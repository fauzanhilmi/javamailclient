/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signature;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author A 46 CB i3
 */
public class ECDSA {
    
    // attribute
    private final EC ec;
    private final SHA sha;
    private final BigInteger n;
    private final BigPoint basis;
    
    // constructor
    public ECDSA() {
        ec = new EC(
                new BigInteger("-3"),
                new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16),
                new BigInteger("6277101735386680763835789423207666416083908700390324961279")
        );
        sha = new SHA();
        n = new BigInteger("6277101735386680763835789423176059013767194773182842284081");
        basis = new BigPoint(
                new BigInteger("188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012", 16),
                new BigInteger("07192b95ffc8da78631011ed6b24cdd573f977a11e794811", 16)
        );
    }
    
    // function
    public BigPoint generate(String plaintext, BigInteger privatekey) {
        
        // step 1
        sha.setup(plaintext);
        BigInteger e = sha.process();
        
        // step 2
        Random rand = new Random();
        BigInteger k = new BigInteger("" + rand.nextInt()).mod(n);
        
        // step 3
        BigPoint temp = ec.multiply(basis, k);
        BigInteger r = temp.getX().mod(n);
        
        // step 4
        BigInteger s = k.modInverse(n);
        s = s.multiply(e.add(privatekey.multiply(r)));
        s = s.mod(n);
        
        return new BigPoint(r, s);
    }
    
    public boolean verify(String plaintext, BigPoint signature, BigPoint publickey) {
        BigInteger r = signature.getX();
        BigInteger s = signature.getY();
        
        // step 1
        if(r.compareTo(BigInteger.ZERO) == 1 && r.compareTo(n) == -1 && s.compareTo(BigInteger.ZERO) == 1 && s.compareTo(n) == -1) {
            
            // step 2
            sha.setup(plaintext);
            BigInteger e = sha.process();
            
            // step 3
            BigInteger w = s.modInverse(n);
            
            // step 4
            BigInteger u1 = e.multiply(w).mod(n);
            BigInteger u2 = r.multiply(w).mod(n);
            
            // step 5
            BigPoint p1 = ec.add(ec.multiply(basis, u1), ec.multiply(publickey, u2));
            BigPoint p2 = ec.multiply(basis, u1);
            BigPoint p3 = ec.multiply(publickey, u2);
            
            return r.equals(p1.getX().mod(n));
        }
        else {
            return false;
        }
    }
}
