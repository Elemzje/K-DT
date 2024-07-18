# OracleDB와 연동이 되는 Java : instantClient에 있는 ojdbc8.jar
# OracleDB와 연동이 되는 Python : cx_Oracle.py(가 instantClient를 사용)
from cx_Oracle import connect

# 기본적으로 python에는 OracleDB 연결 기능이 없어요...
# 시작 - cmd -> pip install cx_oracle
# pip list

# sqlplus로 접속할 때 사용하는 주소
#    sqlplus [ID]/[PW]@[IP Address]:[PORT]/[SID]
#    sqlplus minju/3045@localhost:1521/xe

try:
    c = connect("minju/3045@localhost:1521/xe")
    print("success !")
except Exception as e:
    print(e)

c.close()