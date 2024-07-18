# DB연결 => 커피이름, 가격, 원두정보 => .csv파일로 생성(, 를 기준으로)
#    ex)    이름,가격,원두
#           이름,가격,원두
#           ... 
from cx_Oracle import connect

con = connect("minju/3045@localhost:1521/xe")
sql = "select c_name, c_price, c_bean from jul18_coffee order by c_price"
cur = con.cursor()
cur.execute(sql)
file = open("C:/Users/sdedu/Desktop/file/others/coffee.csv", "a", encoding="UTF-8")
for n, p, b in cur:
    line = f"{n},{p},{b}"
    file.write(line + "\n")
file.close()
con.close()