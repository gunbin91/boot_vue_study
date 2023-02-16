<template>
  <div>
    <ul>
      <template v-for="(item, index) in items" :key="item.id">
        <li v-if="index % 2 == 0">
          인덱스: {{ index }} , 메시지: {{ item.message }}
        </li>
      </template>
    </ul>
    <hr />
    <ul>
      <li v-for="(value, key, index) in obj" :key="key">
        {{ value }} - {{ key }} - {{ index }}
      </li>
    </ul>
  </div>
</template>

<script>
import { reactive } from "vue";
export default {
  setup() {
    const items = reactive([
      { id: 1, message: "java" },
      { id: 2, message: "html" },
      { id: 3, message: "CSS" },
    ]);

    const obj = reactive({
      title: "제목",
      author: "홍길동",
      publisthedAt: "2023-01-01",
    });
    return { items, obj };
  },
};
</script>
