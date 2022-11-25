/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import domain.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class HDC {
    private static  int i =1;
    private String id;
    private String nvName;
    private String khName;
    private Date tgianTao;
    public Object[] toRow(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        return new Object[]{
           id , dateFormat.format(tgianTao),nvName,khName
        };
    }

    public HDC() {
        id = "HD"+i;
        i++;
    }

    public HDC( Date tgianTao,String nvName, String khName ) {
        id = "HD"+i;
        i++;
        this.nvName = nvName;
        this.khName = khName;
        this.tgianTao = tgianTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNvName() {
        return nvName;
    }

    public void setNvName(String nvName) {
        this.nvName = nvName;
    }

    public String getCus() {
        return khName;
    }

    public void setCus(String khName) {
        this.khName = khName;
    }

    public Date getTgianTao() {
        return tgianTao;
    }

    public void setTgianTao(Date tgianTao) {
        this.tgianTao = tgianTao;
    }
    
}
