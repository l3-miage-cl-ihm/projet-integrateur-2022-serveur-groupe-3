package fr.litopia.cyberchamis.model.entity;

import javax.persistence.*;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue
    @Column(name = "idCom", nullable = false)
    Integer id;

    @Column(name = "comentaire", nullable = false, length = 128)
    String text;

    @ManyToOne(optional = false)
    Chami auteur;

    public Commentaire() {}
    Commentaire(String text, Chami auteur) {
        this.auteur = auteur;
    }
    public void setText(String text) {
        if(text.length() > 128){
            throw new IllegalArgumentException("Commentaire should be less than 128 characters");
        }
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }
}