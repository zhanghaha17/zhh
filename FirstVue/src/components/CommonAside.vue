<template>
  <el-menu
      default-active="1-4-1"
      class="el-menu-vertical-demo"
      :collapse="isCollapse"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :router= "true">
    <h3>{{isCollapse?'标题':'后台管理系统'}}</h3>
    <el-menu-item v-for="item in noChildren" :key="item.path" :index="item.path+''">
      <i :class="'el-icon-'+ item.icon"></i>
      <span slot="title">{{item.label}}</span>
    </el-menu-item>

    <el-submenu v-for="item in hasChildren" :key="item.path" :index="item.path+''">
      <template slot="title">
        <i :class="'el-icon-'+ item.icon"></i>
        <span slot="title">{{item.label}}</span>
      </template>
      <el-menu-item-group v-for="subItem in item.children" :key="subItem.path">
        <el-menu-item :index="subItem.path">{{subItem.label}}</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>

export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      menu: [
        {
          path: '/',
          name: 'home',
          label: '首页',
          icon: 's-home',
          url: 'Home/Home'
        },
        {
          path: '/mall',
          name: 'mall',
          label: '商品管理',
          icon: 'video-play',
          url: 'MallManage/MallManage'
        },
        {
          path: '/user',
          name: 'user',
          label: '用户管理',
          icon: 'user',
          url: 'UserManage/UserManage'
        },
        {

          label: '其他',
          icon: 'location',
          children: [
            {
              path: '/page01',
              name: 'page01',
              label: '页面1',
              icon: 'setting',
              url: 'Other/PageOne'
            },
            {
              path: '/page02',
              name: 'page02',
              label: '页面2',
              icon: 'setting',
              url: 'Other/PageTwo'
            }]
        }
      ]
    }
  },
  computed: {
    noChildren(){
      return this.menu.filter(item => !item.children)
    },
    hasChildren(){
      return this.menu.filter(item => item.children)
    },
    isCollapse(){
      return false;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less" scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 100vh;
  border: none;
}
.el-menu {
  border: none;
}
.el-menu-item-group__title {
  padding: 0;
}

h3{
  color: aliceblue;
  line-height: 30px;
}

span,.el-menu-item{
  font-size: 16px;
}

</style>