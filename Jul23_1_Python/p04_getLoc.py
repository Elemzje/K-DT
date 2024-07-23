from urllib.parse import quote
from http.client import HTTPSConnection
from json import loads
from cx_Oracle import connect


# a36c75323e66b79cf7cfc8e39c9a5352
# 37.5560305 / 126.8526681
# https://dapi.kakao.com/v2/local/search/keyword.json
# json 데이터
# 검색어를 입력
#    => 위도/경도 지정
#    => 반경 1km내에 있는
#    => 검색어에 대한 위치 정보

#    => 장소명(업체명), 전화번호, 경도, 위도
#    => DB에 저장
#    => 전화번호 : 없는 부분은 " - " 으로 대체
#    => 경도, 위도 : 소수점 6자리까지

q = quote(input("검색어 : "))
url = f'/v2/local/search/keyword.json?x=126.8526681&y=37.5560305&radius=1000&query={q}'
hkey = {"Authorization" : "KakaoAK a36c75323e66b79cf7cfc8e39c9a5352"}

hc = HTTPSConnection("dapi.kakao.com")
hc.request("GET", url, headers=hkey)

resBody = hc.getresponse().read()
locations = loads(resBody)

con = connect("minju/3045@localhost:1521/xe")
cur = con.cursor()

for loc in locations["documents"]:
    name = loc["place_name"]
    phone = loc["phone"]
    lon = loc["x"]
    lat = loc["y"]
    sql = "insert into jul23_loc values("
    sql += "jul23_loc_seq.nextval, "
    sql += f"'{name}', nvl('{phone}', ' - '), {float(lon):.6f}, {float(lat):.6f})"
    cur.execute(sql)

con.commit()
con.close()
print("성공 !")
