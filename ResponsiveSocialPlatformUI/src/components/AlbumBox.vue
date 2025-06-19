<template>
    <div class="album">
        <div class="album__header">
            <img src="https://images.genius.com/2326b69829d58232a2521f09333da1b3.1000x1000x1.jpg" alt="User avatar"
                class="album__avatar" />
            <div class="album__info">
                <div class="album__title">
                    <strong class="album__author">Quan Ha</strong>
                    create new
                    <span class="album__media-type">album</span>
                </div>
                <div class="album__time">6 hours ago</div>
            </div>
            <button class="album__menu"></button>
        </div>

        <div class="album__content">
            <p class="album__description">
                When the bass drops, so do my problems.
            </p>
            <div class="album__photos">
                <img src="https://images.unsplash.com/photo-1508179719682-dbc62681c355?ixlib=rb-1.2.1&auto=format&fit=crop&w=2378&q=80"
                    alt="Photo 1" class="album__photo" />
                <div class="album__photos-secondary">
                    <img src="https://images.unsplash.com/photo-1502872364588-894d7d6ddfab?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80"
                        alt="Photo 2" class="album__photo" />
                    <img src="https://images.unsplash.com/photo-1566737236500-c8ac43014a67?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80"
                        alt="Photo 3" class="album__photo" />
                </div>
            </div>
        </div>

        <div class="album__actions">
            <a href="#" class="album__action album__action--like">
                <svg stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round"
                    viewBox="0 0 24 24">
                    <path
                        d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z" />
                </svg>
                <span class="album__count">87</span>
            </a>
            <a href="#" class="album__action album__action--comment">
                <svg stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round"
                    viewBox="0 0 24 24">
                    <path d="M21 15a2 2 0 01-2 2H7l-4 4V5a2 2 0 012-2h14a2 2 0 012 2z" />
                </svg>
                <span class="album__count">20</span>
            </a>
            <a href="#" class="album__action album__action--share">
                <svg stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round"
                    viewBox="0 0 24 24">
                    <path d="M17 1l4 4-4 4" />
                    <path d="M3 11V9a4 4 0 014-4h14M7 23l-4-4 4-4" />
                    <path d="M21 13v2a4 4 0 01-4 4H3" />
                </svg>
                <span class="album__count">13</span>
            </a>
        </div>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.album {
    margin-top: 20px;
    padding-top: 20px;
    border-radius: 4px;
    background-color: #151728;
    color: #a2a4b4;

    &__header {
        display: flex;
        align-items: center;
        padding: 0 20px 20px;
    }

    &__avatar {
        width: 50px;
        height: 50px;
        margin-right: 20px;
        border-radius: 50%;
        object-fit: cover;
    }

    &__info {
        flex: 1;
    }

    &__title {
        font-size: 16px;
        font-weight: 600;

        & .album__author {
            font-weight: bold;
            margin-right: 4px;
        }

        & .album__media-type {
            color: #1771d6;
            cursor: pointer;
        }
    }

    &__time {
        font-size: 15px;
        color: #595c6c;
        margin-top: 4px;
    }

    &__menu {
        // 三點菜單
        position: relative;
        width: 4px;
        height: 4px;
        padding: 0;
        margin-left: auto;
        border: none;
        background-color: #8f98a9;
        border-radius: 50%;
        cursor: pointer;

        // 左右兩個 pseudo-dots
        &::before,
        &::after {
            content: "";
            position: absolute;
            top: 50%;
            width: 4px;
            height: 4px;
            background-color: #8f98a9;
            border-radius: 50%;
            transform: translateY(-50%);
        }

        &::before {
            left: -(20px / 2);
        }

        &::after {
            right: -(20px / 2);
        }
    }

    &__content {
        padding: 0 20px 20px;
        font-size: 14px;
        line-height: 1.5;
    }

    &__description {
        margin: 0 0 16px; // 讓段落和照片間有間隔
        font-size: 14px;
        line-height: 1.5;
        color: #e0e2ea; // 或依整體設計調整
    }

    &__photos {
        display: flex;
        max-height: 30vh;

        >.album__photo {
            width: 50%;
            margin-right: 10px;
            border-radius: 4px;
            object-fit: cover;
            object-position: center;
        }
    }

    &__photos-secondary {
        display: flex;
        flex-direction: column;
        justify-content: space-between;

        >.album__photo {
            height: calc(50% - 5px);
            border-radius: 4px;
            object-fit: cover;
            object-position: center;
        }
    }

    &__photo {
        display: block;
        width: 100%;
        object-fit: cover;
        object-position: center;
        border-radius: 4px;
        margin-top: 10px;
    }

    &__actions {
        display: flex;
        padding: 0 20px 20px;
    }

    &__action {
        display: inline-flex;
        align-items: center;
        margin-right: 20px;
        color: inherit;
        text-decoration: none;
        font-weight: 600;
        transition: color 0.2s;

        &:hover {
            color: #fff;
        }

        svg {
            width: 16px;
            margin-right: 6px;
        }

        &--like svg {
            stroke: #e74c3c;
        }

        &--comment svg {
            stroke: #3498db;
        }

        &--share svg {
            stroke: #1abc9c;
        }
    }

    &__count {
        display: inline-block;
    }
}
</style>