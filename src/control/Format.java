package control;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Format extends PlainDocument {

	public enum TipoEntrada {
        NOME, TELEFONE;    
       }
		
	 private int tamanhoMax;
     private TipoEntrada tpEntrada;
     
     public Format(int tamanhoMax, TipoEntrada tpEntrada){
         this.tamanhoMax = tamanhoMax;
         this.tpEntrada = tpEntrada; 
     }

     
     @Override
     public void insertString(int i, String string, AttributeSet as) throws BadLocationException  {
     	
     	if(string == null || getLength() == tamanhoMax) {
     		return;
     	}
     	
     	int totalCarac = getLength() + string.length();
     	
     	String regex = "";
         switch(tpEntrada) {
         case NOME:    regex = "[^\\p{IsLatin} ][^0-9]"; break;
         case TELEFONE:	  regex = "[^0-9]"; break;          
         }  
         
         string = string.replaceAll(regex, "");
         
         
         if(totalCarac <= tamanhoMax) {
         	super.insertString(i, string, as);
         }else {
         	String nova = string.substring(0, tamanhoMax);
         	super.insertString(i, nova, as);
         }
         
         
     }
     
}
