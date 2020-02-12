; (= 15 (reduce __ [1 2 3 4 5]))
; (=  0 (reduce __ []))
; (=  6 (reduce __ 1 [2 3]))

(= 15 (reduce + [1 2 3 4 5])) ; => true
(=  0 (reduce + [])) ; => true
(=  6 (reduce + 1 [2 3])) ; => true