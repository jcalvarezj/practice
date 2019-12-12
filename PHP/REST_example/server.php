<?php

$allowed_resources = ['books', 'authors', 'genres'];

if(!in_array('resource_type',array_keys($_GET)))
	die;

$resource_type = $_GET['resource_type'];

$resource = getResource($resource_type);

if(!in_array($resource_type, $allowed_resources))
	die;

$resource_id = array_key_exists('resource_id',$_GET) ? $_GET['resource_id'] : '';

header('Content-Type: application/json');

switch(strtoupper($_SERVER['REQUEST_METHOD'])) {
	case 'GET':
		if(empty($resource_id))
			echo json_encode($resource); 
		else
			if (array_key_exists($resource_id,$resource))
				echo json_encode($resource[$resource_id]);
		break;
	case 'POST':
		$json_body = file_get_contents('php://input');
		$new_book = json_decode($json_body, true);
		$resource[] = $new_book;
		echo json_encode($resource,true);

		break;
	case 'PUT':
		if(!empty($resource_id) && array_key_exists($resource_id, $resource)) {
			$json_body = file_get_contents("php://input");
			$resource[$resource_id] = json_decode($json_body, true);

			echo json_encode($resource);
		}
		else
			echo "HEY, YOU FORGOT THE ID ON THE URL!!!";
		break;
	case 'DELETE':
		if(!empty($resource_id) && array_key_exists($resource_id, $resource)) {
			unset($resource[$resource_id]);

			echo json_encode($resource);
		}
		break;
}

function getResource($type) {
	$resource;

	switch($type) {
		case 'books':
			$resource = [
				1 => [
					'title' => 'Lo que el viento se llevó',
					'authorId' => 123,
					'genreId' => 1
				],
				2 => [
					'title' => 'The Crow',
					'authorId' => 3,
					'genreId' => 2
				]
			];
			break;
		default:
			$resource = [ 0 => 'Not implemented yet' ];
			break;
	}

	return $resource;
}
