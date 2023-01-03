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


CREATE TABLE HR.TEMP
(
  EMP_ID      NUMBER                            NOT NULL,
  EMP_NAME    VARCHAR2(10 BYTE)                 NOT NULL,
  BIRTH_DATE  DATE,
  DEPT_CODE   VARCHAR2(6 BYTE)                  NOT NULL,
  EMP_TYPE    VARCHAR2(4 BYTE),
  USE_YN      VARCHAR2(1 BYTE)                  NOT NULL,
  TEL         VARCHAR2(15 BYTE),
  HOBBY       VARCHAR2(30 BYTE),
  SALARY      NUMBER,
  LEV         VARCHAR2(4 BYTE),
  STEP        NUMBER(5)
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;
?
?
--  There is no statement for index HR.SYS_C0011993.
--  The object is created when the parent object is created.
?
ALTER TABLE HR.TEMP ADD (
  PRIMARY KEY
  (EMP_ID)
  USING INDEX
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE);
  
  
SELECT 연산이 가능하다 FROM;

SELECT 1+1, 500-300, 2*5, 5/2
  FROM TEMP;
  
SELECT * FROM DBA_USERS;


