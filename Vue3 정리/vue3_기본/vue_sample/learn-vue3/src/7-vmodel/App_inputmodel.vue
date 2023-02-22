<template>
  <div>
    bind: <input type="text" :value="bind_text" /><br/>
    model: <input type="text" v-model="model_text"/>
    <button @click="print">button</button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup () {
    const bind_text = ref("바인드");
    const model_text = ref("모델");

    const print = ()=>{
      console.log(`bint_text = ${bind_text.value} // model_text = ${model_text.value}`)
    }
    return {bind_text, model_text, print}
  }
}
</script>

<style lang="scss" scoped>

</style>