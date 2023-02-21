<template>
    <div class="card">
        <div class="card-header">Deep_Child_Header</div>
        <div class="card-body">
            message : {{ message }}<br/>
            data : {{ data }}<br/>
            test: {{ test }}
        </div>
    </div>
</template>

<script>
import { inject, ref } from 'vue';

export default {
    setup () {
        const {message} = inject('message');
        const {updateMessage} = inject('message');
        const data = ref(inject('data', '디폴트데이타'));
        const test = inject('test');

        data.value = '자식데이터변경';
        updateMessage('메시지변경');

        return {message, data, test}
    }
}
</script>

<style lang="scss" scoped>

</style>