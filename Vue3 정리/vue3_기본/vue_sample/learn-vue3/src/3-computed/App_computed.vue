<template>
  <div>
    {{ hasLeacture }}
    {{ hasLeacture2 }}
    {{ hasLeacture3() }}
  </div>
</template>

<script>
import { reactive, computed } from "vue";

export default {
  setup() {
    const teacher = reactive({
      name: "김수환무",
      leactures: ["HTML", "CSS", "Vue3"],
    });

    const hasLeacture = computed(() => {
      return teacher.leactures.length > 0 ? "잇" : "없";
    });

    const hasLeacture2 = teacher.leactures.length > 0 ? "잇" : "없";

    const hasLeacture3 = () => {
      return teacher.leactures.length > 0 ? "잇" : "없";
    };

    return {
      teacher,
      hasLeacture,
      hasLeacture2,
      hasLeacture3,
    };
  },
};
</script>
