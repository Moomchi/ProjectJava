<template>
  <div>
    <header class="jumbotron">
      <h3>Total items: {{this.rows}}</h3>
      <button v-on:click="getProductsPage">Търси</button>
      <b-table
        id="sauceTable"
        striped
        hover
        dark
        bordered
        :items="sauces"
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
        aria-controls="sauceTable"
      ></b-pagination>

    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Sauce',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      sauces: '',
      fields: [
        { key: 'sauceName', label: 'Име' },
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
      MenuService.getProductById(5, 4).then(
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
      MenuService.getProductAll(5).then(
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
      MenuService.getProductsPage(this.name, this.currentPage, this.perPage, 5).then(
        response => {
          this.sauces = response.data.products
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
