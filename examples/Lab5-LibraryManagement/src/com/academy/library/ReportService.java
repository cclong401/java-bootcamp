package com.academy.library;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReportService {

    private final LibraryService libraryService;

    public ReportService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void displaySummaryReport() {
        // compute totalBooks, borrowedBooks, availableBooks, totalMembers
        // findMostPopularCategory(); print Reports block matching solution format
        List<Book> availableBooks = libraryService.getBooks().stream()
                .filter(Book::isAvailable)
                .toList();
        long totalBooks = libraryService.getBooks().size();
        long borrowedBooks = libraryService.getBorrowRecords().size();
        long availableBooksCount = availableBooks.size();
        long totalMembers = libraryService.getMembers().size();

        System.out.printf("Summary Report:%nBooks: %d%nBorrowed: %d%nAvailable: %d%nMembers: %d%nMost Popular Category: %s%n",
                totalBooks, borrowedBooks, availableBooksCount, totalMembers, findMostPopularCategory()
                );
    }

    public Path exportReportToFile(String fileName) throws IOException {
        // Bonus / full-path feature — implement after core borrow/return/summary TODOs.
        File reportFile = new File(fileName);
        FileWriter writer = new FileWriter(reportFile);
        reportFile.createNewFile();
        writer.write("test");
        writer.close();
        return reportFile.toPath();
    }

    private String findMostPopularCategory() {
        // max entry by value from getCategoryBookCount(); orElse "N/A"
        TreeMap<String, Integer> categories = libraryService.getCategoryBookCount();

        String mostPopularCategory = categories.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(Map.entry("N/A", 0))
                .getKey();

        return mostPopularCategory;
    }
}
