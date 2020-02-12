; (= (__ [1 2 3 4 5]) 5)
; (= (__ '(5 4 3)) 3)
; (= (__ ["b" "c" "d"]) "d")

; Can't use: last

(= (get-last [1 2 3 4 5]) 5) ; => true
(= (get-last '(5 4 3)) 3)  ; => true
(= (get-last ["b" "c" "d"]) "d")  ; => true

(defn get-last [x] (first (reverse x)))