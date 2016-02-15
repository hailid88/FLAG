package com.IXL;

public class StateUtils {

	  //
	  // Generates an HTML select list that can be used to select a specific
	  // U.S. state.
	  //
	  public static String createStateSelectList()
	  {
	    return
	      "<select name=\"state\">\n"
	    + "<option value=\"Alabama\">Alabama</option>\n"
	    + "<option value=\"Alaska\">Alaska</option>\n"
	    + "<option value=\"Arizona\">Arizona</option>\n"
	    + "<option value=\"Arkansas\">Arkansas</option>\n"
	    + "<option value=\"California\">California</option>\n"
	    // more states here
	    + "</select>\n"
	    ;
	  }

	  //
	  // Parses the state from an HTML form submission, converting it to
	  // the two-letter abbreviation.
	  //
	  public static String parseSelectedState(String s)
	  {
	    if (s.equals("Alabama"))     { return "AL"; }
	    if (s.equals("Alaska"))      { return "AK"; }
	    if (s.equals("Arizona"))     { return "AZ"; }
	    if (s.equals("Arkansas"))    { return "AR"; }
	    if (s.equals("California"))  { return "CA"; }
	    else{ return "Others"; }
	    // more states here
	  }

	  //
	  // Displays the full name of the state specified by the two-letter code.
	  //
	  public static String displayStateFullName(String abbr) 
	  {
	    if (abbr.equals("AL")) { return "Alabama";    }
	    if (abbr.equals("AK")) { return "Alaska";     }
	    if (abbr.equals("AZ")) { return "Arizona";    }
	    if (abbr.equals("AR")) { return "Arkansas";   }
	    if (abbr.equals("CA")) { return "California"; }
	    else{ return "Others"; }
	    // more states here
	  }
}
