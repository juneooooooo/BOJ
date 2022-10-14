SELECT b.HOUR, count(a.HOUR) cnt
FROM (select to_char(datetime,'HH24') HOUR from animal_outs) a 
   , (select level-1 HOUR from dual connect by level <= 24) b
WHERE b.HOUR=a.HOUR(+)
GROUP BY b.HOUR
ORDER BY b.HOUR
;