; (clojure.set/superset? __ #{2})
; (clojure.set/subset? #{1} __)
; (clojure.set/superset? __ #{1 2})
; (clojure.set/subset? #{1 2} __)

(clojure.set/superset? #{1 2} #{2}) ; => true
(clojure.set/subset? #{1} #{1 2}) ; => true
(clojure.set/superset? #{1 2} #{1 2}) ; => true
(clojure.set/subset? #{1 2} #{1 2}) ; => true