/**
 * problem_20
 */

// // n! means n × (n − 1) × ... × 3 × 2 × 1

// // For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
// // and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

// // Find the sum of the digits in the number 100!

// vector<int> factorial(int n){
//     if (n == 0)
//     {
//         return 1;
//     }
//     else {
//         return n * factorial(n - 1);
//     }
    
// }
public class problem_20 {

    public static void main(String[] args) {
        factorial(100);
    }

    // This function finds factorial of
    // large numbers and prints them
    public static void factorial(int n)
    {
        int res[] = new int[500];
 
        // Initialize result
        res[0] = 1;
        int res_size = 1;
 
        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);
 

        int sum = 0;
        System.out.println("Sum of digits of Factorial of " + n + " is ");
        for (int i = res_size - 1; i >= 0; i--){
            System.out.print(res[i]);
            sum += res[i];
        }
        System.out.println("\nSum = " + sum);
            
    }
     
    // This function multiplies x with the number
    // represented by res[]. res_size is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of res_size
    // and returns the new value of res_size
    public static int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry
 
        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
                                // 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }
 
        // Put carry in res and increase result size
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}