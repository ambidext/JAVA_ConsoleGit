package com.home.calc;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorLauncher {

    static String IntCalc(String input)
    {
        String result = "";

        Stack<String> numStack = new Stack<String>();
        String strNum = "";

        if (input.charAt(0) == '-' || input.charAt(0) == '+')
            input = "0" + input;

        // 숫자 추출  
        int PlusMinus = 1;
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9')
            {
                strNum += input.charAt(i); 
            }
            else // +-*/ 기호 
            {
            	if (!strNum.equals(""))
            	    numStack.push(Integer.parseInt(strNum)*(PlusMinus)+"");
            	
            	if (numStack.peek().equals("*") || numStack.peek().equals("/") || numStack.peek().equals("+") || numStack.peek().equals("-"))
            	{
            		if (input.charAt(i) == '-')
            			PlusMinus = -1;
            		else 
            			PlusMinus = 1;
            	}
            	else 
            	{
            		numStack.push(input.charAt(i)+"");            		
            	}
                strNum = "";                
            }
        }
        if (strNum != "")
        {                
        	numStack.push(Integer.parseInt(strNum)*(PlusMinus)+"");
        }

        // 곱하기, 나누기 처리 
        Stack<String> calcStack = new Stack<String>();
        //for (String item : numStack)
        int len = numStack.size();
        for (int i=0; i<len; i++)
        {
        	String item = numStack.pop();
            if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-"))
            {
                calcStack.push(item);
            }
            else
            {
                if (calcStack.size() > 0 && calcStack.peek().equals("*"))
                {
                    int num2 = Integer.parseInt(item);
                    String str = calcStack.pop();
                    str = calcStack.pop();
                    int num1 = Integer.parseInt(str);
                    calcStack.push((num1*num2)+"");
                }
                else if (calcStack.size() > 0 && calcStack.peek().equals("/"))
                {
                    int num2 = Integer.parseInt(item);
                    String str = calcStack.pop();
                    str = calcStack.pop();
                    int num1 = Integer.parseInt(str);
                    if (num1 == 0)
                        return "INF";

                    calcStack.push((num2 / num1)+"");
                }
                else
                {
                    calcStack.push(item);
                }
            }
        }

        //// 더하기, 빼기 처리
        while (true)
        {
            if (calcStack.size() == 1)
            {
                result = calcStack.pop();
                break;
            }

            int num1, num2;
            String sym;
            String str = calcStack.pop();

            num1 = Integer.parseInt(str);
            sym = calcStack.pop();
            str = calcStack.pop();
            num2 = Integer.parseInt(str);

            int total = 0;
            if (sym.equals("+"))
                total = num1 + num2;
            else if (sym.equals("-"))
                total = num1 - num2;
            calcStack.push(total+"");
        }

        return result;
    }

    static String NormalCalc(String input)
    {
        String result = null;
        //------------------------------

        // 괄호 처리 
        Stack<String> charStack = new Stack<String>();
        String inBrace = "";
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == ')')
            {
                while (true)
                {
                    String temp = charStack.pop();
                    if (temp.equals("("))
                    {
                        String dc = IntCalc(inBrace);
                        for (int c = 0; c<dc.length(); c++) 
                        {
                            charStack.push(dc.charAt(c)+"");
                        }

                        inBrace = "";
                        break;
                    }
                    else
                    {
                        inBrace = temp + inBrace;
                    }
                }
            }
            else
            {
                charStack.push(input.charAt(i)+"");
            }
        }

        String str = "";
        for (String item : charStack)
        {
            str = str + item;
        }
        result = IntCalc(str);
        //------------------------------

        return result;
    }
    
    static String Conv10(String strNum)
    {
        Integer decNum = 0;
        if ((strNum.length() > 1) && (strNum.charAt(0) == '0' && strNum.charAt(1) == 'x'))
        {
            String hexNum = strNum.substring(2);
            for (int i=0; i<hexNum.length(); i++)
            {
                decNum += (hexNum.charAt(hexNum.length() - 1 - i) - '0') * (int)Math.pow(16.0, (double)i);
            }
            return decNum.toString();
        }
        else if ((strNum.length() > 1) && strNum.charAt(strNum.length()-1) == 'b')
        {
            for (int i = 0; i < strNum.length()-1; i++)
            {
                decNum += (strNum.charAt(strNum.length() - 2 - i) - '0') * (int)Math.pow(2.0, (double)i);
            }
            return decNum.toString();
        }
        else
        {
            return strNum;
        }
    }
    
    static String ProgrammerCalc(String input)
    {
        String result = null;
        //------------------------------
        String numQ = ""; 
        String strNum = "";

        // 숫자 추출 & 10진수 변환
        for (int i = 0; i < input.length(); i++)
        {
            if ((input.charAt(i) >= '0' && input.charAt(i) <= '9') || (input.charAt(i) == 'x') || input.charAt(i) == 'b')
            {
                strNum += input.charAt(i);
            }
            else
            {
                if (strNum != "")
                    numQ = numQ + Conv10(strNum);
                numQ = numQ + (input.charAt(i) + "");
                strNum = "";
            }
        }
        if (strNum != "")
            numQ = numQ + Conv10(strNum);

        String decRes = NormalCalc(numQ);
        int resNum = Integer.parseInt(decRes);
        String hexRes = "0x" + Integer.toHexString(resNum).toUpperCase();
        String binRes = Integer.toBinaryString(resNum) + "b"; 
        result = decRes + " " + hexRes + " " + binRes;
        //------------------------------
        return result;
    }
    
    static int factorial(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
    
    static double GetTriValue(String strNum)
    {
        double dNum;
        if (strNum.charAt(0) == 'S')
        {
            dNum = Double.parseDouble(strNum.substring(1));
            dNum = Math.sin(dNum*Math.PI/180.0);
        }
        else if (strNum.charAt(0) == 'C')
        {
            dNum = Double.parseDouble(strNum.substring(1));
            dNum = Math.cos(dNum * Math.PI / 180.0);
        }
        else if (strNum.charAt(0) == 'T')
        {
            dNum = Double.parseDouble(strNum.substring(1));
            dNum = Math.tan(dNum * Math.PI / 180.0);
        }
        else if (strNum.charAt(0) == 'L')
        {
            dNum = Double.parseDouble(strNum.substring(1));
            dNum = Math.log10(dNum);
        }
        else
        {
            dNum = Double.parseDouble(strNum);
        }
        return dNum;
    }
    
    static String DoubleCalc(String input)
    {
        String result = null;

        Stack<String> numStack = new Stack<String>();
        String strNum = "";

        if (input.charAt(0) == '-' || input.charAt(0) == '+')
            input = "0" + input;

        // 숫자 추출 & factorial 처리 
        for (int i = 0; i < input.length(); i++)
        { 
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == '.' || input.charAt(i) == 'S' || input.charAt(i) == 'C' || input.charAt(i) == 'T' || input.charAt(i) == 'L')
            {
                strNum += input.charAt(i);
            }
            else if (input.charAt(i) == '!')
            {
                Integer nNum = factorial(Integer.parseInt(strNum));
                strNum = "";
                numStack.push(nNum.toString());
            }
            else // +-*/ 기호 
            {
                Double dNum = GetTriValue(strNum);

                numStack.push(dNum.toString());
                strNum = "";
                numStack.push(input.charAt(i)+"");
            }
        }
        if (strNum != "")
        {
            Double dNum = GetTriValue(strNum);
            numStack.push(dNum.toString());
        }

        // 곱하기, 나누기, 거듭제곱 처리 
        Stack<String> calcStack = new Stack<String>();
        int len = numStack.size();
        for (int i=0; i<len; i++)
        {
        	String item = numStack.pop();
            if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-") || item.equals("^"))
            {
                calcStack.push(item);
            }
            else
            {
                if (calcStack.size() > 0 && calcStack.peek().equals("*"))
                {
                    Double num2 = Double.parseDouble(item);
                    String str = calcStack.pop();
                    str = calcStack.pop();
                    Double num1 = Double.parseDouble(str);

                    calcStack.push((num1 * num2) + "");
                }
                else if (calcStack.size() > 0 && calcStack.peek().equals("/"))
                {
                    Double num2 = Double.parseDouble(item);
                    String str = calcStack.pop();
                    str = calcStack.pop();
                    Double num1 = Double.parseDouble(str);
                    if (num1 == 0)
                        return "INF";

                    calcStack.push((num2 / num1) + "");
                }
                else if (calcStack.size() > 0 && calcStack.peek().equals("^"))
                {
                    Double num1 = Double.parseDouble(item);
                    String str = calcStack.pop();
                    str = calcStack.pop();
                    Double num2 = Double.parseDouble(str);

                    calcStack.push(Math.pow(num1, num2) + "");
                }
                else
                {
                    calcStack.push(item);
                }
            }
        }

        //// 더하기, 빼기 처리 
        
        while (true)
        {
            if (calcStack.size() == 1)
            {
                result = calcStack.pop();
                break;
            }

            Double num1, num2;
            String sym;
            String str = calcStack.pop();

            num1 = Double.parseDouble(str);
            sym = calcStack.pop();
            str = calcStack.pop();
            num2 = Double.parseDouble(str);

            Double total = 0.0;
            if (sym.equals("+"))
                total = num1 + num2;
            else if (sym.equals("-"))
                total = num1 - num2;
            calcStack.push(total.toString());
        }

        return result;
    }
    
    static String EngineeringCalc(String input)
    {
        String result = null;
        //------------------------------
        input = input.replace("SIN", "S");
        input = input.replace("COS", "C");
        input = input.replace("TAN", "T");
        input = input.replace("LOG", "L");

        // 괄호 처리 
        Stack<String> charStack = new Stack<String>();
        String inBrace = "";
        for (int i=0; i<input.length(); i++)
        {
            if (input.charAt(i) == ')')
            {
                while (true)
                {
                    String temp = charStack.pop();
                    if (temp.charAt(0) == '(')
                    {
                        String dc = DoubleCalc(inBrace);
                        for(int c = 0; c<dc.length(); c++)
                        {
                            charStack.push(dc.charAt(c)+"");
                        }

                        inBrace = "";
                        break;
                    }
                    else
                    {
                        inBrace = temp + inBrace;
                    }
                }
            }
            else
            {
                charStack.push(input.charAt(i)+"");
            }
        }

        String str = "";
        for (String item : charStack)
        {
            str = str + item;
        }
        result = DoubleCalc(str);
        double dRes = Double.parseDouble(result);
        result = String.format("%.3f", dRes);
        //------------------------------

        return result;
    }
    
	public static void main(String[] args) {		
        String NormalInput = "-3-(-3)";//"12+3*(7+3*2)+19/(3*(3/2))";// "-2+5*7+19/((2+1)*(2+1))";//
        String ProgrammerInput = "11b+(0x11*10b+1)-9";//"10b+0x23+9/3";//
        String EngineeringInput = "-0.123+2^(1/2)+SIN((40+5)*SIN(89+SIN(90)))+LOG(2*3+4)+5!";//"-2+2^(1/2)+SIN((40+5)*2)+LOG(2*3+4)+5!"; //"-2+2^(1/2)+SIN((40+5)*2)+LOG(2*3+4)+5!"; // 

        System.out.println("Normal Calculator: " + NormalInput);
        System.out.println(NormalCalc(NormalInput));
        System.out.println();
        System.out.println("Programmer Calculator: " + ProgrammerInput);
        System.out.println(ProgrammerCalc(ProgrammerInput));
        System.out.println();
        System.out.println("Engineering Calculator: " + EngineeringInput);
        System.out.printf("%.3f", Double.parseDouble(EngineeringCalc(EngineeringInput)));
	}
}
