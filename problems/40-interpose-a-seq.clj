; (= (__ 0 [1 2 3]) [1 0 2 0 3])
; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

(fn my-int [v s]
  (drop-last (flatten (map #(concat (list %) (list v)) s))))

(= (my-int 0 [1 2 3]) [1 0 2 0 3]) ; => true
(= (apply str (my-int ", " ["one" "two" "three"])) "one, two, three") ; => true
(= (my-int :z [:a :b :c :d]) [:a :z :b :z :c :z :d]) ; => true