; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))) ; => true