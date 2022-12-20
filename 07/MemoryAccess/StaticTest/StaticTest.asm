@111 // push constant 111
D=A
@SP
A=M
M=D
@SP
M=M+1
@333 // push constant 333
D=A
@SP
A=M
M=D
@SP
M=M+1
@888 // push constant 888
D=A
@SP
A=M
M=D
@SP
M=M+1
@SP // pop static 8
M=M-1
A=M
D=M
@Main.8
M=D
@SP // pop static 3
M=M-1
A=M
D=M
@Main.3
M=D
@SP // pop static 1
M=M-1
A=M
D=M
@Main.1
M=D
@Main.3 // push static 3
D=M
@SP
A=M
M=D
@SP
M=M+1
@Main.1 // push static 1
D=M
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
@Main.8 // push static 8
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
