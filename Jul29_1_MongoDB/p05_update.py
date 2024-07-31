#  -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

con = MongoClient("192.168.0.13")

db = con.jul29

# update_one / update_many

# db.jul29_lunch.update_one({ "_id" : "김밥"}, {"$set" : {"price" : 5000}})

# upsert는 해당 정보를 찾아서 update하게 되는데
#    만약에 해당 값이 없으면 새롭게 생성하겠다 라는 옵션

db.jul29_lunch.update_one({ "_id" : "test"}, {"$set" : {"price" : 8000}}, upsert=True)

con.close()
print("성공!")























