/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class Agencias {
    

    public Agencias() {
    }

    public Agencias(int num_age, String nome_age, String ende_age, String nume_age, String compl_age, String bair_age, String cida_age, String uf_age, String cep_age, String fone_age) {
        this.num_age = num_age;
        this.nome_age = nome_age;
        this.ende_age = ende_age;
        this.nume_age = nume_age;
        this.compl_age = compl_age;
        this.bair_age = bair_age;
        this.cida_age = cida_age;
        this.uf_age = uf_age;
        this.cep_age = cep_age;
        this.fone_age = fone_age;
    };
    
    private int num_age;
    private String nome_age;
    private String ende_age;
    private String nume_age;
    private String compl_age;
    private String bair_age;
    private String cida_age;
    private String uf_age;
    private String cep_age;
    private String fone_age;

    public int getNum_age() {
        return num_age;
    }

    public void setNum_age(int num_age) {
        this.num_age = num_age;
    }

    public String getNome_age() {
        return nome_age;
    }

    public void setNome_age(String nome_age) {
        this.nome_age = nome_age;
    }

    public String getEnde_age() {
        return ende_age;
    }

    public void setEnde_age(String ende_age) {
        this.ende_age = ende_age;
    }

    public String getNume_age() {
        return nume_age;
    }

    public void setNume_age(String nume_age) {
        this.nume_age = nume_age;
    }

    public String getCompl_age() {
        return compl_age;
    }

    public void setCompl_age(String compl_age) {
        this.compl_age = compl_age;
    }

    public String getBair_age() {
        return bair_age;
    }

    public void setBair_age(String bair_age) {
        this.bair_age = bair_age;
    }

    public String getCida_age() {
        return cida_age;
    }

    public void setCida_age(String cida_age) {
        this.cida_age = cida_age;
    }

    public String getUf_age() {
        return uf_age;
    }

    public void setUf_age(String uf_age) {
        this.uf_age = uf_age;
    }

    public String getCep_age() {
        return cep_age;
    }

    public void setCep_age(String cep_age) {
        this.cep_age = cep_age;
    }

    public String getFone_age() {
        return fone_age;
    }

    public void setFone_age(String fone_age) {
        this.fone_age = fone_age;
    }
  
    public String dadosSQLValues(){

        String dadosAgencias;
        dadosAgencias = "'"
                + this.getNum_age() + "','"
                + this.getNome_age() + "','"
                + this.getEnde_age() + "','"
                + this.getNume_age() + "','"
                + this.getCompl_age() + "','"
                + this.getBair_age() + "','"
                + this.getCida_age() + "','"
                + this.getUf_age() + "','"
                + this.getCep_age() + "','"
                + this.getFone_age() + "'";
        return dadosAgencias;

    }    
 
    public String alteraDadosSQLValues(){
 
        String dadosAgencias;

        dadosAgencias = "NUM_AGE = '" + this.getNum_age()

                + "',NOME_AGE = '" + this.getNome_age()

                + "',ENDE_AGE = '" + this.getEnde_age() 

                + "',NUME_AGE = '" + this.getNume_age()

                + "',COMPL_AGE = '" + this.getCompl_age()

                + "',BAIR_AGE = '" + this.getBair_age()

                + "',CIDA_AGE = '" + this.getCida_age()

                + "',UF_AGE = '" + this.getUf_age() 

                + "',CEP_AGE = '" + this.getCep_age()

                + "',FONE_AGE = '" + this.getFone_age() + "'";

        return dadosAgencias;
 
    }    
 
    
    }
