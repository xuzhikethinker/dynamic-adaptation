package eu.choreos.analysis;

import org.junit.Before;
import org.junit.Test;

import tests.util.GraphFactory;
import tests.util.GraphFactory.TestGraph;
import edu.uci.ics.jung.graph.DirectedGraph;
import eu.choreos.analysis.entity.CentralityAnalysis;

/**
 * Tests the centralities calculations with a graph more complex (but not so much)
 * 
 * @author leofl
 *
 */
public class CentralityComplexTest {

	private DependencyAnalyzer<String,String> analyzer;
	private DirectedGraph<String,String> graph;
	private CentralityAnalysis<String,String> expectedCentrality;
	private CentralityAnalysis<String,String> actualCentrality;
	
	@Before
	public void setUp() {
		
		GraphFactory factory = new GraphFactory();
		graph = factory.getSimpleGraph(TestGraph.COMPLEX);
		expectedCentrality = factory.getSimpleCentralityAnalysis(TestGraph.COMPLEX);		
		analyzer = new JungAnalyzer<String,String>(graph);
		actualCentrality = analyzer.calculateCentralityAnalysis();		
	}
	
	@Test
	public void shouldCalculateVerticeDegreeCentrality() {

		CentralityBaseTests.shouldCalculateVerticeDegreeCentrality(expectedCentrality, actualCentrality);
	}

	@Test
	public void shouldCalculateGraphDegreeCentrality() {
		
		CentralityBaseTests.shouldCalculateGraphDegreeCentrality(expectedCentrality, actualCentrality);
	}
	
	@Test
	public void shouldCalculateVerticesBetweenessCentrality() {
		
		CentralityBaseTests.shouldCalculateVerticesBetweenessCentrality(expectedCentrality, actualCentrality);
	}

	@Test
	public void shouldCalculateVerticesPageRank() {
		
		CentralityBaseTests.shouldCalculateVerticesPageRank(expectedCentrality, actualCentrality);
	}

}