-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT
FROM FISH_INFO
WHERE LEFT(TIME,4) = "2021"