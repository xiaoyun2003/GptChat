import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        GptChat g=new GptChat();
        User_Gpt_Chat u=new User_Gpt_Chat();

        //登陆之后在控制台查看
        u.token="Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1UaEVOVUpHTkVNMVFURTRNMEZCTWpkQ05UZzVNRFUxUlRVd1FVSkRNRU13UmtGRVFrRXpSZyJ9.eyJodHRwczovL2FwaS5vcGVuYWkuY29tL3Byb2ZpbGUiOnsiZW1haWwiOiJpcGljNzAxQHZhcm5ldC5hc2lhIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImdlb2lwX2NvdW50cnkiOiJVUyJ9LCJodHRwczovL2FwaS5vcGVuYWkuY29tL2F1dGgiOnsidXNlcl9pZCI6InVzZXItb3c5eUZ3TU94ZkJmempqbkZtV2I3c1RHIn0sImlzcyI6Imh0dHBzOi8vYXV0aDAub3BlbmFpLmNvbS8iLCJzdWIiOiJhdXRoMHw2MzhkZTQ1MmFiZjA5Mzg2ZDc4Y2RmNTciLCJhdWQiOlsiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS92MSIsImh0dHBzOi8vb3BlbmFpLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE2NzA1MDQ4NjcsImV4cCI6MTY3MDU5MTI2NywiYXpwIjoiVGRKSWNiZTE2V29USHROOTVueXl3aDVFNHlPbzZJdEciLCJzY29wZSI6Im9wZW5pZCBlbWFpbCBwcm9maWxlIG1vZGVsLnJlYWQgbW9kZWwucmVxdWVzdCBvcmdhbml6YXRpb24ucmVhZCBvZmZsaW5lX2FjY2VzcyJ9.zLjzqwv3KijlEvagxNy0_kGGmXkvTCJQOeFPIVNs9-veSbOPmVRtwz7b5flN8YDZnPdC9uiqESDGSNsPPL-m5uQrcm7NMCQUVdqmpXWWoj23on7GjpfNqz2ZRVepoAyFnGlJP5HqVVerGd4djUuy2Lxw5904G5sXY50y7qDo86S_Hi3EmrmkselRtQAPrQn4SKXk37c3F_bAAtPSRY5yrhZXCPvSszrYCO5XDTXyUwoMt-FWyrZ588Jo8AUjw0oW5X8Sji2amKFJVd5UeY1yO3Oe0-I13JlLG7aVfPYZlSWQqgwoylzo0iCkEFcGlUhjNx_a5nPcsWvRwYtH5cdLgw";
        u.cookies="_ga=GA1.2.1397573685.1670258123; mp_d7d7628de9d5e6160010b84db960a7ee_mixpanel={\"distinct_id\": \"184e325e9a931b-0e379983de8387-26021151-144000-184e325e9aadf9\",\"$device_id\": \"184e325e9a931b-0e379983de8387-26021151-144000-184e325e9aadf9\",\"$initial_referrer\": \"https://chat.openai.com/\",\"$initial_referring_domain\": \"chat.openai.com\"}; __Host-next-auth.csrf-token=bd7397d29aeaa325bfa4f2325cb8c7f07acfa51a97712e6254bbc22c338f5552|2b39ee4d258eca2432ccec26b980915f968ed8e2745cb44a09e7f5c6b6a47f09; __Secure-next-auth.callback-url=https://chat.openai.com; _gid=GA1.2.539557689.1670557202; intercom-session-dgkjq2bp=TXY0Z1lwK2V6Y0owWnByNzJ6aTFKdzJDMnFKcWN0VlhodWFTd2FEeDZ1TU9DUCtFVU1uQjRURFNCRHdpMlBGQy0tazYwV2dPTCtxeWFWSkR6WU9yNVFHdz09--df8677d5165710df0ec9db5b69aedbfb18793b98; intercom-device-id-dgkjq2bp=75ec2c2c-d7e1-4515-80d0-a3a1d2b6836e; __Secure-next-auth.session-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..bKH-5jwg8Cd_Ou_l.V3-vjzAE7k9Vcb19D6A6WGVZ-6PrPav8Ze7CRUkIcebtj6nwSXQxpHeN2VlpuLte_vha5j9W7BAIQpmMgL-_H3gJ31YivVSGwQz5w348m8aVOQa1vtK1b6xePWDMHhTeVFwWNGXytjtolyn08YfvM7hRUURsJeG8lBBs-a11_BuV3tM3BrVn35UViRU0PIkq41fxLcpaHnN8JPveOlAdh_aZwmNJ1XZS2dvdwo-CEJWkzgA2lB9d168qGb3ulx4fBgUan6AxpnqxELHSSf_Egec_8x7WDvbqJt422R0yf0fsGiGf1FFdgAXXM9tVY4Brs7zVql004gwWA6BltZkNcOxTZdrb2dAdSwdlTYvXf63DuAQHOTJkZRyEnHtAg-OsyYVhr9mEGcAlqw66WM_U4nsnU2B3v0dEGItH6u_xzQElFD7UtxpC_O01MEZ4evEHLGQ-Dpv83-ZMWWppzBLDT8jOpUMVT9qjIj7xHHl35VHZeejUYUy1QVVOjxKkHOXQ5g6YAb8DHCy0BzVo4ln2Uf62vc2pJNtcGNcjBUZqeffFmTqVDrFhIIyv91wYRRo1Q1-Ed-4DhA5qrJcKY62T0dYXryttQHPtbVvfWCcOSXGkXG8TMjDyvho9Bn9MjYoZtkSCUnknIXoEP9Ynvb-ePDch-tcGomU8y-G5toxec3_S0VnGzFl_1fdmp9FLFWFwT6acRnvWt_GUjexquLcJvWR-qkoYlx4D7NQo3h8RlphGGqBwKOjA7CPFRwGKBbrIcboCH_NwFFiEjVfpRcoJRAQxm03YCyyvkuW3ZuUULxMrGVgEUB-LxHMUxrfwm5DoFDb4yPfDoJ-XT1FMj02F0NbM3dlqFYfX0rckdPpNnA7YV6IkZ0h3yDl7Cy_idbUnYHaw9LtSyLJ2S8A9EthAW_mGp7pwh93wMhGhRRI3P82R1yKN_4JkDPOTVlXtHQPp_qn0Gwl9UvdWUzVwYR9XHuFMdnTHAFwoBy0xaoDNrlO7Z0jOUH5r3OOtqUxEx9dsOjfI4KPdY-AI9B9iCtc4NX4b92LYWyZhXl0iqiW3krFporosJvXbl3x2YrdktBrJ2_0nIcDeelR-FRL3ViUZzjB_y5yI1-VBTg3jOCa65LKVpzKwM_HiyFCJj2V7qFbk-_loshJrHDbf8iM6h4iEtpuVGHeAgHInFwLoSExJGpIZ7BdOl_3Y6_qysWpXfUwUWNPi6AQzAyfPLrTu78jVOXCncb7bZSN7NX_-UoZyB-zVYo-POBNuJ-5pMR6Luu9yFAbe9Lb-kOT2xOyZuXPBg9Q0Ht42-UtRSVpgMqDtm9BcvdMSqrSa4eZWXcvvPOXqhDGgzIuHXIHbDdz42EMkcc0EeUBbFc6lmMX05zVG166r8lnZiQTYeixEW2kL_7xIxnE6u3_hQu1KBoUGb45p1qxW4WY29yTKBiGaWM6fyEneLy4daoL4hwur8LdspLSHFul5ThCt2AzlS064A1SmI0654PQWu2E0XqtcJIQlCN67D4NndPmFetQqoXXqLe20dWAWUaFAj1wy1JYOH1-53VUjYP78vkDkwISDDxu_AD39Mp6w4waDBltQ9xp9fTJpQayLZhlFy_NbBel7SrctTZkomNH5dVKl1fY89AYzXJgXyuvBNzTNw41pQmtd1mE2xfhuyB7h-t-lqJKzzhtz9edU41dAH_86xkM1GZtk8lPfpLtFBGeouC1vSzflAptgbF6aHGPXwiq_tsahBNPbYFti2HgKXW9tb2pdDfZB-qrYUW5jBARH8ca9gKAXr50cC_cQTKR7o-D8aUDoxUNwd64eUu9atSGyrKxceZWvClhO2RgJY0S49_bXvP2jaWbU1E4UEfpBo4NMhgOhWm5gLu0fiQF7oOOdyAim0RAYsz0aIxJJxiPUIbXN6b6h3v4oOBTox-sJmFXggKKLrQ8pVEEhQFrNipXX61WPlrV3M_QES0m-6IfPHR8bF6tfnu0ccoAO3FhsIHP998KxLnzjyb1oTvpJWDIV3kKIY1UURzT0zsJNjQzyT84GkcgW_jkpiBv5WsVAnJMxG1VhAav7OyrZW08tf6vL7vi7ran3ENHsF7KLkGkHnik-9POWtu49s-AzxU2w1adIHOJc5S09mhljia4zdv75Hzi9fviCf4Kqn5Tarx7UY98YProxJD70CnHkvxcgqCpRnbaUfamUva5dYp2keViKYKCAmymNQEo6hwaQBiyavlGFG8uZZTEp1m0fNwgJFoNYGZxYcNxpKN9YXXX5aDs22zlttrI3Wjo2J8339yx1JgX5D0cSzJuBxOFAgNq0QS7Z7uNrTtJOprO6VMlF4sLB8bprm2uMKA.MIX9lxTtN0GTIIn9KTBV5A";

        //构建一个会话管理器，这里记录了当前会话id
        Gpt_Conversion cc=new Gpt_Conversion();
        //你可以为该机器人指定会话，以便机器人拥有记忆
        //cc.id="";
        //cc.conversion_id="";
        //cc.parent_id="";
        String res=g.chat(u,cc,"用c语言写一个计数器");
        System.out.println(res);

        String res1=g.chat(u,cc,"继续");


        System.out.println(res1);


        /*
下面是一个简单的程序，它使用C语言来实现一个计数器。它将从1开始递增，每次递增1，直到达到用户指定的最大值。

```
#include <stdio.h>

int main() {
  // 定义计数器变量并初始化为1
  int counter = 1;

  // 定义最大值并从用户输入中读取
  int max;
  printf("Enter the maximum value: ");
  scanf("%d", &max);

  // 循环递增计数器，直到达到最大值
  while (counter <= max) {
    printf("%d\n", counter);
    counter++;
  }

  return 0;
}
```

该程序的工作原理如下：

1. 首先，它定义了一个名为`counter`的变量，并将其初始化为1。
2. 然后，它定义了一个名为`max`的变量，并使用`scanf`函数从用户输入中读取最大值。
3. 接着，它使用一个`while`循环递增`counter`变量，直到它达到用户指定的最大值。每次递增时，它都会使用`printf`函数输出`counter`的当前值。

希望这可以帮助你。
         */

    }
}



