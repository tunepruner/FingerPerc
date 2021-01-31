for file in *.mp3
do
	oldName=${file}
	mv "${file}" "centro_${oldName}" 
done
