; (= (__ "Dave") "Hello, Dave!")
; (= (__ "Jenn") "Hello, Jenn!")
; (= (__ "Rhea") "Hello, Rhea!")

(= (say-hello "Dave") "Hello, Dave!") ; => true
(= (say-hello "Jenn") "Hello, Jenn!") ; => true
(= (say-hello "Rhea") "Hello, Rhea!") ; => true

(defn say-hello [s] (apply str ["Hello, " s "!"]))  ; [note: 4clojure.com doesn't like defn!]