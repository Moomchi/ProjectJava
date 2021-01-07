<template>
  <div>
  <header class="jumbotron">
    <h3>{{message}}</h3>
    <button v-on:click="getProductsPage">Търси</button>
    <b-table
    id="burgerTable"
    striped
    hover
    :items="burgers"
    :fields="fields"
    :current-page="currentPage"
    :per-page="0"
    >
    </b-table>

    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      @input="getProductsPage"
      aria-controls="burgerTable"
    ></b-pagination>

    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Burger',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      burgers: [
        {
          name: '',
          price: ''
        }],
      fields: [
        { key: 'name', label: 'Име' },
        { key: 'price', label: 'Цена' }
      ],
      currentPage: '',
      perPage: 5,
      rows: '',
      filters: [
        {
          name: '',
          price: ''
        }]
    }
  },
  mounted () {
    this.getProductsPage()
  },
  methods: {
    getProductById () {
      MenuService.getProductById(0, 4).then(
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
    },
    getProductAll () {
      MenuService.getProductAll(0).then(
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
    },
    getProductsPage () {
      MenuService.getProductsPage(this.name, this.currentPage, this.perPage, 0).then(
        response => {
          this.burgers = response.data.products
          this.rows = response.data.totalItems
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
