package edu.ale.rentofbilds.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Client {
    @Id
    private String id;
    private String name;
    private String gender;
    private String adress;
    private String phone;
    private LocalDate dateOfBirthday;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Client() {
    }


    public Client(String name, String gender, String adress, String phone, LocalDate dateOfBirthday, String description) {
        this.name = name;
        this.gender = gender;
        this.adress = adress;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.description = description;
    }

    public Client(String id, String name, String gender, String adress, String phone, LocalDate dateOfBirthday, String description, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.adress = adress;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Client(String id, String name, String gender, String adress, String phone, LocalDate dateOfBirthday, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.adress = adress;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId().equals(client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
