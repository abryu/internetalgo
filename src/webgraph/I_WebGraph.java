package webgraph;

public interface I_WebGraph {
	
	int getDiameter();
	
	int getNumberOfNodes();

	int getNumberOfLinks();
	
	boolean hasPathTo(String originalURL, String destinationURL);
	
	boolean isConnected(String originalURL, String destinationURL);

	boolean isStronglyConnected(String originalURL, String destinationURL);
	
	int getInDegree(String url);

	int getOutDegree(String url);
	
    void addLink(String from, String to);
    
    void printNodes();
    
    int getShortestDistance(String originalURL, String destinationURL);

    int getAverageDistance(String originalURL, String destinationURL);

    String getShortestDistancePath(String originalURL, String destinationURL);
    
}
