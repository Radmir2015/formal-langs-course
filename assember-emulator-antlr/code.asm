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

pe: PRINT 123; JE end;

pp: PRINT 234;