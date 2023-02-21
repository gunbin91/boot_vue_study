<template>
  <div>
    <!-- <button v-on:click="$emit('createPost', '홍길동')">Success</button> -->
    제목: <input type="text" v-model="title" /> <br />
    내용: <input type="text" v-model="contents" /><br /><br />
    <a href="#" class="btn btn-primary" @click="createPost">확인</a>
    <hr />
  </div>
</template>

<script>
import { ref } from "vue";

export default {
  emits: {
    createPost: (newPost) => {
      if (!newPost) return false;
      return true;
    },
  },
  setup(props, context) {
    const title = ref("");
    const contents = ref("");

    const createPost = () => {
      context.emit("createPost", {
        title: title.value,
        contents: contents.value,
      });
      title.value = "";
      contents.value = "";
    };
    return { createPost, title, contents };
  },
};
</script>
