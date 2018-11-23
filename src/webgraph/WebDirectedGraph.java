package webgraph;

public class WebDirectedGraph implements I_WebGraph {
	
	private static WebDirectedGraph instance;
	
	public static synchronized WebDirectedGraph getInstance() {
		    if (instance == null)
		      instance = new WebDirectedGraph();
		    return instance;
    }
	  

	@Override
	public int getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfLinks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasPathTo(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStronglyConnected(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInDegree(String url) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOutDegree(String url) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addLink(String from, String to) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printNodes() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getShortestDistance(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAverageDistance(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getShortestDistancePath(String originalURL, String destinationURL) {
		// TODO Auto-generated method stub
		return null;
	}

}
