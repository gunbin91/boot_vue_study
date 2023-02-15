<template>
    <div>
        <!-- <button v-on:click="state.count++"> count : {{ state.count }}</button> -->
        <button v-on:click="count++"> count : {{ count }}</button>

        <button v-on:click="time+='!'"> time : {{ time }}</button>

        <button v-on:click="test++"> time : {{ test }}</button>
    </div>
</template>

<script>
import {ref, reactive, toRef, toRefs, readonly} from 'vue'

export default {
    setup () {
        const state = reactive({
            count: 0,
            title: '좋다',
            time: '111',
        });

        const {count, title} = toRefs(state);
        let time = readonly(state.time);
        time = '2222';

        return {state, count, time, title, test}
    }
}
</script>