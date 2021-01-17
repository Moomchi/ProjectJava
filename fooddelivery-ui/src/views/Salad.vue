<template>
  <div>
    <header class="jumbotron">
      <b-table
        id="saladTable"
        striped
        hover
        dark
        bordered
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
              <div></div>
              <b-button variant="secondary" v-on:click="getProductsPage">Търси</b-button>
            </div>
          </td>
        </template>
      </b-table>
      <template>
        <v-container class="grid-list-xl">
          <td v-for="(salad,index) in salads" :key="salad.id">
            <div class="card text-white bg-dark col-lg-4" style="max-width: 15rem;margin: 4px">
              <div class="card-header">{{salad.saladName}}</div>
              <img src="../assets/salad.jpg" height="200" width="200" />
              <div class="card-body">
                <p class="card-text">
                  {{salad.price}} лв.
                </p>
                <input v-model="quantities[index]" placeholder="Попълни ме" type="number">
                <div slot="chosen">
                  <b-button variant="secondary" v-on:click="saveProduct(quantities[index],salad.id)">Добави</b-button>
                </div>
              </div>
            </div>
          </td>
        </v-container>
      </template>
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        @input="getProductsPage"
        aria-controls="saladTable"
      ></b-pagination>
      <h3>Total items: {{this.rows}}</h3>

    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Salad',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      salads: '',
      quantities: [],
      added: {
        id: '',
        num: 2,
        productId: '',
        quantity: '',
        customerId: 5
      },
      fields: [
        { key: 'saladName', label: 'Търси по име:' }
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
      MenuService.getProductById(2, 4).then(
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
      MenuService.getProductAll(2).then(
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
      MenuService.getProductsPage(this.name, this.currentPage, this.perPage, 2).then(
        response => {
          this.salads = response.data.products
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
    saveProduct (quantities, productID) {
      this.added.quantity = quantities
      this.added.productId = productID
      MenuService.saveProduct(this.added).then(
        response => {
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
