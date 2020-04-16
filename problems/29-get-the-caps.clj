; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (empty? (__ "nothing"))
; (= (__ "$#A(*&987Zf") "AZ")

(= ((fn [s] (apply str (filter #(Character/isUpperCase %) (seq s)))) "HeLlO, WoRlD!") "HLOWRD") ; => true
(empty? ((fn [s] (apply str (filter #(Character/isUpperCase %) (seq s)))) "nothing")) ; => true
(= ((fn [s] (apply str (filter #(Character/isUpperCase %) (seq s)))) "$#A(*&987Zf") "AZ") ; => true
