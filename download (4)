<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>
        Login
    </title>

    <link rel="stylesheet"
          href="<?= BASE_URL ?>/public/css/style.css">

</head>

<body class="login-page">

    <div class="login-container">

        <div class="login-card">

            <img src="<?= BASE_URL ?>/public/img/insignia.png"
                 class="login-logo">

            <h1>
                SISTEMA DE ASISTENCIA
            </h1>

            <p>
                I.E. JOSE OLAYA BALANDRA
            </p>
            <?php if(isset($error)): ?>

    <div class="error-message">
    Usuario o contraseña incorrecta
</div>
<?php endif; ?>

            <form action="<?= BASE_URL ?>/login/auth"
                  method="POST">

                <input type="text"
                       name="usuario"
                       placeholder="Usuario"
                       required>

                <input type="password"
                       name="password"
                       placeholder="Contraseña"
                       required>

                <button type="submit">

                    INGRESAR

                </button>

            </form>

        </div>

    </div>

</body>

</html>