<template>
  <div>
    <header class="jumbotron">
      <h3>Total items: {{this.rows}}</h3>
      <b-table
        id="burgerTable"
        striped
        hover
        dark
        bordered
        :items="deals"
        :fields="fields"
        :current-page="currentPage"
        :per-page="0"
      >
        <template v-slot:cell(pizzaId)="data">
          <div v-if="data.item.pizza !== null">
            {{ data.item.pizza.pizzaName }}
          </div>
        </template>
        <template v-slot:cell(burgerId)="data">
          <div v-if="data.item.burger !== null">
            {{ data.item.burger.burgerName }}
          </div>
        </template>
        <template v-slot:cell(saladId)="data">
          <div v-if="data.item.salad !== null">
          {{ data.item.salad.saladName }}
          </div>
        </template>
        <template v-slot:cell(dessertId)="data">
          <div v-if="data.item.dessert !== null">
            {{ data.item.dessert.dessertName }}
          </div>
        </template>
        <template v-slot:cell(drinkId)="data">
          <div v-if="data.item.drink !== null">
            {{ data.item.drink.drinkName }}
          </div>
        </template>
      </b-table>
    </header>
  </div>
</template>

<script>
import MenuService from '../services/menu-service'

export default {
  name: 'Deals',
  data () {
    return {
      content: '',
      deals: '',
      fields: [
        { key: 'id', label: 'Номер' },
        { key: 'pizzaId', label: 'Пица' },
        { key: 'burgerId', label: 'Бургер' },
        { key: 'saladId', label: 'Салата' },
        { key: 'dessertId', label: 'Десерт' },
        { key: 'drinkId', label: 'Напитка' },
        { key: 'price', label: 'Цена' },
        { key: 'choose', label: '' }
      ],
      currentPage: '',
      perPage: 5,
      rows: ''
    }
  },
  mounted () {
    this.getAll()
  },
  methods: {
    getAll () {
      MenuService.getAllDeals().then(
        response => {
          this.deals = response.data
          this.rows = response.data.length
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
