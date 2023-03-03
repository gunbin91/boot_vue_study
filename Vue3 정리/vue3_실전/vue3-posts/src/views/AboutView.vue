<template>
  <div>
    <h2>AboutView_StoreTest</h2>
    <div>
      <p>store.counter : {{ store.counter }}</p>
      <p>store.doubleCount: {{ store.doubleCount }}</p>
      <p><button @click="store.increment()">increment</button></p>
    </div>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { useCounterStore } from '@/store/counter';

const route = useRoute();
console.log('route path: ', route.path);

const store = useCounterStore();
</script>