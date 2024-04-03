package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "prix")
    private int prix;

    @Column(name = "type")
    private String type;

    @Column(name = "Description")
    private String description;

    @Column(name = "lieu")
    private String lieu;

    @ElementCollection
    @Column(name = "image")
    private List<String> images;

    // Additional field for image files

    @Column(name = "temps de publier")
    @Temporal(TemporalType.TIMESTAMP) // Use TemporalType.TIMESTAMP for date-time values

    private LocalDateTime tempsPub;

    @Column(name = "typeDeTransaction")
    private String typeDeTransaction;

    public Post(Long id, String title, int prix, String type, String description, String lieu, List<String> images, List<MultipartFile> imageFiles, LocalDateTime tempsPub, String typeDeTransaction, int superficie, int sallesDeBains, int chambres, int user_id) {
        this.id = id;
        this.title = title;
        this.prix = prix;
        this.type = type;
        this.description = description;
        this.lieu = lieu;
        this.images = images;
        this.tempsPub = tempsPub;
        this.typeDeTransaction = typeDeTransaction;
        this.superficie = superficie;
        this.sallesDeBains = sallesDeBains;
        this.chambres = chambres;
        this.user_id = user_id;
    }




    @Column(name = "superficie")
    private int superficie;

    @Column(name = "Salles de bains")
    private int sallesDeBains;

    @Column(name = "Chambres")
    private int chambres;

    @Column(name = "user_id")
    private int user_id;


    public Post() {
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public LocalDateTime getTempsPub() {
        return tempsPub;
    }

    public void setTempsPub(LocalDateTime tempsPub) {
        this.tempsPub = tempsPub;
    }

    public String getTypeDeTransaction() {
        return typeDeTransaction;
    }

    public void setTypeDeTransaction(String typeDeTransaction) {
        this.typeDeTransaction = typeDeTransaction;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getSallesDeBains() {
        return sallesDeBains;
    }

    public void setSallesDeBains(int sallesDeBains) {
        this.sallesDeBains = sallesDeBains;
    }

    public int getChambres() {
        return chambres;
    }

    public void setChambres(int chambres) {
        this.chambres = chambres;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", prix=" + prix +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", lieu='" + lieu + '\'' +
                ", images=" + images +
                ", tempsPub=" + tempsPub +
                ", typeDeTransaction='" + typeDeTransaction + '\'' +
                ", superficie=" + superficie +
                ", sallesDeBains=" + sallesDeBains +
                ", chambres=" + chambres +
                ", user_id=" + user_id +
                '}';
    }

    // Method to update images
    public void updateImages(List<String> newImages) {
        if (newImages != null) {
            this.images.clear();
            this.images.addAll(newImages);
        }
    }
}
