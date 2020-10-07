package ir.aut.midProject;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        int simpleKey = 0;
        String complexKey = " ";
        String inputDirectoryPath = null;
        String outputDirectoryPath = null;
        int remove = 0;
        int act = 0;
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "-es")) {
                simpleKey = Integer.parseInt(args[i + 1]);
                act = 1;
            }
            if (Objects.equals(args[i], "-ds")) {
                simpleKey = Integer.parseInt(args[i + 1]);
                act = 2;
            }
            if (Objects.equals(args[i], "-ec")) {
                complexKey = args[i + 1];
                act = 3;
            }
            if (Objects.equals(args[i], "-dc")) {
                complexKey = args[i + 1];
                act = 4;
            }
            if (Objects.equals(args[i], "-i")) inputDirectoryPath = args[i + 1];
            if (Objects.equals(args[i], "-o")) outputDirectoryPath = args[i + 1];
            if (Objects.equals(args[i], "-r")) remove = 1;
        }
        File input = new File(inputDirectoryPath);
        File output;
        if (outputDirectoryPath == null) output = input;
        else output = new File(outputDirectoryPath);
        if (Objects.equals(output, null)) output = input;
        Coding coder = new Coding();
        OutputFileWriter writer = new OutputFileWriter();
        InputFileReader reader = new InputFileReader();
        SimpleShiftCryptography simpleShift = new SimpleShiftCryptography(simpleKey);
        ComplexShiftCryptography complexShift = new ComplexShiftCryptography(complexKey);
        switch (act) {
            case 1:
                writer.write(coder.decode(simpleShift.encrypt(coder.encode(reader.readFile(input)))), output);
                break;
            case 2:
                writer.write(coder.decode(simpleShift.decrypt(coder.encode(reader.readFile(input)))), output);
                break;
            case 3:
                writer.write(coder.decode(complexShift.encrypt(coder.encode(reader.readFile(input)))), output);
                break;
            case 4:
                writer.write(coder.decode(complexShift.decrypt(coder.encode(reader.readFile(input)))), output);
                break;
            default:
                System.out.println("Please enter an appropriate argument in main.");
        }
        if (remove == 1) input.delete();
    }
}
