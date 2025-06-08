/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingpoo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        janela.setBounds(200,150,600,550);
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
        
        // botoes // 
        JButton botaoSalvar = new JButton("SAVE");
        botaoSalvar.setBounds(350, 170, 80, 25);
        botaoSalvar.setBackground(Color.GREEN);
        janela.add(botaoSalvar);
        
        JButton botaoCancelar = new JButton("CANCEL");
        botaoCancelar.setBounds(450, 170, 100, 25);
        janela.add(botaoCancelar);
        
        JButton botaoAlterar = new JButton("ALTER");
        botaoAlterar.setBounds(350, 205, 80, 25);
        botaoAlterar.setEnabled(false);
        janela.add(botaoAlterar);
        
        JButton botaoDeletar = new JButton("DEL");
        botaoDeletar.setBounds(450, 205, 100, 25);
        botaoDeletar.setEnabled(false);
        janela.add(botaoDeletar);
        
        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(350, 240, 80, 25);
        janela.add(botaoFiltrar);
        
        String[] colunas = new String[]{"Nome", "Sexo", "CPF", "Endereco", "Nascimento"};
        ArrayList<EUsuario> oListaUsuario = new ArrayList<>();
        PUsuario ppUsuarios = new PUsuario();
       /* 
        try {
            oListaUsuario = ppUsuarios.consultarPessoa();
        } catch(SQLException e1){
            System.out.println(e1.getMessage());*/
        //}
        
        String linhas[][] = new String[oListaUsuario.size()][5];
        
        int i = 0;
        
        for(EUsuario usu: oListaUsuario){
            
            linhas[i][0] = usu.getNome();
            linhas[i][1] = usu.getSexo();
            linhas[i][2] = usu.getCpf();
            linhas[i][3] = usu.getEndereco();
            linhas[i][4] = usu.getDataNasc();
            
            i++;
            
        }
        
        JLabel nomeFiltro = new JLabel("FILTRO:");
        nomeFiltro.setBounds(10, 205, 60, 25);
        nomeFiltro.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeFiltro);
        
        
        JTextField campoFiltro = new JTextField();
        campoFiltro.setBounds(20, 230, 250, 25);
        campoFiltro.setLayout(null);
        janela.add(campoFiltro);

        /// tabela
        JTable tabela = new JTable(linhas, colunas);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(30,270,515,220);
        scroll.setViewportView(tabela);
        janela.add(scroll); 
        
        
         botaoSalvar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (campoUsuario.getText().trim().equalsIgnoreCase("")
                        ||ojComboBox.getSelectedIndex() == 0
                        ||campoCPF.getText().trim().equalsIgnoreCase("")
                        ||campoEndereco.getText().trim().equalsIgnoreCase("")
                        ||campoData.getText().trim().equalsIgnoreCase("")){
                         

                    JOptionPane.showMessageDialog(null, "Preencha todos os dados!");

                    return;

                }

                PUsuario usu = new PUsuario();
                String inclusao = usu.incluirUsuario(campoUsuario.getText(), ojComboBox.getSelectedItem().toString(), campoCPF.getText(), campoEndereco.getText(),  campoData.getText());
                                                    

                JOptionPane.showMessageDialog(null, inclusao);

                janela.dispose();
                try {
                    Usuario.montarTelaUsuario();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }
        });
         
         
         // arrumar essa sintaxe para aparecer na tela
         /*
         tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                oJTextFieldCPF.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
                oJTextFieldNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                oJTextFieldDataNasc.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
                if (tabela.getValueAt(tabela.getSelectedRow(), 3).toString().trim().equalsIgnoreCase("Masculino")) {
                    oJComboBox.setSelectedIndex(1);
                } else {
                    oJComboBox.setSelectedIndex(2);
                }

                oJButtonAlterar.setEnabled(true);
                oJButtonExcluir.setEnabled(true);

                oJButtonExcluir.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        PPessoa oPPessoa = new PPessoa();

                        try {
                            if (!oJTextFieldCPF.getText().equalsIgnoreCase("") && oJTextFieldCPF.getText() != null) {
                                String exclusao = oPPessoa.excluirPessoa(oJTextFieldCPF.getText());
                                JOptionPane.showMessageDialog(null, exclusao);
                                oJFrame.dispose();
                                Tela.montarTela();

                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma pessoa!");
                                
                            }

                        } catch (SQLException | IOException e1) {
                            System.out.println(e1.getMessage());
                        }

                    }
                });

        
        */
        
        
        
        
        
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
