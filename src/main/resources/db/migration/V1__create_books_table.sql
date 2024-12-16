
CREATE TABLE books(
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      title TEXT NOT NULL,
                      author TEXT NOT NULL,
                      genre TEXT,
                      publication_year INTEGER,
                      available BOOLEAN DEFAULT TRUE
);