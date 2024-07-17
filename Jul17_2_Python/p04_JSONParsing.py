# a36c75323e66b79cf7cfc8e39c9a5352
# https://dapi.kakao.com/v3/search/book
from http.client import HTTPSConnection
from urllib.parse import quote
from json import loads

# 책책책 책을 읽읍시다!
# 책 이름 검색해서 책 제목 - 작가 / 할인가 / 도서 소개 출력

q = input("책 검색 : ")
q = quote(q)
api = "a36c75323e66b79cf7cfc8e39c9a5352"
hc = HTTPSConnection("dapi.kakao.com")
hc.request("GET", f"/v3/search/book?query={q}", headers={"Authorization": "KakaoAK " + api})

resBody = hc.getresponse().read()

bookQueryResult = loads(resBody)
for book in bookQueryResult["documents"]:
    title = book["title"]
    authors = book["authors"]
    salePrice = book["sale_price"]
    contents = book["contents"]
    print(title)
    print(", ".join(authors))
            # .join() : list를 문자열로
            # 구분자.join() : list의 요소들을 지정한 구분자로 나눠
            #                하나의 문자열로 합쳐줌
            # ex) ", ".join(["a", "b", "c") => a, b, c
    print(salePrice)
    print(contents)
    print("------------------------")






