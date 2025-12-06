# Projekt Programowanie Obiektowe
# Tekstowa Gra RPG

1. Opis
   Projekt obejmuje konsolową grę RPG, w której gracz tworzy swoją postać, walczy z przeciwnikami,
   zdobywa poziomy, przedmioty, które trafiają do ekwipunku i złoto.
   System walki jest w postaci turowej, każda postać ma mechanikę swojej własnej umiejętności specjalnej
   zależnej od wybranej klasy. Zaimplementowana jest mechanika zapisu gry, w tym automatycznego zapisu.

   Wykorzystano:
   - klasy abstrakcyjne
   - polimorfizm
   - delegacje funkcji
   - enum
   - obsługę wyjątków
   - zapis/odczyt do/z pliku JSON (GSON)
   - asynchroniczność

2. Wymagane do uruchomienia
   - Projekt jest stworzony przy użyciu Java 25
   - Wykorzystana jest biblioteka zewnętrzena GSON (gson-2.10.1)
  
3. Funkcjonalność

    #Tworzenie postaci
     - Wybór imienia
     - Wybór klasy: Wojownik, Łucznik, Mag
       Każda klasa posiada inne statystyki i umiejętność specjalną

    # Walka
     - System turowy
     - Atak podstawowy
     - Umiejętność specjalna (dostępna co 3 tury)
     - Używanie przedmiotów z ekwipunku
  
    # Po wygranej walce
     - Zdobycie punktów doświadczenia (XP)
     - Awans na kolejny poziom (jeśli został przebity próg poziomu)
     - Zdobycie złota
     - Losowa szansa na zdobycie przedmiotu
  
    # Sklep
      - Możliwość zakupienia przedmiotów
        - Mikstura leczenia (+40 HP)
        - Mikstura siły (+15 DMG)
        - Mikstura szczęście (Reset cooldownu umiejętności specjalnej)
       
   # Ekwipunek
     - Przedmioty przechowywane przy użyciu map (nazwa -> ilość)
     - Użycie przedmiotów z ekwipunku podczas walki
  
   # Zapis
     - Ręczny zapis: pytanie o zapisanie rozgrywki po każdej walce
     - Automatyczny zapis: wykonuje się w tle przez osobny wątek co X sekund
     - Dane zapisaywane do pliku save.json
  
   # Wczytywanie gry
     - Przy rozpoczęciu rozgrywki jest możliwość wczytania stanu gry z ostatnio wykonanego zapisu

 4. Struktura projektu

          src/
       ├── Main.java
       ├── UI.java
       ├── Player.java
       ├── Combat.java
       ├── Enemy.java
       ├── EnemyType.java
       ├── CharacterClass.java
       │    ├── Warrior.java
       │    ├── Archer.java
       │    └── Mage.java
       ├── Item.java
       │    ├── HealingPotion.java
       │    ├── StrengthPotion.java
       │    └── LuckPotion.java
       ├── Shop.java
       ├── ClassStats.java
       ├── ConfigLoader.java
       ├── Save.java
       ├── SaveManager.java
       ├── AutoSaveThread.java
      
      test/
       ├── PlayerGoldTest.java
       ├── PlayerXPTest.java
       ├── EnemyDamageTest.java
       ├── SpecialAbilityTest.java
       └── SaveLoadTest.java
      
      save.json
      class_config.json



  5. Przykład formatu zapisu do pliku save.json

    {
      "playerName": "Filip",
      "className": "Mag",
      "level": 3,
      "xp": 100,
      "health": 80,
      "gold": 75,
      "round": 7,
      "inventory": {
        "Mikstura siły": 1
      }
    }


  6. Unit testy

     Zaimplementowane są Unit Testy przy użyciu JUnit:
     - test wydania, otrzymania złota i sprawdzenie działania ograniczenia
     - test poziomu i doświadczenia
     - test zakresu obrażeń przeciwników
     - test użycia przedmiotu
     - test poprawności zapisu i odczytu rozgrywki
    
 7. Technologie
    - Java 25
    - Biblioteka GSON
    - JUnit 4

 8. Autor
    Filip Rutkowski
    Projekt zaliczeniowy
    Programowanie Obiektowe


   
      



