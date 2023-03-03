<template>
    <div>
        <h2>게시글 등록</h2>
        <hr class="my-4" />
        <PostFrom @submit.prevent="save()" v-model:title="form.title" v-model:contents="form.contents">
            <template #actions>
                <button class="btn btn-outline-dark me-2" @click.prevent="$router.push('/posts')">목록</button>

                <button class="btn btn-primary" type="button" disabled v-if="loading">
                    <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                    <span class="visually-hidden">Loading...</span>
                </button>
                <button class="btn btn-primary" @click.prevent="save()" v-else>등록</button>
            </template>
        </PostFrom>
    </div>

    <AlertBar :alertParams="alertParams"></AlertBar>
</template>

<script setup>
import { ref } from 'vue';
import { createPost } from '@/api/posts'
import PostFrom from '@/components/posts/PostForm.vue'
import AlertBar from '@/components/AlertBar.vue'
import { useAlert } from '@/composables/alert'

const form = ref({
    title: null,
    contents: null,
})

const loading = ref(false);

const { alertParams, vAlert } = useAlert();

const save = async () => {
    try {
        loading.value = true;
        var today = new Date();

        var year = today.getFullYear();
        var month = ('0' + (today.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        var dateString = year + '-' + month + '-' + day;

        await createPost({
            ...form.value,
            createdAt: dateString,
        });

        vAlert('등록이 완료되었습니다.', true);
        // router.push({name: 'posts'})
    } catch (error) {
        vAlert(error);
    } finally {
        loading.value = false;
    }
}
</script>