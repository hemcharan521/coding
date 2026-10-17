#include <stdio.h>
//note:in this program index start from 1 as we write i =1 and j =1 in for loop while taking input
int a[10][10],reach[10],n;//a is adjacency matrix that shows if there is edge between two particular verices,reach shows if we already visited it,n is no of vertices
void dfs(int v)
{
    int i;
    reach[v]=1;
    for(i = 1;i<=n;i++)//loop n times(vertices) 
    {
        if(a[v][i]&&!reach[i])//a[v][i] means if it has 0 means no edge so doesnt enter if it is 1 it enters(systems automatically evaluated 0 or 1)and !reach means if it has 1 it reached if 0 not reached yet we cant mention 0 directly so we use !
        {
            printf("\n%d->%d",v,i);//met above conditions so moving from v to i vertex as we are using depth first
            dfs(i);//recursion uses backtracking
        }
    }
}
int main()
{
    int i,j,count=0;
    printf("enter the numbber of vertices in the graph : ");
    scanf("%d",&n);//n is declared globally
    //intializing all the reach and the array for safety
    for(i=1;i<=n;i++)
    {
        reach[i]=0;//all reach to zero
        for(j=1;j<=n;j++)
        {
            a[i][j]=0;
        }
    }
    //taking the adjacency matrix as input
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }    
    dfs(1);//check note due that reason instead of 1st vertex whixh normally would be 0 we use 1 here instead
    //since reach is 1d array each vertex visited is stored in separate array
    for(i=1;i<=n;i++)

    {
        if(reach[i])
        {
            count++;//checking how many vertices reach visited
        }
    }
    if(count==n)//means reach visited every vertex while starting from 1st index
    
    {
        printf("\ngraph is connected\n");
    }
    else
    {
        printf("\n graph is not connected");
    }
        
    return 0;
}
