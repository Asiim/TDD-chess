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
- ~~Set rock on square~~
- ~~Make rock private~~
- ~~Pawn/Rock duplication in square~~
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
- Prevent figure to go out of table

### Pawn tests:
- ~~Pawn init~~
- ~~Black pawn init~~
- ~~White pawn init~~
- ~~Enable pawn to keep track of its position~~
- ~~Pawn with start position init~~
- Move pawn one field forward
- Move pawn two field forward for the very first move
- Move pawn one field forward for the very first move
- Capture with pawn
- Pawn blocked by ally figure
- Pawn blocked by enemy figure in front
- "En passat"

### Rook tests:
- ~~Rook init~~
- ~~Black rook init~~
- ~~White rook init~~
- ~~Enable rook to keep track of its position~~
- ~~Rook with start position init~~
- Move rock vertical
- Move rock horizontal
- Capture with rock
- Rock blocked by ally figure

### Knight tests:
- ~~Knight init~~
- ~~Black knight init~~
- ~~White knight init~~
- ~~Enable knight to keep track of its position~~
- ~~Knight with start position init~~
- Move knight

### Bishop tests:
- ~~Bishop init~~
- ~~Black bishop init~~
- ~~White bishop init~~
- ~~Enable bishop to keep track of its position~~
- ~~Bishop with start position init~~
- Move bishop diagonal

### Queen tests:
- ~~Queen init~~
- ~~Black queen init~~
- ~~White queen init~~
- ~~Enable queen to keep track of its position~~
- ~~Queen with start position init~~
- Move queen diagonal
- Move queen horizontal
- Move queen vertical

### King tests:
- ~~King init~~
- ~~Black king init~~
- ~~White king init~~
- ~~Enable king to keep track of its position~~
- ~~King with start position init~~
- Move king one field
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
