; (= __ (if-not false 1 0))
; (= __ (if-not nil 1 0))
; (= __ (if true 1 0))
; (= __ (if [] 1 0))
; (= __ (if [0] 1 0))
; (= __ (if 0 1 0))
; (= __ (if 1 1 0))

(= 1 (if-not false 1 0)) ; => true
(= 1 (if-not nil 1 0)) ; => true
(= 1 (if true 1 0)) ; => true
(= 1 (if [] 1 0)) ; => true
(= 1 (if [0] 1 0)) ; => true
(= 1 (if 0 1 0)) ; => true
(= 1 (if 1 1 0)) ; => true