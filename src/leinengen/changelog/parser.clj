(ns leinengen.changelog.parser
  (:require [instaparse.core :as insta]))

(def git-message
  (insta/parser
   "message = type subject <\":\"> ws? title ws? issue? ws? pull?;
    type = text;
    title = text;
    subject = <\"(\"> text <\")\">;
    issue = <\"[\"> gitlink <\"]\">;
    pull = < \"(\"> gitlink <\")\">;
    <text> = #'[a-zA-Z0-9-_.\\s]*';
    <gitlink> = #'[a-zA-Z0-9-_./#]*'
    <ws> = <#\"\\s\">;"))