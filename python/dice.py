#30-01-26
import random 
#● ┌ ┐ │ └ ┘ #these symbol are obtained by using some code in print statement

"┌─────────┐"
"│         │"
"│         │"
"│         │"
"└─────────┘"
#a dictionary of tuples
dice_art = { 1: ("┌─────────┐",
                 "│         │",
                 "│    ●    │",
                 "│         │",
                 "└─────────┘"),
              2:("┌─────────┐",
                 "│         │",
                 "│   ●  ●  │",
                 "│         │",
                 "└─────────┘"),
              3:("┌─────────┐",
                 "│    ●    │",
                 "│         │",
                 "│  ●    ● │",
                 "└─────────┘"),
              4:("┌─────────┐",
                 "│  ●    ● │",
                 "│         │",
                 "│  ●    ● │",
                 "└─────────┘"),
              5:("┌─────────┐",
                 "│  ●    ● │",
                 "│     ●   │",
                 "│  ●    ● │",
                 "└─────────┘"),   
              6:("┌─────────┐",
                 "│  ●    ● │",
                 "│  ●    ● │",
                 "│  ●    ● │",
                 "└─────────┘") }
dice = []#to store the dice value
total = 0
num_of_dice = int(input("enni dice vesthav"))
for die in range (num_of_dice):
    dice.append(random.randint(1,6))
#outer loop for no of dice
#inner for printing each line as it is a tuple with multiple values
for die in range(num_of_dice):
    for line in dice_art.get(dice[die]):
        print(line)
#for understaning if you remove the inner loop and directly print the tupel if will print tuple sideways which looks ugly        

#this prints sideways but not the ugly sideways i said above
# for line in range(5):
#     for die in dice:
#         print(dice_art.get(die)[line],end="")
#     print()    
for die in dice :
    total +=die
print(f"total is {total}")        