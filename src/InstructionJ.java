public class InstructionJ extends Instruction {
  private String address;
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public void traduzir(String inst, InstructionI instu) {
    InstructionI instruction = instu ;
    if (inst.compareTo("j") == 0){
      instruction.setOpcode("000010");      
      
    }
     if (inst.compareTo("jal") == 0){
      instruction.setOpcode("000011");      
      
    }
    
  }
  
}
