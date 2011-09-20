package al.gov.asp.smc.e4.linkapp.osgiservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import outer.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {

	private List fDictionaries = new ArrayList();
	
    public void registerDictionary(Dictionary dictionary) {
    	fDictionaries.add(dictionary);
    }
    
    public void unregisterDictionary(Dictionary dictionary) {
    	fDictionaries.remove(dictionary);
    }

	public boolean check(String word) {
		for (int i = 0; i < fDictionaries.size(); i++ ) {
			Dictionary dictionary = (Dictionary) fDictionaries.get(i);
			if(dictionary.check(word))
				return true;
		}
		return false;
	}
	
    public String[] getLanguages() {
    	List languages = new ArrayList();
    	for (int i = 0; i < fDictionaries.size(); i++ ) {
			Dictionary dictionary = (Dictionary) fDictionaries.get(i);
			languages.add(dictionary.getLanguage());
		}
    	return (String[]) languages.toArray(new String[fDictionaries.size()]);
    }

	@Override
	public String getWelcomeMessage() {
		return "Welcome to OSGi hettttaven";
	}

	@Override
	public boolean isSaveAllowed() {
		
		return getWelcomeMessage().equals("Welcome to OSGi heaven");
	}

}
