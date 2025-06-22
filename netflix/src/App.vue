<template>
    <div class="app">
        <AppHeader />
        <Tabs />
    </div>
</template>

<script lang="ts" setup>
import AppHeader from './components/AppHeader.vue';
import Tabs from './components/Tabs.vue';
</script>

<style scoped lang="scss">
.app {
	background: #000;
	color: #999;
}
</style>