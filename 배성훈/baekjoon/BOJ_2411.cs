class Program
{
    private static int _n, _m;
    private static List<int> _cnts;
    private static int[,] _arr;

    static void Main()
    {
        _cnts = new List<int>();

        var input = Console.ReadLine().Split();
        _n = int.Parse(input[0]);
        _m = int.Parse(input[1]);
        var a = int.Parse(input[2]);
        var b = int.Parse(input[3]);

        _arr = new int[_n + 1, _m + 1];
        var items = new List<(int y, int x)>();

        for (var i = 0; i < a; i++)
        {
            var s = Console.ReadLine().Split();
            var y = int.Parse(s[0]);
            var x = int.Parse(s[1]);
            _arr[y, x] = 2;
            items.Add((y, x));
        }

        for (var i = 0; i < b; i++)
        {
            var s = Console.ReadLine().Split();
            var y = int.Parse(s[0]);
            var x = int.Parse(s[1]);
            _arr[y, x] = 1;
        }

        items.Sort((a, b) =>
        {
            if (a.y == b.y) return a.x.CompareTo(b.x);
            return a.y.CompareTo(b.y);
        });

        int ans = 1;
        int sy = 1, sx = 1;

        foreach (var item in items)
        {
            ans *= Dp(sy, sx, item.y, item.x);
            sy = item.y;
            sx = item.x;
        }

        ans *= Dp(sy, sx, _n, _m);

        Console.WriteLine(ans);
    }

    private static int Dp(int sy, int sx, int ey, int ex)
    {
        var dp = new int[_n + 1, _m + 1];
        dp[sy, sx] = 1;

        for (int y = sy; y <= ey; y++)
        {
            for (int x = sx; x <= ex; x++)
            {
                if (_arr[y, x] == 1 || (y == sy && x == sx)) continue;
                if (y > sy) dp[y, x] += dp[y - 1, x];
                if (x > sx) dp[y, x] += dp[y, x - 1];
            }
        }

        return dp[ey, ex];
    }
}