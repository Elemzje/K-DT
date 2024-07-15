# function(함수)
# def 함수명(파라미터명):    
    # code

def test():
    print("잠못잔 오빈규")

def test2():    # :을 썼으면 그 다음줄에는 반드시 들여쓰기를 해야!!
    pass        # : 뒤에 코드 적을것이 없을 때, 자리채워주라는 의미

# 정수 2개를 넣으면 그 합을 '출력'하는 함수
def printHab(x=5, y=8): # 호출할 때 값을 안넣어주면 함수파라미터의 값을
                        # 기본값으로 사용
    print(x + y)

# 정수 3개를 넣으면 그 합을 '출력'하는 함수
def printHab2(x, y, z):   # overloading이 안됨 => 모든 함수명이 다 달라야...
    print(x + y + z)
    
# 정수 2개를 넣으면 그 합을 '구하는' 함수
def getHab(x, y):
    return x + y

# 정수 2개를 넣으면 사칙연산 결과를 '구하는' 함수
def calc(x, y):
    '''
        설명서...
        ㅁㄴㅇ;ㄻㄵ대ㅑㅍㅁ@!$$#%@%#!%!@#%
    '''
    
    
    return x + y, x - y, x * y, x / y   # tuple 하나 리턴

#------------------------------------------------------------------------------ 
help(calc)
help(print)
test()
printHab(10, 15)
printHab()
printHab2(14, 24, 9)
a = getHab(2, 4)
print(a)

d = calc(20, 10)
print(d, type(d))

# u, i, o, p = calc(20, 10)

u, i, _, p = calc(20, 10)   # _ 처리하면 곱하기 결과 안가져올수 있음
print(u, i, p)
