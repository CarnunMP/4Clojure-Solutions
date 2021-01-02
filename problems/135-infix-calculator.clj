(defn infix-calc ; (fn..., for submission
  [& args]
  (if (= 1 (count args))
    (first args)
    (let [a (take 3 args)
          reduced-a (apply (second a) [(first a) (last a)])
          b (drop 3 args)]
      (apply infix-calc (cons reduced-a b)))))
