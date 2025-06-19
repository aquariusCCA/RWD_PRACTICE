<template>
  <div class="event-box">
    <div class="wrapper">
      <img 
        src="https://images.unsplash.com/photo-1516450360452-9312f5e86fc7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80"
        alt="Event Image"
        class="image" 
      />
      <div class="date">
        <div class="month">Jan</div>
        <div class="day">01</div>
      </div>
      <div class="title">Winter Wonderland</div>
      <div class="subtitle">01st Jan, 2019 07:00AM</div>
    </div>
  </div>
</template>

<script lang="ts" setup>
</script>

<style scoped lang="scss">
.event-box {
  background-color: #151728;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s ease, box-shadow 0.3s ease;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.3);
  }

  .wrapper {
    position: relative;
  }

  .image {
    display: block;
    width: 100%;
    height: auto;
  }

  .date {
    position: absolute;
    top: 16px;
    left: 16px;
    display: flex;
    flex-direction: column;
    text-align: center;

    .month {
      background-color: #1687fa;
      padding: 4px 12px;
      font-family: "DM Sans", sans-serif;
      font-weight: 600;
      color: #fff;
      text-transform: uppercase;
      letter-spacing: 1px;
      border-top-left-radius: 8px;
      border-top-right-radius: 8px;
    }

    .day {
      background-color: rgba(0, 0, 0, 0.4);
      backdrop-filter: blur(4px);
      padding: 6px 0;
      width: 100%;
      font-family: "DM Sans", sans-serif;
      font-size: 24px;
      font-weight: 700;
      color: #fff;
    }
  }

  .title {
    margin: 12px 16px 4px;
    font-family: "DM Sans", sans-serif;
    font-size: 18px;
    font-weight: 600;
    color: #c3c5d5;
  }

  .subtitle {
    margin: 0 16px 16px;
    font-family: "DM Sans", sans-serif;
    font-size: 14px;
    font-weight: 500;
    color: #5c5e6e;
  }
}
</style>
