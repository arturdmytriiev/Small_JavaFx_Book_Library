CREATE TABLE role(
                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                     name TEXT NOT NULL UNIQUE
);

CREATE TABLE users (
                       id INTEGER PRIMARY KEY AUTOINCREMENT ,
                       username TEXT NOT NULL UNIQUE,
                       password TEXT NOT NULL,
                       role_id INTEGER NOT NULL,
                       FOREIGN KEY (role_id) REFERENCES role(id)
);