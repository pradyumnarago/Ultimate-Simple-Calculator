package com.example.sc;

public class Expression{
    char[] infix;
    String[] postfix;
    double val;
    public double getVal() {
        return val;
    }
    Expression(String infix){
        this.infix=infix.toCharArray();
        this.postfix = new String[this.infix.length+1];
        val=0;
    }

    int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*'|| c == '%')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    void infix_to_postfix(){
        String[] stack = new String[100];
        boolean flag=false;
        int i=0,j=0,stackIndex=-1;
        while(i<infix.length){
            char c=infix[i];
            if((c>='0' && c<='9')||c=='.'){
                if(flag){
                    postfix[j-1]= (postfix[j-1]+String.valueOf(c));
                }else {
                    flag=true;
                    postfix[j++]=String.valueOf(c);
                }

            }else if (c == '(') {
                stack[++stackIndex] = String.valueOf(c);
                flag=false;
            }else if (c == ')') {
                while (stackIndex >= 0 && stack[stackIndex].charAt(0) != '(') {
                    postfix[j++] = stack[stackIndex--];
                }
                stackIndex--; // Pop '('
                flag=false;
            }else {
                while ((stackIndex >= 0) && (prec(c) < prec(stack[stackIndex].charAt(0)) ||
                        (prec(c) == prec(stack[stackIndex].charAt(0))))) {
                    postfix[j++] = stack[stackIndex--];
                }
                stack[++stackIndex] = String.valueOf(c);
                flag=false;
            }
            i++;
        }

        // Pop all the remaining elements from the stack
        while (stackIndex >= 0) {
            postfix[j++] = stack[stackIndex--];
        }
        postfix[j]=null;
    }
    void evaluate() {
        double[] stack = new double[100];
        int i,top=-1;
        boolean flag=true;
        for(i=0;postfix[i]!=null;i++){
            flag=true;
            try {
                double inte=Double.parseDouble(postfix[i]);
                stack[++top]=inte;
                flag=false;
            }
            catch (Exception e){
                flag=true;
            }
            if(flag){
                double val1 = stack[top--];
                double val2 = stack[top--];

                switch (postfix[i].charAt(0)) {
                    case '+':
                        stack[++top]=(val2 + val1);
                        break;
                    case '-':
                        stack[++top]=(val2 - val1);
                        break;
                    case '*':
                        stack[++top]=(val2 * val1);
                        break;
                    case '/':
                        stack[++top]=((double)val2 / val1);
                        break;
                    case '^':
                        stack[++top]=Math.pow(val2,val1);
                        break;
                    case '%':
                        stack[++top]=val2%val1;
                        break;
                }
            }
        }

        val=stack[top];
    }
}

