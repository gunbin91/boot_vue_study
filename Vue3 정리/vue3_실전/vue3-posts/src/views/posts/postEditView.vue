<template>
    <div>
        <h2>게시글 수정</h2>
        <hr class="my-4"/>
        <!-- <form @submit.prevent="edit">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" placeholder="name@example.com" v-model="form.title">
            </div>
            <div class="mb-3">
                <label for="contents" class="form-label">내용</label>
                <textarea class="form-control" id="contents" rows="3" v-model="form.contents"></textarea>
            </div>
            <div class="pt-4">
                <button class="btn btn-outline-danger me-2"
                @click="goDetailPage">취소</button>
                <button class="btn btn-primary">수정</button>
            </div>
        </form> -->
    </div>
</template>

<script setup>
import { getPostById, updatePost } from '@/api/posts';
import router from '@/router';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();

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
        router.push({name: 'detail', params: {id : route.params.id}})
    } catch (error) {
        console.log(error);
    }
}

</script>