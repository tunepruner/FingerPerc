for file in borde*.wav
do
	newName=${file/borde_/1_}
	mv "${file}" "${newName}"
done
for file in centro*.wav
do
	newName=${file/centro_/2_}
	mv "${file}" "${newName}"
done
for file in *.wav
do
	withoutWav=${file/.wav/}
	withBombo=${withoutWav}_bomboleguero
	withWav=${withBombo}.wav
	mv "${file}" "${withWav}"
done