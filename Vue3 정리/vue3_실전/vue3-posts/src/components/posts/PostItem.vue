<template>
    <div class="card">
        <div class="card-header">
            {{ title }}
        </div>
        <div class="card-body">
            <h5 class="card-title">{{ contents }}</h5>
            <p class="card-text">{{ createdAt }}</p>
        </div>
        <div class="card-footer d-flex flex-row-reverse">
            <button class="btn p-0" @click.prevent.stop="$emit('openModal')">
                <i class="bi bi-emoji-heart-eyes-fill"></i>
            </button>
        </div>
    </div>
</template>

<script setup>
defineProps({
    title: {
        type: String,
        required: true,
    },
    contents: {
        type: String,
    },
    createdAt: {
        type: [String, Date, Number],
        required: true,
    },
})
</script>

<style lang="scss" scoped></style>