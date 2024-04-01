
<script>
export default{

  data() {
    return {
      buscar:'',
      id:'',
      isbn:'',
      nombre:'',
      autor:'',
      genero:'',
      fecha_publicacion:'',
      precio:'',
      i:-1,
     alumnos:[]
    }
  },
  computed:{
    lista(){
      return this.alumnos.filter(alumno=>alumno.nombre.toUpperCase().includes(this.buscar.toUpperCase()))
    }
  },

  // if(this.i===-1){
  //           this.alumnos.push({nombre:this.nombre, edad:this.edad})          
  //       }
      
  methods:{
    RegistrarLibro() {
      if(this.id!=='' && this.isbn!=='' && this.nombre!=='' && this.autor!=='' && this.genero!=='' && this.fecha_publicacion!=='' && this.precio!==''){
        if(this.i===-1){

      var endpoint = "http://localhost:8080/Libros/guardar";
      var opciones = {
        method: "POST",
        headers: { "Content-type": "Application/json" },
        body: JSON.stringify({
          id: this.id,
          isbn: this.isbn,
          nombre: this.nombre,
          autor: this.autor,
          genero: this.genero,
          fecha_publicacion: this.fecha_publicacion,
          precio: this.precio,
        }),
      };
      fetch(endpoint, opciones).then(async (Response) => {
        try {    
            Swal.fire({
              icon: "question",
              title: "Desea Registrar Libro?",
              showDenyButton: true,
              showCancelButton: false,
              confirmButtonText: "Registrar",
              denyButtonText: `Cancelar`,
            }).then((result) => {
              if (result.isConfirmed) {
                if (Response.status)
                Swal.fire("Guardado con exito", "", "success");
                // this.$router.push("/");
              } else if (result.isDenied) {
                Swal.fire("Los cambios no se guardaron", "", "warning");
                return false;
              }
            });
          } catch (error) {
          return '{"sucess":false ,"message":"Error al intentar registrar."}';
        }
      });
        }
        else{
           this.alumnos[this.i].id= this.id;
           this.alumnos[this.i].isbn = this.isbn;
           this.alumnos[this.i].nombre= this.nombre;
           this.alumnos[this.i].autor = this.autor;
           this.alumnos[this.i].genero= this.genero;
           this.alumnos[this.i].fecha_publicacion = this.fecha_publicacion;
           this.alumnos[this.i].precio = this.precio;
            this.i = -1;
    }
    this.alumnos.push({
          id: this.id,
          isbn: this.isbn,
          nombre: this.nombre,
          autor: this.autor,
          genero: this.genero,
          fecha_publicacion: this.fecha_publicacion,
          precio: this.precio})

       this.id= '',
       this.isbn='',
       this.nombre='',
       this.nombre = '',
       this.autor = '',
       this.genero = '',
       this.fecha_publicacion='',
       this.precio = ''
       
      }
    },
    remove(){
      // this.alumnos.splice(index,1);
      var endpoint = "http://localhost:8080/Libros/eliminar/" + this.id;
            var opciones = { method: "DELETE" };
            fetch(endpoint, opciones).then(response => response.json())
              .then(data => { 
                this.alumnos = data; console.log(data)
                Swal.fire({
              icon: "question",
              title: "Desea eliminar Libro",
              showDenyButton: true,
              showCancelButton: false,
              confirmButtonText: "Registrar",
              denyButtonText: `Cancelar`,
            }).then((result) => {
              if (result.isConfirmed) {
                if (Response.status)
                Swal.fire("Elimado con exito", "", "success");
                this.Buscar();
                // this.$router.push("/");
              } else if (result.isDenied) {
                Swal.fire("Los cambios no se guardaron", "", "warning");
                return false;
              }
            })
               
              })
               
    },
    update(index){
      this.id = this.alumnos[index].id;
      this.isbn =  this.alumnos[index].isbn;
      this.nombre = this.alumnos[index].nombre;
      this.autor = this.alumnos[index].autor;
      this.genero = this.alumnos[index].genero;
      this.fecha_publicacion = this.alumnos[index].fecha_publicacion;
      this.precio = this.alumnos[index].precio;
      this.i = index; 
    },  
    Actualizar() {
            var endpoint = "http://localhost:8080/Libros/guardar"
            var opciones = {
                method: "POST",
                headers: { "Content-type": "Application/json" },
                body: JSON.stringify({ 
                  id: this.id,
          isbn: this.isbn,
          nombre: this.nombre,
          autor: this.autor,
          genero: this.genero,
          fecha_publicacion: this.fecha_publicacion,
          precio: this.precio
              // id: this.alumnos[index].id, 
              // isbn: this.alumnos[index].isbn, 
              // nombre: this.alumnos[index].nombre,
              // autor: this.alumnos[index].autor, 
              // genero: this.alumnos[index].genero, 
              // fecha_publicacion: this.alumnos[index].fecha_publicacion, 
              // precio: this.alumnos[index].precio, 
             })
            }
            fetch(endpoint, opciones).then(async Response => {
                // alert('Guardado Correctamente');
                try {
                    if (Response.status)
                        Swal.fire({
                            icon: 'question',
                            title: 'Desea Actualizar Libro?',
                            showDenyButton: true,
                            showCancelButton: false,
                            confirmButtonText: 'Actualizar',
                            denyButtonText: `Cancelar`,
                        }).then((result) => {
                            if (result.isConfirmed) {
                                Swal.fire('Actualizado con exito', '', 'success')
                                this.Buscar();

                            } else if (result.isDenied) {
                                Swal.fire('Los cambios no se Actualizaron', '', 'warning')
                                return false
                            }
                        })
                    else {
                        alert("error")
                    }
                } catch (error) {
                    return "{\"sucess\":false ,\"message\":\"Error al intentar actualizar.\"}";
                }
            })
        },
    Buscar() {
            var endpoint = "http://localhost:8080/Libros/ver";
            var opciones = { method: "GET" };
            fetch(endpoint, opciones)
                .then(response => response.json())
                .then(data => { this.alumnos = data; console.log(data) })
        }
  }
}

</script>
<template>

<div id="root" class="container">
  <form @submit.prevent="RegistrarLibro" class="card p-5 formcenter" >
    <p class="text-center">Agregar Libros</p>
    <div class="class-content-from">
      <div class="classflex classinput">
        <div>
          <div v-if="(i===-1)">
          <div class="form-group">
        <input type="text" class="form-control" placeholder="id" v-model="id">
        </div>    
        </div>
        <div v-else>
          <div class="form-group">
        <input type="text" class="form-control" placeholder="id" v-model="id" disabled>
        </div>   
        </div>
        </div> 
        <div class="form-group">
        <input type="text" class="form-control" placeholder="isbn" v-model="isbn" required>
        </div> 
        <div class="form-group">
        <input type="text" class="form-control" placeholder="Nombre" v-model="nombre" required>
       </div>
       <div class="form-group">
      <input type="text" class="form-control" placeholder="Autor" v-model="autor" required>
       </div>
        <div class="form-group">
      <input type="text" class="form-control" placeholder="Genero" v-model="genero" required>
       </div>
        <div class="form-group">
      <input type="text" class="form-control" placeholder="Fecha publicacion" v-model="fecha_publicacion" required>
        </div>
        <div class="form-group">
      <input type="text" class="form-control" placeholder="Precio" v-model="precio" required>
        </div>
     </div>
      <!-- <div class="classflex classinput">  
    </div> -->
    <div>
    <div v-if="i===-1"> 
      <button type="submit" class="btn btn-success"><span >AGREGAR</span> </button> 
    </div>

    <div v-else>
      <button type="submit" class="btn btn-success" v-on:click="Actualizar"><span>Actualizar</span> </button> 
      <button type="submit" class="btn btn-success" v-on:click="remove"><span>Eliminar</span></button>
    </div>
  </div>
  </div>
  </form>
 <div class="divcontsearch divsearpad">
  <input type="text" class="form-control my-3" placeholder="Buscar" v-model="buscar">
  <input type="submit" value="Ver Libros" v-on:click="Buscar">
 </div> 
  <table class="table" v-if="alumnos.length>0">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Isbn</th>
      <th scope="col">Nombre</th>
      <th scope="col">Autor</th>
      <th scope="col">Genero</th>
      <th scope="col">Fecha Publicacion</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
  <tbody>
      <tr v-for="(alumno,index) in lista">
        <td>{{alumno.id}}</td>
        <td>{{alumno.isbn}}</td>
        <td>{{alumno.nombre}}</td>
        <td>{{alumno.autor}}</td>
        <td>{{alumno.genero}}</td>
        <td>{{alumno.fecha_publicacion}}</td>
        <td>{{alumno.precio}}</td>

      <td>
        <!-- <button class="btn btn-danger" @click="remove(index)">Eliminar</button> -->
        <button class="btn btn-success" @click="update(index)">Editar </button>
      </td>
    </tr>
    
  </tbody>
</table>
</div>
  
</template>

<style scoped>
.container{
  display: grid;
  row-gap: 5px;
  grid-template-columns:1fr;
/* background: blue; */
  padding: 5px;
}
.divcontsearch{
  margin:0 auto;
  width: 80%;
 display:flex;
  /* display: block;
   top: 100px;
  position: relative;
  height: 40px;  */
}
.card{
  display:grid;

}
.formcenter{
  text-align: center;
}
.class-content-from {
    /* padding-top: 10px; */
    width: 80%;
    display: grid;
    position: relative;
    margin: 0 auto;
    height: 100%;
}
.classflex.classinput {
    height: 100%;
    width: 100%;
    display: grid;
    /* background: #c13434; */
    height: 100%;
}
.form-control.my-3{
  width: 90%;
  background: #f7f7f7;
  color:black;
  margin: 0.3rem;

}
</style>