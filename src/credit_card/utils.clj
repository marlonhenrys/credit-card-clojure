(ns credit-card.utils)

(defn total-amount
  [purchases]
  (->> purchases
       (map :amount)
       (reduce +)))

(defn get-month
  [purchase]
  (-> purchase
      :date
      (subs 5 7)))
