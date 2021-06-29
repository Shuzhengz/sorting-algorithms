(ns sorting-algorithms.counting)

;; Counting Sort
(defn countingsort
  "Counting Sort"
  ([coll n-buckets]
   (countingsort
    coll
    n-buckets
    (fn [coll idx]
      (nth coll idx))))
  ([coll n-buckets *get-elm]
   (let [len (count coll)
         coll (vec coll)]
     (loop [result (vec (replicate len 0))
            counts (counts-less-eq coll n-buckets *get-elm)
            idx (dec len)]
       (if (= idx -1)
         (rest result)
         (recur (assoc result (counts (*get-elm coll idx)) (nth coll idx))
           (assoc counts (*get-elm coll idx) (dec (counts (*get-elm coll idx))))
           (dec idx)))))))

(defn- counts-less-eq
  "Returns a vector of counts <= to the index"
  [coll n-buckets *get-elm]
  (let [len
        (count coll)
        counts-eq
        (reduce (fn [acc idx]
                  (let [elm (*get-elm coll idx)]
                    (assoc acc elm (inc (acc elm)))))
                (-> (replicate n-buckets 0) vec)
                (range len))]
    (reduce (fn [acc idx]
              (assoc acc idx (+ (acc idx) (acc (dec idx)))))
            counts-eq
            (range 1 n-buckets))))