<template>
    <div>
      <header class="jumbotron">
        <h3>Вашата количка</h3>
        <button v-on:click="getCartPage">Търси</button>
        <b-table
          id="productList"
          striped
          hover
          dark
          bordered
          :items="products"
          :fields="fields"
          :current-page="currentPage"
          :per-page="0"
        >
          <template slot="top-row" slot-scope="{ fields }">
            <td v-for="(field, index) in fields" :key="field.id">
              <div v-if="index !== 0">
              </div>
              <div v-else>
                <input v-model="customerId" :placeholder="field.label">
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
          @input="getCartPage"
          aria-controls="productList"
        ></b-pagination>
      </header>
    </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Cart',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      customerId: 5,
      products: '',
      fields: [
        { key: 'productName', label: 'Име' },
        { key: 'quantity', label: 'Количество' },
        { key: 'productsPrice', label: 'Цена' },
        { key: 'choose', label: '' }
      ],
      currentPage: '',
      perPage: 5,
      rows: ''
    }
  },
  mounted () {
    this.getCartPage()
  },
  methods: {
    getCart: function () {
      MenuService.getCart(this.customerId).then(
        response => {
          console.log()
          this.content = response.data
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        })
    },
    getCartPage () {
      MenuService.getCartPage(this.customerId, this.currentPage, this.perPage).then(
        response => {
          this.products = response.data.products
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
    getProductById () {
      MenuService.getProductById(this.fields[0], 4).then(
        response => {
          console.log()
          this.name = response.data
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
