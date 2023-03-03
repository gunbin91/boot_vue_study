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

import MyPage from '@/views/MypageView.vue';

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
    path: '/mypage',
    component: MyPage,
    name: 'mypage',
    beforeEnter: (to, from) =>{
      // console.log('to: ', to);
      // console.log('from: ', from);
      // return false;
      // return {name: 'Home'};
      // if(Object.keys(to.query).length > 0){
      //   return { path: to.path, query: {} };
      // }
    }
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

router.beforeEach((to, from)=>{
  console.log('to: ', to);
  console.log('from: ', from);
  if(to.name === 'mypage'){
    // return false; // 접근불가
    // router.push({name: 'Home'});  // 리다이렉트
    // return {name: 'Home'}
  }
})
// 세번째 인자로 next를 받아 next({name: 'Home'}); 으로도 처리가 가능하나, 권장사항X


export default router;