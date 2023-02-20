<template>
  <PropsTest title="제목ㅋㅋ" :contents="con"/>
</template>

<script>
import { ref } from "vue";
import PropsTest from "./components/PropsTest.vue"

export default {
  setup() {
    const con = ref('내용1');
    return {con};
  },
  components: {
    PropsTest
  },
};
</script>

<style lang="scss" scoped></style>
