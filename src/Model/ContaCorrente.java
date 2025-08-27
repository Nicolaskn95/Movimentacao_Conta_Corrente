/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class ContaCorrente {

    public ContaCorrente() {
    }

    public ContaCorrente(int num_agencia, int num_cc, int id_cli, double saldo) {
        this.num_agencia = num_agencia;
        this.num_cc = num_cc;
        this.id_cli = id_cli;
        this.saldo = saldo;
    }
    
    private int num_agencia;
    private int num_cc;
    private int id_cli;
    private double saldo;

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_age) {
        this.num_agencia = num_age;
    }

    public int getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(int num_cc) {
        this.num_cc = num_cc;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String dadosSQLValues() {
        
        String dadosContaCorrente;
        dadosContaCorrente = "'"
            + this.getNum_agencia() + "','"
            + this.getNum_cc() + "','"
            + this.getId_cli() + "','"
            + this.getSaldo() + "'";
        
        return dadosContaCorrente;        
    }
    
    public String alteraDadosSQLValues(){
 
        String dadosContaCorrente;

        dadosContaCorrente = "NUM_AGE = '" + this.getNum_agencia()

                + "',NUM_CC = '" + this.getNum_cc()

                + "',ID_CLI = '" + this.getId_cli() 

                + "',SALDO = '" + this.getSaldo() + "'";



        return dadosContaCorrente;
 
    }    
    
}
