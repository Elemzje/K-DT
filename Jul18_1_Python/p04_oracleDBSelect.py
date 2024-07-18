from cx_Oracle import connect

# 각각의 커피 이름, 가격, 원두 정보 가격 오름차순으로 정렬해서 출력

# 연결
con = connect("minju/3045@localhost:1521/xe")

# sql문 작성
sql = "select c_name, c_price, c_bean from jul18_coffee order by c_price"

# DB관련 총괄객체 / sql 수행 결과(select문 결과 객체)
cur = con.cursor()

# sql문을 수행
cur.execute(sql)    # 수행하면 select의 결과가 cur에 tuple로 들어가게 됨

# data = cur.fetchall()   # => 결과가 다 불러와짐
# for i in data:
    # print(i)

# for c in cur:
    # print(c, type(c))

for n, p, b in cur:
    print(n, p, b)
    print("-------------")


con.close()

