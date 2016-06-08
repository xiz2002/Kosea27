-- 문) 부서가 "Finance"인 사원 중에서 최고 급여를 받는 사원(들)의 이름과 급여를 출력하십시오.

-- 결과 참고) Nancy  Greenberg 12008
 
-- Hint) Where 조건문에서의 Hint

-- 부서 테이블에서 Finance 에 해당하는 부서 아이디를 구하는 select문을 작성한다.
-- 위의 구문을 활용하여 사원 테이블에서 부서의 최고 연봉을 구하는 select문을 작성한다.
-- 위의 조건만으로는 값이 "결과 참고"와 같이 출력되지 않고 중복될 수 있다.
-- 이것을 막기 위해서는 아래의 조건을 "동시에(AND)" 만족하도록 위의 조건들과 더불어
-- 부서 테이블에서 Finance 에 해당하는 부서 아이디를 구하는 select문을 재활용한다.
SELECT (FIRST_NAME || '' || LAST_NAME) "이름", SALARY
FROM (SELECT * 
	  FROM  EMPLOYEES
	  WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
							  FROM DEPARTMENTS 
							  WHERE DEPARTMENT_NAME = 'Finance' )
	  )
WHERE ROWNUM = 1
ORDER BY SALARY ASC;

-- 정답 )

