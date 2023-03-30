
public class TestDocumentsLRU {
	
	public static void main(String[] args) {
		
		DocumentsLRU docs = new DocumentsLRU(5);
		System.out.println("Scenario de tests pour la classe DocumentsLRU");
		System.out.println("---------------------------------------------");
		System.out.println("Au depart : ");
		if(!docs.toString().equals("doc1 doc2 doc3 doc4 doc5")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc1 doc2 doc3 doc4 doc5");
			System.out.println("recu    : "+docs);
			System.out.println("constructeur a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n1 : ouvrir doc3");
		docs.ouvrirDocument("doc3");
		if(!docs.toString().equals("doc3 doc1 doc2 doc4 doc5")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc3 doc1 doc2 doc4 doc5");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n2 : ouvrir doc4");
		docs.ouvrirDocument("doc4");
		if(!docs.toString().equals("doc4 doc3 doc1 doc2 doc5")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc4 doc3 doc1 doc2 doc5");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}

		
		System.out.println("\n3 : ouvrir doc4");
		docs.ouvrirDocument("doc4");
		if(!docs.toString().equals("doc4 doc3 doc1 doc2 doc5")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc4 doc3 doc1 doc2 doc5");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}

		
		System.out.println("\n4 : ouvrir doc5");
		docs.ouvrirDocument("doc5");
		if(!docs.toString().equals("doc5 doc4 doc3 doc1 doc2")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc5 doc4 doc3 doc1 doc2");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n5 : ouvrir doc6");
		docs.ouvrirDocument("doc6");
		if(!docs.toString().equals("doc6 doc5 doc4 doc3 doc1")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc6 doc5 doc4 doc3 doc1");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n6 : ouvrir doc3");
		docs.ouvrirDocument("doc3");
		if(!docs.toString().equals("doc3 doc6 doc5 doc4 doc1")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc3 doc6 doc5 doc4 doc1");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n7 : ouvrir doc6");
		docs.ouvrirDocument("doc6");
		if(!docs.toString().equals("doc6 doc3 doc5 doc4 doc1")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc6 doc3 doc5 doc4 doc1");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		
		System.out.println("\n8 : ouvrir doc7");
		docs.ouvrirDocument("doc7");
		if(!docs.toString().equals("doc7 doc6 doc3 doc5 doc4")){
			System.out.println("contenu ko");
			System.out.println("attendu : doc7 doc6 doc3 doc5 doc4");
			System.out.println("recu    : "+docs);
			System.out.println("methode ouvrirDocument() a revoir");
			return;
		}else{
			System.out.println("--> "+docs);
		}
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
		
	}
}
