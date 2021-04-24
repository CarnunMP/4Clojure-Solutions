(defn bt?
  [coll]
  (let [left (second coll)
        right (last coll)]
    (and
      (= 3 (count coll))
      (or (nil? left) (coll? left))
      (or (nil? right) (coll? right))
      (or
        (and (nil? left) (nil? right))
        (and (bt? left) (nil? right))
        (and (nil? left) (bt? right))
        (and (bt? left) (bt? right))))))

;; Hmm. This solution is quite 'wordy'. I can do better.

(defn bt2?
  [[v l r :as coll]]
  (and
    (= 3 (count coll))
    (or
      (nil? l)
      (and (coll? l) (bt2? l)))
    (or
      (nil? r)
      (and (coll? r) (bt2? r)))))

;; Huh. And I also don't love the inconsistent formatting here!

(defn bt2?
  [[v l r :as coll]]
  (and (= 3 (count coll))
    (or (nil? l) (and (coll? l) (bt2? l)))
    (or (nil? r) (and (coll? r) (bt2? r)))))

;; That's definitely neater - and more readable too.
;; I should go light on \n when my lines are short to begin with, I think.
