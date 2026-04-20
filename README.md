# I.E-64693-Jos-Olaya-Balandra-
<img width="354" height="372" alt="image" src="https://github.com/user-attachments/assets/d53fc02e-cf50-4470-89f1-725e12365176" />

## SOTFWARE DE ACISTENCIA DE DOCENTES

INTRUDUCCIÓN 
EL SOTFWARE ES PARA EL USO EN LA ASISTENCIA DE PROFESORES DE LA I.E JOSE OLAYA BALANDRA CON EL FIN DE MEJORAR EL CONTROL DE DOCENTES EN EL AÑO ESCOLAR FOBORECIENDO ASI SU TRABAJO Y VIENESTAR DE LA INSTITUCIÓN.


## DESCRIPCIÓN DEL ESTABLECIMIENTO
NOMBRE: I.E. 6469.Jose Olaya Balandra
RUBRO: SERVICIOS EDUCATIVOS DENTRO DEL SECTOR SERVICIOS DEDICÁNDOCE A LA ENSEÑANZA, ENTRENAMIENTO Y FORMACIÓN ACADEMICA EN NIVELES INICIAL, PRIMARIA Y SECUNDARIA.
TAMAÑO: MEDIANO
JUSTIFICACIÓN: HACE FALTA UN SISTEMA DE ASISTENCIA PARA LOS DOCENTES DE NIVEL SECUNDARIA.

## PROBLEMÁTICA 
LA DIRECTORA DE LA I.E. JOSE OLAYA PRESENTA DIFICULTADES EN EL CONTROL DE ASISTENCIA DE LOS DOCENTES, YA QUE ACTUALMENTE EL REGISTRO SE REALIZA DE MANERA MANUAL MEDIANTE FIRMAS EN CUADERNOS O LISTAS.
ESTE METODO A GENERADO ERRORES EN EL REGISTRO DE TARDANZA Y INASISTENCIAS.
POSIBLES SUPLANTACIÓN DE IDENTIDAD AL FIRMAR POR OTRO DOCENTE.
PERDIDA DE TIEMPO O FALTA DE INFORMACIÓN INMEDIATA SOBRE QUE DOCENTES ASISTIERON.
POR ESTE CASO LA DIRECTORA CONSIDERA IMPLEMENTAR ESTE SISTEMA PARA MEJORAR EL CONTROL DE SUS DOCENTES.

## SOLUCIÓN
EL SOTFWARE ES PARA LA ASISTENCIA DE PROFESORES DE LA I.E JOSE
OLAYA BALANDRA POR MEDIO DE SU NUMERO DE DNI CON EL FIN DE
MEJORAR EL CONTROL DE DOCENTES EN EL AÑO ESCOLAR FOBORECIENDO
ASI SU TRABAJO Y VIENESTAR DE LA INSTITUCIÓN.

## Requerimientos Funcionales
| Codigo | Descripcion |
|---|---|
| RF01 |el sistema debe permitir registrar asistencia de docentes mediante DNI.|
| RF02 |debe validar si el DNI pertenece a un docente registrado.|
| RF03 |puede evitar duplicidad de asistencia en el mismo día.|
| RF04 |el sistema debe registrar fecha y hora automáticamente.|
| RF05 |el sistema debe mostrar historial de asistencia.|
| RF06 |El sistema debe ser rápido menos de 10 segundos.|

## Requerimientos no Funcionales
| Codigo | Descripcion |
|---|---|
| RNF01 |Debe ser fácil de usar interfaz simple.|
| RNF02 |Debe garantizar seguridad de datos.|
| RNF03 |Debe estar disponible en horario escolar.|

##Modelo relacional

<img width="847" height="428" alt="image" src="https://github.com/user-attachments/assets/ccaaaf0e-e9bf-4131-8c1e-913fb2e03c2e" />

##Modelo Entidad-Relación (MER)

<img width="1035" height="553" alt="image" src="https://github.com/user-attachments/assets/d5941ff5-328d-4680-88ed-7c3da5eb276e" />


CARDINALEDAD:  DOCENTE (1): (N) ASISTENCIA
```sql
##SQL – Creación de tablas (DDL)
CREATE DATABASE registro;
USE registro;

CREATE TABLE Docente (
    dni CHAR(8) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    curso VARCHAR(50)
);

CREATE TABLE Asistencia (
    id_asistencia INT AUTO_INCREMENT PRIMARY KEY,
    dni CHAR(8) NOT NULL,
    fecha DATE NOT NULL,
    hora_entrada TIME,
    hora_salida TIME,
    estado VARCHAR(15),
    FOREIGN KEY (dni) REFERENCES Docente(dni),
    UNIQUE (dni, fecha)
);
```

---

##SQL – Inserción y consultas (DML)
```sql
INSERT INTO Docente VALUES 
('00000001', 'Luis', 'Ramirez', 'EPT'),
('00000002', 'Maria', 'Lopez', 'Ciencia'),
('00000003', 'Carlos', 'Perez', 'Matemática'),
('00000004', 'Ana', 'Torres', 'Inglés'),
('00000005', 'Jorge', 'Castro', 'Comunicación'),
('00000006', 'Lucia', 'Vargas', 'Arte'),
('00000007', 'Pedro', 'Rojas', 'Física'),
('00000008', 'Sofia', 'Mendoza', 'DPCC');


INSERT INTO Asistencia (dni, fecha, hora_entrada, estado) VALUES
('00000001', '2026-03-21', '06:50:00', 'Temprano'),
('00000002', '2026-03-21', '07:30:00', 'Tardanza'),
('00000003', '2026-03-22', NULL, 'Falta');

UPDATE Asistencia 
SET estado = 'Temprano'
WHERE id_asistencia > 0 AND hora_entrada < '07:10:00';

UPDATE Asistencia 
SET estado = 'Tardanza'
WHERE id_asistencia > 0 AND hora_entrada >= '07:10:00';

UPDATE Asistencia 
SET estado = 'Falta'
WHERE id_asistencia > 0 AND hora_entrada IS NULL;


```

---
##DISEÑO FIGMA MOVILE

<img width="1108" height="932" alt="image" src="https://github.com/user-attachments/assets/0bda9004-a4d1-4f4b-a372-64c116d3a2ae" />
<img width="1063" height="811" alt="image" src="https://github.com/user-attachments/assets/a5772afb-4547-490c-9986-bd7ee1cca937" />

##ENLACE DE FIGMA



https://www.figma.com/design/ALETE11U7srpZnlilG9nst/Sin-t%C3%ADtulo?m=auto&t=5i0AwE4Cg0nMOr6Y-6



