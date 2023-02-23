<template>
    <div>
        <h2>게시글 목록</h2>
        <hr class="my-4"/>
        <div class="row g-3">
            <div class="col-3" v-for="post in posts" :key="post.id" @mouseover="changeView(post.id)">
                <PostItem :title="post.title" :contents="post.contents" 
                :createdAt="post.createdAt" @click="goPage(post.id)"></PostItem>
            </div>
        </div>
        <h3><br/>미리보기>></h3>
        <postDetailView :id="viewId"></postDetailView>
    </div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue'
import postDetailView from './postDetailView.vue';

import { getPosts } from '@/api/posts'
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from "axios";

const posts = ref([]);
const router = useRouter();
const viewId = ref(1);

const fetchPosts = () =>{
    axios.get('http://localhost:5000/posts')
    .then(response=> {
        posts.value = response.data;
        console.log(response)
    }).catch(error => {
        console.log('error: ', error);
    });
}
fetchPosts();

const goPage = (id)=>{
    router.push(`/posts/${id}`);
}

const changeView = (id)=>{
    viewId.value = id;
}
</script>