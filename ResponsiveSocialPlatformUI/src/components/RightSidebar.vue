<template>
    <div 
        class="right-side"
        :class="{ active: isRightSidebarOpen }"
        >
        <Account />
        <StoriesSideWrapper />
        <ContatctsSideWrapper />
        <RightSearchBar />
    </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';
import Account from './Account.vue';
import StoriesSideWrapper from './StoriesSideWrapper.vue';
import ContatctsSideWrapper from './ContatctsSideWrapper.vue';
import RightSearchBar from './RightSearchBar.vue';

const appStore = useAppStore();
const { isRightSidebarOpen } = storeToRefs(appStore);
</script>

<style scoped lang="scss">
.right-side {
    overflow: auto;
    display: flex;
    flex-direction: column;
    width: 280px;
    margin-left: auto;
    background-color: #151728;

    @media screen and (max-width: 1210px) {
        position: fixed;
        top: 0;
        right: 0;
        transform: translateX(280px);
        transition: .3s;
        z-index: 4;

        &.active {
            transform: translatex(0);
        }
    }

}
</style>