package com.heimlich.domain.common.codes.briefcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.heimlich.domain.common.codes.briefcode.impl.BriefCodeComponentFactory;

public enum BriefCodesCache {
	Instance;
	//
	private final CacheLoader<BriefCodeFilter, List<? extends BriefCodeDefine>> filterResultLoader = new CacheLoader<BriefCodeFilter, List<? extends BriefCodeDefine>>() {

		@Override
		public List<? extends BriefCodeDefine> load(final BriefCodeFilter filter)
				throws Exception {
			return BriefCodesCache.this.loadKeys(filter);
		}
	};

	private final LoadingCache<BriefCodeFilter, List<? extends BriefCodeDefine>> filterResultCache //
	= CacheBuilder.newBuilder() //
			.maximumSize(300) // maximum cache size
			.expireAfterAccess(10, TimeUnit.MINUTES)//
			.build(this.filterResultLoader);

	public BriefCodeComponent getBridfCodeComponent() {
		return BriefCodeComponentFactory.get();
	}

	private List<? extends BriefCodeDefine> loadKeys(
			final BriefCodeFilter filter) {
		final BriefCodeComponent briefCodeComponent = this
				.getBridfCodeComponent();
		final List<? extends BriefCodeDefine> codes = briefCodeComponent
				.getCodes(filter.getCategory());
		final List<? extends BriefCodeDefine> list = filter
				.prepare(new LinkedList<BriefCodeDefine>(codes));
		if (list == null) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(list);
		}
	}

	public <F extends BriefCodeFilter> List<? extends BriefCodeDefine> getCodeTable(
			final F fileter) {
		try {
			return this.filterResultCache.get(fileter);
		} catch (final Exception e) {
			return Collections.emptyList();
		}
	}

}
