(defn my-map
  [f coll]
  (reduce #(conj %1 (f %2)) [] coll))

;; This works, but it isn't lazy. Hmm. Perhaps I need to implement with sequences?

(defn my-map
  [f coll]
  (if (empty? coll)
    nil
    (lazy-seq (cons (f (first coll)) (my-map f (rest coll))))))

; Yep! lazy-seq was the key.

; Interesting note, though... with conj this overflowed the stack, so I had to switch to cons.
; I wonder why there's a difference, there...

; Ah! Makes sense: https://stackoverflow.com/a/12390331
