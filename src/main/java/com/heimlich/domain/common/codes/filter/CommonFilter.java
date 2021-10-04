package com.heimlich.domain.common.codes.filter;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public class CommonFilter extends CodesFilter {
	private final String base;

    public CommonFilter(final String category, final String base, final String includedKeys, final String excludedKeys) {
        super(category, toSet(includedKeys), toSet(excludedKeys));
        this.base = base;
    }

    @Override
    public <T extends BriefCodeDefine> List<T> prepare(final List<T> sources) {

        if (StringUtils.isNotBlank(this.base)) {
            for (final Iterator<T> iterator = sources.iterator(); iterator.hasNext();) {
                final T item = iterator.next();
                final String code = item.toCode();
                if (!StringUtils.startsWith(code, this.base)) {
                    iterator.remove();
                }
            }
        }
        super.filterIncludeExclude(sources);
        return sources;
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder b = new HashCodeBuilder();
        b.append(this.category);
        b.append(this.base);
        b.append(this.includedKeys);
        b.append(this.excludedKeys);
        return b.toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommonFilter) {
            final CommonFilter obj2 = (CommonFilter) obj;
            final EqualsBuilder b = new EqualsBuilder();
            b.append(this.category, obj2.category);
            b.append(this.base, obj2.base);
            b.append(this.includedKeys, obj2.includedKeys);
            b.append(this.excludedKeys, obj2.excludedKeys);
            return b.isEquals();
        } else {
            return false;
        }
    }
	

}
