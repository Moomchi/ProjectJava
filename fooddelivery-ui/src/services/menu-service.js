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

  saveProduct (form) {
    return axios.post(API_URL + '/products/save',
      {
        id: form.id,
        customerId: form.customerId,
        num: form.num,
        productId: form.productId,
        quantity: form.quantity
      })
  }

  getCart (customerId) {
    return axios.get(API_URL + '/cart',
      {
        params:
          {
            customerId: customerId
          }
      })
  }

  getCartPage (customerId, currentPage, perPage) {
    return axios.get(API_URL + '/cart/page',
      {
        params:
          {
            customerId: customerId,
            currentPage: currentPage,
            perPage: perPage
          }
      })
  }

  deleteProductFromCart (num) {
    return axios.get(API_URL + '/cart/delete',
      {
        params:
          {
            num: num
          }
      })
  }

  getOrderPage (customerId, currentPage, perPage) {
    return axios.get(API_URL + '/orders/page',
      {
        params:
          {
            customerId: customerId,
            currentPage: currentPage,
            perPage: perPage
          }
      })
  }

  saveOrder (form) {
    return axios.post(API_URL + '/orders/save',
      {
        id: form.id,
        customerName: form.customerName,
        customerId: form.customerId
      })
  }
}

export default new MenuService()
