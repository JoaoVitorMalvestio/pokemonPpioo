/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;

/**
 *
 * @author joaov
 */
public class AtaqueFixo extends Ataque{
    private int val;

    public AtaqueFixo(String[] parametros){
        super(parametros);
        
        this.val = parseInt(parametros[7].split(",")[0]);       
    }
    
    @Override
    public void efeito(){
        
    }
}
