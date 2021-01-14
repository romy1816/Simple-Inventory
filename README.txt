buka my.ini di config sql
ubah 
	max _alowed_packet menjadi 10mb atau lebih
	innodb_log_file_size = 10M
	innodb_log_buffer_size menjadi 10M

import sinju.sql terlebih dahulu sebelum run program.

Untuk SKU belum bisa autoincrement dan belum ada pengecekan duplikat data.
Belum ada fitur laporan log stok per barang.