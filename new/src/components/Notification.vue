<template>
  <Badge class="notification" dot :offset="[3, 0]">
    <Icon class="icon" type="ios-notifications-outline" size="32"></Icon>
  </Badge>
</template>

<script>
export default {
  name: 'Notification'
}
</script>

<style lang="scss" scoped>
.notification {
  width: 32px;
  height: 32px;
  top: 12px;
  color: #fff;
  .icon {
    vertical-align: initial;
  }
}
</style>
