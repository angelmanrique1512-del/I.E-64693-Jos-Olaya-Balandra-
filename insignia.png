<?php
$asistencias = $asistencias ?? [];
?>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTEMA JOSE OLAYA</title>

    <link rel="stylesheet"
      href="<?= BASE_URL ?>/public/css/style.css">

</head>

<body>

    <div class="navbar">

        <h2>
            I.E. 64693 JOSE OLAYA BALANDRA
        </h2>

        <div>

            DIRECTORA:
            <?= $_SESSION['user'] ?>

            |

            <a href="<?= BASE_URL ?>/login/logout"
               style="color:white;">

               Cerrar Sesión

            </a>

        </div>

    </div>


    <div class="sidebar">

        <div class="menu-item">

            <a href="#">
                OPCIONES ▼
            </a>

            <div class="submenu">

                <a href="#"
                   onclick="openModal('lista')">

                    LISTA DE DOCENTES

                </a>

            </div>

        </div>

    </div>

    <div class="main-content">

        <div class="card-registro">

            <h1 style="color:#1a5276;">

                INGRESA TU DNI

            </h1>

            <form action="<?= BASE_URL ?>/dashboard/marcar"
                  method="POST">

                <input type="text"
                       name="dni"
                       class="dni-input"
                       placeholder="00000000"
                       maxlength="8"
                       required>

                <button type="submit"
                        class="btn-submit">

                    REGISTRAR ASISTENCIA

                </button>

            </form>

        </div>


      
<div class="tabla-box">

    <h2 class="titulo-registros">
        REGISTROS DE ASISTENCIA
    </h2>

    <table>

        <thead>

            <tr>

                <th>Nombre</th>
                <th>Fecha</th>
                <th>Estado</th>

            </tr>

        </thead>

        <tbody>

            <?php foreach ($asistencias as $a): ?>

                <tr>

                    <td><?= $a['nombre'] ?></td>

                    <td><?= $a['fecha'] ?></td>

                    <td><?= $a['estado'] ?></td>

                </tr>

            <?php endforeach; ?>

        </tbody>

    </table>

</div>

    </div>

    
    <div id="modalBox"
         class="modal">

        <div class="modal-content">

            <h2 id="modalTitle"></h2>

            <div id="modalBody"></div>

            <br>

            <button onclick="
                document.getElementById('modalBox').style.display='none'
            ">

                Cerrar

            </button>

        </div>

    </div>

    <script>

    const docentes = <?= json_encode($docentes) ?>;

    function openModal(type)
    {
        document.getElementById('modalBox').style.display =
            'block';

        if(type == 'lista')
        {
            document.getElementById('modalTitle').innerText =
                'Lista de Docentes';

            let html = `
                <table class="tabla-modal">

                    <tr>
                        <th>DNI</th>
                        <th>NOMBRE</th>
                        <th>ESPECIALIDAD</th>
                    </tr>
            `;

            docentes.forEach(d => {

                html += `
                    <tr>
                        <td>${d.dni}</td>
                        <td>${d.nombre}</td>
                        <td>${d.especialidad}</td>
                    </tr>
                `;
            });

            html += `</table>`;

            document.getElementById('modalBody').innerHTML =
                html;
        }
    }

    </script>

</body>

</html>