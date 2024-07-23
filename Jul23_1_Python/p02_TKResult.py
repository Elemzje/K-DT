import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

# Python의 시각화를 위한 library - matplotlib
# cmd install matplotlib

name = []
count = []

with open("C:/Users/sdedu/Desktop/file/others/ThreeKingdoms/TKResult.csv", "r", encoding="UTF-8") as f:
    for line in f.readlines():
        n, c = tuple(line.rstrip().split(","))
        name.append(n)
        count.append(int(c))

# print(name)
# print(count)

# 글씨체 통일, 맑은 고딕
# 타 글씨체는 글씨가 깨질 수 있음
fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# 막대그래프 - 절대적인 값 비교
c = ['#00ccff', '#b2ccff', '#ffa7a7'] 
# plt.bar(name, count, width=0.4, color=c)
# plt.title('Three Kingoms')
# plt.xlabel("name")
# plt.ylabel('count')
# plt.xticks(range(len(name)), name)    # 눈금 설정
# plt.show()

# 파이차트 (pie)
plt.pie(count, labels=name, colors=c, shadow=True, explode=(0.1, 0.1, 0.1))
# explode : 각 항목이 원점에서 튀어나오는 정도 속성의 갯수만큼 필요하다
plt.title("Three Kingdoms")
plt.show()
