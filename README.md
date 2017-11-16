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
- ~~Rotate table~~
- ~~Check if field is occupied by enemy rook~~
	- ~~Enemy rook is on same column like destination, but on a higher row~~
	- ~~Enemy rook is on same column like destination, but on a lower row~~
	- ~~Enemy rook is on same row like destination, but on a higher column~~
	- ~~Enemy rook is on same row like destination, but on a lower clomun~~
	- ~~Enemy rook is on same column like destination, but on a higher row (Nothing is between destination and rook)~~
	- ~~Enemy rook is on same column like destination, but on a lower row (Nothing is between destination and rook)~~
	- ~~Enemy rook is on same row like destination, but on a higher column (Nothing is between destination and rook)~~
	- ~~Enemy rook is on same row like destination, but on a lower clomun (Nothing is between destination and rook)~~
	- ~~2 enemy rook are on same column, target field is between the rooks, one of the rooks is blocked by another figure~~
	- ~~2 enemy rook are on same row, target field is between the rooks, one of the rooks is blocked by another figure~~
	- ~~One rook is on higher column like the target field and one is on higher row, one of the rooks is blocked by another figure~~
	- ~~One rook is on higher column like the target field and one is on lower row, one of the rooks is blocked by another figure~~
	- ~~One rook is on lower column like the target field and one is on higher row, one of the rooks is blocked by another figure~~
	- ~~One rook is on lower column like the target field and one is on lower row, one of the rooks is blocked by another figure~~
- Check if field is occupied by enemy bishop
	- Enemy bishop is on higher column and higher row
	- Enemy bishop is on higher column and lower row
	- Enemy bishop is on lower column and higher row
	- Enemy bishop is on lower column and lower row
	- Nothing is between destination and bishop
- Check if field is occupied by enemy queen
	- Enemy queen is on same column like destination, but on a higher row
	- Enemy queen is on same column like destination, but on a lower row
	- Enemy queen is on same row like destination, but on a higher column
	- Enemy queen is on same row like destination, but on a lower clomun
	- Enemy queen is on higher column and higher row
	- Enemy queen is on higher column and lower row
	- Enemy queen is on lower column and higher row
	- Enemy queen is on lower column and lower row
	- Nothing is between destination and queen
- Check if field is occupied by enemy knight
	- Enemy knight is two column up and one row right
	- Enemy knight is two column up and one row left
	- Enemy knight is two column down and one row right
	- Enemy knight is two column down and one row left
	- Enemy knight is two column left and one row up
	- Enemy knight is two column left and one row down
	- Enemy knight is two column right and one row up
	- Enemy knight is two column right and one row down
- Check if field is occupied by enemy pawn
	- Enemy pawn is one row up and one column left
	- Enemy pawn is one row up and one column right
- Check if field is occupied by enemy king
	- Enemy king is one row up and on same column
	- Enemy king is one row down and on same column
	- Enemy king is on same row and one column left
	- Enemy king is on same row and one column right
	- Enemy king is one row up and one column left
	- Enemy king is one row up and one column right
	- Enemy king is one row down and one column left
	- Enemy king is one row down and one column right
- Prevent figure to go out of table

### Pawn tests:
- ~~Pawn init~~
- ~~Black pawn init~~
- ~~White pawn init~~
- ~~Enable pawn to keep track of its position~~
- ~~Pawn with start position init~~
- ~~Move pawn one field forward (field in front of pawn empty)~~
- ~~Prevent pawn from moving one field forward (figure in front of pawn)~~
- ~~Move pawn two field forward for the very first move (fields on the way empty)~~
- ~~Move pawn one field forward for the very first move (fields on the way empty)~~
- ~~Prevent pawn from moving two field forward if not the very first move~~
- ~~Prevent pawn from moving two field formawrd for the very first move (on destination is a figure)~~
- ~~Prevent pawn from moving two field formawrd for the very first move (in front of pawn is a figure)~~
- ~~Move pawn one field diagonally forward-right(enemy field on the destination)~~
- ~~Move pawn one field diagonally forward-left(enemy field on the destination)~~
- ~~Prevent pawn from moving one field diagonally forward (destination field empty)~~
- ~~Prevent pawn from moving one field diagonally forward (ally figure on the destination)~~
- "En passat"

### Rook tests:
- ~~Rook init~~
- ~~Black rook init~~
- ~~White rook init~~
- ~~Enable rook to keep track of its position~~
- ~~Rook with start position init~~
- ~~Move rook one field vertically on empty field~~
- ~~Prevent rook from moving diagonally~~
- ~~Move rook one field horizontally on empty field~~
- ~~Move rook n fields vertically (all field on the way are empty)~~
- ~~Move rook n fields horizontally (all fields on the way are empty)~~
- ~~Prevent rook from moving n fields vertically (in front of rook vertically is a figure)~~
- ~~Prevent rook from moving n fields horizontally (next to rook horizontally is a figure)~~
- ~~Prevent rook from moving n fields vertically (on the way are figures)~~
- ~~Prevent rook from moving n fields horizontally (on the way are figure)~~
- ~~Move rook n fields vertically (on the destination is ally figure)~~
- ~~Move rook n fields horizontally (on the destination is ally figure)~~
- ~~Move rook n fields vertically (on the destination is enemy figure)~~
- ~~Move rook n fields horizontally (on the destination is enemy figure)~~
- ~~Move rook n fields vertically backwards (all field on the way are empty)~~
- ~~Prevent rook from moving n fields vertically backwards (in back of rook vertically is a figure)~~
- ~~Prevent rook from moving n fields vertically backwards (on the way are figures)~~
- ~~Move rook n fields vertically backwards (on the destination is ally figure)~~
- ~~Move rook n fields vertically backwards (on the destination is enemy figure)~~
- ~~Move rook n fields horizontally backwards/left (all field on the way are empty)~~
- ~~Prevent rook from moving n fields horizontally backwards/left (next to rook horizontally is a figure)~~
- ~~Prevent rook from moving n fields horizontally backwards/left (on the way are figures)~~
- ~~Move rook n fields horizontally backwards/left (on the destination is ally figure)~~
- ~~Move rook n fields horizontally backwards/left (on the destination is enemy figure)~~
- ~~Prevent rook to move like knight~~

### Knight tests:
- ~~Knight init~~
- ~~Black knight init~~
- ~~White knight init~~
- ~~Enable knight to keep track of its position~~
- ~~Knight with start position init~~
- ~~Move knight RANDOM~~
- ~~Move knight where vertically increases by 2 fields and horizontally increases by one field (destination empty)~~
- ~~Move knight where vertically increases by 2 fields and horizontally decreases by one field (destination empty)~~
- ~~Move knight where vertically decreases by 2 fields and horizontally increases by one field (destination empty)~~
- ~~Move knight where vertically decreases by 2 fields and horizontally decreases by one field (destination empty)~~
- ~~Move knight where horizontally increases by 2 fields and vertically increases by one field (destination empty)~~
- ~~Move knight where horizontally increases by 2 fields and vertically decreases by one field (destination empty)~~
- ~~Move knight where horizontally decreases by 2 fields and vertically increases by one field (destination empty)~~
- ~~Move knight where horizontally decreases by 2 fields and vertically decreases by one field (destination empty)~~
- ~~Prevent knight from moving where ally on destination~~
- ~~Move knight if enemy is on destination~~
- ~~Prevent knight from moving horizontally~~
- ~~Prevent knight from moving vertically~~
- ~~Prevent knight from moving diagonally~~

### Bishop tests:
- ~~Bishop init~~
- ~~Black bishop init~~
- ~~White bishop init~~
- ~~Enable bishop to keep track of its position~~
- ~~Bishop with start position init~~
- ~~Move bishop one field diagonally (y increases with x increased)~~
- ~~Move bishop one field diagonally (y decreases with x increased)~~
- ~~Move bishop n fields diagonally (y increases with x increased, all fields on the way are empty)~~
- ~~Move bishop n fields diagonally (y decreases with x increased, all fields on the way are empty)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x increased, next to bishop is a figure)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x increased, next to bishop is a figure)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x increased, on the way are figures)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x increased, on the way are figures)~~
- ~~Move bishop n fields diagonally (y increases with x increased, enemy figure on destination)~~
- ~~Move bishop n fields diagonally (y decreases with x increased, enemy figure on destination)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x increased, friendly figure on destination)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x increased, friendly figure on destination)~~
- ~~Move bishop one field diagonally (y increases with x decreased)~~
- ~~Move bishop one field diagonally (y decreases with x decreased)~~
- ~~Move bishop n fields diagonally (y increases with x decreased, all fields on the way are empty)~~
- ~~Move bishop n fields diagonally (y decreases with x decreased, all fields on the way are empty)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x decreased, next to bishop is a figure)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x decreased, next to bishop is a figure)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x decreased, on the way are figures)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x decreased, on the way are figures)~~
- ~~Move bishop n fields diagonally (y increases with x decreased, enemy figure on destination)~~
- ~~Move bishop n fields diagonally (y decreases with x decreased, enemy figure on destination)~~
- ~~Prevent bishop from moving n fields diagonally (y increases with x decreased, friendly figure on destination)~~
- ~~Prevent bishop from moving n fields diagonally (y decreases with x decreased, friendly figure on destination)~~
- ~~Prevent bishop to move vertically~~
- ~~Prevent bishop to move horizontally~~
- ~~Prevent bishop to move like knight~~

### Queen tests:
- ~~Queen init~~
- ~~Black queen init~~
- ~~White queen init~~
- ~~Enable queen to keep track of its position~~
- ~~Queen with start position init~~
- ~~Move queen one field vertically on empty field~~
- ~~Move queen one field horizontally on empty field~~
- ~~Move queen n fields vertically (all field on the way are empty)~~
- ~~Move queen n fields horizontally (all fields on the way are empty)~~
- ~~Prevent queen from moving n fields vertically (next to queen vertically is a figure)~~
- ~~Prevent queen from moving n fields horizontally (next to queen horizontally is a figure)~~
- ~~Prevent queen from moving n fields vertically (on the way are figures)~~
- ~~Prevent queen from moving n fields horizontally (on the way are figures)~~
- ~~Move queen n fields vertically (on the destination is enemy figure)~~
- ~~Move queen n fields horizontally (on the destination is enemy figure)~~
- ~~Prevent queen from moving n fields vertically (on the destination is friendly figure)~~
- ~~Prevent queen from moving n fields horizontally (on the destination is friendly figure)~~
- ~~Move queen n fields vertically backwards (all field on the way are empty)~~
- ~~Prevent queen from moving n fields vertically backwards (in back of queen vertically is a figure)~~
- ~~Prevent queen from moving n fields vertically backwards (on the way are figures)~~
- ~~Move queen n fields vertically backwards (on the destination is ally figure)~~
- ~~Move queen n fields vertically backwards (on the destination is enemy figure)~~
- ~~Move queen n fields horizontally backwards/left (all field on the way are empty)~~
- ~~Prevent queen from moving n fields horizontally backwards/left (next to queen horizontally is a figure)~~
- ~~Prevent queen from moving n fields horizontally backwards/left (on the way are figures)~~
- ~~Move queen n fields horizontally backwards/left (on the destination is ally figure)~~
- ~~Move queen n fields horizontally backwards/left (on the destination is enemy figure)~~
- ~~Move queen one field diagonally (y increases with x increased)~~
- ~~Move queen one field diagonally (y decreases with x increased)~~
- ~~Move queen n fields diagonally (y increases with x increased, all fields on the way are empty)~~
- ~~Move queen n fields diagonally (y decreases with x increased, all fields on the way are empty)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x increased, next to queen is a figure)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x increased, next to queen is a figure)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x increased, on the way are figures)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x increased, on the way are figures)~~
- ~~Move queen n fields diagonally (y increases with x increased, enemy figure on destination)~~
- ~~Move queen n fields diagonally (y decreases with x increased, enemy figure on destination)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x increased, friendly figure on destination)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x increased, friendly figure on destination)~~
- ~~Move queen one field diagonally (y increases with x decreased)~~
- ~~Move queen one field diagonally (y decreases with x decreased)~~
- ~~Move queen n fields diagonally (y increases with x decreased, all fields on the way are empty)~~
- ~~Move queen n fields diagonally (y decreases with x decreased, all fields on the way are empty)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x decreased, next to queen is a figure)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x decreased, next to queen is a figure)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x decreased, on the way are figures)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x decreased, on the way are figures)~~
- ~~Move queen n fields diagonally (y increases with x decreased, enemy figure on destination)~~
- ~~Move queen n fields diagonally (y decreases with x decreased, enemy figure on destination)~~
- ~~Prevent queen from moving n fields diagonally (y increases with x decreased, friendly figure on destination)~~
- ~~Prevent queen from moving n fields diagonally (y decreases with x decreased, friendly figure on destination)~~
- ~~Prevent queen to move like knight~~

### King tests:
- ~~King init~~
- ~~Black king init~~
- ~~White king init~~
- ~~Enable king to keep track of its position~~
- ~~King with start position init~~
- ~~Move king one field left (destination empty)~~
- ~~Move king one field right (destination empty)~~
- ~~Move king one field forward (destination empty)~~
- ~~Move king one field backward (destination empty)~~
- ~~Move king one field diagonally forward-left (destination empty)~~
- ~~Move king one field diagonally backward-left (destination empty)~~
- ~~Move king one field diagonally forward-right (destination empty)~~
- ~~Move king one field diagonally backward-right (destination empty)~~
- ~~Prevent king from moving one field horizontally (ally on destination)~~
- ~~Prevent king from moving one field vertically (ally on destination)~~
- ~~Prevent king from moving one field diagonally (ally on destination)~~
- Prevent king from moving on a field that is occupied by enemy rook
- Prevent king from moving on a field that is occupied by enemy bishop
- Prevent king from moving on a field that is occupied by enemy queen
- Prevent king from moving on a field that is occupied by enemy knight
- Prevent king from moving on a field that is occupied by enemy pawn
- ~~Move king on a field that is not occupied (enemy on destination)~~
- King blocked
- King atacked

### Figure tests:
- ~~Figure init~~
- ~~Black figure init~~
- ~~White figure init~~
- ~~Enable figure to keep track of its position~~
- ~~Figure with start position init~~
- ~~Prevent any figure from moving 4 fields horizontally/vertically and 5 fields vertically/horizontlly~~

### Rules tests:
- ~~2 type of figures (white, black)~~
- White side starts first
- Draw
- Checkmate
- Promote a pawn (change pawn with another figure)
