-- 코드를 입력하세요
# SELECT count(AGE is null) as USERS
# from USER_INFO


SELECT count(*) as USERS
from USER_INFO
where AGE IS NULL
