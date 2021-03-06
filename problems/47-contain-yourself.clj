; "The contains? function checks if a KEY is present in a given collection.
; This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.""

(contains? #{4 5 6} 4) ; => true
(contains? [1 1 1 1 1] 4) ; => true
(contains? {4 :a 2 :b} 4) ; => true
(not (contains? [1 2 4] 4)) ; => true