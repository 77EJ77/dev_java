SELECT deptno, dname, loc FROM dept

SELECT empno, ename, deptno FROM emp

SELECT empno, ename, deptno, dname FROM emp

SELECT 컬럼명1, 컬럼명2, COUNT(컬럼명3)
  FROM 집합1, 집합2,.... 카타시안의곱 - 묻지마조인 - 일어날 수 있는 모든경우의수

부적합할 식별자
열정의가 애매하다

SQLException대상 - > try..catch(SQLException se){}

양쪽 테이블에 모두 존재하나 인덱스인 컬럼명을 쓰는 것이 더 빠르다
카타시안곱 - 일어날 수 있는 모든 경우의 수이다. 다 나온다
emp - 14
dept - 4

SELECT count(empno) FROM emp

SELECT count(deptno) FROM dept

SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept
  
SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept
 WHERE emp.deptno = dept.deptno

Natural JOIN

SELECT empno, ename, dept.deptno, dname 
  FROM emp, dept
 WHERE emp.deptno = dept.deptno
   AND emp.ename = 'SMITH'   
   
--조건절을 사용하면 경우의 수가 줄어든다(그러니까 검색속도는 증가함)
--AND - 교집합 - 튜플의 수는 줄어든다.
--OR - 합집합 - 튜플의 수는 증가한다.

금융(제1금융-금융지주그룹, 2금융-증권사, 3금융-토마토저축, )  
보험, 물류, 회계, 통신- 과금
   
   

--SELECT empno FROM emp;

--옵티마이저에게 보내는 hint문 추가함

SELECT /*+ index_desc(emp pk_emp) */ empno
  FROM emp;

SELECT ename FROM emp;

SELECT ename FROM emp
ORDER BY ename asc;

1.1.월 급여는 연봉을 18로 나누어 홀수 달에는 연봉의 1/18이 지급되고, 
짝수달에는 연봉의 2/18가 지급된다고 가정했을 때 홀수 달과 짝수 달에 받을 금액을 나타내시오.

SELECT * FROM temp

SELECT 연산이 가능하다  FROM

SELECT 1+1, 500-300, 2*5, 5/2
  FROM temp
  
컬럼명이 늘어나면 가로가 길어짐

만일 로우를 늘어나게 하고 싶다면 어떡하지?
데이터를 복제하는 용도로 사용함

SELECT 1 FROM dual 
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual

합집합 - UNION ALL, UNION
교집합 - INTERSECT
차집합 - MINUS
  
SELECT 1+1, 500-300, 2*5, 5/2
  FROM dual  
  
--컬럼하나 로우하나짜리 가상 테이블을 지원함 dual  

SELECT emp_name, salary
  FROM temp
  
SELECT emp_name, salary, salary/18
  FROM temp  

SELECT emp_name, salary, salary/18, (salary*2)/18
  FROM temp 
  
SELECT emp_name, ROUND(salary/18,-1), ROUND((salary*2)/18, -1)
  FROM temp  
  
SELECT 123456.789,
       ROUND(123456.789,0) --소수 첫번째 자리에서 올림
      ,ROUND(123456.789,1) --소수 두번째 자리에서 올림
      ,ROUND(123456.789,-1)--일의 자리에서 올림
  FROM dual   
  
SELECT emp_name
     , ROUND(salary/18,-1)
     , ROUND((salary*2)/18, -1)
  FROM temp   
  
SELECT emp_name
     , to_char((ROUND(salary/18,-1)),'999,999,999')
     , to_char((ROUND((salary*2)/18, -1)),'999,999,999')
  FROM temp   
  
SELECT emp_name
     , to_char((ROUND(salary/18,-1)),'999,999,999')||'원' 
     , to_char((ROUND((salary*2)/18, -1)),'999,999,999')||'원'
  FROM temp  
  
-- 사칙연산 이 가능하다
-- 컬럼명 자리에 함수를 중첩해서 사용가능
-- 실제 테이블의 구조가 아닌 다른 구조로 출력이 가능하다
--예를 들어 고객이 원하는 테이블 구조대로 가능함  
  
SELECT emp_name as "사원명"
     , to_char((ROUND(salary/18,-1)),'999,999,999')||'원' as "홀수달"
     , to_char((ROUND((salary*2)/18, -1)),'999,999,999')||'원' as "짝수달"
  FROM temp
    

2.위에서 구한 월 급여에 교통비가 10만원씩 지급된다면(짝수달은 20만원)위의 문장이
어떻게 바뀔지 작성해 보시오.

SELECT emp_name
     , ROUND(salary/18,-1)+100000
     , ROUND((salary*2)/18, -1)+200000
  FROM temp 

3.TEMP 테이블에서 취미가 NULL 이 아닌 사람의 성명을 읽어오시오.

SELECT 
       emp_name, hobby
  FROM temp
  
SELECT 
       emp_name, hobby
  FROM temp  
 WHERE hobby IS NOT NULL

SELECT 
       emp_name, hobby
  FROM temp  
 WHERE hobby IS NULL
 
SELECT 
       emp_name, hobby
  FROM temp  
 WHERE hobby=NULL 

4.TEMP 테이블에서 취미가 NULL인 사람은 모두 HOBBY를 “없음”이라고 값을 치환하여 
가져오고 나머지는 그대로 값을 읽어오시오.

SELECT ename, NVL(comm, 0), comm FROM emp

SELECT emp_name, NVL(hobby,'없음'), hobby FROM temp

5.TEMP의 자료 중 HOBBY의 값이 NULL인 사원을 ‘등산’으로 치환했을 때 
HOBBY가 ‘등산인 사람의 성명을 가져오는 문장을 작성하시오.

SELECT emp_name, hobby
  FROM temp


SELECT emp_name, hobby
  FROM temp
 WHERE hobby IS NULL
 
SELECT emp_name, hobby
  FROM temp
 WHERE hobby = '등산' 

SELECT emp_name, hobby
  FROM temp
 WHERE NVL(hobby,'등산') = '등산' 

6.TEMP의 자료 중 EMP_ID와 EMP_NAME을 각각 ‘사번’,’성명’으로 표시되어 
DISPLAY되도록 COLUMN ALLIAS를 부여하여 SELECT 하시오.

SELECT emp_id as "사번", emp_name as "성명"
  FROM temp

7.TEMP의 자료를 직급 명(LEV)에 ASCENDING하면서 결과내에서 다시 사번 순으로
DESCENDING하게 하는 ORDER BY하는 문장을 만들어 보시오.

SELECT
       emp_id, emp_name, lev 
  FROM temp
  
SELECT
       emp_id, emp_name, lev 
  FROM temp
 ORDER BY lev asc  
 
SELECT
       emp_id, emp_name, lev 
  FROM temp
 ORDER BY lev asc, emp_id desc   
 
SELECT
       emp_id, emp_name, lev 
  FROM temp
 ORDER BY step asc, emp_id desc
 
SELECT * FROM t_letitbe

SELECT MOD(5,2), MOD(6,2), MOD(120,2) FROM dual

SELECT seq_vc
  FROM t_letitbe  
  
SELECT seq_vc
  FROM t_letitbe
ORDER BY seq_vc asc  

SELECT seq_vc
  FROM t_letitbe
ORDER BY to_number(seq_vc) asc

오라클에서 형전환함수가 있다.
to_char() 날짜-> 문자, 숫자 -> 문자

to_number(문자) -> 숫자타입으로 전환  

함수(파라미터1, 파라미터2)
함수는 리턴값이 있다.
함수는 파라미터를 맞춰야 한다.갯수와 타입 모두를 맞춰야 한다.

SELECT MOD(seq_vc,2)
  FROM t_letitbe
  
SELECT MOD(TO_NUMBER(seq_vc),2)
  FROM t_letitbe  
  
SELECT MOD(seq_vc,2)
  FROM t_letitbe
 WHERE seq_vc = 1  
 
SELECT MOD(seq_vc,2)
  FROM t_letitbe
 WHERE MOD(seq_vc,2) = 1   
 
SELECT MOD(seq_vc,2)
  FROM t_letitbe
 WHERE MOD(seq_vc,2) = 0 
 
SELECT MOD(seq_vc,2) as "no"
  FROM t_letitbe
 WHERE MOD(seq_vc,2) = 0  
 
SELECT MOD(seq_vc,2) as "no"
  FROM t_letitbe
 WHERE no = 0   
 
SELECT MOD(seq_vc,2) "no"
  FROM t_letitbe
 WHERE no = 0    
 
-- 조건절에 사용하는 컬럼은 반드시 집합에 있는 컬럼명만 가능하다 
 
SELECT MOD(seq_vc,2) no
  FROM t_letitbe
 WHERE no = 0  
 
SELECT empno, dname
  FROM emp 
  
-- 형 굳이 이렇게 하고 싶어요. 어떡하지?
-- 인라인뷰

SELECT
        no
  FROM (
        SELECT MOD(seq_vc,2) no
          FROM t_letitbe  
       )  
       
SELECT
        no
  FROM (
        SELECT MOD(seq_vc,2) no
          FROM t_letitbe  
       )  
 WHERE no = 1       
 
SELECT
       ename, sal
  FROM emp 
  
DECODE문 검색

SELECT
       DECODE(job, 'CLERK', sal, null)
  FROM emp  
  
SELECT DECODE(job, 'CLERK', sal, null)
      ,DECODE(job, 'SALESMAN', sal, null)
  FROM emp    
  
SELECT DECODE(job, 'CLERK', sal, null)
      ,DECODE(job, 'SALESMAN', sal, null)
      ,DECODE(job, 'CLERK',null, 'SALESMAN',null, sal)
  FROM emp  
  
SELECT SUM(DECODE(job, 'CLERK', sal, null))
      ,SUM(DECODE(job, 'SALESMAN', sal, null))
      ,SUM(DECODE(job, 'CLERK',null, 'SALESMAN',null, sal))
  FROM emp   
  
SELECT deptno, DECODE(deptno, 10 , 'ACCOUNTING' ,
                              20 , 'RESEARCH' ,
                              30 , 'SALES', 'OPERATIONS') name
  FROM dept;  
  
SELECT deptno, DECODE(deptno, 10 , SUM(sal),
                              20 , MAX(sal),
                              30 , MIN(sal)) sal
  FROM emp
 GROUP BY deptno;   
 
SELECT * FROM emp;

MAX
MIN
COUNT
AVG
SUM

SELECT SUM(empno), SUM(sal), SUM(comm) FROM emp;

SELECT SUM(sal) as "전체급여합"
      ,AVG(sal) as "급여평균"
      ,COUNT(empno) as "사원수"
  FROM emp

SELECT SUM(sal)
  FROM emp
  
SELECT distinct(deptno)
  FROM emp  
  
SELECT '10', SUM(sal)
  FROM emp
 WHERE deptno = 10  
UNION ALL 
SELECT '20', SUM(sal)
  FROM emp
 WHERE deptno = 20  
UNION ALL 
SELECT '30', SUM(sal)
  FROM emp
 WHERE deptno = 30    

SELECT deptno
  FROM emp
GROUP BY deptno
 
SELECT distinct(deptno)
  FROM emp 
  
SELECT SUM(sal) FROM emp

SELECT DECODE(job, 'CLERK', sal,null)
  FROM emp  
  
SELECT SUM(DECODE(job, 'CLERK', sal,null))
  FROM emp  
  
SELECT deptno, ename
  FROM emp
GROUP BY deptno, ename

SELECT deptno, ename
  FROM emp

SELECT deptno, count(ename)
  FROM emp
GROUP BY deptno

SELECT deptno, MAX(ename)
  FROM emp
GROUP BY deptno

SELECT deptno, MIN(ename)
  FROM emp
GROUP BY deptno
 
SELECT distinct(deptno),ename
  FROM emp   

SELECT
       deptno, SUM(sal)
  FROM emp 
GROUP BY deptno
 

-- 부서별로 급여 합계를 출력한다. 

SELECT NVL(DECODE(deptno, 10, sal),0) deptno10, 
       NVL(DECODE(deptno, 20, sal),0) deptno20,
       NVL(DECODE(deptno, 30, sal),0) deptno30,
       NVL(DECODE(deptno, 40, sal),0) deptno40
  FROM emp

SELECT NVL(SUM(DECODE(deptno, 10, sal)),0) deptno10, 
       NVL(SUM(DECODE(deptno, 20, sal)),0) deptno20,
       NVL(SUM(DECODE(deptno, 30, sal)),0) deptno30,
       NVL(SUM(DECODE(deptno, 40, sal)),0) deptno40
  FROM emp


SELECT deptno, NVL(SUM(DECODE(deptno, 10, sal)),0) deptno10, 
               NVL(SUM(DECODE(deptno, 20, sal)),0) deptno20,
               NVL(SUM(DECODE(deptno, 30, sal)),0) deptno30,
               NVL(SUM(DECODE(deptno, 40, sal)),0) deptno40
  FROM emp
 GROUP BY deptno; 
 
SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp 

SELECT deptno, 
       CASE deptno
         WHEN 10 THEN 'ACCOUNTING'
         WHEN 20 THEN 'RESEARCH'
         WHEN 30 THEN 'SALES'
         ELSE 'OPERATIONS'
       END as "Dept Name"
  FROM dept;
  
SELECT deptno, DECODE(deptno, 10, 'ACCOUNTING'
                    , 20, 'RESEARCH'
                    , 30, 'SALES'
                    , 'OPERATIONS')
  FROM dept;
  
SELECT ename , sal,
       CASE
          WHEN sal < 1000  THEN sal+(sal*0.8)
          WHEN sal BETWEEN 1000 AND 2000 THEN sal+(sal*0.5)
          WHEN sal BETWEEN 2001 AND 3000 THEN sal+(sal*0.3)
          ELSE sal+(sal*0.1)
       END sal
  FROM emp;   
  
우리회사 직원중에 급여가 1000이상이고 3000이하인 직원들의 성명, 급여액을 
출력하는 SQL문 작성하시오.

SELECT
       ename, sal
  FROM emp
  
SELECT
       ename, sal
  FROM emp
 WHERE sal >= 2000
   AND sal <= 3000   
   
SELECT
       ename, sal
  FROM emp
 WHERE sal >= 2000
    OR sal <= 3000     
   
SELECT
       ename, sal
  FROM emp
 WHERE sal BETWEEN 2000 AND 3000 
 
 
SELECT * FROM member

SELECT CASE WHEN mem_id=:id THEN 1
       ELSE -1      
       END as result
  FROM member
  
SELECT CASE WHEN mem_id=:id THEN 1
       ELSE -1      
       END as result
  FROM member
ORDER by result desc  

SELECT
       result
  FROM (
        SELECT CASE WHEN mem_id=:id THEN 1
               ELSE -1      
               END as result
          FROM member
        ORDER by result desc 
       )
       
SELECT
       result
  FROM (
        SELECT CASE WHEN mem_id=:id THEN 1
               ELSE -1      
               END as result
          FROM member
        ORDER by result desc 
       )
 WHERE rownum = 1              

 