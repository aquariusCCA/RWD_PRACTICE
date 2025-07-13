document.addEventListener("DOMContentLoaded", function () {
  // 1. 侧边栏链接点击，高亮切换
  const sidebarLinks = document.querySelectorAll(".sidebar-link");
  sidebarLinks.forEach((link) => {
    link.addEventListener("click", function () {
      sidebarLinks.forEach((l) => l.classList.remove("is-active"));
      this.classList.add("is-active");
    });
  });

  // 2. 窗口尺寸变化时折叠/展开侧边栏
  const sidebar = document.querySelector(".sidebar");
  function handleResize() {
    if (window.innerWidth > 1090) {
      sidebar.classList.remove("collapse");
    } else {
      sidebar.classList.add("collapse");
    }
  }
  window.addEventListener("resize", handleResize);
  handleResize(); // 初始化时执行一次

  // 3. 视频悬停播放、移出暂停
  document.querySelectorAll(".video").forEach((v) => {
    const vid = v.querySelector("video");
    v.addEventListener("mouseover", () => vid.play());
    v.addEventListener("mouseleave", () => vid.pause());
  });

  // 4. 点击 logo / logo-expand / discover，隐藏主区域并滚回顶部
  document.querySelectorAll(".logo, .logo-expand, .discover").forEach((el) => {
    el.addEventListener("click", () => {
      const main = document.querySelector(".main-container");
      main.classList.remove("show");
      main.scrollTop = 0;
    });
  });

  // 5. 点击 trending，显示主区域、滚回顶部，并标记高亮
  document.querySelectorAll(".trending").forEach((el) => {
    el.addEventListener("click", () => {
      const main = document.querySelector(".main-container");
      main.classList.add("show");
      main.scrollTop = 0;
      sidebarLinks.forEach((l) => l.classList.remove("is-active"));
      el.classList.add("is-active");
    });
  });

  // 6. 点击任意视频容器：同上显示主区域 + 更新视频流信息
  document.querySelectorAll(".video").forEach((v) => {
    v.addEventListener("click", () => {
      // 6.1 显示主区域并高亮 trending
      const main = document.querySelector(".main-container");
      main.classList.add("show");
      main.scrollTop = 0;
      sidebarLinks.forEach((l) => l.classList.remove("is-active"));
      const trending = document.querySelector(".trending");
      if (trending) trending.classList.add("is-active");

      // 6.2 更新视频流及相关信息
      const sourceUrl = v.querySelector("source").getAttribute("src");
      const titleText = v.querySelector(".video-name").textContent;
      const personText = v.querySelector(".video-by").textContent;
      const authorImgSrc = v.querySelector(".author-img").getAttribute("src");

      const streamVideo = document.querySelector(".video-stream video");
      const streamSource = document.querySelector(".video-stream source");

      // 若需停止之前的播放，可先 pause()
      streamVideo.pause();

      streamSource.setAttribute("src", sourceUrl);
      streamVideo.load();

      document.querySelector(".video-p-title").textContent = titleText;
      document.querySelector(".video-p-name").textContent = personText;
      document
        .querySelector(".video-detail .author-img")
        .setAttribute("src", authorImgSrc);
    });
  });
});
