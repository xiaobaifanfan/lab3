package text1;

import java.util.ArrayList;

class Text {
    private String text;
    private String[] words;
    private int wordsNumber;
    public Text(String text) {
	this.text = text;
	if(text.length() == 0)
	    return;
	wordsNumber = 1;
	for(int i = 0; i < text.length(); i++)
	    if(text.charAt(i) == ' ')
		wordsNumber++;
	words = new String[wordsNumber];
	int beginIndex = 0, endIndex = 1;
	for(int i = 0; i < wordsNumber; i++) {
	    while(endIndex < text.length() && text.charAt(endIndex) != ' ')
		endIndex++;
	    words[i] = text.substring(beginIndex, endIndex);
	    beginIndex = ++endIndex;
	}
    }
    public int getNum() {
	return wordsNumber;
    }
    public String getWordIndex(int i) {
	return words[i];
    }
}

class DirectGraph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    public DirectGraph(int n) {
	edges = new int[n][n];
	vertexList = new ArrayList<String>(n);
    }
    public void insertVertex(String name) {
	vertexList.add(vertexList.size(), name);
    }
    public void insertEdge(int v1, int v2, int weight) {
	edges[v1][v2] = weight;
    }
    public int getWeight(int v1, int v2) {
	return edges[v1][v2];
    }
    public int locateVertex(String vertexName) {
	return vertexList.indexOf(vertexName);
    }
    public StringBuffer printGraph() {
	StringBuffer graphInfo;
	graphInfo = new StringBuffer("鏈�" + vertexList.size() + "涓《鐐筡n");
	for(int i = 0; i < vertexList.size(); i++) {
	    for(int j = 0; j < vertexList.size(); j++) {
		graphInfo.append(edges[i][j]);
		graphInfo.append(' ');
	    }
	    graphInfo.append('\n');
	}
	return graphInfo;
    }
}

public class demo11 {
    public static void main(String []args) {
	Text test = new Text("a b c d e f g h i j k l m n o p q r s t");
	System.out.println("鏈�" + test.getNum() + "涓崟璇�");
	for(int i = 0; i < test.getNum(); i++) {
	    System.out.println("绗�" + (i + 1) + "涓槸" + test.getWordIndex(i));
	}
	System.out.println("=======================");
	DirectGraph testGraph = new DirectGraph(test.getNum());
	WordsToGraph(test, testGraph);
	System.out.print(testGraph.printGraph());
    }
    private static void WordsToGraph(Text text, DirectGraph graph) {
	for(int i = 0; i < text.getNum(); i++) {
	    if(graph.locateVertex(text.getWordIndex(i)) == -1)
		graph.insertVertex(text.getWordIndex(i));
	}
	int v1, v2;
	for(int i = 0; i < text.getNum() - 1; i++) {
	    v1 = graph.locateVertex(text.getWordIndex(i));
	    v2 = graph.locateVertex(text.getWordIndex(i + 1));
	    graph.insertEdge(v1, v2, graph.getWeight(v1, v2) + 1);
	}
    }
}
