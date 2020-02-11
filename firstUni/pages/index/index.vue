<template>
	<view>
		<button type="primary">{{title}}</button>
		<view hover-class="hoverBox">
			view
		</view>
		<scroll-view scroll-y="true"><!--可滚动view-->
			fd
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '按钮',
			}
		},
	}
</script>

<style scoped lang="less">
	.hoverBox{
		background-color:skyblue;
	}
</style>
