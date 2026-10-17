questions = ("what is your gender","who has largest dih","who won GOTY last year","what is my favourite game")
#it is tuple coz we dont add or remove questions (in a real quiz) also tuple is way faster than list
options = (("A.male" ,"B.female", "c.email", "d.blackmail"),
           ("a.me ","b.you", "c.dog" ,"d.your friend"),
           ("a.astro bot" ,"b.ghost of tsushima"," c.ghost of yotei" ,"d.baldur gate 3"),
           ("a.rdr", "b.mortal kombat", "c. rdr2" ,"d.ghost of tsushima"))#looks good and makes code esier to write
#same reasons as questions . we use 2d tuple as in each question we have multiple options a question(2d tuple) has options(1d tuple)
answers = ("a","a","a","d")
guesses = []#after each question we add the guess given by user to list so we use list instead of tuple
#we dont show 5 questions at a time so for each question we add the guess
qno=0#qno used to print options of specific qusetion instead of printing all options for a specific question
score=0
for question in questions:#iterating thtrough eaach question
    print(question)
    for option in options[qno]:
#if we write options without qno since it is inner loop it prints all options of questions for a singl question which will repeat 4 times duw to 4 questions 
        print(option)
    guess=input("edi correct anin ni brain anukuntondo adi enter chey :")#taking the guess given by user 
    guesses.append(guess)#adding the guess given by user to guess list
    if guess.lower()==answers[qno].lower():#making lower so even if the user gives capital letteer it works we can make viceversa by .upper
        print("correct ra munda")
        score+=1
    else:
        print(f"thappu ra munda answer is {answers[qno]}")        
    qno = qno+1
#if not incremented it always shows the options of 1st question last line coz we use this in answers checking which essentaila to check to current question instead of next question
# i=0    
# for answer in answers :
#     if answer.lower==guesses[i].lower:
#         score=score+1
#     i+=1    #this works but above one looks good
print(score)
