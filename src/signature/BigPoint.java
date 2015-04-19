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
public class BigPoint {
    
    // attribute
    private BigInteger x;
    private BigInteger y;
    
    // constructor
    public BigPoint(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }
    
    // getter
    public BigInteger getX() {
        return x;
    }
    public BigInteger getY() {
        return y;
    }
    
    // setter
    public void setX(BigInteger x) {
        this.x = x;
    }
    public void setY(BigInteger y) {
        this.y = y;
    }   
}
