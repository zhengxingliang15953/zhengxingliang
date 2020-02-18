<template>
  <div id="hutu">
    <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>关于湖图</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <br />
    <hr />
    <p>湖州师范学院图书馆初创于1958年，重建于1978年，“文化大革命”时期曾停办。1978至1984年称为嘉兴师专图书馆。1984年撤地建市后改名为湖州师专图书馆。1999年，原湖州师范专科学校、湖州师范学校和湖州教师进修学院三校合并，升格建立湖州师范学院，图书馆同时更名。2000年5月，原湖州卫生学校并入湖州师范学院。2003年12月新图书馆大楼落成之际，我国知名书画家、楹联艺术家沈左尧先生倾其所藏艺术珍品捐赠给学校图书馆，学校遂将图书馆命名为“沈左尧图书馆”，并专设“沈行楹联艺术馆”收藏和展示其艺术珍品。2017年4月东校区图书馆正式启用。</p>
    <baidu-map style="height:500px" :center="center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true">
      <bm-marker
        :position="{lng: 120.135592, lat: 30.879258}"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="我爱湖师图书馆"
          :labelStyle="{color: 'red', fontSize : '24px'}"
          :offset="{width: -35, height: 30}"
        />
      </bm-marker>
    </baidu-map>
  </div>
</template>

<script>
export default {
  name: "hutu",
  data() {
    return {
      center: {
        lng: 0,
        lat: 0
      },
      zoom: 3
    };
  },
  methods: {
    handler({ BMap, map }) {
      console.log(BMap, map);
      this.center.lng = 120.135592;
      this.center.lat = 30.879258;
      this.zoom = 15;
    }
  }
};
</script>

<style lang="less" scoped>
p {
  font-size: 14px;
}
</style>