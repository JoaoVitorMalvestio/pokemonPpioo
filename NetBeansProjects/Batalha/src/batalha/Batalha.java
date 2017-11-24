/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        //carregaAtaques();
        //carregarTabelas();
        inicializarJogadores();;
        /*String teste = JOptionPane.showInputDialog(null, "oLA");
        System.out.println(teste);*/
    }
    
    public static void carregarTabelas(){         
        String nome = "C:\\TabelaEspecies.txt";
        String[] campos = new String[8];    
        Especie especie = null;
        
        try {
            FileReader arq = new FileReader(nome);            
            BufferedReader lerArq = new BufferedReader(arq);                        
 
            String linha = lerArq.readLine();
            linha = lerArq.readLine(); 
            while (linha != null) {
                System.out.printf("%s\n", linha);
                campos = linha.split("\t");
                matrizEspecie[Integer.parseInt(campos[0])-1] = linha.split("\t");
                /*try {
                    especie = new Especie(Integer.parseInt(campos[0]),
                                          campos[1],
                                          Tipo.valueOf(campos[2]),
                                          Tipo.valueOf(campos[3]),
                                          Double.parseDouble(campos[4]),
                                          Double.parseDouble(campos[5]),
                                          Double.parseDouble(campos[6]),
                                          Double.parseDouble(campos[7]),
                                          Double.parseDouble(campos[8]));
                } catch(IllegalArgumentException e){
                    especie = new Especie(Integer.parseInt(campos[0]),
                                          campos[1],
                                          Tipo.valueOf(campos[2]),
                                          Tipo.valueOf("None"),
                                          Double.parseDouble(campos[4]),
                                          Double.parseDouble(campos[5]),
                                          Double.parseDouble(campos[6]),
                                          Double.parseDouble(campos[7]),
                                          Double.parseDouble(campos[8]));
                }
                listaEspecie.add(especie);*/
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
        
        for(int i = 0;i<listaEspecie.size();i++){            
            System.out.println(listaEspecie.get(i).getNome());
        }
        
        //System.out.println();
    }
    
    public static String carregaAtaques(){
        JFileChooser arqEscolhido = new JFileChooser();        
        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivo TXT", "txt");
        arqEscolhido.addChoosableFileFilter(filtroTxt);
        arqEscolhido.setAcceptAllFileFilterUsed(false);
        
        FileReader arqLido = new FileReader(arqEscolhido.getSelectedFile().getAbsolutePath());
        
        BufferedReader lerArq = new BufferedReader(arqLido);                        
 
            String linha = lerArq.readLine();
            linha = lerArq.readLine(); 
            while (linha != null) {
                System.out.printf("%s\n", linha);
                campos = linha.split("\t");
                matrizEspecie[Integer.parseInt(campos[0])-1] = linha.split("\t");
                /*try {
                    especie = new Especie(Integer.parseInt(campos[0]),
                                          campos[1],
                                          Tipo.valueOf(campos[2]),
                                          Tipo.valueOf(campos[3]),
                                          Double.parseDouble(campos[4]),
                                          Double.parseDouble(campos[5]),
                                          Double.parseDouble(campos[6]),
                                          Double.parseDouble(campos[7]),
                                          Double.parseDouble(campos[8]));
                } catch(IllegalArgumentException e){
                    especie = new Especie(Integer.parseInt(campos[0]),
                                          campos[1],
                                          Tipo.valueOf(campos[2]),
                                          Tipo.valueOf("None"),
                                          Double.parseDouble(campos[4]),
                                          Double.parseDouble(campos[5]),
                                          Double.parseDouble(campos[6]),
                                          Double.parseDouble(campos[7]),
                                          Double.parseDouble(campos[8]));
                }
                listaEspecie.add(especie);*/
                linha = lerArq.readLine();
            }
            arq.close();
        
        if(arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION){
            /*seuTextField.setText(*/ /*);*/
            System.out.println(arquivo.getSelectedFile().getAbsolutePath()); 
        }
        return "";
    }
    
    public static void inicializarJogadores(){       
        Object[] opcJogador = { "Humano", "Maquina" };
        Object auxString;;
        Integer auxInt;
        
        //Criando o time 1
        auxString = JOptionPane.showInputDialog(null,
            "Qual o tipo do Jogador 1?",
            "Pokemon",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcJogador,
            "Humano");
        
        if (auxString=="Humano") jogador1 = new Humano();
        else
        if (auxString=="Maquina") jogador1 = new Maquina();
             
        jogador1.setNome(JOptionPane.showInputDialog("Qual é o nome do Jogador 1?"));
        
        
        //Criando time 2
        auxString = JOptionPane.showInputDialog(null,
            "Qual o tipo do Jogador 2?",
            "Pokemon",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcJogador,
            "Humano");
        
        if (auxString=="Humano") jogador2 = new Humano();
        else
        if (auxString=="Maquina") jogador2 = new Maquina();
             
        jogador2.setNome(JOptionPane.showInputDialog("Qual é o nome do Jogador 2?"));
    }
    
    public static void executarTurno(){
        
    }
}
