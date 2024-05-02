# Ultimate-Simple-Calculator
I built this using android studio, It could do basic operations but given in a complex form like (((3/2)+5)^2)%2. So, basically here, I converted the given expression to postfix, and then evaluate postfix expression which is easy for a computer.
<br><br>
You can isntall this app and try it out by downloading https://github.com/pradyumnarago/Ultimate-Simple-Calculator/app-debug.apk in the above files.
<br><br>
You can find the Expression.java in the folder :- https://github.com/pradyumnarago/Ultimate-Simple-Calculator/app/src/main/java/com/example/Expression.java
<br><br>
You can find the MainActivity.java in the folger :- https://github.com/pradyumnarago/Ultimate-Simple-Calculator/app/src/main/java/com/example/MainActivity.java
<br><br>
You can find the activity_main.xml in the folder :- https://github.com/pradyumnarago/Ultimate-Simple-Calculator/tree/main/app/src/main/res/layout/activity_main.xml
<br><br>
This Java code is for converting infix mathematical expressions to postfix notation and then evaluating the postfix expression. Let's break down the logic step by step:
<br><br>
Expression Class: This class represents a mathematical expression. It has the following attributes:
<br><br>
infix: An array of characters representing the infix expression.
<br><br>
postfix: An array of strings representing the postfix expression.
<br><br>
val: A double variable to store the evaluated result of the expression.
<br><br>
Constructor: The constructor initializes the infix array with the provided infix expression, converts it into postfix notation, and initializes val to 0.
<br><br>
prec Method: This method returns the precedence of operators. It assigns higher precedence values to operators with higher priority.
<br><br>
infix_to_postfix Method: This method converts the infix expression to postfix notation using the Shunting-yard algorithm:
<br><br>
It initializes a stack to hold operators and a flag to track whether the previous character was a digit.
<br><br>
It iterates through each character in the infix expression.
<br><br>
If the character is a digit or a decimal point, it appends it to the current operand in the postfix array.
<br><br>
If the character is an opening parenthesis, it pushes it onto the stack.
<br><br>
If the character is a closing parenthesis, it pops operators from the stack and appends them to the postfix array until an opening parenthesis is encountered.
<br><br>
If the character is an operator, it compares its precedence with the precedence of operators at the top of the stack. If the precedence is higher or equal, it pops operators from the stack and appends them to the postfix array until the stack is empty or an operator with lower precedence is encountered. Then, it pushes the current operator onto the stack.
<br><br>
Finally, it pops any remaining operators from the stack and appends them to the postfix array.
<br><br>
evaluate Method: This method evaluates the postfix expression:
<br><br>
It initializes a stack to hold operands.
<br><br>
It iterates through each element in the postfix array.
<br><br>
If the element is a number, it pushes it onto the stack.
<br><br>
If the element is an operator, it pops the top two operands from the stack, performs the operation, and pushes the result back onto the stack.
<br><br>
After iterating through all elements, the final result is stored in the val variable.
<br><br>
Overall, this code provides functionality to convert infix expressions to postfix notation and evaluate the result using stacks.