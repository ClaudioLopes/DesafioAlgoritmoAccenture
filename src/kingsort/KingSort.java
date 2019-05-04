package kingsort;

import static java.lang.String.join;
import java.util.Arrays;
import static java.util.Collections.nCopies;
import java.util.Comparator;

public class KingSort {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] aux = {"Philippe VI", "Jean II", "Charles V", "Charles VI", "Charles VII", "Louis XI"};
        aux = getSortedList(aux);
        aux = retornaParaRomano(aux);
        for(int i = 0; i < aux.length; i++){
            System.out.println(aux[i]);
        }
        
    }
    
    private static String[] getSortedList(String[] kings){
        String[] containing = preparaVetor(kings);
        
        Arrays.sort(containing, new Comparator() {
			public int compare(Object o1, Object o2) {
				String a = (String) o1;
				String b = (String) o2;
				return a.compareTo(b);
			}
		});
        
        return containing;
    }
    
    private static String[] preparaVetor(String[] vet){
        String[] king = new String[vet.length];
        
        for(int i = 0; i < vet.length; i++){
            String[] Auxiliar;
            Auxiliar = vet[i].split(" ");
            Auxiliar[1] = traduzirNumeralRomano(Auxiliar[1]);
            king[i] = Auxiliar[0] + " " + Auxiliar[1];
        }
        
        return king;
    }
    
    private static String traduzirNumeralRomano(String texto) {
		int n = 0;
		int numeralDaDireita = 0;
		for (int i = texto.length() - 1; i >= 0; i--) {
			int valor = (int) traduzirNumeralRomano(texto.charAt(i));
			n += valor * Math.signum(valor + 0.5 - numeralDaDireita);
			numeralDaDireita = valor;
		}
                String dec = (n < 10 ? "0" : "") + n;
		return dec;
	}
    private static double traduzirNumeralRomano(char caractere) {
		return Math.floor(Math.pow(10, "IXCM".indexOf(caractere))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(caractere)));
    }
    
    private static String converterEmRomanos(int decimal) {
        StringBuilder resultado = new StringBuilder();
        int[] DECIMAIS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ROMANOS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for (int i = 0; i < DECIMAIS.length; i++) {
            int parteInteira = decimal / DECIMAIS[i];
            decimal -= DECIMAIS[i] * parteInteira;
            resultado.append(join("", nCopies(parteInteira, ROMANOS[i])));
        }
        return resultado.toString();
    }
    
    private static  String[] retornaParaRomano(String[] vet){
        String[] king = new String[vet.length];
        
        for(int i = 0; i < vet.length; i++){
            String[] Auxiliar;
            Auxiliar = vet[i].split(" ");
            Auxiliar[1] = converterEmRomanos(Integer.valueOf(Auxiliar[1]));
            king[i] = Auxiliar[0] + " " + Auxiliar[1];
        }
        
        return king;
    }
}
