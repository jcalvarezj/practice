<?php
	namespace Modelo;

	/* ----------------------- BOCETO PARA MODELAR POR POLIMORFISMO
		Representa las entidades en general
	*/
	interface Entidad {

		/*
			Retorna un string con los atributos de la entidad en el formato:
			atributo1;...;atributoN
		*/
		// abstract function toString(); --> YA EXISTE EN PHP: __toString()
	}