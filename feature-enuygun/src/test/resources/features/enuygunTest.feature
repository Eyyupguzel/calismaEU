@test
Feature: enuygun

  Scenario: En Uygun - Istanbul/Ankara 10:00-18:00 Kalkis Listeleme
    Given go to enuygunTest page with Chrome
    * i isVisible element anaSayfa
    * i click element gidis-donus
    * send keys istanbul sabiha to element nereden
    * i click element firstOption
    * send keys ankara esen to element nereye
    * i click element firstOptionReturn
    * i click element gidisTarihi
    * click on the desired date for departure 15 Haziran 2024
    * i click element donusTarihi
    * click on the desired date for return 15 Haziran 2024
    * i click element ucusArama
    * i isVisible element ucusSecimSayfası
    * i click element kalkisSaati
    * 10:00-18:00 departure time and verify
    * driver quit

  Scenario: En Uygun - Istanbul/Ankara - Fiyat Kucukten Buyuge Kontrolu
    Given go to enuygunTest page with Chrome
    * i isVisible element anaSayfa
    * i click element gidis-donus
    * send keys istanbul sabiha to element nereden
    * i click element firstOption
    * send keys ankara esen to element nereye
    * i click element firstOptionReturn
    * i click element gidisTarihi
    * click on the desired date for departure 15 Haziran 2024
    * i click element donusTarihi
    * click on the desired date for return 15 Haziran 2024
    * i click element ucusArama
    * i isVisible element ucusSecimSayfası
    * i click element kalkisSaati
    * 10:00-18:00 departure time and verify
    * 10:00-18:00 landing time and verify
    * Checking price list from smallest to largest
    * driver quit

  Scenario: En Uygun - Istanbul/Ankara 10:00-18:00 Kalkis Listeleme - Firefox
    Given go to enuygunTest page with Firefox
    * i isVisible element anaSayfa
    * i click element gidis-donus
    * send keys istanbul sabiha to element nereden
    * i click element firstOption
    * send keys ankara esen to element nereye
    * i click element firstOptionReturn
    * i click element gidisTarihi
    * click on the desired date for departure 15 Haziran 2024
    * i click element donusTarihi
    * click on the desired date for return 15 Haziran 2024
    * i click element ucusArama
    * i isVisible element ucusSecimSayfası
    * i click element kalkisSaati
    * 10:00-18:00 departure time and verify
    * driver quit

  Scenario: Parallel Test
    Given paralel run scenario with the following scenarios
      | scenarioList                                                   |
      | En Uygun - Istanbul/Ankara - Fiyat Kucukten Buyuge Kontrolu          |
      | En Uygun - Istanbul/Ankara 10:00-18:00 Kalkis Listeleme |
