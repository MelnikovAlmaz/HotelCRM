create or replace function search_hotels (pattern varchar, beginDate date, endDate date, guestNumber integer)
returns table (id integer, "name" varchar(100), phonenumber char(11), address varchar(100), description varchar(255), price double precision) as $$
begin
return query
select * ,
    (select avg(cost) from 
        ((select * from room where h.id = hotelid) as r 
         inner join 
        (select roomcategory.id, roomcategory.cost from roomcategory where bednumber = guestNumber) as rc on rc.id = r.categoryid)
    )as price
from hotel as h where h.name like pattern;
end;
$$ language plpgsql;