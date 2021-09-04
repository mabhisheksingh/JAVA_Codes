package ShivamProblems.sortedArray;
//Not able to solve problem
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        /*int arr1[] = {10,20,30,40,50};
        int arr2[] = {5,15,25,35,45};*/
        int arr1[] = {10,20,30,40,50};
        int arr2[] = {5,6,11,35,45};
        double median = getMedian(arr1,arr2);
        System.out.println("Correct Media : "+median);
        median = findMedianOptimize(arr1,arr2);

        System.out.println("MYCode Media : "+median);
    }

    private static double findMedianOptimize(int[] arr1, int[] arr2) {
        int m1=0,m2=0;
        if ( arr1.length==1 && arr2.length==1 )        return (arr1[0]+arr2[0])/2.0;
        else if( arr1.length ==1 && arr2.length==0) return arr1[0];
        else if( arr1.length ==0 && arr2.length==1) return arr2[0];
        else{
            int left1 =0,right1=arr1.length-1,left2 = 0,right2 = arr2.length-1,mid1,mid2;
           if(arr1.length <= arr2.length){
               while (left1!=right1){
                   mid1 = (left1+right1)/2;
                   mid2 = (left2+right2)/2;
                   if(arr1[mid1] >= arr2[mid2]){
                       right1 = mid1;
                       left2= mid2;
                   }else {
                       left1 = mid1;
                       right2= mid2;
                   }

               }
           }else if(arr1.length > arr2.length){

           }

        }
        return (m1+m2)/2.0;
     }
    static double getMedian(int ar1[], int ar2[] ) {
        int n=ar1.length, m = ar2.length;
        // Current index of input array ar1[]
        int i = 0;

        // Current index of input array ar2[]
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        //index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1)
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                if (i != n && j != m)
                {
                    m1 = (ar1[i] > ar2[j]) ?
                            ar2[j++] : ar1[i++];
                }
                else if (i < n)
                {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else
                {
                    m1 = ar2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging
        // ar1 and ar2
        else
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                m2 = m1;
                if (i != n && j != m)
                {
                    m1 = (ar1[i] > ar2[j]) ?
                            ar2[j++] : ar1[i++];
                }
                else if (i < n)
                {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else
                {
                    m1 = ar2[j++];
                }
            }
            return (m1 + m2) / 2.0;
        }
    }

}
