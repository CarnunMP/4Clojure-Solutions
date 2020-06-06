; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
; (= (take 100 (__ inc 0)) (take 100 (range)))
; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

(defn my-iterate [f x] ; [note: 4clojure.com doesn't like defn!]
  (lazy-seq (cons x (my-iterate f (f x)))))

(= (take 5 (my-iterate #(* 2 %) 1)) [1 2 4 8 16]) ; => true
(= (take 100 (my-iterate inc 0)) (take 100 (range))) ; => true
(= (take 9 (my-iterate #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))) ; => true