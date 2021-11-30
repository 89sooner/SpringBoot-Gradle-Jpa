package com.example.demo.model;
import lombok.Data;

@Data
public class SearchVO {
    private String id;
    private String email;
    private int page;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
