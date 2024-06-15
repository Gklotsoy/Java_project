CREATE database javalab_rentacar;

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(100) NOT NULL,
    daily_cost DECIMAL(10, 1) NOT NULL,
    cylinder_capacity INT NOT NULL,
    seats INT NOT NULL,
    category ENUM('Economy', 'Compact', 'Midsize', 'Fullsize', 'SUV', 'Van', 'Luxury') NOT NULL
);

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);


CREATE TABLE rentals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(id) ON DELETE CASCADE,
    FOREIGN KEY (car_id) REFERENCES Cars(id) ON DELETE CASCADE
);

INSERT INTO cars (model, daily_cost, cubic_capacity, seats, category) 
VALUES 
('Toyota Yaris', 50.00, 1200, 4, 'Economy'), 
('Volkswagen Golf', 60.00, 1400, 5, 'Compact'), 
('Ford Focus', 70.00, 1600, 5, 'Midsize'), 
('Chevrolet Malibu', 80.00, 1800, 5, 'Fullsize'), 
('Jeep Wrangler', 90.00, 2000, 4, 'SUV'), 
('Mercedes-Benz Sprinter', 100.00, 2200, 9, 'Van'), 
('BMW 5 Series', 120.00, 2500, 5, 'Luxury'), 
('Honda Civic', 60.00, 1400, 5, 'Compact'), 
('Hyundai Elantra', 70.00, 1600, 5, 'Midsize'), 
('Audi A4', 90.00, 1800, 5, 'Fullsize');

INSERT INTO customers (first_name, last_name, gender, address, email, phone) 
VALUES 
('Γιάννης', 'Παπαδόπουλος', 'Male', 'Αθήνα', 'giannis@example.com', '1234567890'), 
('Μαρία', 'Παπανικολάου', 'Female', 'Θεσσαλονίκη', 'maria@example.com', '0987654321'), 
('Νίκος', 'Καραμανλής', 'Male', 'Πάτρα', 'nikos@example.com', '9876543210'), 
('Ελένη', 'Δημητρίου', 'Female', 'Ηράκλειο', 'eleni@example.com', '0123456789'), 
('Δημήτρης', 'Παπαδόπουλος', 'Male', 'Λάρισα', 'dimitris@example.com', '6789012345'), 
('Αναστασία', 'Παπανικολάου', 'Female', 'Βόλος', 'anastasia@example.com', '5432109876'), 
('Γιώργος', 'Καραμανλής', 'Male', 'Χαλκίδα', 'giorgos@example.com', '8901234567'), 
('Σοφία', 'Δημητρίου', 'Female', 'Ρόδος', 'sofia@example.com', '4567890123'), 
('Παναγιώτης', 'Παπαδόπουλος', 'Male', 'Καλαμάτα', 'panagiotis@example.com', '2345678901'), 
('Ελένη', 'Παπανικολάου', 'Female', 'Ιωάννινα', 'eleni@example.com', '9012345678'), 
('Ανδρέας', 'Καραμανλής', 'Male', 'Κατερίνη', 'andreas@example.com', '6789012345'), 
('Μαρία', 'Δημητρίου', 'Female', 'Τρίκαλα', 'maria@example.com', '5432109876'), 
('Γιάννης', 'Παπαδόπουλος', 'Male', 'Σέρρες', 'giannis@example.com', '8901234567'), 
('Ελένη', 'Παπανικολάου', 'Female', 'Καβάλα', 'eleni@example.com', '4567890123'), 
('Νίκος', 'Καραμανλής', 'Male', 'Χανιά', 'nikos@example.com', '2345678901'), 
('Αναστασία', 'Δημητρίου', 'Female', 'Λαμία', 'anastasia@example.com', '9012345678'), 
('Γιώργος', 'Παπαδόπουλος', 'Male', 'Κομοτηνή', 'giorgos@example.com', '6789012345'), 
('Σοφία', 'Παπανικολάου', 'Female', 'Κέρκυρα', 'sofia@example.com', '5432109876'), 
('Παναγιώτης', 'Καραμανλής', 'Male', 'Ρέθυμνο', 'panagiotis@example.com', '8901234567'), 
('Ελένη', 'Δημητρίου', 'Female', 'Καρδίτσα', 'eleni@example.com', '4567890123');


INSERT INTO rentals (customer_id, car_id, start_date, end_date) 
VALUES 
(1, 1, '2022-01-01', '2022-01-05'), 
(2, 3, '2022-02-10', '2022-02-15'), 
(3, 5, '2022-03-20', '2022-03-25'), 
(4, 2, '2022-04-15', '2022-04-20'), 
(5, 4, '2022-05-05', '2022-05-10');
