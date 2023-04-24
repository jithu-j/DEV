package com.perproj.learnspringboot;

public class Course {
    private long id;
    private String Name;
    private String author;

    public Course(long id, String name, String author) {
        this.id = id;
        Name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
