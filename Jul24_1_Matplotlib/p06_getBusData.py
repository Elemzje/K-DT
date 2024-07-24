from http.client import HTTPConnection
from json import loads
from math import ceil

# http://openapi.seoul.go.kr:8088
# /4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/5/20151101/

# 2021 ~ 2023년 3년치 데이터를...
# 연,월,일,노선번호,정류장명(역명),승차총승객수,하차총승객수
# 연도별로 csv파일에 저장

# 정류장명(역명) => 혹시 ,가 들어있을수도 있으니
#        => ,를 .로 바꿔서 저장

# 인원수 관련 => 정수형태로 저장

years = [2021, 2022, 2023]
hc = HTTPConnection("openapi.seoul.go.kr:8088")
year = years[1]
# TODO: 2023년 데이터
with open(f"C:/Users/sdedu/Desktop/file/others/bus{year}.csv", "w", encoding="UTF-8") as f:
    for month in range(1, 13):
        if month == 2:
            if year % 4 == 0:
                end = 29
            else:
                end = 28
        elif month == 4 or month == 6 or month == 9 or month == 11:
            end = 30
        else:
            end = 31
        for day in range(1, 1 + end):
            date = f"{year}{month:02d}{day:02d}"
            print(date)
            url = f'/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/1000/{date}/'
            hc.request("GET", url)
            resBody = hc.getresponse().read()
            resBody = loads(resBody)
            dayListCount = resBody["CardBusStatisticsServiceNew"]["list_total_count"]
            dayListCount = ceil(dayListCount / 1000)
            for thousand in range(1, dayListCount + 1):
                start = thousand * 1000 - 999
                end = thousand * 1000
                url = f'/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/{start}/{end}/{date}/'
                hc.request("GET", url)
                resBody = hc.getresponse().read()
                resBody = loads(resBody)
                for data in resBody["CardBusStatisticsServiceNew"]["row"]:
                    busno = data['RTE_NO']
                    stationName = data['SBWY_STNS_NM'].replace(",", ".")
                    gton = int(data['GTON_TNOPE'])
                    gtoff = int(data['GTOFF_TNOPE'])
                    f.write(f"{year},{month},{day},{busno},{stationName},{gton},{gtoff}\n")
