<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de un 
		Estudiante
	*/
	
	class Estudiante implements Entidad {
		// Atributos

		private $cedula;
		private $nombre;
		private $apellido;
		private $edad;
		private $grado;
		private $seccion; // Anterior: $gradoSeccion (formato: "Grado-Seccion")

        // Métodos

        function __construct($cedula, $nombre, $apellido, $edad, $grado, $seccion)
        {
            $this->$cedula = $cedula;
            $this->$nombre = $nombre;
            $this->$apellido = $apellido;
            $this->$edad = $edad;
            $this->$grado;
            $this->$seccion = $seccion;
		}

		function __toString() {
			$seccionGrado = explode("-",$gradoSeccion);
			return "$cedula;$nombre;$apellido;$edad;$grado;$seccion";
		}

		function getCedula() {
			return $this->$cedula;
		}

		function setCedula($cedula) {
			$this->$cedula = $cedula;
		}

		function getNombre() {
			return $this->$nombre;
		}

		function setNombre($nombre) {
			$this->$nombre = $nombre;
		}

		function getApellido() {
			return $this->$apellido;
		}

		function setApellido($apellido) {
			$this->$apellido = $apellido;
		}

		function getEdad() {
			return $this->$edad;
		}

		function setEdad($edad) {
			$this->$edad = $edad;
		}

		function getGrado() {
			return $this->$grado;
		}

		function setGrado($grado) {
			$this->$grado = $grado;
		}

		function getSeccion() {
			return $this->$seccion;
		}

		function setSeccion($seccion) {
			$this->$seccion = $seccion;
		}
	}