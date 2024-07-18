# 원두를 검색해서
# 그 원두를 사용하는 커피의 종류 갯수, 평균가를 출력
from cx_Oracle import connect

s = input("원두 이름 : ")
con = connect("minju/3045@localhost:1521/xe")
sql = f"select count(*), round(avg(c_price), 2) from jul18_coffee where c_bean = '{s}'"
cur = con.cursor()
cur.execute(sql)
c, a = cur.fetchall()[0]
print("종류 : " + str(c))
print("평균가 : " + str(a))
con.close()
