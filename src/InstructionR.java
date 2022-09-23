public class InstructionR extends Instruction {
  private String rs;
  private String rt;
  private String rd;
  private String shamt;
  private String funct;

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

  public String getRd() {
    return rd;
  }

  public void setRd(String rd) {
    this.rd = rd;
  }

  public String getShamt() {
    return shamt;
  }

  public void setShamt(String shamt) {
    this.shamt = shamt;
  }

  public String getFunct() {
    return funct;
  }

  public void setFunct(String funct) {
    this.funct = funct;
  }

  public void traduzir(String inst, InstructionR instu) {
    InstructionR instruction = instu;
    int i;
    if (inst.compareTo("sll") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("000000");
      

    } else if (inst.compareTo("srl") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("000010");

    } else if (inst.compareTo("jr") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("001000");

    } else if (inst.compareTo("mfhi") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("010000");

    }

    else if (inst.compareTo("mflo") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("010010");

    }

    else if (inst.compareTo("mult") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("011000");

    } else if (inst.compareTo("multu") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("011001");

    } else if (inst.compareTo("div") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("011010");

    } else if (inst.compareTo("divu") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("011011");

    } else if (inst.compareTo("add") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100000");

    } else if (inst.compareTo("addu") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100001");

    } else if (inst.compareTo("sub") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100010");

    } else if (inst.compareTo("subu") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100011");

    } else if (inst.compareTo("and") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100100");

    } else if (inst.compareTo("or") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("100101");

    }

    else if (inst.compareTo("slt") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("101010");

    } else if (inst.compareTo("sltu") == 0) {
      instruction.setOpcode("000000");
      instruction.setFunct("101011");

    } else if (inst.compareTo("mul") == 0) {
      instruction.setOpcode("011000");
      instruction.setFunct("000010");

    }
    for (int i = 0; i < 32; i++) {

      if ((inst.substring(1, inst.length() - 1).compareTo(Integer.toString(i))) == 0) {
        instruction.rd = Integer.toBinaryString(i);
        break;
      }
      for (i = 0; i < 32; i++) {

        if ((inst.substring(1, inst.length() - 1).compareTo(Integer.toString(i))) == 0) {
          instruction.rd = Integer.toBinaryString(i);
          break;
        }
      }

    }

  }
}
