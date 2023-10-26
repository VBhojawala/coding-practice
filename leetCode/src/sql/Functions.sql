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

