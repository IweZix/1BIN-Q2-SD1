import java.io.File;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonScanner {
	private Scanner scanner ;
	private Object source ;

	public MonScanner(File file) {
		try {
			scanner = new Scanner(file);
			source = file ;
		} catch(java.io.FileNotFoundException e) {
			e.printStackTrace() ;
			System.exit(0);
		}
	}
	
	public MonScanner(String file) {
		try {
			source = new File(file) ;
			scanner = new Scanner((File)source);
		} catch(java.io.FileNotFoundException e) {
			e.printStackTrace() ;
			System.exit(0);
		}
	}

	public MonScanner(InputStream stream) {
		source = stream ;
		scanner = new Scanner(stream) ;
	}
	
	public String next() {
		try {
			String st = scanner.next() ;
			if (source!=System.in) {
				System.out.print(st) ;
			}
			return st ;
		} catch(InputMismatchException e) {
			e.printStackTrace() ;
			System.exit(0) ;
			return null ;
		} catch(Exception e) {
			scanner =  new Scanner(System.in) ;
			source = System.in ;
			return scanner.next();
		}
	}
	
	public String nextLine() {
		try {
			String st = scanner.nextLine() ;
			if (source!=System.in) {
				System.out.println(st) ;
			}
			return st ;
		} catch(InputMismatchException e) {
			e.printStackTrace() ;
			System.exit(0) ;
			return null ;
		} catch(Exception e) {
			scanner =  new Scanner(System.in) ;
			source = System.in ;
			return scanner.nextLine();
		}
	}
	
	public int nextInt() {
		try {
			int entier = scanner.nextInt() ;
			if (source!=System.in) {
				System.out.println(entier) ;
			}
			return entier ;
		} catch(InputMismatchException e) {
			e.printStackTrace() ;
			System.exit(0) ;
			return 0 ;
		} catch(Exception e) {
			scanner =  new Scanner(System.in) ;
			source = System.in ;
			return scanner.nextInt();
		}
	}
	
	public double nextDouble() {
		try {
			double reel = scanner.nextDouble() ;
			if (source!=System.in) {
				System.out.println(reel) ;
			}
			return reel ;
		} catch(InputMismatchException e) {
			e.printStackTrace() ;
			System.exit(0) ;
			return 0 ;
		} catch(Exception e) {
			scanner =  new Scanner(System.in) ;
			source = System.in ;
			return scanner.nextDouble();
		}
	}
	
}
