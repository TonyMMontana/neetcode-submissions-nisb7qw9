-- Write your query below
select customers.customer_id, customers.customer_name 
from customers
where customers.customer_id in(
    select customer_id 
    from orders
    where product_name like 'A%'
) 
and customers.customer_id in(
    select customer_id 
    from orders
    where product_name like 'B%'
) 
and customers.customer_id not in (
    select customer_id 
    from orders
    where product_name like 'C%'

)
order by customers.customer_name;