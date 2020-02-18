import java.util.*;
import java.io.*;

public class ST {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		work();
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return a==0?b:gcd(b%a,a);
	}
	ArrayList<Integer>[] graph;
	int[][] A;
	int[] dis;
	void work() {
		int n=ni();
		dis=new int[n];
		A=new int[n][30];
		graph=ng(n,n-1);
		build(0,new boolean[n],0,0);
		int q=ni();
		for(int i=0;i<q;i++) {
			int x=ni()-1,y=ni()-1,a=ni()-1,b=ni()-1,k=ni();
			int v1=count(a,b);
			if(v1<=k&&v1%2==k%2) {
				out.println("YES");
				continue;
			}
			int v2=count(a,x)+count(b,y)+1;
			if(v2<=k&&v2%2==k%2) {
				out.println("YES");
				continue;
			}
			int v3=count(a,y)+count(b,x)+1;
			if(v3<=k&&v3%2==k%2) {
				out.println("YES");
				continue;
			}
			out.println("NO");
		}
	}





	private int count(int node1, int node2) {
		int dep=Math.min(dis[node1], dis[node2]);
		int ret=0;
		for(int i=29;i>=0;i--) {
			if(dis[node1]-(1<<i)>=dep) {
				ret+=1<<i;
				node1=A[node1][i];
			}
			if(dis[node2]-(1<<i)>=dep) {
				ret+=1<<i;
				node2=A[node2][i];
			}
		}
		if(node1==node2)return ret;
		for(int i=29;i>=0;i--) {
			if(A[node1][i]!=A[node2][i]) {
				ret+=1<<i+1;
				node1=A[node1][i];
				node2=A[node2][i];
			}
		}
		ret+=2;
		return ret;
	}



//https://codeforces.com/contest/1304/problem/E

	private void build(int node, boolean[] vis,int pre,int dep) {
		vis[node]=true;
		dis[node]=dep;
		int cur=pre;
		A[node][0]=cur;
		for(int i=1;i<30;i++) {
			A[node][i]=A[cur][i-1];
			cur=A[node][i];
		}
		for(int nn:graph[node]) {
			if(!vis[nn])build(nn,vis,node,dep+1);
		}
	}





	//input
	private ArrayList<Integer>[] ng(int n, int m) {
		ArrayList<Integer>[] graph=(ArrayList<Integer>[])new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=1;i<=m;i++) {
			int s=in.nextInt()-1,e=in.nextInt()-1;
			graph[s].add(e);
			graph[e].add(s);
		}
		return graph;
	}

	private ArrayList<long[]>[] ngw(int n, int m) {
		ArrayList<long[]>[] graph=(ArrayList<long[]>[])new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=1;i<=m;i++) {
			long s=in.nextLong()-1,e=in.nextLong()-1,w=in.nextLong();
			graph[(int)s].add(new long[] {e,w,i});
			graph[(int)e].add(new long[] {s,w});
		}
		return graph;
	}

	private int ni() {
		return in.nextInt();
	}

	private long nl() {
		return in.nextLong();
	}
	
	private String ns() {
		return in.next();
	}

	private long[] na(int n) {
		long[] A=new long[n];
		for(int i=0;i<n;i++) {
			A[i]=in.nextLong();
		}
		return A;
	}
	private int[] nia(int n) {
		int[] A=new int[n];
		for(int i=0;i<n;i++) {
			A[i]=in.nextInt();
		}
		return A;
	}
}	

class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}


	public String next() 
	{
		while(st==null || !st.hasMoreElements())//回车，空行情况
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}
