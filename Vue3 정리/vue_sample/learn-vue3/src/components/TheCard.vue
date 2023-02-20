<template>
  <div class="card" style="width: 18rem" v-for="item in cardList" :key="item.index">
    <img src="..." class="card-img-top" alt="..." />
    <div class="card-body">
      <h5 class="card-title">{{item.title}}</h5>
      <p class="card-text">
        {{item.contents}}
      </p>
      <a href="#" class="btn btn-primary">{{ test }}</a>
    </div>
  </div>
  {{ test }}
</template>

<script>
import { reactive } from 'vue';

export default {
  props:{
    test: {
      type: String,
      default: '테스트',
    }
  },
  setup() {
    const cardList = reactive([
      {title: '제목1', contents: '내용1'},
      {title: '제목2', contents: '내용2'},
      {title: '제목3', contents: '내용3'},
      {title: '제목4', contents: '내용4'},
    ])
    return {cardList};
  },
};
</script>

<style lang="scss" scoped></style>
