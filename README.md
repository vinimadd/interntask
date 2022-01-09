# Internship task 2022


## Zadanie 3

- Program pobiera dane z API Github
- Dla wskazanego użytkownika zwraca w formie tablcy informacje - nazwę repozytorium, ilość gwiazdek repozytorium, sumę gwiazdek z wszystkich dostępnych repozytoriów.  
- W projekcie wykorzystany został framework Spring Boot.
- W kodzie dodany został segment v1 URL, który w przypadku wprowadzenia zmian w API umożliwia łatwie odesłanie klienta do używania nowej wersji programu poprzez np. update aplikacji.
 
## Uruchomienie

Program można uruchomić pobierając projekt a następnie otwierając w dowolnym IDE lub w terminalu wpisując: 

```sh
./mvnw spring-boot:run
```

Po połączeniu się z serwerem należy wpisać poniższy adres w aplikacji postman lub w przeglądarce:


```sh
localhost:8080/api/v1/users/{username}/repos
```

uzupełniając pole {username} loginem użytkownika github, dla którego chcemy pobrać dane.

## Część dodatkowa zadania

Do listowania najpopularniejszych języków programowania oraz sumy ich wielkości użyłabym kolekcji Map, która pozwala na użycie pary klucz:wartość. W omawianym przypadku byłoby to język programowania:wielkość. Dane do pobrania zostałyby przygotowane tak jak w pierwszej części zadania w klasie GithubRepo - zmianie poddane zostałyby pola, które chcemy wykorzystać.

- W pierwszym kroku dzięki pętli forEach sprawdzeniu poddany zostałby klucz z wartością pobranego pola dla języka programowania. Jeśli klucz = pole, zostanie dodana wartość bajtów dla wartości klucza.
- Kolejnym krokiem byłoby posortowanie danych oraz przepisanie wyniku do tablicy, która następnie zostanie zwrócona.

Niestety ze względu na małe doświadczenie z implementacją kolekcji Map nie dodawałam kodu dla tej części zadania.

## Propozycje dla istniejącego projektu

W celu ulepszenia projektu oraz w ramach najlepszych praktyk, w projekcie mogłyby się znaleźć:

- testy metod
- użycie biblioteki lombok w klasie odpowiedzialnej za pobieranie wskazanych pól z API
- zmiana prezentacji danych z tablicy na listę
- obsługa błędów/wyjątków w przypadku, gdy nie można zwrócić danych z serwera 



