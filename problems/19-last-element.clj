; (= (__ [1 2 3 4 5]) 5)
; (= (__ '(5 4 3)) 3)
; (= (__ ["b" "c" "d"]) "d")

; Can't use: last

(= (last-element [1 2 3 4 5]) 5) ; => true
(= (last-element '(5 4 3)) 3)  ; => true
(= (last-element ["b" "c" "d"]) "d")  ; => true

(defn last-element [x] (first (reverse x)))