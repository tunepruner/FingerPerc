for file in *.wav*
do
	withOutWav=${file/.wav/}
	addingWavAgain=${withoutWav}.wav
	mv "${file}" "${addingWavAgain}"
done
