package br.ufma.ecp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CodeWriter {

    private StringBuilder output = new StringBuilder();
    private String moduleName = "Main";
    private int labelCount = 0;
    private String outputFileName;
    private int callCount = 0;

    public CodeWriter(String fname) {
        outputFileName = fname;
    }

    void setFileName(String s) {
        moduleName = s.substring(0, s.indexOf("."));
        moduleName = moduleName.substring(s.lastIndexOf("/") + 1);
        System.out.println(moduleName);
    }

    String registerName(String segment, int index) {

        if (segment.equals("local"))
            return "LCL";
        if (segment.equals("argument"))
            return "ARG";
        if (segment.equals("this"))
            return "THIS";
        if (segment.equals("that"))
            return "THAT";
        if (segment.equals("pointer"))
            return "R" + (3 + index);
        if (segment.equals("temp"))
            return "R" + (5 + index);

        return moduleName + "." + index;
    }

    // StaticsTest não funcionou nem com writeInit e nem sem, não entendi qual o
    // problema.
    public void writeInit() {// vamos usar apenas em: 08/FunctionCalls[FibonacciElement, NestedCall ]

        write("@256");
        write("D=A");
        write("@SP");
        write("M=D");
        writeCall("Sys.init", 0);
    }

    void writePush(String seg, int index) {
        if (seg.equals("constant")) {
            write("@" + index + " // push " + seg + " " + index);
            write("D=A");
            write("@SP");
            write("A=M");
            write("M=D");
            write("@SP");
            write("M=M+1");
        } else if (seg.equals("static") || seg.equals("temp") || seg.equals("pointer")) {
            write("@" + registerName(seg, index) + " // push " + seg + " " + index);
            write("D=M");
            write("@SP");
            write("A=M");
            write("M=D");
            write("@SP");
            write("M=M+1");
        }

        else {
            write("@" + registerName(seg, 0) + " // push " + seg + " " + index);
            write("D=M");
            write("@" + index);
            write("A=D+A");
            write("D=M");
            write("@SP");
            write("A=M");
            write("M=D");
            write("@SP");
            write("M=M+1");
        }
    }

    void writePop(String seg, int index) {
        if (seg.equals("static") || seg.equals("temp") || seg.equals("pointer")) {

            write("@SP // pop " + seg + " " + index);
            write("M=M-1");
            write("A=M");
            write("D=M");
            write("@" + registerName(seg, index));
            write("M=D");
        } else {
            write("@" + registerName(seg, 0) + " // pop " + seg + " " + index);
            write("D=M");
            write("@" + index);
            write("D=D+A");
            write("@R13");
            write("M=D");
            write("@SP");
            write("M=M-1");
            write("A=M");
            write("D=M");
            write("@R13");
            write("A=M");
            write("M=D");
        }
    }

    void writeArithmeticAdd() {
        write("@SP // add");
        write("M=M-1");
        write("A=M");
        write("D=M");
        write("A=A-1");
        write("M=D+M");
    }

    void writeArithmeticSub() {
        write("@SP // sub");
        write("M=M-1");
        write("A=M");
        write("D=M");
        write("A=A-1");
        write("M=M-D");
    }

    void writeArithmeticNeg() {
        write("@SP // neg");
        write("A=M");
        write("A=A-1");
        write("M=-M");
    }

    void writeArithmeticAnd() {
        write("@SP // and");
        write("AM=M-1");
        write("D=M");
        write("A=A-1");
        write("M=D&M");
    }

    void writeArithmeticOr() {
        write("@SP // or");
        write("AM=M-1");
        write("D=M");
        write("A=A-1");
        write("M=D|M");
    }

    void writeArithmeticNot() {

        write("@SP // not");
        write("A=M");
        write("A=A-1");
        write("M=!M");
    }

    void writeArithmeticEq() {
        String label = ("JEQ_" + moduleName + "_" + (labelCount));
        write("@SP // eq");
        write("AM=M-1");
        write("D=M");
        write("@SP");
        write("AM=M-1");
        write("D=M-D");
        write("@" + label);
        write("D;JEQ");
        write("D=1");
        write("(" + label + ")");
        write("D=D-1");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");

        labelCount++;
    }

    void writeArithmeticGt() {
        String labelTrue = ("JGT_TRUE_" + moduleName + "_" + (labelCount));
        String labelFalse = ("JGT_FALSE_" + moduleName + "_" + (labelCount));

        write("@SP // gt");
        write("AM=M-1");
        write("D=M");
        write("@SP");
        write("AM=M-1");
        write("D=M-D");
        write("@" + labelTrue);
        write("D;JGT");
        write("D=0");
        write("@" + labelFalse);
        write("0;JMP");
        write("(" + labelTrue + ")");
        write("D=-1");
        write("(" + labelFalse + ")");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");

        labelCount++;
    }

    void writeArithmeticLt() {
        String labelTrue = ("JLT_TRUE_" + moduleName + "_" + (labelCount)); // toDo ; module
        String labelFalse = ("JLT_FALSE_" + moduleName + "_" + (labelCount));

        write("@SP // lt");
        write("AM=M-1");
        write("D=M");
        write("@SP");
        write("AM=M-1");
        write("D=M-D");
        write("@" + labelTrue);
        write("D;JLT");
        write("D=0");
        write("@" + labelFalse);
        write("0;JMP");
        write("(" + labelTrue + ")");
        write("D=-1");
        write("(" + labelFalse + ")");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");

        labelCount++;
    }

    void writeLabel(String label) {
        write("(" + label + ")");
    }

    void writeGoto(String label) {
        write("@" + label);
        write("0;JMP");
    }

    void writeIf(String label) {
        write("@SP");
        write("AM=M-1");
        write("D=M");
        write("M=0");
        write("@" + label);
        write("D;JNE");

    }

    void writeFunction(String funcName, int nLocals) {

        var loopLabel = funcName + "_INIT_LOCALS_LOOP";
        var loopEndLabel = funcName + "_INIT_LOCALS_END";

        write("(" + funcName + ")" + "// initializa local variables");
        write(String.format("@%d", nLocals));
        write("D=A");
        write("@R13"); // temp
        write("M=D");
        write("(" + loopLabel + ")");
        write("@" + loopEndLabel);
        write("D;JEQ");
        write("@0");
        write("D=A");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");
        write("@R13");
        write("MD=M-1");
        write("@" + loopLabel);
        write("0;JMP");
        write("(" + loopEndLabel + ")");

    }

    void writeFramePush(String value) {
        write("@" + value);
        write("D=M");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");
    }

    void writeCall(String funcName, int numArgs) {

        /*
         * push return-address // (using the label declared below)
         * push LCL // save LCL of the calling function
         * push ARG // save ARG of the calling function
         * push THIS // save THIS of the calling function
         * push THAT // save THAT of the calling function
         * ARG = SP-n-5 // reposition ARG (n = number of args)
         * LCL = SP // reposiiton LCL
         * goto f // transfer control
         * (return-address) // declare a label for the return-address
         */

        var comment = String.format("// call %s %d", funcName, numArgs);

        var returnAddr = String.format("%s_RETURN_%d", funcName, callCount);
        callCount++;

        write(String.format("@%s %s", returnAddr, comment)); // push return-addr
        write("D=A");
        write("@SP");
        write("A=M");
        write("M=D");
        write("@SP");
        write("M=M+1");

        writeFramePush("LCL");
        writeFramePush("ARG");
        writeFramePush("THIS");
        writeFramePush("THAT");

        write(String.format("@%d", numArgs)); // ARG = SP-n-5
        write("D=A");
        write("@5");
        write("D=D+A");
        write("@SP");
        write("D=M-D");
        write("@ARG");
        write("M=D");

        write("@SP");// LCL = SP
        write("D=M");
        write("@LCL");
        write("M=D");

        writeGoto(funcName);

        write("(" + returnAddr + ")"); // (return-address)

    }

    void writeReturn() {

        /*
         * FRAME = LCL // FRAME is a temporary var
         * RET = *(FRAME-5) // put the return-address in a temporary var
         * ARG = pop() // reposition the return value for the caller
         * SP = ARG + 1 // restore SP of the caller
         * THAT = *(FRAME - 1) // restore THAT of the caller
         * THIS = *(FRAME - 2) // restore THIS of the caller
         * ARG = *(FRAME - 3) // restore ARG of the caller
         * LCL = *(FRAME - 4) // restore LCL of the caller
         * goto RET // goto return-address (in the caller's code)
         */

        write("@LCL"); // FRAME = LCL
        write("D=M");

        write("@R13"); // R13 -> FRAME
        write("M=D");

        write("@5");// RET = *(FRAME-5)
        write("A=D-A");
        write("D=M");
        write("@R14"); // R14 -> RET
        write("M=D");

        write("@SP");// *ARG = pop()
        write("AM=M-1");
        write("D=M");
        write("@ARG");
        write("A=M");
        write("M=D");

        write("D=A"); // SP = ARG+1
        write("@SP");
        write("M=D+1");

        write("@R13"); // THAT = *(FRAME-1)
        write("AM=M-1");
        write("D=M");
        write("@THAT");
        write("M=D");

        write("@R13");// THIS = *(FRAME-2)
        write("AM=M-1");
        write("D=M");
        write("@THIS");
        write("M=D");

        write("@R13"); // ARG = *(FRAME-3)
        write("AM=M-1");
        write("D=M");
        write("@ARG");
        write("M=D");

        write("@R13");// LCL = *(FRAME-4)
        write("AM=M-1");
        write("D=M");
        write("@LCL");
        write("M=D");

        write("@R14"); // goto RET
        write("A=M");
        write("0;JMP");

    }

    private void write(String s) {
        output.append(String.format("%s\n", s));
    }

    public String codeOutput() {
        return output.toString();
    }

    public void save() {

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(outputFileName);

            outputStream.write(output.toString().getBytes());

            outputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
