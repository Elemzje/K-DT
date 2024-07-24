import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
from http.client import HTTPConnection
from json import loads

# http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/

# 서북권, 도심권, 동북권, ... 의 미세먼지 / 초미세먼지
#    각각 평균값을 bar그래프로 표현 (누적합)

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

resBody = hc.getresponse().read()
dictlist10 = {"서북권": [], "도심권": [], "동북권": [], "서남권": [], "동남권": []}
dictlist25 = {"서북권": [], "도심권": [], "동북권": [], "서남권": [], "동남권": []}
airs = loads(resBody)

for air in airs["RealtimeCityAir"]["row"]:
    rgn = air["MSRRGN_NM"]
    dictlist10[rgn].append(float(air["PM10"]))
    dictlist25[rgn].append(float(air["PM25"]))

x = list(dictlist10.keys())
y1, y2 = [], []
for rgn in dictlist10.values():
    y1data = sum(rgn) / len(rgn)
    y1.append(float(f"{y1data:.2f}"))
for rgn in dictlist25.values():
    y2data = sum(rgn) / len(rgn)
    y2.append(float(f"{y2data:.2f}"))

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

plt.bar(x, y1, color="#ffa7a7")
plt.bar(x, y2, color="#b2ccff", bottom=y1)
plt.axis([None, None, 0, 40])
plt.legend(["미세먼지", "초미세먼지"])
plt.show()
