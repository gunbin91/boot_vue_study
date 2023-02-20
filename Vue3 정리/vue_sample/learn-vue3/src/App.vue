<template>
  <div>
    <TheNavTest></TheNavTest>
    <viewTest></viewTest>
    <AppCard /><app-card />
  </div>
</template>

<script>
import TheNavTest from "./components/TheNav.vue";
import TheView from "./components/TheView.vue";

export default {
  setup() {
    return {};
  },
  components: {
    TheNavTest,
    viewTest: TheView,
  },
};
</script>

<style lang="scss" scoped></style>
