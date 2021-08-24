; first, reduce to map of {:longest [...] :candidate [...]}, where the latter replaces the former iff it's longer and more than 1 element long
; then return :longest

(defn longest-increasing-sub-seq [s]
  (:longest
    (reduce (fn [{:keys [longest candidate] :as acc} cur]
              (let [new-candidate (if (< (last candidate) cur)
                                    (conj candidate cur)
                                    [cur])]
                (cond-> acc
                  (and (< (count longest) (count new-candidate))
                       (< 1 (count new-candidate)))
                  (assoc :longest new-candidate)

                  true (assoc :candidate new-candidate))))
            {:longest [] :candidate [(first s)]}
            (rest s))))

(comment
  (longest-increasing-sub-seq [1 0 1 2 3 0 4 5]) ; => [0 1 2 3]
  (longest-increasing-sub-seq [7 6 5 4])) ; => []

; works like a charm! :)
