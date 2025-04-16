-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) as count
from ANIMAL_OUTS 
where hour(datetime) between 9 and 19
and minute(datetime) between 0 and 59
group by hour(datetime)
order by hour(datetime)