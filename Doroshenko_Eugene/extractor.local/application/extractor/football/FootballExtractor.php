<?php
/**
 * Created by PhpStorm.
 * Date: 21.11.2015
 * Time: 3:18
 */

namespace application\extractor\football;


class FootballExtractor
{
    public function getMinScoreDiff($file)
    {
        $team = $this->getColumn('Team', $file, 'strval');
        $goalsFor = $this->getColumn('F', $file, 'intval');
        $goalsAgainst = $this->getColumn('A', $file, 'intval');

        $combined = ['Team' => $team, 'For' => $goalsFor, 'Against' => $goalsAgainst];

        $gDiff = [];

        for($i = 0; $i < count($team); $i++)
        {
            $gDiff[] = $goalsFor[$i] - $goalsAgainst[$i];
        }

        $gDiffAbs = array_map('abs', $gDiff);
        return trim($team[array_search(min($gDiffAbs), $gDiffAbs)]);
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