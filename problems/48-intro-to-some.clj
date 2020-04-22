; (= __ (some #{2 7 6} [5 6 7 8]))
; (= __ (some #(when (even? %) %) [5 6 7 8]))

(= 6 (some #{2 7 6} [5 6 7 8])) ; => true
(= 6 (some #(when (even? %) %) [5 6 7 8])) ; => true