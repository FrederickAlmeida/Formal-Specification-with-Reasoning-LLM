cd ../..
ls ./testcases/common/
for dirname in `ls ./testcases/common/`
do
    if test -d ./testcases/common/${dirname}
    then
        echo "python ./SpecGen.py --input ./testcases/common/${dirname}/${dirname}.java"
        python ./SpecGen.py --input ./testcases/common/${dirname}/${dirname}.java
    fi
done