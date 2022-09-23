
import java.io.*;
import java.util.*;

public class Montador {

    public static void main(String[] args) throws IOException {

        File assembly = new File("C:/Users/jhosh/Documents/GitHub/arquitetura/src/assembly.asm"); // Arquivo de entrada
                                                                                                  // fica na mesma pasta
                                                                                                  // do Montador.java
        Scanner sc = new Scanner(assembly);
        List<String> instructionsPerLine = new ArrayList<>();
        List<String> instructionsMachinePerLine = new ArrayList<>();
        String actual[];

        while (sc.hasNextLine()) { // Guardando as instruções em uma lista por linha.
            instructionsPerLine.add(sc.nextLine());
        }
        int i = 0; // Contador para percorrer a lista de instruções.

        while (i < instructionsPerLine.size()) { // Percorrendo a lista de instruções por linha.

            actual = instructionsPerLine.get(i).split(" "); // Dividindo a primeira linha em um array com cada instrução
                                                            // para depois checkar se tem uma label ou não.

        }
    }

}
