# Autor: Filip Rutkowski

# DOKUMENTACJA UŻYTKOWNIKA - Projekt Gra RPG

## 1. Wprowadzenie
Gra jest konsolowym RPG tekstowym. Gracz może utworzyć postać, walczy z przeciwnikami,
po drodze zdobywa punkty doświadczenia, złoto i przedmioty co może zostać użyte w walce.
W projekcie zawarte jest:
- system walki turowej z przeciwnikami
- levelowanie postaci
- sklep z przedmiotami i ekwipunek do ich przechowywania
- zapis i wczytywanie gry, również zapis automatyczny działający w tle

## 2. Uruchomienie gry
1. Otwarcie projektu
2. Wybranie pliku 'Main.java'
3. Uruchomienie

## 3. Menu główne
Po uruchomieniu wyświetla się:
1. Nowa gra - tworzenie nowej rozgrywki, postaci.
2. Wczytaj grę - wczytanie stanu gry z pliku save.json.

W przypadku braku zapisu, gra automatycznie przejdzie do nowej rozgrywki.

## 4. Tworzenie postaci
Użytkownik musi wykonać poniższe kroki:
1. Podanie imienia postaci.
2. Wybranie jednej z poniższych klas
	- Wojownik: wysoka ilość punktów życia, średnie obrażenia
	- Łucznik: niska ilość punktów życia, wysokie obrażenia
	- Mag: niska ilość punktów życia, wysokie obrażenia, najsilniejsza umiejętność specjalna
Każda klasa ma własną wersję ataku specjalnego.

## 5. Przebieg walki
Walka odbywa się w systemie turowym.
W każdej turze gracz może dokonać poniższych wyborów:

1. Zwykły atak
2. Użycie umiejętności specjalnej (dostępna co 3 tury)
3. Użycie przedmiotu z ekwipunku

Po akcji gracza atakuje przeciwnik.
Gdy punkty życia przeciwnika lub gracz osiągną wartość 0 to walka się kończy.

## 6. Po walce
Po wygraniu walki, gracz zdobywa:
- Punkty doświadczenia (XP)
- Złoto 
- Szansa na zdobycie przedmiotu (losowo)

## 7. Sklep
Po walce gracz może otworzyć sklep.
Przedmioty w sklepie:
Mikstura leczenia | +40 HP | Koszt: 40 złota
Mikstura siły | +15 dmg | Koszt: 30 złota
Mikstura szczęścia | Reset cooldownu umiejętności specjalnej | Koszt: 60 złota

## 8. Ekwipunek
Zdobyte i zakupione przedmioty są przechowywane w ekwipunku,
można je użyć podczas walki.

## 9. Zapis
- Zapis ręczny:
Po każdej walce gra pyta czy użytkownik chce zapisać gre, a zapis trafia do pliku save.json

- Zapis automatyczny:
Gra automatycznie zapisuje stan gry w tle co kilka sekund

## 10. Zakończenie gry 
Gra kończy się, gdy:
- Gracz zginie
- Gracz wybierze wyjście z gry

Wyświetlane są wtedy statystyki postaci.









