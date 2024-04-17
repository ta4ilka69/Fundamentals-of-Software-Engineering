#!/bin/bash
staged_files=$(git diff --cached --name-only --diff-filter=ACM | grep '\.java$')

if [[ -n "$staged_files" ]]; then
    echo "Formatting staged .java files..."
    for file in $staged_files; do
        java -jar ~/dop/google-java-format-1.22.0-all-deps.jar "$file" > tmp.java && mv tmp.java "$file"
        git add "$file"
    done
fi
