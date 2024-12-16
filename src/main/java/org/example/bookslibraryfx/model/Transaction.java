package org.example.bookslibraryfx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "books_id", nullable = false)
    private Book bookId;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    @Column(name = "borrow_date", nullable = false)
    private Date borrowDate;
    @Column(name = "return_date", nullable = false)
    private Date returnDate;
}
