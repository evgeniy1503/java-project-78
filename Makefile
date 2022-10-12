.DEFAULT_GOAL := build-run

run-dist: #запуск программы
	./build/install/app/bin/app

test:
	make -C app test

clean:
	make -C app clean

lint:
	make -C app lint

build:
	make -C app build

run:
	make -C app run

install:
	make -C app clean install

report:
	make -C app report

.PHONY: build