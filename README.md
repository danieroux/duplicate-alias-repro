# What 

`make compile` failes with: "Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns"

The offending line is in `src/a-ns.cljc`.

This is the output I see:

```
$ make compile

npm install

up to date, audited 117 packages in 1s

18 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities
clojure -J-Dclojure.main.report=stderr \
    -M --main cljs.main --compile-opts compile.edn --compile
WARNING: aliases-in-a-ns is a single segment namespace at line 1 /Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc
{:clojure.main/message
 "Unexpected error (AssertionError) compiling at (REPL:1).\nAssert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns\n(not (contains? as-aliases alias))\n",
 :clojure.main/triage
 {:file
  #object[java.io.File 0x4870d2e1 "/Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc"],
  :clojure.error/phase :compilation,
  :clojure.error/class java.lang.AssertionError,
  :clojure.error/cause
  "Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns\n(not (contains? as-aliases alias))"},
 :clojure.main/trace
 {:via
  [{:type clojure.lang.ExceptionInfo,
    :message
    "failed compiling file:/Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc",
    :data
    {:file
     #object[java.io.File 0x4870d2e1 "/Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc"],
     :clojure.error/phase :compilation},
    :at
    [cljs.compiler$compile_file$fn__4949 invoke "compiler.cljc" 1826]}
   {:type clojure.lang.ExceptionInfo,
    :data
    {:clojure.error/source
     "/Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc",
     :clojure.error/line 1,
     :clojure.error/column 1,
     :clojure.error/phase :compilation},
    :at
    [cljs.analyzer$analyze_seq_STAR__wrap
     invokeStatic
     "analyzer.cljc"
     4342]}
   {:type clojure.lang.ExceptionInfo,
    :message
    "Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns\n(not (contains? as-aliases alias)) at line 1 /Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc",
    :data
    {:file
     "/Users/danie/src/duplicate-alias-repro/src/aliases_in_a_ns.cljc",
     :line 1,
     :column 1,
     :tag :cljs/analysis-error},
    :at [cljs.analyzer$error invokeStatic "analyzer.cljc" 795]}
   {:type java.lang.AssertionError,
    :message
    "Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns\n(not (contains? as-aliases alias))",
    :at
    [cljs.analyzer.impl.namespaces$check_as_alias_duplicates
     invokeStatic
     "namespaces.cljc"
     34]}],
  :trace
  [[cljs.analyzer.impl.namespaces$check_as_alias_duplicates
    invokeStatic
    "namespaces.cljc"
    34]
   [cljs.analyzer.impl.namespaces$check_as_alias_duplicates
    invoke
    "namespaces.cljc"
    31]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_libspecs$fn__676
    invoke
    "namespaces.cljc"
    49]
   [clojure.lang.ArrayChunk reduce "ArrayChunk.java" 60]
   [clojure.core.protocols$fn__8274 invokeStatic "protocols.clj" 135]
   [clojure.core.protocols$fn__8274 invoke "protocols.clj" 123]
   [clojure.core.protocols$fn__8233$G__8228__8242
    invoke
    "protocols.clj"
    19]
   [clojure.core.protocols$seq_reduce invokeStatic "protocols.clj" 31]
   [clojure.core.protocols$fn__8264 invokeStatic "protocols.clj" 74]
   [clojure.core.protocols$fn__8264 invoke "protocols.clj" 74]
   [clojure.core.protocols$fn__8207$G__8202__8220
    invoke
    "protocols.clj"
    13]
   [clojure.core$reduce invokeStatic "core.clj" 6965]
   [clojure.core$reduce invoke "core.clj" 6947]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_libspecs
    invokeStatic
    "namespaces.cljc"
    46]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_libspecs
    invoke
    "namespaces.cljc"
    38]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_ns_specs$fn__683
    invoke
    "namespaces.cljc"
    63]
   [clojure.core.protocols$fn__8279 invokeStatic "protocols.clj" 167]
   [clojure.core.protocols$fn__8279 invoke "protocols.clj" 123]
   [clojure.core.protocols$fn__8233$G__8228__8242
    invoke
    "protocols.clj"
    19]
   [clojure.core.protocols$seq_reduce invokeStatic "protocols.clj" 31]
   [clojure.core.protocols$fn__8266 invokeStatic "protocols.clj" 74]
   [clojure.core.protocols$fn__8266 invoke "protocols.clj" 74]
   [clojure.core.protocols$fn__8207$G__8202__8220
    invoke
    "protocols.clj"
    13]
   [clojure.core$reduce invokeStatic "core.clj" 6965]
   [clojure.core$reduce invoke "core.clj" 6947]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_ns_specs
    invokeStatic
    "namespaces.cljc"
    60]
   [cljs.analyzer.impl.namespaces$elide_aliases_from_ns_specs
    invoke
    "namespaces.cljc"
    55]
   [cljs.analyzer$fn__3182 invokeStatic "analyzer.cljc" 3446]
   [cljs.analyzer$fn__3182 invoke "analyzer.cljc" 3418]
   [clojure.lang.MultiFn invoke "MultiFn.java" 252]
   [cljs.analyzer$analyze_seq_STAR_ invokeStatic "analyzer.cljc" 4338]
   [cljs.analyzer$analyze_seq_STAR_ invoke "analyzer.cljc" 4336]
   [cljs.analyzer$analyze_seq_STAR__wrap
    invokeStatic
    "analyzer.cljc"
    4343]
   [cljs.analyzer$analyze_seq_STAR__wrap invoke "analyzer.cljc" 4341]
   [cljs.analyzer$analyze_seq invokeStatic "analyzer.cljc" 4367]
   [cljs.analyzer$analyze_seq invoke "analyzer.cljc" 4345]
   [cljs.analyzer$analyze_form invokeStatic "analyzer.cljc" 4554]
   [cljs.analyzer$analyze_form invoke "analyzer.cljc" 4551]
   [cljs.analyzer$analyze_STAR_ invokeStatic "analyzer.cljc" 4605]
   [cljs.analyzer$analyze_STAR_ invoke "analyzer.cljc" 4599]
   [cljs.analyzer$analyze invokeStatic "analyzer.cljc" 4625]
   [cljs.analyzer$analyze invoke "analyzer.cljc" 4608]
   [cljs.compiler$emit_source invokeStatic "compiler.cljc" 1642]
   [cljs.compiler$emit_source invoke "compiler.cljc" 1615]
   [cljs.compiler$compile_file_STAR_$fn__4918
    invoke
    "compiler.cljc"
    1729]
   [cljs.compiler$with_core_cljs invokeStatic "compiler.cljc" 1535]
   [cljs.compiler$with_core_cljs invoke "compiler.cljc" 1524]
   [cljs.compiler$compile_file_STAR_ invokeStatic "compiler.cljc" 1713]
   [cljs.compiler$compile_file_STAR_ invoke "compiler.cljc" 1706]
   [cljs.compiler$compile_file$fn__4949 invoke "compiler.cljc" 1811]
   [cljs.compiler$compile_file invokeStatic "compiler.cljc" 1786]
   [cljs.compiler$compile_file invoke "compiler.cljc" 1762]
   [cljs.closure$compile_file invokeStatic "closure.clj" 663]
   [cljs.closure$compile_file invoke "closure.clj" 641]
   [cljs.closure$fn__6641 invokeStatic "closure.clj" 737]
   [cljs.closure$fn__6641 invoke "closure.clj" 731]
   [cljs.closure$fn__6550$G__6543__6557 invoke "closure.clj" 559]
   [cljs.closure$fn__6645 invokeStatic "closure.clj" 746]
   [cljs.closure$fn__6645 invoke "closure.clj" 731]
   [cljs.closure$fn__6550$G__6543__6557 invoke "closure.clj" 559]
   [cljs.closure$compile_sources$iter__6767__6771$fn__6772
    invoke
    "closure.clj"
    1108]
   [clojure.lang.LazySeq force "LazySeq.java" 50]
   [clojure.lang.LazySeq realize "LazySeq.java" 89]
   [clojure.lang.LazySeq seq "LazySeq.java" 106]
   [clojure.lang.Cons next "Cons.java" 41]
   [clojure.lang.RT next "RT.java" 733]
   [clojure.core$next__5472 invokeStatic "core.clj" 64]
   [clojure.core$dorun invokeStatic "core.clj" 3150]
   [clojure.core$doall invokeStatic "core.clj" 3156]
   [clojure.core$doall invoke "core.clj" 3156]
   [cljs.closure$compile_sources invokeStatic "closure.clj" 1104]
   [cljs.closure$compile_sources invoke "closure.clj" 1093]
   [cljs.closure$build invokeStatic "closure.clj" 3089]
   [cljs.closure$build invoke "closure.clj" 2993]
   [cljs.build.api$build invokeStatic "api.clj" 231]
   [cljs.build.api$build invoke "api.clj" 212]
   [cljs.cli$default_compile invokeStatic "cli.clj" 538]
   [cljs.cli$default_compile invoke "cli.clj" 494]
   [cljs.cli$compile_opt invokeStatic "cli.clj" 553]
   [cljs.cli$compile_opt invoke "cli.clj" 548]
   [cljs.cli$main invokeStatic "cli.clj" 744]
   [cljs.cli$main doInvoke "cli.clj" 733]
   [clojure.lang.RestFn applyTo "RestFn.java" 142]
   [clojure.core$apply invokeStatic "core.clj" 669]
   [clojure.core$apply invoke "core.clj" 662]
   [cljs.main$_main invokeStatic "main.clj" 65]
   [cljs.main$_main doInvoke "main.clj" 56]
   [clojure.lang.RestFn applyTo "RestFn.java" 140]
   [clojure.lang.Var applyTo "Var.java" 707]
   [clojure.core$apply invokeStatic "core.clj" 667]
   [clojure.main$main_opt invokeStatic "main.clj" 515]
   [clojure.main$main_opt invoke "main.clj" 511]
   [clojure.main$main invokeStatic "main.clj" 665]
   [clojure.main$main doInvoke "main.clj" 617]
   [clojure.lang.RestFn applyTo "RestFn.java" 140]
   [clojure.lang.Var applyTo "Var.java" 707]
   [clojure.main main "main.java" 40]],
  :cause
  "Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns\n(not (contains? as-aliases alias))",
  :phase :compilation}}

Unexpected error (AssertionError) compiling at (REPL:1).
Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns
(not (contains? as-aliases alias))
```
