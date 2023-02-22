<template>
  <div v-if="visible">
    테스트
    <ul>
      <li>잉</li>
      <li>이건나와?</li>
    </ul>
  </div>
  <div v-else>엘스</div>
  <button v-on:click="visible = !visible">체인지</button>
</template>

<script>
import { ref } from "vue";
export default {
  setup() {
    const visible = ref(false);

    return { visible };
  },
};
</script>

<style lang="scss" scoped></style>
