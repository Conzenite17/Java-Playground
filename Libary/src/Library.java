import java.util.ArrayList;

public class Library {

	private static String openingHours;
	private String address;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public Library(String address){
		this.address = address;
		openingHours = "9AM - 5PM";
	}
	
	public void addBook(Book book){
		this.bookList.add(book);
	}
	
	public static void printOpeningHours(){
		System.out.println(openingHours);
	}
	
	public void printAddress(){
		System.out.println(this.address);
	}
	
	private int getBookIndex(String bookName){
		for (int i = 0; i < bookList.size(); i++){
			if (this.bookList.get(i).getTitle() == bookName){
				return i;
			}
		}
		return -1;
	}
	
	public void borrowBook(String bookName){	
		if (getBookIndex(bookName) > -1){
			//borrow book, if not isBorrowed()
			if (!this.bookList.get(getBookIndex(bookName)).isBorrowed()){
				this.bookList.get(getBookIndex(bookName)).borrowed();
				System.out.println("You successfully borrowed " + bookName);
			} else{
				System.out.println("Sorry, this book is already borrowed.");
			}
		} else{
			System.out.println("Sorry, this book is not our catalog.");
		}
	}
	
	public void printAvailableBooks(){
		int availableBookCount = 0;
		
		for (Book book : bookList){
			if (!book.isBorrowed()){
				availableBookCount++;
				System.out.println(book.getTitle());
			}
		}
		if (availableBookCount == 0){
			System.out.println("No book in catalog");
		}
	}
	
	public void returnBook(String bookName){
		this.bookList.get(getBookIndex(bookName)).returned();
		System.out.println("You successfully returned The Lord of the Rings");
	}
	
	public static void main(String[] args) {
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		
		System.out.println("Library hours:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		
		System.out.println("Borrowing The Lord of the Rings: ");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		//Return the lord of the rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		
		//Print the titles of available from the first library
		System.out.println("Books available in the first Library");
		firstLibrary.printAvailableBooks();
	}

}
