select s.seller_name 
from seller s 
where s.seller_id not in(
    select o.seller_id
    from orders o
    where o.sale_date >= '2020.01.01' and o.sale_date <= '2020.12.31' 
) 
group by s.seller_name; 
