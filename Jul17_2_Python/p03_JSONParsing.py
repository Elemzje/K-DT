# 42008a8c8e7402a3fc9d3b1a7df8fee9
from http.client import HTTPSConnection
from json import loads

# https://api.openweathermap.org
# /data/2.5/weather?q={city name}&appid={API key}&units=metric&lang=kr

# 도시 이름 : 입력 (영어)
# 요청파라미터 추가 O
# 응답 내용 출력

q = input("city(only eng) : ")

api = "42008a8c8e7402a3fc9d3b1a7df8fee9"

hc = HTTPSConnection("api.openweathermap.org")
hc.request("GET", f"/data/2.5/weather?q={q}&appid={api}&units=metric&lang=kr")

resBody = hc.getresponse().read()
print(resBody.decode()) # 여기까지가 HTTP통신

weatherData = loads(resBody)
# print(weatherData)

# dict : {"key" : "value"}
# list : [1, 2, 3] => 인덱스 값으로
l = [1, 2, 3]                           # python : list / JS : array
d = {"name" : "홍길동", "age" : 30}     # python : dict / JS : object
############################################################################### 
# 날씨 / 기온 / 체감기온 / 습도 / 풍속
# 데이터를 콘솔창에 출력

# 단 하나의 데이터 O => 반복문이 필요없음 !

wf = weatherData["weather"][0]["description"]
temp = weatherData["main"]["temp"]
feelsTemp = weatherData["main"]["feels_like"]
humidity = weatherData["main"]["humidity"]
windSpeed = weatherData["wind"]["speed"]
print("날씨", wf)
print("기온", temp)
print("체감온도", feelsTemp)
print("습도", humidity)
print("풍속", windSpeed)



