using System;

class Program
{
    static void Main()
    {
        var inputs = Console.ReadLine().Split();
        int x = int.Parse(inputs[0]);
        int y = int.Parse(inputs[1]);
        int d = int.Parse(inputs[2]);
        int t = int.Parse(inputs[3]);
        var dist = Math.Sqrt(x * x + y * y);
        var jump = (int)(dist / d);
        var remain = dist - jump * d;
        var ans = Math.Min(dist, remain + jump * t);
        ans = Math.Min(ans, (jump + 1) * d - dist + (jump + 1) * t);
        if (jump > 0)
        {
            ans = Math.Min(ans, (jump + 1) * t);
        }
        else
        {
            if (dist < d) ans = Math.Min(ans, t * 2.0);
        }

        Console.WriteLine($"{ans:F9}");
    }
}