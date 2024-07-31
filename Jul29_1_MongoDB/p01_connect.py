# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

# Python + MongoDB 

# cmd => pip install pymongo

# 연결
con = MongoClient("192.168.0.13")

db = con.jul29

con.close()
print("Success !")
































