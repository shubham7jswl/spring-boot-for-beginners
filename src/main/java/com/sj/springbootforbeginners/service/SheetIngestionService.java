package com.sj.springbootforbeginners.service;

import com.opencsv.CSVReader;
import com.sj.springbootforbeginners.model.Person;
import com.sj.springbootforbeginners.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SheetIngestionService {

    @Autowired
    private PersonRepository personRepository;

    private final String csvUrl = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQ4Z134DfqVTny-Umm4Fhu3VgbTgjY5a1DBdR2qyauiNLh2mo9t7Ix99ACHo2zF2GH5vtjiuLWSG2mg/pub?output=csv";

    @Scheduled(fixedRate = 300000) // every 5 minutes
    public void fetchDataFromSheet() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(csvUrl).openStream()))) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> rows = csvReader.readAll();

            List<Person> people = new ArrayList<>();
            for (int i = 1; i < rows.size(); i++) { // skip header
                String[] row = rows.get(i);
                Person person = new Person();
                person.setName(row[0]);
                person.setEmail(row[1]);
                person.setAge(Integer.parseInt(row[2]));
                people.add(person);
            }

            personRepository.saveAll(people);
            System.out.println("Data updated from Google Sheet.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
