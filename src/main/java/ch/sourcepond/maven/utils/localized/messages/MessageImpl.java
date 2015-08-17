/*Copyright (C) 2015 Roland Hauser, <sourcepond@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package ch.sourcepond.maven.utils.localized.messages;

import static java.text.MessageFormat.format;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Default implementation {@link Messages}.
 *
 */
final class MessageImpl implements Messages {
	private final ResourceBundle bundle;

	/**
	 * Creates a new instance of this class.
	 */
	MessageImpl(final ResourceBundle pBundle) {
		bundle = pBundle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.sourcepond.maven.plugin.jenkins.message.Messages#getMessage(java.lang
	 * .String, java.lang.Object[])
	 */
	@Override
	public String getMessage(final String pKey, final Object... pArguments) {
		try {
			final String value = bundle.getString(pKey);
			return format(value, pArguments);
		} catch (final MissingResourceException e) {
			return pKey;
		}
	}
}
