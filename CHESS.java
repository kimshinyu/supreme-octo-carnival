import java.io.*; 
import java.util.*; 

public class App{ //!!!!
	public static void main(String() args) {
		//starts chess
		##sysout("The game is now starting.");
		Chess chess = new Chess();
	//maybe ask for player names																												!!!!
		//repeat until game is over:
		boolean keepPlaying = true;
		boolean whitePlays = true;
		while (keepPlaying){
			chess.printTable();//prints table (tabulate) for the player
			if(whitePlays){//do movement for white
				##sysout("The whites plays.");
				chess.getInput(/*thing about input and stuff*/);																							 //!!!!!!!!!
			}
			else{//do movement for black
				##sysout("The blacks plays.");
				chess.getInput(/*thing about input and stuff*/);																							 //!!!!!!!!!
			}
		//check kings (to change keepPlaying, if white cannot move print "blacks win" if black cannot move print "whites win")					!!!!
		whitePlays = !whitePlays; //changes turns
		}
		##sysout("The game has ended.");
		##sysout("Thanks for playing with us.");
	}
}

public class Chess{//will do a version with a matrix, and my objects will be the squares
	private Square[][] table;
	private ArrayList<String> log;
	
	public Chess(){//initiate new table	//DONE
		this.log = new ArrayList<String>; //new log
		this.table = new SquareType[8][8]; //new table
		//set colour to build
		builderColour = 0 //0 for black to start
													//create pieces
		for(int rank = 0, rank < 8, rank ++){		//iterate by rank //I could do something like table.lenght() and table[i].lenght() and stuff, but I want it not to be different from 8 so whatever
		
			if(rank==6)//change colour to build //i'm guessing the colour will be mantained for rank = 7
			{builderColour = 1} //1 for white
			
			for(int file = 0, file < 8, file ++){	//iterate by file
				switch(rank){			//changing the type to build defined by rank
					
					case 0: case 7:			//make pieces with classes
						switch(file){	//changing the type to build defined by file
							
							case 0: case 7: 	//make rook
								this.table[rank][file] = new Square(ROOK, builderColour);
								break;
								
							case 1: case 6: 	//make knight
								this.table[rank][file] = new Square(KNIGHT, builderColour);
								break;
								
							case 2: case 5: 	//make bishop
								this.table[rank][file] = new Square(BISHOP, builderColour);
								break;
								
							case 3: 			//make queen
								this.table[rank][file] = new Square(QUEEN, builderColour);
								break;
								
							case 4: 			//make king
								this.table[rank][file] = new Square(KING, builderColour);
								break;
								
							default:			//in case of unexpected error
							##sysout("There was an error in making pieces with classes.");
						}
						
					case 1: case 6:		//make pawns
						this.table[rank][file] = new Square(PAWN, builderColour);
								break;
						
					case 2: case 3: 	//make EMPTY squares
					case 4: case 5: 	//make EMPTY squares
						this.table[rank][file] = new Square(EMPTY, -1);
								break;
						
					default:			//in case of unexpected error
					##sysout("There was an error in making pieces.");
				}
			}
		}
	}	

	public movePiece(int fileFrom,int rankFrom,int fileTo,int rankTo){//do everything necesary for movement						//!!!!!!!!!!!!!!!!!!
		Square fromSquare = this.table[fileFrom][rankFrom];
		Square toSquare = this.table[fileTo][rankTo];
		if(this.isValidMove(fromSquare.getType(), fileFrom, rankFrom, fileTo, rankTo)){//checks for validity of movement (out of bounds, reachable by type)	
			if (toSquare.getColour() == -1){				//if destination is empty, copy in TO and destroy in FROM 	
																						//log movement											!!!!
				##sysout("Your " + fromSquare.getType() + " has moved to " + fileTo + ":" + rankTo + ".");

				if(toSquare.getType() == PAWN && 				
					(toSquare.getColour() == 0 && rankTo == 7)|
					(toSquare.getColour() == 1 && rankTo == 0)){   //if PAWN&finalRank, check for change (ask for input) 	
																						//log movement											!!!!
					##sysout("Your pawn has adquired a rank up! Please enter the desired rank: (QUEEN,ROOK,BISHOP,KNIGHT)");
					##newRank = sysin();
					switch (newRank){
						case QUEEN:
						fromSquare.setType(QUEEN)
						##sysout("Your pawn has ranked up to a QUEEN!");
						break;
						case ROOK:
						fromSquare.setType(ROOK)
						##sysout("Your pawn has ranked up to a ROOK!");
						break;
						case BISHOP:
						fromSquare.setType(BISHOP)
						##sysout("Your pawn has ranked up to a BISHOP!");
						break;
						case KNIGHT:
						fromSquare.setType(KNIGHT)
						##sysout("Your pawn has ranked up to a KNIGHT!");
						break;
						default:
						##sysout("Invalid rank for the rank up.");
					}
				}
				toSquare.Square(fromSquare.getType(),fromSquare.getColour());
				fromSquare.Square(EMPTY,-1);
			}
			else{											//if destination is not empty
				boolean sameColour = (fromSquare.getColour() == toSquare.getColour());
				switch(sameColour){
					case true:												//if blocked by same colour, show error (light error)
					##sysout("Invalid move. The destination contains a piece of the same colour");
					chess.getInput(/*thing about input and stuff*/);																							 //!!!!!!!!!
					break;

					case false:													 //if blocked by opposite colour, eat 	
																				//log movement													!!!!
					##sysout("Your " + fromSquare.getType() + " from square " + fileFrom + ":" + rankFrom + " has eaten the enemy " + toSquare.getType() + " from square " + fileTo + ":" + rankTo + ".");
					if(toSquare.getType() == PAWN && 				
						(toSquare.getColour() == 0 && rankTo == 7)|
						(toSquare.getColour() == 1 && rankTo == 0)){ 				  //if PAWN&finalRank, check for change (ask for input) 	
																							//log movement											!!!!
						##sysout("Your pawn has adquired a rank up! Please enter the desired rank: (QUEEN,ROOK,BISHOP,KNIGHT)");
						##newRank = sysin();
						switch (newRank){
							case QUEEN:
							fromSquare.setType(QUEEN)
							##sysout("Your pawn has ranked up to a QUEEN!");
							break;
							case ROOK:
							fromSquare.setType(ROOK)
							##sysout("Your pawn has ranked up to a ROOK!");
							break;
							case BISHOP:
							fromSquare.setType(BISHOP)
							##sysout("Your pawn has ranked up to a BISHOP!");
							break;
							case KNIGHT:
							fromSquare.setType(KNIGHT)
							##sysout("Your pawn has ranked up to a KNIGHT!");
							break;
							default:
							##sysout("Invalid rank for the rank up.");
						}
					}
					toSquare.Square(fromSquare.getType(),fromSquare.getColour());
					fromSquare.Square(EMPTY,-1);
					break;
				
					default:
					##sysout("Some kind of error in the movement.");
				}
			}	
		}
		else{//if movement is not valid
			##sysout("Invalid move for the piece type.");
				chess.getInput(/*thing about input and stuff*/);																	 //!!!!!!!!!
		}
	}
	
	private getInput(int fileFrom,int rankFrom,int fileTo,int rankTo){//DONE
			##sysout("Enter your move: (FileFrom,RankFrom,FileTo,RankTo)");
			##sysin();
							//check if From data corresponds to correct colour 	&& not empty																!!!!
			chess.movePiece(FileFrom,RankFrom,FileTo,RankTo);
	}
	
	private getInput(String data){//if user input asks for log, give	//DONE
		if(data == "log"){
		this.printLog();
		}
		else{
		##sysout("Input is invalid. (String)");
		}
	}
	
	private isValidMove(SquareType type, int fileFrom,int rankFrom,int fileTo,int rankTo){ //   !!!!!!!!!!!!!!!!!!!!!!!!
		
																					//implement against suicide												!!!!
				switch(fromSquare.getType()){
			case PAWN:				//define if move valid for type																				!!!!
				//three cases: anywhere one step forward
								//starting position two steps forward
								//any position, enemy on diagonal forward one square of distance
			break;
			case ROOK:				//define if move valid for type																				!!!!
			
			break;
			case KNIGHT:			//define if move valid for type																				!!!!
			
			break;
			case BISHOP:			//define if move valid for type																				!!!!
			
			break;
			case QUEEN:			//define if move valid for type																				!!!!
			
			break;
			case KING:				//define if move valid for type																				!!!!
			
			break;
			default:
			##sysout("Error in type movement validation.");				//define error sysout		
		}

	}

	public printTable(){//shows current state of the table //taken from outside https://www.geeksforgeeks.org/print-2-d-array-matrix-java/ //DONE
        // Loop through all rows 
        for (Square[] row : this.table) {
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
		} 
	}
	
	public printLog(){//prints out log//DONE
	if(this.log.size() > 0){
	##sysout(toString(this.log));
	}
	else
	{##sysout("Log is empty.")}
	}
}

class Square{//DONE
	SquareType type;
	int colour; //0 for black, 1 for white, -1 for empty
	
	//builder
	public Square(SquareType type, int colour){
	if(type == EMPTY){colour = -1;}
	this.type = type;
	this.colour = colour;
	}
	//getters
	SquareType getType(){
		return type;
	}
	int getColour(){
		return colour;
	}
	//setters
	SquareType setType(SquareType type){
		this.type = type;
	}
	int setColour(int colour){
		this.colour = colour;
	}
}

enum SquareType{//DONE
	EMPTY,KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN;	
}





4
/*
public class Chess{ //I'm going to make two versions; one with hashmaps (with a "piece" class)
//cant do "square class" version since it is impossible (aka hard) to make a check to a particular square (unless hashmaps are used)
	public static void main(String() args) {
		
		
		
	}
}


//columns are "files", rows are "ranks"
class Table{
	HashMap<Position,Piece> hMap; //	KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN
	//List<String> log; to log all movements done


	void movePiece(Type pieceType, int colour, int pieceFile, int pieceRank){
		//check if movement is legal for that type and colour
		//check if destination is empty, ally or enemy
		
		//check if movement is pawn>final rank
		if(pieceType == PAWN){
			//out "what new piece"
			//change type to new piece
		}
		//do movement
	}
}

class Piece{
	PieceType type; //	KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN
	int colour; //		-1 = blank, 0 = white, 1 = black
	
	boolean equals(Piece piece){
		if( piece.type == this.type && piece.colour == this.colour){
		return true;
	}
	return false
	}
	PieceType setType(Type type){
		this.type = type;
	}
	int setColour(int colour){
		this.colour = colour;
	}
	PieceType getType(){
		return type;
	}
	int getColour(){
}
}

enum PieceType{
	KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN;	
}

class Position{
	int file;	// 0 is null, 1~8 left to right
	int rank;	// 0 is null, 1~8 white to black (normally down to up)

	boolean isValidPosition(){
		if(this.file >= 1 && this.file <= 8 && this.rank >= 1 && this.rank <= 8){
			return true;
		}
		return false;
	}
	boolean equals(Position position){
		if( position.file == this.file && position.rank == this.rank){
			return true;
		}
		return false
	}
	int getFile(){
		return file;
	}
	int getRank(){
		return rank;
	}
	int setFile(int file){
		this.file = file;
	}
	int setRank(int rank){
		this.rank = rank;
	}
}
*/