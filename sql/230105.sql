
--230104 문1 풀이) 회원과 상품의 관계는 N:N임.
SELECT point_nu as "상품포인트"
FROM t_giftpoint
WHERE name_vc = '영화티켓'

--뭐라고 일을 시킴?

-- 사원번호를 채번하는 쿼리 MAX+1 최댓값에 +1함
-- 사원을 등로하는 업무를 처리 -> 사원정보 등록시에 사원번호 채번해서 가장 큰 값 +1해서 뽑기
SELECT MAX(EMPNO)+1 as "사원번호 채번" FROM EMP;

SELECT EMPNO FROM EMP;


SELECT EMPNO+1 as "사원번호 채번" FROM EMP;


-- rownum : 스탑키 => rownum=1이면 한개 값을 남겨두는?
SELECT EMPNO FROM EMP WHERE rownum=1;

SELECT MIN(EMPNO) FROM EMP;


SELECT
        empno+1
  FROM (
        SELECT
                empno
          FROM emp
         ORDER BY empno desc
        )
 WHERE rownum=1
 
SELECT
       /*+index_desc(emp pk_emp) */ empno
  FROM emp
 
SELECT
       /*+index_desc(emp pk_emp) */ empno
  FROM emp
WHERE rownum =1


-- /*+ */는 힌트문이라고 한다.
-- 힌트문은 개발자가 옵티마이저에게 실행에 대한 요청이나 생각을 전달할 수 있는 문장임.
-- 만일 힌트문에 오타나 오류가 있더라도 에러가 발생하지는 않음. 다만 무시당함.
-- 옵티마이저에게 내 생각을 전달할 때 사용한다고 생각하면 됨.
-- 아래에서는 사원번호 최댓값을 찾아야 하는데 다행히 empno가 PK라서 index가 제공되기 때문에 ORDER BY를 쓰지 않아도 정렬이 일어남.
-- SELECT ename FROM emp는 정렬이 되지 않는 것은 그 이유 때문임.
-- 인덱스가 있는 경우에는 인덱스 이름이 있는데 이것을 이용해 힌트문으로 옵티마이저에게 개발자의 실행계획이나 의도를 전달할 수 있음.
-- 인덱스의 경우 디폴트가 오름차순으로 정렬되어있는데 힌트문을 이용해서 인덱스 access시에 내림차순으로 읽어올 것을 요청하는 것임. 그러나 무시될 수도 있다는 게 함정.
-- 옵티마이저의 동작 원리에는 >>  [rule base] 옵티마이저 모드와      >> 15규칙에 순서에 따라 실행계획을 가져가는 방식임.
--                            :수동카메라 - 개발자가 본인의 의도대로 조작이 가능.
--                       >>  [cost base] 옵티마이저 모드가 있음  >> 이것은 데이터의 분포도와 통계자료를 바탕으로 실행계획을 가져가는 방식.
--                            :데이터의 분포도가 최신인가가 중요함 -> 잘못된 선택이 된다. -자동카메라 -효과적인 실행계획을 가져갈 확률이 높다.


-- NESTED LOOPS 너하나 나하나 찾는 방식
SELECT /*+ rule*/
        empno, ename, dname
  FROM emp, dept
 WHERE emp.deptno = dept.deptno;
 
SELECT /*+ all_rows*/
        empno, ename, dname
  FROM emp, dept
 WHERE emp.deptno = dept.deptno;

-- 데이터의 물리적 위치를 나타냄. rowid ~ 실제적인 위치값
SELECT rowid rno FROM EMP;

SELECT EMPNO FROM EMP WHERE rowid='AAARE8AAEAAAACTAAC';

-- ROWID : DBMS가 가지고 있는 모든 데이터의 각각의 고유한 식별자
-- 이 ROWID는 INDEX와도 깊은 관련이 있는데 INDEX테이블은 INDEX KEY와 ROWID로 이루어져 있기 때문이다.
-- 이렇게 저장공간을 가지고 있는 ROWID는 마치 물리적인 정보라고 생각할 수 있지만 실제로는 존재하지 않으며
-- INDEX테이블 내에 있는 ROWID는 해당 데이터를 찾기 위한 하나의 논리적인 정보일 뿐이다.
-- ROWID
-- ------ --- ------ ---
-- AAAArs AAD AAAAUa AAA
--    1    2    3    4
-- 1) 6자리 : 데이터 오브젝트 번호
-- 2) 3자리 : 상대적 파일 번호
-- 3) 6자리 : 블록번호
-- 4) 3자리 : 블록 내의 행 번호

-- IO BLOCK?
-- 체이닝 현상 -> 한 칸에 더 이상 들어갈 수 없을 때 옆집 차지함. 그러면 한 사람의 정보를 읽는데 두 칸을 읽어와야하니까 속도가 느려짐.


-- 2023년 1월 4일 숙제 풀이
SELECT * FROM t_giftmem;

SELECT point_nu FROM t_giftpoint
 WHERE name_vc = '영화티켓';
-- WHERE 회원집합.point_nu >= 상품집합.point_nu
-- 1-1)
SELECT mem.name_vc as "회원명",
       mem.point_nu as "회원 보유 포인트",
       TO_CHAR(mem.point_nu - poi.point_nu, '999,999') || '점' as "잔여포인트"
  FROM (
         SELECT point_nu FROM t_giftpoint
         WHERE name_vc = '영화티켓'
       ) poi, t_giftmem mem
 WHERE mem.point_nu >= poi.point_nu;

-- 1-2)
SELECT mem.name_vc as "회원명",
       mem.point_nu as "회원 보유 포인트",
       TO_CHAR(mem.point_nu - poi.point_nu, '999,999') || '점' as "잔여포인트"
  FROM t_giftpoint poi, t_giftmem mem
 WHERE mem.point_nu >= poi.point_nu
   AND poi.name_vc = '영화티켓';

-- 2)
SELECT '한과세트', '김유신' FROM dual; --이런 결과

-- 카타시안의 곱 일어나 일어날 수 있는 모든 경우의 수가 조회 될 것이다.
-- 그룹함수와 일반 선택은 같이 사용할 수 없다.
SELECT
        poi.name_vc, mem.name_vc, poi.point_nu
  FROM t_giftpoint poi, t_giftmem mem
 WHERE mem.name_vc='김유신'
   AND poi.point_nu <= mem.point_nu;

SELECT
        MAX(poi.point_nu)
  FROM t_giftpoint poi, t_giftmem mem
 WHERE mem.name_vc='김유신'
   AND poi.point_nu <= mem.point_nu;

SELECT name_vc, point_nu
  FROM t_giftpoint
 WHERE point_nu = (
                     SELECT
                            MAX(poi.point_nu)
                      FROM t_giftpoint poi, t_giftmem mem
                     WHERE mem.name_vc='노정환'
                       AND poi.point_nu <= mem.point_nu
                    );