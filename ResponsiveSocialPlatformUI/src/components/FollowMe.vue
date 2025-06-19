<template>
    <div>
        <a 
            href="https://twitter.com/AysnrTrkk" 
            class="follow-me"
            :class="{ active: isLeftSidebarOpen }" 
            target="_blank"
            rel="noopener noreferrer"
        >
            <span class="text-layer">
                <svg viewBox="0 0 24 24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round"
                    stroke-linejoin="round" class="icon">
                    <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1
             A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2
             c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z">
                    </path>
                </svg>
                <span>Follow me on Twitter</span>
            </span>
            <span class="text-layer developer-layer">
                <img src="https://pbs.twimg.com/profile_images/1253782473953157124/x56UURmt_400x400.jpg"
                    alt="Profile picture" />
                <span>Aysenur Turk — @AysnrTrkk</span>
            </span>
        </a>
    </div>
</template>


<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const { isLeftSidebarOpen } = storeToRefs(appStore);
</script>

<style scoped lang="scss">
.follow-me {
    overflow: hidden;
    position: relative;
    display: block;
    height: 52px;
    padding: 0 20px;
    border-top: 1px solid #272a3a;
    color: #9c9cab;
    font-size: 14px;
    text-decoration: none;

    &.active {
        opacity: 1;
    }

    &:not(.active) {
        opacity: 0;
        pointer-events: none;
    }

    .text-layer {
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 10px;
        position: absolute;
        left: 0;
        width: 100%;
        height: 100%;
        padding: 0 20px;
        background-color: transparent;
        transition: transform 0.3s ease;

        svg.icon {
            width: 20px;
            height: 20px;
        }

        // 強制所有 span 中的文字「單行顯示」，並在超過寬度時自動用 ... 省略
        span {
            white-space: nowrap; // 不換行
            overflow: hidden; // 超出部分裁切
            text-overflow: ellipsis; // 顯示 ...
            max-width: 100%; // 限制最大寬度（必要時可以用 calc）
        }
    }

    .developer-layer {
        background-color: #272a3a;
        color: #fff;
        transform: translateY(-100%);

        img {
            width: 26px;
            height: 26px;
            border-radius: 50%;
            object-fit: cover;
        }
    }

    &:hover {
        .text-layer:first-of-type {
            transform: translateY(100%);
        }

        .developer-layer {
            transform: translateY(0);
        }
    }
}
</style>