<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de un Grado
	*/
	
	class Grado implements Entidad {
		//Atributos
		private $numero;
		private $nombreAsesor;
		private $letra;

        //Metodos         
        function __construct($numero, $nombreAsesor, $letra) {
            $this->$nombreAsesor = $nombreAsesor;
            $this->$numero = $numero;
            $this->$letra = $letra;
		}

		function __toString() {
			return "$numero;$nombreAsesor";
		}

		function getNombreAsesor() {
			return $this->$nombreAsesor;
		}

		function setNombreAsesor($nombreAsesor) {
			$this->$nombreAsesor = $nombreAsesor;
		}

		function getNumero() {
			return $this->$numero;
		}

		function setNumero($numero) {
			$this->$numero = $numero;
		}

		function getLetra() {
			return $this->$letra;
		}

		function setLetra($letra) {
			$this->$letra = $letra;
		}
	}