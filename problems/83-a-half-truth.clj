; Write a function which takes a variable number of booleans.
; Your function should return true if some of the parameters are true, but not all of the parameters are true. 
; Otherwise your function should return false.

(fn some-true [& args]
  (if (or (= nil (some true? args)) (= nil (some false? args)))
    false
    true))

; Much more concise answer: not=, which is shorthand for (not (= x y & more))

(= false (some-true false false))
(= true (some-true true false))
(= false (some-true true))
(= true (some-true false true false))
(= false (some-true true true true))
(= true (some-true true true true false))