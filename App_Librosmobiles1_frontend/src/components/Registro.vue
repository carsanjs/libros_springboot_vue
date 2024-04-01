
<script>
export default {
  data() {
    name: "Registro";
    return {
      id:"",
      nombre: "",
      apellido: "",
      nombre_usuario: "",
      correo: "",
      contrasena: ""
    };
  },
  methods: {
    Registrar() {
      var endpoint = "http://localhost:8080/usuarios/guardar";
      var opciones = {
        method: "POST",
        headers: { "Content-type": "Application/json" },
        body: JSON.stringify({
          id: this.id,
          nombre: this.nombre,
          apellido: this.apellido,
          nombre_usuario: this.nombre_usuario,
          correo: this.correo,
          contrasena: this.contrasena,
        }),
      };
      fetch(endpoint, opciones).then(async (Response) => {
        try {
         
            Swal.fire({
              icon: "question",
              title: "Desea Registrar Usuario?",
              showDenyButton: true,
              showCancelButton: false,
              confirmButtonText: "Registrar",
              denyButtonText: `Cancelar`,
            }).then((result) => {
              if (result.isConfirmed) {
                if (Response.status)
                Swal.fire("Guardado con exito", "", "success");
                this.$router.push("/");
              } else if (result.isDenied) {
                Swal.fire("Los cambios no se guardaron", "", "warning");
                return false;
              }
            });
          // else {
          //   alert("error");
          // }
        } catch (error) {
          return '{"sucess":false ,"message":"Error al intentar registrar."}';
        }
      });
    },
  },
};
</script>

<template>
  <form action="" class="styl-form" method="POST" @submit.prevent="Registrar">
    <h3 class="h3classsesion">Registrate con nosotros</h3>
    <div class="class-content-from">
      <div class="classflex classinput">
        <input
          type="text"
          name="id"
          class="box"
          placeholder="Documento."
          id="id"
          required
          v-model="id"
        />
      </div>
      <div class="classflex classinput">
        <input
          type="text"
          name="nombre"
          class="box"
          placeholder="Nombre"
          id="nombre"
          required
          v-model="nombre"
        />
        <input
          type="text"
          name="apellido"
          class="box"
          placeholder="Apellido"
          id="apellido"
          required
          v-model="apellido"
        />
      </div>
      <div class="classflex classinput">
        <input
          type="text"
          name="nombre_usuario"
          class="box"
          placeholder="Usuario"
          id="nombre_usuario"
          required
          v-model="nombre_usuario"
        />
        <input
          type="email"
          name="correo"
          class="box"
          placeholder="Correo"
          id="correo"
          required
          v-model="correo"
        />
        <input
          type="password"
          name="contrasena"
          class="box"
          placeholder="contrasena"
          id="contrasena"
          required
          autocomplete="off"
          v-model="contrasena"
        />
      </div>

      <div class="divinputbtn">
        <input type="submit" value="Registrarse" class="btn" />
      </div>

      <div class="classflex classp">
        <p class="pp"> Ya tienes cuenta?<router-link to="/sesion">Ingresa Aqui</router-link></p>
      </div>
    </div>
  </form>
</template>