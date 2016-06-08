
-- 문1) 아래 링크의 문제를 중첩 쿼리(inner query)를 사용하여 다시 작성하십시오.
-- http://cafe.naver.com/kosea27/406
-- SELECT DISTINCT e.employee_id, (e.first_name || '' || e.last_name) AS "이름"
-- FROM employees e, job_history j
-- WHERE e.employee_id = j.employee_id
-- AND j.start_date < '2002/01/01';

SELECT DISTINCT employee_id, (first_name || '' || last_name) AS "이름"
FROM employees
WHERE employee_id IN (SELECT EMPLOYEE_ID FROM JOB_HISTORY WHERE START_DATE < '2002/01/01')


-- 문2) 2005년 4월 1일 당일에 근무중이었으며, 미국 시애틀(Seattle)에 위치한 부서에서 근무했던 근로자들의 이름을 
-- 오름차순으로 출력하도록 조치하십시오. 중첩 쿼리(inner query)를 사용하여 풀이하도록 합니다.
SELECT (FIRST_NAME || '' || LAST_NAME) AS "이름"
FROM EMP_DETAILS_VIEW
WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM JOB_HISTORY WHERE START_DATE='2005/04/01' OR END_DATE='2005/04/01')
AND LOCATION_ID IN (SELECT LOCATION_ID FROM LOCATIONS WHERE CITY = 'Seattle')
ORDER BY "이름" ASC;

SELECT * FROM EMP_DETAILS_VIEW;
SELECT * FROM JOB_HISTORY;
SELECT * FROM EMPLOYEES;
SELECT * FROM LOCATIONS;
SEELCT * FROM JABS;

-- 문3) 관리자 아이디가 "100" 인 사원들의 "평균" 임금을 출력하시오.
SELECT AVG(SALARY) 
FROM employees
WHERE manager_id = '100'

-- 문4) 부서명이 "Accounting"인 사원들의 이름 명단(first_name 과 last_name 합쳐서)을 내림차순으로 출력하시오.
SELECT (FIRST_NAME || '' || LAST_NAME) AS "NAME"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
					   FROM DEPARTMENTS 
					   WHERE DEPARTMENT_NAME ='Accounting')

