--소수점 이후의 값이 존재하면 무조건 올림하는 함수이다.
--CEIL(n) n은 숫자값

SELECT CEIL(13.11) FROM dual

SELECT CEIL(13.0001) FROM dual

--나머지값을 구하는 함수이다.
--MOD(n,m) n/m의 나머지값
SELECT MOD(23,5) FROM dual

SELECT MOD(57,145) FROM dual

--승수값을 구하는 함수이다.
--POWER(n,m) n의 m승값
SELECT POWER(3,2), POWER(3,-2) FROM dual

SELECT POWER(2,10) FROM dual

--반올림값을 구하는 함수 입니다.
--ROUND(n,m) : n은 계산할 숫자값, m값은 정수입니다.
SELECT ROUND(345.123,0) FROM dual

SELECT ROUND(345.123,0), ROUND(345.123,-1) FROM dual

--버림값을 구하는 함수입니다.
--TRUNC(n,m) : n은 계산할 숫자값, m값은 정수입니다.
SELECT TRUNC(345.123,1), TRUNC(345.123,0), TRUNC(345.123,-1) FROM dual

--해당 값이 양수면 1, 음수면 -1, 0이면 0을 돌려줍니다.
--SIGN(n): n값을 1,0,-1로 바꿔줍니다.
SELECT SIGN(5.989), SIGN(0), SIGN(-999.098) FROM dual

SELECT DECODE(SIGN(POWER(2,100)-1000),1,'2의 10승이 1000보다 크다',
             -1,'2의 10승이 1000보다 작다','2의 10승이 1000과 같다') 비교값
  FROM dual
  
아스키코드:128개의 가능한 문자조합을 제공하는 7비트 부호로 처음 32개의 부호는 인쇄와
전송 제어용으로 사용된다.(미국표준부호)
--ASCII값을 문자로, 문자를 ASCII값으로 변환
--CHR(n) :n은 정수이고, n을 ASCII 문자기호로 변환한다.
--ASCII(char) : CHR와 반대로 char(문자)를 ASCII에 해당하는 정수값으로 변환
SELECT CHR(65) "CHR", ASCII('A') "ASCII" FROM dual

--정보통신B반
--해당 문자나 문자열을 소문자와 대문자로 변환한다.
LOWER(char) : char를 모두 소문자로 변환합니다.
UPPER(char) : char를 모두 대문자로 변환합니다.

SELECT LOWER('Have a Good Time!!!') "LOWER"
      ,UPPER('Have a Good Time!!!') "UPPER"
  FROM dual    
  
--해당 문자열에서 정해진 공간의 나머지 공간을 왼쪽과 오른쪽으로 주어진 
--문자로 채워주는 함수이다.    
--LPAD(char1,n,char2) : n자리만큼의 공간에서 char1을 오른쪽에 붙이고
--                     남는 자리는 char2로 채웁니다.
--RPAD(char1,n,char2) : n자리만큼의 공간에서 char1을 왼쪽에 붙이고
--                     남는 자리는 char2로 채웁니다.
SELECT LPAD('KSS',10,'*') "LPAD", RPAD('KSS',10,'*') "RPAD" FROM dual

--공백문자(Space)를 제거합니다.
--LTRIM(char) : char의 맨 왼쪽부분에 있는 Space를 제거한다.
--RTRIM(char) : char의 맨 오른쪽 부분에 있는 Space를 제거한다.
SELECT LTRIM('   AAA   ') "LTRIM", RTRIM('   AAA   ') "RTRIM" FROM dual

--문자나 문자열을 치환해 준다.
--REPLACE(char1,char2,char3) : char1의 char2를 char3로 변환시킨다.
SELECT REPLACE('ORACLE','A','BBB')"REPLACE" FROM dual

--문자열의 일부분을 돌려준다.
--SUBSTR(char, n) : char의 n번째 자리부터 문자열 끝까지를 돌려준다.
--SUBSTR(char, n, m) : char의 n번째 자리부터 m번째에 해당하는 문자열을 돌려
--준다.
--SUBSTRB(char, n, m) : byte단위로 char의 n번째 자리부터 m번째에 해당하는
--문자열을 돌려준다.한글은 2byte이지만 길이나 문자를 한 개로 인식하기 
--때문에 이를 원래 길이인 2로 인식한다는 의미
SELECT SUBSTR('ORACLE PROJECT',1,3) substr1
      ,SUBSTR('ORACLE PROJECT',4,3) substr2
      ,SUBSTR('ORACLE PROJECT',10) substr3 FROM dual
      
SELECT SUBSTRB('오라클 PROJECT',1,2) substr1
      ,SUBSTRB('오라클 PROJECT',4,5) substr2
      ,SUBSTRB('오라클 PROJECT',10) substr3 FROM dual      
      
--문자열의 길이를 알 수 있다.
--LENGTH(char) : char의 길이를 돌려준다.
--LENGTHB(char) : Byte의 단위로 char의 길이를 돌려준다.
SELECT LENGTH(7566), LENGTHB('홍길동') FROM dual      

---문자열 속에서 특정문자나 문자열의 위치를 알려준다.
--INSTR(char1,char2,n,m): char1문자열중에서 char2가 포함된 문자열의 위치가
--                      char1기준으로 앞에서 몇 번째 있는지 돌려준다.
--                      단 n번째 위치부터 시작해서 m번째로 char2와 같은
--                      위치를 돌려준다.
--INSTRB(char1,char2,n,m): Byte단위로 char1 문자열중에서 char2가 포함된  
--                      문자열의 위치가 char1기준으로 앞에서 몇 번째 있는지.
--                      돌려준다. n,m의 역할은 INSTR과 동일하다.

SELECT INSTR('ORACLE PROJECT','R',1,1) INSTR1
     ,INSTR('ORACLE PROJECT','R',1,2) INSTR2
     ,INSTR('ORACLE PROJECT','R',1,3) INSTR3
  FROM dual
  
--나열한 데이터 중에서 가장 큰 값과 가장 작은 값을 찾습니다.  
--여기의 크다/작다의 기준은 문자의 경우 Sort에 준한다.
--다시말해 [가]는 [나]보다 작고, [김]은 [강]보다 크다.
SELECT GREATEST(135,33,45,90,60,77) "GREASTE"
      ,LEAST(135,33,45,90,60,77) "LEAST" FROM dual
      
SELECT GREATEST('가','나') FROM dual
      
select 
      lower(translate(upper(mem_id),'SYL6FZ5NM0VCET29W8DKJG4XABIUPOH3Q7R1','ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890')) mem_id
  from member  
        
select 
      lower(translate(mem_pw,'SYL6FZ5NM0VCET29W8DKJG4XABIUPOH3Q7R1','ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890')) mem_pw
  from member  
  
CONVERSION Function
TO_CHAR : NUMBER 와 DATE를 문자로 바꾼다.

'9,999.99' 
'9,999,999.999'
'9,999.99'
'999,999'

TO_CHAR(n) : n을 문자로 바꾼다.
TO_CHAR(n,format) : n을 format형식의 문자로 바꾼다.

SELECT TO_CHAR(1234567.891) "TO_CHAR1"
      --,TO_CHAR(1234567.891,'999') "TO_CHAR2"
      ,TO_CHAR(1234567.891,'9,999,999') "TO_CHAR3"
      --,TO_CHAR(1234567.891,'0.0000') "TO_CHAR4" 
      ,TO_CHAR(1234567.891,'9,999,999.0000') "TO_CHAR5"
      --,TO_CHAR(123.25,'9,999.00') "TO_CHAR6"
      ,TO_CHAR(123.25,'9,999.99') "TO_CHAR7"
  FROM dual    
  
TO_CHAR(date,format) : date를 format형식의 문자로 바꾼다.

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') "TO_CHAR1"
      ,TO_CHAR(SYSDATE, 'YYYY/MM') "TO_CHAR2"
      ,TO_CHAR(SYSDATE, 'YYYY') "TO_CHAR3"
      ,TO_CHAR(SYSDATE, 'DD') "TO_CHAR4"
      ,TO_CHAR(SYSDATE, 'DAY') "TO_CHAR5"
      ,TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') "TO_CHAR6"
  FROM dual       
  

TO_NUMBER : 모양만 숫자인 문자를 NUMBER로 바꾸어 준다.

TO_NUMBER(char) : 숫자로 이루어진 char를 숫자로 바꾸어 준다.
                 char가 숫자모양이 아닌 a,b, 가,나 처럼 일반 문자면
                 에러가 발생

TO_NUMBER(char,format) : format에 맞는 형태의 숫자로 이루어진 char를 
                        숫자로 바꾸어 준다. 여기서 주의할 점은 format
                        의 크기가 최소한 char보단 커야한다는 것입니다.

SELECT TO_NUMBER('1234567.8') "숫자" FROM dual    

SELECT TO_NUMBER('123,456.9', '999999.9') "숫자" 
      ,TO_NUMBER('123,456.9', '999.9') "숫자1"
  FROM dual                                     
                 

TO_DATE
모양만 날짜인 문자를 DATE로 바꾸어 준다.
TO_DATE(char) : 날짜로 이루어진 char를 날짜로 바꾸어 준다.
TO_DATE(char, format) : format에 맞는 형태의 날짜로 이루어진 char를 
                       날짜로 바꾸어 준다.

SELECT TO_DATE('20081219') "TO_DATE1"
      ,TO_DATE('2008-12-19') "TO_DATE2"
      ,TO_DATE('2008/12/19 08:10:15','YYYY/MM/DD HH24:MI:SS') "TO_DATE3"
  FROM dual                       


날짜에서 날짜를 빼면 그 사이의 일 수가 숫자로 나온다.

SELECT sysdate - birth_date
  FROM temp
 WHERE emp_name = '홍길동'
 
SELECT birth_date, birth_date + 1, birth_date - 1
  FROM temp
 WHERE emp_name = '홍길동'
 
SELECT 
       birth_date
      ,add_months(birth_date, 1) 
      ,to_char(add_months(birth_date, 1),'YY/MM/DD') 
      ,add_months(birth_date, -13)
  FROM temp
 WHERE emp_name = '홍길동' 
  
주어진 두 개의 일자 간격이 몇 개월인지를 보여준다.

SELECT
       months_between(sysdate, birth_date) mon_term
  FROM temp
 WHERE emp_name = '홍길동'  
 
 
Temp의 birth_date와 그 달의 마지막 일자를 조회한다.

SELECT 
       birth_date, last_day(birth_date)
  FROM temp; 
