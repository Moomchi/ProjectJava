<template>
    <div>
      <header class="jumbotron">
        <h3>Вашата количка</h3>
        <template>
          <label>Въведете име:
            <input v-model="name">
          </label>
        </template>
        <template>
          <div>
            <b-alert
              variant="danger"
              dismissible
              fade
              :show="showDismissibleAlert"
              @dismissed="showDismissibleAlert=false"
            >
              {{ 'Вашият код за проверка на поръчка е:' + this.id }}
            </b-alert>
          </div>
        </template>
        <b-button variant="secondary" v-on:click="saveOrder(name);showDismissibleAlert=true" type="button">Направи поръчка</b-button>
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
      showDismissibleAlert: false,
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
      added: {
        id: '',
        customerName: '',
        customerId: 5
      },
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
    },
    saveOrder (name) {
      this.added.customerName = name
      MenuService.saveOrder(this.added).then(
        response => {
          this.id = response.data.id
          console.log(this.id)
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        })
    }
  }
}
</script>

<style scoped>

</style>
