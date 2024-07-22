from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# https://search.daum.net/search?w=news&q={q}&enc=utf8&cluster=y&cluster_page=1&DA=DNS

# 검색어 콘솔에 입력
# 요청했을때 나오는 결과 1 ~ 5페이지까지의 뉴스 제목을 출력

q = quote(input("뉴스 : ")) 

for i in range(1, 6):
    print(f"=============={i} 페이지==============")
    url = f"https://search.daum.net/search?w=news&q={q}&enc=utf8&cluster=y&cluster_page=1&DA=DNS&p={i}"
    res = requests.get(url)
    if res.status_code == 200:
        soup = BeautifulSoup(res.text, 'html.parser')
        news = soup.select(".item-title")
        for n in news:
            print(n.text)
    else:
        print(res.status_code)

