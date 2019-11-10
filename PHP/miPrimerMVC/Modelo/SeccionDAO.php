<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de una Seccion
	*/
	
	class SeccionDAO {
		// Constantes

		define("QNUMERO",0);
		define("QLETRA",1);
		define("QGRADO",2);
		define("QTODO",3);

		// Atributos (heredados: $conexion)

        // Metodos

		function __construct($conexion) {
			parent::__construct($conexion);
		}

		function registrar($seccion) {			
			$letra = $seccion->getLetra();
			$grado = $seccion->getNumeroGrado();

			$sentencia = $conexion->prepare("INSERT INTO Secciones(letra, ".
				"grado_fk) VALUES(UPPER(?),?);");
			$sentencia->bind_param("si",$codigo,$seccion,);
			$resultado = $sentencia->execute();

			return $resultado;
		}

		function consultar($seccion,$tipoConsulta) {
			$codigo = $seccion->getCodigo();
			$letra = $seccion->getLetra();
			$grado = $seccion->getNumeroGrado();

			$sentencia;
			$sql = "";

			switch ($tipoConsulta) {
				case QNUMERO: {
					$sql = "SELECT S.pk_codigo, S.letra, G.pk_numero, "
					."G.nombre_asesor FROM Secciones AS S JOIN Grados AS G "
					."ON S.grado_fk = G.pk_numero WHERE S.pk_codigo = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("i",$codigo);
					break;
				}
				case QLETRA: {
					$sql = "SELECT S.pk_codigo, S.letra, G.pk_numero, "
					."G.nombre_asesor FROM Secciones AS S JOIN Grados AS G "
					."ON S.grado_fk = G.pk_numero WHERE S.letra = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("s",$letra);
					break;
				}
				case QGRADO: {
					$sql = "SELECT S.pk_codigo, S.letra, G.pk_numero, "
					."G.nombre_asesor FROM Secciones AS S JOIN Grados AS G "
					."ON S.grado_fk = G.pk_numero WHERE S.grado_fk = ?;";

					$sentencia = $conexion->prepare($sql);
					$sentencia->bind_param("i",$grado);
					break;
				}
				case QTODO: {
					$sql = "SELECT S.pk_codigo, S.letra, G.pk_numero, "
					."G.nombre_asesor FROM Secciones AS S JOIN Grados AS G "
					."ON S.grado_fk = G.pk_numero;";

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

		function actualizar($seccion,$numeroRegistro) {		
			$numero = $seccion->getNumero();
			$asesor = $seccion->getAsesor();
			
			$sql = "UPDATE seccions SET pk_numero = ?, nombre_asesor = ? ".
			"WHERE pk_numero = ?;";
			$sentencia = $conexion->prepare($sql);
			$sentencia->bind_param("isi",$numero,$asesor,$numeroRegistro);
			$resultado = $sentencia->execute();

			return $resultado;
		}

		function borrar($numeroRegistro) {
			$sql = "DELETE FROM seccions WHERE pk_numero = ?";
			$sentencia = $conexion->prepare(sql);
			$sentencia->bind_param("i",$numeroRegistro);
			$resultado = $sentencia->execute(sql);
			return $resultado;
		}

		function listarColumnas() {			
			$resultado = $conexion->query("DESCRIBE Secciones;");
			return $resultado;
		}
	}