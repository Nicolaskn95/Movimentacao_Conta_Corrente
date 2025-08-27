/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class Usuario {

    public Usuario() {
    }

    public Usuario(String id, String senha, int num_age, int num_cc) {
        this.id = id;
        this.senha = senha;
        this.num_age = num_age;
        this.num_cc = num_cc;
    }
    
    private String id;
    private String senha;
    private int num_age;
    private int num_cc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNum_age() {
        return num_age;
    }

    public void setNum_age(int num_age) {
        this.num_age = num_age;
    }

    public int getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(int num_cc) {
        this.num_cc = num_cc;
    }

    public String dadosSQLValues(){

        String dadosusuario;
        dadosusuario = "'"
                + this.getId() + "','"
                + this.getSenha() + "','"
                + this.getNum_age() + "','"
                + this.getNum_cc() + "'";
        
        return dadosusuario;

    }    

    public String alteraDadosSQLValues(){
 
        String dadosUsuario;

        dadosUsuario = "ID = '" + this.getId()

                + "',SENHA = '" + this.getSenha()

                + "',NUM_AGE = '" + this.getNum_age() 

                + "',NUM_CC = '" + this.getNum_cc() + "'";


        return dadosUsuario;
 
    }    
    
}
