CREATE TABLE translations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,  
    source_lang VARCHAR(50) NOT NULL,  
    target_lang VARCHAR(50) NOT NULL,  
    original_text TEXT NOT NULL, 
    translated_text TEXT NOT NULL,  
    translation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE  
);
