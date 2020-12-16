(fn [v1 v2]
  (reduce + (map (fn [a b]
                   (* a b)) v1 v2)))
