/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingpoo;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author felipe
 */
public class PUsuario {
    
    public ArrayList<EUsuario> consultarPessoaNome(String nome) throws SQLException {
        
        ArrayList<EUsuario> oListaPessoa = new ArrayList();
        
        Connection conn =  Conexao.obterConexaoMySQL();
        
        String SQL = "select * from usuarios where usuarios_nome like ? order by usuarios_nome";
        
        
        try {
            ResultSet rset;
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)){
                pstm.setString(1, "%" + nome.toUpperCase().trim() + "%");
                rset = pstm.executeQuery();
                int i = 0;
                
                while (rset.next()){
                    
                    EUsuario usuario = new EUsuario();
                    usuario.setNome(rset.getString("usuarios_nome"));
                    usuario.setSexo(rset.getString("usuarios_sexo"));
                    usuario.setCpf(rset.getString("usuarios_cpf"));
                    usuario.setEndereco(rset.getString("usuarios_endereco"));
                    usuario.setDataNasc(rset.getString("usuarios_nascimento"));
                    
                    oListaPessoa.add(i++, usuario);
                }
                
            }
            
            rset.close();
            Conexao.fecharConexao();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        return oListaPessoa;
    }
    
    public ArrayList<EUsuario> consultarPessoa() throws SQLException {
        
        ArrayList<EUsuario> oListaPessoa = new ArrayList();
        
        Connection conn = Conexao.obterConexaoMySQL();
        
        String SQL = "Select * from usuarios order by usuarios_nome";
        
        try {
            ResultSet rset;
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)){
                rset = pstm.executeQuery();
                int i = 0;
                while(rset.next()){
                    
                    EUsuario usuario = new EUsuario();
                    
                    usuario.setNome(rset.getString("usuario_nome"));
                    usuario.setSexo(rset.getString("usuarios_sexo"));
                    usuario.setCpf(rset.getString("usuarios_cpf"));
                    usuario.setEndereco(rset.getString("usuarios_endereco"));
                    usuario.setDataNasc(rset.getString("usuarios_nascimento"));
                    
                    oListaPessoa.add(i++, usuario);
                    
                }
            } 
            rset.close();
            Conexao.fecharConexao();
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return oListaPessoa;
    }
    
    public String incluirUsuario(String nome, String sexo, String cpf, String endereco, String DataNasc){
        
        String resultado;
        
        Connection conn = Conexao.obterConexaoMySQL();
        
        try{
            String SQL = "Insert into usuarios values (?,?,?,?,?)";
                try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {                pstm.setString(1, nome.toUpperCase());
                    pstm.setString(2, sexo.toUpperCase());
                    pstm.setString(3, cpf.toUpperCase());
                    pstm.setString(4, endereco.toUpperCase());
                    pstm.setString(5, DataNasc.toUpperCase());
                    pstm.executeUpdate();
                }
                
                resultado = "Inclusao efetuada com sucesso!";
                
        } catch (SQLException e) {
            resultado = "Erro na inclusao: " + e.getMessage();
        }
        
        Conexao.fecharConexao();
        
        return resultado;
    }
    
}
