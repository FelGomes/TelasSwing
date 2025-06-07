package swingpoo;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaInicial {

    public static void montarTelaInicial() throws IOException {

        final JFrame oJFrame = new JFrame("Cadastro de Empresa");

        oJFrame.setBounds(200, 150, 500, 400); //eixo x, eixo Y, largura e altura
        oJFrame.setLayout(null);
        
        JLabel oJLabelCNPJ = new JLabel("CNPJ:");
        oJLabelCNPJ.setBounds(10,20,60,25);
        oJLabelCNPJ.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(oJLabelCNPJ);
       
        final JTextField JTextFieldCNPJ = new JFormattedTextField(mascara("##.###.###/####-##"));
        JTextFieldCNPJ.setBounds(80, 20, 130, 25);
        JTextFieldCNPJ.setLayout(null);
        oJFrame.add(JTextFieldCNPJ);
        
        JLabel LabelRZ = new JLabel("RZ. SOC:");
        LabelRZ.setBounds(10, 40, 60, 55);
        LabelRZ.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(LabelRZ);
        
        
        JTextField jTextFieldRZ = new JTextField();
        jTextFieldRZ.setBounds(80,55,330,25); //80 vai ser a distancia da borda da esquerda para o meio
        jTextFieldRZ.setLayout(null);         // 55 a altura, (usa igual o ultimo campo do nome JLabel)
        oJFrame.add(jTextFieldRZ);           // 220 A largura do retangulo
                                            // 25 vai ser a altura do quadrado
                                            
        JLabel LabelTipo = new JLabel("Tipo:");
        LabelTipo.setBounds(5,87, 60, 25);
        LabelTipo.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(LabelTipo);
        
        
        final JComboBox<String> oJComboBox = new JComboBox<>();
        oJComboBox.setBounds(80, 90, 100, 20);
        oJComboBox.addItem("-Selecione-");
        oJComboBox.addItem("LTDA");
        oJComboBox.addItem("MEI");
        oJFrame.add(oJComboBox);
        
        
        JLabel JLabelData = new JLabel("Dat.Fund");
        JLabelData.setBounds(10, 120, 60, 25);
        JLabelData.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(JLabelData);
        
        final JTextField jTextFieldData = new JFormattedTextField(mascara1("##/##/#####"));
        jTextFieldData.setBounds(80, 125, 100, 20);
        jTextFieldData.setLayout(null);
        oJFrame.add(jTextFieldData);
        
        
        String[] colunas = new String[]{"CNPJ", "RZ.SOC", "TIPO", "DATA.FUND"};
        Object[][] dados = {};
        
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(30,170,400,120);
        scroll.setViewportView(tabela);
        oJFrame.add(scroll);
        
        JButton ojButtonGravar = new JButton("GRAVAR");
        ojButtonGravar.setBounds(30,300, 90, 25);
        oJFrame.add(ojButtonGravar);
        
        JButton ojButtonEditar = new JButton("EDITAR");
        ojButtonEditar.setBounds(130,300,90,25);
        oJFrame.add(ojButtonEditar);
        
        JButton ojButtonDeletar = new JButton("APAGAR");
        ojButtonDeletar.setBounds(230, 300, 100, 25);
        oJFrame.add(ojButtonDeletar);
        
        JButton ojButtonCancelar = new JButton("CANCELAR");
        ojButtonCancelar.setBounds(340,300,105,25);
        oJFrame.add(ojButtonCancelar);
        
        
                                      
                                            
        
        /*
        JButton oJButtonTela1 = new JButton("Tela 1");
        oJButtonTela1.setBounds(60, 60, 100, 30);
        oJFrameInicial.add(oJButtonTela1);

        JButton oJButtonTela2 = new JButton("Tela 2");
        oJButtonTela2.setBounds(200, 60, 100, 30);
        oJFrameInicial.add(oJButtonTela2);

        JButton oJButtonTela3 = new JButton("Tela 3");
        oJButtonTela3.setBounds(350, 60, 100, 30);
        oJFrameInicial.add(oJButtonTela3);*/

      oJFrame.setVisible(true);
    }
    
    
        //mascara para CNPJ
        public static MaskFormatter mascara(String mascara){
           
           MaskFormatter F_Mascara = new MaskFormatter();
           
           try {
               F_Mascara.setMask(mascara); // atribui a mascaraa
               F_Mascara.setPlaceholder("00.000.000/0001-00"); // caracter para preenchimento e os numeros
               
           } catch (ParseException excecao) {
               System.out.println(excecao.getMessage());
               
           }
           
           return F_Mascara;
           
       }  
        
        //mascara para data
        public static MaskFormatter mascara1(String mascara){
           
           MaskFormatter F_Mascara = new MaskFormatter();
           
           try {
               F_Mascara.setMask(mascara); // atribui a mascaraa
               F_Mascara.setPlaceholder(" "); // caracter para preenchimento e os numeros
               
           } catch (ParseException excecao) {
               System.out.println(excecao.getMessage());
               
           }
           
           return F_Mascara;
           
       }  
}

