package com.heimlich.domain.common.codes.briefcode;

public interface BriefCodeDefine {
	
	char SEPARATOR = ':';
	
	String toLastKey();
	
	String toCode();
	
	String toText();

}
