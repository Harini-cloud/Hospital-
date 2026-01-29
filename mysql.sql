CREATE TABLE appointment (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(10),
    doctor_name VARCHAR(100),
    appointment_date DATE,
    token_number INT,
    status VARCHAR(30)
);
