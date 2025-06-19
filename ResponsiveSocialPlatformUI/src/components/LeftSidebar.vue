<template>
  <div 
    class="left-side"
    :class="{ active: isLeftSidebarOpen }"
  >

    <LeftSideButton />

    <Logo />

    <MenuSideWrapper />

    <FavouriteSideWrapper />

    <FollowMe 
      class="follow-mex"
    />
  </div>
</template>

<script lang="ts" setup>
import LeftSideButton from './LeftSideButton.vue';
import Logo from './Logo.vue';
import MenuSideWrapper from './MenuSideWrapper.vue';
import FavouriteSideWrapper from './FavouriteSideWrapper.vue';
import FollowMe from './FollowMe.vue';
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const { isLeftSidebarOpen } = storeToRefs(appStore);
</script>

<style scoped lang="scss">
.left-side {
  overflow: auto;
  display: flex;
  flex-direction: column;
  width: 260px;
  border-right: 1px solid #272a3a;
  background-color: #151728;
  transition: width 0.3s;

  &.active {
    width: 260px;
    z-index: 4;
  }

  &:not(.active) {
    width: 56px;
    overflow: hidden;
  }
}

.follow-mex {
  flex-shrink: 0;
  margin-top: auto;
}
</style>