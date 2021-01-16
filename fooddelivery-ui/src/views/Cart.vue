<template>
    <div>
      <header class="jumbotron">
        <h3>Вашата количка</h3>
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
          <template v-slot:cell(choose)="{ item }">
            <b-button variant="secondary" v-on:click="deleteProductFromCart(item.id)" type="button">Изтрий</b-button>
          </template>
        </b-table>
        <b-button variant="secondary" v-on:click="deleteProductFromCart(item.id)">Запази</b-button>
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
      id: '',
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
    },
    deleteProductFromCart (id) {
      MenuService.deleteProductFromCart(id).then(
        response => {
          console.log('Работи бе майкати ти да еба')
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
