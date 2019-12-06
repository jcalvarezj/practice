<?php
class Route {
	public $id;
	public $init;
	public $end;

	public function __construct($id, $init, $end) {
		$this->init = $init;
		$this->end = $end;
	}
}
