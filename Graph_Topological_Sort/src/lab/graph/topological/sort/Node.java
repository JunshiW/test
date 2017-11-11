package lab.graph.topological.sort;
import java.util.ArrayList;


public class Node {
		private boolean visited;
		private boolean added; // "added" used for judging if a node data added into
						// result list
		private int indegree;
		private int outdegree;
		private int target;
		private String data;
		private ArrayList<Node> next;

		public Node(String data, int size) {
			this.visited = false;
			this.added = false;
			indegree = 0;
			outdegree = 0;
			this.data = data;
			target = 0;
			next = new ArrayList<Node>(size * 3);
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public boolean isAdded() {
			return added;
		}

		public void setAdded(boolean added) {
			this.added = added;
		}

		public int getIndegree() {
			return indegree;
		}

		public void setIndegree(int indegree) {
			this.indegree = indegree;
		}

		public int getOutdegree() {
			return outdegree;
		}

		public void setOutdegree(int outdegree) {
			this.outdegree = outdegree;
		}

		public int getTarget() {
			return target;
		}

		public void setTarget(int target) {
			this.target = target;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public ArrayList<Node> getNext() {
			return next;
		}

		public void setNext(ArrayList<Node> next) {
			this.next = next;
		}


	}
