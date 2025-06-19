<template>
    <div class="account">
        <button class="account-button">
            <!-- 信件 icon -->
            <svg 
                stroke="currentColor" 
                stroke-width="2" 
                fill="none" 
                stroke-linecap="round" 
                stroke-linejoin="round"
                class="css-i6dzq1" 
                viewBox="0 0 24 24"
            >
                <path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
                <path d="M22 6l-10 7L2 6" />
            </svg>
        </button>
        <button class="account-button account-button--has-indicator">
            <!-- 鈴鐺 icon -->
            <svg 
                stroke="currentColor" 
                stroke-width="2" 
                fill="none" 
                stroke-linecap="round" 
                stroke-linejoin="round"
                class="css-i6dzq1" 
                viewBox="0 0 24 24"
            >
                <path d="M18 8A6 6 0 006 8c0 7-3 9-3 9h18s-3-2-3-9M13.73 21a2 2 0 01-3.46 0" />
            </svg>
        </button>
        <span class="account-user">
            Quan Ha
            <img 
                class="account-profile"
                src="https://images.genius.com/2326b69829d58232a2521f09333da1b3.1000x1000x1.jpg" alt=""
            >
            <span>▼</span>
        </span>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.account {
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: sticky;
    top: 0;
    height: 60px;
    padding: 0 16px;
    background-color: #151728;
    z-index: 3;
    gap: 16px;
}

.account-button {
    position: relative;
    padding: 0;
    border: none;
    background: transparent;
    color: #64677a;
    cursor: pointer;
    display: flex;
    align-items: center;
    transition: color 0.2s ease;

    &:hover {
        color: #ffffff;
    }

    svg {
        width: 20px;
        height: 20px;
        display: block;
    }

    &--has-indicator::before {
        content: "";
        position: absolute;
        top: -2px;
        right: 0;
        width: 8px;
        height: 8px;
        background-color: #1b86f8;
        border: 2px solid #151728;
        border-radius: 50%;
    }
}

.account-user {
    display: flex;
    align-items: center;
    color: #64677a;
    font-weight: 600;
    gap: 8px;

    span {
        font-size: 10px;
        font-weight: normal;
    }
}

.account-profile {
    width: 28px;
    height: 28px;
    border-radius: 50%;
    object-fit: cover;
}
</style>