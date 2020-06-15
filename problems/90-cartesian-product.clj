;;; Write a function which calculates the Cartesian product of two sets.

;;; (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
;;;    #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
;;;      ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
;;;      ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

;;; (= (__ #{1 2 3} #{4 5})
;;;   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

;;; (= 300 (count (__ (into #{} (range 10))
;;;   (into #{} (range 30)))))

(defn cartesian-product [s1 s2] ; [note: 4clojure.com doesn't like defn!]
  (->> (map #(for [symbol s2] [% symbol]) s1)
       (apply concat)
       (set)))

(= (cartesian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}) ; => true

(= (cartesian-product #{1 2 3} #{4 5})
  #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}) ; => true

(= 300 (count (cartesian-product (into #{} (range 10))
  (into #{} (range 30))))) ; => true

; Note: could have used _mapcat_ instead of _map_ then _concat_! Like so:

(defn cartesian-product2 [s1 s2] ; [note: 4clojure.com doesn't like defn!]
  (set (mapcat #(for [symbol s2] [% symbol]) s1)))

; Or a straight-up list comp, without mapping (?):

(defn cartesian-product3 [s1 s2]
  (set (for [x s1 y s2] [x y])))