;; Write an oscillating iterate: a function that takes an initial value and a variable number of functions.
;; It should return a lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.

(defn oscilrate
  [v & fns]
  (let [fnseq (flatten (repeat [fns]))]
    (cons v (map-indexed (fn [i v]
                           ((apply comp (reverse (take (inc i) fnseq))) v))
                         (repeat v)))))

(comment
  (take 10 (oscilrate 1 dec inc #(* 5 %))))
