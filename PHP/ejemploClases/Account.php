<?php
class Account {
	public $id;
	public $name;
	public $document;
	public $email;
	public $password;

	function __construct($id, $name) {
		$this->id = $id;
		$this->name = $name;
	}

	function toString() {
		return "id: $this->id\nname: $this->name";
	}
}
