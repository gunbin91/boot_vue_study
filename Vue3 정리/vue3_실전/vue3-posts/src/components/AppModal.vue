<template>
  <div v-if="show" class="modal-backdrop fade show"></div>
  <Transition>
    <div class="modal fade" :class="show ? 'show d-block' : ''" id="exampleModal" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true" @click="$emit('closeModal')">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">{{ title }}</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
              @click="$emit('closeModal')"></button>
          </div>
          <div class="modal-body">
            <slot name="body">...</slot>
          </div>
          <div class="modal-footer">
            <slot name="footer"></slot>
          </div>
        </div>
      </div>
    </div>
  </Transition>
</template>

<script setup>
defineProps({
  show: Boolean,
  title: String
})
</script>

<style scoped>
.v-enter-from,
.v-leave-to {
  opacity: 0;
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}

.v-enter-to,
.v-leave-from {
  opacity: 1;
}
</style>