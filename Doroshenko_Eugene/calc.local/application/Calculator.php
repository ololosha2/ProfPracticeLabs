<?php
/**
 * Created by PhpStorm.
 * Date: 09.11.2015
 * Time: 0:57
 */

namespace application;


use exceptions\NegativeItemException;

class Calculator
{

    function __construct()
    {
        echo "Done";
    }

    public function add($nums)
    {
        $patEnd = @strpos($nums, '\n', 2);
        $numPart = null;
        if($patEnd !== false)
        {
            $delimPat = substr($nums, 2, $patEnd-2);
            $delimPat = str_replace(['[', ']'], '', $delimPat);
            $rgxPtrn = "/[$delimPat]/";
            $numPart = substr($nums, $patEnd + 2);
        }
        else
        {
            $rgxPtrn = "/;/";
            $numPart = $nums;
        }

        $parts = preg_split($rgxPtrn, $numPart);

        $negatives = [];
        $res = 0;

        foreach($parts as $token)
        {
            if($token < 0)
            {
                array_push($negatives, $token);
                continue;
            }
            //$res += $token;
            $res += ($token > 1000) ? 0 : $token;
        }

        if(!empty($negatives))
        {
            throw new NegativeItemException("Negatives are not allowed: " . implode(', ', $negatives));
        }
        return $res;
    }
}
