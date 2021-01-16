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
       :items="burgers"
       :fields="fields"
       :current-page="currentPage"
       :per-page="0"
       >
        <!--
         <template>
        <input class="form-control" type="text" placeholder="Search" aria-label="Search"/>
      </template>

        <template>
          <v-container class="grid-list-xl">
            <td v-for="(burger,index) in burgers" :key="burger.id">
              <div class="card text-white bg-dark col-lg-4" style="max-width: 15rem;">
                <div class="card-header">{{burger.burgerName}}</div>
                <div class="card-body">
                  <p class="card-text">
                    {{burger.price}} лв.
                  </p>
                  <input v-model="quantities[index]" placeholder="Попълни ме" type="number">
                  <div slot="chosen">
                    <button v-on:click="saveProduct(quantities[index],burger.id)">Добави</button>
                  </div>
                </div>
              </div>
            </td>
          </v-container>
        </template>
        -->
         <template slot="top-row" slot-scope="{ fields }">
           <td v-for="(field, index) in fields" :key="field.id">
             <div v-if="index !== 0">
             </div>
             <div v-else>
               <input v-model="name" :placeholder="field.label">
               <input v-model="quantities[index]" placeholder="Попълни ме" type="number">
             </div>
           </td>
         </template>

         <template v-slot:cell(choose)>
           <input v-model="quantities[index]" placeholder="Попълни ме" type="number">
           <button v-on:click="saveProduct(quantities[index],burger.id)">Избери</button>
         </template>
       </b-table>
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
      quantities: [],
      added: {
        id: '',
        num: 0,
        productId: '',
        quantity: '',
        customerId: 5
      },
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
