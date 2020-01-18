
public class SegmentTree {
	private void update(Node node, int l, int r, int s, int e) {//这里的lazy代表区间的值取反
		updatelazy(node,l,r);
		if(s<=l&&r<=e) {
			node.sum=r-l+1-node.sum;
			if(l!=r) {
				getLnode(node).lazy^=1;
				getRnode(node).lazy^=1;
			}
			return;
		}
		int m=l+(r-l)/2;
		if(m>=s) {
			update(getLnode(node),l,m,s,e);
		}
		if(m+1<=e) {
			update(getRnode(node),m+1,r,s,e);
		}
		updatelazy(getLnode(node),l,m);
		updatelazy(getRnode(node),m+1,r);
		node.sum=getLnode(node).sum+getRnode(node).sum;//左右节点可能有lazy标记
	}
	void updatelazy(Node node,int l,int r) {
		if(node.lazy==1) {
			node.sum=(r-l+1)-node.sum;
			node.lazy=0;
			if(l!=r) {
				getLnode(node).lazy^=1;
				getRnode(node).lazy^=1;
			}
		}
	}
	private int search(Node node, int l, int r, int s, int e) {
		updatelazy(node,l,r);
		if(s<=l&&r<=e) {
			return node.sum;
		}
		int m=l+(r-l)/2;
		int ret=0;
		if(m>=s) {
			ret+=search(getLnode(node),l,m,s,e);
		}
		if(m+1<=e) {
			ret+=search(getRnode(node),m+1,r,s,e);
		}
		return ret;
	}
	private void insert(Node node,int l,int r,int idx) {
		if(l==r) {
			node.sum=1;
			return;
		}
		Node lnode=getLnode(node);
		Node rnode=getRnode(node);
		int m=l+(r-l)/2;
		if(idx<=m) {
			insert(lnode,l,m,idx);
		}else {
			insert(rnode,m+1,r,idx);
		}
		node.sum=lnode.sum+rnode.sum;
	}
	private Node getLnode(Node node) {
		if(node.lnode==null)node.lnode=new Node();
		return node.lnode;
	}
	private Node getRnode(Node node) {
		if(node.rnode==null)node.rnode=new Node();
		return node.rnode;
	}
	class Node{
		Node lnode,rnode;
		int lazy,sum;
	}
}
