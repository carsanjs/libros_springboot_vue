<script>
export default {
  data() {
    name: "Sesion";
    return {
      correo: "",
      contrasena: "",
    };
  },
  methods: {
    InicioLogin: async function () {
      try {
        var endpoint =
          "http://localhost:8080/usuarios/login/" +
          this.correo +
          "/" +
          this.contrasena;
        var opciones = { method: "GET" };
        fetch(endpoint, opciones)
          .then(async (response) => {
            const respuesta = await response.json();
            if (respuesta.length >= 1) {
              Swal.fire({
                width: 300,
                icon: "success",
                title: "Correcto",
                text: "Usuario Registrado",
                showConfirmButton: false,
                timer: 500,
              });
              this.$router.push("/crud");
            } else if (!respuesta.length) {
              Swal.fire({
                width: 300,
                icon: "question",
                title: "Error",
                text: "Usuario no encontrado",
                showConfirmButton: false,
                timer: 500,
              });
            } else
              Swal.fire({
                width: 300,
                icon: "error",
                title: "Error",
                text: "Usuario o Clave Incorrectos",
                showConfirmButton: false,
                timer: 2000,
              });
            // console.log(response)
          })
          .then((data) => data)
          .catch((error) => console.log(error));
      } catch (error) {
        Swal.fire({
          width: 300,
          icon: "warning",
          text: "A Ocurrido un error, verifique el Servidor",
          showConfirmButton: false,
          timer: 2000,
        });
      }
    },
  },
};
</script>


<template>
  <form action="" class="styl-form" method="GET" @submit.prevent="InicioLogin">
    <h3 class="h3classsesion">iniciar sesión</h3>
    <div class="class-content-from">
      <div class="classflex classinput">
        <input
          type="email"
          name="correo"
          class="box"
          v-model="correo"
          placeholder="Correo"
          id="correo"
          required
        />
        <input
          type="password"
          name="contrasena"
          class="box"
          v-model="contrasena"
          placeholder="Contraseña"
          id="contrasena"
          autocomplete="off"
          required
        />
      </div>

      <div class="divinputbtn">
        <input type="submit" value="Iniciar Sesion" class="btn" />
      </div>

      <div class="classflex classp">
        <p class="pp">Olvidaste tu Contraseña?<a href="#">Clik Aqui</a></p>
        <p class="pp">
          No tienes cuenta?
          <router-link to="/registro">Registrarse</router-link>
          <!-- <a href="register.html"></a> -->
        </p>
      </div>
    </div>
  </form>
</template>