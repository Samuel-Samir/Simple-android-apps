package com.example.samuel.plusorminus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity
{
    int numOfCufee = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public  void increment (View view)
    {
        numOfCufee++;
        display(numOfCufee);
    }
    public  void decrement (View view)
    {
        if ( numOfCufee == 0 )
        {
           /* AlertDialog.Builder myalart = new AlertDialog.Builder(this) ;
            myalart.setMessage("No Nigative ").create() ;
            myalart .show() ;*/
            Toast.makeText(MainActivity.this, "You Can't Order less than  Zero ", Toast.LENGTH_SHORT).show();


        }
        else
        {
            numOfCufee--;
            display(numOfCufee);
        }
    }

    public void submitOrder(View view)

    {
        EditText Name = (EditText) findViewById(R.id.NameText);
        String name =  Name.getText().toString() ;

        CheckBox box  = (CheckBox) findViewById(R.id.checkboxS) ;
        boolean chreama  =  box.isChecked() ;
        CheckBox chockletBox = (CheckBox) findViewById(R.id.choochlet) ;
        boolean chochlet  =  chockletBox.isChecked() ;
        String Massage  = createOrderSummary((5*numOfCufee) , chreama , chochlet , name) ;


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just  Java Order to " + name);
        intent.putExtra(Intent.EXTRA_TEXT, Massage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */


    private  String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate ,String name)
    {
        if (addWhippedCream==true) price+= (numOfCufee) ;
        if (addChocolate == true ) price+=(2*numOfCufee) ;
        String priceMessage = "Name: "+name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + numOfCufee;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

}
