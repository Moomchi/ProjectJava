<template>
  <div>
    <header class="jumbotron">
      <h3>Total items: {{this.rows}}</h3>
      <button v-on:click="getProductsPage">Търси</button>
      <b-table
        id="dessertTable"
        striped
        hover
        dark
        bordered
        :items="desserts"
        :fields="fields"
        :current-page="currentPage"
        :per-page="0"
      >
        <template slot="top-row" slot-scope="{ fields }">
          <td v-for="(field, index) in fields" :key="field.id">
            <div v-if="index !== 0">
            </div>
            <div v-else>
              <input v-model="name" :placeholder="field.label">
            </div>
          </td>
        </template>

        <template v-slot:cell(choose)="data">
          <button v-on:click="(data.item.id)">Избери</button>
        </template>

      </b-table>

      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        @input="getProductsPage"
        aria-controls="dessertTable"
      ></b-pagination>

    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Dessert',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      desserts: '',
      fields: [
        { key: 'dessertName', label: 'Име' },
        { key: 'price', label: 'Цена' },
        { key: 'choose', label: '' }
      ],
      currentPage: '',
      perPage: 5,
      rows: ''
    }
  },
  mounted () {
    this.getProductsPage()
  },
  methods: {
    getProductById () {
      MenuService.getProductById(3, 4).then(
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
      MenuService.getProductAll(3).then(
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
      MenuService.getProductsPage(this.name, this.currentPage, this.perPage, 3).then(
        response => {
          this.desserts = response.data.products
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
