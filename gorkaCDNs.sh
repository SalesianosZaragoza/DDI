#! /bin/bash

OLDJS=https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js
OLDCSS=https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css
NEWCSS=https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css
NEWJS=https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js

TARGET=Bootstrap/*/index.html

sed -i -e "s#$OLDJS#$NEWJS#g" $TARGET 
sed -i -e "s#$OLDCSS#$NEWCSS#g" $TARGET 
