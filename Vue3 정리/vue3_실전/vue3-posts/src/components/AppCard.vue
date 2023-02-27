<template>
  <div class="card">
    <div class="card-header">
      <slot name="header">디폴트</slot>
    </div>
    <div class="card-body">
      <blockquote class="blockquote mb-0">
        <slot></slot>
      </blockquote>
    </div>
  </div>
</template>

<script setup>

</script>