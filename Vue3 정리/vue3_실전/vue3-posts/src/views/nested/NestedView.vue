<template>
  <div>
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <RouterLink class="nav-link" :class="$route.path == '/nested/one'? 'active':''" to="/nested/one">Nested_One</RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" :class="$route.path == '/nested/two'? 'active':''" to="/nested/two">Nested_Two</RouterLink>
      </li>
    </ul>
  </div>
  {{ $route.path }}
  <RouterView></RouterView>
</template>

<script setup>

</script>