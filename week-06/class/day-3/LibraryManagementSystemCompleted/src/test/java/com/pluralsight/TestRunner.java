package com.pluralsight;

import com.pluralsight.model.entities.Book;
import com.pluralsight.model.entities.Magazine;
import com.pluralsight.model.entities.Member;
import com.pluralsight.model.entities.Movie;
import com.pluralsight.model.entities.Item;
import com.pluralsight.service.*;
import com.pluralsight.exceptions.*;

/**
 * Test runner for the Library Management System.
 * Runs a suite of tests to verify the functionality of all components.
 * Includes tests for Book, Movie, Magazine, Member, and Library classes.
 * Provides a summary of test results at the end.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("RUNNING LIBRARY MANAGEMENT SYSTEM TESTS");
        System.out.println("=".repeat(60));

        int totalTests = 0;
        int passedTests = 0;

        // Test Book
        System.out.println("\n--- Testing Book Class ---");
        try {
            testBook();
            System.out.println("✓ Book tests PASSED");
            passedTests++;
        } catch (Exception e) {
            System.out.println("✗ Book tests FAILED: " + e.getMessage());
        }
        totalTests++;

        // Test Movie
        System.out.println("\n--- Testing Movie Class ---");
        try {
            testMovie();
            System.out.println("✓ Movie tests PASSED");
            passedTests++;
        } catch (Exception e) {
            System.out.println("✗ Movie tests FAILED: " + e.getMessage());
        }
        totalTests++;

        // Test Magazine
        System.out.println("\n--- Testing Magazine Class ---");
        try {
            testMagazine();
            System.out.println("✓ Magazine tests PASSED");
            passedTests++;
        } catch (Exception e) {
            System.out.println("✗ Magazine tests FAILED: " + e.getMessage());
        }
        totalTests++;

        // Test Member
        System.out.println("\n--- Testing Member Class ---");
        try {
            testMember();
            System.out.println("✓ Member tests PASSED");
            passedTests++;
        } catch (Exception e) {
            System.out.println("✗ Member tests FAILED: " + e.getMessage());
        }
        totalTests++;

        // Test Library
        System.out.println("\n--- Testing Library Class ---");
        try {
            testLibrary();
            System.out.println("✓ Library tests PASSED");
            passedTests++;
        } catch (Exception e) {
            System.out.println("✗ Library tests FAILED: " + e.getMessage());
            e.printStackTrace();
        }
        totalTests++;

        // Summary
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST SUMMARY: " + passedTests + "/" + totalTests + " tests passed");
        System.out.println("=".repeat(60));

        if (passedTests == totalTests) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
        } else {
            System.out.println("❌ Some tests failed. Please check the output above.");
        }
    }

    private static void testBook() {
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction");
        assert book.getIsbn().equals("1234567890");
        assert book.getTitle().equals("Test Book");
        assert book.getAuthor().equals("Test Author");
        assert book.getType().equals("Book");
        assert book.getBorrowDuration() == 14;
        assert book.isAvailable();
    }

    private static void testMovie() {
        Movie movie = new Movie("MOV001", "Inception", "Christopher Nolan", "Sci-Fi", 148);
        assert movie.getId().equals("MOV001");
        assert movie.getTitle().equals("Inception");
        assert movie.getDirector().equals("Christopher Nolan");
        assert movie.getType().equals("Movie");
        assert movie.getBorrowDuration() == 3;
        assert movie.getDuration() == 148;
        assert movie.isAvailable();
    }

    private static void testMagazine() {
        Magazine magazine = new Magazine("MAG001", "Tech Weekly", "Tech Publications", "Technology", "Issue 42", "2025-05-01");
        assert magazine.getId().equals("MAG001");
        assert magazine.getTitle().equals("Tech Weekly");
        assert magazine.getPublisher().equals("Tech Publications");
        assert magazine.getType().equals("Magazine");
        assert magazine.getBorrowDuration() == 7;
        assert magazine.getIssueNumber().equals("Issue 42");
        assert magazine.isAvailable();
    }

    private static void testMember() {
        Member member = new Member("M1001", "John Doe", "john@test.com");
        assert member.getMemberId().equals("M1001");
        assert member.getName().equals("John Doe");
        assert member.getEmail().equals("john@test.com");
        assert member.getBorrowedCount() == 0;

        // Test borrow and return
        String testItemId = "1234567890";
        assert member.borrowItem(testItemId);
        assert member.getBorrowedCount() == 1;
        assert member.hasBorrowedItem(testItemId);
        
        // Verify borrow date was recorded
        String borrowDate = member.getBorrowDate(testItemId);
        assert borrowDate != null && !borrowDate.isEmpty();

        assert member.returnItem(testItemId);
        assert member.getBorrowedCount() == 0;
        assert !member.hasBorrowedItem(testItemId);
    }

    private static void testLibrary() throws Exception {
        Library library = Library.getInstance();

        // Test adding items
        Book book = new Book("1234567890", "Java Programming", "John Author", "Programming");
        Movie movie = new Movie("MOV001", "Inception", "Christopher Nolan", "Sci-Fi", 148);
        Member member = new Member("M1001", "Alice Johnson", "alice@test.com");

        assert library.addItem(book);
        assert library.addItem(movie);
        assert library.addMember(member);

        // Test borrowing
        try {
            library.borrowItem("M1001", "1234567890");
            assert !book.isAvailable();
            assert member.hasBorrowedBook("1234567890");
        } catch (Exception e) {
            System.out.println("Error during borrow test: " + e.getMessage());
            throw e;
        }

        // Test returning
        try {
            library.returnItem("M1001", "1234567890");
            assert book.isAvailable();
            assert !member.hasBorrowedBook("1234567890");
        } catch (Exception e) {
            System.out.println("Error during return test: " + e.getMessage());
            throw e;
        }

        // Test search
        assert library.searchItems("Java").size() == 1;
        assert library.searchItems("Inception").size() == 1;
    }
}
