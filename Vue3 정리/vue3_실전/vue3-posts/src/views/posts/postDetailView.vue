<template>
    <div>
        <h2>{{ form? form.title : ''}} / id : {{ id }}</h2>
        <p>{{ form? form.contents : ''}}</p>
        <p class="text-muted">{{ form? form.createdAt : '' }}</p>
        <hr class="my-4"/>
        <div class="row g-2">
            <div class="col-auto">
                <button class="btn btn-outline-dark">이전글</button>
            </div>
            <div class="col-auto">
                <button class="btn btn-outline-dark">다음글</button>
            </div>
            <div class="col-auto me-auto"></div>
            <div class="col-auto">
                <button class="btn btn-outline-dark" @click="goListPage">목록</button>
            </div>
            <div class="col-auto">
                <button class="btn btn-outline-primary" @click="goEditPage">수정</button>
            </div>
            <div class="col-auto">
                <button class="btn btn-outline-danger">삭제</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { getPostById } from '@/api/posts';
import router from '@/router';
import { reactive, ref, watchEffect } from 'vue';

const props = defineProps(['id']);

const form = ref(getPostById(props.id));

const goListPage = ()=>{
    router.push({name: 'posts'})
};

const goEditPage = ()=>{
    router.push({name: 'edit', params: { 'id': props.id }});
}

watchEffect(()=>{
    form.value = getPostById(props.id);
});


</script>
