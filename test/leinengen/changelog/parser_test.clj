(ns leinengen.changelog.parser-test
  (:require [clojure.test :refer :all]
            [leinengen.changelog.parser :as parser]))

(deftest git-message
  (testing "complete"
    (is (= (parser/git-message "fix(parser): message [#issueId] (#pullId)")
           [:message
            [:type "fix"]
            [:subject "parser"]
            [:title " message "]
            [:issue "#issueId"]
            [:pull "#pullId"]])))
  (testing "without ids"
    (is (= (parser/git-message "fix(parser): message")
           [:message
            [:type "fix"]
            [:subject "parser"]
            [:title " message"]]))))