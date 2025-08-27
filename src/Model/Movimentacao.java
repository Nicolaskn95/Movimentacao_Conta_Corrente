/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class Movimentacao {

    public Movimentacao() {
    }

    public Movimentacao(int num_age, int num_cc, String data_mov, String num_docto, char debito_credito, int id_his, String compl_his, double valor, double saldo) {
        this.num_age = num_age;
        this.num_cc = num_cc;
        this.data_mov = data_mov;
        this.num_docto = num_docto;
        this.debito_credito = debito_credito;
        this.id_his = id_his;
        this.compl_his = compl_his;
        this.valor = valor;
        this.saldo = saldo;
    }
    
    private int num_age;
    private int num_cc;
    private String data_mov;
    private String num_docto;
    private char debito_credito;
    private int id_his;
    private String compl_his;
    private Double valor;
    private Double saldo;

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

    public String getData_mov() {
        return data_mov;
    }

    public void setData_mov(String data_mov) {
        this.data_mov = data_mov;
    }

    public String getNum_docto() {
        return num_docto;
    }

    public void setNum_docto(String num_docto) {
        this.num_docto = num_docto;
    }

    public char getDebito_credito() {
        return debito_credito;
    }

    public void setDebito_credito(char debito_credito) {
        this.debito_credito = debito_credito;
    }

    public int getId_his() {
        return id_his;
    }

    public void setId_his(int id_his) {
        this.id_his = id_his;
    }

    public String getCompl_his() {
        return compl_his;
    }

    public void setCompl_his(String compl_his) {
        this.compl_his = compl_his;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    public String dadosSQLValues(){

        String dadosMovimentacao;
        dadosMovimentacao = "'"
                + this.getNum_age() + "','"
                + this.getNum_cc() + "','"
                + this.getData_mov() + "','"
                + this.getNum_docto() + "','"
                + this.getDebito_credito() + "','"
                + this.getId_his() + "','"
                + this.getCompl_his() + "','"
                + this.getValor() + "','"
                + this.getSaldo() + "'";
    
        return dadosMovimentacao;        
    } 

    public String alteraDadosSQLValues(){
 
        String dadosMovimentacao;

        dadosMovimentacao = "NUM_AGE = '" + this.getNum_age()

                + "',NUM_CC = '" + this.getNum_cc()

                + "',DATA_MOV = '" + this.getData_mov() 

                + "',NUM_DOCTO = '" + this.getNum_docto()

                + "',DEBITO_CREDITO = '" + this.getDebito_credito()

                + "',ID_HIS = '" + this.getId_his()

                + "',COMPL_HIS = '" + this.getCompl_his()

                + "',VALOR = '" + this.getValor() 

                + "',SALDO = '" + this.getSaldo() + "'";

        return dadosMovimentacao;
 
    }    
 

}

