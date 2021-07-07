#Zadanie 4.




Celem zadania jest napisanie funkcji sprawdzającej, czy podany tekst jest kodem kreskowym EAN-13 lub EAN-8.
Na wejściu funkcji są dwa parametry:

- wejściowy kod kreskowy: parametr tekstowy
- rodzaj kodu kreskowego - parametr numeryczny: 1 dla EAN-8, 2 dla EAN-13.
  
  Niektóre towary (np. czasopisma) mają dodatkowe kody (tzw. add-on'y) - należy mieć na uwadze, 
  że skaner może dokleić je bezpośrednio do właściwego kodu kreskowego (np. dla towaru o kodzie 
  "6920702707721" oraz add-on’ie "12" na wejściu możliwy jest ciąg "692070270772112"). 
  
Należy założyć, że add-on'y mogą występować zarówno dla kodów EAN-8 jaki i EAN-13.
  Należy mieć na uwadze, że niektóre skanery kodów kreskowych mogą wycinać z kodu kreskowego 
pierwsze wiodące zero (np. zamiast kodu "0075678164125" przesyłają "075678164125").

  Na wyjściu funkcja powinna zwracać prawidłowy kod kreskowy (o długości 8 lub 13 znaków) bez ewentualnego add-on'u.
  Ewentualne błędy w danych wejściowych powinny być sygnalizowane wyjątkami.

#Informacje na temat kodów kreskowych: http://pl.wikipedia.org/wiki/EAN
