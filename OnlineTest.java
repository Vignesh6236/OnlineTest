import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: The theory of Evolution was produced by?");
            jb[0].setText("Darwin");jb[1].setText("Einstein");jb[2].setText("Newton");jb[3].setText("Mendel");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Mount Everest is located in?");  
            jb[0].setText("India");jb[1].setText("Nepal");jb[2].setText("Tibet");jb[3].setText("China");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which tax is collected by Panchayats?");  
            jb[0].setText("Sales tax");jb[1].setText("Tax on local fairs");jb[2].setText("Land Revenue");jb[3].setText("Custom Duty");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: The device used for measuring altitudes is?");  
            jb[0].setText("altimeter");jb[1].setText("ammeter");jb[2].setText("audiometer");jb[3].setText("galvanometer");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Stethoscope was invented by?");  
            jb[0].setText("Bessemer");jb[1].setText("Rane Laennec");jb[2].setText(" Henry Becquarrel");jb[3].setText("none of these");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Who was the first Foreign Minister of free India?");  
            jb[0].setText("John Mathai");jb[1].setText(" Lal Bahadur Shastri");jb[2].setText("Jawaharlal Nehru");jb[3].setText("Gulzari Lal Nanda");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: On which of the following dates was Hiroshima Day observed?");  
            jb[0].setText("August 15, 1999");jb[1].setText("August 6, 1999");jb[2].setText("August 27, 1999");  
                        jb[3].setText("September 7, 1999");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: The ------ is the administrative section of the computer system?");  
            jb[0].setText("Memory Unit");jb[1].setText("Input Unit");jb[2].setText("Central Processing Unit");  
                        jb[3].setText("Control Unit");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Cinematography was invented by?");  
            jb[0].setText("Graham Bell");jb[1].setText("Edison");jb[2].setText("Zeiss");jb[3].setText("Faraday");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: 2010 World Cup football tournament was held in?");  
            jb[0].setText("Austria");jb[1].setText("Germany");jb[2].setText("Turin");  
                        jb[3].setText("South Africa");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[2].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  