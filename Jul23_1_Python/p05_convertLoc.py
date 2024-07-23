from cx_Oracle import connect


# Table 데이터 => 번호값 제외한 모든데이터 => csv파일 담는 작업

con = connect('minju/3045@localhost:1521/xe')
cur = con.cursor()
sql = "select * from jul23_loc"
cur.execute(sql)
with open("C:/Users/sdedu/Desktop/file/others/loc.csv", "w", encoding="UTF-8") as f:
    for _, name, phone, long, lat in cur:
        f.write(f"{name},{phone},{long},{lat}\n")
con.close()
print("성공 !")