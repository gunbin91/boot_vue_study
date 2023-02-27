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

const props = defineProps({
    alertParams: Array,
    message: String,
    type: String
})
</script>

<style>
.alert_div {
    position: fixed;
    top: 35px;
    right: 10px;
}

/* .v-enter-from, .v-leave-to{
    opacity: 0;
}

.v-enter-active, .v-leave-active{
    transition: opacity 0.5s ease;
}

.v-enter-to, .v-leave-from{
    opacity: 1;
} */

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
