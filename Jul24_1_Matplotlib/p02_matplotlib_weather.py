import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from http.client import HTTPConnection
from xml.etree.ElementTree import fromstring

# 또상청 데이터
#    => 각 시간별 기온(temp)와 습도(reh)를 선 그래프로 표현
# http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150059100
hc = HTTPConnection("www.kma.go.kr")
hc.request("GET", "/wid/queryDFSRSS.jsp?zone=1150059100")
resBody = hc.getresponse().read()
temp = []
reh = []
hours = []
for w in fromstring(resBody).iter("data"):
    temp.append(float(w.find("temp").text))
    reh.append(float(w.find("reh").text))
    hour = w.find("hour").text
    hours.append(str(hour + "시"))
indexes = range(len(temp))

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)
# 음수 부호(마이너스) 제대로 안나올 때 처리
plt.rcParams['axes.unicode_minus'] = False 

x1 = plt.subplot()
p1 = x1.plot(indexes, temp, "r:.")
x1.set_xlabel("시간")
x1.set_ylabel("온도")
# x1.set_yticks(np.arange(-15, 36, 5))

x2 = x1.twinx()
p2 = x2.plot(indexes, reh, "b--^")
x2.set_ylabel("습도")
# x2.set_yticks(np.arange(0, 101, 10))
x1.legend(p1 + p2, ["온도, ℃", "습도, %"])

x1.set_xticks(indexes, hours)

plt.grid(axis="y", color="#997700", linestyle="-")
plt.title("화곡6동 시간별 온도/습도", {"fontsize": 20, "fontweight": "bold"}, "center")
plt.show()
