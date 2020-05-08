; (= (__ 2 4) 2)
; (= (__ 10 5) 5)
; (= (__ 5 7) 1)
; (= (__ 1023 858) 33)

; Eulid's algorithm: https://en.wikipedia.org/wiki/Greatest_common_divisor#Euclid's_algorithm
(fn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(= (gcd 2 4) 2) ; => true
(= (gcd 10 5) 5) ; => true
(= (gcd 5 7) 1) ; => true
(= (gcd 1023 858) 33) ; => true