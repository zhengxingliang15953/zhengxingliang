<template>
  <div id="openTime">
      <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>开放时间</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <br><hr></hr>

    <table align="center" border="1" cellpadding="0" cellspacing="0" style="width:65%;margin:2px auto;">
	<tbody>
		<tr>
			<td style="height:28px; width:66px">
			<p style="text-align: center;">校区</p>
			</td>
			<td style="height:28px; width:190px">
			<p style="text-align: center;">部门与服务</p>
			</td>
			<td style="height:28px; width:198px">
			<p style="text-align: center;">星期一 -- 星期五</p>
			</td>
			<td style="height:28px; width:142px">
			<p style="text-align: center;">星期六、星期日</p>
			</td>
		</tr>
		<tr>
			<td style="height:76px; width:66px">
			<p style="text-align: center;">　</p>
			</td>
			<td style="height:76px; width:190px">
			<p style="text-align: center;">总咨询台</p>
			</td>
			<td style="height:76px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:76px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td rowspan="8" style="height:19px; width:66px">
			<p style="text-align: center;">东校区</p>
			</td>
			<td style="height:19px; width:190px">
			<p style="text-align: center;">借阅服务空间</p>
			</td>
			<td colspan="2" style="height:19px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:34px; width:190px">
			<p style="text-align: center;">信息共享空间</p>
			</td>
			<td colspan="2" style="height:34px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:67px; width:190px">
			<p style="text-align: center;">馆督导室</p>
			</td>
			<td style="height:67px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:67px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:69px; width:190px">
			<p style="text-align: center;">知识服务中心</p>
			</td>
			<td style="height:69px; width:198px">
			<p style="text-align: center;">夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:69px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:4px; width:190px">
			<p style="text-align: center;">培训室</p>
			</td>
			<td colspan="2" style="height:4px; width:341px">
			<p style="text-align: center;">培训时间见图书馆通知或进行预约</p>
			</td>
		</tr>
		<tr>
			<td style="height:10px; width:190px">
			<p style="text-align: center;">报刊阅览空间</p>
			</td>
			<td colspan="2" style="height:10px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:6px; width:190px">
			<p style="text-align: center;">学习空间</p>
			</td>
			<td colspan="2" style="height:6px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:30px; width:190px">
			<p style="text-align: center;">研修空间</p>
			</td>
			<td colspan="2" style="height:30px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td rowspan="9" style="height:26px; width:66px">
			<p style="text-align: center;">西校区</p>
			</td>
			<td style="height:26px; width:190px">
			<p style="text-align: center;">借阅服务空间</p>
			</td>
			<td colspan="2" style="height:26px; width:341px">
			<p style="text-align: center;">冬令08:00-17:00<br />
			夏令08:00-17:30</p>
			</td>
		</tr>
		<tr>
			<td style="height:21px; width:190px">
			<p style="text-align: center;">学习空间</p>
			</td>
			<td colspan="2" style="height:21px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:4px; width:190px">
			<p style="text-align: center;">合刊资料库</p>
			</td>
			<td style="height:4px; width:198px">
			<p style="text-align: center;">按需服务</p>
			</td>
			<td style="height:4px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:14px; width:190px">
			<p style="text-align: center;">信息共享与学习空间</p>
			</td>
			<td colspan="2" style="height:14px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:29px; width:190px">
			<p style="text-align: center;">外文借阅服务空间</p>
			</td>
			<td colspan="2" style="height:29px; width:341px">
			<p style="text-align: center;">冬令08:00-21:30<br />
			夏令08:00-22:00</p>
			</td>
		</tr>
		<tr>
			<td style="height:34px; width:190px">
			<p style="text-align: center;">特色、专题阅览空间</p>
			</td>
			<td colspan="2" style="height:34px; width:341px">
			<p style="text-align: center;">冬令08:00-17:00<br />
			夏令08:00-17:30</p>
			</td>
		</tr>
		<tr>
			<td style="height:66px; width:190px">
			<p style="text-align: center;">古籍阅览空间</p>
			</td>
			<td style="height:66px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:66px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:58px; width:190px">
			<p style="text-align: center;">沈行楹联艺术馆</p>
			</td>
			<td style="height:58px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:58px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:4px; width:190px">
			<p style="text-align: center;">合报资料库</p>
			</td>
			<td style="height:4px; width:198px">
			<p style="text-align: center;">按需服务</p>
			</td>
			<td style="height:4px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td rowspan="2" style="height:44px; width:66px">
			<p style="text-align: center;">中校区</p>
			</td>
			<td style="height:44px; width:190px">
			<p style="text-align: center;">人文资料室</p>
			</td>
			<td style="height:44px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:44px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td style="height:36px; width:190px">
			<p style="text-align: center;">两赵纪念馆</p>
			</td>
			<td style="height:36px; width:198px">
			<p style="text-align: center;">冬令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 13:30-17:00<br />
			夏令08:00-11:30<br />
			&nbsp; &nbsp; &nbsp; 14:00-17:30</p>
			</td>
			<td style="height:36px; width:142px">
			<p style="text-align: center;">--</p>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="height:4px; width:595px">
			<p>注：法定节假日不开放</p>
			</td>
		</tr>
	</tbody>
</table>


  </div>
</template>

<script>
export default {
  name: "openTime",
  data() {
    return {};
  }
};
</script>

<style lang="less" scoped>
</style>