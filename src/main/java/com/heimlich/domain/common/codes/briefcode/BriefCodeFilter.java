package com.heimlich.domain.common.codes.briefcode;

import java.util.List;
import java.util.Set;

public interface BriefCodeFilter {
	
	String getCategory();

	<T extends BriefCodeDefine> List<T> prepare(List<T> sources);

	void setIncludedKeys(final Set<String> includedKeys);

	void setExcludedKeys(final Set<String> excludedKeys);

}
