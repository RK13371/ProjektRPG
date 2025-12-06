# Dokumentacja deweloperska - Projekt Gra RPG

### Autor: Filip Rutkowski
### Technologia: Java
### Biblioteki: GSON (zapis/odczyt JSON), JUnit (testy jednostkowe)


1. Struktura projektu:
```
  src/
  ├── Main.java
  ├── UI.java
  ├── Player.java
  ├── Combat.java
  ├── Enemy.java
  ├── EnemyType.java
  ├── CharacterClass.java
  │ ├── Warrior.java
  │ ├── Archer.java
  │ └── Mage.java
  ├── ClassStats.java
  ├── Shop.java
  ├── Item.java
  │ ├── HealingPotion.java
  │ ├── StrengthPotion.java
  │ └── LuckPotion.java
  ├── Save.java
  ├── SaveManager.java
  ├── AutoSaveThread.java
  ├── ConfigLoader.java
  test/
  ├── PlayerGoldTest.java
  ├── PlayerXPTest.java
  ├── EnemyDamageTest.java
  ├── SpecialAbilityTest.java
  ├── SaveLoadTest.java
  ├── PlayerInventoryTest.java
  resources/
  ├── save.json  
  ├── class_config.json
```
3. Klasy

#Main:
 - Główna pętla gry
 - Menu startowe
 - Wywoływanie poszczególnych etapów rozgrywki

#Player
Przechowuje wszystkie statystyki postaci:

- HP, dmg
- poziom (lvl)
- doświadczenie (xp)
- ekwipunek (mapa: nazwa → ilość)
- cooldown umiejętności
- metody:
  - zdobywanie XP
  - levelowanie
  - otrzymywanie obrażeń
  - używanie przedmiotów
  - dodawanie i wydawanie złota

CharacterClass (abstrakcyjna):
 - Podstawowe statystyki postaci według klas
 - Polimorficzna metoda specialAbility
Podklasy:
 - Warrior
 - Archer
 - Mage

Enemy / EnemyType:
 - Przeciwnicy: Goblin, Troll, Gryf
 - Losowe obrażenia (+/- 5)
 - Skalowanie statystyk na podstawie rundy

Combat:
 - Logika walki 
 - Obsługa ataków, przedmiotów, specjalnych umiejętności

Item (abstrakcyjna):
 Podklasy implementują efekty:

 Przedmiot      | Działanie       
 -------------- | --------------- 
 HealingPotion  | +40 HP          
 StrengthPotion | +15 dmg         
 LuckPotion     | Reset cooldownu 


Shop:
 - Obsługa kupna przedmiotów

Save / SaveManager:
 - Zapis i odczyt do/z JSON za pomocą biblioteki GSON
 Zapisuje m.in.:
 - imię postaci
 - klasę
 - statystyki
 - rundę
 - ekwipunek
 - złoto

AutoSaveThread:
 - Działa równolegle z grą
 - Zapisuje stan rozgrywki co X sekund
 - nie blokuje interakcji gracza podczas rozgrywki
 
3. Asynchroniczność
 Gra wykorzystuje wątki (Thread)
 - Osobny wątek AutoSave, który działa w tle
 - Główna pętla rozgrywki może przyjmować input od użytkownika w trakcie działania autosave

4. JSON - zapis i odczyt:
 Przykład z pliku save.json: 

{
 "playerName":"Filip",
 "className":"Mag",
 "level":3,
 "xp":100,
 "health":80,
 "attackCount":3,
 "round":7,
 "gold":75,
 "inventory": {
    "Mikstura siły":1
 }
}


5. Test jednostkowe (JUnit):
 W projekcie zaimplementowane jest klka testów:

 PlayerGoldTest:
 - test poprawności zdobywania i wydawania złota

 PlayerXPTest:
 - test działania zdobywania poziomu

 EnemyDamageTest: 
 - test granicy losowości obrażeń przeciwnika

 PlayerInventoryTest: 
 - test użycia przedmiotu

 SpecialAbilityTest:
 - test działania umiejętności specjalnej

 SaveLoadTest:
 - test wczytania wczytania zapisanej rozgrywki


W projekcie zastosowałem
- Dziedziczenie klas: klasy postaci i przedmiotów
- Polimorfim: specialAbility, itemEffect
- Delegacja: np. z Main do Shop, SaveManager
- Asynchroniczność: AutoSaveThread
- Obsługa JSON (GSON)



 


 

 
