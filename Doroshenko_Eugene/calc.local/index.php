<?php
/**
 * Created by PhpStorm.
 * Date: 09.11.2015
 * Time: 0:55
 */

use application\Calculator;

spl_autoload_extensions(".php");
spl_autoload_register();

$calc = new Calculator();
$r = $calc->add('1');
$r = $calc->add('');
echo 'st';
