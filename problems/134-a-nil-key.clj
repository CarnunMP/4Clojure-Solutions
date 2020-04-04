; (true?  (__ :a {:a nil :b 2}))
; (false? (__ :b {:a nil :b 2}))
; (false? (__ :c {:a nil :b 2}))

(true?  (#(and (contains? %2 %1) (= nil (get %2 %1))) :a {:a nil :b 2})) ; => true
(false? (#(and (contains? %2 %1) (= nil (get %2 %1))) :b {:a nil :b 2})) ; => true
(false? (#(and (contains? %2 %1) (= nil (get %2 %1))) :c {:a nil :b 2})) ; => true
      
; The following also works, and is more readble:
; (fn [k m] (and (contains? m k) (= nil (get m k))))
