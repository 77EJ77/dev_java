SELECT 1
  FROM member
  where mem_id=:user_id
  
SELECT
        NVL((
               SELECT 1
                 FROM member
                WHERE mem_id=:user_id
        ), 0)
  FROM dual
  
-- 그룹함수는 전체범위 처리를 한다. - 속도가 느리다.
-- 전체범위 처리의 반대말은 부분범위 처리다. - 속도 빠르다.
-- 운반단위가 차면 fetch를 해서 화면에 출력이 나갈 수 있는 처리
-- 전체범위처리 -> 끝까지 다 찾아보고 결과를 알려줌

-- 그렇다면 아래 쿼리는 부분범위처리로 어떻게 바꿀수 있나

SELECT
        NVL((
               SELECT 1
                 FROM member
                WHERE mem_id=:user_id
        ), 0)
  FROM dual