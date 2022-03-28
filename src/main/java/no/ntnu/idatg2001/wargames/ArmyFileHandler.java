package no.ntnu.idatg2001.wargames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;


public class ArmyFileHandler {

    enum UnitType{
        INFANTRYUNIT,
        CAVALRYUNIT,
        RANGEDUNIT,
        COMMANDERUNIT
    }

    public static Army readCsv(Path path) {
        Army army = new Army("temp");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String name = reader.readLine();
            String lineOfText;
            while ((lineOfText = reader.readLine()) != null) {
                String[] words = lineOfText.split(",");
                UnitType whichUnit = UnitType.valueOf(words[0].toUpperCase());
                switch (whichUnit){
                    case INFANTRYUNIT:
                        army.add(new InfantryUnit(words[1].strip(), Integer.parseInt(words[2].strip())));
                        break;
                    case CAVALRYUNIT:
                        army.add(new CavalryUnit(words[1].strip(), Integer.parseInt(words[2].strip())));
                        break;
                    case RANGEDUNIT:
                        army.add(new RangedUnit(words[1].strip(), Integer.parseInt(words[2].strip())));
                        break;
                    case COMMANDERUNIT:
                        army.add(new CommanderUnit(words[1].strip(), Integer.parseInt(words[2].strip())));
                        break;
                    default:
                        break;
                }
            }
            army.setName(name);
            return  army;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public static void writeCSV(Army army, Path path)
    {
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(army.getName() + "\n");
            for (Unit unit : army.getAllUnits()) {
                Class unitClass = unit.getClass();
                String typeOfUnit = unitClass.getSimpleName();
                writer.write(typeOfUnit + ", " +  unit.getName() + ", " + unit.getHealth() + "\n");
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

    /*

    public static void main(String[] args) throws IOException {
        Army army123 = readCsv(Path.of("units.csv"));
        String navn = army123.getName();
        System.out.println(navn);
        army123.getAllUnits().forEach(unit -> System.out.println(unit.getName() + " " + unit.getHealth()));
    }
     */

}
