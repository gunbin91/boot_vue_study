<template>
	<main>
		<div class="container py-4">
			<RouterView></RouterView>
			{{ $route.name }}
		</div>
	</main>
</template>

<script setup></script>
