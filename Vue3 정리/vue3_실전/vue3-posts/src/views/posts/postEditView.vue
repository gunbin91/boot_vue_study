<template>
    <div>
        <h2>게시글 수정</h2>
        <hr class="my-4"/>

        <PostFrom @submit.prevent="edit()" 
        v-model:title="form.title" 
        v-model:contents="form.contents">
            <template #actions>
                <button class="btn btn-outline-danger me-2"
                @click="goDetailPage">취소</button>
                <button class="btn btn-primary">수정</button>
            </template>
        </PostFrom>

        <AlertBar :flag-alert="alertParams.flagAlert" 
        :message="alertParams.message"
        :type="alertParams.type"></AlertBar>
    </div>
</template>

<script setup>
import { getPostById, updatePost } from '@/api/posts';
import router from '@/router';
import { ref } from 'vue';
import { useRoute } from 'vue-router';
import PostFrom from '@/components/posts/PostForm.vue'
import AlertBar from '@/components/AlertBar.vue'

const route = useRoute();
const alertParams = ref({
    flagAlert: false,
    message: '',
    type: 'success'
})

const goDetailPage = ()=>{
    router.push({name: 'detail', params: {'id': route.params.id}})
}

const form = ref({});

const formData = async ()=>{
    const response = await getPostById(route.params.id);
    form.value = response.data;
}
formData();

const edit = async () => {
    try {
        await updatePost(route.params.id, form.value);
        // router.push({name: 'detail', params: {id : route.params.id}})
        vAlert('수정이 완료되었습니다.', true);
    } catch (error) {
        vAlert(error, false);
    }
}

const vAlert = (message, error) => {
    alertParams.value.flagAlert = true;
    alertParams.value.message = message;
    if(error == true) alertParams.value.type = 'success'
    else alertParams.value.type = 'error'
    setTimeout(()=>{
        alertParams.value.flagAlert = false;
    }, 2000)
}

</script>