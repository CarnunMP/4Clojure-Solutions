; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])

(= (second-to-last (list 1 2 3 4 5)) 4) ; => true
(= (second-to-last ["a" "b" "c"]) "b") ; => true
(= (second-to-last [[1 2] [3 4]]) [1 2]) ; => true

(defn second-to-last [x] (first (rest (reverse x))))