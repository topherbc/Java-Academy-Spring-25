package com.pluralsight.model.entities;

/**
 * Represents a magazine in the library system.
 * Magazines have publishers, issue numbers, and publication dates.
 * Default borrow duration for magazines is 1 week (7 days).
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Magazine extends Item {
    private String issueNumber;
    private String publicationDate;
    
    public Magazine(String magazineId, String title, String publisher, String genre, 
                   String issueNumber, String publicationDate) {
        super(magazineId, title, publisher, genre);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }
    
    public Magazine(String magazineId, String title, String publisher, String genre, 
                   String issueNumber, String publicationDate, boolean isAvailable) {
        super(magazineId, title, publisher, genre, isAvailable);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }
    
    public String getIssueNumber() { 
        return issueNumber; 
    }
    
    public String getPublicationDate() { 
        return publicationDate; 
    }
    
    public String getPublisher() { 
        return getCreator(); 
    }
    
    @Override
    public String getType() {
        return "Magazine";
    }
    
    @Override
    public int getBorrowDuration() {
        return 7; // 1 week for magazines
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s by %s [%s] Issue: %s (%s) - %s", 
            getId(), getTitle(), getPublisher(), getGenre(), issueNumber, publicationDate,
            isAvailable() ? "Available" : "Borrowed");
    }
}