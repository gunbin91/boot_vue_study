<template>
  <div>
    <!-- <input
      @input="$emit('update:modelValue', $event.target.value)"
      :value="modelValue"
      type="text"
    />
    <br />
    {{ modelValue }}
    <hr /> -->

    <input type="text" v-model="inputValue" />
    {{ inputValue }}
  </div>
</template>

<script>
import { computed } from "vue";
export default {
  setup(props, context) {
    const inputValue = computed({
      get() {
        return props.title;
      },
      set(value) {
        context.emit("update:title", value);
      },
    });
    return { inputValue };
  },
  props: {
    modelValue: {
      type: String,
      default: "ss",
    },
    title: {
      type: String,
    },
  },
  emits: ["update:modelValue"],
};
</script>
