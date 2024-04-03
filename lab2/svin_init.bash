#init
pr=file:///$(pwd)/svnclown
svnadmin create svnclown
cd svnclown
svn mkdir ${pr}/red ${pr}/branches -m "Init"
svn checkout ${pr}/red main
cd main