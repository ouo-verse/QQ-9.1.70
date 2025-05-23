package wn2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.m {
    private DiscussionMemberInfo X;
    private long Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445860a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445861b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f445862c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f445863d0;

    public b(AppInterface appInterface, int i3, DiscussionMemberInfo discussionMemberInfo) {
        super(appInterface, i3, 0L);
        this.X = discussionMemberInfo;
        C(6);
        D(discussionMemberInfo.memberUin);
    }

    private void T() {
        int i3 = this.Z;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f445861b0 = "";
                    return;
                }
                DiscussionMemberInfo discussionMemberInfo = this.X;
                this.f445861b0 = discussionMemberInfo.inteRemark;
                if (!TextUtils.isEmpty(discussionMemberInfo.memberName)) {
                    this.f445862c0 = this.X.memberName;
                    return;
                } else {
                    this.f445862c0 = this.X.memberUin;
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.X.inteRemark)) {
                DiscussionMemberInfo discussionMemberInfo2 = this.X;
                this.f445861b0 = discussionMemberInfo2.inteRemark;
                this.f445862c0 = discussionMemberInfo2.memberName;
                return;
            } else {
                DiscussionMemberInfo discussionMemberInfo3 = this.X;
                this.f445861b0 = discussionMemberInfo3.memberName;
                this.f445862c0 = discussionMemberInfo3.memberUin;
                return;
            }
        }
        if (!TextUtils.isEmpty(this.X.inteRemark)) {
            DiscussionMemberInfo discussionMemberInfo4 = this.X;
            this.f445861b0 = discussionMemberInfo4.inteRemark;
            this.f445862c0 = discussionMemberInfo4.memberUin;
        } else if (!TextUtils.isEmpty(this.X.memberName)) {
            DiscussionMemberInfo discussionMemberInfo5 = this.X;
            this.f445861b0 = discussionMemberInfo5.memberName;
            this.f445862c0 = discussionMemberInfo5.memberUin;
        } else {
            this.f445861b0 = this.X.memberUin;
            this.f445862c0 = null;
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        String str;
        int i3 = this.Z;
        if (i3 == 0) {
            str = "uin";
        } else if (i3 == 1) {
            str = "nickname";
        } else if (i3 == 2) {
            str = "remark";
        } else {
            str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        return am.a(this.f445860a0, this.J, str, this.Y, null, "DiscussionMember", 0L);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X.memberUin;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445862c0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445861b0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1004;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        DiscussionInfo discussionInfo = (DiscussionInfo) ((IDiscussionService) this.G.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.X.discussionUin);
        if (discussionInfo != null && !discussionInfo.isDiscussHrMeeting() && !discussionInfo.isHidden()) {
            this.f445863d0 = str;
            this.Y = Long.MIN_VALUE;
            long S = S(str, this.X.inteRemark, com.tencent.mobileqq.search.j.f283428p);
            if (S > this.Y) {
                this.Y = S;
                this.Z = 2;
                this.f445860a0 = this.X.inteRemark;
            }
            long S2 = S(str, this.X.memberName, com.tencent.mobileqq.search.j.f283429q);
            if (S2 > this.Y) {
                this.Y = S2;
                this.Z = 1;
                this.f445860a0 = this.X.memberName;
            }
            long k06 = SearchUtils.k0(str, this.X.memberUin, com.tencent.mobileqq.search.j.f283432t, false);
            if (k06 > this.Y) {
                this.Y = k06;
                this.Z = 0;
                this.f445860a0 = this.X.memberUin;
            }
            long j3 = this.Y;
            if (j3 != Long.MIN_VALUE) {
                this.Y = j3 + com.tencent.mobileqq.search.j.P;
                T();
            }
            return this.Y;
        }
        this.Y = Long.MIN_VALUE;
        return Long.MIN_VALUE;
    }

    public Pair<CharSequence, CharSequence> R() {
        int i3 = this.Z;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return new Pair<>(SearchUtils.u0(this.X.inteRemark, this.f445863d0, 6, true), null);
            }
            if (!TextUtils.isEmpty(this.X.inteRemark)) {
                DiscussionMemberInfo discussionMemberInfo = this.X;
                return new Pair<>(discussionMemberInfo.inteRemark, SearchUtils.s0(discussionMemberInfo.memberName, this.f445863d0, 6, true));
            }
            return new Pair<>(SearchUtils.u0(this.X.memberName, this.f445863d0, 6, true), null);
        }
        if (!TextUtils.isEmpty(this.X.inteRemark)) {
            DiscussionMemberInfo discussionMemberInfo2 = this.X;
            return new Pair<>(discussionMemberInfo2.inteRemark, SearchUtils.s0(discussionMemberInfo2.memberUin, this.f445863d0, 6, false));
        }
        if (!TextUtils.isEmpty(this.X.memberName)) {
            DiscussionMemberInfo discussionMemberInfo3 = this.X;
            return new Pair<>(discussionMemberInfo3.memberName, SearchUtils.s0(discussionMemberInfo3.memberUin, this.f445863d0, 6, false));
        }
        return new Pair<>(SearchUtils.u0(this.X.memberUin, this.f445863d0, 6, false), null);
    }

    public long S(String str, String str2, long j3) {
        if (this.N) {
            return SearchUtils.o0(str, str2, j3, true, false, false);
        }
        return SearchUtils.j0(str, str2, j3);
    }

    @Override // com.tencent.mobileqq.search.model.m
    public String d() {
        return this.X.discussionUin;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.memberUin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (SearchUtils.F0(this.I)) {
            return HardCodeUtil.qqStr(R.string.l3n);
        }
        return HardCodeUtil.qqStr(R.string.l2l);
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
        return this.f445863d0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            Context context = view.getContext();
            DiscussionMemberInfo discussionMemberInfo = this.X;
            iSearchPieceFetcher.enterTroopTmpChatWin(context, discussionMemberInfo.memberUin, discussionMemberInfo.discussionUin, 1004, discussionMemberInfo.memberName, false, null, null);
            SearchUtils.c1(this.f445863d0, 20, 1, view);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445863d0);
            AppInterface appInterface = this.G;
            String charSequence = getTitle().toString();
            DiscussionMemberInfo discussionMemberInfo2 = this.X;
            SearchUtils.f1(appInterface, charSequence, discussionMemberInfo2.memberUin, discussionMemberInfo2.discussionUin, 1004);
            SearchUtils.Z0(this.f445863d0, 20, view, false);
            SearchUtils.X0(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
            }
            if ((G() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445863d0, this.L, (String) G(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 1, 0, null, null);
                    return;
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
                    return;
                }
            }
            return;
        }
        SearchUtils.l1(view, this);
    }
}
