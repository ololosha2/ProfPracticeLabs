<?php
/**
 * Created by PhpStorm.
 * Date: 21.11.2015
 * Time: 3:19
 */

namespace application\extractor\weather;


class WeatherExtractor
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

    private function getColumn($name, $file, $castTo)
    {
        $fh = fopen($file, 'r');
        $bounds = $this->locateBounds($name, $fh);

        $line = null;
        $column = [];

        while(!feof($fh))
        {
            fseek($fh, $bounds['start'], SEEK_CUR);
            $val = fread($fh, $bounds['end']-$bounds['start']);
            if(!empty($val))
            {
                $column[] = $val;
            }
            fgets($fh);
        }
        fclose($fh);

        return array_map($castTo, $column);
    }

    /**
     * @param $colName Name of column for which we perform column bouns search
     * @param $fileResource resource of file in which we perform search
     * @return array ['start'=>value, 'end'=>value]
     */
    private function locateBounds($colName, $fileResource)
    {
        $bounds = ['start' => null, 'end' => null, 'linelen' => null];

        //$fh = fopen($file, 'r');

        $headingLine = fgets($fileResource);

        $bounds['linelen'] = strlen($headingLine);

        //fclose($fh);

        $bounds['start'] = strpos($headingLine, $colName);

        $matches = [];
        preg_match("/$colName\s*/", $headingLine, $matches);

        $bounds['end'] = $bounds['start'] + strlen($matches[0]);

        return $bounds;
    }
} 