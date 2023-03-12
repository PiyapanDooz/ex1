package exam1;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import java.util.*;

public class CountryRandomizerGUI {
	  private Shell shell;
	  private Label countryLabel;

	  public static void main(String[] args) {
	    Display display = new Display();
	    CountryRandomizerGUI app = new CountryRandomizerGUI();
	    app.open(display);
	    display.dispose();
	  }

	  public void open(Display display) {
	    shell = new Shell(display);
	    shell.setText("Country Randomizer");

	    // Create a button to randomize and display a country
	    Button button = new Button(shell, SWT.PUSH);
	    button.setText("Randomize Country");
	    button.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        String[] countries = {"Australia", "Brazil", "Canada", "Denmark", "Egypt", "France", "Greece", "Honduras", "India", "Japan"};
	        Random rand = new Random();
	        int index = rand.nextInt(countries.length);
	        String country = countries[index];
	        countryLabel.setText(country);
	      }
	    });

	    // Create a label to display the selected country
	    countryLabel = new Label(shell, SWT.NONE);
	    countryLabel.setText("Click the button to randomize a country.");

	    // Set the layout of the shell
	    GridLayout layout = new GridLayout(2, false);
	    layout.marginWidth = layout.marginHeight = 10;
	    shell.setLayout(layout);

	    // Add the button and label to the shell
	    button.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
	    countryLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

	    // Pack the contents of the shell and open it
	    shell.pack();
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	  }
	}
