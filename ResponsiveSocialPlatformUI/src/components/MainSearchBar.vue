<template>
  <div class="main-search-bar">
    <input 
      class="search-input"
      type="text" 
      placeholder="Search" 
    />
    <button 
      class="toggle-sidebar-button"
      @click="toggleRightSidebar"
    >
      <svg 
        viewBox="0 0 24 24" 
        stroke="currentColor" 
        stroke-width="2" 
        fill="none"
        stroke-linecap="round" 
        stroke-linejoin="round"
      >
        <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z" />
      </svg>
    </button>
  </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';

const appStore = useAppStore();
const { toggleRightSidebar } = appStore;
</script>

<style scoped lang="scss">
.main-search-bar {
    display: flex;
    align-items: center;
    position: relative;
    height: 60px;
    background-color: #151728;
    z-index: 3;

    .search-input {
        flex: 1;
        height: 100%;
        padding: 0 54px;
        border: none;
        background-color: transparent;
        background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' width='512' height='512'%3e%3cpath d='M508.9 478.7L360 330a201.6 201.6 0 0045.2-127.3C405.3 90.9 314.4 0 202.7 0S0 91 0 202.7s91 202.6 202.7 202.6c48.2 0 92.4-17 127.3-45.2L478.7 509c4.2 4.1 11 4.1 15 0l15.2-15.1c4.1-4.2 4.1-11 0-15zm-306.2-116c-88.3 0-160-71.8-160-160s71.7-160 160-160 160 71.7 160 160-71.8 160-160 160z' data-original='%23000000' class='active-path' data-old_color='%23000000' fill='%235C5D71'/%3e%3c/svg%3e");
        background-repeat: no-repeat;
        background-size: 16px;
        background-position: 25px 50%;
        color: #fff;
        font-family: "Source Sans Pro", sans-serif;
        font-weight: 600;

        &::placeholder {
            color: #5c5d71;
        }
    }
}

.toggle-sidebar-button {
    position: relative;
    display: none;
    width: 52px;
    height: 100%;
    border: none;
    border-left: 1px solid #272a3a;
    background-color: #1e2031;
    color: #fff;
    cursor: pointer;
    justify-content: center;
    align-items: center;
    display: flex;

    svg {
        width: 22px;
    }

    @media screen and (max-width: 1210px){
        display: block;
    }

    &::before {
        content: "";
        position: absolute;
        top: 13px;
        right: 12px;
        width: 10px;
        height: 10px;
        border: 2px solid #1e2031;
        border-radius: 50%;
        background-color: #1b86f8;
    }
}
</style>