<template>
  <div>{{ $props }}</div>
</template>

<script setup>
const props = defineProps({
  param: {
    type: String,
    default: "메롱",
  },
  param2: {
    type: String,
  },
});
console.log(props);
</script>

<style lang="scss" scoped></style>
