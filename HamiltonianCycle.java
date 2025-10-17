import java.util.Scanner;  
public class HamiltonianCycle 
 { 
    final int V; 
    int path[];
  public HamiltonianCycle(int v) 
 { 
  V = v; 
  path = new int[V]; 
    } 
  void printSolution(int graph[][])  
{ 
 System.out.print("Hamiltonian Cycle: "); 
 for (int i = 0; i < V; i++)  
{ 
  System.out.print(path[i] + " ");         
} 
   System.out.println(path[0]);   
} 
  boolean isSafe(int v, int graph[][], boolean visited[], int pos)  
{ 
  if (graph[path[pos - 1]][v] == 0)  
{ 
 return false;       
 } 
   if (visited[v])  
{ 
return false;       
 } 
return true;     
}  
 boolean hamCycleUtil(int graph[][], boolean visited[], int pos)  
{ 
  if (pos == V)  
{ 
  return graph[path[pos - 1]][path[0]] == 1;       
 } 
for (int v = 1; v < V; v++)  
{ 
  if (isSafe(v, graph, visited, pos))  
{ 
  path[pos] = v; 
  visited[v] = true; 
  if (hamCycleUtil(graph, visited, pos + 1))  
{ 
 return true;                 
} 
  visited[v] = false; 
    path[pos] = -1;              
}         
}    
return false;     
} 
 public boolean hamCycle(int graph[][])  
{ 
   for (int i = 0; i < V; i++)  
{ 
    path[i] = -1;     
 } 
 path[0] = 0; 
  boolean[] visited = new boolean[V]; 
  visited[0] = true; 
         
  if (!hamCycleUtil(graph, visited, 1)) 
 { 
     System.out.println("No Hamiltonian cycle found"); 
    return false; 
      
   } 
      printSolution(graph); 
      return true; 
    } 
    public static void main(String args[]) 
 { 
    int graph1[][] = 
 {
{0, 1, 0, 1, 0}, 
{1, 0, 1, 1, 1}, 
{0, 1, 0, 0, 1}, 
{1, 1, 0, 0, 1}, 
{0, 1, 1, 1, 0}, 
}; 
HamiltonianCycle hc = new HamiltonianCycle(graph1.length); 
hc.hamCycle(graph1); 
} 
}
