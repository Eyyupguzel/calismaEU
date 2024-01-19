# Genel Bilgi.
Bu projede,  ui test otomasyonları için selenium cucumber Java dilinde kullanılmıştır.
Proje temel yapısı, belirli bir yazılım veya uygulamanın test süreçlerini otomatikleştirmek için kullanılabilir.

## Gereksinimler

- Java JDK (sürüm 20.0.1 veya daha yüksek)
- Diğer gereksinimler için bkz. : pom.xml

## Proje Yapısı

    automation_structure/
    ├── config/
    │   └── config.ini
    ├── helpers/
    │   ├── ui/
    │   ├── base/
    │   └── project/
    ├── options/
    ├── stepdefs/
    │   └── ui/
    ├── utils/
    ├── feature/
    │   └── ui/
    ├── properties/
    └── testResults/

- `src/test/java/config`: Bu klasör, driver,extension ve config.ini gibi proje sabiti konularını içerir.
- `src/test/java/helpers`: Bu klasör, stepdefs içerisinde kullanımı kolaylaştıran yardımcı methodları içerir.
- `src/test/java/options`: Bu klasör, testlerin çalıştırılmasını gerçekleştiren runner dosyalarını içerir.
- `src/test/java/stepdefs`: Bu klasör, feature cümlelerinin yazılması ile çalışacak methodları içerir.
- `src/test/java/utils`: Bu klasör, işlerin daha hızlı yapılması için yardımcı methodlar içerir.
- `src/test/resources/features`: Bu klasör, test cümlelerini içerir.
- `src/test/resources/propeties`: Bu klasör, log ve rapor yapılandırma dosyalarını içerir.
- `src/test/resources/testResults`: Bu klasör, test sonuçlarının çıktılarını içerir.
- `pom.xml`: Bu dosya, Maven proje yapılandırma dosyasıdır.

## Test Çalıştırma

1. Test senaryolarını `src/test/resources/feature` klasöründe bulabilirsiniz.
2. Bir test senaryosunu çalıştırmak için, ilgili feature dosyasını açın ve run butonuna tıklayın.
3. "Parallel Test" senaryosu yazdığım method ile paralel çalıştırma yapabiliyor.
4. Senaryoları farklı browserlarda koşabilirsiniz. 

NOT : Locatorları  utils altındaki webUtils/elements/enuygunTest.json içersinden almaktadır.
Allure report için Runnerdan senaryoları tetiklemeniz gerekmektedir.
      'allure serve -h localhost' komutu ile allure report'u görüntüleyebilirsiniz.

## Katkılar

1. eyyupguzel47@gmail.com
