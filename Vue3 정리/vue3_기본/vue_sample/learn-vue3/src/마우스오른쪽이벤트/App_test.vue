<template>
  <div @contextmenu.prevent="showMenu" ref="menu">
    <!-- your component content here -->zzzzzzzzzzzzzzzzzzzzzzz
    <div
      v-if="showContextMenu"
      :style="{
        top: position.y + 'px',
        left: position.x + 'px',
        background: 'red',
        width: '50px',
        height: '50px',
        position: 'absolute',
      }"
    >
      메뉴
      <!-- context menu content here -->
    </div>
  </div>
  tt
</template>

<script>
export default {
  data() {
    return {
      showContextMenu: false,
      position: { x: 0, y: 0 },
    };
  },
  methods: {
    showMenu(event) {
      event.preventDefault();
      this.position = { x: event.clientX, y: event.clientY };
      this.showContextMenu = true;
    },
  },
};
</script>
