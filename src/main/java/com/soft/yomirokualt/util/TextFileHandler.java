package com.soft.yomirokualt.util;

import com.soft.yomirokualt.domain.BookEntry;
import com.soft.yomirokualt.domain.VideoEntry;
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
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializedBookEntryFile,true));
            ArrayList<BookEntry> bookEntryArrayList = new ArrayList<BookEntry>();
            bookEntryArrayList.add(bookEntry);
            objectOutputStream.writeObject(bookEntryArrayList);
            objectOutputStream.flush();
            System.out.println("Book entry written to ser file.");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void writeVideoEntryToSerFile(VideoEntry videoEntry) {
        File serializedVideoEntryFile = new File("videos.ser");

        if(!serializedVideoEntryFile.exists()){
            System.out.println("File does not exist. Creating file.");
            try {
                serializedVideoEntryFile.createNewFile();
            } catch (IOException e) {
                Logger.getLogger(BookEntry.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        try{
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializedVideoEntryFile,true));
            ArrayList<VideoEntry> videoEntryArrayList = new ArrayList<VideoEntry>();
            videoEntryArrayList.add(videoEntry);
            objectOutputStream.writeObject(videoEntryArrayList);
            objectOutputStream.flush();
            System.out.println("Video entry written to ser file.");
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
                    bookEntryArrayList = (ArrayList<BookEntry>) obj;

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

    public ArrayList<VideoEntry> readFromVideoEntrySerFile() {
        File serializedVideoEntryFile = new File("videos.ser");
        ArrayList<VideoEntry> videoEntryArrayList = new ArrayList<>();

        List<VideoEntry> bookEntryList = null;
        if (!serializedVideoEntryFile.exists()) {
            System.out.println("File does not exist.");
            return null;
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serializedVideoEntryFile))) {
            boolean controlWhileLoop = true;

            while (controlWhileLoop) {
                try {
                    Object obj = objectInputStream.readObject();
                    if (obj == null) {
                        break;
                    }
                    videoEntryArrayList = (ArrayList<VideoEntry>) obj;

                } catch (EOFException e) {
                    controlWhileLoop = false;
                }
            }
            return videoEntryArrayList;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
