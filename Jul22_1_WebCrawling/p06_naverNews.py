from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

# 검색어를 입력했을 때,
# url 주소뒤에 요청파라미터로 start=숫자를 넣으면
# 관련 뉴스 내용 5페이지까지의 뉴스 제목들을 콘솔에 출력

# https://search.naver.com/search.naver?where=news&query={q}&sm=tab_tmr&nso=so:r,p:all,a:all&sort=0

q = quote(input("뉴스 검색 : "))

for i in range(1,42,10):
    url = f"https://search.naver.com/search.naver?where=news&query={q}&sm=tab_tmr&nso=so:r,p:all,a:all&sort=0&start={i}"
    print(f"==================={i}===================")
    response = requests.get(url)
    
    if response.status_code == 200:
        html = response.text
        soup = BeautifulSoup(html, 'html.parser')
        titles = soup.select(".news_tit")
        for title in titles:
            print(title.text)
    else:
        print(response.status_code)
