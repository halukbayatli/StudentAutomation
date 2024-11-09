package Package;

import java.io.IOException;
import java.util.Scanner;

public class AnaSayfa {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = 0;
		System.out.print("N: ");
		N = Integer.parseInt(sc.nextLine());
		Bolum[] bolumler = crearteDepartment(N);

		boolean control = true;
		int choose = 0;
		while(control) {
			System.out.println();
			System.out.println("1- Tüm bölümleri Listele");
			System.out.println("2- Öğrencileri Listele");
			System.out.println("3- Teorik Dersleri Listele");
			System.out.println("4- Pratik Dersleri Listele");
			System.out.println("5- Arama Yap");
			System.out.println("6- Çıkış");
			System.out.print("İşlem seçimi: ");
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
				case 1:
					departmentList(bolumler);
					break;
				case 2:
					classStudentList(bolumler);
					break;
				case 3:
					theoreticalLectureList(bolumler);
					break;
				case 4:
					practicalLectureList(bolumler);
					break;
				case 5:
					searchOperation(bolumler);
					break;
				case 6:
					control = false;
					break;
				default:
					System.out.println("Lütfen geçerli bir işlem yapınız...");
			}
			System.out.println("\n");
		}
	}

	private static Bolum[] crearteDepartment(int N) {
		Bolum[] bolumler = new Bolum[N];

		String bol_ad;
		int bol_no, ogr_sayi;

		String ogr_ad, ogr_soyad;
		int ogr_sinif;

		String ders_adi;
		int ders_kredi, teorik_ders_sayi, pratik_ders_sayi;

		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println("---------- " + (i + 1) + ". Bölüm ----------");
			System.out.print("Bölüm numarası giriniz: ");
			bol_no = Integer.parseInt(sc.nextLine());
//			bol_no = sc.nextInt();
//			sc.nextLine();
			System.out.print("Bölüm adı giriniz: ");
			bol_ad = sc.nextLine();
			bolumler[i] = new Bolum(bol_no, bol_ad);
			System.out.println();
			System.out.print("Bölümdeki öğrenci sayısı giriniz: ");
			ogr_sayi = Integer.parseInt(sc.nextLine());
//			ogr_sayi = sc.nextInt();
//			sc.nextLine();
			bolumler[i].ogrenciler = new Ogrenci[ogr_sayi];
			for (int j = 0; j < ogr_sayi; j++) {
				System.out.println("---------- " + (j + 1) + ". Öğrenci ----------");
				System.out.print("Öğrenci adı giriniz: ");
				ogr_ad = sc.nextLine();
				System.out.print("Öğrenci soyadı giriniz: ");
				ogr_soyad = sc.nextLine();
				System.out.print("Öğrenci sınıfı giriniz: ");
				ogr_sinif = Integer.parseInt(sc.nextLine());
//				ogr_sinif = sc.nextInt();
//				sc.nextLine();
				bolumler[i].ogrenciler[j] = new Ogrenci(bolumler[i].getBolNo(), ogr_ad, ogr_soyad, ogr_sinif);
				System.out.println();
			}
			System.out.print("Bölümdeki teorik ders sayısını giriniz: ");
			teorik_ders_sayi = sc.nextInt();
			sc.nextLine();
			bolumler[i].teorikDersler = new TeorikDers[teorik_ders_sayi];
			for (int j = 0; j < teorik_ders_sayi; j++) {
				System.out.println("---------- " + (j + 1) + ". Teorik Ders ----------");
				System.out.print("Teorik dersin adını giriniz: ");
				ders_adi = sc.nextLine();
				System.out.print("Teorik dersin kredisini giriniz: ");
				ders_kredi = Integer.parseInt(sc.nextLine());
//				ders_kredi = sc.nextInt();
//				sc.nextLine();
				bolumler[i].teorikDersler[j] = new TeorikDers(bolumler[i].getBolNo(), ders_adi, ders_kredi);
				System.out.println();
			}
			System.out.print("Bölümdeki pratik ders sayısını giriniz: ");
			pratik_ders_sayi = Integer.parseInt(sc.nextLine());
//			pratik_ders_sayi = sc.nextInt();
//			sc.nextLine();
			bolumler[i].pratikDersler = new PratikDers[pratik_ders_sayi];
			for (int j = 0; j < pratik_ders_sayi; j++) {
				System.out.println("---------- " + (j + 1) + ". Pratik Ders ----------");
				System.out.print("Pratik dersin adını giriniz: ");
				ders_adi = sc.nextLine();
				System.out.print("Pratik dersin kredisini giriniz: ");
				ders_kredi = Integer.parseInt(sc.nextLine());
//				ders_kredi = sc.nextInt();
//				sc.nextLine();
				bolumler[i].pratikDersler[j] = new PratikDers(bolumler[i].getBolNo(), ders_adi, ders_kredi);
				System.out.println();
			}
			System.out.println();
		}
		return bolumler;
	}

	private static void departmentList (Bolum[] listBolumler) {
		for (int i = 0; i < listBolumler.length; i++) {
			System.out.printf("Bölüm No: %d		Bölüm Ad: %s\n",
					listBolumler[i].getBolNo(),
					listBolumler[i].getBolAd());
			System.out.println("Öğrenciler:");
			for (int j = 0; j < listBolumler[i].ogrenciler.length; j++) {
				System.out.printf("%d. Öğrenci:  ID: %d	%s %s	Sınıf: %d\n",
						j + 1,
						listBolumler[i].ogrenciler[j].getOgrID(),
						listBolumler[i].ogrenciler[j].getOgrAd(),
						listBolumler[i].ogrenciler[j].getOgrSoyad(),
						listBolumler[i].ogrenciler[j].getOgrSinif());
			}
			System.out.println("\nTeorik Dersler:");
			for (int j = 0; j < listBolumler[i].teorikDersler.length; j++) {
				System.out.printf("%d. Ders: ID: %d  %s  Kredi: %d\n",
						j + 1,
						listBolumler[i].teorikDersler[j].getDersID(),
						listBolumler[i].teorikDersler[j].getDersAd(),
						listBolumler[i].teorikDersler[j].getDersKredi());
			}
			System.out.println("\nPratik Dersler:");
			for (int j = 0; j < listBolumler[i].pratikDersler.length; j++) {
				System.out.printf("%d. Ders: ID: %d  %s  Kredi: %d\n",
						j + 1,
						listBolumler[i].pratikDersler[j].getDersID(),
						listBolumler[i].pratikDersler[j].getDersAd(),
						listBolumler[i].pratikDersler[j].getDersKredi());
			}
			System.out.println("\n");
		}
	}

	private static void classStudentList (Bolum[] listBolumler) {
		for (int c_Index = 1; c_Index != 5; c_Index++) {
			boolean control = true;
			for (int i = 0; i < listBolumler.length; i++) {
				for (int j = 0; j < listBolumler[i].ogrenciler.length; j++) {
					if (c_Index == listBolumler[i].ogrenciler[j].getOgrSinif()) {
						if(control) {
							System.out.println(c_Index + ". Sınıf Öğrenciler:");
							control = false;
						}
						System.out.printf("		ID: %d	%s %s\n",
								listBolumler[i].ogrenciler[j].getOgrID(),
								listBolumler[i].ogrenciler[j].getOgrAd(),
								listBolumler[i].ogrenciler[j].getOgrSoyad());
					}
				}
			}
			if(!control)
				System.out.println();
		}
		System.out.println("\n");
	}

	private static void theoreticalLectureList (Bolum[] listBolumler) {
		int maxCredit = Integer.MIN_VALUE, minCredit = Integer.MAX_VALUE;
		int creditLesson;
		for (int i = 0; i < listBolumler.length; i++) {
			for (int j = 0; j < listBolumler[i].teorikDersler.length; j++) {
				creditLesson = listBolumler[i].teorikDersler[j].getDersKredi();
				if (maxCredit < creditLesson)
					maxCredit = creditLesson;
				if (minCredit > creditLesson)
					minCredit = creditLesson;
			}
		}
		for (int credit = minCredit; credit <= maxCredit; credit++) {
			boolean control = true;
			for (int i = 0; i < listBolumler.length; i++) {
				for (int j = 0; j < listBolumler[i].teorikDersler.length; j++) {
					if (credit == listBolumler[i].teorikDersler[j].getDersKredi()) {
						if(control) {
							System.out.println(credit + " Kredilik Dersler:");
							control = false;
						}
						System.out.printf("		ID: %d %s\n",
								listBolumler[i].teorikDersler[j].getDersID(),
								listBolumler[i].teorikDersler[j].getDersAd());
					}
				}
			}
			if(!control)
				System.out.println();
		}
		System.out.println("\n");
	}

	private static void practicalLectureList (Bolum[] listBolumler) {
		int maxCredit = Integer.MIN_VALUE, minCredit = Integer.MAX_VALUE;
		int creditLesson;
		for (int i = 0; i < listBolumler.length; i++) {
			for (int j = 0; j < listBolumler[i].pratikDersler.length; j++) {
				creditLesson = listBolumler[i].pratikDersler[j].getDersKredi();
				if (maxCredit < creditLesson)
					maxCredit = creditLesson;
				if (minCredit > creditLesson)
					minCredit = creditLesson;
			}
		}
		for (int credit = minCredit; credit <= maxCredit; credit++) {
			boolean control = true;
			for (int i = 0; i < listBolumler.length; i++) {
				for (int j = 0; j < listBolumler[i].pratikDersler.length; j++) {
					if (credit == listBolumler[i].pratikDersler[j].getDersKredi()) {
						if(control) {
							System.out.println(credit + " Kredilik Dersler:");
							control = false;
						}
						System.out.printf("		ID: %d %s\n",
								listBolumler[i].pratikDersler[j].getDersID(),
								listBolumler[i].pratikDersler[j].getDersAd());
					}
				}
			}
			if(!control) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}

	private static void searchOperation(Bolum[] listBolumler) {
		String searchWord;
		System.out.print("Aranacak kelime giriniz: ");
		searchWord = sc.nextLine().toLowerCase();
		if(searchWord.split(" ").length ==  1)
			searchWord = searchWord.replaceAll("[^a-zA-Z0-9 ]", "");
		else
			searchWord = searchWord.replaceAll("[^a-zA-Z0-9]","");
		boolean control_1 = false,control_2 = false,control_3 = false;
		int index_1 = 0,index_2 = 0;
		for(int i = 0; i < listBolumler.length; i++) {
			control_1 = false;
			for(int j = 0; j < listBolumler[i].ogrenciler.length; j++) {
				if(listBolumler[i].ogrenciler[j].getOgrAd().toLowerCase().contains(searchWord) || listBolumler[i].ogrenciler[j].getOgrSoyad().toLowerCase().contains(searchWord)) {
					control_1 = true;
					index_1 = i;
					index_2 = j;
				}
			}
			if(control_1)
				break;
			control_2 = false;
			for(int j = 0; j < listBolumler[i].teorikDersler.length; j++) {
				if(listBolumler[i].teorikDersler[j].getDersAd().toLowerCase().contains(searchWord)) {
					control_2 = true;
					index_1 = i;
					index_2 = j;
				}
			}
			if(control_2)
				break;
			control_3 = false;
			for(int j = 0; j < listBolumler[i].pratikDersler.length; j++) {
				if(listBolumler[i].pratikDersler[j].getDersAd().toLowerCase().contains(searchWord)) {
					control_3 = true;
					index_1 = i;
					index_2 = j;
					break;
				}
			}
			if(control_3)
				break;
		}
		if(control_1) {
			System.out.println("Bölüm: "+listBolumler[index_1].getBolAd());
			System.out.println("ID: "+ listBolumler[index_1].ogrenciler[index_2].getOgrID());
			System.out.println("Ad: "+ listBolumler[index_1].ogrenciler[index_2].getOgrAd());
			System.out.println("Soyad: "+ listBolumler[index_1].ogrenciler[index_2].getOgrSoyad());
			System.out.println("Sınıf: "+ listBolumler[index_1].ogrenciler[index_2].getOgrSinif());
		}
		else
			System.out.println("Öğrenci bulunamadi...");
		if(control_2) {
			System.out.println("Bölüm: "+listBolumler[index_1].getBolAd());
			System.out.println("ID: "+listBolumler[index_1].teorikDersler[index_2].getDersID());
			System.out.println(listBolumler[index_1].teorikDersler[index_2].getDurum());
			System.out.println("Ders: "+listBolumler[index_1].teorikDersler[index_2].getDersAd());
			System.out.println("Kredi: "+listBolumler[index_1].teorikDersler[index_2].getDersKredi());
		}
		else
			System.out.println("Teorik ders bulunamadi...");
		if(control_3) {
			System.out.println("Bölüm: "+listBolumler[index_1].getBolAd());
			System.out.println("ID: "+listBolumler[index_1].pratikDersler[index_2].getDersID());
			System.out.println(listBolumler[index_1].pratikDersler[index_2].getDurum());
			System.out.println("Ders: "+listBolumler[index_1].pratikDersler[index_2].getDersAd());
			System.out.println("Kredi: "+listBolumler[index_1].pratikDersler[index_2].getDersKredi());
		}
		else
			System.out.println("Pratik ders bulunamadi...");
		System.out.println("\n");
	}
}