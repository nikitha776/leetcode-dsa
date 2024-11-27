 class Solution {
     public static int partition(int a[],int low,int high)
     {
        int i=low-1;
        int pivot=a[high];
        int j;
        for(j=low;j<high;j++)
        {
            if(a[j]<pivot)
            {i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        int temp=a[i];
        a[i]=pivot;
        a[high]=temp;
        return i;
     }
      public static void quicksort(int a[],int low,int high)
      {
        if(low<high)
        {
            int loc=partition(a,low,high);
            quicksort(a,low,loc-1);
            quicksort(a,loc+1,high);
        }
      }
    public int removeDuplicates(int[] nums) {
        quicksort(nums,0,nums.length-1);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!list.contains(nums[i]))
            {
                list.add(nums[i]);
            }
        }

        int[] a=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            nums[i]=list.get(i);
        }
        return list.size();
    }
}