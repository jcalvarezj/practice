<?php

$xkcd_json = file_get_contents("https://xkcd.com/info.0.json");

$xkcd_data = json_decode($xkcd_json, true);

echo "<img src='".$xkcd_data['img']."' />".PHP_EOL;
