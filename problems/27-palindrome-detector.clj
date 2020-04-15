; (false? (__ '(1 2 3 4 5)))
; (true? (__ "racecar"))
; (true? (__ [:foo :bar :foo]))
; (true? (__ '(1 1 3 3 1 1)))
; (false? (__ '(:a :b :c)))

(false? (#(= (apply str %) (apply str (reverse %))) '(1 2 3 4 5))) ; => true
(true? (#(= (apply str %) (apply str (reverse %))) "racecar")) ; => true
(true? (#(= (apply str %) (apply str (reverse %))) [:foo :bar :foo])) ; => true
(true? (#(= (apply str %) (apply str (reverse %))) '(1 1 3 3 1 1))) ; => true
(false? (#(= (apply str %) (apply str (reverse %))) '(:a :b :c))) ; => true
