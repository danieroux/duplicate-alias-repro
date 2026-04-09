(ns duplicate-alias-repro
  (:require [aliases-in-a-ns]))

(js/console.log (aliases-in-a-ns/say-hello "John"))