/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author joaov
 */
public class Batalha {    
    private static String[][] matrizEspecie = new String[151][8];
    private static String[][] matrizAtaque = new String[165][7];
    private static Jogador jogador1;
    private static Jogador jogador2;  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        matrizEspecie = carregaEspecies();
        matrizAtaque  = carregaAtaques();
        inicializarJogador(jogador1,1);
        inicializarJogador(jogador2,2);

    }
    
    public static String[][] carregaEspecies(){
        String[][] retorno = new String[151][8];
        String nome = "C:\\TabelaEspecies.txt";
        FileReader arq;
        BufferedReader lerArq;
        String linha;
        Integer i = 0;
        
        try{
            arq = new FileReader(nome);            
            lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            linha = lerArq.readLine();
            while (linha != null){                
                retorno[i++] = linha.split("\t");
                linha = lerArq.readLine();
            }
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }
        
        return retorno;
    }
    
    public static String[][] carregaAtaques(){
        String[][] retorno = new String[165][7];
        String nome = "C:\\TabelaAtaques.txt";
        FileReader arq;
        BufferedReader lerArq;
        String linha;
        Integer i = 0;
        
        try{
            arq = new FileReader(nome);            
            lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            linha = lerArq.readLine();
            while (linha != null){                
                retorno[i++] = linha.split("\t");
                linha = lerArq.readLine();
            }
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }
        return retorno;
    }
    
    public static void inicializarJogador(Jogador jogador,int numJogador){
        Object[] opJogador = { "Humano", "Maquina"};
        Object[] opNumPokemon = {1,2,3,4,5,6};
        int escolha = 0;
        int contPkm = 0;
        String[] parametros = new String[6];
        
        escolha = JOptionPane.showOptionDialog(null, "O jogador " + numJogador + " será:", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opJogador, opJogador[0]);
        
        switch (escolha) {
            case 0:
                jogador = new Maquina();
                break;
                
            case 1:
                jogador = new Humano();
                break;
                
            default:
                fechaJogo();
                break;
        }
        
        escolha = 1;
        
        escolha += JOptionPane.showOptionDialog(null, "O jogador terá quantos pokemons?", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opNumPokemon, opNumPokemon[0]);
        if (escolha<1 || escolha>6) fechaJogo();                
        
        do{
            parametros = JOptionPane.showInputDialog("Entre com os parametros do pokemon Nº" + ++contPkm,"3 50 65 66 67 68").split(" ");

            List<Ataque> listaAtaque = new ArrayList();
            
            int i = 2;
            
            while (i<=5){
                String[] linhaMatrizAtaque = matrizAtaque[parseInt(parametros[i])-1];
                
                Ataque ataque = null;                               
                
                if (parseInt(parametros[i])>0){
                    switch (matrizAtaque[parseInt(parametros[i])-1][6]){
                        case "comum":
                            ataque = new Ataque(linhaMatrizAtaque);
                            break;
                            
                        case "modifier":
                            ataque = new AtaqueModifier(linhaMatrizAtaque);
                            break;
                            
                        case "status":
                            ataque = new AtaqueStatus(linhaMatrizAtaque);
                            break;
                            
                        case "multihit":
                            ataque = new AtaqueMultihit(linhaMatrizAtaque);
                            break;
                            
                        case "hp":
                            ataque = new AtaqueHP(linhaMatrizAtaque);
                            break;
                            
                        case "fixo":
                            ataque = new AtaqueFixo(linhaMatrizAtaque);
                            break;
                            
                        case "charge":
                            ataque = new AtaqueCharge(linhaMatrizAtaque);
                            break;
                    }                     
                }                
                listaAtaque.add(ataque);
                i++;
            }
            
            Especie especie = new Especie(matrizEspecie[parseInt(parametros[0])-1]);
            Pokemon pokemon = new Pokemon(especie,parametros[1],listaAtaque);
            
            jogador.addPkmLista(pokemon);
        } while(--escolha >= 1);        
    }
    
    public static void fechaJogo(){
        System.exit(0);       
    }
}