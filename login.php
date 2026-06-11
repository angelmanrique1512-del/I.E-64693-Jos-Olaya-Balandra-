<?php

session_start();

require_once __DIR__ . '/../../config/config.php';
require_once __DIR__ . '/Router.php';

$router = new Router();
$router->run();