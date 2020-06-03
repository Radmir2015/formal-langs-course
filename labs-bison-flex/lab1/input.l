%option noyywrap yylineno

%{
#include "y.tab.h"
%}

digit [0-9]
hexdigit [a-f]
letter [a-zA-Z]

%%
"(" { return LPAR; }
")" { return RPAR; }
"\"" { return QUOTE; }
"," { return COMMA; }
";" { return SEMICOLON; }
"!" { return EXCLAM; }
"?" { return QUEST; }
"printf" { return PRINTF; }

{digit}({hexdigit}|{digit})* { return HEXNUMBER; }
{letter}({letter}|{digit})* { return IDENT; }

%%
int main(int argc, char **argv) {
  if (argc < 2) {
    printf("\nNot enough arguments. Please specify filename.\n");
    return -1;
  }
  if ((yyin = fopen(argv[1], "r")) == NULL) {
    printf("\nCannot open file %s.\n", argv[1]);
    return -1;
  }
  yylineno = 1;
  while (1) {
    int token = yylex();
    if (token == 0)
      break;
    printf("%d\n", token);
  }
  fclose(yyin);
  return 0;
}
