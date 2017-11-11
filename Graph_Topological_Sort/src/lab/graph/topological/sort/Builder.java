package lab.graph.topological.sort;

/*
 
* author Junshi Wang

 * This class uses graph data structure to implement
 * topological sort, and allow user to check each step for every 
 * target.
 * graph data structure is defined by author, include Node class.
 */


import java.util.ArrayList;

public class Builder {
	private static String input; // store input String
	private ArrayList<Node> resultFinal; // store topological result
	private ArrayList<String> result; // store steps for specific target
	private static int size; // number of lines
	private static ArrayList<String> seprator; // store separator to distinguish
												// target, steps and command
	private static ArrayList<Node> nodes; // store every Node

	/**
	 * constructor
	 * 
	 * @param makefile
	 *            the incoming file
	 * @throws ParseException
	 *             check if there exist input error
	 * @throws UnknownTargetException
	 *             check if the input string is complete
	 * @throws CycleDetectedException
	 *             check if there exist a cycle in input String
	 */
	public Builder(String makefile) throws ParseException,
			UnknownTargetException, CycleDetectedException {

		size = 0;
		String[] subString;
		int indexFirst; // index of first ":"
		int lastIndex; // index of second ":"
		int j = 0;
		Node first; // String before first ":"
		Node second; // String between first and second ":"
		Node third; // String after second ":"
		int flag1 = 0; // check if the first node has already in nodes list
		int Cycleflag = 0; // flag to check cycle
		int flag3 = 0; // check UnknownTargetException
		nodes = new ArrayList<Node>(100);
		resultFinal = new ArrayList<Node>(100);

		if (makefile == null)
			throw new ParseException();
		else
			input = makefile;
		seprator = new ArrayList<String>(3);
		seprator.add("\n");
		seprator.add(":");
		seprator.add(" ");

		// check the size of input String based on "\n"
		int temp = input.length() - 1;
		for (int i = 0; i < input.length(); i++) {
			String subStr = input.substring(i, i + 1);
			if (subStr.equals(seprator.get(0))) {
				size++;
				temp = i;
			}
		}
		if (size == 0 || temp < input.length() - 1)
			size++;
		if (size > 1)
			subString = input.split(seprator.get(0));
		else
			subString = new String[] { input };

		/*
		 * Create graph
		 */
		while (j != size) {
			// check input error and divide each line into three parts
			if (subString[j].indexOf(seprator.get(1)) < 0) // structure error
															// (if not exists
															// ":")
				throw new ParseException();
			else
				indexFirst = subString[j].indexOf(seprator.get(1));
			if (subString[j].lastIndexOf(seprator.get(1)) == subString[j]
					.indexOf(seprator.get(1))) // structure error (only one ":")
				throw new ParseException();
			else
				lastIndex = subString[j].lastIndexOf(seprator.get(1));
			if (subString[j].length() - lastIndex == 1) // structure error (if
														// command for target is
														// null)
				throw new ParseException();
			if (include((String) subString[j].subSequence(lastIndex + 1,
					subString[j].length()))) // duplicate error (if command has
												// exists)
				throw new ParseException();
			third = new Node((String) subString[j].subSequence(lastIndex + 1,
					subString[j].length()), size);

			if (include((String) subString[j].subSequence(0, indexFirst))) {
				first = getNode((String) subString[j]
						.subSequence(0, indexFirst));
				flag1 = 1;
			} else
				first = new Node((String) subString[j].subSequence(0,
						indexFirst), size);
			third.getNext().add(first);
			third.setOutdegree(third.getOutdegree() + 1);
			first.setIndegree(first.getIndegree() + 1);
			first.setTarget(1);

			// check if there exist more than one pre-requirement
			// if more than one requirement, split them into several nodes
			if (lastIndex - indexFirst != 1) {
				String[] str2 = ((String) subString[j].subSequence(
						indexFirst + 1, lastIndex)).split(seprator.get(2));

				for (int i = 0; i < str2.length; i++) {
					if (str2[i].contains(":") == true) { // if more than two ":"
						flag3 = 1;
						throw new ParseException();
					}
					if (include(str2[i])) {
						second = getNode(str2[i]);
					} else {
						second = new Node((String) str2[i], size);
						nodes.add(second);
					}
					second.getNext().add(third);
					second.setOutdegree(second.getOutdegree() + 1);
					third.setIndegree(third.getIndegree() + 1);
				}
			}

			if (flag3 != 1)
				nodes.add(third);

			if (flag1 != 1)
				nodes.add(first);

			j++;
			flag1 = 0;
			flag3 = 0;
		}

		// check exception
		// every target companies with a command
		if (nodes.size() % 2 != 0)
			throw new UnknownTargetException();

		// if no source node, then exists cycle
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getIndegree() == 0)
				Cycleflag = 1;
		}
		if (Cycleflag == 0)
			throw new CycleDetectedException();

	}

	/*
	 * give every step to make the give target
	 * 
	 * @param targetName
	 *            the target
	 * @return result the made target
	 */
	public ArrayList<String> makeTarget(String targetName) {
		int findex = -1; // index of target in topological sort result list

		if (resultFinal.size() == 0)
			topologicSort();
		result = new ArrayList<String>(resultFinal.size());

		for (int i = 0; i < resultFinal.size(); i++) {
			if (resultFinal.get(i).getData().equals(targetName)) {
				findex = i;
				break;
			}
		}
		if (findex == -1)
			return result;

		print(resultFinal.get(findex));
		// reset condition about each node in topological sort result list
		for (int i = 0; i < resultFinal.size(); i++)
			resultFinal.get(i).setAdded(false);

		return result;
	}

	/*
	 * Recursively find every step
	 * 
	 * @param target
	 *            target that to be made
	 */
	private void print(Node target) {
		int indegree = target.getIndegree();
		int outdegree = 0;

		for (int j = resultFinal.size() - 1; j >= 0; j--) {
			if (indegree != 0) {
				outdegree = resultFinal.get(j).getOutdegree();
				for (int a = 0; a < outdegree; a++)
					if (resultFinal.get(j).getNext().get(a).getData()
							.equals(target.getData())) {
						outdegree--;
						indegree--;
						print(resultFinal.get(j));
						if (resultFinal.get(j).getTarget() == 0
								&& resultFinal.get(j).isAdded() == false) {
							resultFinal.get(j).setAdded(true);
							result.add(resultFinal.get(j).getData());
						}
					}
			} else
				break;
		}
	}

	/*
	 * 
	 * Judge if there has already exists the given node
	 * 
	 * @param nodeData
	 * @return result of the judgment
	 */
	private static boolean include(String nodeData) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getData().equals(nodeData))
				return true;
		}
		return false;
	}

	/*
	 * 
	 * Find the node in nodes list based on given node data.
	 * 
	 * @param nodeData
	 * @return node in nodes list or null
	 */
	private static Node getNode(String nodeData) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getData().equals(nodeData))
				return nodes.get(i);
		}
		return null;
	}

	/*
	 * 
	 * Sorting graph nodes
	 * 
	 * @param n
	 *            implementing DFS sort from node n
	 */
	private void DFS(Node n) {

		n.setVisited(true);
		for (int a = 0; a < n.getNext().size(); a++)
			if (n.getNext().get(a).isVisited() == false)
				DFS(n.getNext().get(a));

		resultFinal.add(n);
	}

	/*
	 * 
	 * Function to sort a graph Obtain a linear ordering of the vertices such
	 * that for every edge (u, v), u appears before v in the ordering.
	 */
	private void topologicSort() {
		ArrayList<Node> ns = new ArrayList<Node>(nodes.size());
		ns = nodes;
		Node j = new Node(null, 0);
		for (int i = 0; i < ns.size(); i++) {
			if (ns.get(i).getIndegree() == 0 && ns.get(i).isVisited() == false) {
				ns.get(i).setVisited(true);
				j = ns.get(i);
				DFS(j);
			}
		}
	}
	

}
