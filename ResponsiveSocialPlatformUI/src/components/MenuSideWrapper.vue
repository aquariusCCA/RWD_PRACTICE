<template>
    <div 
        class="side-wrapper"
        :class="{ active: isLeftSidebarOpen }"
    >
        <div class="side-title">MENU</div>
        <div class="side-menu">
            <a href="#">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2"
                    stroke-linecap="round" stroke-linejoin="round" viewBox="0 0 24 24">
                    <path d="M3 9l9-7 9 7v11a2 2 0 01-2 2H5a2 2 0 01-2-2z" />
                    <path d="M9 22V12h6v10" />
                </svg>
                Home
            </a>
            <a href="#">
                <svg stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round"
                    viewBox="0 0 24 24">
                    <path d="M2 3h6a4 4 0 0 1 4 4v14a3 3 0 0 0-3-3H2z"></path>
                    <path d="M22 3h-6a4 4 0 0 0-4 4v14a3 3 0 0 1 3-3h7z"></path>
                </svg>
                Latest News
            </a>
            <a href="#">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2"
                    stroke-linecap="round" stroke-linejoin="round" viewBox="0 0 24 24">
                    <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0118 0z" />
                    <circle cx="12" cy="10" r="3" />
                </svg>
                Explore
            </a>
            <a href="#">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2"
                    stroke-linecap="round" stroke-linejoin="round" viewBox="0 0 24 24">
                    <path d="M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8z" />
                    <path d="M14 2v6h6M16 13H8M16 17H8M10 9H8" />
                </svg>
                Files
            </a>
            <a href="#">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <rect x="3" y="3" width="18" height="18" rx="2" ry="2" />
                    <circle cx="8.5" cy="8.5" r="1.5" />
                    <path d="M21 15l-5-5L5 21" />
                </svg>
                Galery
            </a>
            <a href="#">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <rect x="3" y="4" width="18" height="18" rx="2" ry="2" />
                    <path d="M16 2v4M8 2v4M3 10h18" />
                </svg>
                Events
            </a>
        </div>
    </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const { isLeftSidebarOpen } = storeToRefs(appStore);
</script>

<style scoped lang="scss">
$color-text: #9c9cab;
$color-hover: #ffffff;
$color-title: #5c5e6e;
$menu-gap: 20px;
$svg-size: 16px;

.side-wrapper {
    padding: 30px;
    opacity: 0;
    pointer-events: none;
    transition: opacity 0.3s ease-in-out;

    &.active {
        opacity: 1;
        pointer-events: auto;
    }
}

.side-title {
    margin-bottom: $menu-gap;
    color: $color-title;
    font-family: 'DM Sans', sans-serif;
    font-size: 15px;
    font-weight: 600;
}

.side-menu {
    display: flex;
    flex-direction: column;
    font-size: 15px;
    white-space: nowrap;
    gap: $menu-gap;

    a {
        display: flex;
        align-items: center;
        color: $color-text;
        text-decoration: none;
        transition: color 0.2s ease;

        &:hover {
            color: $color-hover;
        }

        svg {
            flex-shrink: 0;
            width: $svg-size;
            height: $svg-size;
            margin-right: 16px;
        }
    }
}
</style>
