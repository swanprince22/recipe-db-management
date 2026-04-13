# recipe-db-management

Angela log (Apr. 13)
CMD to out files on bin/ and access mysqlconnector jar in lib/
- javac -cp "lib/*" -d bin src/*.java
- java -cp "bin:lib/*" Main
- Outdated above (use Makefile instead)

Makefile
- make compile: Compiles all packages
- make run: Runs the app
- make clean: cleans bin/ folder

Directories
- model/ for entities
- dao/ for DAO classes

Env file
- Naming convention: DB_* where asterisk represents non-prexied variable name

Project definitions
- Bootstrap: loading the program

To be added in Makefile
- src/model/*.java src/dao/*.java