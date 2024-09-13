-- 코드를 입력하세요
select count(a.NAME)
from (
    SELECT distinct NAME
    FROM ANIMAL_INS
    WHERE NAME is not null
    ) a