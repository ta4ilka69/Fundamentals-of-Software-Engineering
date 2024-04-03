#r0
cp -f ~/commits/commit0/* ./
svn add * --username="roma"
svn commit -m "r0" --username="roma"
#r1
cp -f ~/commits/commit1/* ./
svn commit -m "r1" --username="roma"
#new branch blue
svn copy ${pr}/red ${pr}/branches/blue -m "artem-init" --username="artem"
svn switch ${pr}/branches/blue
#r2
cp -f ~/commits/commit2/* ./
svn add * --username="artem"
svn commit -m "r2" --username="artem"
svn switch ${pr}/red
#r3
cp -f ~/commits/commit3/* ./
svn add * --username="roma"
svn commit -m "r3" --username="roma"
#r4
cp -f ~/commits/commit4/* ./
svn add * --username="roma"
svn commit -m "r4" --username="roma"
#new branch bluemiddle (still mine)
svn copy ${pr}/red ${pr}/branches/bluemiddle -m "artem-init-2" --username="artem"
svn switch ${pr}/branches/bluemiddle
#r5
cp -f ~/commits/commit5/* ./
svn add * --username="artem"
svn commit -m "r5" --username="artem"
svn switch ${pr}/branches/blue
#r6
cp -f ~/commits/commit6/* ./
svn add * --username="artem"
svn commit -m "r6" --username="artem"
#r7
cp -f ~/commits/commit7/* ./
svn add * --username="artem"
svn commit -m "r7" --username="artem"
#r8
cp -f ~/commits/commit8/* ./
svn add * --username="artem"
svn commit -m "r8" --username="artem"
#r9
cp -f ~/commits/commit9/* ./
svn add * --username="artem"
svn commit -m "r9" --username="artem"
#switch to red
svn switch ${pr}/red
#r10
cp -f ~/commits/commit10/* ./
svn add * --username="roma"
svn commit -m "r10" --username="roma"
#switch to blue
svn switch ${pr}/branches/blue
#r11
cp -f ~/commits/commit11/* ./
svn add * --username="artem"
svn commit -m "r11" --username="artem"
#r12
cp -f ~/commits/commit12/* ./
svn add * --username="artem"
svn commit -m "r12" --username="artem"
#merge blue to bluemiddle
svn switch ${pr}/branches/bluemiddle
svn merge ${pr}/branches/blue --username="artem"
#answers for merge
r
r
#r13
cp -f ~/commits/commit13/* ./
svn add * --username="artem"
svn commit -m "r13" --username="artem"
#switch to red
svn switch ${pr}/red
svn merge ${pr}/branches/bluemiddle --username="roma"
#answers for merge
tc
#r14
cp -f ~/commits/commit14/* ./
svn add * --username="roma"
svn commit -m "r14" --username="roma"