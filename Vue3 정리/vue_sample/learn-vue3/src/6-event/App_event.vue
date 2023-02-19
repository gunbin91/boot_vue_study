<template>
  <div>
    <button @click="test('hello', $event)" value="qkqh"> on click </button>
  </div>
</template>

<script>
export default {
  setup () {
    const test = (msg, event) => {
      console.log(msg);
      console.log(event.target);
      console.log(event.target.value);
    }

    return {test}
  }
}
</script>

<style lang="scss" scoped>

</style>