package SiteGerador;

import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorDeSenha {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		SecureRandom rng = new SecureRandom();
		
		System.out.println("==== Gerador de senhas ====");
		
		System.out.print("Comprimento da senha (ex: 12): ");
		int len = sc.nextInt();
		sc.nextLine(); 
		
		System.out.print("Incluir Letras minúscula? (s/n)"); 
		boolean useLower = sc.nextLine().trim().equalsIgnoreCase("s");
		System.out.print("Incluir Letras Maiúscula? (s/n)"); 
		boolean useUpper = sc.nextLine().trim().equalsIgnoreCase("s");
		System.out.print("Incluir Digitos? (s/n)"); 
		boolean useDigits = sc.nextLine().trim().equalsIgnoreCase("s");
		System.out.print("Incluir Simbolos? (s/n)");
		boolean useSymblos = sc.nextLine().trim().equalsIgnoreCase("s");
		
		if (len <= 11) {
			System.out.print("Comprimento Inválido");
			sc.close();
			return;
		}
		
		if (!useLower && !useUpper && !useDigits && !useSymblos) {
			System.out.print("Seleione ao menos um tipo de caractere.");
			sc.close();
			return;
		}
		                
		String lower = "adcdefghijklmnopqrstuvwxyz";
		String Upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Digits = "0123456789";
		String Symblos = "!@#$%&*()-_=+[]{};:,.?/";
		
		StringBuilder pool = new StringBuilder();
		if (useLower) pool.append (lower);
		if (useUpper) pool.append (Upper);
		if (useDigits) pool.append (Digits);
		if (useSymblos) pool.append (Symblos);
		
		StringBuilder senha = new StringBuilder();
		if (useLower) senha.append (lower.charAt(rng.nextInt(lower.length())));
		if (useUpper) senha.append (Upper.charAt(rng.nextInt(Upper.length())));
		if (useDigits) senha.append (Digits.charAt(rng.nextInt(Digits.length())));
		if (useSymblos) senha.append(Symblos.charAt(rng.nextInt(Symblos.length())));
		
		while (senha.length() < len) {
			int idx = rng.nextInt(pool.length());
			senha.append(pool.charAt(idx));
		}
		
		char[] chars = senha.toString().toCharArray(); 
		for (int i = 0; i < chars.length; i++) { 
			int j = rng.nextInt(chars.length); 
			char tmp = chars[i]; 
			chars[i] = chars[j]; 
			chars [j] = tmp;
		}
		
		System.out.println("Senha Gerada: " + new String(chars));
		sc.close();	
	}

}
