<template>
    <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous" @click.prevent="$emit('page',currentPage-1)"
                    :style="currentPage <= pageCount ? 'disabled' : ''">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item" v-for="page in pageCount">
                <a class="page-link" href="#" @click.prevent="$emit('page',page);"
                    :class="currentPage == page ? 'active' : ''">{{ page }}</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next" @click.prevent="$emit('page',currentPage+1)"
                    :style="currentPage >= pageCount ? 'disabled' : ''">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
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