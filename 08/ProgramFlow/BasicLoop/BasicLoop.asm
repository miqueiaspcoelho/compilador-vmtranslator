@0 // push constant 0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL // pop local 0
D=M
@0
D=D+A
@R13
M=D
@SP
M=M-1
A=M
D=M
@R13
A=M
M=D
(LOOP_START)
@ARG // push argument 0
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@LCL // push local 0
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP // add
M=M-1
A=M
D=M
A=A-1
M=D+M
@LCL // pop local 0
D=M
@0
D=D+A
@R13
M=D
@SP
M=M-1
A=M
D=M
@R13
A=M
M=D
@ARG // push argument 0
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@1 // push constant 1
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // sub
M=M-1
A=M
D=M
A=A-1
M=M-D
@ARG // pop argument 0
D=M
@0
D=D+A
@R13
M=D
@SP
M=M-1
A=M
D=M
@R13
A=M
M=D
@ARG // push argument 0
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
AM=M-1
D=M
M=0
@LOOP_START
D;JNE
@LCL // push local 0
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
