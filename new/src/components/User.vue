<template>
  <div class="user-avator-dropdown">
    <Dropdown @on-click="handleClick" placement="bottom-end">
      <Avatar icon="ios-person" :src="userAvator"/>
      <span>王小明</span>
      <Icon class="arrow" :size="18" type="md-arrow-dropdown"></Icon>
      <DropdownMenu slot="list">
        <DropdownItem name="logout">退出登录</DropdownItem>
      </DropdownMenu>
    </Dropdown>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'User',
  props: {
    userAvator: {
      type: String,
      default: ''
    }
  },
  methods: {
    ...mapActions([
      'handleLogOut'
    ]),
    handleClick (name) {
      switch (name) {
        case 'logout':
          this.handleLogOut().then(() => {
            this.$router.push({
              name: 'login'
            })
          })
          break
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.user-avator-dropdown {
  margin-right: 20px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  display: inline-block;
  vertical-align: middle;
  span {
    margin-right: 5px;
  }
}
</style>
