# flapjax-demo

This is a web application that uses [Flapjax][1] to demonstrate
[Functional Reactive Programming (FRP)][2] in [ClojureScript][3].

To play around with this project, you will first need
[Leiningen][4] installed.

## Running the App

Set up and start the server like this:

    $ lein deps
    $ lein cljsbuild once
    $ lein ring server-headless 3000

Now, point your web browser at http://localhost:3000/index.html and see Flapjax in action!

[1]: http://www.flapjax-lang.org/
[2]: http://en.wikipedia.org/wiki/Functional_reactive_programming
[3]: https://github.com/clojure/clojurescript
[4]: https://github.com/technomancy/leiningen
