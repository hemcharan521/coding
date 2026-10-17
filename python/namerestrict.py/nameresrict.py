#strenths string methods alao brain degifies

name = input("enter your name ")

while True :
    enter = False
    if(len(name)>13):
        print("name should be no more than 12 characters")
        enter = True
    if(name.find(" ")>0):
        print("name should not containn spaces")
        enter = True 
    if(any(char.isdigit() for char in name)):
        print("name should not containn numbers")
        enter = True
    if(enter == True ):
        name = input("malli number enter chey ra munda nayala")
    if(enter == False):
        break;    

print(name)    
        

