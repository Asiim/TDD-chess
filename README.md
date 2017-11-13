# TDD-chess
chess implemented using TDD in java

Rules:
https://www.chess.com/learn-how-to-play-chess

# Tests:
### Table tests:
- ~~Square init~~
- ~~Set color of square black~~
- ~~Set color of square white~~
- ~~Make color in Square private~~
- ~~Set pawn on square~~
- ~~Make pawn private~~
- ~~Set rook on square~~
- ~~Make rook private~~
- ~~Pawn/Rook duplication in square~~
- ~~Table init~~
- ~~Check table size~~
- ~~Init squares in table~~
- ~~Make square private in class Table~~
- ~~Init black square~~
- ~~Init white square~~
- ~~Set color of square on position [0,0] to BLACK~~
- ~~Set every square on position [x,y] where (x + y) % 2 == 0  to BLACK~~
- ~~Set every square on position [x,y] where (x + y) % 2 == 1  to WHITE~~
- ~~Set square color in table~~
- ~~Set a figure on the table~~
- ~~Set two figures on different squares~~
- ~~Prevent setting two figures on the same square~~
- ~~Set all figures of one player on table in defined order on table init~~
- ~~Set all figures of both player on table in defined order on table init~~
- Rotate table
- Prevent figure to go out of table

### Pawn tests:
- ~~Pawn init~~
- ~~Black pawn init~~
- ~~White pawn init~~
- ~~Enable pawn to keep track of its position~~
- ~~Pawn with start position init~~
- Move pawn one field forward (field in front of pawn empty)
- Prevent pawn from moving one field forward (figure in front of pawn)
- Move pawn two field forward for the very first move (fields on the way empty)
- Move pawn one field forward for the very first move (fields on the way empty)
- Prevent pawn from moving two field forward if not the very first move
- Prevent pawn from moving two field formawrd for the very first move (on destination is a figure)
- Prevent pawn from moving two field formawrd for the very first move (in front of pawn is a figure)
- Move pawn one field diagonaly forward (enemy field on the destination)
- Prevent pawn from moving one field diagonaly forward (destination field empty)
- Prevent pawn from moving one field diagonaly forward (ally figure on the destination)
- "En passat"

### Rook tests:
- ~~Rook init~~
- ~~Black rook init~~
- ~~White rook init~~
- ~~Enable rook to keep track of its position~~
- ~~Rook with start position init~~
- Move rook one field vertical on empty field
- Move rook one field horizontal on empty field
- Move rook n fields vertical (all field on the way are empty)
- Move rook n fields horizontal (all fields on the way are empty)
- Prevent rook from moving n fields vertical (next to rook vertical is a figure)
- Prevent rook from moving n fields horizontal (next to rook horizontal is a figure)
- Prevent rook from moving n fields vertical (on the way are figures)
- Prevent rook from moving n fields horizontal (on the way are figures)
- Move rook n fields vertical (on the destination is enemy figure)
- Move rook n fields horizontal (on the destination is enemy figure)
- Prevent rook from moving n fields vertical (on the destination is friendly figure)
- Prevent rook from moving n fields horizontal (on the destination is friendly figure)

### Knight tests:
- ~~Knight init~~
- ~~Black knight init~~
- ~~White knight init~~
- ~~Enable knight to keep track of its position~~
- ~~Knight with start position init~~
- Move knight where vertical position changes for 2 fields and horizontal one field (destination empty)
- Move knight where vertical position changes for one field and horizontal 2 fields (destination empty)
- Move knight where vertical position changes for 2 fields and horizontal one field (enemy on destination)
- Move knight where vertical position changes for one field and horizontal 2 fields (enemy on destination)
- Prevent knight from moving where vertical position changes for 2 fields and horizontal one field (ally on destination)
- Prevent knight from moving where vertical position changes for one field and horizontal 2 fields (ally on destination)
- Move knight

### Bishop tests:
- ~~Bishop init~~
- ~~Black bishop init~~
- ~~White bishop init~~
- ~~Enable bishop to keep track of its position~~
- ~~Bishop with start position init~~
- Move bishop one field diagonaly (y grows whit x)
- Move bishop one field diagonaly (y falls whit x)
- Move bishop n fields diagonaly (y grows whit x, all fields on the way are empty)
- Move bishop n fields diagonaly (y falls whit x, all fields on the way are empty)
- Prevent bishop from moving n fields diagonaly (y grows whit x, next to bishop is a figure)
- Prevent bishop from moving n fields diagonaly (y falls whit x, next to bishop is a figure)
- Prevent bishop from moving n fields diagonaly (y grows whit x, on the way are figures)
- Prevent bishop from moving n fields diagonaly (y falls whit x, on the way are figures)
- Move bishop n fields diagonaly (y grows whit x, enemy figure on destination)
- Move bishop n fields diagonaly (y falls whit x, enemy figure on destination)
- Prevent bishop from moving n fields diagonaly (y grows whit x, friendly figure on destination)
- Prevent bishop from moving n fields diagonaly (y falls whit x, friendly figure on destination)

### Queen tests:
- ~~Queen init~~
- ~~Black queen init~~
- ~~White queen init~~
- ~~Enable queen to keep track of its position~~
- ~~Queen with start position init~~
- Move queen one field vertical on empty field
- Move queen one field horizontal on empty field
- Move queen n fields vertical (all field on the way are empty)
- Move queen n fields horizontal (all fields on the way are empty)
- Prevent queen from moving n fields vertical (next to queen vertical is a figure)
- Prevent queen from moving n fields horizontal (next to queen horizontal is a figure)
- Prevent queen from moving n fields vertical (on the way are figures)
- Prevent queen from moving n fields horizontal (on the way are figures)
- Move queen n fields vertical (on the destination is enemy figure)
- Move queen n fields horizontal (on the destination is enemy figure)
- Prevent queen from moving n fields vertical (on the destination is friendly figure)
- Prevent queen from moving n fields horizontal (on the destination is friendly figure)
- Move queen one field diagonaly (y grows whit x)
- Move queen one field diagonaly (y falls whit x)
- Move queen n fields diagonaly (y grows whit x, all fields on the way are empty)
- Move queen n fields diagonaly (y falls whit x, all fields on the way are empty)
- Prevent queen from moving n fields diagonaly (y grows whit x, next to queen is a figure)
- Prevent queen from moving n fields diagonaly (y falls whit x, next to queen is a figure)
- Prevent queen from moving n fields diagonaly (y grows whit x, on the way are figures)
- Prevent queen from moving n fields diagonaly (y falls whit x, on the way are figures)
- Move queen n fields diagonaly (y grows whit x, enemy figure on destination)
- Move queen n fields diagonaly (y falls whit x, enemy figure on destination)
- Prevent queen from moving n fields diagonaly (y grows whit x, friendly figure on destination)
- Prevent queen from moving n fields diagonaly (y falls whit x, friendly figure on destination)

### King tests:
- ~~King init~~
- ~~Black king init~~
- ~~White king init~~
- ~~Enable king to keep track of its position~~
- ~~King with start position init~~
- Move king one field horizontaly (destination empty)
- Move king one field verticaly (destination empty)
- Move king one field diagonaly (destination empty)
- Prevent king from moving one field horizontaly (ally on destination)
- Prevent king from moving one field verticaly (ally on destination)
- Prevent king from moving one field diagonaly (ally on destination)
- Prevent king from moving on a field that is occupied by rook
- Prevent king from moving on a field that is occupied by bishop
- Prevent king from moving on a field that is occupied by queen
- Prevent king from moving on a field that is occupied by knight
- Prevent king from moving on a field that is occupied by pawn
- Move king on a field that is not occupied (enemy on destination)
- King blocked
- King atacked

### Figure tests:
- ~~Figure init~~
- ~~Black figure init~~
- ~~White figure init~~
- ~~Enable figure to keep track of its position~~
- ~~Figure with start position init~~

### Rules tests:
- ~~2 type of figures (white, black)~~
- White side starts first
- Draw
- Checkmate
- Promote a pawn (change pawn with another figure)
