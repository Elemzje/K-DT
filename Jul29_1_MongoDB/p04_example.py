#  -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient
from http.client import HTTPConnection
from json import loads

# 4f626857416f6c6c3632586a416843

# http://openAPI.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/

# 전체 공원 데이터 중에
# 공원이름 (pk), 공원 소개, 개원일, 주소
# => MongoDB에 넣고

# 다 넣었으면 => 출력 (console)

con = MongoClient("192.168.0.13")

db = con.jul29

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/")
resBody = hc.getresponse().read()
parkData = loads(resBody)

park = parkData["SearchParkInfoService"]["row"]
for p in park:
    a = p["P_PARK"]
    b = p["P_LIST_CONTENT"]
    c = p["OPEN_DT"]
    d = p["P_ADDR"]
    db.jul29_park.insert_one( {"_id" : a,  "P_LIST_CONTENT" : b,"OPEN_DT" : c,"P_ADDR" : d})

pp = db.jul29_park.find()


for l in pp:
    print(l["_id"])
    print(l["P_LIST_CONTENT"])
    if l["OPEN_DT"] == "":
        print(" - ")
    else:    
        print(l["OPEN_DT"])
    print(l["P_ADDR"])
    print("--------------")


con.close()
print("Success !")

















