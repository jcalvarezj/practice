<?php
	namespace Modelo;

	/*
		Esta corresponde a la clase entidad que guarda los datos de una Seccion
	*/
	
	class Seccion implements Entidad {
		//Atributos
		private $codigo;
		private $letra;
		private $numeroGrado;

        //Metodos         
        function __construct($codigo, $letra, $numeroGrado) {
            $this->$codigo = $codigo;
            $this->$letra = $letra;
            $this->$numeroGrado = $numeroGrado;
		}

		function __toString() {
			return "$codigo;$letra;$numeroGrado";
		}

		function getCodigo() {
			return $this->$codigo;
		}

		function setCodigo($codigo) {
			$this->$codigo = $codigo;
		}

		function getLetra() {
			return $this->$letra;
		}

		function setLetra($letra) {
			$this->$letra = $letra;
		}

		function getNumeroGrado() {
			return $this->$numeroGrado;
		}

		function setNumeroGrado($numeroGrado) {
			$this->$numeroGrado = $numeroGrado;
		}
	}