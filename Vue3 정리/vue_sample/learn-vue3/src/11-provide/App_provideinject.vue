<template>
  <div class="card">
        <div class="card-header">AppVue</div>
        <div class="card-body">
          message: {{ message }}<br/>
          data: {{ data }}
            <ChildTest/>
        </div>
    </div>
</template>

<script>
import ChildTest from '@/components/ChildTest.vue'
import { provide, ref } from 'vue';

// ChildTest.provide('test', '테스트');

export default {
  setup () {
    const message = ref('메시지');
    const updateMessage = (value)=>{
      message.value = value;
    }
    const data = ref('데이터');
    provide('message', {message, updateMessage});
    provide('data', data);

    return {message, data}
  },
  components: {
    ChildTest
  }
}
</script>

<style lang="scss" scoped>

</style>