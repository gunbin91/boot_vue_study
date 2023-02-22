<script>
export default {
  data() {
    return {
      counter: 0,
    };
  },
  methods: {
    increment() {
      this.counter++;
    },
  },
  mounted() {
    console.log("컴포넌트가 마운트 되었습니다.");
  },
};
</script>

<template>
  Vue3 Start
  <button v-on:click="increment()">{{ counter }}</button>
</template>

<style scoped></style>
