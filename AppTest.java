package n2e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.hamcrest.Description; 
import org.hamcrest.Matcher; 
import org.hamcrest.TypeSafeMatcher;

class AppTest extends TypeSafeMatcher {

	@Override 
	  public int matchesSafely(String text) { 
	    return text.length(); 
	  }

	  public void describeTo(Description description) { 
	    description.appendText("Incorrect length of text"); 
	  }

	  public static Matcher notANumber() { 
	    return new AppTest(); 
	  }

	  public static Matcher<String> length(Matcher<? super Integer> matcher) {
		    return new FeatureMatcher<String, Integer>(matcher,
		            "a String of length that", "length") {
		        @Override
		        protected Integer featureValueOf(String actual) {
		            return actual.length();
		        }
		    };
		}
	  
	  @Test
	  public void fellowShipOfTheRingShouldContainer7() {
	      assertThat("Gandalf", length(is(8)));
	  }
}



/*Defines a custom Matcher for Hamcrest that provides the length Matcher for a String.

We want to use the ->FeatureMatcher class.

With FeatureMatcher we can adjust an existing Matcher, decide which field of the Test 
Object to match, and provide a nice error message. The FeatureMatcher constructor has 
the following arguments in this order:

    The matcher we want to wrap up.
    A description of the feature we're testing.
    A description of the possible mismatch.

The only method we need to override is featureValueOf(currentT), which returns the 
value that will be passed to the match() / matchesSafely() method. Use your custom 
comparator in a test to check if the string "Mordor" has a length of 8.

Adjust the test if necessary.
 * 
 * 
 * 
 */
