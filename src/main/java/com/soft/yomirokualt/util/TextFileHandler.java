package com.soft.yomirokualt.util;

import com.soft.yomirokualt.domain.BookEntry;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFileHandler {
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    File bookEntryFile;

    public void writeBookEntryToSerFile(BookEntry bookEntry) {
        File serializedBookEntryFile = new File("books.ser");

        if(!serializedBookEntryFile.exists()){
            System.out.println("File does not exist. Creating file.");
            try {
                serializedBookEntryFile.createNewFile();
            } catch (IOException e) {
                Logger.getLogger(BookEntry.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        try{
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializedBookEntryFile));
            objectOutputStream.writeObject(bookEntry);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Book entry written to ser file.");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<BookEntry> readFromBookEntrySerFile() {
        File serializedBookEntryFile = new File("books.ser");
        ArrayList<BookEntry> bookEntryArrayList = new ArrayList<>();
        List<BookEntry> bookEntryList = null;
        if (!serializedBookEntryFile.exists()) {
            System.out.println("File does not exist.");
            return null;
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serializedBookEntryFile))) {
            boolean controlWhileLoop = true;

            while (controlWhileLoop) {
                try {
                    Object obj = objectInputStream.readObject();
                    if (obj == null) {
                        break;
                    }
                    BookEntry bookEntry = (BookEntry) obj;
                    bookEntryArrayList.add(bookEntry);

                } catch (EOFException e) {
                    controlWhileLoop = false;
                }
            }
            return bookEntryArrayList;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
