package signature;

import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A 46 CB i3
 */
public class SHA {
    
    // attribute
    private int h0;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int[] message;
    
    // constructor
    public SHA() {}
    
    public void setup(String s) {
        // get message length
        long length = s.length()*8;
        
        // add padding bits
        s = s + (char) 128; 
        while(s.length() % 64 != 56) {
            s = s + (char) 0;
        }
        
        // convert to 32-bit int
        message = new int[s.length()/4 + 2];
        for(int i=0; i<message.length-2; i++) {
            message[i] = convert(s.substring(i*4, (i+1)*4));
        }
        message[message.length-2] = (int) (length >> 32);
        message[message.length-1] = (int) length;
        
        h0 = 1732584193;
        h1 = -271733879;
        h2 = -1732584194;
        h3 = 271733878;
        h4 = -1009589776;
    }
    
    public int convert(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        for(int i=0; i<4; i++) {
            result = result + ((int)c[i] << (3-i)*8);
        }
        return result;
    }
    
    public BigInteger process() {
        int[] chunk = new int[80];
        int a, b, c, d, e, f, k, temp;
        
        for(int i=0; i<message.length; i=i+16) {
            
            // initial chunk
            for(int j=0; j<16; j++) {
                chunk[j] = message[i+j];
            }
            
            // extend chunk
            for(int j=16; j<80; j++) {
                chunk[j] = chunk[j-3] ^ chunk[j-8] ^ chunk[j-14] ^ chunk[j-16];
                chunk[j] = Integer.rotateLeft(chunk[j], 1);
            }
            
            // initialize hash value;
            a = h0;
            b = h1;
            c = h2;
            d = h3;
            e = h4;
            
            // main loop
            for(int j=0; j<80; j++) {
                if(0<=j && j<20) {
                    f = (b & c) | (~b & d);
                    k = 1518500249;
                }
                else if(20<=j && j<40) {
                    f = b ^ c ^ d;
                    k = 1859775393;
                }
                else if(40<=j && j<60) {
                    f = (b & c) | (b & d) | (c & d);
                    k = -1894007588;
                }
                else {
                    f = b ^ c ^ d;
                    k = -899497514;
                }
                
                temp = Integer.rotateLeft(a, 5) + f + e + k + chunk[j];
                e = d;
                d = c;
                c = Integer.rotateLeft(b, 30);
                b = a;
                a = temp;
            }
            h0 = h0 + a;
            h1 = h1 + b;
            h2 = h2 + c;
            h3 = h3 + d;
            h4 = h4 + e;
        }
        BigInteger result = new BigInteger("" + h0);
        result = result.shiftLeft(32).add(new BigInteger("" + h1));
        result = result.shiftLeft(32).add(new BigInteger("" + h2));
        result = result.shiftLeft(32).add(new BigInteger("" + h3));
        result = result.shiftLeft(32).add(new BigInteger("" + h4));
        
        return result;
    }
}
