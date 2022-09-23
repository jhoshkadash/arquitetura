public class InstructionI extends Instruction {
  private String rs;
  private String rt;
  private String immediate;
  public String getRs() {
    return rs;
  }
  public void setRs(String rs) {
    this.rs = rs;
  }
  public String getRt() {
    return rt;
  }
  public void setRt(String rt) {
    this.rt = rt;
  }
  public String getImmediate() {
    return immediate;
  }
  public void setImmediate(String immediate) {
    this.immediate = immediate;
  }

  public void traduzir(String inst, InstructionI instu) {
    InstructionI instruction = new InstructionI();
    if (inst.compareTo("beq") == 0){
      instruction.setOpcode("000100");      
      
    }
     if (inst.compareTo("bne") == 0){
      instruction.setOpcode("000101");      
      
    }
   
     if (inst.compareTo("addi") == 0){
      instruction.setOpcode("001000");      
      
    }
     if (inst.compareTo("addiu") == 0){
      instruction.setOpcode("001001");      
      
    }
     if (inst.compareTo("slti") == 0){
      instruction.setOpcode("001010");      
      
    }
     if (inst.compareTo("sltiu") == 0){
      instruction.setOpcode("001011");      
      
    }
     if (inst.compareTo("andi") == 0){
      instruction.setOpcode("001100");      
      
    }
     if (inst.compareTo("ori") == 0){
      instruction.setOpcode("001101");      
      
    }
    
     if (inst.compareTo("lui") == 0){
      instruction.setOpcode("001111");
    }
   
     if (inst.compareTo("lw") == 0){
      instruction.setOpcode("100011");      
      
    }
    if (inst.compareTo("sw") == 0){
      instruction.setOpcode("101011");      
      
    }
    
  }
}
