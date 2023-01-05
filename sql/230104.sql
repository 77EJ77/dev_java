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

-- 그룹함수
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

--HAVING -> GROUP BY에 대한 조건설정시 사용
SELECT
        deptno, AVG(sal)
  FROM  emp
GROUP BY  deptno
HAVING avg(sal) >= 2000;


-- 04-001.sql
-- 문1) 주당 강의 시간과 ~~~~  같을 때는 일반과목 생략하면 NULL ...~> 못들었음...
SELECT
        DECODE(lec_time, lec_point, '일반과목')
  FROM lecture;

SELECT
        DECODE(lec_time, lec_point, '일반과목', NULL)
  FROM lecture;

SELECT
        DECODE(lec_time, lec_point, '일반과목', '특별과목')
  FROM lecture;
  
-- 문2) 주간 강의 시간과 학점이 같은 강의의 숫자를 알고싶다.
SELECT
        COUNT(DECODE(lec_time, lec_point, '뭐')) as "같은 강의 숫자"
  FROM lecture;
  
-- 문) 강의 시간과 학점이 같으면 1을 반환한다
SELECT
        DECODE(lec_time, lec_point, 1)
  FROM lecture;

-- NULL은 모른다 결정되지 않았다
-- SUM할 수 있나? COUNT?

SELECT  lec_time, lec_point
        , DECODE(lec_time, lec_point, 1)
  FROM  lecture;

SELECT
        DECODE(job, 'CLERK', sal)
  FROM  emp;

SELECT
        SUM(DECODE(job, 'CLERK', sal)) as "CLERK의 급여 합"
       ,COUNT(DECODE(job, 'CLERK', sal)) as "CLERK의 인원"
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

-- 문3)time이 크면 실험과목, point가 크면 기타과목, 둘이 같으면 일반과목으로 돌려받고자 함.
-- DECODE는 같다만 비교가능

-- HINT
SELECT 120-10, (10-120), 0-0, 500-500
  FROM dual;
  
SELECT SIGN(120-10), SIGN(10-120), 0-0, 500-500, SIGN(10-25), SIGN(1+6), SIGN(400-400)
  FROM dual;

SELECT lec_time, lec_point,
        DECODE(SIGN(lec_time-lec_point), 0, '일반과목', 1, '실험과목', '기타과목') as "과목분류"
  FROM lecture;

SELECT to_char(sysdate, 'DD') FROM dual;

SELECT to_char(sysdate, 'DAY') FROM dual;

SELECT '04'||'21' FROM dual;

SELECT
        DECODE (to_char(sysdate, 'DAY'), '월요일', '01'
                                       , '화요일', '11'
                                       , '수요일', '21'
                                       , '목요일', '31'
                                       , '금요일', '41'
                                       , '토요일', '51'
                                       , '일요일', '61') FROM dual;

SELECT to_char(sysdate, 'DD')
        ||
        DECODE (to_char(sysdate, 'DAY'), '월요일', '01'
                                       , '화요일', '11'
                                       , '수요일', '21'
                                       , '목요일', '31'
                                       , '금요일', '41'
                                       , '토요일', '51'
                                       , '일요일', '61') as "오늘의 비번"
  FROM dual;

-- 1) 영어 가사만 나오게 하기

SELECT
        MOD(seq_vc, 2), seq_vc, words_vc
  FROM  t_letitbe;

SELECT
        MOD(seq_vc, 2) as "num", seq_vc
      , DECODE(MOD(seq_vc, 2), 1, words_vc, NULL)
  FROM  t_letitbe
 WHERE MOD(seq_vc, 2) = 1; 
-- num을 where문에 넣을 수 없음 없는 컬럼이니까.

-- num은 별칭이지 t_letitbe에 존재하는 컬럼이 아니다
-- 따라서 where절에 사용이 불가함
-- 문제 해결하는 방법 -> 인라인뷰를 사용하면 가능하다.
-- 인라인뷰를 사용해서 집합을 가공(컬럼, 로우값-where) 할 수 있다.

SELECT * FROM emp
WHERE sal > 3000;

-- 인라인뷰는 FROM 뒤에 오는 SELECT 문을 말한다.
-- 아래처럼 작성하면 별칭을 조건절에서 사용 가능함
-- 그 컬럼명이 해당 테이블에 존재하지 않는 컬럼이어도
SELECT
        *
  FROM (
          SELECT
                MOD(seq_vc, 2) num, seq_vc
              , DECODE(MOD(seq_vc, 2), 1, words_vc, NULL)
          FROM  t_letitbe
        ) a
 WHERE a.num = 1;

-- 2) 한글 가사만 나오게 하기
SELECT
        MOD(seq_vc, 2) as "num", seq_vc
      , DECODE(MOD(seq_vc, 2), 0, words_vc, NULL)
  FROM  t_letitbe
 WHERE MOD(seq_vc, 2) = 1; 

-- 3) 둘다 나오게 하기
-- * : 와일드 카드 - 집합에 존재하는 모든 컬럼을 말한다.
-- 데이터 검증이나 확인용으로만 사용하세요 자바 코드에서 사용하면 직관적이지 않아서 권장하지 않습니다 IT프로젝트는 거의 모두 다 협업으로 진행되므로 다른 개발자를 위한 배려입니다

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

-- 대체로 더블쿼테이션 생략가능하나 되도록이면 붙여주자. 중간에 띄어쓰기가 있는 경우는 생략 불가
SELECT
        empno 사원번호,
        empno as "사원번호",
        empno "사원번호",
        empno "사원 번호"
  FROM emp;

-- CASE..WHEN 구문 연습
-- 아이디가 존재하는지 먼저 체크해 보고 만일 존재하면 비번을 체크한다
-- 존재하지 않는 경우라면 -1 리턴한다
-- 아이디는 존재하지만 비번이 틀리면 0을 리턴한다               ->자바의 힘을 빌리지 않고 오라클만을 이용하면 업무의 효율성이 높아지니까
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


-- 도전문제
-- tmep의 자료를 salary로 분류하여 30,000,000이하는 'D',
-- 30,000,000 초과 50,000,000이하는 'C'
-- 50,000,000 초과 70,000,000이하는 'B'
-- 70,000,000 초과는 'A'라고 등급을 분류하여 등급별 인원수를
-- 알고 싶다.
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



-- 문제1
-- 영화 티켓을 받을 수 있는 사람의 명단과 현재 가지고 있는 포인트, 영화 티켓의 포인트 그리고 그 티켓을 사용한 후 남은 예상 포인트를 출력하시오.
SELECT
        m.point_nu as "회원이 보유한 포인트"
       ,g.point_nu as "상품의 포인트"
       ,m.point_nu-g.point_nu as "포인트 잔액"
  FROM t_giftmem m, t_giftpoint g
 WHERE  g.name_vc='영화티켓' and m.point_nu-g.point_nu > 0
 
 SELECT
        m.point_nu as "회원이 보유한 포인트"
       ,g.point_nu as "상품의 포인트"
       ,m.point_nu-g.point_nu as "포인트 잔액"
  FROM t_giftmem m, t_giftpoint g
-- 문자열 비교시에는 '' / as ""
-- 카타시안의 곱

-- 문제2 ***** 푸는 중
-- 김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수 있는 상품 중 가장 포인트가 높은 것은 무엇인가?
SELECT MAX()
  FROM  (
            SELECT  g.name_vc as "상품명"
                   ,g.point_nu as "상품 포인트"
              FROM t_giftmem m, t_giftpoint g
             WHERE m.name_vc = '김유신' AND m.point_nu-g.point_nu > 0
        )


-- 관계 형태에는
-- 1:1 -> 사원 - 가족테이블
-- 1:N -> 사원 - 부서테이블
-- N:N -> 회원 - 상품 / 학생 - 교과목...
-- : 업무에 대한 정의가 덜 된 경우이다.카타시안의 곱이 발생하므로 조인하면 안된다.(의미 없는 값-쓰레기 값)
-- ERD를 볼 수 있어야 함
-- n:n의 관계를 1:n으로 만들어 주는 교차엔티티(행위엔티티)를 찾는 것이 중요하다.

-- 제1정규화 : 중복되는 값을 관리하지 않는다 -> 중복금지
-- 제2정규화 : 복합키 모두에 종속적인 컬럼명만 쓴다. -> 교차엔티티 또는 행위엔티티
-- 제3정규화 : 테이블에 관계형태로 FK가 존재하는 경우 PK가 아니 FK에 종속적인 컬럼이 존재하면 안됨
-- Natural JOIN // OUTER JOIN // SELF JOIN 만 잘걸면 됨


-- CASE...WHEN

SELECT * FROM zipcode_t;

-- 대분류 // 중분류 // 소분류 컨셉

SELECT '전체' FROM dual
UNION ALL
SELECT zdo FROM zipcode_t group by zdo;

-- order by 절과 union all 같이 쓸 수 없는듯함

-- 인라인뷰
SELECT '전체' zdo FROM dual
UNION ALL
SELECT zdo 
  FROM (
            SELECT distinct(zdo) zdo
            FROM zipcode_t
            order by zdo asc
         );

SELECT '전체' sigu FROM dual
UNION ALL
SELECT sigu 
  FROM (
            SELECT distinct(sigu) sigu
            FROM zipcode_t
            where zdo=:zdo
            order by sigu asc
        );

SELECT '전체' FROM dual
UNION ALL
SELECT dong 
  FROM (
            SELECT distinct(dong) dong
            FROM zipcode_t
            where zdo=:zdo AND sigu=:sigu
            order by dong asc
        );