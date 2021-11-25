<template>
  <div class="about">
    <InMap class="map" :toolbar="true" />
  </div>
</template>

<script>
import InMap from '@/components/InMap'

export default {
  name: 'about',
  components: {
    InMap
  }
}
</script>

<style lang="scss" scoped>
.map {
  width: 80%;
  height: 600px;
  margin-left: auto;
  margin-right: auto;
}
</style>
