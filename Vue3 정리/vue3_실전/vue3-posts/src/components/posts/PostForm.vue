<template>
  <form>
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" class="form-control" id="title" placeholder="name@example.com" :value="title" @input="$emit('update:title', $event.target.value)">
    </div>
    <div class="mb-3">
      <label for="contents" class="form-label">내용</label>
      <textarea class="form-control" id="contents" rows="3" :value="contents" @input="$emit('update:contents', $event.target.value)"></textarea>
    </div>
    <div class="pt-4">
      <!-- <button class="btn btn-outline-danger me-2" @click="goDetailPage">취소</button>
      <button class="btn btn-primary">수정</button> -->
      <slot name="actions"></slot>
    </div>
  </form>
</template>

<script setup>
const props = defineProps({
  title: String,
  contents: String,
})

defineEmits(['update:title', 'update:contents'])
</script>
