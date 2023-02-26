<template>
    <div v-if="flagAlert" class="alert my-4" :class="classType" role="alert">
        {{ message }}
    </div>
</template>

<script setup>
import { computed } from 'vue'

const props = defineProps({
    flagAlert: Boolean,
    message: String,
    type: String
})

const classType = computed(()=>{
    return props.type == 'error'? 'alert-danger': 'alert-success';
});
    
</script>

<style>
.alert_div {
    position: fixed;
    top: 35px;
    right: 10px;
}
</style>
