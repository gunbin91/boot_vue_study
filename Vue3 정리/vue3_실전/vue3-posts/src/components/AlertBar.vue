<template>
    <div class="alert_div">
        <TransitionGroup name="slide">
            <div v-for="item in alertParams" :key="item.index" class="alert my-4" :class="item.type" role="alert">
                {{ item.message }}
            </div>
        </TransitionGroup>
    </div>
</template>

<script setup>
import { computed } from 'vue'

import { useAlertStore } from '@/store/alert';
import { storeToRefs } from 'pinia';

const alertStore = useAlertStore();
const { alerts:alertParams } = storeToRefs(alertStore);

</script>

<style>
.alert_div {
    position: fixed;
    top: 35px;
    right: 10px;
}

.slide-enter-from,
.slide-leave-to {
    opacity: 0;
    transform: translateY(-30px);
}

.slide-enter-active,
.slide-leave-active {
    transition: all 0.5s ease;
}

.slide-enter-to,
.slide-leave-from {
    opacity: 1;
    transform: translateY(0px);
}
</style>
