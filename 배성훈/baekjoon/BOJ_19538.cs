using System.Text;

public class Program
{
    static int[] Times;
    static bool[] Check;
    static int[] Count;
    static int N;
    static List<int>[] Adj;

    public static void Main(string[] args)
    {
        N = int.Parse(Console.ReadLine());
        Adj = new List<int>[N + 1];
        Times = new int[N + 1];
        Check = new bool[N + 1];
        Count = new int[N + 1];
        Array.Fill(Times, -1);

        for (var i = 1; i <= N; i++)
        {
            Adj[i] = new List<int>();
        }

        for (var i = 1; i <= N; i++)
        {
            var s = Console.ReadLine().Split();
            for (int j = 0; j < s.Length - 1; j++)
            {
                Adj[i].Add(int.Parse(s[j]));
            }
        }

        var m = int.Parse(Console.ReadLine());
        var initial = Console.ReadLine().Split();
        var q = new Queue<int>();
        for (var i = 0; i < m; i++)
        {
            var num = int.Parse(initial[i]);
            Times[num] = 0;
            Check[num] = true;
            q.Enqueue(num);
        }

        while (q.Count != 0)
        {
            var cur = q.Dequeue();

            foreach(var next in Adj[cur])
            {
                if (Check[next]) continue;

                if (++Count[next] < (Adj[next].Count + 1) / 2) continue;

                Check[next] = true;
                Times[next] = Times[cur] + 1;
                q.Enqueue(next);
            }
        }

        var sb = new StringBuilder();
        for (var i = 1; i <= N; i++)
        {
            sb.Append(Times[i]).Append(' ');
        }
        Console.WriteLine(sb.ToString());
    }
}