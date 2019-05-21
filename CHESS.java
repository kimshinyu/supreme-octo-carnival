import java.io.*;
import java.util.*;

///things to do
//movePiece
//checkedKing
//isValidMove
//change getInput to getInputAndMove

public class App {
	public static void main(String() args) { //donedone
		//starts chess
		System.out.println("The game is now starting.");
		Chess chess = new Chess();
//maybe ask for player names		
		//repeat until game is over:
		boolean whitePlays = true;
		while (!chess.checkedKing()){
			chess.printTable();//prints table (tabulate) for the player
			if(whitePlays){//do movement for white
				System.out.println("The whites plays.");
				chess.getInputAndMove(1);	
			}
			else{//do movement for black
				System.out.println("The blacks plays.");
				chess.getInputAndMove(0);	
			}
		//check kings (to change keepPlaying, if white cannot move print "blacks win" if black cannot move print "whites win")
		whitePlays = !whitePlays; //changes turns
		}
		System.out.println("The game has ended.");
		System.out.println("Thanks for playing with us.");
	}
}

	public class Chess {// will do a version with a matrix, and my objects will be the squares
		private Square[][] table;
		private ArrayList<String> log;

	public Chess(){//initiate new table	//DONEdone
		this.log = new ArrayList<String>; //new log
		this.table = new SquareType[8][8]; //new table
		//set colour to build
		builderColour = 0; //0 for black to start
													//create pieces
		for(int rank = 0, rank < 8, rank ++){		//iterate by rank //I could do something like table.lenght() and table[i].lenght() and stuff, but I want it not to be different from 8 so whatever
		
			if(rank==6)//change colour to build //i'm guessing the colour will be mantained for rank = 7
			{builderColour = 1;} //1 for white
			
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
							System.out.println("There was an error in making pieces with classes.");
						}
						
					case 1: case 6:		//make pawns
						this.table[rank][file] = new Square(PAWN, builderColour);
								break;
						
					case 2: case 3: 	//make EMPTY squares
					case 4: case 5: 	//make EMPTY squares
						this.table[rank][file] = new Square(EMPTY, -1);
								break;
						
					default:			//in case of unexpected error
					System.out.println("There was an error in making pieces.");
				}
			}
		}
	}

	public movePiece(int fileFrom,int rankFrom,int fileTo,int rankTo){//do everything necesary for movement						//!!!!!!!!!!!!!!!!!!
		Square fromSquare = this.table[fileFrom][rankFrom];
		Square toSquare = this.table[fileTo][rankTo];
		if(this.isValidMove(fromSquare.getType(), fileFrom, rankFrom, fileTo, rankTo)){//checks for validity of movement (out of bounds, reachable by type)	
			if (toSquare.getType() == EMPTY){				//if destination is empty, copy in TO and destroy in FROM 	
																						//log movement											!!!!
				System.out.println("Your " + fromSquare.getType() + " has moved to " + fileTo + ":" + rankTo + ".");

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
					System.out.println("Invalid move. The destination contains a piece of the same colour");;
					chess.getInputAndMove(fromSquare.getColour());																							 //!!!!!!!!!
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

	private getInputAndMove(int colour){           //donedone
		
		System.out.println("Enter your move: (FileFrom)");
		Scanner inputff = new Scanner(System.in)
		int fileFrom = inputff.nextInt();
		
		System.out.println("Enter your move: (RankFrom)");
		Scanner inputrf = new Scanner(System.in)
		int rankFrom = inputrf.nextInt();
		
		if(this.table[fileFrom][rankFrom].getType() == EMPTY | this.table[fileFrom][rankFrom].getColour() != colour){
			//check if From data corresponds to correct colour 	&& not empty
			System.out.println("There is an error on the 'FROM' input. Please enter again.");
			this.getInputAndMove();
			return;
		}
		
		System.out.println("Enter your move: (FileTo)");
		Scanner inputft = new Scanner(System.in)
		int fileTo = inputft.nextInt();
		
		System.out.println("Enter your move: (RankTo)");
		Scanner inputrt = new Scanner(System.in)
		int rankTo = inputrt.nextInt();
		
		if(this.isValidMove(fileFrom,rankFrom,fileTo,rankTo)){
			this.movePiece(fileFrom,rankFrom,fileTo,rankTo);
		}
		else{
			System.out.println("A problem has ocurred with either the input or the movement or the validation of movement.");
		}
	}

	boolean public checkedKing(){  //Returns true if there is a checked king  !!!!!!!!!
		
	}
	
	private getInput(String data){//if user input asks for log, give	//DONEDONE
		if(data == "log"){
		this.printLog();
		}
		else{
		System.out.println("Input is invalid. (String)");;
		}
	}

	boolean private isValidMove(int fileFrom,int rankFrom,int fileTo,int rankTo){ //   !!!!!!!!!!!!!!!!!!!!!!!!
		boolean validity = false;
		SquareType type = this.table[fileFrom][rankFrom].getType();
																					//implement against suicide												!!!!
		switch(type){
			case PAWN:				//define if move valid for type																				!!!!
				//three cases: anywhere one step forward
								//starting position two steps forward
								//any position, enemy on diagonal forward one square of distance
				return validity;
				break;
			case ROOK:				//define if move valid for type																				!!!!
				return validity;
				break;
			case KNIGHT:			//define if move valid for type																				!!!!
				return validity;
				break;
			case BISHOP:			//define if move valid for type																				!!!!
				return validity;
				break;
			case QUEEN:			//define if move valid for type																				!!!!
				return validity;
				break;
			case KING:				//define if move valid for type																				!!!!
				return validity;
				break;
			default:
			System.out.println("Error in type movement validation.");			//define error sysout		
		}
		return validity;
	}

	public printTable(){//shows current state of the table  //DONEDONE
        // Loop through all rows //taken from outside https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
        for (Square[] row : this.table) {
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row));
		} 
	}

	public printLog(){//prints out log//DONEDONE
	if(this.log.size() > 0){
	System.out.println(toString(this.log));
	}
	else
	{System.out.println("Log is empty.");}
	}
	}

	class Square {// DONEDONE
		SquareType type;
		int colour; // 0 for black, 1 for white, -1 for empty

		// builder
		public Square(SquareType type, int colour) {
			if (type == EMPTY) {
				colour = -1;
			}
			this.type = type;
			this.colour = colour;
		}

		// getters
		SquareType getType() {
			return type;
		}

		int getColour() {
			return colour;
		}

		// setters
		SquareType setType(SquareType type) {
			this.type = type;
		}

		int setColour(int colour) {
			this.colour = colour;
		}
	}

enum SquareType{//DONEDONE
	EMPTY,KING,QUEEN,ROOK,BISHOP,KNIGHT,PAWN;	
}