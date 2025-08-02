HISTORY_FILE ="history.txt"

def show_history():

    #open the file
    file=open(HISTORY_FILE,'r')
    lines=file.readlines()

    #check is there any data in the file
    if len(lines) == 0:
        print("No history found")
    else:
        for line in reversed(lines):
            print(line.strip())
    file.close()

#if we want to clear the files content where we can strat with new content
def clear_history():
    file=open(HISTORY_FILE,'w')
    file.close()
    print('History cleared.')

def save_to_history(equation,result):
    file=open(HISTORY_FILE,'a')
    file.write(equation + "=" + str(result)+ "\n")
    file.close()

def calculate(user_input):
    #now if the user give '2+2'  this will be in single string . so we have to split the string into array  ['2','+','2']
    parts=user_input.split()
    if len(parts) != 3:
        print('Invalid input. Use formate : number operator number (e.g: 8+8)')
        return
    num1=float(parts[0])  #'2' to floating number 2.0
    op=parts[1]    # '+' is a string
    num2=float(parts[2])  #'2' to floating number 2.0

    if op == "+":
        result=num1 + num2
    elif op == "-":
        result=num1- num2
    elif op == "*":
        result=num1 * num2
    elif op == "/":
        if num2 == 0:
            print('cannot divide by zero')
            return
        
        result=num1/num2
    else :
        print('Invaid operator . use on;y +,-,*,/')

    if int(result) == result:
        result=int(result)
    print('Result:',result)
    save_to_history(user_input,result)

def main():
    print('SIMPLE CALCULATOR (type history , clear or exit)')

    while True:
        user_input =input("Enter calculation(+ - * /) or command (history,clear,exit) = ")
        if user_input == 'exit':
            print('Goodbye')
            return
        elif user_input == 'history':
            show_history()
        elif user_input == 'clear':
            clear_history()
        else:
            calculate(user_input)

main()