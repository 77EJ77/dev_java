-- SCOTT

SELECT  distinct(deptno)
  FROM  emp;

SELECT
        ename
  FROM  emp
GROUP BY ename;

SELECT
        deptno
  FROM  emp
GROUP BY deptno;

-- �׷��Լ�
SELECT
        MAX(ename), deptno
  FROM  emp
GROUP BY deptno;

SELECT
        deptno
  FROM  emp
GROUP BY  deptno;

SELECT
        deptno, AVG(sal)
  FROM  emp
GROUP BY  deptno;

--HAVING -> GROUP BY�� ���� ���Ǽ����� ���
SELECT
        deptno, AVG(sal)
  FROM  emp
GROUP BY  deptno
HAVING avg(sal) >= 2000;


-- 04-001.sql
-- ��1) �ִ� ���� �ð��� ~~~~  ���� ���� �Ϲݰ��� �����ϸ� NULL ...~> �������...
SELECT
        DECODE(lec_time, lec_point, '�Ϲݰ���')
  FROM lecture;

SELECT
        DECODE(lec_time, lec_point, '�Ϲݰ���', NULL)
  FROM lecture;

SELECT
        DECODE(lec_time, lec_point, '�Ϲݰ���', 'Ư������')
  FROM lecture;
  
-- ��2) �ְ� ���� �ð��� ������ ���� ������ ���ڸ� �˰�ʹ�.
SELECT
        COUNT(DECODE(lec_time, lec_point, '��')) as "���� ���� ����"
  FROM lecture;
  
-- ��) ���� �ð��� ������ ������ 1�� ��ȯ�Ѵ�
SELECT
        DECODE(lec_time, lec_point, 1)
  FROM lecture;

-- NULL�� �𸥴� �������� �ʾҴ�
-- SUM�� �� �ֳ�? COUNT?

SELECT  lec_time, lec_point
        , DECODE(lec_time, lec_point, 1)
  FROM  lecture;

SELECT
        DECODE(job, 'CLERK', sal)
  FROM  emp;

SELECT
        SUM(DECODE(job, 'CLERK', sal)) as "CLERK�� �޿� ��"
       ,COUNT(DECODE(job, 'CLERK', sal)) as "CLERK�� �ο�"
  FROM  emp;

SELECT COUNT(*) FROM lecture
 WHERE lec_time = lec_point;

SELECT 1 FROM lecture
 WHERE lec_time = lec_point;

SELECT COUNT(1) FROM lecture
 WHERE lec_time = lec_point;

SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual;

SELECT 1, 2, 3 FROM dual;

-- ��3)time�� ũ�� �������, point�� ũ�� ��Ÿ����, ���� ������ �Ϲݰ������� �����ް��� ��.
-- DECODE�� ���ٸ� �񱳰���

-- HINT
SELECT 120-10, (10-120), 0-0, 500-500
  FROM dual;
  
SELECT SIGN(120-10), SIGN(10-120), 0-0, 500-500, SIGN(10-25), SIGN(1+6), SIGN(400-400)
  FROM dual;

SELECT lec_time, lec_point,
        DECODE(SIGN(lec_time-lec_point), 0, '�Ϲݰ���', 1, '�������', '��Ÿ����') as "����з�"
  FROM lecture;

SELECT to_char(sysdate, 'DD') FROM dual;

SELECT to_char(sysdate, 'DAY') FROM dual;

SELECT '04'||'21' FROM dual;

SELECT
        DECODE (to_char(sysdate, 'DAY'), '������', '01'
                                       , 'ȭ����', '11'
                                       , '������', '21'
                                       , '�����', '31'
                                       , '�ݿ���', '41'
                                       , '�����', '51'
                                       , '�Ͽ���', '61') FROM dual;

SELECT to_char(sysdate, 'DD')
        ||
        DECODE (to_char(sysdate, 'DAY'), '������', '01'
                                       , 'ȭ����', '11'
                                       , '������', '21'
                                       , '�����', '31'
                                       , '�ݿ���', '41'
                                       , '�����', '51'
                                       , '�Ͽ���', '61') as "������ ���"
  FROM dual;

-- 1) ���� ���縸 ������ �ϱ�

SELECT
        MOD(seq_vc, 2), seq_vc, words_vc
  FROM  t_letitbe;

SELECT
        MOD(seq_vc, 2) as "num", seq_vc
      , DECODE(MOD(seq_vc, 2), 1, words_vc, NULL)
  FROM  t_letitbe
 WHERE MOD(seq_vc, 2) = 1; 
-- num�� where���� ���� �� ���� ���� �÷��̴ϱ�.

-- num�� ��Ī���� t_letitbe�� �����ϴ� �÷��� �ƴϴ�
-- ���� where���� ����� �Ұ���
-- ���� �ذ��ϴ� ��� -> �ζ��κ並 ����ϸ� �����ϴ�.
-- �ζ��κ並 ����ؼ� ������ ����(�÷�, �ο찪-where) �� �� �ִ�.

SELECT * FROM emp
WHERE sal > 3000;

-- �ζ��κ�� FROM �ڿ� ���� SELECT ���� ���Ѵ�.
-- �Ʒ�ó�� �ۼ��ϸ� ��Ī�� ���������� ��� ������
-- �� �÷����� �ش� ���̺� �������� �ʴ� �÷��̾
SELECT
        *
  FROM (
          SELECT
                MOD(seq_vc, 2) num, seq_vc
              , DECODE(MOD(seq_vc, 2), 1, words_vc, NULL)
          FROM  t_letitbe
        ) a
 WHERE a.num = 1;

-- 2) �ѱ� ���縸 ������ �ϱ�
SELECT
        MOD(seq_vc, 2) as "num", seq_vc
      , DECODE(MOD(seq_vc, 2), 0, words_vc, NULL)
  FROM  t_letitbe
 WHERE MOD(seq_vc, 2) = 1; 

-- 3) �Ѵ� ������ �ϱ�
-- * : ���ϵ� ī�� - ���տ� �����ϴ� ��� �÷��� ���Ѵ�.
-- ������ �����̳� Ȯ�ο����θ� ����ϼ��� �ڹ� �ڵ忡�� ����ϸ� ���������� �ʾƼ� �������� �ʽ��ϴ� IT������Ʈ�� ���� ��� �� �������� ����ǹǷ� �ٸ� �����ڸ� ���� ����Դϴ�

SELECT
        seq_vc
      , DECODE(MOD(seq_vc, 2), 1, words_vc) A
  FROM  t_letitbe
UNION ALL
SELECT
        seq_vc
      , DECODE(MOD(seq_vc, 2), 0, words_vc) A
  FROM  t_letitbe;

SELECT
        seq_vc, MAX(A)
  FROM (
            SELECT
                    seq_vc
                  , DECODE(MOD(seq_vc, 2), 1, words_vc) A
              FROM  t_letitbe
            UNION ALL
            SELECT
                    seq_vc
                  , DECODE(MOD(seq_vc, 2), 0, words_vc) A
              FROM  t_letitbe
        )
GROUP BY seq_vc
ORDER BY to_number(seq_vc) asc;

SELECT seq_vc, words_vc From t_letitbe;

-- ��ü�� ���������̼� ���������ϳ� �ǵ����̸� �ٿ�����. �߰��� ���Ⱑ �ִ� ���� ���� �Ұ�
SELECT
        empno �����ȣ,
        empno as "�����ȣ",
        empno "�����ȣ",
        empno "��� ��ȣ"
  FROM emp;

-- CASE..WHEN ���� ����
-- ���̵� �����ϴ��� ���� üũ�� ���� ���� �����ϸ� ����� üũ�Ѵ�
-- �������� �ʴ� ����� -1 �����Ѵ�
-- ���̵�� ���������� ����� Ʋ���� 0�� �����Ѵ�               ->�ڹ��� ���� ������ �ʰ� ����Ŭ���� �̿��ϸ� ������ ȿ������ �������ϱ�
SELECT
        result
  FROM (
        SELECT CASE WHEN mem_id=:id THEN
               CASE WHEN mem_pw=:pw THEN 1
               ELSE 0
               END
               ELSE -1
               END as result
          FROM member
        ORDER BY result desc
        )
WHERE rownum = 1;


-- ��������
-- tmep�� �ڷḦ salary�� �з��Ͽ� 30,000,000���ϴ� 'D',
-- 30,000,000 �ʰ� 50,000,000���ϴ� 'C'
-- 50,000,000 �ʰ� 70,000,000���ϴ� 'B'
-- 70,000,000 �ʰ��� 'A'��� ����� �з��Ͽ� ��޺� �ο�����
-- �˰� �ʹ�.
 SELECT 
         CASE
            WHEN salary <= 30000000 THEN 'D'
            WHEN salary BETWEEN 30000001 AND 50000000 THEN 'C'
            WHEN salary BETWEEN 50000001 AND 70000000 THEN 'B'
            WHEN salary > 70000000 THEN 'A'
         END
         ,COUNT(salary)
    FROM temp
    GROUP BY CASE
            WHEN salary <= 30000000 THEN 'D'
            WHEN salary BETWEEN 30000001 AND 50000000 THEN 'C'
            WHEN salary BETWEEN 50000001 AND 70000000 THEN 'B'
            WHEN salary > 70000000 THEN 'A'
         END;



-- ����1
-- ��ȭ Ƽ���� ���� �� �ִ� ����� ��ܰ� ���� ������ �ִ� ����Ʈ, ��ȭ Ƽ���� ����Ʈ �׸��� �� Ƽ���� ����� �� ���� ���� ����Ʈ�� ����Ͻÿ�.
SELECT
        m.point_nu as "ȸ���� ������ ����Ʈ"
       ,g.point_nu as "��ǰ�� ����Ʈ"
       ,m.point_nu-g.point_nu as "����Ʈ �ܾ�"
  FROM t_giftmem m, t_giftpoint g
 WHERE  g.name_vc='��ȭƼ��' and m.point_nu-g.point_nu > 0
 
 SELECT
        m.point_nu as "ȸ���� ������ ����Ʈ"
       ,g.point_nu as "��ǰ�� ����Ʈ"
       ,m.point_nu-g.point_nu as "����Ʈ �ܾ�"
  FROM t_giftmem m, t_giftpoint g
-- ���ڿ� �񱳽ÿ��� '' / as ""
-- īŸ�þ��� ��

-- ����2 ***** Ǫ�� ��
-- �����ž��� �����ϰ� �ִ� ���ϸ��� ����Ʈ�� ���� �� �ִ� ��ǰ �� ���� ����Ʈ�� ���� ���� �����ΰ�?
SELECT MAX()
  FROM  (
            SELECT  g.name_vc as "��ǰ��"
                   ,g.point_nu as "��ǰ ����Ʈ"
              FROM t_giftmem m, t_giftpoint g
             WHERE m.name_vc = '������' AND m.point_nu-g.point_nu > 0
        )


-- ���� ���¿���
-- 1:1 -> ��� - �������̺�
-- 1:N -> ��� - �μ����̺�
-- N:N -> ȸ�� - ��ǰ / �л� - ������...
-- : ������ ���� ���ǰ� �� �� ����̴�.īŸ�þ��� ���� �߻��ϹǷ� �����ϸ� �ȵȴ�.(�ǹ� ���� ��-������ ��)
-- ERD�� �� �� �־�� ��
-- n:n�� ���踦 1:n���� ����� �ִ� ������ƼƼ(������ƼƼ)�� ã�� ���� �߿��ϴ�.

-- ��1����ȭ : �ߺ��Ǵ� ���� �������� �ʴ´� -> �ߺ�����
-- ��2����ȭ : ����Ű ��ο� �������� �÷��� ����. -> ������ƼƼ �Ǵ� ������ƼƼ
-- ��3����ȭ : ���̺� �������·� FK�� �����ϴ� ��� PK�� �ƴ� FK�� �������� �÷��� �����ϸ� �ȵ�
-- Natural JOIN // OUTER JOIN // SELF JOIN �� �߰ɸ� ��


-- CASE...WHEN

SELECT * FROM zipcode_t;

-- ��з� // �ߺз� // �Һз� ����

SELECT '��ü' FROM dual
UNION ALL
SELECT zdo FROM zipcode_t group by zdo;

-- order by ���� union all ���� �� �� ���µ���

-- �ζ��κ�
SELECT '��ü' zdo FROM dual
UNION ALL
SELECT zdo 
  FROM (
            SELECT distinct(zdo) zdo
            FROM zipcode_t
            order by zdo asc
         );

SELECT '��ü' sigu FROM dual
UNION ALL
SELECT sigu 
  FROM (
            SELECT distinct(sigu) sigu
            FROM zipcode_t
            where zdo=:zdo
            order by sigu asc
        );

SELECT '��ü' FROM dual
UNION ALL
SELECT dong 
  FROM (
            SELECT distinct(dong) dong
            FROM zipcode_t
            where zdo=:zdo AND sigu=:sigu
            order by dong asc
        );