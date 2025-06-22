<template>
    <div class="app">
        <AppHeader />
        <Tabs />
        <TabContent />
    </div>
</template>

<script lang="ts" setup>
import AppHeader from './components/AppHeader.vue';
import Tabs from './components/Tabs.vue';
import TabContent from './components/TabContent.vue';
</script>

<style scoped lang="scss">
.app {
	background: #000;
	color: #999;
}
</style>