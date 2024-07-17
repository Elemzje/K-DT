# https://openapi.naver.com/v1/search/shop.xml
# cqiZ41MlC8FSuJz8VfWe
# z3UO23QzC0

# 상품명 : 입력
# xml 파싱해서
# 문서의 상품명 / 최저가 / 브랜드 / 대분류 카테고리 정보를 출력 

from http.client import HTTPSConnection
from urllib.parse import quote
from xml.etree.ElementTree import fromstring

q = input("상품명 : ")

# URLEncoding해서 주소로 넘겨줄 것
# urllib.parse.quote()
q = quote(q)

def cut(t):
    t = t.replace("<b>", "").replace("</b>", "")
    return t

hc = HTTPSConnection("openapi.naver.com")
# request 함수의 body
#    : 요청할 때 데이터를 보내야 하는 경우에 body에 담아서 보냄

h = {
        "X-Naver-Client-Id":"cqiZ41MlC8FSuJz8VfWe",
        "X-Naver-Client-Secret":"z3UO23QzC0" 
    }

hc.request("GET", f"/v1/search/shop.xml?query={q}", headers=h)

resBody = hc.getresponse().read()


for p in fromstring(resBody).iter("item"):
    print(cut(p.find("title").text))
    print(p.find("lprice").text)
    print(p.find("brand").text)
    print(p.find("category1").text)
    print("----------------------")
