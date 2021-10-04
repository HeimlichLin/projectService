package com.heimlich.domain.common.codes.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;
import com.heimlich.domain.common.codes.briefcode.BriefCodeFilter;

public abstract class CodesFilter implements BriefCodeFilter {
	protected final String category;
    protected Set<String> includedKeys;
    protected Set<String> excludedKeys;
    
    public static Set<String> toSet(final String keys) {
        final String[] split = StringUtils.split(StringUtils.defaultString(keys), " ,");
        final List<String> asList = Arrays.asList(split);
        return Collections.unmodifiableSet(new HashSet<String>(asList));
    }
    
    public CodesFilter(final String category, final Set<String> includedKeys, final Set<String> excludedKeys) {
        super();
        this.category = category;
        this.includedKeys = includedKeys;
        this.excludedKeys = excludedKeys;
    }
    
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public void setExcludedKeys(final Set<String> excludedKeys) {
        this.excludedKeys = excludedKeys;
    }

    @Override
    public void setIncludedKeys(final Set<String> includedKeys) {
        this.includedKeys = includedKeys;
    }
    
    protected <T extends BriefCodeDefine> void filterIncludeExclude(final List<T> sources) {
        if (!this.includedKeys.isEmpty()) {            // Process Include
            for (final Iterator<T> iterator = sources.iterator(); iterator.hasNext();) {
                final T item = iterator.next();
                final String lastKey = item.toLastKey();
                if (!this.includedKeys.contains(lastKey)) {
                    iterator.remove();
                }
            }
        }
        if (!this.excludedKeys.isEmpty()) {            // Process ExcludedKeys
            for (final Iterator<T> iterator = sources.iterator(); iterator.hasNext();) {
                final T item = iterator.next();
                final String lastKey = item.toLastKey();
                if (this.excludedKeys.contains(lastKey)) {
                    iterator.remove();
                }
            }
        }
    }

}
