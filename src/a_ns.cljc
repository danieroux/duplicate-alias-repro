(ns a-ns
  ; This line causes:
  ;
  ;  Assert failed: Duplicate :as-alias aliased-in, already in use for lib a-ns
  #?(:cljs (:require-macros [a-ns]))
  (:require [aliases-in-a-ns]))