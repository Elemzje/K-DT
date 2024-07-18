# input으로 숫자 2개를 입력 => 가격순(오름차순)으로 정렬해서
#                            => ? ~ ?번째까지의 평균 가격을 출력
from cx_Oracle import connect

a = int(input("시작값 : "))
b = int(input("끝값 : "))
if a > b:
    a, b = b, a
con = connect("minju/3045@localhost:1521/xe")
sql = "select round(avg(c_price), 2) from (" 
sql += "select rownum as rn, c_price from ("
sql += "select c_price from jul18_coffee "
sql += "order by c_price)) "
sql += f"where rn between {a} and {b}"
cur = con.cursor()
cur.execute(sql)
avgprice = cur.fetchall()[0]
print("평균가 : %.2f원" % avgprice)
