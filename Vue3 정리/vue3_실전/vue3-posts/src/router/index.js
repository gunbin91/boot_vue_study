import { createRouter, createWebHistory } from "vue-router";
import HomeView from '@/views/HomeView.vue';
import AboutView from '@/views/AboutView.vue';

import PostCreateView from '@/views/posts/PostCreateView.vue';
import PostDetailView from '@/views/posts/PostDetailView.vue';
import PostListView from '@/views/posts/PostListView.vue';
import PostEditView from '@/views/posts/PostEditView.vue';

const routes = [
  {
    path: '/',
    component: HomeView,
    name: 'Home',
  },
  {
    path: '/about',
    component: AboutView,
    name: 'About',
  },
  {
    path: '/posts',
    component: PostListView,
    name: 'posts',
  },
  {
    path: '/posts/create',
    component: PostCreateView,
    name: 'create',
  },
  {
    // 동적경로
    // /posts/sam
    // /posts/tom
    path: '/posts/:id',
    component: PostDetailView,
    name: 'detail',
  },
  {
    path: '/posts/:id/edit',
    component: PostEditView,
    name: 'edit',
  },
];

const router = createRouter({
  history: createWebHistory('/'),
  routes,
  mode: 'history'
});

export default router;