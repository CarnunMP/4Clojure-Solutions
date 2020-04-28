; (= (__ 1) 1)
; (= (__ 3) 6)
; (= (__ 5) 120)
; (= (__ 8) 40320)

(= (#(reduce * (range 1 (inc %))) 1) 1) ; => true
(= (#(reduce * (range 1 (inc %))) 3) 6) ; => true
(= (#(reduce * (range 1 (inc %))) 5) 120) ; => true
(= (#(reduce * (range 1 (inc %))) 8) 40320) ; => true