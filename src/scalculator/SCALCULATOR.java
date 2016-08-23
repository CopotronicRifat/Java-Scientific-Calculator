/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scalculator;

/**
 *
 * @author Copotronic Rifat
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.lang.String;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class SCALCULATOR extends JApplet
{

    public void init()
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CalculatorPanel calcPanel=new CalculatorPanel();
                add(calcPanel);
            }
        });
    }
}

class CalculatorPanel extends JPanel
{
    private JTextField display1;
    private JTextField display2;
    private JPanel buttonPanel;
    private JPanel displayPanel;
    ActionListener listener=new CalculatorListener();
    ActionListener displayListener=new DisplayListener();
    void addDisplayButton(String type)
    {
        JButton button=new JButton(type);
        button.addActionListener(displayListener);
        buttonPanel.add(button);
    }
    void addCalcButton(String type)
    {
        JButton button=new JButton(type);
        button.addActionListener(listener);
        buttonPanel.add(button);
    }
    public CalculatorPanel()
    {
        setLayout(new BorderLayout());
        displayPanel=new JPanel();
        displayPanel.setLayout(new GridLayout(2,3));
        display1=new JTextField("");
        displayPanel.add(display1);
        display2=new JTextField("");
        displayPanel.add(display2);
        display1.requestFocusInWindow();
        add(displayPanel,BorderLayout.NORTH);
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(12,4));
        addCalcButton("1");
        addCalcButton("2");
        addCalcButton("3");
        addCalcButton("4");
        addCalcButton("5");
        addCalcButton("6");
        addCalcButton("7");
        addCalcButton("8");
        addCalcButton("9");
        addCalcButton("0");
        addCalcButton("(");
        addCalcButton(")");
        addCalcButton("1/x");
        addCalcButton("x\u00B2");
        addCalcButton("x\u00B3");
        addCalcButton("n!");
        addCalcButton("sin");
        addCalcButton("cos");
        addCalcButton("tan");
        addCalcButton("log");
        addCalcButton("sinh");
        addCalcButton("cosh");
        addCalcButton("tanh");
        addCalcButton("sqrt");
        addCalcButton("arcsin");
        addCalcButton("arccos");
        addCalcButton("arctan");
        addCalcButton("ln");
        addCalcButton("floor");
        addCalcButton("ceil");
        addCalcButton("abs");
        addCalcButton("PI");
        addCalcButton("e");
        addCalcButton("%");
        addCalcButton(".");
        addCalcButton("=");
        addCalcButton("+");
        addCalcButton("-");
        addCalcButton("*");
        addCalcButton("/");
        addDisplayButton("DEL");
        addCalcButton("ANS");
        addDisplayButton("AC");
        addDisplayButton("OFF");
        addCalcButton("x10");
        addCalcButton("BIN");
        addCalcButton("OCT");
        addCalcButton("HEX");
        add(buttonPanel,BorderLayout.CENTER);
    }
    ScriptEngineManager manager=new ScriptEngineManager();
    ScriptEngine engine=manager.getEngineByName("JavaScript");
    boolean opDone=false;

    private class DisplayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command=event.getActionCommand();

            if(command.equals("AC"))
            {
                display1.setText("");
                display2.setText("");
            }
            else if(command.equals("OFF"))
            {
                System.exit(0);
            }
            else if(command.equals("DEL"))
            {
                display1.setText(display1.getText().substring(0, display1.getText().length()-1));
            }
        }
    }
    private class CalculatorListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            String command=event.getActionCommand();

            try
            {
                if(command.equals("ln"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.log(input)));
                    opDone=true;
                }
                else if(command.equals("log"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.log10(input)));
                    opDone=true;
                }
                else if(command.equals("sin"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.sin((input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("tan"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.tan((input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("cos"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.cos(Math.floor(input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("sinh"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.sinh((input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("tanh"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.tanh((input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("cosh"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.cosh(Math.floor(input*Math.PI)/180)));
                    opDone=true;
                }
                else if(command.equals("floor"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.floor(input)));
                    opDone=true;
                }
                else if(command.equals("ceil"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.ceil(input)));
                    opDone=true;
                }
                else if(command.equals("abs"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.abs(input)));
                    opDone=true;
                }
                else if(command.equals("PI"))
                {
                    display1.setText(Double.toString(Math.PI));
                    display2.setText(Double.toString(Math.PI));
                    opDone=true;
                }
                else if(command.equals("e"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.exp(input)));
                    opDone=true;
                }
                else if(command.equals("x\u00B2"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(input*input));
                    opDone=true;
                }
                else if(command.equals("x\u00B3"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(input*input*input));
                    opDone=true;
                }
                else if(command.equals("sqrt"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.sqrt(input)));
                    opDone=true;
                }
                else if(command.equals("="))
                {
                    String input=display1.getText();
                    display2.setText(Double.toString(evaluateExpression(input)));
                    opDone=true;
                }
                else if(command.equals("ANS"))
                {
                    if(opDone)
                    {
                        display1.setText(display2.getText());
                    }
                    else
                    {
                        display1.setText(display1.getText()+display2.getText());
                    }

                    opDone=false;
                }
                else if(command.equals("1/x"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(1/input));
                    opDone=true;
                }
                else if(command.equals("arcsin"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.asin(input)*57.296));
                    opDone=true;
                }
                else if(command.equals("arctan"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.atan(input)*57.296));
                    opDone=true;
                }
                else if(command.equals("arccos"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(Math.acos(input)*57.296));
                    opDone=true;
                }
                else if(command.equals("n!"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(fact(input)));
                    opDone=true;
                }
                else if(command.equals("x10"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString((input)*10));
                    opDone=true;
                }
                else if(command.equals("BIN"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(tobin((int)input)));
                    opDone=true;
                }
                else if(command.equals("OCT"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(tooct((int)input)));
                    opDone=true;
                }
                else if (command.equals("HEX"))
                {
                    double input=evaluateExpression(display1.getText());
                    display2.setText(Double.toString(tohex((int)input)));
                    opDone=true;
                }
                else
                {
                    char opr=command.charAt(0);
                    if(opDone)
                    {
                        if(Character.isDigit(opr)||opr=='.')
                        {
                            display1.setText(command);
                        }
                        else
                            display1.setText(display2.getText()+command);
                    }
                    else
                        display1.setText(display1.getText()+command);
                    opDone=false;
                }

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        Double evaluateExpression (String expression) throws Exception
        {
            return (Double) engine.eval(expression);
        }
        double fact(double input)
        {
            int er = 0;
            if (input < 0)
            {
                er = 20;
                return 0;
            }
            double i, s = 1;
            for (i = 2; i <= input; i += 1.0)
            {
                s *= i;
            }
            return s;
        }
        int tobin(int input)
        {
            int r[];
            r=new int[100];
            int result=0;
            int n=0,i;
            while(input>0)
            {
                int mod=input%2;
                r[n]=mod;
                input/=2;
                n++;
            }
            while(n>=0)
            {
                result=10*result+r[n];
                n--;
            }
            return result;
        }
        int tooct(int input)
        {
            int ro[];
            ro=new int[100];
            int resulto=0;
            int no=0,io;
            while(input>0)
            {
                int modo=input%8;
                ro[no]=modo;
                input/=8;
                no++;
            }
            while(no>=0)
            {
                resulto=10*resulto+ro[no];
                no--;
            }
            return resulto;
        }
    }
    int tohex(int input)
    {
        int rh[];
        rh=new int[100];
        int resulth=0;
        int nh=0,ih;
        while(input>0)
        {
            int modh=input%16;
            rh[nh]=modh;
            input/=16;
            nh++;
        }
        while(nh>=0)
        {
            resulth=10*resulth+rh[nh];
            nh--;
        }
        return resulth;
    }
}
