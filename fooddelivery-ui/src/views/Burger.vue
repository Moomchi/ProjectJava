<template>
  <div>
  <header class="jumbotron">
    <h3>Total items: {{this.rows}}</h3>
    <template>
      <div class="card text-white bg-dark mb-3" style="max-width: 20rem;">
        <div class="card-header">Your cart</div>
        <div class="card-body">
          <p class="card-text"
               v-for="burger in burgers" :key="burger.id">
            • {{burger.burgerName}} - {{burger.price}}лв.
          </p>
        </div>
      </div>
    </template>
    <template>
      <v-container grid-list>
      <td v-for="burger in burgers" :key="burger.id">
      <div class="card text-white bg-dark col-lg-4" style="max-width: 15rem;">
        <div class="card-header">{{burger.burgerName}}</div>
        <div class="card-body">
          <p class="card-text">
            {{burger.price}} лв.
          </p>
          <div slot="chosen">
            <button v-on:click="saveProduct">Add</button>
          </div>
        </div>
      </div>
      </td>
      </v-container>
    </template>

   <!-- <b-table
    id="burgerTable"
    striped
    hover
    dark
    bordered
    :items="burgers"
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

      <template v-slot:cell(choose)>
        <button v-on:click="saveProduct">Избери</button>
      </template>

    </b-table>
    -->

    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      @input="getProductsPage"
      aria-controls="burgerTable"
    ></b-pagination>
    <button v-on:click="getProductsPage">Търси</button>

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
      burgers: '',
      added: '',
      fields: [
        { key: 'burgerName', label: 'Име' },
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
    },
    saveProduct () {
      MenuService.saveProduct(5, 0, 7, 2).then(
        response => {
          this.added = response.data.productList
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
