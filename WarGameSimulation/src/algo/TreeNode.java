package algo;

import java.util.List;
import java.util.ArrayList;

public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	
	public TreeNode() {
		data = null;
		parent = null;
		children = new ArrayList<TreeNode<T>>();
	}
	
	public TreeNode(T data) {
		this.data = data;
		parent = null;
		children = new ArrayList<TreeNode<T>>();
	}
	
	public TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
		children = new ArrayList<TreeNode<T>>();
	}
	
	/**
	 * Set data for tree node.
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Get data from tree node.
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Set parent tree node.
	 * 
	 * @param parent
	 */
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	
	/**
	 * Get parent tree node.
	 * 
	 * @return parent node
	 */
	public TreeNode<T> getParent(){
		return parent;
	}
	
	/**
	 * 
	 * 
	 * @param children
	 */
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	
	/**
	 * Get list of child nodes. If null, this is leaf node.
	 * 
	 * @return
	 */
	public List<TreeNode<T>> getChildren() {
		return children;
	}
	
	/**
	 * Determines of this instance of TreeNode is root.
	 * 
	 * @return boolean
	 */
	public boolean isRoot() {
		if (parent == null)
			return true;
		else
			return false;
	}
}
