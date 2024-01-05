drop table if exists question;
CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    category VARCHAR(25),
    difficulty_level VARCHAR(25),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    question_title VARCHAR(255),
    correct_answer VARCHAR(255)
);       



INSERT INTO question (category, difficulty_level, option1, option2, option3, option4, question_title, correct_answer)
VALUES ('Geography', 'Easy', 'What is the capital of France?', 'Paris', 'London', 'Rome', 'Berlin', 'Paris');

INSERT INTO question (category, difficulty_level, option1, option2, option3, option4, question_title, correct_answer)
VALUES ('Literature', 'Medium', 'Who wrote the novel "Moby Dick"?', 'Herman Melville', 'Mark Twain', 'Charles Dickens', 'Leo Tolstoy', 'Herman Melville');

INSERT INTO question (category, difficulty_level, option1, option2, option3, option4, question_title, correct_answer)
VALUES ('Math', 'Hard', 'What is the square root of 16?', '4', '8', '12', '16', '4');

INSERT INTO question (category, difficulty_level, option1, option2, option3, option4, question_title, correct_answer)
VALUES ('Science', 'Easy', 'What is the name of the largest planet in the solar system?', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Jupiter');

INSERT INTO question (category, difficulty_level, option1, option2, option3, option4, question_title, correct_answer)
VALUES ('History', 'Medium', 'What was the name of the first world war?', 'World War I', 'World War II', 'The Great War', 'The War to End All Wars', 'World War I');