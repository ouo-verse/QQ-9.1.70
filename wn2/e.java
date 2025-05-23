package wn2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends com.tencent.mobileqq.search.model.k {
    private final gd1.a X;
    private final String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private ChnToSpell.b f445881a0;

    /* renamed from: b0, reason: collision with root package name */
    private ChnToSpell.b f445882b0;

    public e(AppInterface appInterface, int i3, long j3, String str, gd1.a aVar) {
        super(appInterface, i3, j3);
        ChnToSpell.c f16;
        this.Y = str;
        this.X = aVar;
        if (!TextUtils.isEmpty(aVar.f401941e) && (f16 = ChnToSpell.f(aVar.f401941e)) != null) {
            this.f445881a0 = f16.b();
            this.f445882b0 = f16.a();
        }
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.X.f401941e;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 10007;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.Z = str;
        return SearchUtils.m0(str, this.X.f401941e, this.f445881a0, this.f445882b0, Long.MIN_VALUE);
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 119;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return HardCodeUtil.qqStr(R.string.f212125mo) + this.X.f401947k;
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
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.G, view.getContext(), this.Y, 6);
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.Z);
        SearchUtils.f1(this.G, this.X.f401941e, this.Y, "", 10007);
    }
}
