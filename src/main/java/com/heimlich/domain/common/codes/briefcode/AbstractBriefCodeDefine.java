package com.heimlich.domain.common.codes.briefcode;


public abstract class AbstractBriefCodeDefine implements BriefCodeDefine {
	
	protected String getLastKey(final String fullCode) {
		if (fullCode == null || fullCode.matches(" +")) {
			return "";
		}
		final int lastIndexOf = fullCode.lastIndexOf(BriefCodeDefine.SEPARATOR);
		if (lastIndexOf < 0) {
			return fullCode;
		}
		if (lastIndexOf == fullCode.length() - 1) {
			return "";
		}
		return fullCode.substring(lastIndexOf + 1);
	};

	protected String joinKeys(final String... keys) {
		if (keys == null) {
			return null;
		}
		final int startIndex = 0;
		final int endIndex = keys.length;
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return "";
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(BriefCodeDefine.SEPARATOR);
			}
			if (keys[i] != null) {
				buf.append(keys[i]);
			}
		}
		return buf.toString();
	}

}
