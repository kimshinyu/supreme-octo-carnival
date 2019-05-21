import java.util.*;

///things to do
//movePiece
//checkedKing
//isValidMove
//change getInput to getInputAndMove

public class Chess{// will do a version with a matrix, and my objects will be the squares
	private Square[][] table;
	private ArrayList<String> log;
	
	public Chess(){//initiate new table	//DONEdone
		this.log = new ArrayList<String>(); //new log
		this.table = new Square[8][8]; //new table
		int builderColour = 0; //0 for black to start//create pieces //set colour to build
		for(int rank = 0; rank < 8; rank ++){		//iterate by rank //I could do something like table.lenght() and table[i].lenght() and stuff, but I want it not to be different from 8 so whatever
			if(rank==6 || rank == 7){builderColour = 1;} //change colour to build //i'm guessing the colour will be mantained for rank = 7//1 for white
			for(int file = 0; file < 8; file ++){	//iterate by file
				switch(rank){			//changing the type to build defined by rank
					
					case 0: case 7:			//make pieces with classes
						switch(file){	//changing the type to build defined by file
							case 0: case 7: 	//make rook
								this.table[rank][file] = new Square(SquareType.ROOK, builderColour);
								break;
								
							case 1: case 6: 	//make knight
								this.table[rank][file] = new Square(SquareType.KNIGHT, builderColour);
								break;
								
							case 2: case 5: 	//make bishop
								this.table[rank][file] = new Square(SquareType.BISHOP, builderColour);
								break;
								
							case 3: 			//make queen
								this.table[rank][file] = new Square(SquareType.QUEEN, builderColour);
								break;
								
							case 4: 			//make king
								this.table[rank][file] = new Square(SquareType.KING, builderColour);
								break;
								
							default:			//in case of unexpected error
							System.out.println("There was an error in making pieces with classes.");
						}
						break;
						
					case 1: case 6:		//make pawns
						this.table[rank][file] = new Square(SquareType.PAWN, builderColour);
						break;
						
					case 2: case 3: 	//make EMPTY squares
					case 4: case 5: 	//make EMPTY squares
						this.table[rank][file] = new Square(SquareType.EMPTY, -1);
						break;
						
					default:			//in case of unexpected error
					System.out.println("There was an error in making pieces.");
				}
			}
		}
	}

	public void movePiece(int rankFrom,int rankTo,int fileFrom,int fileTo){//do everything necesary for movement						//!!!!!!!!!!!!!!!!!!
		Square fromSquare = this.table[rankFrom][fileFrom];
		Square toSquare = this.table[rankTo][fileTo];
		if (toSquare.getType() == SquareType.EMPTY){				//if destination is empty, copy in TO and destroy in FROM 	//log movement		!!!!
			System.out.println("Your " + fromSquare.getType() + " has moved to " + rankTo + ":" + fileTo + ".");
			if(toSquare.getType() == SquareType.PAWN && (toSquare.getColour() == 0 && rankTo == 7) | (toSquare.getColour() == 1 && rankTo == 0)){ 				  //if PAWN&finalRank, check for change (ask for input) 	 //log movement											!!!!
				rankUpPawn(rankFrom,rankTo,fileFrom,fileTo);
			}
		}
		else{								 //if blocked by opposite colour, eat 	//log movement													!!!!
			System.out.println("Your " + fromSquare.getType() + " from square " + rankFrom + ":" + fileFrom + " has eaten the enemy " + toSquare.getType() + " from square " + rankTo + ":" + fileTo + ".");
			if(toSquare.getType() == SquareType.PAWN && (toSquare.getColour() == 0 && rankTo == 7) | (toSquare.getColour() == 1 && rankTo == 0)){ 				  //if PAWN&finalRank, check for change (ask for input) 	 //log movement											!!!!
				rankUpPawn(rankFrom,rankTo,fileFrom,fileTo);
			}
		}
		toSquare.setColour(fromSquare.getColour());
		toSquare.setType(fromSquare.getType());
		fromSquare.setType(SquareType.EMPTY);
		fromSquare.setColour(-1);
	}
	
	private void rankUpPawn(int rankFrom,int rankTo,int fileFrom,int fileTo){
		Square fromSquare = this.table[rankFrom][fileFrom];
	    System.out.println("Your pawn has adquired a rank up! Please enter the desired rank: (QUEEN,ROOK,BISHOP,KNIGHT)");
		SquareType newRank = SquareType.EMPTY;
		while(newRank.equals(SquareType.EMPTY) || newRank.equals(SquareType.KING) || newRank.equals(SquareType.PAWN)){
			Scanner input = new Scanner(System.in);
			newRank.fromString(input.next());
			input.close();
			if(newRank.equals(SquareType.EMPTY) || newRank.equals(SquareType.KING) || newRank.equals(SquareType.PAWN)){
				System.out.println("Please enter a valid option (QUEEN,ROOK,BISHOP,KNIGHT): ");
			}else{
		        fromSquare.setType(newRank);
		        System.out.println("Your pawn has ranked up to a " + newRank + "!");
			}
		}
	}
	
 	public void getInputAndMove(int colour){           //donedone

		System.out.println("Enter your piece data: (RankFrom: Vertical Position)");
		Scanner inputrf = new Scanner(System.in);
		int rankFrom = inputrf.nextInt();
		
		System.out.println("Enter your piece data: (FileFrom: Horizontal Position)");
		Scanner inputff = new Scanner(System.in);
		int fileFrom = inputff.nextInt();
		
		if(fileFrom < 0 || fileFrom > 7 ||rankFrom < 0 || rankFrom > 7|| SquareType.EMPTY.equals(this.table[rankFrom][fileFrom].getType()) | this.table[rankFrom][fileFrom].getColour() != colour){
			
			//check if From data corresponds to correct colour 	&& not empty

			System.out.println("Please enter a correct piece to move.");
			System.out.println("Let's try it again.");
			
			getInputAndMove(colour);
			
		}else{
			
			System.out.println("You, (" + (colour == 0? "Black": "White") + "), are playing your " + table[rankFrom][fileFrom].getType() + ".");
			
			System.out.println("Enter your move: (RankTo: Vertical Position)");
			Scanner inputrt = new Scanner(System.in);
			int rankTo = inputrt.nextInt();
			
			System.out.println("Enter your move: (FileTo: Vertical Position)");
			Scanner inputft = new Scanner(System.in);
			int fileTo = inputft.nextInt();
			
			if( !(fileFrom < 0 && fileFrom > 7 && rankFrom < 0 && rankFrom > 7) && !(rankFrom == rankTo && fileFrom == fileTo) && isValidMove(rankFrom,rankTo,fileFrom,fileTo)){
				this.movePiece(rankFrom,rankTo,fileFrom,fileTo);
			}
			else{
				System.out.println("A problem has ocurred with the validation of the movement.");
				System.out.println("Please enter again the information.");
				this.getInputAndMove(colour);
			}
			
			if(checkedKing()){
				inputft.close();
				inputrt.close();
			}
		}
		if(checkedKing()){
			inputff.close();
			inputrf.close();
		}
	}
 	
	public boolean checkedKing(){  //Returns true if there is a checked king  !!!!!!!!! FOR NOW IT RETURNS ONLY IF ONE OF THE KINGS DIES
		int kingCount = 0;
		for(Square[] rank : table){
			for(Square s : rank){
				kingCount = kingCount + (SquareType.KING == s.getType()?1:0);
			}
		}
		return kingCount == 1;
	}

	private boolean isValidMove(int rankFrom,int rankTo,int fileFrom,int fileTo){ //   !!!!!!!!!!!!!!!!!!!!!!!! //TODO: implement against king suicide	
		
		if(table[rankFrom][fileFrom].getColour() == table[rankTo][fileTo].getColour()){
			System.out.println("Invalid move. The destination contains a piece of the same colour");
			return false;
		}
		switch(this.table[rankFrom][fileFrom].getType()){
			case PAWN:				//define if move valid for type																				!!!!
				//three cases: anywhere one step forward
								//starting position two steps forward
								//any position, enemy on diagonal forward one square of distance
				return 	((this.table[rankFrom][fileFrom].getColour() == 0
						&& ((rankFrom == 1 && rankTo == 3 && fileFrom == fileTo && table[2][fileFrom].getType() == SquareType.EMPTY) 
							|| (fileFrom == fileTo && rankTo-rankFrom == 1)
							|| (Math.abs(fileFrom-fileTo) == 1 && rankTo-rankFrom == 1)
							))
						|| 
						(this.table[rankFrom][fileFrom].getColour() == 1 
						&& ((rankFrom == 6 && rankTo == 4 && fileFrom == fileTo && table[5][fileFrom].getType() == SquareType.EMPTY) 
							|| (fileFrom == fileTo && rankFrom-rankTo == 1)
							|| (Math.abs(fileFrom-fileTo) == 1 && rankFrom-rankTo == 1)
							))
						);
			
			case ROOK:				//define if move valid for type																				!!!!
				return (((rankFrom == rankTo) && noHorizontalBlockage(rankFrom, fileFrom, fileTo))
				|| ((fileFrom == fileTo) && noVerticalBlockage(rankFrom, rankTo, fileFrom)));
			
			case KNIGHT:			//define if move valid for type																				!!!!
				return (Math.abs(rankFrom - rankTo) == 1 && Math.abs(fileFrom - fileTo) == 2) || (Math.abs(rankFrom - rankTo) == 2 && Math.abs(fileFrom - fileTo) == 1);
			
			case BISHOP:			//define if move valid for type																				!!!!
				return ((Math.abs(rankFrom - rankTo) == Math.abs(fileFrom - fileTo)) && noDiagonalBlockage(rankFrom, rankTo, fileFrom, fileTo));
			
			case QUEEN:				//define if move valid for type																				!!!!
				return (((Math.abs(rankFrom - rankTo) == Math.abs(fileFrom - fileTo)) && noDiagonalBlockage(rankFrom, rankTo, fileFrom, fileTo))
						|| (((rankFrom == rankTo) && noHorizontalBlockage(rankFrom, fileFrom, fileTo))
								|| ((fileFrom == fileTo) && noVerticalBlockage(rankFrom, rankTo, fileFrom))));
			
			case KING:				//define if move valid for type																				!!!!
				return Math.abs(rankFrom - rankTo) <= 1 && Math.abs(fileFrom - fileTo) <= 1;
				
			default:
				System.out.println("Error in type movement validation.");			//define error sysout		
				return false; //si no toma ningun tipo aceptable
		}
	}

	public void printTable(){//shows current state of the table  //DONEDONE
	    // Loop through all rows //taken from outside https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
		System.out.println("[\t0\t,\t1\t,\t2\t,\t3\t,\t4\t,\t5\t,\t6\t,\t7\t]");
		int i = 0;
	    for (Square[] rank : this.table) {
	        // converting each row as string 
	        // and then printing in a separate line 
	    	System.out.print(i);
	        System.out.println(Arrays.toString(rank));
	        i++;
		} 
	}
	
	private boolean noHorizontalBlockage(int rankFrom, int rankTo, int file){
		boolean result = true;
		for(int i = 1 + (rankTo < rankFrom?rankTo:rankFrom); i < (rankTo < rankFrom?rankFrom:rankTo) ; i++){
			result = result && SquareType.EMPTY == this.table[i][file].getType();
		}
		return result;
	}
	
	private boolean noVerticalBlockage(int rank, int fileFrom, int fileTo){
		boolean result = true;
		for(int i = 1 + (fileTo < fileFrom?fileTo:fileFrom); i < (fileTo < fileFrom?fileFrom:fileTo) ; i++){
			result = result && SquareType.EMPTY == this.table[rank][i].getType();
		}
		return result;
	}
	
	private boolean noDiagonalBlockage(int rankFrom,int rankTo,int fileFrom,int fileTo){
		boolean result = true;
		for(int i = 1 ; i < Math.abs(rankFrom - rankTo); i++){
				result = result && SquareType.EMPTY == this.table[(rankTo < rankFrom?rankTo:rankFrom)+i][(fileTo < fileFrom?fileTo:fileFrom)+i].getType();
		}
		return result;
	}
	
	public void printLog(){//prints out log//DONEDONE
		System.out.println(this.log.isEmpty()? "Log is empty.": this.log);
	}
}

