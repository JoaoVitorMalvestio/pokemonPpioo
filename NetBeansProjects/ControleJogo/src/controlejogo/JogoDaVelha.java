/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlejogo;

import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class JogoDaVelha {
    int jogadorDaVez;
    Celula[][] grade = new Celula[3][3];
    
    public JogoDaVelha (int jogadorDaVez){
        this.jogadorDaVez = jogadorDaVez;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grade[i][j] = Celula.VAZIA;
            }            
        }
    }
    
    private boolean gradeCheia(){
        int i, j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(grade[i][j].getValor()==0) return false;
            }            
        }
        return true;
    }
    
    private int verificaLinhas(){
        int i, j, aux = 0;
        
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                aux += grade[i][j].getValor();
            }
            if (aux==3) return 1;
            if (aux==-3) return -1;
            aux = 0;
        }
        return 0;
    }
    
    private int verificaColunas(){
        int i, j, aux = 0;
        
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                aux += grade[j][i].getValor();
            }
            if (aux==3) return 1;
            if (aux==-3) return -1;
            aux = 0;
        }
        return 0;
    }
        
    private int verificaDiagonais(){
        int aux = 0; 
        
        aux = grade[0][0].getValor() + grade[1][1].getValor() + grade[2][2].getValor();
        if (aux==3) return 1;
        if (aux==-3) return -1;
        
        aux = 0;
        aux = grade[0][2].getValor() + grade[1][1].getValor() + grade[2][0].getValor();
        if (aux==3) return 1;
        if (aux==-3) return -1;
        
        return 0;
    }
    
    
    
    private int ganhou(){
        int aux;
        aux = verificaLinhas();
        if (aux!=0) return aux;
        aux = verificaColunas();
        if (aux!=0) return aux;
        aux = verificaDiagonais();
        if (aux!=0) return aux;
        
        return 0;
    }
    
    private void fazerJogada(){
        int linha, coluna;
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Jogador " + jogadorDaVez + " entre com a linha:");
            linha = entrada.nextInt();
            System.out.println("Jogador " + jogadorDaVez + " entre com a coluna:");
            coluna = entrada.nextInt();
        } while (grade[linha][coluna] != Celula.VAZIA);
        
        
        if(jogadorDaVez==1) grade[linha][coluna] = Celula.JOGADOR_1;
        if(jogadorDaVez==2) grade[linha][coluna] = Celula.JOGADOR_2;
    }
    
    public void imprimirGrade(){
        System.out.println(grade[0][0].getMarca() + "|" + grade[0][1].getMarca() + "|" + grade[0][2].getMarca()); 
        System.out.println("-----"); 
        System.out.println(grade[1][0].getMarca() + "|" + grade[1][1].getMarca() + "|" + grade[1][2].getMarca());
        System.out.println("-----"); 
        System.out.println(grade[2][0].getMarca() + "|" + grade[2][1].getMarca() + "|" + grade[2][2].getMarca()); 
    }
    
    public boolean jogar(){
        if(ganhou()!=0) {          
            System.out.println("Jogador " + ganhou() + " ganhou!");
            return false;
        }
        
        fazerJogada();  
        
        imprimirGrade();
        
        if (gradeCheia()) return false;
        
        if (jogadorDaVez==1) jogadorDaVez=2;
        else jogadorDaVez = 1;
        
        return true;
    }
    
    
}
