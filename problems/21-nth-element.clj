; (= (__ '(4 5 6 7) 2) 6)
; (= (__ [:a :b :c] 0) :a)
; (= (__ [1 2 3 4] 1) 2)
; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

; Can't use: nth

(= (nth '(4 5 6 7) 2) 6) ; => true
(= (nth [:a :b :c] 0) :a) ; => true
(= (nth [1 2 3 4] 1) 2) ; => true
(= (nth '([1 2] [3 4] [5 6]) 2) [5 6]) ; => true

(defn nth [x i] (last (take (inc i) x))) ; [note: 4clojure.com doesn't like defn!]