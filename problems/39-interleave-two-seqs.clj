; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
; (= (__ [1 2 3 4] [5]) [1 5])
; (= (__ [30 20] [25 15]) [30 25 20 15])

; First attempt:
; (defn my-interleave [seq1 seq2]
;   (loop [s1 seq1
;          s2 seq2
;          result []]
;     (if (or (empty? s1) (empty? s2))
;       result
;       (recur (pop s1) (pop s2) (conj result (peek s1) (peek s2)))
;     )
;   )
; )

; Second, after much reading:
(defn my-interleave [seq1 seq2]
  (flatten (map list seq1 seq2))
)

(= (my-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)) ; => true
(= (my-interleave [1 2] [3 4 5 6]) '(1 3 2 4)) ; => true
(= (my-interleave [1 2 3 4] [5]) [1 5]) ; => true
(= (my-interleave [30 20] [25 15]) [30 25 20 15]) ; => true