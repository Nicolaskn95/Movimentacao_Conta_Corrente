/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
  
/**
 *
 * @author Alunos
 */
public class Cliente {

    public Cliente() {
    }

    public Cliente(int id_cli, String nome_cli, String ende_cli, String nume_cli, String compl_cli, String bair_cli, String cida_cli, String uf_cli, String cep_cli, String fone_cli, String cpf_cli, String DataNasc_cli, String cnpj_cli) {
        this.id_cli = id_cli;
        this.nome_cli = nome_cli;
        this.ende_cli = ende_cli;
        this.nume_cli = nume_cli;
        this.compl_cli = compl_cli;
        this.bair_cli = bair_cli;
        this.cida_cli = cida_cli;
        this.uf_cli = uf_cli;
        this.cep_cli = cep_cli;
        this.fone_cli = fone_cli;
        this.cpf_cli = cpf_cli;
        this.cnpj_cli = cnpj_cli;
        this.DataNasc_cli = DataNasc_cli;
    }
    
    
    private int id_cli;
    private String nome_cli;
    private String ende_cli;
    private String nume_cli;
    private String compl_cli;
    private String bair_cli;
    private String cida_cli;
    private String uf_cli;
    private String cep_cli;
    private String fone_cli;
    private String cpf_cli;
    private String DataNasc_cli;
    private String cnpj_cli;

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getEnde_cli() {
        return ende_cli;
    }

    public void setEnde_cli(String ende_cli) {
        this.ende_cli = ende_cli;
    }

    public String getNume_cli() {
        return nume_cli;
    }

    public void setNume_cli(String nume_cli) {
        this.nume_cli = nume_cli;
    }

    public String getCompl_cli() {
        return compl_cli;
    }

    public void setCompl_cli(String compl_cli) {
        this.compl_cli = compl_cli;
    }

    public String getBair_cli() {
        return bair_cli;
    }

    public void setBair_cli(String bair_cli) {
        this.bair_cli = bair_cli;
    }

    public String getCida_cli() {
        return cida_cli;
    }

    public void setCida_cli(String cida_cli) {
        this.cida_cli = cida_cli;
    }

    public String getUf_cli() {
        return uf_cli;
    }

    public void setUf_cli(String uf_cli) {
        this.uf_cli = uf_cli;
    }

    public String getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(String cep_cli) {
        this.cep_cli = cep_cli;
    }

    public String getFone_cli() {
        return fone_cli;
    }

    public void setFone_cli(String fone_cli) {
        this.fone_cli = fone_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public void setDataNasc_cli(String DataNasc_cli) {
        this.DataNasc_cli = DataNasc_cli;
    }
    
    public String getDataNasc_cli() {
        return DataNasc_cli;
    }
    
    public String getCnpj_cli() {
        return cnpj_cli;
    }

    public void setCnpj_cli(String cnpj_cli) {
        this.cnpj_cli = cnpj_cli;
    }
    
    public String dadosSQLValues(){

        String dadosCliente;
        dadosCliente = "'"
                + this.getId_cli() + "','"
                + this.getNome_cli() + "','"
                + this.getEnde_cli() + "','"
                + this.getNume_cli() + "','"
                + this.getCompl_cli() + "','"
                + this.getBair_cli() + "','"
                + this.getCida_cli() + "','"
                + this.getUf_cli() + "','"
                + this.getCep_cli() + "','"
                + this.getFone_cli() + "','"
                + this.getCpf_cli() + "','"
                + this.getDataNasc_cli() + "','"
                + this.getCnpj_cli() + "'";
                
        return dadosCliente;

    }    
    
     public String alteraDadosSQLValues(){
 
        String dadosCliente;

        dadosCliente = "ID_CLI = '" + this.getId_cli()

                + "',NOME_CLI = '" + this.getNome_cli()

                + "',ENDE_CLI = '" + this.getEnde_cli() 

                + "',NUME_CLI = '" + this.getNume_cli()

                + "',COMPL_CLI = '" + this.getCompl_cli()

                + "',BAIR_CLI = '" + this.getBair_cli()

                + "',CIDA_CLI = '" + this.getCida_cli()

                + "',UF_CLI = '" + this.getUf_cli() 

                + "',CEP_CLI = '" + this.getCep_cli()
                
                + "',CPF_CLI = '" + this.getCpf_cli()
                
                + "',DATA_NASC = '" + this.getDataNasc_cli()
                
                + "',CNPJ_CLI = '" + this.getCnpj_cli()

                + "',FONE_CLI = '" + this.getFone_cli() + "'";

        return dadosCliente;
 
    }    
    
}


