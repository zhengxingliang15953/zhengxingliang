<template>
	<view>
		<button type="primary">{{title}}</button>
		<view hover-class="hoverBox"><!--正常view-->
			正常的view
		</view>
		<scroll-view scroll-y="true"><!--可滚动view-->
			可滚动view
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
