/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signature;

/**
 *
 * @author A 46 CB i3
 */
public class KriptoSurel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KeyGenerator key = new KeyGenerator();
        key.generate();
        
        ECDSA ecdsa = new ECDSA();
        
        BigPoint signature = ecdsa.generate("menori", key.privatekey);
        System.out.println(ecdsa.verify("menori", signature, key.publickey));
    }
    
}
