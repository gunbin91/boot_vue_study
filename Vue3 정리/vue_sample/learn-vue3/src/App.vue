<template>
  <EmitTest v-on:create-post="emitCreatePost"></EmitTest>
  <div v-for="post in posts" :key="post.index">
    <TheCard :title="post.title" :contents="post.contents" />
  </div>
  <hr />
  <!-- <model-input
    :model-value="username"
    @mvt="
      (value) => {
        username = value;
      }
    "
  /> -->
  <!-- <model-input v-model="username" /> -->

  <model-input v-model:title="username2" />
</template>

<script>
import EmitTest from "./components/EmitTest.vue";
import TheCard from "@/components/TheCard.vue";
import ModelInput from "@/components/ModelInput.vue";
import { reactive, ref } from "vue";

export default {
  components: {
    EmitTest,
    TheCard,
    ModelInput,
  },
  setup() {
    const posts = reactive([]);

    const username = ref("a");

    const username2 = ref("zz");

    const emitCreatePost = (newPost) => {
      console.log("post", newPost);
      posts.push(newPost);
    };

    const changeUsername = (value) => {
      username.value = value;
      console.log(value);
      console.log(username.value);
    };

    return { emitCreatePost, posts, username, changeUsername, username2 };
  },
};
</script>
