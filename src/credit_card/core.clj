(ns credit-card.core
  (:require [credit-card.models :as cc.models]
            [credit-card.db :as cc.db]
            [credit-card.logic :as cc.logic]
            [credit-card.utils :as cc.utils])
  (:use [clojure pprint]))

(def user (cc.models/new-user "123.456.789-10", "Marlon Henrique", "marlon@henrique.com.br"))

(def card (cc.models/new-card (:id user), "1010202030304040", "123", "2023-06-01T00:00:00", 3050))

(def purchases (cc.db/load-mocked-purchases (:id card)))

(print-table purchases)

(map pprint ["User:" user
             "Card:" card
             "Search by Merchant:" (cc.logic/search :merchant "Netflix" purchases)
             "Search by Amount:" (cc.logic/search :amount 30 purchases)
             "Resume by Category:" (cc.logic/report :category cc.utils/total-amount purchases)
             "Resume by Month:" (cc.logic/report cc.utils/get-month cc.utils/total-amount purchases)])