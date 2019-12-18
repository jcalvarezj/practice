/*
 * Basic example of binary tree data structure
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <string>
#include <math.h>

class Node {
public:
	Node(std::string info): info(info) {
		left = NULL;
		right = NULL;
	}

	Node * getLeft() {
		return left;
	}

	void setLeft(Node * left) {
		this->left = left;
	}

	Node * getRight() {
		return right;
	}

	void setRight(Node * right) {
		this->right = right;
	}

	std::string getInfo() {
		return info;
	}

	void printNode() {
		std::cout << info << std::endl;
	}

	void printNodeComplete() {
		std::string leftInfo = left ? left->getInfo() : "NULL";
		std::string rightInfo = right ? right->getInfo() : "NULL";
		std::cout << info << "... children:\n\t" << leftInfo << " - " <<
			rightInfo << std::endl;
	}

private:
	Node * left;
	Node * right;
	std::string info;
};

class BinaryTree {
public:
	BinaryTree() {
		root = NULL;
	}

	Node * getRoot() {
		return root;
	}

	void addNode(Node * node) {
		if(!root)
			root = node;
		else
			addNodeToSubTree(node, root);
	}

	void addNodeToSubTree(Node * node, Node * subTree) {
		if(!subTree)
			subTree = node;
		else {
			int comparison = node->getInfo().compare(subTree->getInfo());
			if(comparison < 0) {
				if(!subTree->getLeft())
					subTree->setLeft(node);
				else
					addNodeToSubTree(node, subTree->getLeft());
			}
			else {
				if(!subTree->getRight())
					subTree->setRight(node);
				else
					addNodeToSubTree(node, subTree->getRight());
			}
		}
	}

	void printTree() {
		printSubTree(root, 0);
	}

	void printSubTree(Node * subTree, int level) {
		if(subTree) {
			int nTabs = level == 0 ? 0 : (int)pow(2.0, level - 1);
			for(int i = 0; i < nTabs ; i++)
				std::cout << "\t";
			subTree->printNode();
			printSubTree(subTree->getLeft(), level + 1);
			printSubTree(subTree->getRight(), level + 1);
		}
	}

	void cleanTree() {
		if(root)
			cleanSubTree(root);
	}

	void cleanSubTree(Node * subTree) {
		if(subTree) {
			cleanSubTree(subTree->getLeft());
			cleanSubTree(subTree->getRight());
			delete subTree;
		}
	}

	Node * search(std::string info) {
		Node * found = NULL;

		if(root) {
				found = searchSubTree(info, root);
		}

		return found;
	}

	Node * searchSubTree(std::string info, Node * subTree) {
		Node * found = NULL;

		if(subTree) {
			if(subTree->getInfo().compare(info) == 0)
				found = subTree;
			else {
				found = searchSubTree(info, subTree->getLeft());
				if(!found)
					found = searchSubTree(info, subTree->getRight());
			}
		}

		return found;
	}

private:
	Node * root;
};

int main(int argc, char ** args) {
	BinaryTree * bt = new BinaryTree;

	bt->addNode(new Node("figaro"));
	bt->addNode(new Node("pepe"));
	bt->addNode(new Node("coal"));
	bt->addNode(new Node("boat"));
	bt->addNode(new Node("hello"));
	bt->addNode(new Node("aloha"));
	bt->addNode(new Node("cello"));

	bt->printTree();

	std::string searchInfo = "pepe";
	std::cout << "Searching for... " << searchInfo << std::endl; 
	Node * search = bt->search(searchInfo);

	if(!search)
		std::cout << "Node not found :(" << std::endl;
	else {
		std::cout << "Found it :)" << std::endl; 
		search->printNodeComplete();
	}

	bt->cleanTree();
	delete bt;

	return 0;
}

