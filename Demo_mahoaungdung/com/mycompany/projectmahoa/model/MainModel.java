/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmahoa.model;

import com.mycompany.projectmahoa.model.ceasar.Ceasar;
import com.mycompany.projectmahoa.model.chuyendichdong.TranspositionCipher;
import com.mycompany.projectmahoa.model.venegere.Vinegere;

public class MainModel {
    //mã hoá Vinegere
    public String EncryptionVinegere(String document, String key){
        Vinegere cipherVinegere = new Vinegere();
        return cipherVinegere.encryption(document, key);
    }
    //giải mã
    public String DecryptionVinegere(String document, String key){
        Vinegere ciphVinegere = new Vinegere();
        return ciphVinegere.Decryption(document, key);
    }
    //mã hoá Transposition
    public String EncryptionTransposition(String document, String key){
        TranspositionCipher cipherTransposition = new TranspositionCipher();
        return cipherTransposition.encryption(document, key);
    }
    // giải mã
    public String DecryptionTransposition(String document, String key){
        TranspositionCipher cipherTransposition = new TranspositionCipher();
        return cipherTransposition.Decryption(document, key);
    }
    // mã hoá ceaser
    public String EncryptionCeaser(String document, int key){
        return Ceasar.MaHoa(document, key);
    }
    // giải mã
    public String DecryptionCeaser(String document, int key){
        return Ceasar.GiaiMa(document, key);
    }
}
