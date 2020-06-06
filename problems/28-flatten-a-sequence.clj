; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))

; from https://stackoverflow.com/questions/37244971/how-can-i-recursively-flatten-arbitrarily-nested-vectors-and-maps-in-clojure:

(defn my-flatten [x] ; [note: 4clojure.com doesn't like defn!]
  (if (coll? x)
    (mapcat my-flatten x)
    [x]))

; Bad, because it consumes stack?

(= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ; => true
(= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c")) ; => true
(= (my-flatten '((((:a))))) '(:a)) ; => true