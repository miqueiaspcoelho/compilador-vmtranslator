@256
D=A
@SP
M=D
@Sys.init_RETURN_0 // call Sys.init 0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@0
D=A
@5
D=D+A
@SP
D=M-D
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(Sys.init_RETURN_0)
(Sys.init)// initializa local variables
@0
D=A
@R13
M=D
(Sys.init_INIT_LOCALS_LOOP)
@Sys.init_INIT_LOCALS_END
D;JEQ
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
@R13
MD=M-1
@Sys.init_INIT_LOCALS_LOOP
0;JMP
(Sys.init_INIT_LOCALS_END)
@4000 // push constant 4000
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 0
M=M-1
A=M
D=M
@R3
M=D
@5000 // push constant 5000
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 1
M=M-1
A=M
D=M
@R4
M=D
@Sys.main_RETURN_1 // call Sys.main 0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@0
D=A
@5
D=D+A
@SP
D=M-D
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.main
0;JMP
(Sys.main_RETURN_1)
@SP // pop temp 1
M=M-1
A=M
D=M
@R6
M=D
(LOOP)
@LOOP
0;JMP
(Sys.main)// initializa local variables
@5
D=A
@R13
M=D
(Sys.main_INIT_LOCALS_LOOP)
@Sys.main_INIT_LOCALS_END
D;JEQ
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
@R13
MD=M-1
@Sys.main_INIT_LOCALS_LOOP
0;JMP
(Sys.main_INIT_LOCALS_END)
@4001 // push constant 4001
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 0
M=M-1
A=M
D=M
@R3
M=D
@5001 // push constant 5001
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 1
M=M-1
A=M
D=M
@R4
M=D
@200 // push constant 200
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL // pop local 1
D=M
@1
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
@40 // push constant 40
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL // pop local 2
D=M
@2
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
@6 // push constant 6
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL // pop local 3
D=M
@3
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
@123 // push constant 123
D=A
@SP
A=M
M=D
@SP
M=M+1
@Sys.add12_RETURN_2 // call Sys.add12 1
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@1
D=A
@5
D=D+A
@SP
D=M-D
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.add12
0;JMP
(Sys.add12_RETURN_2)
@SP // pop temp 0
M=M-1
A=M
D=M
@R5
M=D
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
@LCL // push local 1
D=M
@1
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@LCL // push local 2
D=M
@2
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@LCL // push local 3
D=M
@3
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@LCL // push local 4
D=M
@4
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
@SP // add
M=M-1
A=M
D=M
A=A-1
M=D+M
@SP // add
M=M-1
A=M
D=M
A=A-1
M=D+M
@SP // add
M=M-1
A=M
D=M
A=A-1
M=D+M
@LCL
D=M
@R13
M=D
@5
A=D-A
D=M
@R14
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
D=A
@SP
M=D+1
@R13
AM=M-1
D=M
@THAT
M=D
@R13
AM=M-1
D=M
@THIS
M=D
@R13
AM=M-1
D=M
@ARG
M=D
@R13
AM=M-1
D=M
@LCL
M=D
@R14
A=M
0;JMP
(Sys.add12)// initializa local variables
@0
D=A
@R13
M=D
(Sys.add12_INIT_LOCALS_LOOP)
@Sys.add12_INIT_LOCALS_END
D;JEQ
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
@R13
MD=M-1
@Sys.add12_INIT_LOCALS_LOOP
0;JMP
(Sys.add12_INIT_LOCALS_END)
@4002 // push constant 4002
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 0
M=M-1
A=M
D=M
@R3
M=D
@5002 // push constant 5002
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop pointer 1
M=M-1
A=M
D=M
@R4
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
@12 // push constant 12
D=A
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
@LCL
D=M
@R13
M=D
@5
A=D-A
D=M
@R14
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
D=A
@SP
M=D+1
@R13
AM=M-1
D=M
@THAT
M=D
@R13
AM=M-1
D=M
@THIS
M=D
@R13
AM=M-1
D=M
@ARG
M=D
@R13
AM=M-1
D=M
@LCL
M=D
@R14
A=M
0;JMP
