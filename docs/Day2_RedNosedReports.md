# Hari 2: Laporan Hidung Merah 

## Bagian 1
Untungnya, lokasi pertama yang ingin dicari oleh Para Sejarawan tidak terlalu jauh dari kantor Kepala Sejarawan.

Meskipun pabrik fusi/fisi nuklir Rusa Hidung Merah tampaknya tidak menunjukkan tanda-tanda keberadaan Kepala Sejarawan,
para insinyur di sana langsung menghampiri Anda begitu melihat Anda. Rupanya, mereka masih sering membicarakan saat
Rudolph diselamatkan melalui sintesis molekuler dari satu elektron.

Mereka cepat menambahkan bahwa - karena Anda sudah di sini - mereka sangat menghargai bantuan Anda dalam menganalisis
data yang tidak biasa dari reaktor Hidung Merah. Anda berbalik untuk memeriksa apakah Para Sejarawan menunggu Anda,
tetapi mereka tampaknya sudah terbagi dalam kelompok-kelompok yang saat ini mencari di setiap sudut fasilitas. Anda
menawarkan diri untuk membantu dengan data yang tidak biasa tersebut.

Data yang tidak biasa (input puzzle Anda) terdiri dari banyak laporan, satu laporan per baris. Setiap laporan adalah
daftar angka yang disebut level yang dipisahkan oleh spasi. Contohnya:

```
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
```
Data contoh ini berisi enam laporan yang masing-masing berisi lima level.

Para insinyur mencoba mencari tahu laporan mana yang aman. Sistem keamanan reaktor Hidung Merah hanya dapat mentolerir
level yang meningkat atau menurun secara bertahap. Jadi, sebuah laporan hanya dihitung aman jika kedua hal berikut
benar:
```
Level-levelnya semua meningkat atau semua menurun.
Setiap dua level yang berdekatan berbeda minimal satu dan maksimal tiga.
```
Dalam contoh di atas, laporan-laporan dapat ditemukan aman atau tidak aman dengan memeriksa aturan-aturan tersebut:
```
7 6 4 2 1: Aman karena level-levelnya semua menurun sebesar 1 atau 2.
1 2 7 8 9: Tidak aman karena 2 7 adalah peningkatan sebesar 5.
9 7 6 2 1: Tidak aman karena 6 2 adalah penurunan sebesar 4.
1 3 2 4 5: Tidak aman karena 1 3 meningkat tetapi 3 2 menurun.
8 6 4 4 1: Tidak aman karena 4 4 bukan peningkatan atau penurunan.
1 3 6 7 9: Aman karena level-levelnya semua meningkat sebesar 1, 2, atau 3.
```
Jadi, dalam contoh ini, 2 laporan aman.

Analisis data yang tidak biasa dari para insinyur. Berapa banyak laporan yang aman? 

`Jawaban: 534`
## Bagian 2

Para insinyur terkejut dengan rendahnya jumlah laporan yang aman sampai mereka menyadari mereka lupa memberitahu Anda
tentang Problem Dampener.

Problem Dampener adalah modul yang dipasang pada reaktor yang memungkinkan sistem keamanan reaktor mentoleransi satu
level buruk dalam apa yang seharusnya menjadi laporan aman. Seolah-olah level buruk itu tidak pernah terjadi!

Sekarang, aturan yang sama berlaku seperti sebelumnya, kecuali jika menghilangkan satu level dari laporan tidak aman
akan membuatnya aman, laporan tersebut dianggap aman.

Lebih banyak laporan dari contoh di atas yang kini aman:

    7 6 4 2 1: Aman tanpa menghilangkan level apapun.
    1 2 7 8 9: Tidak aman terlepas dari level mana yang dihilangkan.
    9 7 6 2 1: Tidak aman terlepas dari level mana yang dihilangkan.
    1 3 2 4 5: Aman dengan menghilangkan level kedua, 3.
    8 6 4 4 1: Aman dengan menghilangkan level ketiga, 4.
    1 3 6 7 9: Aman tanpa menghilangkan level apapun.

Berkat Problem Dampener, 4 laporan sebenarnya aman!

Perbarui analisis Anda dengan menangani situasi di mana Problem Dampener dapat menghilangkan satu level dari laporan
yang tidak aman. Berapa banyak laporan yang kini aman?

`Jawaban: 577`

Solusi lengkap: [Day2.scala](../src/main/scala/Day2.scala)

Inputs: [inputDay2.txt](../input/inputDay2.txt)