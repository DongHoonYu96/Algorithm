-- 1. car의 id 뽑기, 대여횟수 5회이상인
WITH a AS (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)

-- 2. id 필터링, 날짜필터링
-- 월별그룹화, car_id로 2차 그룹화 => (월, car_id) 조합생성
SELECT 
    MONTH(start_date) AS MONTH, 
    car_id AS CAR_ID, 
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    car_id IN (SELECT car_id FROM a)
    and month(start_date) between 8 and 10
GROUP BY MONTH(start_date), car_id
order by month asc, car_id desc;