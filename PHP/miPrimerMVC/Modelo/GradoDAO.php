<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de un Grado
	*/
	
	class GradoDAO extends DAO{
		// Constantes

		define("QGRADO",0);
		define("QASESOR",1);
		define("QLETRA",2);
		define("QTODO",3);

		// Atributos (heredados: $conexion)

        // Metodos

		function __construct($conexion) {
			parent::__construct($conexion);
		}

		function registrar($grado) {
			$numero = $grado->getNumero();
			$asesor = $grado->getAsesor();

			$sentencia = $conexion->prepare("INSERT INTO Grados VALUES(?,?);");
			$sentencia->bind_param("is",$numero,$asesor);
			$resultado = $sentencia->execute();

			return $resultado;
		}

		function consultar($grado,$tipoConsulta) {
			$numero = $grado->getNumero();
			$asesor = $grado->getAsesor();
			$letra = $grado->getLetra();

			$sentencia;
			$sql = "";

			switch ($tipoConsulta) {
				case QGRADO: {
					$sql = "SELECT G.pk_numero, G.nombre_asesor, S.letra "
					."FROM Grados AS G JOIN Secciones AS S "
					."ON G.pk_numero = S.grado_fk "
					."WHERE G.pk_numero = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("i",$numero);
					break;
				}
				case QNOMBRE: {
					$sql = "SELECT G.pk_numero, G.nombre_asesor, S.letra "
					."FROM Grados AS G JOIN Secciones AS S "
					."ON G.pk_numero = S.grado_fk "
					."WHERE UPPER(G.nombre_asesor) = UPPER(?);";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$asesor);
					break;
				}
				case QLETRA: {
					$sql = "SELECT G.pk_numero, G.nombre_asesor, S.letra "
					."FROM Grados AS G JOIN Secciones AS S "
					."ON G.pk_numero = S.grado_fk "
					."WHERE UPPER(S.letra) = UPPER(?);";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$letra);
					break;
				}
				case QTODO: {
					$sql = "SELECT G.pk_numero, G.nombre_asesor, S.letra "
					."FROM Grados AS G JOIN Secciones AS S "
					."ON G.pk_numero = S.grado_fk;"

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$asesor);
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

		function actualizar($grado,$numeroRegistro) {
			$numero = $grado->getNumero();
			$asesor = $grado->getAsesor();
			
			$sql = "UPDATE Grados SET pk_numero = ?, nombre_asesor = ? ".
			"WHERE pk_numero = ?;";
			$sentencia = $conexion->prepare($sql);
			$sentencia->bind_param("isi",$numero,$asesor,$numeroRegistro);
			$resultado = $sentencia->execute();

			return $resultado;
		}

		function borrar($numeroRegistro) {
			$sql = "DELETE FROM Grados WHERE pk_numero = ?";
			$sentencia = $conexion->prepare(sql);
			$sentencia->bind_param("i",$numeroRegistro);
			$resultado = $sentencia->execute(sql);
			
			return $resultado;
		}

		function listarColumnasTabla() {
			$resultado = $conexion->query("DESCRIBE Grados;");
			return $resultado;
		}

	}