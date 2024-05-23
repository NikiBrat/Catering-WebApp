/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author nikol
 */
public class Poruke 
{
    private String poruka;
    private String tip;
    private String link;
    private String link2;
    private String ispisDugme;
    private String ispisDugme2;
    private int brDugmica=1;

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIspisDugme() {
        return ispisDugme;
    }

    public void setIspisDugme(String ispisDugme) {
        this.ispisDugme = ispisDugme;
    }

    public int getBrDugmica() {
        return brDugmica;
    }

    public void setBrDugmica(int brDugmica) {
        this.brDugmica = brDugmica;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getIspisDugme2() {
        return ispisDugme2;
    }

    public void setIspisDugme2(String ispisDugme2) {
        this.ispisDugme2 = ispisDugme2;
    }
}
