package com.yomiroku.yomiroku.factory;

import com.yomiroku.yomiroku.domain.BookEntry;

import java.awt.print.Book;
import java.time.LocalDate;

public class BookEntryFactory {

    public static BookEntry createBookEntry(String name, int pagesRead) {
        if(name.isEmpty() || pagesRead <= 0){
            return null;
        }
        return new BookEntry.Builder().setName(name).setPagesRead(pagesRead).build();
    }

    public static BookEntry newCreateBookEntry(String name, int pagesRead, int chaptersRead, int volumesRead, LocalDate entryDate) {
        BookEntry book = new BookEntry.Builder().setName(name)
                .setPagesRead(pagesRead)
                .setChaptersRead(chaptersRead)
                .setVolumesRead(volumesRead)
                .setLocalDate(entryDate)
                .build();

        System.out.println(book.toString());
        return book;
    }
}
