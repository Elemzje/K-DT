from http.client import HTTPConnection
from cx_Oracle import connect
from json import loads

# http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/

# 구 이름, 미세먼지, 초미세먼지 의 정보를 DB에 담아주세요!
#    (여러 기간에 걸쳐 이 데이터를 모은다고 가정)

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

con = connect("minju/3045@localhost:1521/xe")
cur = con.cursor()

resBody = hc.getresponse().read()
cityAirs = loads(resBody)
# print(resBody.decode())
rows = cityAirs["RealtimeCityAir"]["row"]
for row in rows:
    sql = "insert into jul19_cityair values("
    sql += "jul19_cityair_seq.nextval, "
    sql += "'%s', " % row["MSRSTE_NM"]
    sql += "%s, " % row["PM10"]
    sql += "%s)" % row["PM25"]
    cur.execute(sql)

con.commit()
con.close()
hc.close()
print("성공 !")