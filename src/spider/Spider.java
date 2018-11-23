package spider;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import helpers.SpiderConstants;
import webgraph.WebDirectedGraph;

public class Spider implements Runnable, I_Spider {
	
	  private String sourceUrl;
	  private ConcurrentLinkedQueue<String> urlQueueToVisit;
	  private WebDirectedGraph graph;
	  private HashSet<String> visitedURLs;
	  

	@Override
	public void run() {
		
		if (visitedURLs.contains(sourceUrl)) return;
		
		visitedURLs.add(sourceUrl);
		
		try {
			
			Pattern pattern = Pattern.compile(SpiderConstants.REGEX);
			
			Document document = Jsoup.connect(sourceUrl).get();
			Elements links = document.body().getElementsMatchingText(pattern);
			
			for (Element l : links) {
				
				String t = l.toString();
				
				System.out.println(l);
				
				if (!t.equals(sourceUrl)) {
					
					graph.addLink(sourceUrl, t);
					
					if (!urlQueueToVisit.contains(t) && !visitedURLs.contains(t))
						urlQueueToVisit.add(t);
					
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	
	public Spider(String url, ConcurrentLinkedQueue<String> q, WebDirectedGraph g, HashSet<String> v) {
	    this.sourceUrl = url;
	    this.urlQueueToVisit = q;
	    this.graph = g;
	    this.visitedURLs = v;
	}

}
