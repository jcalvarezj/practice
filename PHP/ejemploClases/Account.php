<?php
class Account {
	public $id;
	public $name;
	public $document;
	public $email;
	public $password;

	function __construct($name, $document, $email, $password) {
		$this->name = $name;
		$this->document = $document;
		$this->email = $email;
		$this->password = $password;
	}

	function toString() {
		return "document: $this->document -- name: $this->name -- email: ".
			"$this->email";
	}
}
