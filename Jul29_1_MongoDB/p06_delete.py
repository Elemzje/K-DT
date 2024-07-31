#  -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient


con = MongoClient("192.168.0.13")

db = con.jul29

# remove() / delete_one() + delete_many()
# db.jul29_lunch.remove({"_id" : "test"})
# db.jul29_lunch.remove({}) => mongoDB cmd 내에서 전체 데이터 삭제!

# 해당 데이터 하나만 삭제
db.jul29_lunch.delete_one({"price": 8000})

# 해당 데이터 전체 삭제
db.jul29_lunch.delete_many({"price": 8000})
db.jul29_lunch.delete_many({})

con.close()
print("성공!")