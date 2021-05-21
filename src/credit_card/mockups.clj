(ns credit-card.mockups
  (:require [credit-card.models :as cc.models]))

(def categories [[:service "Serviço"]
                 [:food "Alimentação"]
                 [:health "Saúde"]
                 [:product "Produto"]])

(def purchases [[50 "Uber" "2020-01-02T10:00:00" [:category/key :service]]
                [499 "Americanas" "2020-02-06T10:00:00" [:category/key :product]]
                [40 "Uber Eats" "2020-01-14T10:00:00" [:category/key :food]]
                [22 "Drogaria Araújo" "2020-01-23T10:00:00" [:category/key :health]]
                [46 "Netflix" "2020-01-25T10:00:00" [:category/key :service]]
                [30 "iFood" "2020-01-29T10:00:00" [:category/key :food]]
                [32 "Uber" "2020-02-03T10:00:00" [:category/key :service]]
                [18 "Droga Clara" "2020-02-11T10:00:00" [:category/key :health]]
                [21 "Uber" "2020-02-19T10:00:00" [:category/key :service]]
                [46 "Netflix" "2020-02-25T10:00:00" [:category/key :service]]
                [17 "Spotify" "2020-02-27T10:00:00" [:category/key :service]]
                [29 "iFood" "2020-03-13T10:00:00" [:category/key :food]]
                [30 "Burguer King" "2020-03-27T10:00:00" [:category/key :food]]
                [899 "Amazon" "2020-03-30T10:00:00" [:category/key :product]]])

(defn load-mocked-categories []
  (map #(apply cc.models/new-category %) categories))

(defn load-mocked-purchases []
  (map #(apply cc.models/new-purchase %) purchases))