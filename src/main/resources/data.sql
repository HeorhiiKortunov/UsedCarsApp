-- Insert users
INSERT INTO users (username, email, phone) VALUES
('alice', 'alice@example.com', 123456789),
('bob', 'bob@example.com', 987654321),
('carol', 'carol@example.com', 456789123);

-- Insert posts
INSERT INTO posts (author_id, make, model, year, mileage, price) VALUES
(1, 'Toyota', 'Camry', 2018, 40000, 15000),
(1, 'Honda', 'Civic', 2020, 25000, 18000),
(2, 'Ford', 'Focus', 2017, 60000, 12000),
(3, 'Tesla', 'Model 3', 2022, 10000, 35000),
(3, 'BMW', 'X5', 2019, 30000, 40000);