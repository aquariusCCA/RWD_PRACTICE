<template>
  <div class="side-wrapper stories">
    <div class="side-title">CONTACTS</div>
    <div
      v-for="(story, index) in stories"
      :key="index"
      class="user"
    >
      <img :src="story.img" class="user-img" />
      <div class="user-info">
        <div class="username">{{ story.name }}</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
const stories = [
    {
        name: "Andrei Mashrin",
        img: "https://randomuser.me/api/portraits/men/1.jpg"
    },
    {
        name: "Aryn Jacobssen",
        img: "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=046c29138c1335ef8edee7daf521ba50"
    },
    {
        name: "Carole Landu",
        img: "https://images.unsplash.com/photo-1575084713138-342cae5f8d00?ixlib=rb-1.2.1&auto=format&fit=crop&w=958&q=80"
    },
    {
        name: "Chineze Afa",
        img: "https://images.pexels.com/photos/598745/pexels-photo-598745.jpeg?h=350&auto=compress&cs=tinysrgb"
    },
    {
        name: "Mok Kwang",
        img: "https://pbs.twimg.com/profile_images/2452384114/noplz47r59v1uxvyg8ku.png"
    },
    {
        name: "Naomi Yepes",
        img: "https://randomuser.me/api/portraits/women/63.jpg"
    },
    {
        name: "Shaamikh Ale",
        img: "https://images.unsplash.com/photo-1476493279419-b785d41e38d8?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=61eaea85f1aa3d065400179c78163f15"
    },
    {
        name: "Sofia Alcocer",
        img: "https://m.media-amazon.com/images/M/MV5BMjI4NDcyNjQxNl5BMl5BanBnXkFtZTgwMzI4OTM3NjM@._V1_UY256_CR13,0,172,256_AL_.jpg"
    },
    {
        name: "Wen Yahui",
        img: "https://images.unsplash.com/photo-1509380836717-c4320ccf1a6f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=e01c8c45a063daaf6d6e571a32bd6c90"
    },
    {
        name: "Leslee Moss",
        img: "https://pbs.twimg.com/profile_images/737221709267374081/sdwta9Oh.jpg"
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
</style>