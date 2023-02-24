<template>
    <div>
        <h2>게시글 등록</h2>
        <hr class="my-4"/>
        <form>
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" placeholder="name@example.com" v-model="form.title">
            </div>
            <div class="mb-3">
                <label for="contents" class="form-label">내용</label>
                <textarea class="form-control" id="contents" placeholder="contents" rows="3" v-model="form.contents"></textarea>
            </div>
            <div class="pt-4">
                <button class="btn btn-outline-dark me-2"
                @click.prevent="$router.push('/posts')">목록</button>
                <button class="btn btn-primary"
                @click.prevent="save()">등록</button>
            </div>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import {createPost} from '@/api/posts'
import router from '@/router';

const form = ref({
    title: null,
    contents: null,
})

const save = async ()=>{
    try{
        var today = new Date();

        var year = today.getFullYear();
        var month = ('0' + (today.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        var dateString = year + '-' + month + '-' + day;

        await createPost({
            ...form.value,
            createdAt: dateString,
        });
        router.push({name: 'posts'})
    }catch (error){
        console.log(error);
    }
}
</script>