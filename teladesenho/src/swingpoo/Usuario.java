/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import static swingpoo.TelaInicial.mascara1;

/**
 *
 * @author felipe
 */
public class Usuario {  
    
    
    public static void montarTelaUsuario() throws IOException {
        
        
        JFrame janela = new JFrame("INSERIR USUARIO");
        janela.setBounds(200,150,600,450);
        janela.setLayout(null);
        
        
        
        JLabel nomeUsuario = new JLabel("NOME:");
        nomeUsuario.setBounds(5, 20, 60, 25);
        nomeUsuario.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeUsuario);
        
        
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(20, 45, 250, 25);
        campoUsuario.setLayout(null);
        janela.add(campoUsuario);
        

        JLabel nomeEndereco = new JLabel("ENDERECO:");
        nomeEndereco.setBounds(5, 80, 80, 25);
        nomeEndereco.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeEndereco);
        
        
        JTextField campoEndereco = new JTextField();
        campoEndereco.setBounds(20, 108, 250, 25);
        campoEndereco.setLayout(null);
        janela.add(campoEndereco);
        
        
        JLabel nomeCPF = new JLabel("CPF:");
        nomeCPF.setBounds(310, 20, 60, 25);
        nomeCPF.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeCPF);
        
        JTextField campoCPF = new JFormattedTextField(mascaraCPF("###.###.###-##"));
        campoCPF.setBounds(340, 45, 250,25);
        campoCPF.setLayout(null);
        janela.add(campoCPF);
                
        
        JLabel campoSexo =  new JLabel("SEXO:");
        campoSexo.setBounds(315, 80, 60, 25);
        campoSexo.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(campoSexo);
        
        JComboBox<String> ojComboBox = new JComboBox<>();
        ojComboBox.setBounds(338, 108, 120, 25);
        ojComboBox.addItem("-SELECIONE-");
        ojComboBox.addItem("M");
        ojComboBox.addItem("F");
        janela.add(ojComboBox);
        
        JLabel nomeData = new JLabel("DAT.NASC");
        nomeData.setBounds(20, 140, 60, 25);
        nomeData.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeData);
        
        
        JTextField campoData = new JFormattedTextField(mascaraData("##/##/####"));
        campoData.setBounds(20, 170, 100, 25);
        campoData.setLayout(null);
        janela.add(campoData);
        
        
        JButton botaoSalvar = new JButton("SAVE");
        botaoSalvar.setBounds(310, 170, 80, 25);
        botaoSalvar.setBackground(Color.GREEN);
        janela.add(botaoSalvar);
        
        JButton botaoCancelar = new JButton("CANCEL");
        botaoCancelar.setBounds(400, 170, 100, 25);
        janela.add(botaoCancelar);
        
        JButton botaoAlterar = new JButton("ALTER");
        botaoAlterar.setBounds(310, 205, 80, 25);
        botaoAlterar.setEnabled(false);
        janela.add(botaoAlterar);
        
        JButton botaoDeletar = new JButton("DEL");
        botaoDeletar.setBounds(400, 205, 100, 25);
        botaoDeletar.setEnabled(false);
        janela.add(botaoDeletar);
        
        String[] colunas = new String[]{"Nome", "Sexo", "CPF", "Endereco", "Nascimento"};
        Object[][] dados = {};
        
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(30,250,500,150);
        scroll.setViewportView(tabela);
        janela.add(scroll);
        
        
        
        janela.setVisible(true);
        
    }
    
    public static MaskFormatter mascaraCPF(String mascara){
           
           MaskFormatter F_Mascara = new MaskFormatter();
           
           try {
               F_Mascara.setMask(mascara); // atribui a mascaraa
               F_Mascara.setPlaceholder("000.000.000-00"); // caracter para preenchimento e os numeros
               
           } catch (ParseException excecao) {
               System.out.println(excecao.getMessage());
               
           }
           
           return F_Mascara;
           
       }  
    
    public static MaskFormatter mascaraData(String mascara){
           
           MaskFormatter F_Mascara = new MaskFormatter();
           
           try {
               F_Mascara.setMask(mascara); // atribui a mascaraa
               F_Mascara.setPlaceholderCharacter(' '); // caracter para preenchimento e os numeros
               
           } catch (ParseException excecao) {
               System.out.println(excecao.getMessage());
               
           }
           
           return F_Mascara;
           
       }  

    
    
    
   
    
}
