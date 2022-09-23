
import java.io.*;
import java.util.*;

public class Montador {

    public static void main(String[] args) throws IOException {

        File assembly = new File("C:/Users/jhosh/Documents/GitHub/arquitetura/src/assembly.asm"); // Arquivo de entrada fica na mesma pasta do Montador.java
        Scanner sc = new Scanner(assembly);
        Instruction inst = new Instruction();
        List<String> instructionsPerLine = new ArrayList<>();
        List<Label> labels = new ArrayList<>();
        List<Instruction> instructions = new ArrayList<>();
        String actual[];

        while (sc.hasNextLine()) { // Guardando as instruções em uma lista por linha.
            instructionsPerLine.add(sc.nextLine());
        }
        int i = 0; // Contador para percorrer a lista de instruções.

        while (i < instructionsPerLine.size()) { // Percorrendo a lista de instruções por linha.

            actual = instructionsPerLine.get(i).split(" "); // Dividindo a primeira linha em um array com cada instrução
                                                            // para depois checkar se tem uma label ou não.

            if (actual[0].contains(":")) // Checando se a primeira palavra da linha possui ":". Se tiver é criado um
                                         // objeto Label e adicionado na lista de labels.
            {
                Label label = new Label();
                label.setName(actual[0].substring(0, actual[0].length() - 1));
                label.setLine(i);
                labels.add(label);
                System.out.println(label.getName() + " " + label.getLine()); // Printando o nome da label e a linha que
                                                                             // ela está.
            }
            if (actual.length == 5) {
                for (int j = 1; j < actual.length; j++) {

                    inst.setName(actual[j]);
                }
            } else {
                inst.setName(actual[i]);
            }
            i++;
        }

    }

}
