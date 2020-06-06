; Convert a binary number, provided in the form of a string, to its numerical value.

; (= 0     (__ "0"))
; (= 7     (__ "111"))
; (= 8     (__ "1000"))
; (= 9     (__ "1001"))
; (= 255   (__ "11111111"))
; (= 1365  (__ "10101010101"))
; (= 65535 (__ "1111111111111111"))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn convert [num-string]
  (loop [s (seq num-string)
         n                0         
         sum              0]
    (if (empty? s)
      sum
      (recur
        (drop-last s)
        (inc n)
        (if (= (str (last s)) "1") 
          (+ sum (exp 2 n)) 
            sum)))))

(= 0     (convert "0")) ; => true
(= 7     (convert "111")) ; => true
(= 8     (convert "1000")) ; => true
(= 9     (convert "1001")) ; => true
(= 255   (convert "11111111")) ; => true
(= 1365  (convert "10101010101")) ; => true
(= 65535 (convert "1111111111111111")) ; => true

; Note: because 4Clojure doesn't like defn, to submit this answer I had to tweak things slightly!