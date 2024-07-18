# 파일로부터 데이터를 읽어와서 프로그램에서 활용하기 위함
# 프로그램에서 만든 데이터를 파일형태로 저장하기 위함

# 파일 열기 => 작업(읽기, 쓰기) => 파일 닫기 (필수 !!)

# .txt파일 / .csv (Comma Separated Value)파일 

# 1. 파일에 내용 쓰기 (write)
# 폴더는 미리 만들어둬야함 / 파일은 존재하지 않아도 실행시 파일을 만들어줌
# C:\Users\sdedu\Desktop\file\others \ => \\ or /

# w : 덮어쓰기
# file = open("C:/Users/sdedu/Desktop/file/others/test.txt", "w", encoding="UTF-8")
# file.write("오늘 비가 겁나 오네요 ㅠ-ㅠ 이따 점심 회식인데...")
# print("완료!")
# file.close()

# 2. a : 파일에 내용을 추가 (append)
# file = open("C:/Users/sdedu/Desktop/file/others/test.txt", "a", encoding="UTF-8")
# file.write("\n오늘 제가 살아서 돌아온다면...\n그녀에게 고백하겠어요...\n흙흙...")
# print("완료!")
# file.close()

# 3. r : 파일 읽어오기 (read)
file = open("C:/Users/sdedu/Desktop/file/others/test.txt", "r", encoding="UTF-8")

# 3-1. 파일 전체 읽기
# data = file.read()
# print(data)
# file.close()

# 3-2. 파일을 한줄씩 읽기
while True: # 내가 가져온 파일의 내용이 언제 끝날지 모르기 때문에 True
    data = file.readline() # 한 줄을 읽어옴
    print(data, end="")
    # readline의 결과가 공백인 상황 (파일의 맨 마지막 줄까지 끝난 상황)
    if data == "":
        break
        
file.close()
