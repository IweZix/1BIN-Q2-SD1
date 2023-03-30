import java.util.LinkedList;

/**
 * @author NICOLAS Luca
 */

public class DocumentsLRU {

	private LinkedList<String> listeLRU;
	
	
	/**
	 * construit une liste de nombreDocuments documents : doc1 doc2 ...
	 * @param nombreDocuments
	 * @throws IllegalArgumentException il faut au moins 1 document
	 */
	public DocumentsLRU(int nombreDocuments){
		if (nombreDocuments < 1) throw new IllegalArgumentException("Il faut au moins 1 document");
		listeLRU = new LinkedList<String>();
		for (int i = 0; i < nombreDocuments; i++) {
			listeLRU.add("doc" + (i+1));
		}
	}
	

	/**
	 * place le document passe en parametre dans la liste selon le mecanisme LRU
	 * @param le document qui est ouvert
	 * @throws IllegalArgumentException si le document est null ou ""
	 */
	public void ouvrirDocument(String document){
		if (document == null || document.equals("")) throw new IllegalArgumentException("document est null ou \"\"");
		if (listeLRU.contains(document)){
			String doc = document;
			listeLRU.remove(document);
			listeLRU.addFirst(doc);
		} else {
			listeLRU.addFirst(document);
			listeLRU.removeLast();
		}
	}
	
	
	public String toString(){
		return listeLRU.toString();
	}
	
}
