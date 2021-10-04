package com.heimlich.domain.project.component;

import com.heimlich.domain.project.define.Contract;

public class AppSupportContext {
	private static TextSupport INSTANCE = new TextSupport() {

		@Override
		public String getText(String key) {
			return Contract.getTextFormCodes(key);
		}
	};

	public static void inject(TextSupport textSupport) {
		INSTANCE = textSupport;
	}

	public static TextSupport getTextSupport() {
		return INSTANCE;
	}

}
