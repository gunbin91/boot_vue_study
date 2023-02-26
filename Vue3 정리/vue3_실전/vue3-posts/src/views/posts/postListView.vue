<template>
    <div>
        <h2>게시글 목록</h2>
        <hr class="my-4"/>
        <form @click.prevent="">
            <div class="row g-3">
                <div clss="col">
                    <input type="text" class="form-control" v-model="params.contents_like"/>
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
                <PostItem :title="post.title" :contents="post.contents" 
                :createdAt="post.createdAt" @click="goPage(post.id)"></PostItem>
            </div>
        </div>

        <!-- <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous" @click.prevent="params.currentPage--" :style="currentPage <= pageCount? 'disabled': ''">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item" v-for="page in pageCount">
                    <a class="page-link" href="#" @click.prevent="params.currentPage = page;" :class="params.currentPage == page? 'active': ''">{{ page }}</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next" @click.prevent="params.currentPage++" :style="params.currentPage >= pageCount? 'disabled': ''">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav> -->
        <AppPagenation 
        :pageCount="pageCount"
        :currentPage="params.currentPage"
        @page="changePage"
        ></AppPagenation>
        <hr class="my-5"/>

        <h3><br/>미리보기>></h3>
        <postDetailView :id="viewId"></postDetailView>
    </div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue'
import postDetailView from './postDetailView.vue';
import AppPagenation from '@/components/AppPagenation.vue'

// import { getPosts } from '@/api/posts'
import { getTests } from '@/api/tests'
import { ref, computed, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import axios from "axios";

const posts = ref([]);
const router = useRouter();
const viewId = ref(1);
const postCount = ref(0);
const pageCount = computed(()=>{
    return Math.ceil(postCount.value / params.value.limits);
});

const params = ref({
    currentPage: 1,
    limits: 4,
    title_like: '',
    contents_like: '',
});

const changePage = (page)=>{
    params.value.currentPage = page;
}

const fetchPosts = async() =>{
    const response = await axios.get(`http://localhost:5000/posts?
    _sort=createdAt
    &_order=asc
    &_page=${params.value.currentPage}
    &_limit=${params.value.limits}
    &contents_like=${params.value.contents_like}`);
    
    posts.value = response.data;
    postCount.value = response.headers['x-total-count'];
}
const goPage = (id)=>{
    router.push(`/posts/${id}`);
}

const changeView = (id)=>{
    viewId.value = id;
}

watchEffect(()=>{
    fetchPosts();
})
</script>