.PHONY: compile run clean

compile:
	javac -cp "lib/*" -d bin src/*.java src/db/*.java src/auth/*.java src/model/*.java 

run:
	java -cp "bin:lib/*" Main

clean:
	rm -rf bin/*