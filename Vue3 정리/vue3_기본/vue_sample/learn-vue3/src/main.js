import { createApp } from "vue";
import App from "./App.vue";
import "bootstrap/dist/css/bootstrap.min.css";
import AppCard from "@/components/TheCard.vue";

const app = createApp(App);
// app.provide('test', '테스트입니다.');
app.component("AppCard", AppCard);
app.mount("#app");

import "bootstrap/dist/js/bootstrap.js";
