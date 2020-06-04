grammar syntax;

prog : stat+ EOF ;
stat : block | (lab block) ;
block: line+ ;
line : mov | cmp | add | dec | je | jmp | jg| prt | ret ;
lab : labelName=ID ':'? ;

mov : MOV toId=ID ',' fromId=ID COL 
    | MOV toId=ID ',' fromInt=INT COL 
    | MOV toId=ID ',' '[' fromIdAddress=ID ']' COL 
    | MOV toId=ID ',' '[' fromIntAddress=INT ']' COL 
    | MOV '[' toIdAddress=ID ']' ',' fromId=ID COL 
    | MOV '[' toIdAddress=ID ']' ',' fromInt=INT COL 
    | MOV '[' toIdAddress=ID ']' ',' '[' fromIdAddress=ID ']' COL 
    | MOV '[' toIdAddress=ID ']' ',' '[' fromIntAddress=INT ']' COL ;

add : ADD toId=ID ',' fromId=ID COL 
    | ADD toId=ID ',' fromInt=INT COL 
    | ADD toId=ID ',' '[' fromIdAddress=ID ']' COL 
    | ADD toId=ID ',' '[' fromIntAddress=INT ']' COL 
    | ADD '[' toIdAddress=ID ']' ',' fromId=ID COL 
    | ADD '[' toIdAddress=ID ']' ',' fromInt=INT COL 
    | ADD '[' toIdAddress=ID ']' ',' '[' fromIdAddress=ID ']' COL 
    | ADD '[' toIdAddress=ID ']' ',' '[' fromIntAddress=INT ']' COL ;

cmp : CMP a=(ID | INT) ',' b=(ID | INT) COL 
    | CMP '[' addressA=(ID | INT) ']' ',' b=(ID | INT) COL
    | CMP a=(ID | INT) ',' '[' addressB=(ID | INT) ']' COL
    | CMP '[' addressA=(ID | INT) ']' ',' '[' addressB=(ID | INT) ']' COL ;

dec : DEC var=ID COL ;

je : JE labelName=lab COL ;
jmp : JMP labelName=lab COL ;
jg : JG labelName=lab COL ;

prt : PRT a=(ID | INT) COL ;

ret : RET COL ;


MOV : 'MOV' | 'mov' ;
ADD : 'ADD' | 'add' ;
CMP : 'CMP' | 'cmp' ;
DEC : 'DEC' | 'dec' ;

JE : 'JE' | 'je';
JMP: 'JMP' | 'jmp';
JG : 'JG' | 'jg';

PRT: 'PRINT' | 'print' | 'PRT' | 'prt' ;
RET: 'ret' | 'RET' ;

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
// NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \r\n\t]+ -> skip ; // toss out whitespace
COL : ';' ;