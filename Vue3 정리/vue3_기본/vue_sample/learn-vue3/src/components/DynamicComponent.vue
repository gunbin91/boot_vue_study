<template>
  <div>
    <button
      class="btn btn-primary me-2"
      @click="changeCurrentComp(DynamicApple)"
    >
      사과
    </button>
    <button
      class="btn btn-danger me-2"
      @click="changeCurrentComp(DynamicBanana)"
    >
      바나나
    </button>
    <hr />
    <component :is="currentComp" />
  </div>
</template>

<script setup>
import DynamicApple from "@/components/DynamicApple.vue";
import DynamicBanana from "@/components/DynamicBanana.vue";
import { shallowRef } from "vue";

const currentComp = shallowRef(DynamicApple);
const changeCurrentComp = (comp) => {
  currentComp.value = comp;
};
</script>
