menu= {"biryani":200,
      "curdrice":80,
      "kushka":120,
      "chickenfry":180,
      "coke":50,
      "sprite":70,
      "mazaa":40}#menu using dictionaries it is in dictionary coz this program is for learning dictionary
#this feels more like a list than the bill program that uses lists
cart = []#a list that can store keys(the items we order)
total = 0
for key,value in menu.items():#only way(i know) to print both keys and values at same time
    print(f"{key} : {value}rupaayalu")
while True:#since menu style or asking user we infinte loop until user says dengey
    food=input("enter an item you want to buy (d for dengey): ")    
    if food.lower()=="d":
        break
    elif menu.get(food) is not None:#get gets data fromm menu since if i enter a food that not in menu means that food is None
        #we want to add a food to list which is not none means is present in the list even if  i enter iit it will not be in list
        cart.append(food)
print("the items in your billl are :")        
for food in cart:#loop throgh each element in cart list and add it to total read below lines for more understanding
    total = total + menu.get(food)#get() is a dictionary method which says not found if a key is not iin dictionary instead of raising a error 
    #if key is present then returns value associated with that key
    #it goes to menu then checks food means a item in cart which is a key when it  matches return value(cost) then we add it to total 
    print(food)  #just to show what are the items that our user bought
print(f"your total bill is {total}")     