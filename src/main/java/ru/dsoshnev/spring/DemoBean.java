package ru.dsoshnev.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DemoBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DemoBean{" +
                "title='" + title + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        title = "testtitle";
    }
}
