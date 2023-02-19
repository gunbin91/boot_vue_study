<template>
  <div>
    a<input type="checkbox" value="1" v-model="checkValue"/> // b<input type="checkbox" value="2" v-model="checkValue"/>
    <button @click="test">button</button>
    <hr/>
    a<input type="radio" name="ra" value="a" v-model="radioValue"/>
    b<input type="radio" name="ra" value="b" v-model="radioValue"/>
    c<input type="radio" name="ra" value="c" v-model="radioValue"/>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup () {
    const checkValue = ref([2]);
    const radioValue = ref('b');

    const test = ()=>{
      console.log("check  - " + checkValue.value);
      console.log("radio  - " + radioValue.value);
    }

    return {checkValue, radioValue, test}
  }
}
</script>