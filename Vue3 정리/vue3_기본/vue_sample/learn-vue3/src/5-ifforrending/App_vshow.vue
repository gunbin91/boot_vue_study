<template>
  <div v-show="isShow">테스트</div>
  <button v-on:click="isShow = !isShow">버튼</button>
</template>

<script>
import { ref } from "vue";
export default {
  setup() {
    const isShow = ref(true);
    return { isShow };
  },
};
</script>

<style lang="scss" scoped></style>
