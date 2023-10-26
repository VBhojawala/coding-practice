# IFNULL(column, default_value)
# IF(state='approved', 1, 0)
# CHAR_LENGTH(content)
# ROUND(DIGIT, DECIMALS)
# MOD(id, 2)
# MIN(), MAX()
# DATE_FORMAT(trans_date, '%Y-%m')
# DATE_SUB(A.event_date, INTERVAL 1 DAY)
# DATEDIFF(weather.recordDate, w.recordDate)


# MISC
COUNT(DISTINCT subject_id)
activity_date <= '2019-07-27' AND DATEDIFF('2019-07-27', activity_date) < 30
LEAD(num, 1) OVER () AS above
LAG(num, 1) OVER ()
