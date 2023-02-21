<template>
    <div>
        <h2>RefTemplate</h2>
        <input ref="refInput" value="메롱"/>
        <br/>
        <div v-if="refInput">{{ refInput.value }}</div>
    </div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
    setup () {
        const refInput = ref(null);
        console.log(refInput.value);

        onMounted(()=>{
            // refInput.value.value = '마운트!!';
            console.log('엘리먼트: ', refInput.value);
            console.log('엘리먼트 벨류값: ', refInput.value.value);
        });

        return { refInput }
    },
}
</script>