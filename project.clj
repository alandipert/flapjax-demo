(defproject alandipert/flapjax-demo "0.0.1"
  :description "Flapjax Demo"
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.0"]]
  :plugins [[lein-cljsbuild "0.2.9"]
            [lein-ring "0.7.0"]]
  :cljsbuild {:builds [{:source-path "src/cljs"
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true
                                   :foreign-libs [{:file "http://www.flapjax-lang.org/download/flapjax-2.1.js"
                                                   :provides "flapjax"}]}}]}
  :ring {:handler alandipert.flapjax-demo.routes/app})
