<template>
  <el-row>
    <el-col :span="1">
      <div>
        <el-button icon="el-icon-menu" size="mini" @click="menuHandler"></el-button>
      </div>
    </el-col>
    <el-col :span="1"><div class="table">首页</div></el-col>
    <el-col :span="20"><div class="table">&nbsp;</div></el-col>
    <el-col :span="2">
      <!--   头像下拉菜单 -->
      <el-dropdown trigger="click">
        <div class="circle">
          <el-avatar :size="50" :src="imgUrl"></el-avatar>
        </div>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item icon="el-icon-plus">我的</el-dropdown-item>
          <el-dropdown-item icon="el-icon-circle-plus">账单</el-dropdown-item>
          <el-dropdown-item icon="el-icon-circle-plus-outline">消息</el-dropdown-item>
          <el-dropdown-item icon="el-icon-check">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      //菜单控制
      isCollapse: false,
      //头像地址
      imgUrl:import('@/assets/icon.png')
    }
  },
  methods: {
    menuHandler(){
      this.$store.commit('MENUHANDLER')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less" scoped>
.table {
  color: #C0C4CC;
  line-height: 60px;
}
.circle{
  height: 60px;
}
.el-avatar{
  margin: 5px 0 0 0;
}
</style>