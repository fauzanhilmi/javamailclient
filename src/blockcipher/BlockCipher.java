/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockcipher;

/**
 *
 * @author khaidzir
 */
public class BlockCipher {
    
    private static BlockCipher instance = null;
    
    protected BlockCipher(){
        
    }
    
    public static BlockCipher getInstance(){
        if(instance == null){
            instance = new BlockCipher();
        }
        return instance;
    }
    
    /* Mode ECB */
    public static byte[] electronicCodeBook(byte [] plain, byte[] key) {
        int nBlock = (int)Math.ceil(((double)plain.length)/16);
        byte[] retval = new byte[nBlock*16];
        int offset = 0;
        BlockProcessor bp = new BlockProcessor(key, 16);
        byte[] input = new byte[16];
        while (offset < plain.length) {
            if (offset+15 < plain.length) {
                System.arraycopy(plain, offset, input, 0, 16);
            } else {
                int sisa = (plain.length-offset);
                System.arraycopy(plain, offset, input, 0, sisa);
                for(int i=sisa; i<16; i++)
                    input[i] = 0;
            }
            System.arraycopy(bp.process(input), 0, retval, offset, 16);
            offset += 16;
        }
        return retval;
    }
    public static byte[] decryptECB(byte [] cipher, byte[] key) {
        byte[] retval = new byte[cipher.length];
        int offset = 0;
        BlockProcessor bp = new BlockProcessor(key, 16);
        byte[] input = new byte[16];
        while (offset < cipher.length) {
            System.arraycopy(cipher, offset, input, 0, 16);
            System.arraycopy(bp.inversProcess(input), 0, retval, offset, 16);
            offset += 16;
        }
        return retval;
    }
    
    public static byte[] cipherBlockChaining(byte [] plain, byte[] key) {
        int nBlock = (int)Math.ceil(((double)plain.length)/16);
        byte[] retval = new byte[nBlock*16];
        int offset = 0;
        BlockProcessor bp = new BlockProcessor(key, 16);
        
        /* IV */
        byte [] iv = new byte[16];
        for(int i=0; i<16; i++)
            iv[i] = 0;
        
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] c = new byte[16];
        byte[] p = new byte[16];
        c = iv;
        
        while (offset < plain.length) {
            if (offset+15 < plain.length) {
                System.arraycopy(plain, offset, p, 0, 16);
            } else {
                int sisa = (plain.length-offset);
                System.arraycopy(plain, offset, p, 0, sisa);
                for(int i=sisa; i<16; i++)
                    p[i] = 0;
            }
            for(int i=0; i<16; i++)
                input[i] = (byte)( (p[i] ^ c[i]) & 0xFF );
            output = bp.process(input);
            System.arraycopy(output, 0, retval, offset, 16);
            offset += 16;
            c = output;
        }
        return retval;
    }
    public static byte[] decryptCBC(byte[] cipher, byte[] key) {
        byte[] retval = new byte[cipher.length];
        int offset = 0;
        BlockProcessor bp = new BlockProcessor(key, 16);
        
        /* IV */
        byte [] iv = new byte[16];
        for(int i=0; i<16; i++)
            iv[i] = 0;
        
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] c = new byte[16];
        byte[] p = new byte[16];
        c = iv;
        
        while (offset < cipher.length) {
            System.arraycopy(cipher, offset, input, 0, 16);
            p = bp.inversProcess(input);
            for(int i=0; i<16; i++)
                output[i] = (byte)( (p[i] ^ c[i]) & 0xFF );
            System.arraycopy(output, 0, retval, offset, 16);
            offset += 16;
            System.arraycopy(input, 0, c, 0, 16);
        }
        return retval;
    }
    
    public static byte[] cipherFeedback(byte [] plain, byte[] key){
        int nBlock = (int)Math.ceil(((double)plain.length)/16);
        byte[] retval = new byte[nBlock*16];
        int offset = 0;
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] p = new byte[16];
        byte[] c = new byte[16];
        
        BlockProcessor bp = new BlockProcessor(key, 16);
        //inisialisasi IV
        for(int i=0; i<16; i++){
            c[i] = 0;
        }
        
        while(offset < plain.length){
            if(offset+15 < plain.length){
                System.arraycopy(plain, offset, p, 0, 16);
            }else{
                int sisa = plain.length - offset;
                System.arraycopy(plain, offset, p, 0, sisa);
                for(int i=sisa; i<16; i++){
                    p[i] = 0;
                }
            }
            output = bp.process(c);
            c = xorTwoArray(output, p);
            System.arraycopy(c, 0, retval, offset, 16);            
            offset+=16;
        }
        return retval;
    }
    public static byte[] decryptCFB(byte[] cipher, byte[] key){
        byte[] retval = new byte[cipher.length];
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] p = new byte[16];
        byte[] c = new byte[16];
        int offset = 0;
        
        BlockProcessor bp = new BlockProcessor(key, 16);
        //inisialisasi IV
        for(int i=0; i<16; i++){
            c[i] = 0;
        }
        
        while(offset < cipher.length){
            output = bp.process(c);
            System.arraycopy(cipher, offset, c, 0, 16);
            p = xorTwoArray(c, output);         
            System.arraycopy(p, 0, retval, offset, 16);
            offset+=16;
        }
        return retval;
    }
    
    public static byte[] outputFeedback(byte [] plain, byte[] key){
        int nBlock = (int)Math.ceil(((double)plain.length)/16);
        byte[] retval = new byte[nBlock*16];
        int offset = 0;
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] p = new byte[16];
        byte[] c = new byte[16];
        
        
        BlockProcessor bp = new BlockProcessor(key, 16);
        //inisialisasi IV
        for(int i=0; i<16; i++){
            input[i] = 0;
        }
        
        while(offset < plain.length){
            if(offset+15 < plain.length){
                System.arraycopy(plain, offset, p, 0, 16);
            }else{
                int sisa = plain.length - offset;
                System.arraycopy(plain, offset, p, 0, sisa);
                for(int i=sisa; i<16; i++){
                    p[i] = 0;
                }
            }
            output = bp.process(input);
            input = output;
            c = xorTwoArray(output, p);
            System.arraycopy(c, 0, retval, offset, 16);
            offset+=16;
        }
        return retval;
    }
    public static byte[] decryptOFB(byte[] cipher, byte[] key){
        byte[] retval = new byte[cipher.length];
        byte[] input = new byte[16];
        byte[] output = new byte[16];
        byte[] c = new byte[16];
        byte[] p = new byte[16];
        int offset = 0;
        BlockProcessor bp = new BlockProcessor(key, 16);
        
        //inisialisasi IV
        for(int i=0; i<16; i++){
            input[i] = 0;
        }
        while(offset < cipher.length){
            System.arraycopy(cipher, offset, c, 0, 16);
            output = bp.process(input);
            input = output;
            p = xorTwoArray(output, c);
            System.arraycopy(p, 0, retval, offset, 16);
            offset+=16;
        }
        return retval;
    }
    
    private static byte[] xorTwoArray(byte[] input1, byte[] input2){
        byte[] retval = new byte[input1.length];
        for(int i=0; i<input1.length; i++){
            retval[i] = (byte) ((input1[i] ^ input2[i])&0xFF);
        }
        return retval;
    }
}
