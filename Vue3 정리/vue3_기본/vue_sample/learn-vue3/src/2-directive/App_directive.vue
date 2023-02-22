<template>
	<div>
		<p>문자열 : {{ message }}</p>
    <p v-once>문자열 : {{ message }}</p>
    <button v-on:click="message += '!'">메시지변경</button>
    <hr/>
    <p> {{ htmlMessage }}</p>
    <p v-html="htmlMessage"></p>
    <input v-bind:type="type" :value="input_value" :disabled="disabled" />
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	setup() {
		const message = ref('안녕하세요');
    const htmlMessage = ref('<h2>안녕</h2>');
    const type = ref('text');
    const disabled = ref(true);
    const input_value = ref('홍길동');
		return {
			message,
      htmlMessage,
      type,
      disabled,
      input_value,
		};
	},
};
</script>