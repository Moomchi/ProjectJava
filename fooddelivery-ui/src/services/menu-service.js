import axios from 'axios'

const API_URL = 'http://localhost:8080/menu'

class MenuService {
  getAllDeals () {
    return axios.get(API_URL + '/all/deals')
  }

  getAll () {
    return axios.get(API_URL + '/all')
  }

  getProductsPage (name, currentPage, perPage, num) {
    return axios.get(API_URL + '/product/search/page',
      {
        params:
          {
            name: name,
            currentPage: currentPage,
            perPage: perPage,
            num: num
          }
      }
    )
  }

  getProductById (num, id) {
    return axios.get(API_URL + '/product/search/id',
      {
        params:
          {
            num: num,
            id: id
          }
      })
  }

  getProductAll (num) {
    return axios.get(API_URL + '/product/search/all',
      {
        params:
          {
            num: num
          }
      })
  }

  saveProduct (customerId, num, productId, quantity) {
    return axios.post(API_URL + '/products/save',
      {
        params:
          {
            customerId: customerId,
            num: num,
            productId: productId,
            quantity: quantity
          }
      })
  }
}

export default new MenuService()
