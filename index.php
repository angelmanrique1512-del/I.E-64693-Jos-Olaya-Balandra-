<?php

class Router
{
    public function run()
    {
        $url = filter_input(INPUT_GET, 'url', FILTER_SANITIZE_URL);
        $url = $url ?: 'Home';
        $params = explode('/', trim($url, '/'));

        $controllerName = ucfirst($params[0]) . 'Controller';
        $method = $params[1] ?? 'index';

        $file = __DIR__ . '/../controllers/' . $controllerName . '.php';

        if (!file_exists($file)) {
            $this->notFound();
        }

        require_once $file;

        if (!class_exists($controllerName)) {
            $this->notFound();
        }

        $controller = new $controllerName();

        if (!method_exists($controller, $method) || !is_callable([$controller, $method])) {
            $this->notFound();
        }

        $controller->$method();
    }

   protected function notFound()
{
    header('HTTP/1.0 404 Not Found');

    echo "<h1>404 - Página no encontrada</h1>";
    echo "<a href='" . BASE_URL . "/home'>Volver al inicio</a>";

    exit;
}
}
