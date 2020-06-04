mov cx, [0]; mov ax, [0]; mov bx, [cx]; mov ibx, cx;

cycle:
    cmp cx, 0;
    je iter;

    dec cx;

    cmp cx, 0;
    je iter;

    cmp [cx], bx;
    jg assign;

    jmp cycle;

iter:
    cmp ax, 0;
    je end;
    jmp swap;
    dec ax;

    mov cx, ax;
    mov bx, [cx];
    mov ibx, ax;

    jmp cycle;

end:
    ret;

assign:
    mov bx, [cx];
    mov ibx, cx;

swap:
    mov temp, [ax];
    mov [ax], bx;
    mov [ibx], temp;