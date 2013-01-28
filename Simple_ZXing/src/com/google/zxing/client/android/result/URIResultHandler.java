/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.client.android.result;

import java.util.Locale;

import android.app.Activity;
import android.util.Log;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.URIParsedResult;

/**
 * Offers appropriate actions for URLS.
 * 
 * @author dswitkin@google.com (Daniel Switkin)
 */
public final class URIResultHandler {
	private final ParsedResult result;
	private final Activity activity;

	// URIs beginning with entries in this array will not be saved to history or
	// copied to the
	// clipboard for security.
	private static final String[] SECURE_PROTOCOLS = { "otpauth:" };
	private static final String TAG = URIResultHandler.class.getSimpleName();

	public URIResultHandler(Activity activity, ParsedResult result) {
		this.result = result;
		this.activity = activity;
	}

	public boolean areContentsSecure() {
		if (getResult() instanceof URIParsedResult) {
			URIParsedResult uriResult = (URIParsedResult) getResult();
			String uri = uriResult.getURI().toLowerCase(Locale.ENGLISH);
			for (String secure : SECURE_PROTOCOLS) {
				if (uri.startsWith(secure)) {
					return true;
				}
			}
		}else
			Log.d(TAG, "不是URL类型,ParsedResult type="+getResult().getClass().getSimpleName());
		return false;
	}

	public ParsedResult getResult() {
		return result;
	}

	/**
	 * Create a possibly styled string for the contents of the current barcode.
	 * 
	 * @return The text to be displayed.
	 */
	public CharSequence getDisplayContents() {
		String contents = result.getDisplayResult();
		return contents.replace("\r", "");
	}

	/**
	 * A convenience method to get the parsed type. Should not be overridden.
	 * 
	 * @return The parsed type, e.g. URI or ISBN
	 */
	public final ParsedResultType getType() {
		return result.getType();
	}
}
