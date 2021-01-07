<template>
  <div>
    <header class="jumbotron">
      <h3>{{content}}</h3>
    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Menu',
  data () {
    return {
      content: ''
    }
  },
  mounted () {
    this.getAll()
  },
  methods: {
    getAll () {
      MenuService.getAll().then(
        response => {
          console.log()
          this.content = response.data
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        }
      )
    }
  }
}
</script>

<style scoped>

</style>
