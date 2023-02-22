<template>
  <div>
    <p :style="styleObj">테스트</p>
    <button v-on:click="fs++">+</button>
    <button v-on:click="fs--">-</button>
  </div>
</template>

<script>
import { ref, computed } from "vue";
export default {
  setup() {
    const fs = ref(15);
    const styleObj = computed(() => {
      return {
        color: "red",
        fontSize: fs.value + "px",
      };
    });

    return { styleObj, fs };
  },
};
</script>

<style lang="scss" scoped></style>
