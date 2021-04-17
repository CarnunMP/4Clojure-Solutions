;;; Write a function which returns the nth row of Pascal's Triangle.

(defn pascal-row-n
  ([n]
   (if (= 1 n)
     [1]
     (pascal-row-n n (pascal-row-n (dec n)))))
  ([_n prev]
   (let [prev-sum (map (fn [curr next]
                         (+ curr next))
                       prev (rest prev))]
     (-> prev-sum
         (conj 1)
         (vec)
         (conj 1)))))

(comment
  (pascal-row-n 1)
  (pascal-row-n 2)
  (pascal-row-n 3)
  (pascal-row-n 4)
  (pascal-row-n 5)
  (pascal-row-n 11))

;; Whoa. Much simpler implementation of the same idea from user anjensan:
(fn [x]
  (nth
    (iterate #(concat [1] (map + % (rest %)) [1]) [1])
    (dec x)))
