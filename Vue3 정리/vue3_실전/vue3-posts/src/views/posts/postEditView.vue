<template>
    <div>
        <h2>게시글 수정</h2>
        <hr class="my-4"/>

        <PostFrom @submit.prevent="edit()" 
        v-model:title="form.title" 
        v-model:contents="form.contents">
            <template #actions>
                <button class="btn btn-outline-danger me-2"
                @click="goDetailPage">취소</button>
                <button class="btn btn-primary">수정</button>
            </template>
        </PostFrom>

        <AlertBar :alertParams="alertParams"></AlertBar>
    </div>
</template>

<script setup>
import { getPostById, updatePost } from '@/api/posts';
import router from '@/router';
import { ref } from 'vue';
import { useRoute } from 'vue-router';
import PostFrom from '@/components/posts/PostForm.vue'
import AlertBar from '@/components/AlertBar.vue'

const route = useRoute();
const alertParams = ref([]);

const goDetailPage = ()=>{
    router.push({name: 'detail', params: {'id': route.params.id}})
}

const form = ref({});

const formData = async ()=>{
    const response = await getPostById(route.params.id);
    form.value = response.data;
}
formData();

const edit = async () => {
    try {
        await updatePost(route.params.id, form.value);
        vAlert('수정이 완료되었습니다.', true);
    } catch (error) {
        vAlert(error, false);
    }
}

const vAlert = (message, error) => {
    alertParams.value.push({
        message: message,
        type: error == true? 'alert-success':'alert-danger'
    })
    setTimeout(()=>{
        alertParams.value.shift();
    }, 2000)
}

</script>