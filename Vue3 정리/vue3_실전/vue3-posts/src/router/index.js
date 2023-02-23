import { createRouter, createWebHistory } from "vue-router";
import HomeView from '@/views/HomeView.vue';
import AboutView from '@/views/AboutView.vue';
import NotFoundView from '@/views/NotFoundView.vue'

import PostCreateView from '@/views/posts/PostCreateView.vue';
import PostDetailView from '@/views/posts/PostDetailView.vue';
import PostListView from '@/views/posts/PostListView.vue';
import PostEditView from '@/views/posts/PostEditView.vue';

import NestedView from '@/views/nested/NestedView.vue';
import NestedOne from '@/views/nested/NestedOne.vue';
import NestedTwo from '@/views/nested/NestedTwo.vue';

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
    props: true,
  },
  {
    path: '/posts/:id/edit',
    component: PostEditView,
    name: 'edit',
  },
  {
    path: '/:pathMatch(.*)*',
    component: NotFoundView,
    name: 'notfound',
  },
  {
    path: '/nested',
    component: NestedView,
    name: 'nested',
    children: [
      {
        path: '',
        component: NestedOne,
        name: 'nestedHome',
      },
      {
        path: 'one',
        component: NestedOne,
        name: 'nestedOne',
      },
      {
        path: 'two',
        component: NestedTwo,
        name: 'nestedTwo',
      },
    ]
  },
];

const router = createRouter({
  history: createWebHistory('/'),
  routes,
  mode: 'history'
});

export default router;