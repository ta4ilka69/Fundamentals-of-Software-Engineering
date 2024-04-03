pr=file:///$(pwd)/svnclown
svnadmin create svnclown
cd svnclown
svn mkdir ${pr}/red ${pr}/branches -m "Init"
svn checkout ${pr}/red main
cd main
cp -f ~/commits/commit0/* ./
svn add * --username="roma" --force
svn commit -m "r0" --username="roma"
cp -f ~/commits/commit1/* ./
svn commit -m "r1" --username="roma"
svn copy ${pr}/red ${pr}/branches/blue -m "artem-init" --username="artem"
svn switch ${pr}/branches/blue
cp -f ~/commits/commit2/* ./
svn add * --username="artem" --force
svn commit -m "r2" --username="artem"
svn switch ${pr}/red
cp -f ~/commits/commit3/* ./
svn add * --username="roma" --force
svn commit -m "r3" --username="roma"
cp -f ~/commits/commit4/* ./
svn add * --username="roma" --force
svn commit -m "r4" --username="roma"
svn copy ${pr}/red ${pr}/branches/bluemiddle -m "artem-init-2" --username="artem"
svn switch ${pr}/branches/bluemiddle
cp -f ~/commits/commit5/* ./
svn add * --username="artem" --force
svn commit -m "r5" --username="artem"
svn switch ${pr}/branches/blue
cp -f ~/commits/commit6/* ./
svn add * --username="artem" --force
svn commit -m "r6" --username="artem"
cp -f ~/commits/commit7/* ./
svn add * --username="artem" --force
svn commit -m "r7" --username="artem"
cp -f ~/commits/commit8/* ./
svn add * --username="artem" --force
svn commit -m "r8" --username="artem"
cp -f ~/commits/commit9/* ./
svn add * --username="artem" --force
svn commit -m "r9" --username="artem"
svn switch ${pr}/red
cp -f ~/commits/commit10/* ./
svn add * --username="roma" --force
svn commit -m "r10" --username="roma"
svn switch ${pr}/branches/blue
cp -f ~/commits/commit11/* ./
svn add * --username="artem" --force
svn commit -m "r11" --username="artem"
cp -f ~/commits/commit12/* ./
svn add * --username="artem" --force
svn commit -m "r12" --username="artem"
svn switch ${pr}/branches/bluemiddle
svn merge ${pr}/branches/blue --username="artem"
r
r
cp -f ~/commits/commit13/* ./
svn add * --username="artem" --force
svn commit -m "r13" --username="artem"
svn switch ${pr}/red
svn merge ${pr}/branches/bluemiddle --username="roma"
tc
cp -f ~/commits/commit14/* ./
svn add * --username="roma" --force
svn commit -m "r14" --username="roma"
#сделать два хука
#1) прекоммит, который будет форматить код
#2) премердж хук который чтобы названия коммита формировалось из всех вмердживаемых строк (если у мерджа нет названия, делать автоматом именно это)