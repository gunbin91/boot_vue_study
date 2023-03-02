<template>
    <div>
        <h2>게시글 목록</h2>
        <hr class="my-4" />
        <form @click.prevent="">
            <div class="row g-3">
                <div clss="col">
                    <input type="text" class="form-control" v-model="params.contents_like" />
                </div>
                <div class="col-3">
                    <select class="form-select" v-model="params._limit">
                        <option value="4" selected>4 개씩보기</option>
                        <option value="8">8 개씩보기</option>
                        <option value="12">12 개씩보기</option>
                    </select>
                </div>
            </div>
        </form>
        
        <AppError :message="err" v-if="error != ''"></AppError>
        <AppLoading v-if="loading"></AppLoading>

        <div class="row g-3 my-4">
            <div class="col-3" v-for="post in posts" :key="post.id" @mouseover="changeView(post.id)">
                <PostItem :title="post.title" :contents="post.contents" :createdAt="post.createdAt"
                    @click="goPage(post.id)" @openModal="openModal(post)">
                </PostItem>
            </div>
        </div>

        
        <AppPagenation :pageCount="pageCount" :currentPage="params._page" @page="changePage"></AppPagenation>
        <hr class="my-5" />
        
        <AppCard>
            <template #header>미리보기</template>
            <postDetailView :id="viewId"></postDetailView>
        </AppCard>

        <AppModal 
        :show="modalParams.show"
        :title="modalParams.title"
        :createdAt="modalParams.createdAt"
        @closeModal="closeModal">
            <template #body>{{ modalParams.contents }}</template>
            <template #footer>{{ modalParams.createdAt }}</template>
        </AppModal>
    </div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue'
import postDetailView from './postDetailView.vue';
import AppPagenation from '@/components/AppPagenation.vue'
import AppModal from '@/components/AppModal.vue'
import AppCard from '@/components/AppCard.vue'
import AppError from '@/components/AppError.vue'
import AppLoading from '@/components/AppLoading.vue'
import { useAxios } from '@/composables/useAxios';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const viewId = ref(1);

const params = ref({
    _sort: 'createdAt',
    _order: 'desc',
    _page: 1,
    _limit: 4,
    contents_like: '',
});

const modalParams = ref({
    show: false,
    title: '',
    contents: '',
    createdAt: '',
})

const openModal = (post)=>{
    modalParams.value.title = post.title;
    modalParams.value.contents = post.contents;
    modalParams.value.createdAt = post.createdAt;
    modalParams.value.show = true;
}

const closeModal = () => {
    modalParams.value.show = false;
}

const changePage = (page) => {
    params.value._page = page;
}

const goPage = (id) => {
    router.push(`/posts/${id}`);
}

const changeView = (id) => {
    viewId.value = id;
}

// axios
const {response, data: posts, error, loading} = useAxios('/posts', {method: 'get', params: params.value });

const postCount = computed(()=> response.value.headers['x-total-count']);
const pageCount = computed(() => {
    return Math.ceil(postCount.value / params.value._limit);
});

</script>