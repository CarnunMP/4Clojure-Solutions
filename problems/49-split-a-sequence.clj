; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

(= ((fn [n s] (list (take n s) (drop n s))) 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]) ; => true
(= ((fn [n s] (list (take n s) (drop n s))) 1 [:a :b :c :d]) [[:a] [:b :c :d]]) ; => true
(= ((fn [n s] (list (take n s) (drop n s))) 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]) ; => true

; Another cool solution: (juxt take drop)