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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
