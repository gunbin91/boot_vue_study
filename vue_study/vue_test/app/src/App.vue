<template>
  <div class="container">
    <ol class="list-group list-group-numbered">
      <li v-for="board in data.boardList" v-bind:key="board.boardSeq" class="list-group-item d-flex justify-content-between align-items-start">
        <div class="ms-2 me-auto">
          <div class="fw-bold">{{board.title}}</div>
          {{board.contents }}
        </div>
        <span class="badge bg-primary rounded-pill">{{board.boardSeq}}</span>
      </li>
      <li v-if="data.boardList.length == 0" class="list-group-item d-flex justify-content-between align-items-start">
        <div class="ms-2 me-auto">
          <div class="fw-bold">No게시물</div>
          게시무리 없스무니다.
        </div>
        <span class="badge bg-primary rounded-pill">14</span>
      </li>
    </ol>
  </div>
  
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
</template>

<script>
import { reactive } from '@vue/reactivity'
import { onMounted } from 'vue';
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  setup(){
    // 리스트에서 사용될 data
    const data = reactive({
      boardList: []
    });
    
    // ajax요청?
    const getList = () => {
      fetch(`http://localhost:8080/board`)
      .then(response => response.json())
      .then(reponse => {
        data.boardList = reponse.data;
      });
    };

    onMounted(() =>{
      getList();
    });

    return{
      data: data,
      getList: getList
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
@import 'https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'
</style>
