SELECT deptno, dname, loc FROM dept;

SELECT empno, ename, deptno FROM emp;

--SELECT �÷���1, �÷���2, COUNT(�÷���3) FROM ����1, ����2, ... īŸ�þ��� �� -������ ���� -�Ͼ �� �ִ� ��� ����� ���� �� ������

SELECT empno, ename, deptno, dname 
  FROM emp, dept;
    
SELECT empno FROM emp; --�ε����� ����Ʈ���� ��������

SELECT ename FROM emp ORDER BY ename asc;--������ 2������

--�������� �ĺ��� / �����ǰ� �ָ��ϴ� -> SQLException��� -> try-catch(){}�ʿ�
--ctrl+B -> �ּ�
--��Ƽ���������� ������ hint�� �߰���-> �׳�--


--���� ���̺� ��� �����ϳ� �ε����� �÷����� ���� ���� �� ������
--īŸ�þ��� �� -������ ���� -�Ͼ �� �ִ� ��� ����� ���� �� ������
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

--�������� ����ϸ� ����� ���� �پ���(�׷��ϱ� �˻� �ӵ��� ������)
--AND - ������ - Ʃ���� ���� �پ���.
--OR - ������ - Ʃ���� ���� �����Ѵ�.


--1.1.�� �޿��� ������ 18�� ������ Ȧ�� �޿��� ������ 1/18�� ���޵ǰ�, ¦���޿��� ������ 2/18�� ���޵ȴٰ� �������� �� Ȧ�� �ް� ¦�� �޿� ���� �ݾ��� ��Ÿ���ÿ�.
SELECT emp_name, ROUND(salary/18), ROUND((salary*2)/18) FROM temp;

SELECT emp_name
     , to_char((ROUND(salary/18, -1)), '999,999,999')||'��'
     , to_char((ROUND((salary*2)/18, -1)), '999,999,999')||'��'
  FROM temp;
  
SELECT emp_name as "�����"
     , to_char((ROUND(salary/18, -1)), '999,999,999')||'��' as "Ȧ����"
     , to_char((ROUND((salary*2)/18, -1)), '999,999,999')||'��' as "¦����"
  FROM temp;

--2.������ ���� �� �޿��� ����� 10������ ���޵ȴٸ�(¦������ 20����)���� ������
--��� �ٲ��� �ۼ��� ���ÿ�.
SELECT emp_name as "�����"
     , to_char((ROUND(salary/18, -1))+100000, '999,999,999')||'��' as "Ȧ����"
     , to_char((ROUND((salary*2)/18, -1))+200000, '999,999,999')||'��' as "¦����"
  FROM temp;

--3.TEMP ���̺��� ��̰� NULL �� �ƴ� ����� ������ �о���ÿ�.

SELECT
        emp_name, hobby
  FROM temp
 WHERE hobby IS NULL;
--WHERE hobby=NULL;
 
SELECT
        emp_name, hobby
  FROM temp
 WHERE hobby IS NOT NULL;
 
--4.TEMP ���̺��� ��̰� NULL�� ����� ��� HOBBY�� ���������̶�� ���� ġȯ�Ͽ� �������� �������� �״�� ���� �о���ÿ�.
SELECT ename, NVL(hobby, '����'), hobby FROM temp;
SELECT ename, NVL(comm, 0), hobby FROM temp;

--5.TEMP�� �ڷ� �� HOBBY�� ���� NULL�� ����� ����ꡯ���� ġȯ���� �� HOBBY�� ������� ����� ������ �������� ������ �ۼ��Ͻÿ�.
SELECT ename FROM temp WHERE NVL(hobby, '���')="���";

--6.TEMP�� �ڷ� �� EMP_ID�� EMP_NAME�� ���� �������,���������� ǥ�õǾ� DISPLAY�ǵ��� COLUMN ALLIAS�� �ο��Ͽ� SELECT �Ͻÿ�.
SELECT emp_id as "���", emp_name as "����" FROM temp;

--7.TEMP�� �ڷḦ ���� ��(LEV)�� ASCENDING�ϸ鼭 ��������� �ٽ� ��� ������ DESCENDING�ϰ� �ϴ� ORDER BY�ϴ� ������ ����� ���ÿ�.
--SELECT emp_id, emp_name, lev FROM temp;
SELECT emp_id, emp_name, lev FROM temp ORDER BY step asc, emp_id desc;


  
SELECT ������ �����ϴ� FROM;

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
 
-- ����Ŭ���� ����ȯ�Լ��� �ִ�.
-- to_char() ��¥ -> ����, ���� -> ����
-- to_number(����) -> ����

--�Լ�(�Ķ����1, �Ķ����2)
--�Լ��� ���ϰ��� �ִ�.�Լ��� �Ķ���͸� ����� �Ѵ�.������ Ÿ�� ��θ� ������Ѵ�.

SELECT MOD(to_number(seq_vc), 2) as "no" FROM t_letitbe;

-- �������� ����ϴ� �÷��� �ݵ�� ���տ� �ִ� �÷��� �����ϴ�.

-- �ζ��κ�
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
-- DECODE�� �˻�
-- ũ���۴�X ifX ������ ���ٸ� ����
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
SELECT AVG(sal) as "�޿����", SUM(sal) as "�޿��հ�", COUNT(empno) as "�����" FROM emp;

SELECT AVG(sal) FROM emp;


-- distinct -> �ߺ����� �Լ�
SELECT distinct (deptno)
  FROM emp;

SELECT e.deptno, d.dname, SUM(e.sal) as "�μ��� �޿� ����" FROM emp e, dept d GROUP BY e.deptno, d.dname, e.sal;


SELECT emp.deptno, SUM(sal) as "�μ��� �޿� ����" FROM emp , dept GROUP BY emp.deptno;

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


-- �μ����� �޿� �հ踦 ����Ѵ�.
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
  
  
-- �츮ȸ�� �����߿� �޿��� 1000�̻��̰� 3000������ �������� ����, �޿����� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT ename, sal FROM emp WHERE sal BETWEEN 1000 AND 3000;

--�������� ������ -1,�����ϴµ� ��ġ���� ������ 0  ��ġ�ϸ� 1? 


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