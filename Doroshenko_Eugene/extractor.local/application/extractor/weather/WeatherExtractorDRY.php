<?php
/**
 * Created by PhpStorm.
 * Date: 21.11.2015
 * Time: 20:32
 */

namespace application\extractor\weather;


use application\extractor\Extractor;

class WeatherExtractorDRY extends Extractor
{
    public function smallestTSpread($file)
    {
        $days = $this->getColumn('Dy', $file, 'intval');
        $maxTemps = $this->getColumn('MxT', $file, 'floatval');
        $minTemps = $this->getColumn('MnT', $file, 'floatval');

        $combined = ['Day' => $days, 'MaxTemps' => $maxTemps, 'MinTemps' => $minTemps];

        $tSpread = [];

        for($i = 0; $i < count($days); $i++)
        {
            $tSpread[] = $maxTemps[$i] - $minTemps[$i];
        }


        return 1 + array_search(min($tSpread), $tSpread);
    }
} 