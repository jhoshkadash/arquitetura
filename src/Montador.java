
import java.io.*;
import java.util.*;

public class Montador {
    static Hashtable<String, String> labels = new Hashtable<>();
    static final String opfczero = "000000";
    static final String rzero = "00000";
    static final Instructions tableofInstructions = new Instructions();

    public static void main(String[] args) throws IOException {

        File assembly = new File("src/assembly.asm"); // Arquivo de entrada
                                                      // fica na mesma pasta
                                                      // do Montador.java
        Scanner sc = new Scanner(assembly); // Scanner para ler o arquivo de entrada
        List<String> instructionsPerLine = new ArrayList<>();
        List<List<String>> instructions = new ArrayList<>();
        List<List<String>> machineInstructions = new ArrayList<>();

        while (sc.hasNextLine()) { // Guardando as instruções em uma lista por linha.
            instructionsPerLine.add(sc.nextLine());
        }
        for (int i = 0; i < instructionsPerLine.size(); i++) { // Salvando label de cada linha no vetor labels na ordem
                                                               // em
                                                               // que aparecem.
            if (instructionsPerLine.get(i).contains(":")) { // Se tiver label, salva no vetor labels
                labels.put(saveLabel(instructionsPerLine.get(i)), Integer.toString(4194304+i*4));
            }
            instructions.add(List.of(returnInstruction(instructionsPerLine.get(i)))); // Salvando instruções em uma
                                                                                      // lista
                                                                                      // de listas.

        }
        for (int i = 0; i < instructions.size(); i++) { // Hora do trabs
            if (tableofInstructions.R.containsKey(instructions.get(i).get(0))) {
                machineInstructions.add(codeForRType(instructions.get(i)));
            }
            if (tableofInstructions.I.containsKey(instructions.get(i).get(0))) {
                machineInstructions.add(codeForIType(instructions.get(i),4194304+i*4));
            }
            if (tableofInstructions.J.containsKey(instructions.get(i).get(0))) {
                machineInstructions.add(codeForJType(instructions.get(i)));
            }
        }
        // System.out.println(machineInstructions); //Testando resultado
        File binary = new File("src/binary.bin");
        FileWriter fw = new FileWriter(binary);
        BufferedWriter bw = new BufferedWriter(fw);

        for (List<String> instruction : machineInstructions) {
            String line = instruction.get(0);
            bw.write(line);
            bw.newLine();

        }
        
        bw.close();
        fw.close();
        sc.close();
    }

    public static String[] returnInstruction(String instructionsPerLine) {

        if (instructionsPerLine.contains(":")) { // check se tem label na linha.
            String[] actual = instructionsPerLine.split(":"); // separa a label da instrução.
            actual[1] = actual[1].replace(",", ""); // remove a virgula da instrução.
            actual = actual[1].trim().split(" "); // remove a label da instrução.
            return actual;
        } else {
            String[] actual = instructionsPerLine.trim().replace(",", "").split(" ");

            // separa a label da instrução.
            return actual;
        }
    }

    public static String saveLabel(String instructionsPerLine) { // Salva a label na tabela de labels
        String label = instructionsPerLine.split(":")[0];
        return label; // Retorna a label da linha.

    }

    public static String toBin(String number, int size) { // convert and returns a string decimal number to string
                                                          // binary number
        int num = Integer.parseInt(number);
        String bin = Integer.toBinaryString(num);
        int len = bin.length();
        if (len < size) {
            for (int i = 0; i < size - len; i++) {
                bin = "0" + bin;
            }
        }
        if (len > size) {
            bin = bin.substring(len - size, len);
        }
        return bin;
    }

    public static List<String> removeDSignFromInst(List<String> instructions) { // remove $ from registers instructions
        List<String> newInstructions = new ArrayList<>();
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).contains("$")) {
                newInstructions.add(instructions.get(i).replace("$", ""));
            } else {
                newInstructions.add(instructions.get(i));
            }
        }
        return newInstructions;
    }

    public static List<String> removeParenthesisFromInst(List<String> instructions) { // remove () from instructions
        List<String> newInstructions = new ArrayList<>();
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).contains("(")) {
                newInstructions.add(instructions.get(i).replace("(", ""));
            } else if (instructions.get(i).contains(")")) {
                newInstructions.add(instructions.get(i).replace(")", ""));
            } else {
                newInstructions.add(instructions.get(i));
            }
        }
        return newInstructions;
    }
    

    public static List<String> codeForRType(List<String> instructions) { // retorna a instrução do tipo R em binário
        List<String> machineCode = new ArrayList<>();
        String opcode = opfczero;
        String rs = rzero;
        String rt = rzero;
        String rd = rzero;
        String shamt = rzero;
        String funct = opfczero;
        String command = instructions.get(0);
        instructions = removeDSignFromInst(instructions);
        switch (command) {
            case "sll", "srl":
                rd = toBin(instructions.get(1), 5);
                rt = toBin(instructions.get(2), 5);
                shamt = toBin(instructions.get(3), 5);
                funct = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            case "jr":
                rs = toBin(instructions.get(1), 5);
                funct = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            case "mfhi", "mflo":
                rd = toBin(instructions.get(1), 5);
                funct = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            case "mult", "multu", "div", "divu":
                rs = toBin(instructions.get(1), 5);
                rt = toBin(instructions.get(2), 5);
                funct = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            case "add", "addu", "sub", "subu", "and", "or", "slt", "sltu":
                rd = toBin(instructions.get(1), 5);
                rs = toBin(instructions.get(2), 5);
                rt = toBin(instructions.get(3), 5);
                funct = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            case "mul":
                rd = toBin(instructions.get(1), 5);
                rs = toBin(instructions.get(2), 5);
                rt = toBin(instructions.get(3), 5);
                funct = tableofInstructions.R.get(command);
                opcode = tableofInstructions.R.get(command);
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;
            default:
                machineCode.add(opcode + rs + rt + rd + shamt + funct);
                return machineCode;

        }

    }

    public static List<String> codeForIType(List<String> instructions, int line) { // retorna a instrução do tipo I em binário
        List<String> machineCode = new ArrayList<>();
        String opcode = opfczero;
        String rs = rzero;
        String rt = rzero;
        String immediate = "0000000000000000";
        String command = instructions.get(0);
        instructions = removeDSignFromInst(instructions);
        switch (command) {
            case "beq", "bne":
                rs = toBin(instructions.get(1), 5);
                rt = toBin(instructions.get(2), 5);
                immediate = toBin(Integer.toString(((Integer.parseInt(labels.get(instructions.get(3))))-(line+4))/4), 16);                            
                opcode = tableofInstructions.I.get(command);
                machineCode.add(opcode + rs + rt + immediate);
                return machineCode;
            case "addi", "addiu", "slti", "sltiu", "andi", "ori":
                rt = toBin(instructions.get(1), 5);
                rs = toBin(instructions.get(2), 5);
                immediate = toBin(instructions.get(3), 16);
                opcode = tableofInstructions.I.get(command);
                machineCode.add(opcode + rs + rt + immediate);
                return machineCode;
            case "lui":
                rt = toBin(instructions.get(1), 5);
                immediate = toBin(instructions.get(2), 16);
                opcode = tableofInstructions.I.get(command);
                machineCode.add(opcode + rs + rt + immediate);
                return machineCode;
            case "lw", "sw":
                instructions = removeParenthesisFromInst(instructions);
                rt = toBin(instructions.get(1), 5);
                rs = toBin(instructions.get(3), 5);
                immediate = toBin(instructions.get(2), 16);
                opcode = tableofInstructions.I.get(command);
                machineCode.add(opcode + rs + rt + immediate);
                return machineCode;
            default:
                machineCode.add(opcode + rs + rt + immediate);
                return machineCode;
        }

    }

    public static List<String> codeForJType(List<String> instructions) { // Retorna a instrução do tipo J em binário
        List<String> machineCode = new ArrayList<>();
        String opcode = opfczero;
        String address = "00000000000000000000000000";
        String command = instructions.get(0);
        instructions = removeDSignFromInst(instructions);
        switch (command) {
            case "j", "jal":
                address = toBin(labels.get(instructions.get(1)), 26);                          
                opcode = tableofInstructions.J.get(command);
                machineCode.add(opcode + address);
                return machineCode;
            default:
                machineCode.add(opcode + address);
                return machineCode;
        }
    }

}
