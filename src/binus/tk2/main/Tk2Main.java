package binus.tk2.main;

import java.util.Scanner;

public class Tk2Main {

	private static boolean keepLoop = true;
	
	private static boolean validasiNama(String nama) {
		int panjangNama = (nama != null) ? nama.length() : 0;
		if (panjangNama >= 1 && panjangNama <= 25) {
			return false;
		}
		System.out.println("KESALAHAN! Jumlah karakter wajib nama minimal 1 dan maksimal 25\nSilahkan input ulang...\n");
		return true;
	}
	
	private static void enableLoop() {
		keepLoop = true;
	}
	
	private static boolean validasiNIM(String nim) {
		int panjangNIM = (nim != null) ? nim.length() : 0;
		if (panjangNIM == 10) {
//			if (nim.matches("/^[0-9]{1,10}$/")) {
				return false;
//			} else {
//				System.out.println("KESALAHAN! Jumlah karakter NIM hanya boleh angka\nSilahkan input ulang...\n");
//			}
		} else {
			System.out.println("KESALAHAN! Jumlah karakter NIM wajib 10\nSilahkan input ulang...\n");
		}
		return true;
	}
	
	private static boolean validasiAngka(int angka) {
		if (angka >= 5 && angka <= 20) {
			return false;
		}
		System.out.println("KESALAHAN! Angka yang boleh di-input hanya 5--20\nSilahkan input ulang...\n");
		return true;
	}
	
	private static void tampilkanBilanganGenap(int angka) {
		int jumlahBilanganGenap = 0;
		int bilanganGenap = 2;
		System.out.println(" " + angka + " Bilangan Genap :");
		for (int x=0; x<angka; x++) {
			System.out.print(bilanganGenap + " ");
			jumlahBilanganGenap+=bilanganGenap;
			bilanganGenap+=2;
		}
		System.out.println("\nHasil Penjumlahan = " + jumlahBilanganGenap);
	}
	
	private static void tampilkanBilanganGanjil(int angka) {
		int jumlahBilanganGanjil = 0;
		int bilanganGanjil = 1;
		System.out.println(" " + angka + " Bilangan Ganjil :");
		for (int x=0; x<angka; x++) {
			System.out.print(bilanganGanjil + " ");
			jumlahBilanganGanjil+=bilanganGanjil;
			bilanganGanjil+=2;
		}
		System.out.println("\nHasil Penjumlahan = " + jumlahBilanganGanjil);
	}
	
	private static void tampilkanBilanganFibonacci(int angka) {
		int jumlahBilanganFibonacci = 0;
		int bilanganSebelumnya = 0;
		int bilanganSaatIni = 1;
		System.out.println(" " + angka + " Bilangan Fibonacci :");
		for (int x=0; x<angka; x++) {
			System.out.print(bilanganSaatIni + " ");
			jumlahBilanganFibonacci+=bilanganSaatIni;
			int bilanganSelanjutnya = bilanganSebelumnya + bilanganSaatIni;
			bilanganSebelumnya = bilanganSaatIni;
			bilanganSaatIni = bilanganSelanjutnya;
		}
		System.out.println("\nHasil Penjumlahan = " + jumlahBilanganFibonacci);
	}
	
	private static boolean validasiUlang(String ulang) {
		ulang = (ulang != null) ? ulang : "a";
		if ("Y".equals(ulang) || "y".equals(ulang) || 
				"T".equals(ulang) || "t".equals(ulang)) {
			return false;
		}
		System.out.println("KESALAHAN! Input yang diterima hanya 'y' atau 't'\nSilahkan input ulang...\n");
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sInput = new Scanner(System.in);
		String nama = "";
		String nim = "";
		int angka = 0;
		String ulang = "";
		try {
			do {
				do {
					System.out.print("Masukkan Nama Anda [1..25] : ");
					nama = sInput.nextLine();
					System.out.println();
					keepLoop = validasiNama(nama);
				} while (keepLoop);
				enableLoop();
				
				do {
					System.out.print("Masukkan NIM Anda [harus 10 karakter] : ");
					nim = sInput.nextLine();
					System.out.println();
					keepLoop = validasiNIM(nim);
				} while (keepLoop);
				enableLoop();
				
				System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
				System.out.println("Registrasi Sukses.. \n");
				System.out.println("Selamat datang " + nama + " [NIM : " + nim + "].. ^^v \n");
				System.out.println("Mari Belajar macam-macam deret bilangan..\n");
				
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
				do {
					System.out.print("Masukkan Sembarang Angka [5..20] : ");
					angka = sInput.nextInt();
					// To Consume '\n' on previous nextInt().
					sInput.nextLine();	
					System.out.println();
					keepLoop = validasiAngka(angka);
				} while (keepLoop);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
				enableLoop();
				
				System.out.println("Deret Bilangan");
				System.out.println("###############\n");
				
				tampilkanBilanganGenap(angka);
				System.out.println();
				tampilkanBilanganGanjil(angka);
				System.out.println();
				tampilkanBilanganFibonacci(angka);
				System.out.println();
				
				do {
					System.out.print("Anda ingin mengulang [y/t] : ");
					ulang = sInput.nextLine();
					System.out.println();
					keepLoop = validasiUlang(ulang);
				} while (keepLoop);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
			} while ("Y".equals(ulang) || "y".equals(ulang));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sInput.close();
		}
	}
	
}
