<template>
  <div>
    Vue3 Start
    <h3>반응형 메시지:</h3>
    <p>{{ reMessage }} <button v-on:click="remChange">반응버튼</button></p>
    <h3>일반 메시지:</h3>
    <p>{{ noMessage }} <button v-on:click="nomChange">일반버튼</button></p>
  </div>
</template>

<script>
import { ref } from "vue";

export default {
  setup() {
    const reMessage = ref("Hello World");
    const remChange = () => {
      reMessage.value = reMessage.value + "!";
    };

    let noMessage = "Hello World";
    let nomChange = () => {
      noMessage = noMessage + "!";
    };

    return {
      reMessage,
      noMessage,
      remChange,
      nomChange,
    };
  },
};
</script>

<style lang="scss" scoped></style>
