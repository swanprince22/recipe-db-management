.PHONY: compile run clean

compile:
	javac -cp "lib/*" -d bin src/*.java src/db/*.java 

run:
	java -cp "bin:lib/*" Main

clean:
	rm -rf bin/*