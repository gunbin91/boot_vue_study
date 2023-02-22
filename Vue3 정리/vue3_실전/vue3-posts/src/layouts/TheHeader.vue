<template>
  <header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">SampleProejct</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <RouterLink class="nav-link active" aria-current="page" to="/">Home</RouterLink>
            <RouterLink class="nav-link" to="/about">about</RouterLink>
            <RouterLink class="nav-link" to="/posts">PostList</RouterLink>
          </div>
          <div class="d-flex">
            <button class="btn btn-outline-light"  type="button" 
            @click="goPage">글쓰기</button>
          </div>
        </div>
      </div>
    </nav>
  </header>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();
const goPage = ()=>{
  router.push('/posts/create');
}
</script>
