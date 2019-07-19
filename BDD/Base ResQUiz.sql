CREATE DATABASE ResQuiz;
USE ResQuiz;

CREATE TABLE Expositores(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50),
apellido VARCHAR(50),
correo VARCHAR(100),
telefono VARCHAR(10),
institucion VARCHAR(100),
titulo VARCHAR(100),
idImagen INT,

PRIMARY KEY(id)
);

CREATE TABLE Imagenes(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(100),
tipo VARCHAR(100),
adjunto LONGTEXT,

PRIMARY KEY(id)
);

CREATE TABLE Salas(
id INT NOT NULL AUTO_INCREMENT,
codigo VARCHAR(200),
nombre VARCHAR(100),
tema VARCHAR(50),
capacidad INT,
preguntasPermitidas INT,
idExpositor INT,

PRIMARY KEY(id)
);

CREATE TABLE Preguntas(
id INT NOT NULL AUTO_INCREMENT,
pregunta VARCHAR(200),
nombre VARCHAR(50),
correo VARCHAR(100),

PRIMARY KEY(id)
);

CREATE TABLE SalasPreguntas(
id INT NOT NULL AUTO_INCREMENT,
idSala INT,
idPregunta INT,

PRIMARY KEY(id)
);