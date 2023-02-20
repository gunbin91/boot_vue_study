<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in viewList" :key="item.index">
      {{ item }}
    </li>
  </ul>
</template>

<script>
import { reactive } from "vue";
export default {
  setup() {
    const viewList = reactive([
      "An item",
      "A second item",
      "A third item",
      "A fourth item",
    ]);
    return { viewList };
  },
};
</script>

<style lang="scss" scoped></style>
