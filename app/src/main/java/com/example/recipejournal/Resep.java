package com.example.recipejournal;

import java.io.Serializable;
import java.util.List;

public class Resep implements Serializable {

    private String nama;
    private String gambar;
    private String waktu;
    private List<String> bahan;
    private List<String> resep;

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getGambar(){
        return gambar;
    }

    public void setGambar(String gambar){
        this.gambar = gambar;
    }

    public String getWaktu(){
        return waktu;
    }

    public void setWaktu(String waktu){
        this.waktu = this.waktu;
    }

    public List<String> getBahan(){
        return bahan;
    }

    public void setBahan(List<String> bahan){
        this.bahan = this.bahan;
    }

    public List<String> getResep(){
        return resep;
    }

    public void setResep(List<String> resep){
        this.resep = this.resep;
    }

}
