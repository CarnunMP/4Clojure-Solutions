(fn c [integers]
  (->> integers
       (map (fn [n]
              [n (map #(Character/digit % 10)
                      (str n))]))
       (map (fn [[n digits]]
              [n (reduce #(+ %1 (* %2 %2))
                         0 digits)]))
       (reduce (fn [res [n sum-of-squares]]
                 (if (< n sum-of-squares)
                   (inc res)
                   res))
               0)))
