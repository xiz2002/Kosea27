-- OR
SELECT EMPLOYEE_Id 사원번호,
	   first_name || ' ' || last_name 성명,
	   SALARY 월급,
	   DEPARTMENT_ID 부서코드
FROM employees
WHERE DEPARTMENT_ID = 30
OR DEPARTMENT_ID = 60
OR DEPARTMENT_ID = 90
ORDER BY DEPARTMENT_ID

-- IN
-- OR와 동일하다. 비교하는 값이 괄호 안의 값에 포함될 경우 조건을 만족.
-- 포함되지 않은것을검색한다면 IN 앞에 NOT을 붙인다. (WHERE Attribute NOT IN (args1, args2, args3...))
SELECT EMPLOYEE_Id 사원번호,
	   first_name || ' ' || last_name 성명,
	   SALARY 월급,
	   DEPARTMENT_ID 부서코드
FROM employees
WHERE DEPARTMENT_ID IN (30, 60, 90)

-- SubQuery를 이용하여 위와 같은 결과를 얻는다.
SELECT EMPLOYEE_Id 사원번호,
	   first_name || ' ' || last_name 성명,
	   SALARY 월급,
	   DEPARTMENT_ID 부서코드
FROM employees
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						FROM DEPARTMENTS
						WHERE DEPARTMENT_ID IN (30, 60, 90));
						
-- EXIST
-- IN 과 비슷한 용도, 특정 컬럼의 값의 존재여부를 확인.
-- 아래 코드는 위 코드와 동일한 결과를 내지만, JOIN을 통해 해당 결과 값이 존재하는지 여부를 확인.
-- IN과 다른점은 결과값에 NULL이 있다면, NULL을 포함시킨다.
-- 성능은 IN보다 빠르나, 쿼리문이 복잡해진다.
SELECT emp.employee_id 사원번호,
	   emp.first_name || ' ' || emp.last_name 성명,
	   emp.salary 월급,
	   emp.department_id 부서코드
FROM employees emp
WHERE EXISTS
	  ( SELECT dep.department_id
	  	FROM DEPARTMENTS dep
	  	WHERE dep.department_id IN (30, 60, 90)
	  	AND emp.department_id = dep.department_id);

						
