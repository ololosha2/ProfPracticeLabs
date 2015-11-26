<?php
/**
 * Created by PhpStorm.
 * Date: 21.11.2015
 * Time: 3:17
 */
use application\extractor\football\FootballExtractor;
use application\extractor\football\FootballExtractorDRY;
use application\extractor\weather\WeatherExtractor;
use application\extractor\weather\WeatherExtractorDRY;

spl_autoload_extensions('.php');
spl_autoload_register();

$we = new WeatherExtractor();
$fe = new FootballExtractor();
$minValW = $we->smallestTSpread('vfs/weather.dat');
$minValF = $fe->getMinScoreDiff('vfs/football.dat');
echo 'Minimal difference between Max and Min temperatures is in day: ' . $minValW . '<br />';
echo 'Minimal difference between Goals For and Goals Against is in team: ' . $minValF . '<br />';

//Checking if DRY version works
$wed = new WeatherExtractorDRY();
$fed = new FootballExtractorDRY();
$minValWD = $wed->smallestTSpread('vfs/weather.dat');
$minValFD = $fed->getMinScoreDiff('vfs/football.dat');
echo 'Minimal difference between Max and Min temperatures is in day: ' . $minValWD . '<br />';
echo 'Minimal difference between Goals For and Goals Against is in team: ' . $minValFD . '<br />';