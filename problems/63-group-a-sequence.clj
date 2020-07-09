;;; Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f applied to each item in s.
;;; The value at each key should be a vector of corresponding items in the order they appear in s.

;;; Special Restrictions: group-by

;;; (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})

;;; (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
;;;    {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

;;; (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
;;;   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

(defn my-group-by [f coll] ; [note: 4clojure.com doesn't like defn!]
  (->> (partition-by f (sort coll))
       (map #(vector (f (first %)) (vec %)))
       (into {})))

(= (my-group-by #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}) ; => true

(= (my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) ; => true
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

(= (my-group-by count [[1] [1 2] [3] [1 2 3] [2 3]])
  {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}) ; => true

; Note: the solution works, but two things:
;   1) I can't take full credit: I have https://www.anthony-galea.com/blog/post/solutions-to-4clojure-easy-problems/, to thank.
;      Seems Anthony had a similar idea!
;   2) It feels ad-hoc. Would first sorting the coll work in every case? I suspect not.

; Huh... the following seems to solve at least problem (2)! (But not (1), as it comes from the 4Clojure solutions thread.)

(defn better-group-by [f coll] 
  (apply merge-with concat (map (fn [v] {(f v) [v]}) coll)))

(concat (map (fn [v] {(#(apply / %) v) [v]}) [[1 2] [2 4] [4 6] [3 6]]))

; Looks like the idea was to produce a bunch of maps (one for each element of coll), then merge them...