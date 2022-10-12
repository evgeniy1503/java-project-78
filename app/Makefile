run-dist: #запуск программы
	./build/install/app/bin/

test:
	./gradlew test

clean:
	./gradlew clean

lint:
	./gradlew checkstyleMain checkstyleTest

build:
	./gradlew clean build


install:
	./gradlew clean install

report:
	./gradlew jacocoTestReport

.PHONY: build