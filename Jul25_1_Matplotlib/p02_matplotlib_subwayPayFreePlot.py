# 방금 만든 csv파일 불러와서
#    연월에 맞춰서 => 유임승차,무임승차,유임하차,무임하차
#    => 선 그래프 그리기

import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

dd = {}

with open("C:/Users/sdedu/Desktop/file/csv/SubwayData.csv", "r", encoding="UTF-8") as f:
    for data in f.readlines():
        datalist = data.rstrip().split(",")
        if datalist[0] in dd:
            dd[datalist[0]][0] += int(datalist[3])
            dd[datalist[0]][1] += int(datalist[4])
            dd[datalist[0]][2] += int(datalist[5])
            dd[datalist[0]][3] += int(datalist[6])
        else:
            dd[datalist[0]] = [int(datalist[3]), int(datalist[4]), int(datalist[5]), int(datalist[6])]

for k, v in dd.items():
    if k == "202205":
        dd[k][0] /= 2
        dd[k][1] /= 2
        dd[k][2] /= 2
        dd[k][3] /= 2

xlen = range(len(dd.keys()))
x = list(dd.keys())
for i, asdf in enumerate(x):
    q = int(asdf) % 10000
    x[i] = '%02d.%02d' % (q // 100, q % 100)
    
y1 = []
y2 = []
y3 = []
y4 = []
for d in dd.values():
    y1.append(d[0])
    y2.append(d[1])
    y3.append(d[2])
    y4.append(d[3])

x1 = plt.subplot()
x1.plot(xlen, y1, "r:^", alpha=0.5, markersize=3)
x1.plot(xlen, y3, "b:v", alpha=0.5, markersize=3)
x1.legend(["유임승차", "유임하차"], loc='lower left')
x1.set_ylabel("유임 승하차 승객 수 (천만 명)")
x1.set_yticks(range(0, 250000001, 50000000), range(0, 26, 5))

x2 = x1.twinx()
x2.plot(xlen, y2, "g:^", alpha=0.5, markersize=3)
x2.plot(xlen, y4, "y:v", alpha=0.5, markersize=3)
x2.legend(["무임승차", "무임하차"], loc='lower right')
x2.set_ylabel("무임 승하차 승객 수 (천만 명)")
x2.set_yticks(range(0, 50000001, 10000000), range(0, 6, 1))

plt.title("월별 지하철 유/무임 승/하차 정보")
plt.xticks(xlen[0:60:6], x[0:60:6])
plt.xlabel("연.월")
plt.show()
























