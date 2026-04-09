npm-install:
	npm install

compile:
	clojure -J-Dclojure.main.report=stderr \
	    -M --main cljs.main --compile-opts compile.edn --compile

compile-shadow:
	npx shadow-cljs release :app