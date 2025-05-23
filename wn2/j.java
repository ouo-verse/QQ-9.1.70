package wn2;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class j extends g implements com.tencent.mobileqq.search.model.p {
    public j(AppInterface appInterface, int i3, String str, String str2, String str3, String str4, String str5) {
        super(appInterface, i3, str, str2, str3, str4, str5);
    }

    @Override // com.tencent.mobileqq.search.model.p
    public String getTroopUin() {
        return this.X;
    }

    @Override // wn2.g, com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (SearchUtils.F0(this.I)) {
            return HardCodeUtil.qqStr(R.string.l3l);
        }
        return HardCodeUtil.qqStr(R.string.l2p);
    }

    @Override // wn2.g, com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (!SearchUtils.F0(this.I)) {
            SearchUtils.l1(view, this);
        }
        if (SearchConfig.needSeparate) {
            SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
        }
    }
}
