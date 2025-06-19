<template>
    <div class="main">
        <MainSearchBar />

        <div class="main-container">
            <Profile />

            <div class="timeline">
                <div class="timeline-left">
                    <IntroBox />
                    <EventBox />
                    <PageBox />
                </div>
                <div class="timeline-right">
                    <StatusBox />
                    <AlbumBox />
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" setup>
import MainSearchBar from './MainSearchBar.vue';
import Profile from './Profile.vue';
import IntroBox from './IntroBox.vue';
import EventBox from './EventBox.vue';
import PageBox from './PageBox.vue';
import StatusBox from './StatusBox.vue';
import AlbumBox from './AlbumBox.vue';
</script>

<style scoped lang="scss">
.main {
    display: flex;
    flex-direction: column;
    background-color: #181d2f;
}

.main-container {
    flex-grow: 1;
    overflow: auto;
    padding: 20px;
    background-color: #24273b;
}

.timeline {
    position: relative;
    display: flex;
    padding-top: 20px;
    z-index: 2;

    @media screen and (max-width: 768px) {
        flex-wrap: wrap;
        flex-direction: column-reverse;
    }
}

.timeline-left {
    width: 310px;
    flex-shrink: 0;

    @media screen and (max-width: 768px) {
        width: 100%;
    }
}

.timeline-right {
    flex-grow: 1;
    padding-left: 20px;

    @media screen and (max-width: 768px) {
        padding-left: 0;
        margin-bottom: 20px;
    }
}
</style>