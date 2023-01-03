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
  
  
SELECT ������ �����ϴ� FROM;

SELECT 1+1, 500-300, 2*5, 5/2
  FROM TEMP;
  
SELECT * FROM DBA_USERS;


