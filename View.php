<?php

require_once __DIR__ . '/../../config/database.php';

class LoginController
{
    public function index()
    {
        require_once __DIR__ . '/../views/auth/login.php';
    }

    public function auth()
{
    $usuario = $_POST['usuario'];
    $password = $_POST['password'];

    $db = Database::connect();

    $stmt = $db->prepare("
        SELECT * FROM usuarios
        WHERE usuario = ?
        AND password = ?
    ");

    $stmt->execute([
        $usuario,
        $password
    ]);

    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    if($user)
    {
        $_SESSION['user'] = $user['nombre_usuario'];

        header('Location: ' . BASE_URL . '/dashboard');
        exit;
    }
    else
    {
        $error = "USUARIO O CONTRASEÑA INCORRECTOS";

        require_once __DIR__ . '/../views/auth/login.php';
    }
}
    public function logout()
    {
        session_destroy();

        header('Location: ' . BASE_URL);
        exit;
    }
}