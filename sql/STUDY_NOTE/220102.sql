SELECT 컬럼명1, 컬럼명2,....
  FROM 집합이름1, 집합이름2
 WHERE 컬럼명 비교연산자 값 
 
SELECT * FROM emp

SELECT ename, comm FROM emp

SELECT
       ename as "사원명", comm as "인센티브"
  FROM emp
  
우리 회사에 근무하는 사원들 중에서 인센티브를 받는 사원들의 
사원명과 인센티브 금액을 출력하시오.

SELECT
       ename, comm
  FROM emp

--조건절을 사용하면 경우의 수가 줄어들어 검색 속도는 빨라진다.  

SELECT
       ename, comm
  FROM emp  
 WHERE comm > 0  
  
SELECT
       ename as "사원명", comm as "인센티브"
  FROM emp  
 WHERE comm > 0  
 
SELECT와 FROM절 사이에는 컬럼명이 온다. - 여러개도 가능함
단 콤마(열거형연산자)붙일것
FROM절 뒤에는 집합이 온다. - 집합적 사고- 합집합, 교집합, 차집합, 여집합 

FROM 테이블명1, 테이블2,  (SELECT문-인라인뷰- 경우의 수를 줄여줌)

전체범위처리가 뭐예요?

SELECT count(empno), max(sal), min(sal), avg(sal) FROM emp

옵티마이저

합집합을 하면 row가 늘어난다.

SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual

SELECT deptno FROM dept --4건

SELECT deptno FROM emp -- 14건-중복이 존재함

SELECT distinct(deptno) FROM emp --중복제거 함수임 - distinct(컬럼명)

SELECT 컬럼명1, 컬럼명2, 함수명(컬럼명)

차집합 예약어는 MINUS입니다.

SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp


SELECT deptno FROM emp
MINUS
SELECT deptno FROM dept



우리 회사에 근무하는 사원들 중에서 인센티브를 받지 않는 사원들의
사원명과 인센티브 금액을 출력하시오.

SELECT empno, ename
  FROM emp
 WHERE 1=1
 
SELECT empno, ename
  FROM emp
 WHERE 1!=1 

SELECT empno, ename
  FROM emp
 WHERE 1<>1
  
SELECT empno, ename, comm
  FROM emp
 WHERE comm = 0 

SELECT empno, ename, comm
  FROM emp
 WHERE comm = NULL  
 
널을 비교할 때는 반드시 IS NULL 또는 IS NOT NULL로 비교해야 한다  
 
SELECT empno, ename, comm
  FROM emp
 WHERE comm != NULL   