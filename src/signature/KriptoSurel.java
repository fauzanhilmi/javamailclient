/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signature;

import java.math.BigInteger;

/**
 *
 * @author A 46 CB i3
 */
public class KriptoSurel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EC ec = new EC(
                new BigInteger("-3"),
                new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16),
                new BigInteger("6277101735386680763835789423207666416083908700390324961279")
        );
        BigPoint basis = new BigPoint(
                new BigInteger("188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012", 16),
                new BigInteger("07192b95ffc8da78631011ed6b24cdd573f977a11e794811", 16)
        );
        BigInteger privatekey = new BigInteger("7");
        BigPoint publickey = ec.multiply(basis, privatekey);
        ECDSA ecdsa = new ECDSA();
        
        BigPoint signature = ecdsa.generate("menori", privatekey);
        System.out.println(ecdsa.verify("menori", signature, publickey));
        
        BigPoint bp = new BigPoint(BigInteger.ZERO, BigInteger.ZERO);
    }
    
}
