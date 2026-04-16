const API = "http://localhost:8080/asistencia";

function cargarAsistencia() {
  fetch(API)
    .then(res => res.json())
    .then(data => {
      const tabla = document.getElementById("tabla-asistencia");
      tabla.innerHTML = "";
      data.forEach(a => {
        tabla.innerHTML += `
          <tr>
            <td>${a.dni}</td>
            <td>${a.nombre} ${a.apellidos || ""}</td>
            <td>${a.curso}</td>
            <td>${a.fecha}</td>
            <td>${a.hora_entrada || "-"}</td>
            <td>${a.estado || "Pendiente"}</td>
          </tr>
        `;
      });
    });
}

function registrar() {
  const dni = document.getElementById("dni").value;
  fetch(API + "/registrar", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({ dni })
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("mensaje").innerText = data.mensaje;
    cargarAsistencia();
  });
}

document.addEventListener("DOMContentLoaded", cargarAsistencia);
