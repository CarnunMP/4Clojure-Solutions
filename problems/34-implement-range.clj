; (= (__ 1 4) '(1 2 3))
; (= (__ -2 2) '(-2 -1 0 1))
; (= (__ 5 8) '(5 6 7))

(fn my-range [n1 n2]
  (when (< n1 n2)
    (cons n1 (my-range (inc n1) n2))))

(= (my-range 1 4) '(1 2 3)) ; => true
(= (my-range -2 2) '(-2 -1 0 1)) ; => true
(= (my-range 5 8) '(5 6 7)) ; => true

; Cool alt solution: #(take (- %2 %1) (iterate inc %1))
