<template>
    <div class="container">
        <LeftSidebar class="left-side" />
        <MainContent class="main" />
        <RightSidebar class="right-side" />
        <Overlay :is-active="true"/>
    </div>
</template>

<script lang="ts" setup>
import LeftSidebar from './LeftSidebar.vue';
import MainContent from './MainContent.vue';
import RightSidebar from './RightSidebar.vue';
import Overlay from './Overlay.vue';
</script>

<style scoped lang="scss">
.container {
    display: flex;
    overflow: hidden;
    max-width: 1600px;
    height: 100vh;
    margin: 0 auto;
    background-color: #151728;

    .left-side {
        flex-shrink: 0;
    }

    .main {
        flex-grow: 1;
    }

    .right-side {
        flex-shrink: 0;
    }
}
</style>
