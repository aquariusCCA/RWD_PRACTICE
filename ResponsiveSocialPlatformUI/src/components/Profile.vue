<template>
    <div class="profile">
        <div class="profile-avatar">
            <img 
                src="https://images.genius.com/2326b69829d58232a2521f09333da1b3.1000x1000x1.jpg"
                class="profile-img"
            >
            <div class="profile-name">Quan Ha</div>
        </div>
        <div class="profile-bg"></div> <!-- 作為模糊背景層 -->
        <img
            src="https://images.unsplash.com/photo-1508247967583-7d982ea01526?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
            class="profile-cover"
        >
        <div class="profile-menu">
            <a class="profile-menu-link active">Timeline</a>
            <a class="profile-menu-link">About</a>
            <a class="profile-menu-link">Friends</a>
            <a class="profile-menu-link">Photos</a>
            <a class="profile-menu-link">More</a>
        </div>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.profile {
  position: relative;
  height: 40vh;
  min-height: 250px;
  max-height: 350px;
  z-index: 1;

  .profile-bg {
      position: absolute;
      inset: 0;
      background: url("https://images.unsplash.com/photo-1508247967583-7d982ea01526?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80") center / cover no-repeat;
      filter: blur(50px);
      opacity: 0.7;
      z-index: -1;
  }

  .profile-cover {
    position: absolute;
    inset: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 4px;
    opacity: 0.7;
    z-index: 0;
  }

  .profile-avatar {
    position: absolute;
    top: 60%;         // ❶ 向下偏一點（可微調）
    left: 25%;        // ❷ 向左偏一點（可微調）
    transform: translate(-50%, -50%); // ❸ 保持元素本身居中偏移
    display: flex;
    align-items: center;
    z-index: 1;

    .profile-img {
      width: 150px;
      height: 150px;
      border-radius: 50%;
      border: 3px solid #151728;
      object-fit: cover;
    }

    .profile-name {
      margin-left: 24px;
      margin-bottom: 24px;
      font: 600 22px "DM Sans", sans-serif;
      color: #fff;
    }

    @media screen and (max-width: 700px) {
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      flex-direction: column;
      align-items: center;
      justify-content: center;

      .profile-name {
        margin: 12px 0 0;
      }
    }
  }

  .profile-menu {
      position: absolute;
      bottom: 0;
      display: flex;
      width: 100%;
      padding-left: 200px;
      background: #151728;
      border-radius: 0 0 4px 4px;
      z-index: 1;

      .profile-menu-link {
          padding: 20px 16px;
          color: #5c5e6e;
          cursor: pointer;
          transition: background-color 0.3s, color 0.3s;

          &.active,
          &:hover {
              color: #fff;
              background-color: #1b1d2e;
              border-bottom: 3px solid #1488fa;
          }
      }

      @media screen and (max-width: 700px) {
          padding-left: 0;
          justify-content: space-around;
          overflow-x: auto; // ✅ 開啟橫向捲動
          flex-wrap: nowrap; // ✅ 阻止元素自動換行

          .profile-menu-link {
              flex: 1 1 20%;
              text-align: center;
          }
      }
  }
}
</style>