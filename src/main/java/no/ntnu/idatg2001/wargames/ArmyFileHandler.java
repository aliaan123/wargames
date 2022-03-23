package no.ntnu.idatg2001.wargames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class ArmyFileHandler {

    private String armyName;


    public static Army readCsv(Path path) throws IOException {

        //Scanner in = new Scanner(path);
        //String armyName = in.nextLine();
        Army army = new Army("HEllo");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String lineOfText;
            while ((lineOfText = reader.readLine()) != null) {
                String[] words = lineOfText.split(" ");
                //army.setName();
                army.add(new InfantryUnit(words[0].strip(), Integer.parseInt(words[1].strip())));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return army;
    }

    public static void writeSerialized(Army army, Path path)
    {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(army);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Army readSerialized(Path path)
    {
        Army army = new Army("ArmyName");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            army = (Army) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return army;
    }

    public static void main(String[] args) throws IOException {

        Army army123 = readCsv(Path.of("units.csv"));
        String navn = army123.getName();
        System.out.println(navn);
        writeSerialized(army123, Path.of("units.bin"));
        army123 = readSerialized(Path.of("units.bin"));
        army123.getAllUnits().forEach(unit -> System.out.println(unit.getName() + " " + unit.getHealth()));
    }


}
