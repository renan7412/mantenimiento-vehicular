// Llamar a los complementos jQuery en la tabla de datos " funcionalidad para la paginación"

$(document).ready(function () {

    cargarUsuarios();

    $('#usuarios').DataTable();
});

async function cargarUsuarios(){

    // Función fetch

        const request= await fetch('usuarios', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

        });
        const usuarios = await request.json();

        let listadoHtml = "";  // Variable para guardar a cada usuario
        for (let usuario of usuarios){

            /* Selector de objetos (Usuario) o modificar al objeto, cuando se actualiza la página cargara al objeto (usuario)*/
            let usuarioHtml =  "<tr><td>"+ usuario.id +"</td>\n" +
                                        "<td>"+ usuario.nombre +" " + usuario.apellido + "</td>\n" +
                                        "<td>"+ usuario.email +"</td>\n" +
                                        "<td>"+ usuario.telefono +"</td>\n" +
                                        "<td>"+ Rol +"</td>\n" +
                                        "<td>\n" +
                                            <a href="#" className="btn btn-danger btn-circle btn-sm">
                                                <i className="fas fa-trash"></i>
                                            </a> +
                                        "</td>\n" +
                                    "</tr>\n";
            listadoHtml += usuarioHtml;  // Asignamos a cada usuario en esta variable
        }

        console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}