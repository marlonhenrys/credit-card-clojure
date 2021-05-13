(ns credit-card.db
  (:require [credit-card.models :as cc.models]))

(def category {:service "Serviço"
               :food    "Alimentação"
               :health  "Saúde"
               :product "Produto"})

(def purchases [[50, "Uber", "2020-01-02T10:00:00", (:service category)]
                [499, "Americanas", "2020-02-06T10:00:00", (:product category)]
                [40, "Uber Eats", "2020-01-14T10:00:00", (:food category)]
                [22, "Drogaria Araújo", "2020-01-23T10:00:00", (:health category)]
                [46, "Netflix", "2020-01-25T10:00:00", (:service category)]
                [30, "iFood", "2020-01-29T10:00:00", (:food category)]
                [32, "Uber", "2020-02-03T10:00:00", (:service category)]
                [18, "Droga Clara", "2020-02-11T10:00:00", (:health category)]
                [21, "Uber", "2020-02-19T10:00:00", (:service category)]
                [46, "Netflix", "2020-02-25T10:00:00", (:service category)]
                [17, "Spotify", "2020-02-27T10:00:00", (:service category)]
                [29, "iFood", "2020-03-13T10:00:00", (:food category)]
                [30, "Burguer King", "2020-03-27T10:00:00", (:food category)]
                [899, "Amazon", "2020-03-30T10:00:00", (:product category)]])

(defn load-mocked-purchases [card-id]
  (map #(apply cc.models/new-purchase card-id %) purchases))
