<template>
  <div class="page-box">
    <div class="page-box__header">
      <h2 class="page-box__title">Your pages</h2>
      <button
        type="button"
        class="page-box__menu-btn"
      ></button>
    </div>

    <ul class="page-box__user-list">
      <li
        v-for="user in users"
        :key="user.id"
        class="page-box__user"
      >
        <img
          :src="user.avatar"
          :alt="user.alt"
          class="page-box__avatar"
        />
        <span class="page-box__name">{{ user.name }}</span>
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup>
interface User {
  id: string | number
  avatar: string
  name: string
  alt?: string
}

const users: User[] = [
    {
        id: 1,
        avatar: 'https://i.pravatar.cc/150?img=1',
        name: 'John Doe',
        alt: 'John Doe Avatar'
    },
    {
        id: 2,
        avatar: 'https://i.pravatar.cc/150?img=2',
        name: 'Jane Smith',
        alt: 'Jane Smith Avatar'
    },
    {
        id: 3,
        avatar: 'https://i.pravatar.cc/150?img=3',
        name: 'Alice Johnson',
        alt: 'Alice Johnson Avatar'
    }
]
</script>

<style scoped lang="scss">
.page-box {
  background: #151728;
  border-radius: 4px;
  padding: 20px;
  margin-top: 20px;
  font-family: "DM Sans", sans-serif;

  &__header {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
  }

  &__title {
    font-size: 18px;
    font-weight: 600;
    color: #5c5e6e;
    margin: 0;
  }

  &__menu-btn {
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
    &::before { left: -(20px / 2); }
    &::after  { right: -(20px / 2); }
  }

  &__user-list {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    flex-direction: column;
    gap: 18px;
  }

  &__user {
    display: flex;
    align-items: center;
    cursor: pointer;
  }

  &__avatar {
    width: 45px;
    height: 45px;
    margin-right: 20px;
    border-radius: 50%;
    object-fit: cover;
  }

  &__name {
    color: #ccc8db;
    font-size: 15px;
  }
}
</style>
