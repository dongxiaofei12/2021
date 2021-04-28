#include<iostream>
#include<fstream>
#include<stdlib.h>
using namespace std;
int max(int *p,int n)
{
	int m[n+1][n+1];
      int max=0;
	for(int i=1;i<=n;i++)
	{
		m[i][i]=0;
	}
	for(int r=2;r<=n;r++)
	{
		for(int i=1;i<=n-r+1;i++)
		{
			int j=i+r-1;
			int sum=0;
			for(int b=i;b<=j;b++)
            sum+=p[b];
            m[i][j]=m[i+1][j]+sum;
            //cout<<"m["<<i<<"]["<<j<<"]: "<<m[i][j]<<endl;
            for(int k=i+1;k<j;k++)
            {
               int t=m[i][k]+m[k+1][j]+sum;
               if(t>m[i][j])
               m[i][j]=t;
            }
		}
		
	}
	max=m[1][n];
 return max;
}
int min(int *p,int n)
{
	int m[n+1][n+1];
      int min=0;
	for(int i=1;i<=n;i++)
	{
		m[i][i]=0;
	}
	for(int r=2;r<=n;r++)
	{
		for(int i=1;i<=n-r+1;i++)
		{
			int j=i+r-1;
			int sum=0;
			for(int b=i;b<=j;b++)
            sum+=p[b];
            m[i][j]=m[i+1][j]+sum;
            //cout<<"m["<<i<<"]["<<j<<"]: "<<m[i][j]<<endl;
            for(int k=i+1;k<j;k++)
            {
               int t=m[i][k]+m[k+1][j]+sum;
               if(t<m[i][j])
               m[i][j]=t;
            }
		}
		
	}
	min=m[1][n];
 return min;
}

int main()
{
	ofstream outfile;
    outfile.open("output.txt");
	int n;
	cin>>n;
	int* p = new int[n+1];
	for(int i=1;i<=n;i++)
	{
		cin>>p[i];
	}
	cout<<"��С"<<min(p,n)<<endl;
	cout<<"���"<<max(p,n);
	outfile<<min(p,n)<<endl;
	outfile<<max(p,n);
	outfile.close();
}
