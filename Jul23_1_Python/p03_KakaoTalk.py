import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

# 카카오톡 내용 정제
# ㅋ : ?, ㅎ : ?, ㅠ : ?, ? : ?, ! : ?
kc = {"ㅋ" : 0, 'ㅎ' : 0, 'ㅠ' : 0, '?' : 0, '!' : 0}

def setKC(line):
    for s in line:
        if s in kc:
            kc[s] += 1

with open("C:/Users/sdedu/Desktop/file/others/kakaotalk.txt", "r", encoding="UTF-8") as f:
    for line in f.readlines():
        line = line.replace("\r\n", "")
        print(line)
        if " : " in line:
            lines = line.split(" : ", 1) # 첫번째 " : "에서만 분리
            if len(lines) == 2:
                dialog = lines[-1]
                print(dialog)
                setKC(dialog)
print(kc)

fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

c = ['red', 'orange', 'green', 'blue', 'purple']
w = {'width' : 0.7, 'edgecolor':'black', 'linewidth' : 5}

plt.pie(list(kc.values()), labels=list(kc.keys()), colors=c, autopct="%.2f%%", wedgeprops=w)
# wedgeprops : 테두리
plt.title("카톡 단어 사용량")
plt.show()




















