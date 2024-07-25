from http.client import HTTPConnection
from json import loads

# http://openapi.seoul.go.kr:8088
# /4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/1/5/201501/

# 2019 ~ 2023년 월별로 > 하나의 파일(csv)에 저장
# 연월(ex:201901),호선명,지하철역,유임승차인원,무임승차인원,유임하차인원,무임하차인원

hc = HTTPConnection("openapi.seoul.go.kr:8088")

with open("C:/Users/sdedu/Desktop/file/csv/SubwayData.csv", "w", encoding="UTF-8") as f:
    for year in range(2019, 2024):
        for month in range(1, 13):
            date = f"{year}{month:02d}"
            print(date)
            url = f'/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/1/1000/{date}/'
            hc.request("GET", url)
            resBody = hc.getresponse().read()
            subwayDatas = loads(resBody)
            checkDataCount = subwayDatas["CardSubwayPayFree"]["list_total_count"] 
            if checkDataCount > 1000:
                for i in range(0, checkDataCount - 1, 1000):
                    start = i + 1
                    end = i + 1000
                    url = f'/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/{start}/{end}/{date}/'
                    hc.request("GET", url)
                    resBody = hc.getresponse().read()
                    subwayDatas = loads(resBody)
                    for data in subwayDatas["CardSubwayPayFree"]["row"]:
                        lnnm = data["SBWY_ROUT_LN_NM"]
                        sttn = data["STTN"]
                        rmon = int(data["RMIO_GTON_NOPE"])
                        fcon = int(data["FREECHRG_GTON_NOPE"])
                        rmoff = int(data["RMIO_GTOFF_NOPE"])
                        fcoff = int(data["FREECHRG_GTOFF_NOPE"])
                        f.write(f"{date},{lnnm},{sttn},{rmon},{fcon},{rmoff},{fcoff}\n")
            else:
                for data in subwayDatas["CardSubwayPayFree"]["row"]:
                    lnnm = data["SBWY_ROUT_LN_NM"]
                    sttn = data["STTN"]
                    rmon = int(data["RMIO_GTON_NOPE"])
                    fcon = int(data["FREECHRG_GTON_NOPE"])
                    rmoff = int(data["RMIO_GTOFF_NOPE"])
                    fcoff = int(data["FREECHRG_GTOFF_NOPE"])
                    f.write(f"{date},{lnnm},{sttn},{rmon},{fcon},{rmoff},{fcoff}\n")
















