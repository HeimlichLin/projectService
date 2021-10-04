package com.heimlich.domain.common.codes.briefcode.impl;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;

public class BriefCodeComponentFactory {
	private static BriefCodeComponent briefCodeComponent;

	public static synchronized BriefCodeComponent get() {
		if (BriefCodeComponentFactory.briefCodeComponent == null) {
			BriefCodeComponentFactory.briefCodeComponent = new BriefCodeComponentImpl();
		}
		return BriefCodeComponentFactory.briefCodeComponent;
	}

}
