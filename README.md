# Java Annotation ile Çoklu Dil Örneği

Kendi yazdığımız bir annotation (`@Language`) ve reflection ile, nesnedeki bir alanın değerini `ResourceBundle` üzerinden seçilen dile çeviren küçük bir örnek.

> **Not:** Bu depo 2017 yılında eğitim amaçlı yazıldı ve artık güncellenmiyor. Eski bir kütüphane sürümü (Apache Commons Lang 2.6) kullanır.

## İçerik

Proje `AnnotationLanguage/` klasöründedir.

| Dosya | Ne yapar |
|---|---|
| `annotation/Language.java` | Çevrilecek alanı ve çevirinin hangi alandan okunacağını (`localeValue`) belirten annotation |
| `annotation/TypeCheck.java` | Taslak halinde ikinci bir annotation örneği |
| `modal/MyType.java` | `@Language(localeValue="name")` ile işaretlenmiş örnek model |
| `util/LanguageUtil.java` | Alanları tarayıp annotation'ı bulan, getter/setter'ları reflection ile çağırıp değeri `messages` paketinden çeviren yardımcı sınıf (tek nesne ve liste için) |
| `app/App.java` | `MyType` nesnesini Türkçe yerel ayarla çevirip sonucu yazdıran ana sınıf |
| `messages.properties` | Çeviri anahtarları |

## Teknolojiler

- Java 8 (annotation, reflection, `ResourceBundle`)
- Apache Commons Lang 2.6 (`StringUtils.capitalize`)

## Çalıştırma

Proje Maven/Gradle kullanmaz; düz bir Eclipse Java projesidir.

1. `commons-lang-2.6.jar` dosyasını Maven Central'dan (`commons-lang:commons-lang:2.6`) indirin.
2. IDE'de `AnnotationLanguage/src` klasörünü kaynak klasörü olarak ekleyin ve jar'ı sınıf yoluna koyun.
3. `com.mustafaergan.app.App` sınıfını çalıştırın; çıktı `merhaba` olmalıdır.

Komut satırından (Windows'ta sınıf yolu ayırıcısı `:` yerine `;` olur):

```
cd AnnotationLanguage
javac -cp commons-lang-2.6.jar -d out $(find src -name "*.java")
cp src/messages.properties out/
java -cp out:commons-lang-2.6.jar com.mustafaergan.app.App
```
