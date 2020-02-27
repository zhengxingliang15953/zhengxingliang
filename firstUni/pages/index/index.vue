<template>
	<view>
		<swiper @change="swiperChange" autoplay="true">
			<swiper-item item-id="1">
				<image src="../../static/小白菜的副本.jpg" class="swiperImage"></image>
			</swiper-item>
			<swiper-item item-id="2">
				1
			</swiper-item>
			<swiper-item item-id="3">
				2
			</swiper-item>
		</swiper>
		{{index}}
		<movable-area style="width: 100%;height: 100px;">
			<movable-view direction="all">
				<icon type="success" size="30"></icon>
			</movable-view>
		</movable-area>
		<progress show-info="true" percent="50" border-radious="10"></progress>
		<button type="primary" @click="btn" size="mini">按钮</button>
		<checkbox-group @change="checkChange">
			<checkbox value="cb1" checked="true" />选中
			<checkbox value="cb1" />未选中
		</checkbox-group>
		<editor style="height: 50px;" placeholder="请输入..."></editor>
		<input type="idcard" value="123"/>
		<picker mode="selector" :range="richList" value="0">
			<view>{{richList[1]}}</view>
		</picker>
		<navigator url="http://www.baidu.com">
			<button type="primary" size="mini">我的</button> 
		</navigator>
		<uniRate value="2"></uniRate>
		<uni-icons type="contact" size="50"></uni-icons>
	</view>
</template>

<script>
	import uniRate from '../../component/uni-rate/uni-rate.vue';
	import uniIcons from '../../component/uni-icons/uni-icons.vue';
	export default {
		data() {
			return {
				title: '按钮',
				index: 0,
				richList: [1, 2, 3, 4],
			}
		},
		methods: {
			swiperChange(event) {
				this.index = event.detail.current;
			},
			btn() {
				console.log('点击了');
			},
			checkChange(value){
				console.log(value.detail.value);
			}
		},
		components:{
			uniRate,uniIcons
		}
	}
</script>

<style scoped >
	.swiperImage {

		width: 100%;
	}
</style>
