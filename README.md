## Formal languages course

##### Assembler interpreter ([see here](/assembler-emulator-antlr))

Example program:
```js
MOV A, 0;
MOV CX, [0];

cycle:
    CMP CX, 0;
    JE end;
    ADD A, [CX];
    DEC CX;
    JMP cycle;
end:
    PRINT A;
    ret;
```

##### Interpreter of a language ([see here](/practice-antlr))

Example program:
```pascal
x := 1;
y := not y;
print y;
z := (x or y) and not 0;
print z;

print 1 xor 0;
print (1 xor ((1 or 1 xor 0 and 1)));
print not 1 xor 0 and 1;
print (not 1 xor 0) and 1;
print not (1 xor 0) and 1;
```