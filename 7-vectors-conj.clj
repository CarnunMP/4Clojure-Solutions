; (= __ (conj [1 2 3] 4))
; (= __ (conj [1 2] 3 4))

(= [1 2 3 4] (conj [1 2 3] 4)) ; => true
(= [1 2 3 4] (conj [1 2] 3 4)) ; => true