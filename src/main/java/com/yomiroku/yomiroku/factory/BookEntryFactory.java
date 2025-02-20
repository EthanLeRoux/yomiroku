package com.yomiroku.yomiroku.factory;

import com.yomiroku.yomiroku.domain.BookEntry;

import java.time.LocalDate;

public class BookEntryFactory {
    public static BookEntry createBookEntry(String name, int pagesRead, int chaptersRead, int volumesRead, LocalDate entryDate) {
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
