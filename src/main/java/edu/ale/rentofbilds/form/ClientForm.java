package edu.ale.rentofbilds.form;

import java.time.LocalDate;

public class ClientForm {
    private String id = "";
    private String name = "";
    private String gender = "";
    private String adress = "";
    private String phone = "";
    private String dateOfBirthday = "";
    private String description = "";

    public ClientForm() {
    }

    public ClientForm(String name, String gender, String adress, String phone, String dateOfBirthday, String description) {
        this.name = name;
        this.gender = gender;
        this.adress = adress;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.description = description;
    }

    public ClientForm(String id, String name, String gender, String adress, String phone, String dateOfBirthday, String description) {
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

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "clientForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

