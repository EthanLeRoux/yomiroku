package com.soft.yomirokualt.factory;

import com.soft.yomirokualt.domain.BookEntry;

import java.time.LocalDate;

public class BookEntryFactory {
    public static BookEntry createBookEntry(String name, int pagesRead, int chaptersRead, int volumesRead, LocalDate entryDate) {
            BookEntry book = new BookEntry.Builder().setName(name)
                    .setPagesRead(pagesRead)
                    .setChaptersRead(chaptersRead)
                    .setVolumesRead(volumesRead)
                    .setLocalDate(entryDate)
                    .build();
            return book;
    }
}
