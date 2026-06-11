<?php

require_once __DIR__ . '/../models/AsistenciaModel.php';

class DashboardController
{
    private $model;

    public function __construct()
    {
        $this->model = new AsistenciaModel();
    }

    public function index()
    {
        if (!isset($_SESSION['user']))
        {
            header('Location: ' . BASE_URL . '/login');
            exit;
        }

        $asistencias = $this->model->getAll();

        $docentes = $this->model->getDocentes();

        require_once __DIR__ . '/../views/dashboard/index.php';
    }

    public function marcar()
    {
        $dni = $_POST['dni'];

        $persona = $this->model->getDocenteByDni($dni);

        if (!$persona)
        {
            die("DNI NO ENCONTRADO");
        }

        $this->model->insert(
            $persona['nombre'],
            $dni,
            'PRESENTE'
        );

        header('Location: ' . BASE_URL . '/dashboard');
        exit;
    }
}