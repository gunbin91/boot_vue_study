<template>
  <div v-memo = [b]>
    {{ a }}<br/>
    {{ b }}
  </div>
  <button @click="a++">a++</button>
  <button @click="b++">b++</button>
</template>

<script>
import { ref } from 'vue';

export default {
  setup () {
    const a = ref(10);
    const b = ref(20);

    return {a, b}
  }
}
</script>

<style lang="scss" scoped>

</style>