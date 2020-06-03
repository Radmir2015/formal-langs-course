grammar syntax;

program : line* EOF ;
line : print
     | assign
     ;

logExpr : LPAR logExpr RPAR # parens
        | oper='not' logExpr # notOp
        | logExpr oper='and' logExpr # andOp
        | logExpr oper=('or' | 'xor') logExpr # orXorOp
        | ID # ident
        | INT # integer
        ;

// logExpr : LPAR logExpr RPAR # parens
//         | unaryExpr # un ;
        // | binaryExpr # bin ;

// sumExpr : sumExpr oper=sumOps productExpr # sumOp
//         | productExpr # toProductExpr;

// productExpr : productExpr oper='and' unaryExpr # mulOp
//             | unaryExpr # toUnaryExpr;

// unaryExpr : oper='not' unaryExpr # unaryOp
//           | atom # toAtom ;

// atom : ID # ident
//      | INT # integer
//      | LPAR sumExpr RPAR # parens;

print : PRINT ID COL # printId
    | PRINT logExpr COL # printExpr
    ;
assign : ID ASSIGN logExpr COL # assignExpr;

// sumOps : OR | XOR ;
// mulOps : AND ;
// unaryOps : NOT;

PRINT: 'PRINT' | 'print' | 'PRT' | 'prt';

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
WS  :   [ \r\n\t]+ -> skip ; // toss out whitespace

// CONST0 : '0';
// CONST1 : '1';

LPAR : '(';
RPAR : ')';

OR : 'OR' | 'or';
XOR : 'XOR' | 'xor';
AND : 'AND' | 'and';
// BINARY : OR | XOR | AND;

NOT : 'NOT' | 'not';

ASSIGN : ':=';
COL : ';';
