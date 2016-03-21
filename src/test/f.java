package test;
public class f{
private void reverse(char[] src,int start,int end){

    while (start<end){

        char temp = src[start];

        src[start] = src[end];

        src[end] = temp;

        start++;

        end--;

    }

}
/*public static void main(String[] args){
    private void reverseWord(char[] centense) {

        int i = 0;

        int start = 0;

        while (i<centense.length){

            if(centense[i]!=' '){

                      i++;

            }

            else{

                reverse(centense,start,i);

                start = i+1;

            }

        }
    }

    }



 
public void should_reverse_string(){

    char[] centense = {'i',' ','l','o','v','e',' ','y','o','u'};

    reverse(centense,0,centense.length-1);

    reverseWord(centense);

    System.out.print(centense);

}*/
}