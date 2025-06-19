<template>
    <div 
        class="logo"
        :class="{ 'active': isLeftSidebarOpen }"
    >
        ULTRANET
    </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const { isLeftSidebarOpen } = storeToRefs(appStore);
</script>

<style scoped lang="scss">
.logo {
    position: sticky;
    top: 0;
    height: 68px;
    color: #fff;
    font-family: "DM Sans", sans-serif;
    font-size: 15px;
    font-weight: 600;
    text-align: center;
    line-height: 68px;
    letter-spacing: 4px;
    background: linear-gradient(to bottom, rgb(21, 23, 40) 0%, rgb(21, 23, 40) 76%, rgba(21, 23, 40, 0) 100%);
}

@media screen and (max-width: 930px) {
    .logo:not(.active) {
        display: flex;
        align-items: center;
        margin-top: -10px;
        writing-mode: vertical-lr;
        transform: rotate(180deg);
        transform-origin: bottom;
    }
}
</style>