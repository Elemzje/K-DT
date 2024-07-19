from cx_Oracle import connect

# DB에 있는 미세먼지 데이터 => csv에 저장(데이터 콤마로 구분)
con = connect("minju/3045@localhost:1521/xe")
cur = con.cursor()
file = open("C:/Users/sdedu/Desktop/file/others/seoulair.csv", "a", encoding="UTF-8")

sql = "select * from jul19_cityair order by ca_no"
cur.execute(sql)

file.write("no,ste,pm10,pm25\n")
for no, ste, pm10, pm25 in cur:
    file.write(f"{no},{ste},{pm10},{pm25}\n")

file.close()
con.close()
print("성공")