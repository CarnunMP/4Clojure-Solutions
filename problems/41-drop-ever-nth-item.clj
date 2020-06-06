; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

(defn my-drop-nth [s n] (flatten (map #(take (dec n) %) (partition-all n s))))
; (note: 4clojure.com doesn't like defn)

(= (my-drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]) ; => true
(= (my-drop-nth [:a :b :c :d :e :f] 2) [:a :c :e]) ; => true
(= (my-drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6]) ; => true