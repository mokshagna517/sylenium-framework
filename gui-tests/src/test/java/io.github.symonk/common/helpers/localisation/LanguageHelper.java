package io.github.symonk.common.helpers.localisation;


import io.github.symonk.common.enumerations.SupportedLanguage;
import io.github.symonk.configurations.properties.ManagesFrameworkProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.ResourceBundle;

@Slf4j
public class LanguageHelper implements ProvidesLanguageValues {

    private final SupportedLanguage language;
    private final static String DEFAULT_DIRECTORY = "localisation.";

    public LanguageHelper(final ManagesFrameworkProperties properties) {
        language = properties.getLanguage();
    }

    @Override
    public String getResource(final String key) {
        return ResourceBundle.getBundle(DEFAULT_DIRECTORY + language.getResourceFile(), language.getLocale()).getString(key);
    }
}
