/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class Historico {

    public Historico() {
    }

    public Historico(int id_his, String des_his) {
        this.id_his = id_his;
        this.des_his = des_his;
    }
    
    private int id_his;
    private String des_his;

    public int getId_his() {
        return id_his;
    }

    public void setId_his(int id_his) {
        this.id_his = id_his;
    }

    public String getDes_his() {
        return des_his;
    }

    public void setDes_his(String des_his) {
        this.des_his = des_his;
    }
   
    public String dadosSQLValues(){

        String dadosHistorico;
        dadosHistorico = "'"
                + this.getId_his() + "','"
                + this.getDes_his() + "'";
    
    return dadosHistorico;
}
   
 
    public String alteraDadosSQLValues(){
 
        String dadosHistorico;

        dadosHistorico = "ID_HIS = '" + this.getId_his()

                + "',DES_HIS = '" + this.getDes_his() + "'";

                
        return dadosHistorico;
 
    }    

}    
