;;; (let [x __]
;;;   (and (= (class x) x) x))

(let [x (class (class class))]
  (and (= (class x) x) x))

(class (class class))

; Seems to do the trick! (Cos (class class) is clojure.core$class, (class (class class)) and everything up is java.lang.Class...)
