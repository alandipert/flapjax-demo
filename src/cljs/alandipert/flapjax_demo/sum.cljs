(ns alandipert.flapjax-demo.sum
  (:require [flapjax :as fj]))

(defn parse-float
  "Attempts to parse s with js/parseFloat.  If parsing fails, returns default."
  [s default]
  (let [n (js/parseFloat s)]
    (if (js/isNaN n) default n)))

(defn extractNumberE
  "Returns an event stream of numeric values from the input with
  id.  Unparseable input values take the default value."
  [id default]
  (fj/mapE #(parse-float % default) (fj/extractValueE id)))

(defn extractNumberB
  "Returns a behavior representing a numeric value backed
  by the text input at id.

  Assumes the value of default if the input is empty or contains an
  unparseable string."
  [id default]
  (fj/startsWith (extractNumberE id default) default))

(defn sumB
  "Returns a behavior representing the sum of behaviors."
  [& behaviors]
  (apply fj/liftB + behaviors))

(defn calculate [target-id & source-ids]
  (let [arguments (map #(extractNumberB % 0) source-ids)
        results (apply sumB arguments)]
    (fj/insertValueB results target-id "innerHTML")))