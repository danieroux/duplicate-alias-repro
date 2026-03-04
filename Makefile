compile:
	npm install
	clojure -J-Dclojure.main.report=stderr \
	    -M --main cljs.main --compile-opts compile.edn --compile
