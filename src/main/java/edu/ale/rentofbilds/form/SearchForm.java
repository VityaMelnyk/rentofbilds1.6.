package edu.ale.rentofbilds.form;

public class SearchForm {
    private String name;

    public SearchForm() {
    }

    public SearchForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "name='" + name + '\'' +
                '}';
    }
}

