## Bagian Dua

Hasil analisis Anda hanya mengkonfirmasi apa yang ditakutkan semua orang: kedua daftar ID lokasi tersebut memang sangat
berbeda.

Atau apakah benar demikian?

Para Sejarahwan tidak dapat menyepakati kelompok mana yang membuat kesalahan atau bagaimana membaca sebagian besar
tulisan tangan Kepala Sejarahwan, tetapi dalam kekacauan tersebut Anda memperhatikan detail yang menarik: banyak ID
lokasi muncul di kedua daftar! Mungkin angka-angka lainnya bukanlah ID lokasi sama sekali melainkan tulisan tangan yang
salah diinterpretasikan.

Kali ini, Anda perlu mencari tahu seberapa sering setiap angka dari daftar kiri muncul di daftar kanan. Hitung skor
kesamaan total dengan menjumlahkan setiap angka di daftar kiri setelah mengalikannya dengan jumlah kemunculan angka
tersebut di daftar kanan.

Berikut contoh daftar yang sama lagi:
```text
3   4
4   3
2   5
1   3
3   9
3   3
```

Untuk daftar contoh ini, berikut adalah proses mencari skor kesamaan:

- Angka pertama di daftar kiri adalah 3. Angka ini muncul tiga kali di daftar kanan, jadi skor kesamaan bertambah sebesar 3 * 3 = 9.
- Angka kedua di daftar kiri adalah 4. Angka ini muncul satu kali di daftar kanan, jadi skor kesamaan bertambah sebesar 4 * 1 = 4. 
- Angka ketiga di daftar kiri adalah 2. Angka ini tidak muncul di daftar kanan, jadi skor kesamaan tidak bertambah (2 * 0 = 0).
- Angka keempat yaitu 1 juga tidak muncul di daftar kanan.
- Angka kelima yaitu 3 muncul tiga kali di daftar kanan; skor kesamaan bertambah sebesar 9.
- Angka terakhir yaitu 3 muncul tiga kali di daftar kanan; skor kesamaan kembali bertambah sebesar 9.

Jadi, untuk daftar contoh ini, skor kesamaan di akhir proses adalah 31 (9 + 4 + 0 + 0 + 9 + 9).
### Solusi Lengkap
[Santa.scala](../src/main/scala/Santa.scala)
Jawaban:`21607792`