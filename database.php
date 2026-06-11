<?php

require_once __DIR__ . '/../../config/database.php';

class AsistenciaModel
{
    private $db;

    public function __construct()
    {
        $this->db = Database::connect();
    }

    // obtener asistencias
    public function getAll()
    {
        $stmt = $this->db->query("
            SELECT * FROM asistencia
            ORDER BY id DESC
        ");

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

   // insertar asistencia
public function insert($nombre, $dni)
{
    $estado = "TEMPRANO";

    if(date('H') >= 7)
    {
        $estado = "TARDE";
    }

    $stmt = $this->db->prepare("
        INSERT INTO asistencia(nombre,dni,fecha,estado)
        VALUES (?, ?, CURDATE(), ?)
    ");

    return $stmt->execute([
        $nombre,
        $dni,
        $estado
    ]);
}

    // buscar docente por dni
    public function getDocenteByDni($dni)
    {
        $stmt = $this->db->prepare("
            SELECT * FROM docentes
            WHERE dni = ?
        ");

        $stmt->execute([$dni]);

        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    // obtener docentes
    public function getDocentes()
    {
        $stmt = $this->db->query("
            SELECT * FROM docentes
            ORDER BY nombre ASC
        ");

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}