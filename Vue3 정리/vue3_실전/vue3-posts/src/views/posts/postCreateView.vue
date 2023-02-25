<template>
    <div>
        <h2>게시글 등록</h2>
        <hr class="my-4"/>
        <PostFrom @submit.prevent="save()" 
        v-model:title="form.title" 
        v-model:contents="form.contents">
            <template #actions>
                <button class="btn btn-outline-dark me-2"
                @click.prevent="$router.push('/posts')">목록</button>
                <button class="btn btn-primary"
                @click.prevent="save()">등록</button>
            </template>
        </PostFrom>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import {createPost} from '@/api/posts'
import router from '@/router';
import PostFrom from '@/components/posts/PostForm.vue'

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