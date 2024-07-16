class Avengers:
    def __init__(self, realName):
        self.realName = realName
    def attack(self):
        print("무찐 공격 !")
    def printInfo(self):
        print(self.realName)
############################################################################### 
class Human:
    def __init__(self, age):
        self.age = age
    def eat(self):
        print("쩝쩝박사")
    def attack(self):
        print("데미지 1짜리 발차기")
    def printInfo(self):
        print(self.age)
############################################################################### 
# Java : 다중 상속 - X (interface로 흉내만 냄)
# Python : 다중 상속 - O 
#        상속 받는게 중복되면(ex: 생성자, attack) 
#        => 먼저 상속받은거를 불러옴 (Avengers의 method) 
#        => Human의 method를 불러오고 싶으면 => 직접 입력해야...ㅠㅠㅠ

class Ironman(Avengers, Human):
    def __init__(self, realName, age):
        Avengers.__init__(self, realName)
        Human.__init__(self, age)
    
    def attack(self):
        Avengers.attack(self)
        Human.attack(self)
    
    def printInfo(self):
        Avengers.printInfo(self)
        Human.printInfo(self)
############################################################################### 
if __name__ == "__main__":
    i = Ironman("토니스타크", 40)
    i.attack()
    i.eat()
    i.printInfo()


















