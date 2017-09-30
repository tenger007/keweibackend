package cn.cncic.util;

import java.util.ArrayList;
import java.util.Stack;

public class Test1 {

private int x1, x2, x3, x4;

public Test1(int x1, int x2, int x3, int x4) {
this.x1 = x1;
this.x2 = x2;
this.x3 = x3;
this.x4 = x4;
}

public Test1() {
}

public void answer() {
int f1, f2, f3, f4;
int a, b, c, le, ri;
ArrayList<String> expres = new ArrayList<String>();
expres.add("");
expres.add("");
expres.add("");
expres.add("");
String e[] = { "+", "-", "*", "/" };
int left[] = { 0, 2, 4 };// 左括号的可能位置
int right[] = { 4, 6, 8 };// 右括号的可能位置
// 排列好四个数字
for (f1 = 1; f1 <= 4; f1++) {
for (f2 = 1; f2 <= 4; f2++) {
if (f2 != f1)
for (f3 = 1; f3 <= 4; f3++) {
if (f3 != f2 && f3 != f1)
for (f4 = 1; f4 <= 4; f4++) {
if (f4 != f3 && f4 != f2 && f4 != f1) {
// expres.clear();
// expres.ensureCapacity(10);

expres.set(f1 - 1, String.valueOf(x1));
expres.set(f2 - 1, String.valueOf(x2));
expres.set(f3 - 1, String.valueOf(x3));
expres.set(f4 - 1, String.valueOf(x4));

// 安排四种运算符
ArrayList<String> expres2 = new ArrayList<String>();
ArrayList<String> expres3 = new ArrayList<String>();
expres2 = (ArrayList<String>) expres
.clone();
for (a = 1; a <= 4; a++) {// 第1个操作符
for (b = 1; b <= 4; b++) {// 第2个操作符
for (c = 1; c <= 4; c++) {// 第3个操作符
expres2 = (ArrayList<String>) expres
.clone();
expres2.add(1, e[a - 1]);
expres2.add(3, e[b - 1]);
expres2.add(5, e[c - 1]);

// 安排括号的位置

for (le = 0; le < 3; le++) {
for (ri = le; ri < 3; ri++) {
if (!(le == 0 && ri == 2)) {
expres3 = (ArrayList<String>) expres2
.clone();
expres3.add(
left[le],
"(");
expres3.add(
right[ri],
")");
// 表达式构造完成
// 计算结果(没构造两个括号的表达式)
if (Math.abs(calculate(expres3) - 24) < 0.0000000001) {//由于double的产生的误差会忽略一些结果
for (String string : expres3) {
System.out
.print(string);
}
System.out
.println();
}
}
}
}
}
}
}
}
}
}
}
}
}

Stack<String> optr;
Stack<String> opnd;

private final double calculate(ArrayList<String> b) {
ArrayList<String> a = new ArrayList<String>();
a = (ArrayList<String>) b.clone();
a.add("#");// 表达式尾部添加标记
double result = 0;
optr = new Stack<String>();// 存放运算符
optr.push("#");
opnd = new Stack<String>();// 存放操作数和结果

String opera = "+-*/()#";

String op1, op2, operat, string;
int i = 0;
// for (String string : a) {
string = a.get(i);
while (optr.peek() != "#" || string != "#") {
if (opera.indexOf(string) < 0) {
opnd.push(string);
i++;
string = a.get(i);
} else {
switch (Precede(optr.peek().charAt(0), string.charAt(0))) {
case '<':
optr.push(string);
i++;
string = a.get(i);
break;
case '=':
optr.pop();
i++;
string = a.get(i);
break;
case '>':
operat = optr.pop();
op2 = opnd.pop();
op1 = opnd.pop();
opnd.push(String.valueOf(operate(op1, operat, op2)));
default:
break;
}
}
}
result = Double.parseDouble(opnd.peek());
return result;
}

private final char Precede(char theta, char thetb) {
char cmp = 0;
switch (thetb) {
case '+':
case '-':
if (theta == '(' || theta == '#')
cmp = '<';
else
cmp = '>';
break;
case '*':
case '/':
if (theta == '*' || theta == '/' || theta == ')')
cmp = '>';
else
cmp = '<';
break;
case '(':
if (theta == ')') {
System.out.println("error 1 )");
// printf("ERROR!\n");
// exit( 0 ) ;
} else
cmp = '<';
break;
case ')':
if (theta == '(')
cmp = '=';
else {
if (theta == '#') {
System.out.println("error 2 # )");
// printf("ERROR!\n");
// exit( 0 ) ;
} else
cmp = '>';
}
break;
case '#':
if (theta == '(') {
System.out.println("error 3 (");
// printf("ERROR!\n");
// exit( 0 ) ;
} else {
if (theta == '#')
cmp = '=';
else
cmp = '>';
}
break;
}
return cmp;
}

private double operate(String a, String b, String c) {
double result = 0;
if (b == "+")
return Double.parseDouble(a) + Double.parseDouble(c);
else if (b == "-")
return Double.parseDouble(a) - Double.parseDouble(c);
else if (b == "*")
return Double.parseDouble(a) * Double.parseDouble(c);
else if (b == "/")
return Double.parseDouble(a) / Double.parseDouble(c);
return 0;
}

public static void main(String[] args) {
new Test1(3, 5, 8, 8).answer();
// ArrayList<String> test = new ArrayList<String>();
// test.add("3");
// test.add("*");
// test.add("(");
// test.add("7");
// test.add("-");
// test.add("2");
// test.add(")");
// double result = new Suan24().calculate(test);
// System.out.println(result);
}

}

