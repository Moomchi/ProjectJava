<template>
  <div>
    <header class="jumbotron">
      <h3>Моите поръчки</h3>
      <b-table
        id="orderList"
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
              <input v-model="id" :placeholder="field.label">
            </div>
          </td>
        </template>
      </b-table>
      <b-button variant="secondary" v-on:click="getOrderPage" type="button">Търси</b-button>
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        @input="getOrderPage"
        aria-controls="orderList"
      ></b-pagination>
    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Orders',
  data () {
    return {
      message: '',
      content: '',
      name: '',
      id: '',
      customerId: '',
      products: '',
      fields: [
        { key: 'id', label: '' },
        { key: 'customerName', label: 'Име:' },
        { key: 'orderList', label: 'Поръчка:' },
        { key: 'totalPrice', label: 'Цена:' },
        { key: 'date', label: 'Дата:' }
      ],
      currentPage: '',
      perPage: 5,
      rows: ''
    }
  },
  mounted () {
    this.getOrderPage()
  },
  methods: {
    getOrderPage () {
      MenuService.getOrderPage(this.id, this.currentPage, this.perPage).then(
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
    }
  }
}
</script>

<style scoped>

</style>
