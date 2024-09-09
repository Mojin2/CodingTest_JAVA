-- 코드를 입력하세요
SELECT count(CASE WHEN AGE IS NULL THEN USER_ID END) as USERS
from USER_INFO


# SELECT count(*) as USERS
# from USER_INFO
# where AGE IS NULL