# 숫자야구 (3자리) (함수) (각 자릿수의 숫자는 중복 X)
# 012 ~ 987 중에 랜덤한 숫자 정답 (각 자리의 값들은 list에 담기)
# 유저가 입력 => 자릿수와 값까지 같으면 S, 자릿수는 다른데 값이 같으면 B
# S가 3개 나오면 정답! => 종료
from random import randint
from time import sleep

def printRule():
    print("-====================-")
    print("세 자리 숫자를 입력합니다")
    print("컴퓨터의 세 자리 숫자를 맞히면 승리,")
    print("컴퓨터의 세 자리 숫자를 맞히지 못 하면 패배입니다")
    sleep(1)
    print("기회는 10번 입니다")
    print("세 숫자는 서로 중복되지 않고,")
    print("100의 자리 숫자, 10의 자리 숫자에 0은 올 수 있습니다")
    print("당신께 숫자를 맞히는데 도움이 될 힌트를 제공해드리겠습니다")
    sleep(1)
    print("만약 당신의 숫자와 컴퓨터의 숫자의 자릿수와 값이 같으면")
    print("Strike,")
    print("만약 당신의 숫자와 컴퓨터의 숫자의 값은 같지만 자릿수가 다르다면")
    print("Ball,")
    print("만약 당신의 숫자가 컴퓨터의 숫자와 일치하는 값이 없다면")
    print("Out으로 매 번 보여드리겠습니다")
    sleep(1)
    print("그럼 즐거운 게임 되시길")
    sleep(0.4)
    
def getCom():
    s = set()
    while len(s) != 3:
        s.add(randint(0,9))
    return list(s)

def getUser():
    print("-====================-")
    num = input("각 자리가 중복되지 않는 세 자리 숫자를 입력하세요\n숫자 : ")
    numList = []
    if 0 <= int(num) <= 999:
        for n in num:
            numList.append(int(n))
        if len(set(numList)) != 3:
            print("중복된 숫자를 입력했습니다")
            print("다시 입력해주세요")
            return getUser()
        return numList
    else:
        print("Wrong Input")
        return getUser()    

def judgeMatch(uL, cL):
    ball, strike = 0, 0
    for i, u in enumerate(uL):
        if u in cL:
            if i == cL.index(u):
                strike += 1
            else:
                ball += 1
    out = 3 - strike - ball
    return strike, ball, out

def printHint(s, b, o):
    print("-====================-")
    print("%d Strike" % s)
    print("%d Ball" % b)
    print("%d Out" % o)

def printWin(t):
    print("-====================-")
    print("축하드립니다!")
    print("당신의 승리입니다")
    print("당신은 %d회만에 승리하셨습니다" % t)

def printLose():
    print("-====================-")
    print("아쉽게도 당신은 패배했습니다")
    print("나가세요")
    sleep(0.01)

def playGame():
    printRule()
    turn = 0
    comList = getCom()
    while turn != 10:
        userList = getUser()
        s, b, o = judgeMatch(userList, comList)
        printHint(s, b, o)
        turn += 1
        if s == 3:
            printWin(turn)
            return
    printLose()

playGame()
















