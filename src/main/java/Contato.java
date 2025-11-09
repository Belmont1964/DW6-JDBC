/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author belmo
 */
public class Contato {
    private int id;
    private String nome;
    private String tel;
    
    public Contato (String nome, String tel, int id){
        this.nome = nome;
        this.tel = tel;
        this.id = id;
    }
    
    public String getNome (){
        return nome;
    }
    public String getTel (){
        return tel;
    }
    public int getId (){
        return id;
    }
            
}
