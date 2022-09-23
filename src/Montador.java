
import java.io.*;
import java.util.*;

public class Montador {

    public static void main(String[] args) throws IOException {

        File assembly = new File("src/assembly.asm");
        Scanner sc = new Scanner(assembly);
        List<List<String>> instructions = new ArrayList<>();

        while (sc.hasNextLine()) {
            instructions.add(getLineInstructions(sc.nextLine()));
        }
        System.out.println(instructions);

        Hashtable<String, Integer> rInstructionHashtable = Instruction.getrFunctInstructionHashtable();
        Hashtable<String, Integer> iInstructionHashtable = Instruction.getiOpCodHashtable();
        Hashtable<String, Integer> jInstructionHashtable = Instruction.getjOpCodHashtable();

        for (List<String> line : instructions) {
            String command = line.get(0);

        }

        sc.close();
    }

    public static String toBinary(int number) {
        return toBinary(number, 6);
    }

    public static String toBinary(int number, int bits) {
        String binary = Integer.toBinaryString(number);
        int binaryLength = binary.length();

        if (binaryLength < bits) {
            for (int i = 0; i < bits - binaryLength; i++) {
                binary = "0" + binary;
            }
        }

        return binary;
    }

    public static List<String> getLineInstructions(String line) {
        if (line.contains(":"))
            line = line.split(":")[1];
        List<String> instructions = List.of(line.trim().replace(",", "").split(" "));

        return instructions;
    }

    public static void removeSymbol(List<String> list) {

        for (String i : list) {
            if (i.contains("$")) {
                i = toBinary(Integer.parseInt(i.replace("$", "")));
            }
        }

    }

    public static String handleRInstruction(List<String> list) {
        Hashtable<String, Integer> rInstructionHashtable = Instruction.getrFunctInstructionHashtable();
        String command = list.get(0);
        String opCode = "000000";
        String rs = "000000";
        String rt = "000000";
        String rd = "000000";
        String sa = "000000";
        String funct = toBinary(rInstructionHashtable.get(command));

        switch (command) {
            case "sll":
                rd = list.get(1);
                rt = list.get(2);
                sa = toBinary(3);
                break;

            default:
                break;
        }

        return null;
    }

}
