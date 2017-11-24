/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardapio;

import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class Cardapio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double total = 0;
        int opcao = 0;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();            
            total += preco(opcao);
            
            System.out.println("Opção escolhida: " + opcao);
            System.out.println("Valor de sua conta: " + total + "\n");
        } while(opcao!=0);             
    }
    
    public static void menu(){
        int cont = 0;
        
        System.out.println("\tBebidas");
        
        for(Bebida b : Bebida.values()){
            cont++;
            System.out.println(cont + ". " + b.getNome() + ": \t R$" + b.getPrecoFinal());
        }
        
        System.out.println("\tComidas");
        
        for(Comida c : Comida.values()){
            cont++;
            System.out.println(cont + ". " + c.getNome() + ": \t R$" + c.getPrecoFinal());
        }
        
        System.out.println("0. Sair");
        System.out.println("Escolha sua opção:");
    }
    
    public static double preco(int opcao){
        switch(opcao){
            case 1:
                return Bebida.COCA.getPrecoFinal();
            case 2:
                return Bebida.SUKITA.getPrecoFinal();
            case 3:
                return Bebida.FANTAUVA.getPrecoFinal();
            case 4:
                return Comida.BOLOVO.getPrecoFinal();
            case 5:
                return Comida.FRANGO.getPrecoFinal();
            case 6:
                return Comida.ARROZ.getPrecoFinal();
            default:
                return 0.0;
        }
    }
}
