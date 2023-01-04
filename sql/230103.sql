SELECT deptno, dname, loc FROM dept;

SELECT empno, ename, deptno FROM emp;

--SELECT 컬럼명1, 컬럼명2, COUNT(컬럼명3) FROM 집합1, 집합2, ... 카타시안의 곱 -묻지마 조인 -일어날 수 있는 모든 경우의 수를 다 보여줌

SELECT empno, ename, deptno, dname 
  FROM emp, dept;
    
SELECT empno FROM emp; --인덱스는 디폴트값이 오름차순

SELECT ename FROM emp ORDER BY ename asc;--데이터 2차가공

--부적합한 식별자 / 열정의가 애매하다 -> SQLException대상 -> try-catch(){}필요
--ctrl+B -> 주석
--옵티마이저에게 보내는 hint문 추가함-> 그냥--


--양쪽 테이블에 모두 존재하나 인덱스인 컬럼명을 쓰는 것이 더 빠르다
--카타시안의 곱 -묻지마 조인 -일어날 수 있는 모든 경우의 수를 다 보여줌
SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept;

SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept 
 WHERE emp.deptno = dept.deptno;

--Natural JOIN
SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept 
 WHERE emp.deptno = dept.deptno
   AND emp.ename = 'SMITH';

--조건절을 사용하면 경우의 수가 줄어든다(그러니까 검색 속도는 증가함)
--AND - 교집합 - 튜플의 수는 줄어든다.
--OR - 합집합 - 튜플의 수는 증가한다.


--1.1.월 급여는 연봉을 18로 나누어 홀수 달에는 연봉의 1/18이 지급되고, 짝수달에는 연봉의 2/18가 지급된다고 가정했을 때 홀수 달과 짝수 달에 받을 금액을 나타내시오.
SELECT emp_name, ROUND(salary/18), ROUND((salary*2)/18) FROM temp;

SELECT emp_name
     , to_char((ROUND(salary/18, -1)), '999,999,999')||'원'
     , to_char((ROUND((salary*2)/18, -1)), '999,999,999')||'원'
  FROM temp;
  
SELECT emp_name as "사원명"
     , to_char((ROUND(salary/18, -1)), '999,999,999')||'원' as "홀수달"
     , to_char((ROUND((salary*2)/18, -1)), '999,999,999')||'원' as "짝수달"
  FROM temp;

--2.위에서 구한 월 급여에 교통비가 10만원씩 지급된다면(짝수달은 20만원)위의 문장이
--어떻게 바뀔지 작성해 보시오.
SELECT emp_name as "사원명"
     , to_char((ROUND(salary/18, -1))+100000, '999,999,999')||'원' as "홀수달"
     , to_char((ROUND((salary*2)/18, -1))+200000, '999,999,999')||'원' as "짝수달"
  FROM temp;

--3.TEMP 테이블에서 취미가 NULL 이 아닌 사람의 성명을 읽어오시오.

SELECT
        emp_name, hobby
  FROM temp
 WHERE hobby IS NULL;
--WHERE hobby=NULL;
 
SELECT
        emp_name, hobby
  FROM temp
 WHERE hobby IS NOT NULL;
 
--4.TEMP 테이블에서 취미가 NULL인 사람은 모두 HOBBY를 “없음”이라고 값을 치환하여 가져오고 나머지는 그대로 값을 읽어오시오.
SELECT ename, NVL(hobby, '없음'), hobby FROM temp;
SELECT ename, NVL(comm, 0), hobby FROM temp;

--5.TEMP의 자료 중 HOBBY의 값이 NULL인 사원을 ‘등산’으로 치환했을 때 HOBBY가 ‘등산인 사람의 성명을 가져오는 문장을 작성하시오.
SELECT ename FROM temp WHERE NVL(hobby, '등산')="등산";

--6.TEMP의 자료 중 EMP_ID와 EMP_NAME을 각각 ‘사번’,’성명’으로 표시되어 DISPLAY되도록 COLUMN ALLIAS를 부여하여 SELECT 하시오.
SELECT emp_id as "사번", emp_name as "성명" FROM temp;

--7.TEMP의 자료를 직급 명(LEV)에 ASCENDING하면서 결과내에서 다시 사번 순으로 DESCENDING하게 하는 ORDER BY하는 문장을 만들어 보시오.
--SELECT emp_id, emp_name, lev FROM temp;
SELECT emp_id, emp_name, lev FROM temp ORDER BY step asc, emp_id desc;


  
SELECT 연산이 가능하다 FROM;

SELECT 1+1, 500-300, 2*5, 5/2
  FROM TEMP;

SELECT * FROM t_letitbe;

SELECT MOD(5,2), MOD(6,2), MOD(120,2) FROM dual;

SELECT seq_vc
  FROM t_letitbe
 ORDER BY to_number(seq_vc) asc;

SELECT words_vc
  FROM t_letitbe
 WHERE MOD(seq_vc,2)=0;
 
 SELECT words_vc
  FROM t_letitbe
 WHERE MOD(seq_vc,2)=1;
 
-- 오라클에서 형변환함수가 있다.
-- to_char() 날짜 -> 문자, 숫자 -> 문자
-- to_number(문자) -> 숫자

--함수(파라미터1, 파라미터2)
--함수는 리턴값이 있다.함수는 파라미터를 맞춰야 한다.갯수와 타입 모두를 맞춰야한다.

SELECT MOD(to_number(seq_vc), 2) as "no" FROM t_letitbe;

-- 조건절에 사용하는 컬럼은 반드시 집합에 있는 컬럼명만 가능하다.

-- 인라인뷰
SELECT
        no
  FROM (
          SELECT MOD(seq_vc, 2) no
          FROM t_letitbe
       )
 WHERE no = 1;


SELECT
        ename, sal
  FROM emp;
-- DECODE문 검색
-- 크다작다X ifX 오로지 같다만 가능
SELECT
        DECODE(job, 'CLERK', sal, null)
  FROM emp;
  
SELECT
         DECODE(job, 'CLERK', sal, null)
        ,DECODE(job, 'SALESMAN', sal, null)
  FROM emp;

SELECT
         SUM(DECODE(job, 'CLERK', sal, null))
        ,SUM(DECODE(job, 'SALESMAN', sal, null))
        ,SUM(DECODE(job, 'CLERK', null, 'SALESMAN', sal))
  FROM emp;
  
  
SELECT deptno, DECODE(deptno, 10 , 'ACCOUNTING' ,
                              20 , 'RESEARCH' ,
                              30 , 'SALES', 'OPERATIONS') name
  FROM dept;
  
  
  
SELECT deptno, DECODE(deptno, 10 , SUM(sal),
                              20 , MAX(sal),
                              30 , MIN(sal)) sal
  FROM emp
 GROUP BY deptno;
 
-- Group by -> 
SELECT AVG(sal) as "급여평균", SUM(sal) as "급여합계", COUNT(empno) as "사원수" FROM emp;

SELECT AVG(sal) FROM emp;


-- distinct -> 중복제거 함수
SELECT distinct (deptno)
  FROM emp;

SELECT e.deptno, d.dname, SUM(e.sal) as "부서별 급여 총합" FROM emp e, dept d GROUP BY e.deptno, d.dname, e.sal;


SELECT emp.deptno, SUM(sal) as "부서별 급여 총합" FROM emp , dept GROUP BY emp.deptno;

SELECT deptno, ename
  FROM emp
GROUP BY deptno;

SELECT deptno, MIN(ename)
  FROM emp
GROUP BY deptno;

SELECT deptno, count(ename)
  FROM emp
  GROUP BY deptno;
  
SELECT DECODE(job, 'CLERK', sal, NULL)
  FROM emp;
  
SELECT SUM(DECODE(job, 'CLERK', sal, NULL))
  FROM emp;

SELECT deptno, ename
  FROM emp
GROUP BY deptno, ename;


-- 부서별로 급여 합계를 출력한다.
SELECT deptno, NVL(SUM(DECODE(deptno, 10, sal), 0) deptno10),
               NVL(SUM(DECODE(deptno, 20, sal), 0) deptno20),
               NVL(SUM(DECODE(deptno, 30, sal), 0) deptno30),
               NVL(SUM(DECODE(deptno, 40, sal), 0) deptno40)
  FROM emp;
  
SELECT deptno, NVL(DECODE(deptno, 10, sal), 0) deptno10,
               NVL(DECODE(deptno, 20, sal), 0) deptno20,
               NVL(DECODE(deptno, 30, sal), 0) deptno30,
               NVL(DECODE(deptno, 40, sal), 0) deptno40
  FROM emp;
  
  
SELECT deptno, 
       CASE deptno
         WHEN 10 THEN 'ACCOUNTING'
         WHEN 20 THEN 'RESEARCH'
         WHEN 30 THEN 'SALES'
         ELSE 'OPERATIONS'
       END as "Dept Name"
  FROM dept;


SELECT ename , sal,
       CASE
          WHEN sal < 1000  THEN sal+(sal*0.8)
          WHEN sal BETWEEN 1000 AND 2000 THEN sal+(sal*0.5)
          WHEN sal BETWEEN 2001 AND 3000 THEN sal+(sal*0.3)
          ELSE sal+(sal*0.1)
       END sal
  FROM emp;
  
  
-- 우리회사 직원중에 급여가 1000이상이고 3000이하인 직원들의 성명, 급여액을 출력하는 SQL문을 작성하시오.
SELECT ename, sal FROM emp WHERE sal BETWEEN 1000 AND 3000;

--존재하지 않으면 -1,존재하는데 일치하지 않으면 0  일치하면 1? 


SELECT CASE WHEN mem_id=:id THEN 1
       ELSE -1
       END as result
  FROM member;
  
  
SELECT 
        result
  FROM (
        SELECT CASE WHEN mem_id=:id THEN 1
            ELSE -1
            END as result
        FROM member
        )
ORDER BY result desc;


SELECT
        result
  FROM (
        SELECT CASE WHEN mem_id=:id THEN 1
               ELSE -1
               END as result
        FROM member
        ORDER BY result desc
        )
 WHERE rownum=1;
 
 select * from emp;