function cargarDocentes() {

  // ocultar historial
  document.getElementById("historial").style.display = "none";

  // mostrar docentes
  document.getElementById("lista-docentes").style.display = "block";

  fetch("http://localhost:8080/docentes")
    .then(res => res.json())
    .then(data => {

      let tabla = document.getElementById("tabla-docentes");
      tabla.innerHTML = "";

      data.forEach(d => {
        tabla.innerHTML += `
          <tr>
            <td>${d.dni}</td>
            <td>${d.nombre}</td>
            <td>${d.apellidos}</td>
            <td>${d.curso}</td>
          </tr>
        `;
      });

    });
}
function mostrarHistorial() {

  document.getElementById("historial").style.display = "block";
  document.getElementById("lista-docentes").style.display = "none";

}
