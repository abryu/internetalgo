package main;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import helpers.Helpers;
import spider.Spider;
import webgraph.WebDirectedGraph;

public class Controller {
	
	private Map<String, String> config;
	private ConcurrentLinkedQueue<String> urlQueueToVisit;
	private WebDirectedGraph graph;
	private HashSet<String> visitedURLs;
	
	public Controller() {
		
	    this.config = Helpers.loadConfigFile();
	    this.urlQueueToVisit = new ConcurrentLinkedQueue<>();
	    this.graph = WebDirectedGraph.getInstance();
	    this.visitedURLs = new HashSet<>();
		
	}
	
	public void startParllerCrawler() {
		
		int numOfProcessors = Integer.valueOf(config.get("NUMBER_OF_THREADS"));
		
	    ThreadPoolExecutor threadPool =
	            new ThreadPoolExecutor(numOfProcessors, numOfProcessors,
	                    10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	    
	    urlQueueToVisit.add(config.get("ORIGINAL_SEED_URL"));
	    
	    while (graph.getNumberOfNodes() >= Integer.valueOf(config.get("MAX_NUMBER_OF_GRAPH_NODES"))) {
	    	
	    	int numOfUnvisitedURLs = urlQueueToVisit.size();
	    	
	    	Queue<String> breadth = new LinkedList<String>();
	    	
	    	for (int i = 0; i < numOfUnvisitedURLs; i++)
	    		breadth.add(urlQueueToVisit.poll());
	    		
	        while (!breadth.isEmpty()) {
	        	String url = breadth.poll();
	        	if (url != null)
	        		threadPool.execute(new Spider(url, urlQueueToVisit, graph, visitedURLs));
	        }
	    	

	    }
	    
	
		
	}

}
