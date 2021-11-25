<template>
  <div id="app">
    <Layout>
      <Header class="header">
        <Row>
          <Col :md="3">
            <div class="logo">网格化信息服务平台</div>
          </Col>
          <Col :md="18">
            <Menu class="nav" mode="horizontal" theme="dark" active-name="1">
              <MenuItem name="1">
                <router-link to="/"><Icon type="ios-navigate"></Icon>首页</router-link>
              </MenuItem>
              <MenuItem name="2">
                <router-link to="/about"><Icon type="ios-keypad"></Icon>网格化演示</router-link>
              </MenuItem>
              <MenuItem name="3">
                <router-link to="/customer"><Icon type="ios-keypad"></Icon>户籍管理</router-link>
              </MenuItem>
            </Menu>
          </Col>
          <Col :md="3">
            <Notification />
            <User class="user" />
          </Col>
        </Row>
      </Header>
      <Content class="main">
        <router-view/>
      </Content>
    </Layout>
  </div>
</template>

<script>
import User from '@/components/User'
import Notification from '@/components/Notification'

export default {
  components: {
    User,
    Notification
  }
}
</script>

<style lang="scss" scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  width: 100%;
  min-height: 100vh;
  background: #f5f7f9;
  .header {
    width: 100%;
    height: 64px;
    padding: 0;
    .logo {
      height: 30px;
      padding-left: 10px;
      padding-right: 10px;
      color: #fff;
      background-color: #5b6270;
      border-radius: 3px;
      position: relative;
      top: 17px;
      left: 20px;
      line-height: 30px;
    }
    .nav {
      height: 64px;
      line-height: 64px;
      margin-left: 30px;
    }
    .user {
      float: right;
    }
  }
}
</style>
