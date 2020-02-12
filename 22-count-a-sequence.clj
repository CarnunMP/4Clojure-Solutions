; (= (__ '(1 2 3 3 1)) 5)
; (= (__ "Hello World") 11)
; (= (__ [[1 2] [3 4] [5 6]]) 3)
; (= (__ '(13)) 1)
; (= (__ '(:a :b :c)) 3)

; Can't use: count

(= (county '(1 2 3 3 1)) 5) ; => true
(= (county "Hello World") 11) ; => true
(= (county [[1 2] [3 4] [5 6]]) 3) ; => true
(= (county '(13)) 1) ; => true
(= (county '(:a :b :c)) 3) ; => true

(defn county [sq] (apply + (map (fn [x] 1) sq)))