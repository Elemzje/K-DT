# UP/DOWN 게임 (함수)
# 유저의 이름을 입력받고 환영하는 인사를 출력
# (컴퓨터) 1 ~ 100사이의 랜덤한 숫자를 하나 뽑아서
# 유저에게 정답을 입력하게 했을 때
# 저 범위의 숫자가 아니면 다시 입력하도록
# 입력한 숫자가 정답보다 작으면 'UP', 크면 'DOWN' 출력
# 정답을 맞췄을 때는 몇 번만에 맞췄는지 출력 + 종료
# 정답 기회는 총 10번
import random

def getUsername():
    return input("이름을 입력해주세요\n이름 : ")

def helloUser(username):
    print("----------------------------------")
    print("어서오세요 {}님".format(username))
    print("----------------------------------")

def getRandomNum():
    return random.randint(1,100)

def getUserNum():   
    print("범위는 1 ~ 100")
    userNum = int(input("숫자를 입력해주세요\n숫자 : "))
    return userNum if 1 <= userNum <= 100 else getUserNum()

def judgeUpDown(userNum, comNum):
    if userNum > comNum:
        return "down"
    elif userNum < comNum:
        return "up"
    else:
        return "정답"

def printResult(count, upDown):
    print("{}트, {} !".format(count, upDown))
    print("-------------------------------")

def printUpDown(upDown):
    print(upDown)
    print("-------------------------------")

def printFail(comNum):
    print("10번 안에 못 맞히네")
    print("정답은 {}란다".format(comNum))
    print("다음에는 맞히길 바랄게")
    print("수고하고")

def playUpDown(comNum):
    count = 0
    while count < 10:
        count += 1
        userNum = getUserNum()
        upDown = judgeUpDown(userNum, comNum)
        if upDown == "정답":
            printResult(count, upDown)
            return
        else:
            printUpDown(upDown)
    printFail(comNum)
    
def start():
    helloUser(getUsername())
    comNum = getRandomNum()
    playUpDown(comNum)
    
start()
















