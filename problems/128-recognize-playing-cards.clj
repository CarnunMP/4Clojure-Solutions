(defn recognize
  [card-string]
  (let [suits {\H :heart
               \D :diamond
               \S :spade
               \C :club}
        ranks (merge (zipmap (seq (apply str (range 2 10)))
                             (range 8))
                     {\T 8
                      \J 9
                      \Q 10
                      \K 11
                      \A 12})
        card-seq (seq card-string)
        suit-char (first card-seq)
        rank-char (second card-seq)]
    {:suit (suits suit-char)
     :rank (ranks rank-char)}))

;; Huh. Cool, more succint impl from user 1067 using arg destructuring and condp:
(fn [[s r]]
  {:suit (condp = s
           \D :diamond
           \H :heart
           \C :club
           \S :spade)
   :rank (condp = r
           \A 12
           \K 11
           \Q 10
           \J 9
           \T 8
           (- (int r) 50))}) ; (hmm and weird char stuff... :P )

;; I didn't know you could destructure strings in this way! :)
