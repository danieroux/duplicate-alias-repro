(ns aliases-in-a-ns
  (:require [a-ns :as-alias aliased-in]))

(defn say-hello
  [name]
  (str "Hello " name))