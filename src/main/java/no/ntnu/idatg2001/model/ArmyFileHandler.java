package no.ntnu.idatg2001.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Aliaan
 * Class for handling a file where we can store an army.
 */
public class ArmyFileHandler implements Serializable {

    enum UnitType{
        INFANTRYUNIT,
        CAVALRYUNIT,
        RANGEDUNIT,
        COMMANDERUNIT
    }

    /**
     * Method for reading from the units.csv file.
     * The csv-file contains information of an army that we wish to save.
     * We use this method to read the contents of the file and make sense of it,
     * so that we can turn what is written in the file into an army with units.
     * @param path takes in the path of the csv file as a parameter.
     * @return returns an army that is created from reading the contents of the csv-file or null if an exception occurs.
     */
    public static Army readCSV(Path path) {
        Army army = new Army("temp");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String name = reader.readLine();
            String lineOfText;
            while ((lineOfText = reader.readLine()) != null) {
                String[] words = lineOfText.split(",");
                UnitType whichUnit = UnitType.valueOf(words[0].toUpperCase());
                switch (whichUnit) {
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

    /**
     * Method for writing to the csv file.
     * This method is used for writing to the csv-file,
     * so that we can store an army in it.
     * The first line in the file will always be the army's name.
     * In each line below the first one, you can add units to the army by writing their
     * unit-type, name of unit and health (in that order). One unit per line.
     * @param army takes in an army as a parameter .
     * @param path takes in the path of the csv file as a parameter.
     */
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


    /**
     * Method for serializing army
     * @param army takes in army object as parameter
     * @param path takes in path of file as parameter
     */
    public static void writeSerialized(Army army, Path path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path)))
        {
            outputStream.writeObject(army);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Method for reading serialized army
     * @param path takes in path of as parameter
     * @return returns army
     */
    public static Army readSerialized(Path path) {
        Army army = new Army("d");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            army = (Army) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return army;
    }


}









