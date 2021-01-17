<template>
  <div id="app">
    <div id="nav">
      <b-navbar-brand style="align-content: flex-start;
      font-family: 'Times New Roman';
      font-weight: Bold;
      font-size: xx-large
      ">МИМИ Фуудс©</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <router-link to="/">НАЧАЛО</router-link>
          <router-link to="/burger">БУРГЕР</router-link>
          <router-link to="/pizza">ПИЦА</router-link>
          <router-link to="/salad">САЛАТА</router-link>
          <router-link to="/dessert">ДЕСЕРТ</router-link>
          <router-link to="/drink">НАПИТКА</router-link>
          <router-link to="/sauce">СОС</router-link>
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
  color: blue;
}

#nav {
  padding: 50px;
  color: black;
  text-align: center;
  background-color: whitesmoke;
}

#nav a {
  padding: 10px;
  margin: 10px;
  font-weight: bold;
  border-style: groove;
  border-color: darkslategray;
  background-color: darkslategray;
  color: black;
}

#nav a.router-link-exact-active {
  background-color: coral;
  color:white;
}
</style>
