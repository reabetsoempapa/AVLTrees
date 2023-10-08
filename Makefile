.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<
	
CLASSES2=Vaccine.class \
	 BinaryTree.class \
	 BinaryTreeNode.class \
	 AVLTree.class \
	 AVLExperiment.class \

CLASSES=$(CLASSES2:%.class=$(BINDIR)/%.class)

default: $(CLASSES)

	
clean:
	rm $(BINDIR)/*.class