class Bird:
    def __init__(self, name, asset):
        self.name = name
        self.asset = asset
     
    def printInfo(self):
        print(self.name, self.asset)
        
# [이 모듈을 실행했을 때 동작해라]가 가능한 조건
#    프로그램의 시작점이라는 뜻
# 이 모듈이 import를 당했을 때 아무작업도 하지 말고
#    실제 이 모듈에서 코드가 실행되었을때만 동작해라
#    >> 실질적인 main 역할이 가능 O
if __name__ == "__main__":
    from animal.pet import Dog
    d = Dog('고양이', 2)
    d.printInfo()
    


