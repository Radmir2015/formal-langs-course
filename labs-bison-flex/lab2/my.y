%{
#include <stdio.h>
extern FILE *yyin;
extern int yylineno;
extern char *yytext;
void yyerror(char *);
extern int yylex(void);
%}

%token SEMICOLON BECOMES PLUS MINUS TIMES SLASH LPAR RPAR HEXNUM IDENT UNKNOWN LITERAL COMMA EXCLAM QUEST PRINTF

%%

program: statement | program statement { printf("\nprogram\n"); }
statement: expr SEMICOLON { printf("\nstatement\n"); }
	 | print_statement SEMICOLON { printf("\nprintf\n"); }
expr: IDENT BECOMES expr_cmp { printf("\nassign\n"); }

expr_cmp:
	prim_expr PLUS prim_expr
	| prim_expr MINUS prim_expr
	| prim_expr TIMES prim_expr
	| prim_expr SLASH prim_expr
	| prim_expr { printf("\nexpression\n"); }
prim_expr: IDENT | HEXNUM |
	 | LPAR expr_cmp RPAR { printf("\nprimary expression\n"); }

print_statement: PRINTF LPAR expr_cmp RPAR { printf("\nprint expr\n"); }
	       | PRINTF LPAR LITERAL RPAR { printf("\nprint literal\n"); }

%%
void yyerror(char *errmsg) {
  fprintf(stderr, "%s (%d): %s\n", errmsg, yylineno, yytext);
}

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("\nNot enough arguments. Please specify filename. \n");
    return -1;
  }
  if ((yyin = fopen(argv[1], "r")) == NULL) {
    printf("\nCannot open file %s.\n", argv[1]);
    return -1;
  }
  yylineno = 1;
  yyparse();
  return 0;
}
