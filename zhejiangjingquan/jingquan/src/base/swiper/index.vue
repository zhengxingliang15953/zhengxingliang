<template>
  <swiper :options="swiperOption">
    <!--<swiper-slide v-for="(slide, index) in banner" :key="index">
      <img :src="slide.src" alt />
    </swiper-slide>-->
    <swiper-slide>
      <img src="../../assets/img/瀑布.jpg" alt width="100%;"/>
    </swiper-slide>
    <swiper-slide>
      <!--<img :src="slide[0].src" alt />--><img src="../../assets/img/changfang.png" alt width="100%;"/>
    </swiper-slide>
    <swiper-slide>
      <img src="../../assets/img/swriper3.png" alt width="100%;"/>
    </swiper-slide>
    <div class="swiper-pagination" slot="pagination"></div>
  </swiper>
</template>

<script>
import { getbanner } from "../../api";
export default {
  name: "carrousel",
  created() {
    this.getimg(this.$i18n.locale);
  },
  data() {
    return {
      banner: "",

      swiperOption: {
        pagination: {
          el: ".swiper-pagination"
        },
        autoplay: {
          delay: 3000,
          stopOnLastSlide: false,
          disableOnInteraction: false
        }
      }
    };
  },
  methods: {
    async getimg(lang) {
      this.banner = await getbanner(lang);
      this.banner = this.banner.data;
    }
  },
  mounted() {
    // setInterval(() => {
    //   console.log('simulate async data')
    //   if (this.swiperSlides.length < 10) {
    //     this.swiperSlides.push(this.swiperSlides.length + 1)
    //   }
    // }, 3000)
  }
};
</script>
