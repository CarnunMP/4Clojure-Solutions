; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])

(= (penultimate-element (list 1 2 3 4 5)) 4) ; => true
(= (penultimate-element ["a" "b" "c"]) "b") ; => true
(= (penultimate-element [[1 2] [3 4]]) [1 2]) ; => true

(defn penultimate-element [x] (first (rest (reverse x))))