<template>
  <div class="card" style="width: 18rem">
    <!-- <img src="..." class="card-img-top" alt="..." /> -->
    <div class="card-body">
      <h5 class="card-title">{{ title }}</h5>
      <p class="card-text">{{ contents }}</p>
      <a href="#" class="btn btn-primary">버튼</a>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: "디폴트제목",
    },
    contents: {
      type: String,
      default: "디폴트내용",
    },
  },
  setup() {
    return {};
  },
};
</script>

<style lang="scss" scoped></style>
