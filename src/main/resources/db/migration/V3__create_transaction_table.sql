CREATE TABLE transactions(
                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                             books_id INTEGER NOT NULL,
                             user_id INTEGER NOT NULL,
                             borrow_date DATE,
                             return_date DATE,
                             FOREIGN KEY (books_id) REFERENCES books(id),
                             FOREIGN KEY (user_id) REFERENCES users(id)
);