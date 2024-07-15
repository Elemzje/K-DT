# Java (null) = Python (None)
from random import randint
import time

# 가위바위보 (함수) => 한번 질 때까지 => 총 몇번 이겼는지 출력

def greetUser():
    user = input("이름을 입력해주세요 : ")
    print("Welcome to RSP Game", user)

def getComRSP():
    return randint(1, 3)

def getUserAnswer():
    print("------------------------------")
    print("1. 가위")
    print("2. 바위")
    print("3. 보")
    rsp = int(input("Rock/Scissor/Paper 중 선택해서 입력하세요\n선택 : "))
    if 1 <= rsp <= 3:
        return rsp
    else:
        print("잘못 입력했습니다\n다시 입력해주세요")
        return getUserAnswer()

def judgeWhoWin(comRSP, userAns):
    res = userAns - comRSP
    global w, d
    if res == 1 or res == -2:
        w += 1
        return "승리"
    elif res == 0:
        d += 1
        return "무승부"
    else:
        return "패배"

def printThisResult(comRSP, result):
    print("------------------------------")
    if comRSP == 1:
        comRSP = "가위"
    elif comRSP == 2:
        comRSP = "바위"
    else:
        comRSP = "보"
    print("컴퓨터는 {}를 냈습니다".format(comRSP))
    print("결과는 {}입니다!".format(result))

def printFinalResult(w, d, t):
    print("------------------------------")
    print("최종 결과는 {}승, {}무 입니다".format(w, d))
    print("{}회 시도하셨고, 마지막에 패배하셨습니다".format(t))
    print("------------------------------")

def playGame():
    greetUser()
    global w, d
    w, d, t = 0, 0, 0
    while True:
        t += 1
        comRSP = getComRSP()
        userAns = getUserAnswer()
        result = judgeWhoWin(comRSP, userAns)
        printThisResult(comRSP, result)
        if result == "패배":
            if w >= 10:
                time.sleep(1) # Java의 Thread.sleep()
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".")
                time.sleep(1)
                print("댕고수...")
            elif w >= 5:
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".")
                time.sleep(1)
                print("좀 치네? ")
            else:
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".", end="")
                time.sleep(1)
                print(".")
                time.sleep(1)
                print("허접")
            break
    printFinalResult(w, d, t)

playGame()
    
        
























