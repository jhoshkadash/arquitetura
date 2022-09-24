import java.util.Hashtable;
//Tabela com valores de instruções em binário

public class Instructions {
  Hashtable<String, String> R;
  Hashtable<String, String> I;
  Hashtable<String, String> J;

  public Instructions(){
    R = new Hashtable<>();
    I = new Hashtable<>();
    J = new Hashtable<>();
    // R-Type
    R.put("sll", "000000");
    R.put("srl", "000010");
    R.put("jr", "001000");
    R.put("mfhi", "010000");
    R.put("mflo", "010010");
    R.put("mult", "011000");
    R.put("multu", "011001");
    R.put("div", "011010");
    R.put("divu", "011011");
    R.put("add", "100000");
    R.put("addu", "100001");
    R.put("sub", "100010");
    R.put("subu", "100011");
    R.put("and", "100100");
    R.put("or", "100101");
    R.put("slt", "101010");
    R.put("sltu", "101011");
    R.put("mul", "011100"); 
    // I-Type
    I.put("beq", "000100");
    I.put("bne", "000101");
    I.put("addi", "001000");
    I.put("addiu", "001001");
    I.put("slti", "001100");
    I.put("sltiu", "001101");
    I.put("andi", "001100");
    I.put("ori", "001101");
    I.put("lui", "001111");
    I.put("lw", "100011");
    I.put("sw", "101011");
    // J-Type
    J.put("j", "000010");
    J.put("jal", "000011");
  }
}
