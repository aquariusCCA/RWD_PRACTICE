<template>
  <div class="side-wrapper stories">
    <div class="side-title">STORIES</div>
    <div
      v-for="(story, index) in stories"
      :key="index"
      class="user"
    >
      <img :src="story.img" class="user-img" />
      <div class="user-info">
        <div class="username">{{ story.name }}</div>
        <div class="album-date">{{ story.time }}</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
const stories = [
  {
    name: "Lisandro Matos",
    time: "12 hours ago",
    img: "https://pbs.twimg.com/profile_images/1102351320567164931/ZCkJgJIH.png",
  },
  {
    name: "Gvozden Boskovsky",
    time: "29 minutes ago",
    img: "https://pbs.twimg.com/profile_images/1153966095444992000/1lpIyHaQ.jpg",
  },
  {
    name: "Hnek Fortuin",
    time: "3 hours ago",
    img: "https://images.unsplash.com/photo-1565464027194-7957a2295fb7?ixlib=rb-1.2.1&auto=format&fit=crop&w=3500&q=80",
  },
  {
    name: "Lubomir Dvorak",
    time: "18 hours ago",
    img: "https://images.unsplash.com/photo-1527980965255-d3b416303d12?ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80",
  },
];
</script>

<style scoped lang="scss">
.side-wrapper {
    display: flex;
    flex-direction: column;
    gap: 15px;
    padding: 30px;
    font-family: "DM Sans", sans-serif;
}

.side-title {
    margin-bottom: 20px;
    color: #5c5e6e;
    font-size: 15px;
    font-weight: 600;
}

.user {
    display: flex;
    align-items: center;
    cursor: pointer;
}

.user-img {
    width: 45px;
    height: 45px;
    margin-right: 15px;
    border: 2px solid #e2b96c;
    border-radius: 50%;
    object-fit: cover;
    object-position: center;
}

.user-info {
    display: flex;
    flex-direction: column;
}

.username {
    color: #ccc8db;
    font-size: 15px;
}

.album-date {
    font-size: 15px;
    color: #595c6c;
    margin-top: 4px;
    font-family: "Source Sans Pro", sans-serif;
}
</style>