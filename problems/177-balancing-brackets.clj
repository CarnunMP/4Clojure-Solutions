;;; When parsing a snippet of code it's often a good idea to do a sanity check to see if all the brackets match up.
;;; Write a function that takes in a string and returns truthy if all square [ ] round ( ) and curly { } brackets
;;; are properly paired and legally nested, or returns falsey otherwise.

; Okay, this one is pretty simple! Just need to add to a stack every time a left paren is encountered, and pop
; each time a corresponding right paren is hit. If we try to pop the wrong thing or reach the end of the string
; with parens left on the stack, the string isn't balanced. Otherwise, it is.

; Except... we're not dealing with mutable whatevers here! So we have to be a little clever.

; Hmm. Some kind of reduction that we can terminate early (in the case of trying to pop the wrong thing) should do it.
; Perhaps we can abuse try/catch/throw a little?

(require '[clojure.set :refer [map-invert]])

(defn balanced-parens? [s]
  (let [l->r {\( \)
              \[ \]
              \{ \}}
        r->l (map-invert l->r)
        starting-stack (if (l->r (first s))
                         (list (l->r (first s)))
                         '())]
    (try (->> (rest s)
              (reduce (fn [stack c]
                        ;(prn stack c)
                        (cond
                          (l->r c) ; left paren?
                          (conj stack (l->r c))

                          (r->l c) ; right paren?
                          (if (= c (first stack))
                            (pop stack)
                            (throw (Exception. "Unbalanced!")))

                          :else stack))
                      starting-stack)
              (empty?)) ; if the stack has any chars left in it -> unbalanced!
         (catch Exception _
           false))))

(comment
  (balanced-parens? "This string has no brackets.") ; => true
  (balanced-parens? "class Test {
                          public static void main(String[] args) {
                            System.out.println(\"Hello world.\");
                          }
                        }") ; => true
  (not (balanced-parens? "(start, end]")) ; => true
  (not (balanced-parens? "())")) ; => true
  (not (balanced-parens? "[ { ] } ")) ; => true
  (balanced-parens? "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))") ; => true
  (not (balanced-parens? "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))")) ; => true
  (not (balanced-parens? "[")) ; => true
  )
