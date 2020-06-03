%option noyywrap yylineno

%{
  #include "y.tab.h"
%}

digit [0-9]
hexdigit [a-f]
letter [a-zA-Z]
marks [\?\!\,]

%%
"+" { return PLUS; }
"-" { return MINUS; }
"/" { return SLASH; }
"*" { return TIMES; }
"=" { return BECOMES; }
"(" { return LPAR; }
")" { return RPAR; }
"'"[^']*"'" { return LITERAL; }
"\""[^\"]*"\"" { return LITERAL; }
"," { return COMMA; }
";" { return SEMICOLON; }
"!" { return EXCLAM; }
"?" { return QUEST; }
"printf" { return PRINTF; }

"0x"({hexdigit}|{digit})* { return HEXNUM; }
{letter}({letter}|{digit})* { return IDENT; }

%%
