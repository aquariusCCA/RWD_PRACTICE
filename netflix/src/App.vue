<template>
    <div class="app">
        <AppHeader />
        <Tabs />
        <TabContent />
        <AppFooter />
    </div>
</template>

<script lang="ts" setup>
import AppHeader from './components/AppHeader.vue';
import Tabs from './components/Tabs.vue';
import TabContent from './components/TabContent.vue';
import AppFooter from './components/AppFooter.vue';
</script>

<style scoped lang="scss">
.app {
	background: #000;
	color: #999;
}
</style>