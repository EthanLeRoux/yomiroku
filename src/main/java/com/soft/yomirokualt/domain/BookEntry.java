package com.soft.yomirokualt.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class BookEntry implements Serializable {
    private String name;
    private int pagesRead;
    private int chaptersRead;
    private int volumesRead;
    private LocalDate entryDate;

    public BookEntry(){

    }
    public String getName() {
        return name;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public int getChaptersRead() {
        return chaptersRead;
    }

    public int getVolumesRead() {
        return volumesRead;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    private BookEntry(Builder builder){
        this.name = builder.name;
        this.pagesRead = builder.pagesRead;
        this.chaptersRead = builder.chaptersRead;
        this.volumesRead = builder.volumesRead;
        this.entryDate = builder.entryDate;
    }

    @Override
    public String toString() {
        return "BookEntry{" +
                "name='" + name + '\'' +
                ", pagesRead=" + pagesRead +
                ", chaptersRead=" + chaptersRead +
                ", volumesRead=" + volumesRead +
                ", entryDate=" + entryDate +
                '}';
    }

    public static class Builder{
        private String name;
        private int pagesRead;
        private int chaptersRead;
        private int volumesRead;
        private LocalDate entryDate;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setPagesRead(int pagesRead){
            this.pagesRead = pagesRead;
            return this;
        }

        public Builder setChaptersRead(int chaptersRead){
            this.chaptersRead = chaptersRead;
            return this;
        }

        public Builder setVolumesRead(int volumesRead){
            this.volumesRead = volumesRead;
            return this;
        }

        public Builder setLocalDate(LocalDate entryDate){
            this.entryDate = entryDate;
            return this;
        }

        public BookEntry build(){
            return new BookEntry(this);
        }
    }

}
