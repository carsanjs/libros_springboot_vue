<script>
import Sesion from '../components/Sesion.vue';
export default {
    data() {
        return {
            Logo:"Boquer",
            inicio:"Inicio",
            
        }
    },
    components:{
        Sesion,
    }
    
}
</script>

<template>
     <header class="header">

<div class="header-1">    
    <a href="#" class="logo"> <i class="fas fa-book"></i>{{Logo}} </a>
</div>

<div><div class="header-2">
      <nav class="navbar">
        <router-link to="/">{{inicio}}</router-link>
      </nav>
    </div></div>

</header> 
<div class="contentdiv-f">
<main class="contenmain-from contenmain-f">
    <Sesion></Sesion>
</main>
</div>
   
</template>