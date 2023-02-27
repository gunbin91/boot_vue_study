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
                    <select class="form-select" v-model="params.limits">
                        <option value="4" selected>4 개씩보기</option>
                        <option value="8">8 개씩보기</option>
                        <option value="12">12 개씩보기</option>
                    </select>
                </div>
            </div>
        </form>

        <div class="row g-3 my-4">
            <div class="col-3" v-for="post in posts" :key="post.id" @mouseover="changeView(post.id)">
                <PostItem :title="post.title" :contents="post.contents" :createdAt="post.createdAt"
                    @click="goPage(post.id)"></PostItem>
            </div>
        </div>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Launch demo modal
        </button>

        <AppModal>졸려요,,,</AppModal>

        <AppPagenation :pageCount="pageCount" :currentPage="params.currentPage" @page="changePage"></AppPagenation>
        <hr class="my-5" />

        <AppCard>
            <template #header>미리보기</template>
            <postDetailView :id="viewId"></postDetailView>
        </AppCard>
    </div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue'
import postDetailView from './postDetailView.vue';
import AppPagenation from '@/components/AppPagenation.vue'
import AppModal from '@/components/AppModal.vue'
import AppCard from '@/components/AppCard.vue'

// import { getPosts } from '@/api/posts'
import { getTests } from '@/api/tests'
import { ref, computed, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import axios from "axios";

const posts = ref([]);
const router = useRouter();
const viewId = ref(1);
const postCount = ref(0);
const pageCount = computed(() => {
    return Math.ceil(postCount.value / params.value.limits);
});

const params = ref({
    currentPage: 1,
    limits: 4,
    title_like: '',
    contents_like: '',
});

const changePage = (page) => {
    params.value.currentPage = page;
}

const fetchPosts = async () => {
    const response = await axios.get(`http://localhost:5000/posts?
    _sort=createdAt
    &_order=desc
    &_page=${params.value.currentPage}
    &_limit=${params.value.limits}
    &contents_like=${params.value.contents_like}`);

    posts.value = response.data;
    postCount.value = response.headers['x-total-count'];
}
const goPage = (id) => {
    router.push(`/posts/${id}`);
}

const changeView = (id) => {
    viewId.value = id;
}

watchEffect(() => {
    fetchPosts();
})
</script>