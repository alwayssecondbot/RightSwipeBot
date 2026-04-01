package ru.yanes;

public class Exceptions {
    private static final int pages = 1001;
    public static void main(String[] args) {
        try {
            Shelf.addBook("Ba", pages);
        } catch (TooManyPagesException e) {
            System.out.println(e);
        }
    }

    class Shelf {
        public static void addBook(String title, int pages) throws TooManyPagesException {
            if (pages < 1000) {
                System.out.printf("Add book '%s' to shelf", title);
            } else {
                throw new TooManyPagesException("Book '"+title+"' is out of size limit of 1000: ", pages);
            }
        }
    }

    static class TooManyPagesException extends Exception {
        public TooManyPagesException(String message, int pages) {
            super(message + pages);
        }
    }
}

