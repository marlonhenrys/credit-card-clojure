(ns credit-card.logic)

(defn search
  [key value purchases]
  (filter #(= (key %) value) purchases))

(defn resume-by-group
  [reducer [group purchases]]
  {group (reducer purchases)})

(defn report
  [group reducer purchases]
  (->> purchases
       (group-by group)
       (map #(resume-by-group reducer %))
       (apply merge)))