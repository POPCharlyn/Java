<template>
  <div class="inmap">
    <div class="button-group" v-show="toolbar">
      <Button type="primary" @click="createPath()">创建围栏</Button>
      <Button @click="changeEditStatus()">{{ isEdit ? '关闭编辑' : '启用编辑' }}</Button>
      <Button @click="getPath()">获得围栏路径坐标</Button>
    </div>
    <div class="map" ref="map"></div>
  </div>
</template>

<script>
import inMap from 'inmap'

export default {
  name: 'inMap',
  props: {
    toolbar: {
      default: false
    }
  },
  data () {
    return {
      isEdit: false,
      inmap: null,
      overlay: null
    }
  },
  mounted () {
    const myCity = new BMap.LocalCity()
    myCity.get(result => {
      console.log(result)
      this.inmap = new inMap.Map({
        id: this.$refs.map,
        // skin: "WhiteLover",
        center: [result.center.lng, result.center.lat],
        zoom: {
          value: 12,
          show: true,
          max: 20,
          min: 5
        }
      })
      this.overlay = new inMap.PolygonEditorOverlay({
        style: {
          point: {
            normal: {
              backgroundColor: 'rgba(93,158,247,0.7)', // 填充颜色
              size: 3 // 半径
            },
            mouseOver: {
              backgroundColor: 'rgba(93,158,247,1)',
              borderColor: 'rgba(93,158,247,1)',
              borderWidth: 1
            },
            selected: {
              borderWidth: 1,
              backgroundColor: 'rgba(184,0,0,1)'
            }
          },
          virtualPoint: {
            normal: {
              backgroundColor: 'rgba(0, 0, 0, 0)',
              borderWidth: 1,
              borderColor: 'rgba(0,131,238, 1)',
              size: 3
            },
            mouseOver: {
              backgroundColor: 'rgba(0, 0, 0, 0)',
              borderWidth: 2
            }
          },
          polygon: {
            normal: {
              borderWidth: 1.5,
              backgroundColor: 'rgba(0,184,255,0.3)'
            }
          }
        },
        event: {
          onCreated (event) {
            console.log('onCreate', event)
          },
          onChange (type, event) {
            console.log('onChange', type, event)
          },
          onDelete (event) {
            console.log('onDelete', event)
          }
        }
      })
      this.inmap.add(this.overlay)
    })
  },
  methods: {
    createPath () {
      this.overlay.create()
    },
    getPath () {
      const pathData = this.overlay.getPath()
      alert(JSON.stringify(pathData))
      return pathData
    },
    setPath () {
      const bdary = new BMap.Boundary()
      const name = '上海市普陀区'
      // 获取行政区域
      bdary.get(name, rs => {
        console.log(rs)
        // 行政区域的点有多少个
        const count = rs.boundaries.length
        const mapData = []
        for (let i = 0; i < count; i++) {
          const ply = new BMap.Polygon(rs.boundaries[i], {
            strokeWeight: 2,
            strokeColor: '#ff0000'
          })
          const points = []
          ply.getPath().forEach(point => {
            points.push([point.lng, point.lat])
          })
          mapData.push(points)
        }
        this.overlay.setPath({
          geometry: {
            type: 'MultiPolygon',
            coordinates: [mapData]
          }
        })
      })
    },
    changeEditStatus () {
      this.isEdit = !this.isEdit
      return this.isEdit ? this.overlay.enableEditing() : this.overlay.disableEditing()
    }
  }
}
</script>

<style lang="scss" scoped>
.inmap {
  .map {
    width: 100%;
    height: 100%;
    min-width: 200px;
    min-height: 200px;
  }
  .button-group {
    margin-top: 20px;
    margin-bottom: 20px;
  }
  Button {
    margin-right: 10px;
  }
}
</style>
