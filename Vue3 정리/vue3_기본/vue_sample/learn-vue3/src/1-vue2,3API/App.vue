<template>
  <div>
    Vue3 Start
    <button v-on:click="increment()">{{ counter }}</button>
  </div>
</template>

<script>
import { onMounted, ref } from "vue";

export default {
  setup() {
    const counter = ref(0);

    const increment = () => counter.value++;

    onMounted(() => {
      console.log("마운트 되었습니다.");
    });

    return {
      counter,
      increment,
    };
  },
};
</script>

<style lang="scss" scoped></style>
