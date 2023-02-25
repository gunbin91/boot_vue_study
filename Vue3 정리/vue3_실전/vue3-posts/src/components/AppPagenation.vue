<template>
    <div>

    </div>
</template>

<script setup>
defineProps({
    currentPage: {
        type: Number,
        required: true
    },
    pageCount: {
        type: Number,
        required: true
    }
})
defineEmits(['page'])
</script>