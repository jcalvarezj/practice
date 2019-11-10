<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de un 
		Estudiante
	*/
	
	class EstudianteDAO extends DAO {

		// Constantes

		define("QCEDULA",0);
		define("QNOMBRE",1);
		define("QAPELLIDO",2);
		define("QEDAD",3);
		define("QGRADO",4);
		define("QTODO",5);

		// Atributos (heredados: $conexion)

        // Metodos

		function __construct($conexion) {
			parent::__construct($conexion);
		}

		function registrar($estudiante) {
			$cedula = $estudiante->getCedula();
			$nombre = $estudiante->getNombre();
			$apellido = $estudiante->getApellido();
			$edad = $estudiante->getEdad();
			$gradoSeccion = explode("-",$estudiante->getGradoSeccion());

			$codigoSeccion;
			$sql = "SELECT pk_codigo FROM Secciones AS S INNER JOIN Grados AS G"
						." ON S.grado_fk = G.pk_numero WHERE S.letra = ? AND "
						."G.pk_numero = ?;";
			$sentencia = $conexion->prepare(sql);
			$sentencia->bind_param("si",$gradoSeccion[1],$gradoSeccion[0]);
			$resultado = $sentencia->execute();
			
			if($resultado === FALSE) {
				printf("Error! No hay registro alguno de la combinación Grado-Sección ingresada!");
				exit(1);
			}

			$fila = $resultado->fetch_row();
			$codigoSeccion = intval($fila[0]);

			$sentencia = $conexion->prepare("INSERT INTO Estudiantes 
											VALUES(?,?,?,?,?);");
			$sentencia->bind_param("issii",$cedula,$nombre,$apellido,$edad,
								  $codigoSeccion);
			$resultado = $sentencia->execute();

			return $resultado
		}

		function consultar($estudiante,$tipoConsulta) {
			$cedula = $estudiante->getCedula();
			$nombre = $estudiante->getNombre();
			$apellido = $estudiante->getApellido();
			$edad = $estudiante->getEdad();
			$gradoSeccion = explode("-", $estudiante->getGradoSeccion());

			$sentencia;
			$sql = "";

			switch ($tipoConsulta) {
				case QCEDULA: {
					$sql = "SELECT E.pk_cedula AS [Cédula de Ciudadanía], ".
					"CONCAT(E.nombre,' ',E.apellido) AS [Nombre Completo], ".
					"E.edad AS Edad, CONCAT(G.pk_numero,'-',S.letra) AS Grado ".
					"FROM (Estudiantes AS E INNER JOIN Secciones AS S ".
					  "ON E.seccion_fk = S.pk_codigo) ".
					  "INNER JOIN Grados AS G ON S.grado_fk = G.pk_numero ".
					"WHERE E.pk_cedula = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("i",$cedula);
					break;
				}
				case QNOMBRE: {
					$sql = "SELECT E.pk_cedula AS [Cédula de Ciudadanía], ".
					"CONCAT(E.nombre,' ',E.apellido) AS [Nombre Completo], ".
					"E.edad AS Edad, CONCAT(G.pk_numero,'-',S.letra) AS Grado ".
					"FROM (Estudiantes AS E INNER JOIN Secciones AS S ".
					  "ON E.seccion_fk = S.pk_codigo) ".
					  "INNER JOIN Grados AS G ON S.grado_fk = G.pk_numero ".
					"WHERE E.nombre = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$nombre);
					break;
				}
				case QAPELLIDO: {
					$sql = "SELECT E.pk_cedula AS [Cédula de Ciudadanía], ".
					"CONCAT(E.nombre,' ',E.apellido) AS [Nombre Completo], ".
					"E.edad AS Edad, CONCAT(G.pk_numero,'-',S.letra) AS Grado ".
					"FROM (Estudiantes AS E INNER JOIN Secciones AS S ".
					  "ON E.seccion_fk = S.pk_codigo) ".
					  "INNER JOIN Grados AS G ON S.grado_fk = G.pk_numero ".
					"WHERE E.apellido = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$apellido);
					break;
				}
				case QEDAD: {
					$sql = "SELECT E.pk_cedula AS [Cédula de Ciudadanía], ".
					"CONCAT(E.nombre,' ',E.apellido) AS [Nombre Completo], ".
					"E.edad AS Edad, CONCAT(G.pk_numero,'-',S.letra) AS Grado ".
					"FROM (Estudiantes AS E INNER JOIN Secciones AS S ".
					  "ON E.seccion_fk = S.pk_codigo) ".
					  "INNER JOIN Grados AS G ON S.grado_fk = G.pk_numero ".
					"WHERE E.edad = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("i",$edad);
					break;
				}
				case QGRADO: {
					$sql = "SELECT E.pk_cedula AS [Cédula de Ciudadanía], ".
					"CONCAT(E.nombre,' ',E.apellido) AS [Nombre Completo], ".
					"E.edad AS Edad, CONCAT(G.pk_numero,'-',S.letra) AS Grado ".
					"FROM (Estudiantes AS E INNER JOIN Secciones AS S ".
					  "ON E.seccion_fk = S.pk_codigo) ".
					  "INNER JOIN Grados AS G ON S.grado_fk = G.pk_numero ".
					"WHERE S.letra = ? AND E.seccion_fk = (SELECT pk_codigo ".
						"FROM Secciones WHERE pk_codigo = (SELECT pk_numero ".
						"FROM Grados WHERE pk_numero = ?));";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("is",intval($gradoSeccion[1]), 
											$gradoSeccion[0]);

					break;
				}
				case QTODO: {
					$sql = "SELECT * FROM Estudiantes;";

					$sentencia = $conexion->prepare($sql);

					break;
				}
				default: {
					printf("Error en consulta, opcion no valida!!!");
					exit(1);
				}	
					break;
			}

			$resultado = $sentencia->execute();
			return $resultado;
		}

		function actualizar($estudiante,$cedulaRegistro) {		
			$cedula = $estudiante->getCedula();
			$nombre = $estudiante->getNombre();
			$apellido = $estudiante->getApellido();
			$edad = $estudiante->getEdad();
			$gradoSeccion = explode("-", $estudiante->getGradoSeccion());

			$codigoSeccion;
			$sql = "SELECT pk_codigo FROM Secciones AS S INNER JOIN Grados AS G"
						." ON S.grado_fk = G.pk_numero WHERE S.letra = ? AND "
						."G.pk_numero = ?;";
			$sentencia = $conexion->prepare(sql);
			$sentencia->bind_param("si",$gradoSeccion[1],$gradoSeccion[0]);
			$resultado = $sentencia->execute();
			
			if($resultado === FALSE) {
				printf("Error! No hay registro alguno de la combinación Grado-Sección ingresada!");
				exit(1);
			}

			$fila = $resultado->fetch_row();
			$codigoSeccion = intval($fila[0]);

			$sql = "UPDATE Estudiantes SET pk_cedula = ?, nombre = ?, apellido = ?, "
			."edad = ?, seccion_fk = ? WHERE pk_cedula = ?;";
			$sentencia = $conexion->prepare($sql);
			$sentencia->bind_param("issiii",$cedulaRegistro,$nombre,$apellido,$edad,$codigoSeccion,$cedula);
			$resultado = $sentencia->execute();

			return $resultado;
		}

		function borrar($cedula) {
			$sql = "DELETE FROM Estudiantes WHERE pk_cedula = ?";
			$sentencia = $conexion->prepare(sql);
			$sentencia->bind_param("i",$cedula);
			$resultado = $sentencia->execute(sql);
			return $resultado;
		}

		function listarColumnas() {			
			$resultado = $conexion->query("DESCRIBE Estudiantes;");
			return $resultado;
		}
	}