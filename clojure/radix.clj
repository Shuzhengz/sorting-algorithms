(ns sorting-algorithms.radix
    (:import sorting-algorithms.counting))

;; Radix Sort
(defn- ret-pos
  "Returns the digit by the position"
  [num base pos]
  (let [exp (Math/pow base pos)]
    (-> (/ num exp)
        (mod base)
        int)))

(defn radixsort
  "Radix Sort"
  [coll ndigits]
  (let [len (count coll)
        coll (vec coll)]
    (loop [i 0 result coll]
      (if (= i ndigits)
        result
        (recur (inc i)
          (countingsort
           result
           10
           (fn [coll idx]
             (ret-pos (nth coll idx) 10 i))))))))
