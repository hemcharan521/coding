#we ask the user what are the games he want to bur and add to shopping cart then print the bill
#using lists as we want the bill in order but we can  use sets it just looks ugly thats it it is our choice
#we didnt use tuple as we cannot add or remove in it
games=[]
prices=[]
total=0
i=0#for printing the price along side the items in the bill
while True :#infinite loop as we only stop when unser tell us to 
    game =input("enter the game you want to buy lambdi kodaka (d for dengey) : ")
    if(game.lower() == "d"):#lower used to convert sring into lower case even if lambdi kodaka enteres D it still exits
        break
    else :
        games.append(game)#adding the game to games list
        price = int(input(f"enter the price of the game {game} : "))
        prices.append(price)#addng the price of game to prices liist
# for i in range(len(games)):#we can se for game in games i used this because i am theda normally this is more preferrable and readable than than range one
#     total = total + prices[i]
for game in games :#looks clean than above one game is variable name not the game we used above it is best practice not rule i can use i or j instead of it
    print(game,end=f" - {prices[i]}\n")#\n for new line "end" adds anything to end of print statement normaally defalut is new line since i want price along side i added price using index
    #since iam in games loop i cannot use price in prices so i have to access using index 
    i=i+1#index incrimentation
for price in prices :
    total = total + price    #iterating through price list and adding each game's price
print(f"the total bill is {total}")    
#here we use list because duirng bill printing we show game name along side price if it is set we cant do that as they are not ordered
#tuples not used as they suck           