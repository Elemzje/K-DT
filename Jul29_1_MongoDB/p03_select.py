#  -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

con = MongoClient("192.168.0.13")

db = con.jul29

s = db.jul29_lunch.find()
# print(s)

for l in s:
    print(l["_id"])
    print(l["price"])
    print("--------------")


con.close()
print("Success !")










