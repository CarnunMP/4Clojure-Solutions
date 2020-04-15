; (= (__ 3) '(1 1 2))
; (= (__ 6) '(1 1 2 3 5 8))
; (= (__ 8) '(1 1 2 3 5 8 13 21))

(= (#(map last (take % (iterate (fn [[a b]] [b (+ a b)]) [0 1]))) 3) '(1 1 2)) ; => true
(= (#(map last (take % (iterate (fn [[a b]] [b (+ a b)]) [0 1]))) 6) '(1 1 2 3 5 8)) ; => true
(= (#(map last (take % (iterate (fn [[a b]] [b (+ a b)]) [0 1]))) 8) '(1 1 2 3 5 8 13 21)) ; => true

; Answer inspired by Stuart Halloway and Aaron Bedra's Programming Clojure, 2nd Ed.
