/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_dao;


import Model.Agencias;
import Model.Cliente;
import Model.ContaCorrente;
import Model.Historico;
import Model.Movimentacao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class ConnectDAO {
    Connection con;
    public Connection connectDB(){
        JOptionPane.showMessageDialog(null, "Inicia a classe para"+"conexão com SQL SERVER!");
        
        String caminho = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=MOV_CONTA_CORRENTE;"
                + "encrypt=true;trustServerCertificate=true;";

        String usuario = "sa";
        String senha = "MinhaSenha_forte123";
             
  


        try {
        con = DriverManager.getConnection(caminho, usuario, senha);
        JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
        } return con;


    }

    public void Fechar(){
        try {
        con.close();
        JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
        JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
        } 

    }

    public void insereRegistroJFBD (String tabela, String strDado){
        con = connectDB();
        Statement stmt;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO dbo."+tabela+" "+ "VALUES ("+ strDado+")";
            JOptionPane.showMessageDialog(null, "String de Insert: "+sql);

            try{
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Inclusão executada com sucesso!");
            } catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        }catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alteraRegistroJFBD(String tabela, String strDados, String pesquisaId){
    
        con = connectDB();
        
        Statement stmt;
        
        try  {
            stmt = con.createStatement();
            String sql = "UPDATE dbo." + tabela
           + " SET " + strDados
           + " WHERE (" + pesquisaId + ");";
            JOptionPane.showMessageDialog(null, "String de Update: "+sql);
        
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        }catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void excluiRegistroJFBD(String tabela, String pesquisaId){
    
        con = connectDB();
        
        Statement stmt;
        
        try  {
            stmt = con.createStatement();
            String sql = "DELETE dbo." +tabela
                   + " WHERE ("+pesquisaId+");";
            JOptionPane.showMessageDialog(null, "String de Delete: "+sql);
        
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        }catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Agencias pesquisaAgenciaJFBD(String tabela, String pesquisaID){
        Agencias agenciasReturn = new Agencias();
        String tabelaSGBD = "AGENCIAS";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " +pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   agenciasReturn.setNum_age(dados.getInt(1));
                   agenciasReturn.setNome_age(dados.getString(2));
                   agenciasReturn.setNume_age(dados.getString(4));
                   agenciasReturn.setEnde_age(dados.getString(3));
                   agenciasReturn.setCompl_age(dados.getString(5));
                   agenciasReturn.setBair_age(dados.getString(6));
                   agenciasReturn.setCida_age(dados.getString(7));
                   agenciasReturn.setUf_age(dados.getString(8));
                   agenciasReturn.setCep_age(dados.getString(9));
                   agenciasReturn.setFone_age(dados.getString(10));
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return agenciasReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return agenciasReturn;
    }

    public Cliente pesquisaClienteJFBD(String tabela, String pesquisaID){
        Cliente clienteReturn = new Cliente();
        String tabelaSGBD = "CLIENTES";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " +pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   clienteReturn.setId_cli(dados.getInt(1));
                   clienteReturn.setNome_cli(dados.getString(2));
                   clienteReturn.setEnde_cli(dados.getString(3));
                   clienteReturn.setNume_cli(dados.getString(4));
                   clienteReturn.setCompl_cli(dados.getString(5));
                   clienteReturn.setBair_cli(dados.getString(6));
                   clienteReturn.setCida_cli(dados.getString(7));
                   clienteReturn.setUf_cli(dados.getString(8));
                   clienteReturn.setCep_cli(dados.getString(9));
                   clienteReturn.setFone_cli(dados.getString(10));
                   clienteReturn.setCpf_cli(dados.getString(11));
                   clienteReturn.setDataNasc_cli(dados.getString(12));
                   clienteReturn.setCnpj_cli(dados.getString(13));
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return clienteReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return clienteReturn;
    }

    public ContaCorrente pesquisaContaCorrenteJFBD(String tabela, String pesquisaID){
        ContaCorrente contacorrenteReturn = new ContaCorrente();
        String tabelaSGBD = "CONTACORRENTE";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " +pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   contacorrenteReturn.setNum_agencia(dados.getInt(1));
                   contacorrenteReturn.setNum_cc(dados.getInt(2));
                   contacorrenteReturn.setId_cli(dados.getInt(3));                                   
                   contacorrenteReturn.setSaldo(dados.getDouble(4));
                   
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return contacorrenteReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return contacorrenteReturn;
    }
    
    public Historico pesquisaHistoricoJFBD(String tabela, String pesquisaID){
        Historico historicoReturn = new Historico();
        String tabelaSGBD = "HISTORICOS";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " +pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   historicoReturn.setId_his(dados.getInt(1));
                   historicoReturn.setDes_his(dados.getString(2));
                   
                   
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return historicoReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return historicoReturn;
    }

    public Usuario pesquisaUsuarioJFBD(String tabela, String pesquisaID){
        Usuario usuarioReturn = new Usuario();
        String tabelaSGBD = "USUARIOS";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " + pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   usuarioReturn.setId(dados.getString(1));
                   usuarioReturn.setSenha(dados.getString(2));
                   usuarioReturn.setNum_age(dados.getInt(3));
                   usuarioReturn.setNum_cc(dados.getInt(4));
                   
                   
                   
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return usuarioReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return usuarioReturn;
    }
    
     public Movimentacao pesquisaMovimentacaoJFBD(String tabela, String pesquisaID){
        Movimentacao movimentacaoReturn = new Movimentacao();
        String tabelaSGBD = "MOVIMENTACAO";
        if (tabela.equals(tabelaSGBD)){
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM "+tabela +" WHERE " + pesquisaID;
            try {
               ResultSet dados;
               dados = stmt.executeQuery(sql);
               if (dados.next() == false){
                   JOptionPane.showMessageDialog(null,"Nenhum registro foi encontrado para esta pesquisa!");
               }
               else
               {    
                   movimentacaoReturn.setNum_age(dados.getInt(1));
                   movimentacaoReturn.setNum_cc(dados.getInt(2));
                   movimentacaoReturn.setData_mov(dados.getString(3));
                   movimentacaoReturn.setNum_docto(dados.getString(4));
                   movimentacaoReturn.setDebito_credito(dados.getString(5).charAt(0));
                   movimentacaoReturn.setId_his(dados.getInt(6));
                   movimentacaoReturn.setCompl_his(dados.getString(7));
                   movimentacaoReturn.setValor(dados.getDouble(8));
                   movimentacaoReturn.setSaldo(dados.getDouble(9));
                   
                   
                   
               }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de Conexão," + "connectDAO - Código => "+erro.getErrorCode());
            }           
            con.close();
            return movimentacaoReturn;
        }catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return movimentacaoReturn;
    }

    public ResultSet consultaRegistroAgenciasRSBD(String tabela) {  // throws SQLException{
        // JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");
        con = connectDB();
 
        Statement stmt;
        try {
            
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro
            String sql = "SELECT * FROM "+tabela;
 
             try {
                // Executar a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso!");
 
                // con.close();
                return dados;  // lista;
 
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            //con.close();
 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }  
}



