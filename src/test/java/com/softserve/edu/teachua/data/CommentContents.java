package com.softserve.edu.teachua.data;

public enum CommentContents {
    FIRST_COMMENT("Проба Проба", "2024-06-22 10:59:59", "оба Коментар");

    private CommentContents(String author, String datetime, String text) {
        // TODO Task 3: store author, datetime and text.
    }

    public String getAuthor() {
        // TODO Task 3: return the stored author.
        throw new UnsupportedOperationException("Implement CommentContents.getAuthor()");
    }

    public String getDatetime() {
        // TODO Task 3: return the stored datetime.
        throw new UnsupportedOperationException("Implement CommentContents.getDatetime()");
    }

    public String getText() {
        // TODO Task 3: return the stored text.
        throw new UnsupportedOperationException("Implement CommentContents.getText()");
    }

    @Override
    public String toString() {
        // TODO Task 3: return a readable comment description.
        return name();
    }
}
