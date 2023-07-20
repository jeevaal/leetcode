select B.id
from Weather as A, Weather as B
where B.temperature > A.temperature and datediff(B.recordDate, A.recordDate) = 1;