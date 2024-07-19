from time import sleep
from datetime import datetime
from cx_Oracle import connect

# 메뉴만들기 (함수)
# 1. 학생 등록\n2. 강의장 조회
# 3. 학생 조회\n4. 학생정보를 파일로 내보내기
# 0. 종료

# 강의장 조회 : 1강의장 - 6층 복도 오른쪽
# 학생 조회 : 이름, 생년월일(연-월-일 (요일)), 나이, 몇 강의장
#            중간 점수, 기말 점수, 평균 점수
# 파일로 내보내기 (학생의 전체 정보 다 csv파일로)

def getMenuNo():
    print("=================================")
    print("0. 프로그램 종료\n1. 학생 등록\n2. 강의장 조회\n3. 학생 조회\n4. 학생정보를 파일로 내보내기")
    menuNo = input("메뉴 번호 입력 : ")
    print("=================================")
    try:
        menuNo = int(menuNo)
    except:
        print("메뉴는 숫자로 입력해주세요")
    if 0 > menuNo or 4 < menuNo:
        print("존재하지 않는 메뉴번호입니다.")
        return getMenuNo()
    return menuNo

def quitProgram():
    print(".", end="")
    sleep(0.5)
    print(".", end="")
    sleep(0.5)
    print(".")
    sleep(0.5)
    print("프로그램을 종료합니다")
    sleep(0)

def handleSQL(sql, sqltype):
    con = connect("minju/3045@localhost:1521/xe")
    cur = con.cursor()
    if sqltype == "insert":
        try:
            cur.execute(sql)
            if cur.rowcount == 1:
                con.commit()
                return True
        except:
            return False
        finally: 
            con.close()
    elif sqltype == "select":
        cur.execute(sql)
        data = cur.fetchall()
        con.close()
        return data

def insertStudent():
    print("학생 등록 메뉴입니다")
    print("학생의 정보를 입력해주세요")
    name = input("이름 : ")
    birthday = input("생년월일(YYYY-MM-DD) : ")
    s_class = int(input("강의실 번호 : ")) 
    mscore = int(input("중간고사 점수 : "))
    lscore = int(input("기말고사 점수 : "))
    sql = f"insert into jul19_student values(jul19_student_seq.nextval, '{name}', to_date('{birthday}', 'YYYY-MM-DD'), "
    sql += f"{s_class}, {mscore}, {lscore})"
    if handleSQL(sql, "insert"):
        print("학생 등록에 성공했습니다")
        return
    else:
        print("입력값에 문제가 있습니다")
        print("다시 입력해주세요")
        return insertStudent()
    
def selectClass():
    print("강의장 조회 메뉴입니다")
    sql = "select * from jul19_class"
    data = handleSQL(sql, "select")
    for cno, pos in data:
        print(f"{cno}강의장 - {pos}")
    
def selectStudent(_):
    sql = "select * from jul19_student order by s_no"
    data = handleSQL(sql, "select")
    if _ == "print":
        print("전체 학생 조회 메뉴입니다")
        now = datetime.today()
        for __, n, b, c, ms, ls in data:
            d = datetime.strftime(b, "%Y-%m-%d (%a)")
            age = now.year - b.year
            print("#####################")
            print(f"이름 : {n}\n생년월일 : {d}\n나이 : {age}세\n강의실 : {c}강의장\n중간 : {ms}점\n기말 : {ls}점\n평균 : {(ms + ls) / 2}점")
    elif _ == "file":
        f = open('C:/Users/sdedu/Desktop/file/others/student.csv', "w", encoding="UTF-8")
        for __, n, b, c, ms, ls in data:
            d = datetime.strftime(b, "%Y-%m-%d (%a)")
            f.write(f"{n},{d},{c}강의장,{ms},{ls}\n")
        f.close()
        print("파일 생성 성공 !")

def typeWrongNumber():
    print("잘못된 번호 입력")

def start():
    while True:
        menu = getMenuNo()
        if menu == 0:
            quitProgram()
            break
        elif menu == 1:
            insertStudent()
        elif menu == 2:
            selectClass()
        elif menu == 3:
            selectStudent("print")
        elif menu == 4:
            selectStudent("file")
        else:
            typeWrongNumber()
start()
