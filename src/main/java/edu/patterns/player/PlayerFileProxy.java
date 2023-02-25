package edu.patterns.player;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import edu.patterns.interfaces.IPlayerFileProxy;

public class PlayerFileProxy implements IPlayerFileProxy {

    private PlayerFile pFile;

    public PlayerFileProxy() {
        pFile = new PlayerFile();
    }

    @Override
    public List<String[]> getData() {
        List<String[]> data = pFile.getData();

        Collections.sort(data, (e1, e2) -> {
            return Integer.parseInt(e2[2]) - Integer.parseInt(e1[2]);
        });

        return data;
    }

    public Object[][] convert(List<String[]> list) {
        Object[][] matrix = new Object[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            matrix[i] = new Object[] {i + 1, 
                    list.get(i)[2], 
                    list.get(i)[0], 
                    list.get(i)[1]};
        }

        return matrix;
    }

    public SortedSet<String> nickNames(List<String[]> list) {
        Supplier<TreeSet<String>> stringSet = () -> new TreeSet<String>();
        return list.stream()
                .map(x -> x[0])
                .collect(Collectors.toCollection(stringSet));
    }

}
