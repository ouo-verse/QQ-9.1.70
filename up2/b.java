package up2;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.recent.service.IChannelRecentUserApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.model.PublicAccountInfoForSearch;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends k {
    public final PublicAccountInfoForSearch X;
    private String Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f439755a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f439756b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f439757c0;

    public b(AppInterface appInterface, PublicAccountInfoForSearch publicAccountInfoForSearch, int i3) {
        super(appInterface, i3, 0L);
        this.f439757c0 = i3;
        this.X = publicAccountInfoForSearch;
        if (((IChannelRecentUserApi) QRoute.api(IChannelRecentUserApi.class)).getRecentUserProxy(appInterface).isUinInRecent(publicAccountInfoForSearch.getUinString())) {
            this.f439755a0 = j.W;
        } else {
            this.f439755a0 = j.X;
        }
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X.getUinString();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.X.getName();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        boolean z16;
        this.Y = str;
        this.Z = Long.MIN_VALUE;
        long j06 = SearchUtils.j0(str, this.X.getName(), 1073741824L);
        if (j06 != Long.MIN_VALUE) {
            j06 = ((j06 & 13194139533312L) >> 20) | ((-13523993021644801L) & j06) | ((13510798882111488L & j06) >> 26);
        }
        if (j06 > this.Z) {
            this.Z = j06;
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = this.Z;
        if (j3 != Long.MIN_VALUE) {
            if (this.f439755a0 == j.W) {
                this.Z = 1048576 | j3;
            } else {
                this.Z = 524288 | j3;
            }
            if (!this.X.getIsOffLine()) {
                this.Z |= 2199023255552L;
                if (this.X.getClickCount() >= 3) {
                    if (this.X.getClickCount() < 128) {
                        this.Z |= (this.X.getClickCount() & 127) << 32;
                    } else {
                        this.Z |= 545460846592L;
                    }
                }
            }
            if (z16) {
                this.Z |= 4398046511104L;
            }
            if (this.X.getCertifiedGrade() == 1) {
                this.Z |= 2147483648L;
            }
        }
        return this.Z;
    }

    public PublicAccountInfoForSearch R() {
        return this.X;
    }

    public void S(int i3) {
        this.f439756b0 = i3;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.getUinString();
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        SpannableString a16 = new e(new ArrayList(), getKeyword()).a(SearchUtils.i0(this.X.getSummary()));
        if (a16 == null) {
            return "";
        }
        return a16;
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
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onActionPublicAccountSearchResultModel(this.G, view, context, this.X, this.f439756b0, this.Y, this.f439757c0);
    }
}
