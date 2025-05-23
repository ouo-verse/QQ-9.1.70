package wn2;

import android.view.View;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends com.tencent.mobileqq.search.model.k {
    private IGProGuildInfo X;
    private String Y;
    private long Z;

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X.getGuildID();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 8;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.X.getShowNumber();
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.X.getGuildName();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 10014;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.Y = str;
        this.Z = Long.MIN_VALUE;
        long j06 = SearchUtils.j0(str, this.X.getGuildName(), com.tencent.mobileqq.search.j.f283422j);
        if (j06 > this.Z) {
            this.Z = j06;
        }
        long k06 = SearchUtils.k0(str, this.X.getShowNumber(), com.tencent.mobileqq.search.j.f283432t, false);
        if (k06 > this.Z) {
            this.Z = k06;
        }
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 117;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.getGuildID();
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildInTab(view.getContext(), this.X.getGuildID(), "", null);
        SearchUtils.V0("Sgrp", "search_result2", "clk", 0, 0, this.X.getGuildID());
    }
}
