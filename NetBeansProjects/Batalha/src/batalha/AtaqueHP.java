/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Double.parseDouble;

/**
 *
 * @author joaov
 */
public class AtaqueHP extends Ataque{
    private int valor;
    private double porcentagem;

    public AtaqueHP(String[] parametros){
        super(parametros);
        
        this.valor = 0;
        this.porcentagem = parseDouble(parametros[7].split(",")[1].trim());
    }
    
    @Override
    public void efeito(){
        
    }
}
