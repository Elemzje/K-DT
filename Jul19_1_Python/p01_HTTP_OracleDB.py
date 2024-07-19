from http.client import HTTPConnection
from cx_Oracle import connect
from xml.etree.ElementTree import fromstring

# 기상청 (주소값 구해서)
# 기상청 xml => DB에 적재
# 시간대 / 기온 / 최고기온 / 날씨(한글) / 풍향(한글) 

# http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300

hc = HTTPConnection("www.kma.go.kr")
hc.request("GET", "/wid/queryDFSRSS.jsp?zone=1150060300")
resBody = hc.getresponse().read()
# print(resBody.decode())

con = connect("minju/3045@localhost:1521/xe")
cur = con.cursor() 
for w in fromstring(resBody).iter("data"):
    hour = w.find("hour").text
    temp = w.find("temp").text
    tmx = w.find("tmx").text
    wfkor = w.find("wfKor").text
    wdkor = w.find("wdKor").text
    sql = f"insert into jul19_weather values(jul19_weather_seq.nextval, {hour}, {temp}, {tmx}, '{wfkor}', '{wdkor}')"  
    cur.execute(sql)
    if cur.rowcount == 1:
        con.commit()
    else:
        print("실패")
con.close()
hc.close()
