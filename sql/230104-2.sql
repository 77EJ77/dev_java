-- HR

SELECT * FROM employees;

-- jobID    AD_VP 10%   IT_PROG 15%     ST_MAN 20%      나머지는 5%     출력:job_id 현재급여, 인상적용된 급여

SELECT first_name||' '||last_name, job_id, salary, CASE
                            WHEN job_id='AD_VP' THEN salary*1.1
                            WHEN job_id='IT_PROG' THEN salary*1.15
                            WHEN job_id='ST_MAN' THEN salary*1.2
                            ELSE salary*1.05
                            END as "인상 적용된 급여"
  FROM employees;