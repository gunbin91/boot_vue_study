<template>
  <div>
    <div class="text" :class="{ 'text-red': true, bigText: true }">테스트</div>
    <div class="text" :class="['text-red', bigClasstest]">테스트</div>
    <div class="text" :class="[redClasstest, bigClasstest]">테스트</div>
  </div>
</template>

<script>
import { ref } from "vue";

export default {
  setup() {
    const redClasstest = ref("text-red");
    const bigClasstest = ref("bigText");
    return { redClasstest, bigClasstest };
  },
};
</script>

<style scoped>
.text-red {
  color: red;
}

.bigText {
  font-size: 50px;
}
</style>
