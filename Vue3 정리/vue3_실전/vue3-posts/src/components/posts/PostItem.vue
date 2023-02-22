<template>
    <div class="card">
        <div class="card-header">
            {{ title }}
        </div>
        <div class="card-body">
            <h5 class="card-title">{{ contents }}</h5>
            <p class="card-text">{{ createdAt }}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </div>
</template>

<script setup>
defineProps({
    title:{
        type: String,
        required: true,
    },
    contents:{
        type: String,
    },
    createdAt:{
        type: [String, Date, Number],
        required: true,
    },
})
</script>

<style lang="scss" scoped></style>