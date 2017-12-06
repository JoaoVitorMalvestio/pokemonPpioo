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
        inicializarJogadores();
        /*String teste = JOptionPane.showInputDialog(null, "oLA");
        System.out.println(teste);*/
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
    
    public static void inicializarJogadores(){
        Object[] opJogador = { "Humano", "Maquina"};
        Object[] opNumPokemon = {1,2,3,4,5,6};
        int escolha = 0;
        String[] parametros = new String[6];
        
        escolha = JOptionPane.showOptionDialog(null, "O jogador 1 será:", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opJogador, opJogador[0]);
        if (escolha==0) jogador1 = new Maquina();
        else 
        if (escolha==1) jogador1 = new Humano();
        else fechaJogo();
        
        escolha = 1;
        
        escolha += JOptionPane.showOptionDialog(null, "O jogador 1 terá quantos pokemons?", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opNumPokemon, opNumPokemon[0]);
        if (escolha<1 || escolha>6) fechaJogo();
        
        do{
            int i = 0;
            parametros = JOptionPane.showInputDialog("Entre com os parametros do pokemon numero " + escolha).split(","); 
            Especie especie = new Especie(matrizEspecie[parseInt(parametros[0])-1]);
            Pokemon pokemon = new Pokemon(especie,parametros[1]);
            
            i = 2;
            
            while (i<5){
                Ataque ataque = null;
                
                if (parametros[0]!="0"){
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="comum") ataque = new Ataque(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="modifier") ataque = new AtaqueModifier(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="status") ataque = new AtaqueStatus(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="multihit") ataque = new AtaqueMultihit(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="hp") ataque = new AtaqueHP(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="fixo") ataque = new AtaqueFixo(matrizAtaque[parseInt(parametros[0])-1]);
                    else 
                    if (matrizAtaque[parseInt(parametros[0])-1][6]=="charge") ataque = new AtaqueCharge(matrizAtaque[parseInt(parametros[0])-1]);
                }               
                pokemon.addAtaqueLista(ataque);             
            }
            
            jogador1.addPkmLista(pokemon);
            --escolha;
        } while(escolha >= 1);
        
        
        
        
        
            
        
        
        
        
        
        
        
        
        
        
        
        /*Scanner ler = new Scanner(System.in);
        String[] paramJogador = new String[26];

        System.out.printf("Informe os parametros de inicialização do jogador 1,\n");
        System.out.printf("os paramentros deve ser informados separados por virgula,\n");
        System.out.printf("(0-1 Humano/Maquina),(1-151 Pokemon 1),(1-100 Level),(1-165 Ataque 1),(1-165 Ataque 2),(1-165 Ataque 3),(1-165 Ataque 4)\n");
        
        paramJogador = ler.nextLine().split(",");
        
        if (parseInt(paramJogador[0]) > 1 && parseInt(paramJogador[0]) < 0){
            
            
        }*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    private static boolean parseBoolean(int escolha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void fechaJogo(){
        System.exit(0);       
    }
}
//   
//    /*
//    public static void carregarTabelas(){         
//        String nome = "C:\\TabelaEspecies.txt";
//        String[] campos = new String[8];    
//        Especie especie = null;
//        
//        try {
//            FileReader arq = new FileReader(nome);            
//            BufferedReader lerArq = new BufferedReader(arq);                        
// 
//            String linha = lerArq.readLine();
//            linha = lerArq.readLine(); 
//            while (linha != null) {
//                System.out.printf("%s\n", linha);
//                campos = linha.split("\t");
//                matrizEspecie[Integer.parseInt(campos[0])-1] = linha.split("\t");
//                /*try {
//                    especie = new Especie(Integer.parseInt(campos[0]),
//                                          campos[1],
//                                          Tipo.valueOf(campos[2]),
//                                          Tipo.valueOf(campos[3]),
//                                          Double.parseDouble(campos[4]),
//                                          Double.parseDouble(campos[5]),
//                                          Double.parseDouble(campos[6]),
//                                          Double.parseDouble(campos[7]),
//                                          Double.parseDouble(campos[8]));
//                } catch(IllegalArgumentException e){
//                    especie = new Especie(Integer.parseInt(campos[0]),
//                                          campos[1],
//                                          Tipo.valueOf(campos[2]),
//                                          Tipo.valueOf("None"),
//                                          Double.parseDouble(campos[4]),
//                                          Double.parseDouble(campos[5]),
//                                          Double.parseDouble(campos[6]),
//                                          Double.parseDouble(campos[7]),
//                                          Double.parseDouble(campos[8]));
//                }
//                listaEspecie.add(especie);*/
//                linha = lerArq.readLine();
//            }
//            arq.close();
//        } catch (IOException e) {
//            System.err.printf("Erro na abertura do arquivo: %s.\n",
//            e.getMessage());
//        }
//        
//        for(int i = 0;i<listaEspecie.size();i++){            
//            System.out.println(listaEspecie.get(i).getNome());
//        }
//        
//        //System.out.println();
//    }
//    
//    public static String carregaAtaques(){
//        String nomeTxt;
//        JFileChooser arqEscolhido = new JFileChooser();        
//        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivo TXT", "txt");
//        arqEscolhido.addChoosableFileFilter(filtroTxt);
//        arqEscolhido.setAcceptAllFileFilterUsed(false);
//        
//        if(arqEscolhido.showOpenDialog(arqEscolhido) == JFileChooser.APPROVE_OPTION){
//            nomeTxt = arqEscolhido.getSelectedFile().getAbsolutePath();
//        }
//        
//        nomeTxt = arqEscolhido.getSelectedFile().getAbsolutePath();
//
//        
//        System.out.println(arqEscolhido.getSelectedFile().getPath());
//        System.out.println(arqEscolhido.getSelectedFile().getAbsolutePath());
//        System.out.println(arqEscolhido.getSelectedFile().getCanonicalPath());
//       
//        
//        System.exit(0);
//        
//        
//        FileReader arqLido = new FileReader(nomeTxt);
//
//        BufferedReader lerArq = new BufferedReader(arqLido);                        
// 
//            String linha = lerArq.readLine();
//            linha = lerArq.readLine(); 
//            while (linha != null) {
//                System.out.printf("%s\n", linha);
//                campos = linha.split("\t");
//                matrizEspecie[Integer.parseInt(campos[0])-1] = linha.split("\t");
//                /*try {
//                    especie = new Especie(Integer.parseInt(campos[0]),
//                                          campos[1],
//                                          Tipo.valueOf(campos[2]),
//                                          Tipo.valueOf(campos[3]),
//                                          Double.parseDouble(campos[4]),
//                                          Double.parseDouble(campos[5]),
//                                          Double.parseDouble(campos[6]),
//                                          Double.parseDouble(campos[7]),
//                                          Double.parseDouble(campos[8]));
//                } catch(IllegalArgumentException e){
//                    especie = new Especie(Integer.parseInt(campos[0]),
//                                          campos[1],
//                                          Tipo.valueOf(campos[2]),
//                                          Tipo.valueOf("None"),
//                                          Double.parseDouble(campos[4]),
//                                          Double.parseDouble(campos[5]),
//                                          Double.parseDouble(campos[6]),
//                                          Double.parseDouble(campos[7]),
//                                          Double.parseDouble(campos[8]));
//                }
//                listaEspecie.add(especie);*/
//                linha = lerArq.readLine();
//            }
//            arq.close();
//        
//        if(arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION){
//            /*seuTextField.setText(*/ /*);*/
//            System.out.println(arquivo.getSelectedFile().getAbsolutePath()); 
//        }
//        return "";
//    }
//    */
//
//    public static void inicializarJogadores(){       
//        Object[] opcJogador = { "Humano", "Maquina" };
//        Object auxString;;
//        Integer auxInt;
//        
//        //Criando o time 1
//        auxString = JOptionPane.showInputDialog(null,
//            "Qual o tipo do Jogador 1?",
//            "Pokemon",
//            JOptionPane.PLAIN_MESSAGE,
//            null,
//            opcJogador,
//            "Humano");
//        
//        if (auxString=="Humano") jogador1 = new Humano();
//        else
//        if (auxString=="Maquina") jogador1 = new Maquina();
//             
//        jogador1.setNome(JOptionPane.showInputDialog("Qual é o nome do Jogador 1?"));
//        
//        
//        //Criando time 2
//        auxString = JOptionPane.showInputDialog(null,
//            "Qual o tipo do Jogador 2?",
//            "Pokemon",
//            JOptionPane.PLAIN_MESSAGE,
//            null,
//            opcJogador,
//            "Humano");
//        
//        if (auxString=="Humano") jogador2 = new Humano();
//        else
//        if (auxString=="Maquina") jogador2 = new Maquina();
//             
//        jogador2.setNome(JOptionPane.showInputDialog("Qual é o nome do Jogador 2?"));
//    }
//    
//    public static void executarTurno(){
//        
//    }