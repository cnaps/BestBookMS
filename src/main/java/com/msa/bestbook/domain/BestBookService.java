package com.msa.bestbook.domain;

import com.msa.bestbook.domain.model.BestBook;
import com.msa.bestbook.domain.model.Item;
import com.msa.bestbook.persistence.BestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BestBookService {
    private final BestBookRepository bookRepository;

    public List<BestBook> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BestBook> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public void dealBestBook(Item item){
        BestBook bestBook = bookRepository.findBestBookByItem(item);
        if (bestBook != null){
            bestBook.increseBestBookCount();
        } else {
            bestBook =  BestBook.registerBestBook(item);
        }
        saveBook(bestBook);
    }

    public BestBook updateBook(String id, BestBook book) {
        Optional<BestBook> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            BestBook existingBook = existingBookOptional.get();
            existingBook.setItem(book.getItem());
            existingBook.setRentCount(book.getRentCount());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public boolean deleteBook(String id) {
        Optional<BestBook> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
            return true;
        }
        return false;
    }

    public BestBook saveBook(BestBook book) {
        return bookRepository.save(book);
    }
}