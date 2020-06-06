; (= (__ 1 1) [1])
; (= (__ 99 9) [8 9 1])
; (= (__ 999 99) [9 8 9 0 1])

(defn f [a b]  ; [note: 4clojure.com doesn't like defn!]
  (->> (* a b)
       (str)
       (seq)
       (map #(read-string (str %)))
  ))

(= (f 1 1) [1]) ; => true
(= (f 99 9) [8 9 1]) ; => true
(= (f 999 99) [9 8 9 0 1]) ; => true
