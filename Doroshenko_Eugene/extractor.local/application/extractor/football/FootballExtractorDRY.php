<?php
/**
 * Created by PhpStorm.
 * Date: 21.11.2015
 * Time: 20:32
 */

namespace application\extractor\football;


use application\extractor\Extractor;

class FootballExtractorDRY extends Extractor
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
} 