# 1821
SELECT customer_id FROM Customers WHERE year = 2021 AND revenue > 0;

# 1398
SELECT customer_id, customer_name FROM Customers C JOIN (SELECT customer_id FROM Orders GROUP BY customer_id
 HAVING SUM(product_name = 'A') > 0 AND SUM(product_name = 'B') > 0 AND SUM(product_name = 'C')= 0) AS O USING (customer_id) ORDER BY customer_id;

# 1112
SELECT student_id, course_id, grade FROM
 (SELECT *, RANK()OVER(PARTITION BY student_id ORDER BY grade DESC, course_id) AS rk FROM Enrollments) AS T WHERE rk = 1 ;

# 1607
SELECT seller_name FROM Seller WHERE seller_id
 NOT IN (SELECT DISTINCT seller_id FROM Orders WHERE DATE_FORMAT(sale_date, '%Y')=2020) ORDER BY seller_name;

# 1212
SELECT team_id, team_name, SUM(CASE
    WHEN T.team_id = M.host_team AND M.host_goals > M.guest_goals THEN 3
    WHEN M.host_goals = M.guest_goals THEN 1
    WHEN T.team_id = M.guest_team AND M.guest_goals > M.host_goals THEN 3
    ELSE 0 END) num_points
    FROM Teams T LEFT JOIN Matches M ON T.team_id = M.host_team OR T.team_id = M.guest_team
    GROUP BY team_id ORDER BY num_points DESC, team_id;


#1571
SELECT name AS warehouse_name, SUM(P.Width * P.Length * P.Height * W.units) AS volume FROM Warehouse W
    LEFT JOIN  Products P USING (product_id)
    GROUP BY warehouse_name;

# 1173
SELECT ROUND(SUM(IF(order_date = customer_pref_delivery_date,1,0)) * 100.0 / COUNT(delivery_id), 2) immediate_percentage FROM Delivery;

# 1445
WITH Apples AS (SELECT * FROM Sales WHERE fruit = 'apples')
SELECT sale_date, (A.sold_num - O.sold_num) diff FROM Sales O JOIN Apples A USING (sale_date) WHERE O.fruit = 'oranges' ;

# 1699
SELECT IF(from_id<to_id, from_id, to_id) AS  person1,
 IF(to_id> from_id, to_id, from_id) AS person2,COUNT(1) AS call_count,
  SUM(duration) AS total_duration FROM Calls GROUP BY 1,2;

# 1511
SELECT C.customer_id, C.name FROM Customers C
 JOIN Orders O USING(customer_id)
 JOIN Product P USING(product_id)
 GROUP BY C.customer_id
 HAVING SUM(IF(YEAR(order_date)=2020 AND MONTH(order_date) = 6, price * quantity, 0)) >= 100 AND
 SUM(IF(YEAR(order_date)=2020 AND MONTH(order_date) = 7, price * quantity, 0)) >= 100;


# 1495
SELECT DISTINCT C.title FROM TVProgram T
    INNER JOIN Content C USING(content_id)
    WHERE DATE_FORMAT(program_date, '%Y-%m') = '2020-06' and Kids_content = 'Y' AND content_type= 'Movies';

#1501
WITH T AS (
    SELECT LEFT(phone_number,3) AS country_code,
        AVG(duration) AS duration
    FROM Person JOIN Calls ON id IN (caller_id, callee_id)
    GROUP BY country_code
)
SELECT c.name country FROM Country C JOIN T ON C.country_code = T.country_code
    WHERE T.duration > (SELECT AVG(duration) FROM Calls)



