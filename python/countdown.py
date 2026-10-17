import time 
import winsound#for spund after program ends
#taking the input of no of seconds for countdown
t = int(input("enter the amount of time required for counrdown : "))
#loops for the no of seconds given as input like if 5 seconds it iterates 5 times
#each iteration prints the number and stops for one second which after all iterations results in a countdown
#since it is a coundown we use reversed
#in this program % acts like turn around if minutes exceed 60 it becomes 0 and runs again if hours exceed 24 it becomes 0 again
for i in reversed(range (1,t+1)):#we can use for i in range(t,0,-1) here -1 is step
    seconds = i % 60#repeats itself around ex for 5 seconds shows 5 for 68 seconds shows 8 for 96 shows 36
    minutes=int((i/60)%60)#given seconds divided by 60 gives minutes we type cast to int as we dont need decimal part it is in seconds
    hours = int((i/3600)%24)
    #print(i+1)
    print(f"{hours:02}:{(minutes):02}:{seconds:02}")#in 02 o for zero padding 2 means 2 places or 2 digites
    time.sleep(1)#the program sleeps for that time then executes the next line
winsound.Beep(1000, 500)  # 1000 Hz, 500 ms
print("boom")    

