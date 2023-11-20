-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Haz 2022, 11:49:26
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otomasyonkitap`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplarim`
--

CREATE TABLE `kitaplarim` (
  `kitapID` int(11) NOT NULL,
  `kitapAdi` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `tur` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kuldurum` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `fiyat` double NOT NULL,
  `yazar` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitaplarim`
--

INSERT INTO `kitaplarim` (`kitapID`, `kitapAdi`, `tur`, `kuldurum`, `fiyat`, `yazar`) VALUES
(3, 'Satranç', 'Edebiyat', 'Yeni', 50, 'Stefan Zweig'),
(4, 'Kardeşimin Hikayesi', 'Edebiyat', 'Çok İyi', 13, 'Zülfü Livaneli'),
(5, 'Dönüşüm', 'Edebiyat', 'İdare Eder', 3, 'Franz Kafka'),
(6, 'Füreya', 'Edebiyat', 'Yeni', 45, 'Ayşe Kulin'),
(7, 'Göğe Bakma Durağı', 'Şiir', 'Yeni', 5, 'Turgut Uyar'),
(8, 'Nutuk', 'Otobiyografi', 'Yeni', 100, 'Mustafa Kemal ATATÜRK'),
(34, 'Leyla', 'Edebiyat', 'Yeni', 50, 'Zülfü Livaneli');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sepet`
--

CREATE TABLE `sepet` (
  `sepetID1` int(11) NOT NULL,
  `kitapAdi` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `tur` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kuldurum` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `fiyat` double NOT NULL,
  `yazar` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyelik`
--

CREATE TABLE `uyelik` (
  `kulID` int(11) NOT NULL,
  `ad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `soyad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kullaniciAdi` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `sifre` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `telno` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `adres` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `uyelik`
--

INSERT INTO `uyelik` (`kulID`, `ad`, `soyad`, `kullaniciAdi`, `sifre`, `email`, `telno`, `adres`) VALUES
(1, 'batu', 'kayam', 'batuk', 'c20ad4d76fe97759aa27a0c99bff6710', 'batuk@gmail.com', '05343980450', 'ist'),
(2, 'sena', 'korkmaz', 'korkmaz', '202cb962ac59075b964b07152d234b70', 'snkorkmaz@gmail.com', '05396548978', 'iskenderun hatay'),
(3, 'kerem', 'keremcing', 'keremc', '202cb962ac59075b964b07152d234b70', 'keremc@gmail.com', '05549886834', 'malatya/yeşilyurt'),
(15, 'irem', 'cing', 'iremc', '202cb962ac59075b964b07152d234b70', 'irem@gmail.com', '05315195439', 'malatya'),
(16, 'ayse', 'yılmaz', 'ayse1', '202cb962ac59075b964b07152d234b70', 'ayse@gmail.com', '05365468798', 'malatya'),
(17, 'kerem', 'cing', 'keremc1', '202cb962ac59075b964b07152d234b70', 'kerem@gmail.com', '053654798', 'malatya'),
(19, 'ekin', 'cenan', 'ekinc', '202cb962ac59075b964b07152d234b70', 'ekin@gmail.com', '05325647898', 'iskenderun'),
(21, 'eylul', 'kayam', 'eylul9', 'c20ad4d76fe97759aa27a0c99bff6710', 'eylul@gmail.com', '05325645468', 'malatya');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yetkili`
--

CREATE TABLE `yetkili` (
  `yoneticiID` int(11) NOT NULL,
  `yoneticiad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yoneticisifre` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `yetkili`
--

INSERT INTO `yetkili` (`yoneticiID`, `yoneticiad`, `yoneticisifre`) VALUES
(1, 'iremcing', 'b74a4e4ee0fac81373a11c150a0c51ad');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kitaplarim`
--
ALTER TABLE `kitaplarim`
  ADD PRIMARY KEY (`kitapID`);

--
-- Tablo için indeksler `sepet`
--
ALTER TABLE `sepet`
  ADD PRIMARY KEY (`sepetID1`);

--
-- Tablo için indeksler `uyelik`
--
ALTER TABLE `uyelik`
  ADD PRIMARY KEY (`kulID`);

--
-- Tablo için indeksler `yetkili`
--
ALTER TABLE `yetkili`
  ADD PRIMARY KEY (`yoneticiID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kitaplarim`
--
ALTER TABLE `kitaplarim`
  MODIFY `kitapID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Tablo için AUTO_INCREMENT değeri `sepet`
--
ALTER TABLE `sepet`
  MODIFY `sepetID1` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `uyelik`
--
ALTER TABLE `uyelik`
  MODIFY `kulID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `yetkili`
--
ALTER TABLE `yetkili`
  MODIFY `yoneticiID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
