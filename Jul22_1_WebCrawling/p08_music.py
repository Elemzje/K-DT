from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# 가수, 노래 제목을 직접 입력해서 요청
# 노래 가사에 대한 내용을 출력

# https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query={q}+{music}&oquery={music}&tqi=ipGvGsqo1fsssirAAeZssssstGh-328091

q = quote(input("가수 : "))
music = input("노래 제목 : ")
music += " 가사"
music = quote(music)

url = f"https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query={q}+{music}&oquery={music}&tqi=ipGvGsqo1fsssirAAeZssssstGh-328091"

res = requests.get(url)

if res.status_code == 200:
    soup = BeautifulSoup(res.text, 'html.parser')
    
    lyrics = soup.select_one("div.intro_box > p")
    
    if lyrics == None:
        lyrics = soup.select_one("div.text_expand.text_center._ellipsis > span")
        print(str(lyrics).replace("<br/>", "\n").replace('<span class="desc _text">', "").replace("</span>", ""))
    else:
        print(str(lyrics).replace("<br/>", "\n").replace("</p>", "").replace('<p class="text no_ellipsis type_center _content_text" style="max-height: 50.4rem; -webkit-line-clamp: 15;">', ""))
else:
    print(res.status_code)


