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
public class EC {
    
    // attribute
    private final BigInteger a;
    private final BigInteger b;
    private final BigInteger p;
    
    // constructor
    public EC(BigInteger a, BigInteger b, BigInteger p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }
    
    // getter
    public BigInteger getP() {
        return p;
    }
    
    
    // function
    public BigPoint add(BigPoint p1, BigPoint p2) {
        BigInteger x, y;
        
        if(!p1.getX().equals(p2.getX())) {
        
            // count gradien
            BigInteger gradien = (p1.getY().subtract(p2.getY()));
            gradien = gradien.multiply(p1.getX().subtract(p2.getX()).modInverse(p));
            gradien = gradien.mod(p);
        
            x = gradien.multiply(gradien).subtract(p1.getX()).subtract(p2.getX()).mod(p);
            y = gradien.multiply(p1.getX().subtract(x)).subtract(p1.getY()).mod(p);
        }
        else {
            x = BigInteger.ZERO;
            y = BigInteger.ZERO;
        }
        
        return new BigPoint(x, y);
    }
    
    public BigPoint subtract(BigPoint p1, BigPoint p2) {
        BigPoint temp = new BigPoint(p2.getX(), p2.getY().negate());
        
        return add(p1, temp);
    }
    
    public BigPoint doublePoint(BigPoint p1) {
        BigInteger x, y;
        
        if(!p1.getY().equals(BigInteger.ZERO)) {
            
            // count gradien
            BigInteger gradien = new BigInteger("3").multiply(p1.getX()).multiply(p1.getX()).add(a);
            gradien = gradien.multiply(new BigInteger("2").multiply(p1.getY()).modInverse(p));
            gradien = gradien.mod(p);
            
            x = gradien.multiply(gradien).subtract(new BigInteger("2").multiply(p1.getX())).mod(p);
            y = gradien.multiply(p1.getX().subtract(x)).subtract(p1.getY()).mod(p);
            
            return new BigPoint(x, y);
        }
        else {
            return new BigPoint(BigInteger.ZERO, BigInteger.ZERO);
        }
    }
    
    public BigPoint multiply(BigPoint p1, BigInteger n) {
        if(n.equals(BigInteger.ONE)) {
            return p1;
        }
        else if(n.equals(new BigInteger("2"))) {
            return doublePoint(p1);
        }
        else {
            if(n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                return doublePoint(multiply(p1, n.divide(new BigInteger("2"))));
            }
            else {
                return add(p1, doublePoint(multiply(p1, n.subtract(BigInteger.ONE).divide(new BigInteger("2")))));
            }
        }
    }
}
