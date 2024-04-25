import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class Calculadora_de_Calorías extends JFrame implements ActionListener{

   private JComboBox <String> generoC;
   private JComboBox <String> ejercicioC;
   private JButton cal;
   private JButton exit;
   private JLabel calo;
   private JSpinner pesoS;
   private JSpinner alS;
   private JSpinner edadS;
   private double calD;
   private double TMB;
   private double peso;
   private double al;
   private double edad;
   private String genero;
   private String ejercicio;
   
   
   @Override
   public void actionPerformed (ActionEvent x){
      if(x.getSource()==cal){
         peso = (Double)pesoS.getValue();
         al = (Integer)alS.getValue();
         edad = (Integer)edadS.getValue();
         genero = generoC.getSelectedItem().toString();
         ejercicio = ejercicioC.getSelectedItem().toString();
         
         if(generoC.getSelectedItem().equals("Masculino")){
            TMB = ((10*peso)+(6.25*al)-(5*edad)+5); 
            
            if(ejercicio.equals("Poco o ningún ejercicio")){
               calD=TMB*1.2;
            }
               
            if(ejercicio.equals("Ejercicio ligero (1-3 días a la semana")){
               calD=TMB*1.375;
            }  
              
            if(ejercicio.equals("Ejercicio moderado (3-5 días a la semana)")){
               calD=TMB*1.55;
            }
            
            if(ejercicio.equals("Ejercicio fuerte (6-7 días a la semana)")){
               calD=TMB*1.725;
            }
               
            if(ejercicio.equals("Ejercicio muy fuerte (2 veces al día, entrenamientos muy duros)")){
               calD=TMB*1.9;
            }
            
         }//masculino
         
         if(generoC.getSelectedItem().equals("Femenino")){
            TMB = ((10*peso)+(6.25*al)-(5*edad)-161); 
            
            if(ejercicio.equals("Poco o ningún ejercicio")){
               calD=TMB*1.2;
            }
               
            if(ejercicio.equals("Ejercicio ligero (1-3 días a la semana")){
               calD=TMB*1.375;
            }  
              
            if(ejercicio.equals("Ejercicio moderado (3-5 días a la semana)")){
               calD=TMB*1.55;
            }
            
            if(ejercicio.equals("Ejercicio fuerte (6-7 días a la semana)")){
               calD=TMB*1.725;
            }
               
            if(ejercicio.equals("Ejercicio muy fuerte (2 veces al día, entrenamientos muy duros)")){
               calD=TMB*1.9;
            }
            
         }//femenino

         String caloD = String.valueOf(calD);
         calo.setText(caloD);
      
      }//x.getSource
   
      if(x.getSource()==exit){
         System.exit(0);
      }
   
   }//actionPerformed
    
   public Calculadora_de_Calorías(){
      inicializarComponentes();
      
   }
   
   public void inicializarComponentes(){
      this.setTitle("Cálculo de calorías");
      this.setSize(400,300);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setResizable(true);
      this.setLayout(new GridLayout(6,2,10,10));
      this.setLayout(new BorderLayout(5,5));
      
      JPanel panelT=new JPanel();
      panelT.setLayout(new BorderLayout(5,5));
      JLabel title= new JLabel("CÁLCULO DE CALORÍAS");
      title.setFont(new Font("",Font.BOLD, 20));
      title.setForeground(Color.blue);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      panelT.add(title,BorderLayout.CENTER);
      this.add(panelT,BorderLayout.NORTH);
      
      

      JPanel panelE = new JPanel();
      panelE.setLayout(new GridLayout(6,2,10,10));
      
      JLabel e1 = new JLabel ("Peso (kg):");
      e1.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(e1);
      
      pesoS = new JSpinner(new SpinnerNumberModel(60,1,300,0.5));
      panelE.add(pesoS, BorderLayout.WEST);
      
      JLabel e2 = new JLabel ("Altura (cm):");
      e2.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(e2);
      
      alS = new JSpinner(new SpinnerNumberModel(150,10,250,1));
      panelE.add(alS, BorderLayout.WEST);
      
      JLabel e3 = new JLabel ("Edad:");
      e3.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(e3);
      
      edadS = new JSpinner(new SpinnerNumberModel(20,1,100,1));
      panelE.add(edadS, BorderLayout.WEST);
      
      JLabel e4 = new JLabel ("Género:");
      e4.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(e4);
      
      
      
      generoC = new JComboBox<String>();
      generoC.addItem("Masculino");
      generoC.addItem("Femenino");
      panelE.add(generoC);
        
      JLabel e5 = new JLabel ("Cantidad de ejercicio:");
      e5.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(e5);
      
      ejercicioC = new JComboBox<String>();
      ejercicioC.addItem("Poco o ningún ejercicio");
      ejercicioC.addItem("Ejercicio ligero (1-3 días a la semana");
      ejercicioC.addItem("Ejercicio moderado (3-5 días a la semana)");
      ejercicioC.addItem("Ejercicio fuerte (6-7 días a la semana)");
      ejercicioC.addItem("Ejercicio muy fuerte (2 veces al día, entrenamientos muy duros)");
      panelE.add(ejercicioC);
      
      
      
      cal = new JButton("Calcular");
      panelE.add(cal);
      
      calo = new JLabel ("Calorías");
      calo.setHorizontalAlignment(SwingConstants.CENTER);
      panelE.add(calo);
      
      
      
      JPanel panelExit=new JPanel();
      panelExit.setLayout(new BorderLayout(5,5));
      exit = new JButton ("Salir");
      exit.setHorizontalAlignment(SwingConstants.RIGHT);
      panelExit.add(exit,BorderLayout.EAST);
      this.add(panelExit,BorderLayout.SOUTH);

      this.add(panelE);
      cal.addActionListener(this);
      exit.addActionListener(this);
      
   }
   
   
   public static void main (String []args){
      new Calculadora_de_Calorías().setVisible(true);
   
   }
   
}