<template>
    <div class="search-bar right-search">
        <input 
            type="text" 
            placeholder="Search" 
        />
        <div class="search-bar-svgs">
            <svg 
                stroke="currentColor" 
                stroke-width="2" 
                fill="none" 
                stroke-linecap="round" 
                stroke-linejoin="round"
                class="css-i6dzq1" 
                viewBox="0 0 24 24"
            >
                <circle cx="12" cy="12" r="3" />
                <path
                    d="M19.4 15a1.65 1.65 0 00.33 1.82l.06.06a2 2 0 010 2.83 2 2 0 01-2.83 0l-.06-.06a1.65 1.65 0 00-1.82-.33 1.65 1.65 0 00-1 1.51V21a2 2 0 01-2 2 2 2 0 01-2-2v-.09A1.65 1.65 0 009 19.4a1.65 1.65 0 00-1.82.33l-.06.06a2 2 0 01-2.83 0 2 2 0 010-2.83l.06-.06a1.65 1.65 0 00.33-1.82 1.65 1.65 0 00-1.51-1H3a2 2 0 01-2-2 2 2 0 012-2h.09A1.65 1.65 0 004.6 9a1.65 1.65 0 00-.33-1.82l-.06-.06a2 2 0 010-2.83 2 2 0 012.83 0l.06.06a1.65 1.65 0 001.82.33H9a1.65 1.65 0 001-1.51V3a2 2 0 012-2 2 2 0 012 2v.09a1.65 1.65 0 001 1.51 1.65 1.65 0 001.82-.33l.06-.06a2 2 0 012.83 0 2 2 0 010 2.83l-.06.06a1.65 1.65 0 00-.33 1.82V9a1.65 1.65 0 001.51 1H21a2 2 0 012 2 2 2 0 01-2 2h-.09a1.65 1.65 0 00-1.51 1z" />
            </svg>
            <svg 
                fill="currentColor" 
                xmlns="http://www.w3.org/2000/svg" 
                viewBox="0 0 469.34 469.34"
            >
                <path
                    d="M456.84 76.17l-64-64.06c-16.13-16.13-44.18-16.17-60.37.04L45.77 301.67a10.73 10.73 0 00-2.7 4.59L.41 455.73a10.68 10.68 0 0013.19 13.2l149.33-42.7c1.73-.5 3.3-1.42 4.58-2.7l289.33-286.98c8.06-8.07 12.5-18.78 12.5-30.19s-4.44-22.12-12.5-30.2zM285.99 89.74L325.25 129l-205 205-14.7-29.44a10.67 10.67 0 00-9.55-5.9H78.92L286 89.75zM26.2 443.14l13.9-48.64 34.74 34.74-48.64 13.9zm123.14-35.18L98.3 422.54l-51.5-51.5L61.38 320H89.4l18.38 36.77a10.67 10.67 0 004.77 4.77l36.78 18.39v28.03zm21.33-17.54v-17.09c0-4.04-2.28-7.72-5.9-9.54l-29.43-14.7 205-205 39.26 39.26-208.93 207.07zm271.11-268.7l-47.03 46.61L301 74.6l46.59-47c8.06-8.07 22.1-8.07 30.16 0l64 64c4.03 4.03 6.25 9.38 6.25 15.08s-2.22 11.05-6.22 15.05z" />
            </svg>
            <svg 
                stroke="currentColor" 
                stroke-width="2" 
                fill="none" 
                stroke-linecap="round" 
                stroke-linejoin="round"
                viewBox="0 0 24 24"
            >
                <path d="M12 5v14M5 12h14" />
            </svg>
        </div>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.right-search {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding-right: 10px;
    border-top: 1px solid #272a3a;
    position: sticky;
    bottom: 0;
    margin-top: auto;

    svg {
        width: 16px;
        height: 16px;
        transition: transform 0.2s ease;

        &:hover {
            transform: scale(1.1);
        }
    }
}

.search-bar {
    position: relative;
    height: 60px;
    background-color: #151728;
    z-index: 3;

    input {
        display: block;
        height: 100%;
        width: 100%;
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

.search-bar-svgs {
    display: flex;
    align-items: center;
    gap: 15px;
    color: #656679;
}
</style>