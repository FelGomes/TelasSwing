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
    
}
