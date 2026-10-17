# main.py
import random
def main():
    choices = ["rock","paper","scissors"]
    rounds = int(input("enter how many rounds you want to play : "))
    running = True
    bot_score = 0
    player_score = 0
    while rounds !=0 :
        counter = 1
        print(f"round {counter}")
        while(running) :
            player_choice = input("enter your choice : ").lower()
            if player_choice not in choices :
                print("enter a valid choice : ")
            else :
                running = False

        bot_choice = random.choice(choices)

        player_choice = player_choice.lower()

        bot_choice = bot_choice.lower()

        if player_choice == bot_choice :
            print("result is draw")

        elif player_choice == "rock" and bot_choice == "paper" :
            print("result is bot won")
            bot_score += 1

        elif player_choice == "rock" and bot_choice == "scissors" :
            print("result is player won")
            player_score += 1

        elif player_choice == "paper" and bot_choice == "rock" :
            print("result is player won")
            player_score += 1

        elif player_choice == "paper" and bot_choice == "scissors" :   
            print("result is bot won")
            bot_score += 1

        elif player_choice == "scissors" and bot_choice == "paper" :
            print("result is player won")
            player_score += 1

        elif player_choice == "scissors" and bot_choice == "rock" :   
            print("result is bot won")
            bot_score += 1  

        print(f"current round {counter} \n player score : {player_score} bot score : {bot_score}")    

        rounds = rounds - 1  


if __name__ == "__main__":
    main()
