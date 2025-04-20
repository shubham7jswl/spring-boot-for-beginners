package com.sj.springbootforbeginners.service;

import com.opencsv.CSVReader;
import com.sj.springbootforbeginners.model.Person;
import com.sj.springbootforbeginners.model.Roommate;
import com.sj.springbootforbeginners.repository.PersonRepository;
import com.sj.springbootforbeginners.repository.RoommateRepository;
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

    @Autowired
    private RoommateRepository roommateRepository;

    private final String csvUrl = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQ4Z134DfqVTny-Umm4Fhu3VgbTgjY5a1DBdR2qyauiNLh2mo9t7Ix99ACHo2zF2GH5vtjiuLWSG2mg/pub?output=csv";
//    private final String csvUrlForRoommate = "https://docs.google.com/spreadsheets/d/1TdH9rqw3f1trbOHCUhUcEd0mePP8_ZX2C9jVySNUR0A/edit?gid=2003765756#gid=2003765756";
//    private final String csvUrlForRoommate = "https://docs.google.com/spreadsheets/d/1TdH9rqw3f1trbOHCUhUcEd0mePP8_ZX2C9jVySNUR0A/edit?usp=sharing";
//    private final String csvUrlForRoommate = "https://docs.google.com/spreadsheets/d/e/1TdH9rqw3f1trbOHCUhUcEd0mePP8_ZX2C9jVySNUR0A/pub?output=csv";
    private final String csvUrlForRoommate = "https://docs.google.com/spreadsheets/d/e/2PACX-1vR3qHVbZSymTDqXFWjOfs1Ct4_qFQRZLwOOzSnmClsUN6_IJiO52ShmqBYH10zWizAzlPpriUKdtXeo/pub?output=csv";

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


    @Scheduled(fixedRate = 300000) // every 5 minutes
    public void fetchDataFromRoommateSheet() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(csvUrlForRoommate).openStream()))) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> rows = csvReader.readAll();

            List<Roommate> roommates = new ArrayList<>();
            for (int i = 1; i < rows.size(); i++) { // skip header
                String[] row = rows.get(i);
                Roommate roommate = new Roommate();
                roommate.setTimestamp(row[0]);
                roommate.setName(row[1]);
                roommate.setGender(row[2]);
                roommate.setMobileNumber(row[3]);
                roommate.setIntake(row[4]);
                roommate.setComingFor(row[5]);
                roommate.setYourMajorInUB(row[6]);
                roommate.setHometown(row[7]);
                roommate.setState(row[8]);
                roommate.setMotherTongue(row[9]);
                roommate.setVisa(row[10]);
                roommate.setRoommateSGenderPreference(row[11]);
                roommate.setPreferredRoomType(row[12]);
                roommate.setPreferredHouseType(row[13]);
                roommate.setYourDiet(row[14]);
                roommate.setRateYourCookingSkillsOnAScaleOf10(row[15]);
                roommate.setRoommateSDietPreference(row[16]);
                roommate.setDoYouSmoke(row[17]);
                roommate.setDoYouDrink(row[18]);
                roommate.setRoommateSSmokingPreference(row[19]);
                roommate.setRoommateSDrinkingPreference(row[20]);
                roommate.setEstimatedDateOfArrival(row[21]);
                roommate.setLinkedInURL(row[22]);
                roommate.setInstaID(row[23]);
                roommate.setEnterYourBudgetPerMonthInTheRangeOf350750Dollars(row[24]);
                roommate.setAnyOtherRequirementsOrComments(row[25]);
                roommates.add(roommate);
            }
            roommateRepository.deleteAll();
            roommateRepository.saveAll(roommates);
            System.out.println("Data updated from Google Sheet.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
