/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardapio;

/**
 *
 * @author joaov
 */
public enum Bebida {
    COCA("Coca",1.0,1.0),
    SUKITA("Sukita",1.5,0.5),
    FANTAUVA("Fanta uva",2.5,1.5);
    
    
    private final String nome;
    private final double preçoDeCusto;
    private final double preçoDeLucro;
    
    private Bebida(String nome, double preçoDeCusto, double preçoDeLucro){
        this.nome = nome;
        this.preçoDeCusto = preçoDeCusto;
        this.preçoDeLucro = preçoDeLucro;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getPrecoFinal(){
        return preçoDeCusto + preçoDeLucro;
    }
}