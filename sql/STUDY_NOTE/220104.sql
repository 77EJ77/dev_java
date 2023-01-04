SELECT distinct(deptno)
  FROM emp

SELECT
       ename  
  FROM emp
 GROUP BY ename 
 
SELECT
       max(ename), deptno  
  FROM emp
 GROUP BY deptno  
 
--아래 방법은 group by에 대한 문법적인 오류는 해결되었지만
--group by한 효과가 전혀 없는 경우임 
 
SELECT
       deptno, ename 
  FROM emp
 GROUP BY deptno, ename  

SELECT
       deptno, avg(sal)
  FROM emp
 GROUP BY deptno
 
SELECT
       deptno, avg(sal)
  FROM emp
 GROUP BY deptno
 HAVING avg(sal) >= 2000 
 
DECODE(lec_time, lec_point, '일반과목') = DECODE(lec_time, lec_point, '일반과목',null) 

DECODE(lec_time, lec_point, '일반과목', '특별과목')

SELECT
       DECODE(lec_time, lec_point, '일반과목')
  FROM lecture  
  
SELECT
       DECODE(lec_time, lec_point, '일반과목', null)
  FROM lecture    

SELECT
       DECODE(lec_time, lec_point, '일반과목', '특별과목')
  FROM lecture  

SELECT *
  FROM lecture
  
문제 
강의시간과 학점이 같으면 1을 반환한다

SELECT 
       lec_time, lec_point
  FROM lecture  
  
--널은 모른다, 결정되지 않았다
--SUM할수 있나? COUNT  
  
SELECT lec_time, lec_point
      ,DECODE(lec_time, lec_point,1)
  FROM lecture  
  
SELECT 
       COUNT(DECODE(lec_time, lec_point,1))
  FROM lecture    
  
SELECT
       DECODE(job,'CLERK', sal)
  FROM emp  
  
SELECT
       SUM(DECODE(job,'CLERK', sal))
      ,COUNT(DECODE(job,'CLERK', sal))
  FROM emp   
  
SELECT count(*) FROM lecture  

SELECT 1 FROM lecture  
 WHERE lec_time = lec_point
 
SELECT count(1) FROM lecture  
 WHERE lec_time = lec_point 
    
SELECT 1 FROM dual 
UNION ALL
SELECT 2 FROM dual 

SELECT 1, 2, 3 FROM dual

SELECT 120-10, (10-120), 0-0, 500-500
  FROM dual
  
SELECT SIGN(120-10), SIGN(10-120), 0-0, 500-500
      ,SIGN(10-25), SIGN(1+6), SIGN(400-400)
  FROM dual  
  
DECODE(SIGN(lec_time-lec_point),0,'일반과목'
                               ,1,'실험과목'
                               ,-1,'기타과목')
                               
SELECT  lec_time, lec_point,
        DECODE(SIGN(lec_time-lec_point),0,'일반과목'
                                       ,1,'실험과목'
                                       ,-1,'기타과목')
  FROM lecture              
  
SELECT sysdate
  FROM dual     
  
  SELECT to_char(sysdate, 'DD')
  FROM dual                 

  SELECT to_char(sysdate, 'day')
  FROM dual
  
SELECT '04'||'21' FROM dual  

DECODE(to_char(sysdate,day), '월요일', '01'
                           , '화요일', '11'
                           , '수요일', '21'
                           , '목요일', '31'
                           , '금요일', '41'
                           , '토요일', '51'
                           , '일요일', '61')
                           
SELECT
       to_char(sysdate, 'DD')
  FROM dual   
  
  
SELECT
        DECODE(to_char(sysdate,'day'), '월요일', '01'
                                   , '화요일', '11'
                                   , '수요일', '21'
                                   , '목요일', '31'
                                   , '금요일', '41'
                                   , '토요일', '51'
                                   , '일요일', '61')
  FROM dual                          
     
  
SELECT to_char(sysdate, 'DD')
       ||
        DECODE(to_char(sysdate,'day'), '월요일', '01'
                                           , '화요일', '11'
                                           , '수요일', '21'
                                           , '목요일', '31'
                                           , '금요일', '41'
                                           , '토요일', '51'
                                           , '일요일', '61') 
  FROM dual                         

1)영어가사만 나오게 하기

SELECT
       seq_vc, words_vc
  FROM t_letitbe

SELECT
       MOD(seq_vc,2),seq_vc, words_vc
  FROM t_letitbe
  
SELECT
       MOD(seq_vc,2),seq_vc
     , DECODE(MOD(seq_vc,2),1,words_vc, null)
  FROM t_letitbe  

SELECT
       MOD(seq_vc,2) as "num",seq_vc
     , DECODE(MOD(seq_vc,2),1,words_vc, null)
  FROM t_letitbe  
 WHERE MOD(seq_vc,2) =1
 
SELECT
      DECODE(MOD(seq_vc,2),1,words_vc, null)
  FROM t_letitbe  
 WHERE MOD(seq_vc,2) =1 
 
--num은 별칭이지 t_letitbe에 존재하는 컬럼이 아니다.
--따라서 where절에 사용이 불가함
--문제해결하는 방법 -> 인라인뷰를 사용하면 가능하다.
--인라인뷰를 사용해서 집합을 가공(컬럼, 로우값-where)할 수 있다.

SELECT * FROM emp
WHERE sal > 3000

SELECT empno FROM emp

SELECT
       MOD(seq_vc,2) as "num",seq_vc
     , DECODE(MOD(seq_vc,2),1,words_vc, null)
  FROM t_letitbe  
 WHERE num =1
 
인라인뷰는 FROM뒤에 오는 SELECT 문을 말한다.

SELECT
       *
  FROM (
        SELECT
               MOD(seq_vc,2) num,seq_vc
             , DECODE(MOD(seq_vc,2),1,words_vc, null)
          FROM t_letitbe   
        )a
 WHERE a.num = 1    
 
 --인라인뷰에서 사용된 컬럼명은 where절에서 사용이 가능하다.
 --그 컬럼명이 t_letitbe테이블에 존재하는 컬럼이 아니더라도....
 

2)한글가사만 나오게 하기

SELECT
       *
  FROM (
        SELECT
               MOD(seq_vc,2) num,seq_vc
             , DECODE(MOD(seq_vc,2),0,words_vc, null)
          FROM t_letitbe   
        )a
 WHERE a.num = 0  


3)영문가사와 한글 가사 모두 나오게 하기

SELECT
       seq_vc
      ,DECODE(MOD(seq_vc,2),1, words_vc) A
  FROM t_letitbe

SELECT
       seq_vc
      ,DECODE(MOD(seq_vc,2),0, words_vc) A
  FROM t_letitbe
  

SELECT
       seq_vc
      ,DECODE(MOD(seq_vc,2),1, words_vc) A
  FROM t_letitbe
UNION ALL
SELECT
       seq_vc
      ,DECODE(MOD(seq_vc,2),0, words_vc) A
  FROM t_letitbe  
  
  
SELECT
        seq_vc
  FROM (
        SELECT
               seq_vc
              ,DECODE(MOD(seq_vc,2),1, words_vc) A
          FROM t_letitbe
        UNION ALL
        SELECT
               seq_vc
              ,DECODE(MOD(seq_vc,2),0, words_vc) A
          FROM t_letitbe   
       )  
GROUP BY seq_vc
       
SELECT seq_vc FROM t_letitbe
ORDER BY seq_vc asc

SELECT seq_vc FROM t_letitbe
ORDER BY to_number(seq_vc) asc


SELECT
        seq_vc, MIN(A)--A에 사용되는 그룹함수는 null과 비교되니까 값은 오직하나뿐이다.
  FROM (
        SELECT
               seq_vc
              ,DECODE(MOD(seq_vc,2),1, words_vc) A
          FROM t_letitbe
        UNION ALL
        SELECT
               seq_vc
              ,DECODE(MOD(seq_vc,2),0, words_vc) A
          FROM t_letitbe   
       )  
GROUP BY seq_vc
ORDER BY to_number(seq_vc) asc

SELECT
       ename, comm
  FROM emp
  
SELECT
       ename, comm
  FROM emp
ORDER BY comm asc  

SELECT
       ename, comm
  FROM emp
ORDER BY comm desc 

3번 문제의 경우 SELECT * FROM t_letitbe는 답이 아닙니다.
조건:합지합을 이용하셔야 합니다.
      정렬 해주셔야 합니다.
     영문가사와 한글가사 교대로 출력되어야 합니다.