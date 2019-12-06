<?php
class Car {
	public $id;
	public $license;
	public $driver;
	public $passenger;

	public function __construct($id, $license, $driver, $passenger) {
		$this->id = $id;
		$this->license = $license;
		$this->driver = $driver;
		$this->passenger = $passenger;
	}
}	
