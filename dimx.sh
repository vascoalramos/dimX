#!/bin/bash

if [ $# -eq 0 ]
  then
    echo "usage: dimxc.sh [files_to_compile]"
    exit 1
fi

for arg in $@ 
do
    java $arg
done 
