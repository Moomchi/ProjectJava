<template>
  <div id="app">
    <div id="nav">
      <b-navbar-brand>
        <img src="./assets/logo1.jpg" align="left" a height="100" width="150"
             style="margin:-60px -40px"
      /></b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <router-link to="/">Home</router-link>
          <router-link to="/about">About</router-link>
          <router-link to="/deals">Deals</router-link>
          <router-link to="/burger">BURGER</router-link>
          <router-link to="/pizza">PIZZA</router-link>
          <router-link to="/salad">SALAD</router-link>
          <router-link to="/dessert">DESSERT</router-link>
          <router-link to="/drink">DRINK</router-link>
          <router-link to="/sauce">SAUCE</router-link>
          <router-link to="/cart"><img src="./assets/cart.png" height="37" width="40" align="rightUp" border="grooved"/></router-link>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <router-link to="/orders">Моите поръчки</router-link>
        </b-navbar-nav>
          <router-view/>
      </b-collapse>
  </div>
  </div>
</template>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 50px;
  color: coral;
  background-color: #1b95e0;
}

#nav a {
  padding: 10px;
  margin: 10px;
  font-weight: bold;
  border-style: groove;
  border-color: crimson;
  background-color: crimson;
  color: black;
}

#nav a.router-link-exact-active {
  color:blue;
}
</style>
