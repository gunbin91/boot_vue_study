import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

import { createApp } from 'vue';
import App from './App.vue';
import router from '@/router'

const app = createApp(App)
app.use(router);
app.mount('#app');

import 'bootstrap/dist/js/bootstrap.js';


// 개발모드,어떤모드? / 베이스유알엘 / 프로덕션true/false / 개발모드 true/false
// console.log('MODE: ',     import.meta.env.MODE);
// console.log('BASE_URL: ', import.meta.env.BASE_URL);
// console.log('PROD: ',     import.meta.env.PROD);
// console.log('DEV: ',      import.meta.env.DEV);

// console.log('환경변수: ', import.meta.env.VITE_APP_API_URL)