grammar syntax;

program : line* EOF ;
line : print
     | assign
     ;

logExpr : LPAR logExpr RPAR # parens
        // | oper=('not' | 'NOT') logExpr # notOp
        | oper=NOT logExpr # notOp
        | logExpr oper=AND logExpr # andOp
        | logExpr oper=(OR | XOR) logExpr # orXorOp
        | ID # ident
        | INT # integer
        ;

NOT: 'not' | 'NOT';
AND: 'and' | 'AND';
OR: 'or' | 'OR';
XOR: 'xor' | 'XOR';

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

PRINT: 'PRINT' | 'print' | 'PRT' | 'prt';

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
WS  :   [ \r\n\t]+ -> skip ; // toss out whitespace

LPAR : '(';
RPAR : ')';

ASSIGN : ':=';
COL : ';';
