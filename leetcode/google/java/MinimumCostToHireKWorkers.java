package google.java;

public class MinimumCostToHireKWorkers {

    /*
    * Solution -
    * Lets say quality are [a,b,c,d] and wages are [p,q,r,s]
    * Then effective quality w.r.t to a is [1, b/a, c/a, d,a]
    * Then effective payment w.r.t to a is [p, b/a * p, c/a * p, d/a * p]
    *
    * Let's say we have k people to find the minimum base wage of that group
    * q <= (b/a) * p or a/p <= b/q or q/b <= p/a
    * Either take the element with least quality/wage ratio Or take the highest wage/quality element
    * */
}
