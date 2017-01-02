import sys
from PyQt4 import QtGui, QtCore

class Window(QtGui.QMainWindow):
    
    def __init__(self):
        super(Window,self).__init__()
        self.setGeometry(100,100,1000,600)
        self.setWindowTitle("self")  
        
        #main menu bar
        extractAction = QtGui.QAction("&Pick up", self)
        extractAction.setShortcut("Ctrl+Q")
        extractAction.setStatusTip("Exit the application")
        extractAction.triggered.connect(self.close_application)
        
        self.statusBar()
        
        mainMenu = self.menuBar()
        fileMenu = mainMenu.addMenu('&File')
        fileMenu.addAction(extractAction)
        self.home()
        
        
    def home(self):
        btn = QtGui.QPushButton("Quit", self)
        #btn.clicked.connect(QtCore.QCoreApplication.instance().quit)
        btn.clicked.connect(self.close_application)
        btn.resize(100,100)
        btn.move(100,100)
        
        #tool bar - for page specific menu options
        #extractAction = QtGui.QAction(QtGui.QIcon('sample.png'), 'Hover text',self)
        #extractAction.triggered.connect(self.close_application())
        
        #self.toolBar = self.addToolBar("Extraction")
        #self.toolBar.addAction(extractAction)
        self.show()
    
    def close_application(self):
        #pop up
        choice = QtGui.QMessageBox.question(self,'Ex',"Are you sure?",QtGui.QMessageBox.Yes, QtGui.QMessageBox.No)
        if choice == QtGui.QMessageBox.Yes:
            print("yes")
            sys.exit()
        else:
            pass
        #print("Custom!")
        #sys.exit()  

def run():        
    app = QtGui.QApplication(sys.argv)
    GUI = Window()
    sys.exit(app.exec_())
    
run()
