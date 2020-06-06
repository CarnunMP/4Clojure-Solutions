; (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
; (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
; (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
; (= (__ 1 '(:a :b :c)) '(:b :c :a))
; (= (__ -4 '(:a :b :c)) '(:c :a :b))

(defn rotate [n s] ; [note: 4clojure.com doesn't like defn!]
  (if (pos? n)
    (concat (drop (mod n (count s)) s) (take (mod n (count s)) s))
    (concat (take-last (mod (Math/abs n) (count s)) s) (drop-last (mod (Math/abs n) (count s)) s))))

(rotate 2 [1 2 3 4 5])

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2)) ; => true
(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3)) ; => true
(= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1)) ; => true
(= (rotate 1 '(:a :b :c)) '(:b :c :a)) ; => true
(= (rotate -4 '(:a :b :c)) '(:c :a :b)) ; => true

; Hmm. Messy, but it works! :P