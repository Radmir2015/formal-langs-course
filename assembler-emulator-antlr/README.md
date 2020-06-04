## Assembler Interpreter
See all steps detailed in [practice-antlr](../practice-antlr/README.md).

#### Preparations and explanations

Now we will use listener-handler classes. Generating listeners:
```batch
java -jar .\antlr-4.7.2-complete.jar -Dlanguage=Python3 -listener syntax.g4
```

Also we'll try another way: an integration main ANTLR function (for running lexer->parser stream) with all parser handler functions in one file ([pseudo.py](pseudo.py)).

We have "memory" of interpreter: all variable names, their values, input array, labels, flags, etc.
We also have counter of the (running) commands (operators).
```python
ID_TOKEN = 14
INT_TOKEN = 15

VERBOSE = False

memory = {
    'input': [5, -99, 2123, 0, -444, 3],
    'flags': {
        'equal': False,
        'greater': False
        },
    'labels': {},
    'vars': {}
    }

PC = {}
CX = 1
```

It's working interesting way, not like actual assembler does.
It traverses through main scope and jumps (traverse) through all labels (if any). So you need to finish your program with ret (return) operator or EOF (only if you are not in any labels, else you will be turned back to all "recursive label calls" to finish them first).
First it searches and saves ContextObjects for all labels in given program. When it faces with a jump to a label it pastes BlockContext (block (part) of code) to the main runtime flow (I know that's weird for assembler).
Because of pasting contexts (by reference) we get the same line and start position of an operator (for the same operator, no matter the actual gotten (runtime) program line numbers). We use simple dictionary. If we already have a value in it (key is (contextBlock) line (number), column position of an operator), pc function returns it, if not it increments CX and update the value.

Use VERBOSE to see all variables (registers), PC, flags, command name through each operator.

#### Running examples
To run the interpreter use:
```batch
python .\pseudo.py code.asm
```

**First example** ([code.asm](code.asm) - sum of given array, [0] - size):
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
Verbose = false
```batch
1583
```

Verbose = true
```python
assember-emulator-antlr> python .\pseudo.py code.asm
start_memory {'input': [5, -99, 2123, 0, -444, 3], 'flags': {'equal': False, 'greater': False}, 'labels': {'cycle': [<syntaxParser.syntaxParser.BlockContext object at 0x02E59710>], 'end': [<syntaxParser.syntaxParser.BlockContext object at 0x02E6CB50>]}, 'vars': {}}

PC = 1 mov {'from': {'address': None, 'value': 0}, 'to': {'address': 'A', 'value': None}, 'result': 0}

        РЕГИСТРЫ = {'A': 0}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 2 mov {'from': {'address': '[0]', 'value': 5}, 'to': {'address': 'CX', 'value': None}, 'result': 5}

        РЕГИСТРЫ = {'A': 0, 'CX': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': 0, 'CX': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': 0, 'CX': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 5 add {'from': {'address': '[CX( = 5)]', 'value': 3}, 'to': {'address': 'A', 'value': 0}, 'result': 3}

        РЕГИСТРЫ = {'A': 3, 'CX': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 6 dec CX => CX = 4

        РЕГИСТРЫ = {'A': 3, 'CX': 4}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 7 jmp cycle

        РЕГИСТРЫ = {'A': 3, 'CX': 4}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': 3, 'CX': 4}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': 3, 'CX': 4}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 5 add {'from': {'address': '[CX( = 4)]', 'value': -444}, 'to': {'address': 'A', 'value': 3}, 'result': -441}

        РЕГИСТРЫ = {'A': -441, 'CX': 4}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 6 dec CX => CX = 3

        РЕГИСТРЫ = {'A': -441, 'CX': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 7 jmp cycle

        РЕГИСТРЫ = {'A': -441, 'CX': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': -441, 'CX': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': -441, 'CX': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 5 add {'from': {'address': '[CX( = 3)]', 'value': 0}, 'to': {'address': 'A', 'value': -441}, 'result': -441}

        РЕГИСТРЫ = {'A': -441, 'CX': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 6 dec CX => CX = 2

        РЕГИСТРЫ = {'A': -441, 'CX': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 7 jmp cycle

        РЕГИСТРЫ = {'A': -441, 'CX': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': -441, 'CX': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': -441, 'CX': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 5 add {'from': {'address': '[CX( = 2)]', 'value': 2123}, 'to': {'address': 'A', 'value': -441}, 'result': 1682}

        РЕГИСТРЫ = {'A': 1682, 'CX': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 6 dec CX => CX = 1

        РЕГИСТРЫ = {'A': 1682, 'CX': 1}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 7 jmp cycle

        РЕГИСТРЫ = {'A': 1682, 'CX': 1}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': 1682, 'CX': 1}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': 1682, 'CX': 1}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 5 add {'from': {'address': '[CX( = 1)]', 'value': -99}, 'to': {'address': 'A', 'value': 1682}, 'result': 1583}

        РЕГИСТРЫ = {'A': 1583, 'CX': 1}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 6 dec CX => CX = 0

        РЕГИСТРЫ = {'A': 1583, 'CX': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 7 jmp cycle

        РЕГИСТРЫ = {'A': 1583, 'CX': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 3 cmp

        РЕГИСТРЫ = {'A': 1583, 'CX': 0}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 4 je end

        РЕГИСТРЫ = {'A': 1583, 'CX': 0}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]


PC = 8 OUTPUT: 1583
end_memory {'input': [5, -99, 2123, 0, -444, 3], 'flags': {'equal': True, 'greater': False}, 'labels': {'cycle': [<syntaxParser.syntaxParser.BlockContext object at 0x02E59710>], 'end': [<syntaxParser.syntaxParser.BlockContext object at 0x02E6CB50>]}, 'vars': {'A': 1583, 'CX': 0}}
```

**Second example** ([sort.asm](sort.asm) - to sort given array):
```js
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
```

Verbose = false (you can watch the elements swap)
```python
assember-emulator-antlr> python .\pseudo.py sort.asm
start_memory {'input': [5, -99, 2123, 0, -444, 3], 'flags': {'equal': False, 'greater': False}, 'labels': {'cycle': [<syntaxParser.syntaxParser.BlockContext object at 0x02DED1D0>], 'iter': [<syntaxParser.syntaxParser.BlockContext object at 0x02DFEB90>], 'end': [<syntaxParser.syntaxParser.BlockContext object at 0x02DEFB70>], 'assign': [<syntaxParser.syntaxParser.BlockContext object at 0x02DEF210>], 'swap': [<syntaxParser.syntaxParser.BlockContext object at 0x02DEF7D0>]}, 'vars': {}}

PC = 1 mov {'from': {'address': '[0]', 'value': 5}, 'to': {'address': 'cx', 'value': None}, 'result': 5}

        РЕГИСТРЫ = {'cx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 2 mov {'from': {'address': '[0]', 'value': 5}, 'to': {'address': 'ax', 'value': None}, 'result': 5}

        РЕГИСТРЫ = {'cx': 5, 'ax': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 3 mov {'from': {'address': '[cx( = 5)]', 'value': 3}, 'to': {'address': 'bx', 'value': None}, 'result': 3}

        РЕГИСТРЫ = {'cx': 5, 'ax': 5, 'bx': 3}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 4 mov {'from': {'address': 'cx', 'value': 5}, 'to': {'address': 'ibx', 'value': None}, 'result': 5}

        РЕГИСТРЫ = {'cx': 5, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 5, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 5, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 7 dec cx => cx = 4

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 4, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 7 dec cx => cx = 3

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 3, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 7 dec cx => cx = 2

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 3, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 13 mov {'from': {'address': '[cx( = 2)]', 'value': 2123}, 'to': {'address': 'bx', 'value': 3}, 'result': 2123}

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 2123, 'ibx': 5}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 14 mov {'from': {'address': 'cx', 'value': 2}, 'to': {'address': 'ibx', 'value': 5}, 'result': 2}

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 7 dec cx => cx = 1

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 7 dec cx => cx = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 17 jmp swap

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 18 mov {'from': {'address': '[ax( = 5)]', 'value': 3}, 'to': {'address': 'temp', 'value': None}, 'result': 3}

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 3]

PC = 19 mov {'from': {'address': 'bx', 'value': 2123}, 'to': {'address': '[ax( = 5)]', 'value': 3}, 'result': 2123}

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 2123, 0, -444, 2123]

PC = 20 mov {'from': {'address': 'temp', 'value': 3}, 'to': {'address': '[ibx( = 2)]', 'value': 2123}, 'result': 3}

        РЕГИСТРЫ = {'cx': 0, 'ax': 5, 'bx': 2123, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 21 dec ax => ax = 4

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 2123, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 22 mov {'from': {'address': 'ax', 'value': 4}, 'to': {'address': 'cx', 'value': 0}, 'result': 4}

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': 2123, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 23 mov {'from': {'address': '[cx( = 4)]', 'value': -444}, 'to': {'address': 'bx', 'value': 2123}, 'result': -444}

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': -444, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 24 mov {'from': {'address': 'ax', 'value': 4}, 'to': {'address': 'ibx', 'value': 2}, 'result': 4}

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 25 jmp cycle

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 4, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 7 dec cx => cx = 3

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': -444, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 13 mov {'from': {'address': '[cx( = 3)]', 'value': 0}, 'to': {'address': 'bx', 'value': -444}, 'result': 0}

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': 0, 'ibx': 4, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 14 mov {'from': {'address': 'cx', 'value': 3}, 'to': {'address': 'ibx', 'value': 4}, 'result': 3}

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 3, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 7 dec cx => cx = 2

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 0, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 13 mov {'from': {'address': '[cx( = 2)]', 'value': 3}, 'to': {'address': 'bx', 'value': 0}, 'result': 3}

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 3, 'ibx': 3, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 14 mov {'from': {'address': 'cx', 'value': 2}, 'to': {'address': 'ibx', 'value': 3}, 'result': 2}

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 7 dec cx => cx = 1

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 7 dec cx => cx = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 17 jmp swap

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': 3}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 18 mov {'from': {'address': '[ax( = 4)]', 'value': -444}, 'to': {'address': 'temp', 'value': 3}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, -444, 2123]

PC = 19 mov {'from': {'address': 'bx', 'value': 3}, 'to': {'address': '[ax( = 4)]', 'value': -444}, 'result': 3}

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, 3, 0, 3, 2123]

PC = 20 mov {'from': {'address': 'temp', 'value': -444}, 'to': {'address': '[ibx( = 2)]', 'value': 3}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 4, 'bx': 3, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 21 dec ax => ax = 3

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 3, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 22 mov {'from': {'address': 'ax', 'value': 3}, 'to': {'address': 'cx', 'value': 0}, 'result': 3}

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 3, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 23 mov {'from': {'address': '[cx( = 3)]', 'value': 0}, 'to': {'address': 'bx', 'value': 3}, 'result': 0}

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 0, 'ibx': 2, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 24 mov {'from': {'address': 'ax', 'value': 3}, 'to': {'address': 'ibx', 'value': 2}, 'result': 3}

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 25 jmp cycle

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 3, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 7 dec cx => cx = 2

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 7 dec cx => cx = 1

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 7 dec cx => cx = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 17 jmp swap

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 18 mov {'from': {'address': '[ax( = 3)]', 'value': 0}, 'to': {'address': 'temp', 'value': -444}, 'result': 0}

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 19 mov {'from': {'address': 'bx', 'value': 0}, 'to': {'address': '[ax( = 3)]', 'value': 0}, 'result': 0}

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 20 mov {'from': {'address': 'temp', 'value': 0}, 'to': {'address': '[ibx( = 3)]', 'value': 0}, 'result': 0}

        РЕГИСТРЫ = {'cx': 0, 'ax': 3, 'bx': 0, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 21 dec ax => ax = 2

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': 0, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 22 mov {'from': {'address': 'ax', 'value': 2}, 'to': {'address': 'cx', 'value': 0}, 'result': 2}

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': 0, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 23 mov {'from': {'address': '[cx( = 2)]', 'value': -444}, 'to': {'address': 'bx', 'value': 0}, 'result': -444}

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': -444, 'ibx': 3, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 24 mov {'from': {'address': 'ax', 'value': 2}, 'to': {'address': 'ibx', 'value': 3}, 'result': 2}

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 25 jmp cycle

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 2, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 7 dec cx => cx = 1

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 10 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 11 jg assign

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -444, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 13 mov {'from': {'address': '[cx( = 1)]', 'value': -99}, 'to': {'address': 'bx', 'value': -444}, 'result': -99}

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -99, 'ibx': 2, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 14 mov {'from': {'address': 'cx', 'value': 1}, 'to': {'address': 'ibx', 'value': 2}, 'result': 1}

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 12 jmp cycle

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 7 dec cx => cx = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 17 jmp swap

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': 0}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 18 mov {'from': {'address': '[ax( = 2)]', 'value': -444}, 'to': {'address': 'temp', 'value': 0}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -444, 0, 3, 2123]

PC = 19 mov {'from': {'address': 'bx', 'value': -99}, 'to': {'address': '[ax( = 2)]', 'value': -444}, 'result': -99}

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -99, -99, 0, 3, 2123]

PC = 20 mov {'from': {'address': 'temp', 'value': -444}, 'to': {'address': '[ibx( = 1)]', 'value': -99}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 2, 'bx': -99, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 21 dec ax => ax = 1

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -99, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 22 mov {'from': {'address': 'ax', 'value': 1}, 'to': {'address': 'cx', 'value': 0}, 'result': 1}

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -99, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 23 mov {'from': {'address': '[cx( = 1)]', 'value': -444}, 'to': {'address': 'bx', 'value': -99}, 'result': -444}

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 24 mov {'from': {'address': 'ax', 'value': 1}, 'to': {'address': 'ibx', 'value': 1}, 'result': 1}

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 25 jmp cycle

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 1, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 7 dec cx => cx = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 8 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 9 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 17 jmp swap

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 18 mov {'from': {'address': '[ax( = 1)]', 'value': -444}, 'to': {'address': 'temp', 'value': -444}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 19 mov {'from': {'address': 'bx', 'value': -444}, 'to': {'address': '[ax( = 1)]', 'value': -444}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 20 mov {'from': {'address': 'temp', 'value': -444}, 'to': {'address': '[ibx( = 1)]', 'value': -444}, 'result': -444}

        РЕГИСТРЫ = {'cx': 0, 'ax': 1, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 21 dec ax => ax = 0

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 22 mov {'from': {'address': 'ax', 'value': 0}, 'to': {'address': 'cx', 'value': 0}, 'result': 0}

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': -444, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 23 mov {'from': {'address': '[cx( = 0)]', 'value': 5}, 'to': {'address': 'bx', 'value': -444}, 'result': 5}

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 1, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 24 mov {'from': {'address': 'ax', 'value': 0}, 'to': {'address': 'ibx', 'value': 1}, 'result': 0}

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 25 jmp cycle

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': False, 'greater': True}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 5 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 6 je iter

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 15 cmp

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

PC = 16 je end

        РЕГИСТРЫ = {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}
        ФЛАГИ = {'equal': True, 'greater': False}
        ВВОД = [5, -444, -99, 0, 3, 2123]

end_memory {'input': [5, -444, -99, 0, 3, 2123], 'flags': {'equal': True, 'greater': False}, 'labels': {'cycle': [<syntaxParser.syntaxParser.BlockContext object at 0x02E1D1B0>], 'iter': [<syntaxParser.syntaxParser.BlockContext object at 0x02E2EBF0>], 'end': [<syntaxParser.syntaxParser.BlockContext object at 0x02E1F830>], 'assign': [<syntaxParser.syntaxParser.BlockContext object at 0x02E1F0D0>], 'swap': [<syntaxParser.syntaxParser.BlockContext object at 0x02E1F7D0>]}, 'vars': {'cx': 0, 'ax': 0, 'bx': 5, 'ibx': 0, 'temp': -444}}
```
