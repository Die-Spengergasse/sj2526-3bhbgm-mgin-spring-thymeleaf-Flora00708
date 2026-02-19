package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// das ist die repository klasse, die mit der patient klasse verbunden ist, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben
// das framework macht die implementierung für uns, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben
// das erste ist die entity klasse, die wir in der patient klasse definiert haben, das zweite ist der primärschlüsseltyp, der in der patient klasse als int definiert ist, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben

//das @Reposetory ist auch eine notation, ich muss keine instanz schreiben, weil das Framework das für mich macht, es ist eine spezielle notation, die dem Framework sagt, dass diese Klasse eine Repository-Klasse ist, damit wird sie automatisch erkannt und mit anderen Klassen verbunden, die in der gleichen Package oder in einem Unterpackage liegen, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben
//das verwende ich beim Patient Controller

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    // Patient ist die entity klasse, und Integer ist weil der Primary Key ein int ist, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben

}
