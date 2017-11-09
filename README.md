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
- Make rock private
- Set Knight on square
- Set bishop on square
- Set queen on square
- Set king on square
- Table init
- Set square color (position [0,0] is black square)
- Set all figures of one player on table
- Set all figures of both player on table
- Keep figures in table

### Pawn tests:
- ~~Pawn init~~
- Move pawn one field forward
- Move pawn two field forward for the very first move
- Move pawn one field forward for the very first move
- Attack with pawn
- Pawn blocked by ally figure
- Pawn blocked by enemy figure in front
- "En passat"

### Rook tests:
- ~~Rook init~~
- Move rock vertical
- Move rock horizontal
- Attack with rock
- Rock blocked by ally figure

### Knight tests:
- Knight init
- Move knight

### Bishop tests:
- Bishop init
- Move bishop diagonal

### Queen tests:
- Queen init
- Move queen diagonal
- Move queen horizontal
- Move queen vertical

### King tests:
- King init
- Move king one field
- King blocked
- King atacked

### Rules tests:
- White side starts first
- Draw
- Checkmate
- Promote a pawn (change pawn with another figure)