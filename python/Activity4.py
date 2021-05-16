# Get the users names
user1 = input("What is Player 1's name? ")
user2 = input("What is Player 2's name? ")

# Run the algorithm to see who wins
playAgain = "Y"

while playAgain=="Y":
    user1_answer = input(user1 + ", do you want to choose rock, paper or scissors? ").lower()
    user2_answer = input(user2 + ", do you want to choose rock, paper or scissors? ").lower()

    if user1_answer == user2_answer:
        print("It's a tie!")
    elif user1_answer == 'rock':
        if user2_answer == 'scissors':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif user1_answer == 'scissors':
        if user2_answer == 'paper':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif user1_answer == 'paper':
        if user2_answer == 'rock':
            print(user1 +", Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")

    playAgain = input ("Do you want to try again Y / N : ").upper()

    if(playAgain=='Y'):
        continue
    elif(playAgain=='N'):
        print("Thanks for playing the Game!")
        raise SystemExit
    else:
        print("Invalid selection")
        raise SystemExit


        

