package edu.patterns.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.patterns.interfaces.IPlayerFileProxy;

public final class PlayerFile implements IPlayerFileProxy {
    private static final String CSV_FILE = "res/database.csv";
    private static final String DELIMITER = ",";
    private List<String[]> data;

    public PlayerFile() {
        loadFile();
    }

    public void save(MementoPlayer mPlayer) {
        for (String[] register: data) {
            if (register[0].contentEquals(mPlayer.getNickName())) {
                register[2] = mPlayer.getMaxScore();
                return;
            }
        }

        this.data.add(new String[] {mPlayer.getNickName(),
                mPlayer.getName(),
                mPlayer.getMaxScore()});
    }

    public MementoPlayer open(final String nickName) {
        for (String[] register: data) {
            if (register[0].equals(nickName)) {
                return new MementoPlayer(register[0], register[1], register[2]);
            }
        }
        return null;
    }

    private String joinDelimiter(final String[] data) {
        return Stream.of(data).collect(Collectors.joining(DELIMITER));
    }

    public void writeFile() throws IOException {
        File csvFile = new File(CSV_FILE);

        try (PrintWriter pw = new PrintWriter(csvFile)) {
            data.stream()
            .map(this::joinDelimiter)
            .forEach(pw::println);
        }
    }

    @Override
    public List<String[]> getData() {
        return data;
    }

    public boolean playerExists(String nickName) {
        for (String[] register: data) {
            if (register[0].equals(nickName)) {
                return true;
            }
        }

        return false;
    }

    private List<String[]> readFile() throws FileNotFoundException,
        IOException {
        List<String[]> registers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] register = line.split(DELIMITER);
                registers.add(register);
            }
        }

        return registers;
    }

    private void loadFile() {
        try {
            data = readFile();
        } catch (FileNotFoundException e) {
            data = new ArrayList<>();
            try {
                writeFile();
                data = readFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
