# IFNULL(column, default_value)
# IF(state='approved', 1, 0)
# CHAR_LENGTH(content)
# ROUND(DIGIT, DECIMALS)
# MOD(id, 2)
# MIN(), MAX()
# DATE_FORMAT(trans_date, '%Y-%m')
# DATE_SUB(A.event_date, INTERVAL 1 DAY)
# DATEDIFF(weather.recordDate, w.recordDate)
# CONCAT(lat,'-',lon)
# DENSE_RANK() OVER( PARTITION BY E.departmentId ORDER BY E.salary DESC)
# CONCAT(STR1, STR2)
# SUBSTRING()
# LEFT() RIGHT()
# GROUP_CONCAT()
# REGEXP '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$';
# YEAR(order_date) MONTH() DAY()

# MISC
COUNT(DISTINCT subject_id)
activity_date <= '2019-07-27' AND DATEDIFF('2019-07-27', activity_date) < 30
LEAD(num, 1) OVER () AS above
LAG(num, 1) OVER ()
FIRST_VALUE(new_price) OVER (PARTITION BY product_id ORDER BY change_date DESC)
WITH S As (SELECT person_name, SUM(weight) OVER ( ORDER BY turn) AS total FROM Queue)
SUM(IF(income >= 20000 AND income <= 50000, 1,0))
(IFNULL(IF(MOD(id,2) = 0, LAG(student) OVER(), LEAD(student) OVER()), student))
SUM(amount) OVER (ORDER BY visited_on RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW)
CONCAT(UPPER(LEFT(name,1)), LOWER(SUBSTRING(name, 2)))
DESC LIMIT 1 OFFSET 1
GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',')
SUM(product_name = 'A')
RANK()OVER(PARTITION BY student_id ORDER BY grade DESC, course_id)
DATE_FORMAT(sale_date, '%Y')=2020)
(CASE
    WHEN operator = '>' THEN IF (A.value > B.value, 'true', 'false')
    WHEN operator = '<' THEN IF (A.value < B.value, 'true', 'false')
    WHEN operator = '=' THEN IF (A.value = B.value, 'true', 'false')
    END)