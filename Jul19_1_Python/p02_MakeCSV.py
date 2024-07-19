from cx_Oracle import connect

# csv파일로 만들어주세요! (번호,시간,온도,최고기온,날씨,바람속도 의 형태로)

url = "C:/Users/sdedu/Desktop/file/others/weather.csv"
file = open(url, "a", encoding="UTF-8")

con = connect("minju/3045@localhost:1521/xe")
cur = con.cursor()
sql = "select * from jul19_weather order by w_no"
cur.execute(sql)
for no, hr, tmp, tmx, wfk, wdk in cur:
    file.write(f"{no},{hr},{tmp},{tmx},{wfk},{wdk}\n")

file.close()
con.close()
print("성공 !")