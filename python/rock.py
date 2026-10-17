import random
options = ("rock","paper","scissors")
choice = None#equalent of 0 for integers this is string so None
computer = random.choice(options)
running=True
player=None#None because to make the below while working we have declare player above it
#we use runnign variable becayse in a long while loop code it will be harder to find break statement if the loop is said to true
#if i use a variable you can hold the variable(just put the cursor there) it is easier to find and edit
while running:
    while player not in options:
        #iterate until user gives a valid input
        #not in means the option user gave is not in
        player = input("enter a choice rock,paper or scissors : ")
    if player.lower()==computer.lower():
        print("it is a tie!")
    elif player == "rock"and computer == "scissors":
        print("gelichav")
    elif player == "paper"and computer=="rock":   
        print("gelichav")
    elif player == "scissors" and computer == "paper":
        print("gelichav")
    else :
        print("odipoyav")#erripukodi la odipoyav ki kuda statements rayachu like player = rock and computer = paper print("odipoyav")
        #it takes total 6 statemens(3 won 3 lose)
        # deeni kante 3 gelichave raaso else odipoyav raasthe only 4 statements         
    playing = input("still want to play click((yes or no)")
    if playing.lower()=="no":
        running=False
