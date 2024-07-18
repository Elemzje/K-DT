# select 번호순으로 조회 => 번호를 입력하면 => 그 데이터가 삭제!
# 999를 입력하게 되면 프로그램이 종료 => 종료하기 전까지 반복
from cx_Oracle import connect
from time import sleep

con = connect("minju/3045@localhost:1521/xe")

    
    
while True:
    sqls = "select * from jul18_coffee order by c_no"
    cur = con.cursor()
    cur.execute(sqls)
    
    for i, n, p, b in cur:
        print(f"{i}. {n} | {p} | {b}")
    print("999. 프로그램 종료")
    print("-----------------------------------------------")
    dno = int(input("삭제 번호 : "))
    if dno == 999:
        print(".", end="")
        sleep(0.5)
        print(".", end="")
        sleep(0.5)
        print(".")
        sleep(0.5)
        print("프로그램 종료")
        break
    sqld = f"delete from jul18_coffee where c_no = {dno}"
    cur.execute(sqld)
    if cur.rowcount == 1:
        print(f"{dno}번 커피정보 삭제됨.")
        con.commit()
        sleep(3)
    else:
        print(f"{dno}번은 존재하지 않음.")
        sleep(1.5)
    print("-----------------------------------------------")
con.close()
