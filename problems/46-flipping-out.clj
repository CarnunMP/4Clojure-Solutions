;;; (= 3 ((__ nth) 2 [1 2 3 4 5]))
;;; (= true ((__ >) 7 8))
;;; (= 4 ((__ quot) 2 8))
;;; (= [1 2 3] ((__ take) [1 2 3 4 5] 3))

(fn flip [f]
  (fn [& args] 
    (apply f (reverse args))))

(= 3 ((flip nth) 2 [1 2 3 4 5])) ; => true
(= true ((flip >) 7 8)) ; => true
(= 4 ((flip quot) 2 8)) ; => true
(= [1 2 3] ((flip take) [1 2 3 4 5] 3)) ; => true