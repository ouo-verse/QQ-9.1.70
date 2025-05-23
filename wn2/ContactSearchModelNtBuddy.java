package wn2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.robot.api.IRobotIdentityApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b+\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010g\u001a\u00020\u000e\u0012\u0006\u0010h\u001a\u00020#\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001eH\u0016J\u0006\u0010 \u001a\u00020\tJ\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0004H\u0014J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00102\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010'\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b=\u0010)\"\u0004\b4\u0010+R(\u0010F\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010I\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER(\u0010L\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010A\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER(\u0010N\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010A\u001a\u0004\bM\u0010C\"\u0004\b8\u0010ER\"\u0010R\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010'\u001a\u0004\bP\u0010)\"\u0004\bQ\u0010+R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010'\u001a\u0004\bT\u0010)\"\u0004\b<\u0010+R\"\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010'\u001a\u0004\bV\u0010)\"\u0004\bS\u0010+R\"\u0010Y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010'\u001a\u0004\bX\u0010)\"\u0004\bU\u0010+R\u0016\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010'R\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010ZR\u0016\u0010\\\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ZR$\u0010b\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u00138V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010f\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010)\"\u0004\be\u0010+\u00a8\u0006k"}, d2 = {"Lwn2/k;", "Lcom/tencent/mobileqq/search/model/k;", "Lcom/tencent/mobileqq/search/model/s;", "Lcom/tencent/mobileqq/search/model/n;", "", "categoryName", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "", "Z", "Y", "W", "X", "", "k", "l", "T", ReportConstant.COSTREPORT_PREFIX, "", "r", "V", "M", "", "u", "L", "t", "K", tl.h.F, "H", "", "y", BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "keyword", "", "N", "v", "toString", "Ljava/lang/String;", "U", "()Ljava/lang/String;", "e0", "(Ljava/lang/String;)V", "fromGroupCode", "I", "getChatType", "()I", "d0", "(I)V", "chatType", "uin", "a0", "getNickname", "f0", "nickname", "b0", "getRemark", "k0", "remark", "c0", "getCardName", "cardName", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHitInfo;", "Ljava/util/List;", "getUinHits", "()Ljava/util/List;", "n0", "(Ljava/util/List;)V", "uinHits", "getNicknameHits", "g0", "nicknameHits", "getRemarkHits", "l0", "remarkHits", "getCardNameHits", "cardNameHits", "h0", "getTitle", "m0", "title", "i0", "getCategoryName", "j0", "getRankInfo", "rankInfo", "getRecallReason", "recallReason", "Ljava/lang/CharSequence;", "titleSpans", "subTitleSpans", "<anonymous parameter 0>", "c", "()Z", "setFromGroup", "(Z)V", "isFromGroup", "value", "getGroupCode", "setGroupCode", "groupCode", IProfileCardConst.KEY_FROM_TYPE, "recentIndex", "<init>", "(IJ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wn2.k, reason: from toString */
/* loaded from: classes18.dex */
public final class ContactSearchModelNtBuddy extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.s, com.tencent.mobileqq.search.model.n {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String fromGroupCode;

    /* renamed from: Y, reason: from kotlin metadata and from toString */
    private int chatType;

    /* renamed from: Z, reason: from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String uin;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nickname;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String remark;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cardName;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> uinHits;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> nicknameHits;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> remarkHits;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> cardNameHits;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String categoryName;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rankInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String recallReason;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String keyword;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence titleSpans;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence subTitleSpans;

    public ContactSearchModelNtBuddy(int i3, long j3) {
        super((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), i3, j3);
        List<SearchHitInfo> emptyList;
        List<SearchHitInfo> emptyList2;
        List<SearchHitInfo> emptyList3;
        List<SearchHitInfo> emptyList4;
        this.fromGroupCode = "";
        this.chatType = 1;
        this.uin = "";
        this.nickname = "";
        this.remark = "";
        this.cardName = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.uinHits = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.nicknameHits = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.remarkHits = emptyList3;
        emptyList4 = CollectionsKt__CollectionsKt.emptyList();
        this.cardNameHits = emptyList4;
        this.title = "";
        this.categoryName = "";
        this.rankInfo = "";
        this.recallReason = "";
        this.keyword = "";
        this.titleSpans = "";
        this.subTitleSpans = "";
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        this.G = (AppInterface) peekAppRuntime;
        C(6);
    }

    private final String S(String categoryName) {
        if (((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(getUin())) {
            return HardCodeUtil.qqStr(R.string.f171805l33) + HardCodeUtil.qqStr(R.string.f212145mq);
        }
        return HardCodeUtil.qqStr(R.string.f171805l33) + categoryName;
    }

    private final void W() {
        List listOf;
        List mutableList;
        boolean z16;
        boolean z17;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.remark, this.remarkHits), TuplesKt.to(this.nickname, this.nicknameHits), TuplesKt.to(this.uin, this.uinHits)});
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
        if (this.remark.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            mutableList.remove(0);
        } else if ((!this.remarkHits.isEmpty()) && Intrinsics.areEqual(this.remark, this.nickname)) {
            mutableList.remove(1);
        } else if ((!this.remarkHits.isEmpty()) || (!this.nicknameHits.isEmpty())) {
            CollectionsKt__MutableCollectionsKt.removeLast(mutableList);
        } else {
            mutableList.remove(1);
        }
        if (mutableList.size() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Pair pair = (Pair) mutableList.get(0);
            Pair pair2 = (Pair) mutableList.get(1);
            this.titleSpans = rn2.l.d(new SpannableStringBuilder(), (String) pair.getFirst(), (List) pair.getSecond(), this.keyword);
            this.subTitleSpans = rn2.l.b(new SpannableStringBuilder(), (String) pair2.getFirst(), (List) pair2.getSecond(), this.keyword);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void X() {
        if (!this.remarkHits.isEmpty()) {
            this.titleSpans = rn2.l.d(new SpannableStringBuilder(), this.remark, this.remarkHits, this.keyword);
            this.subTitleSpans = rn2.l.b(new SpannableStringBuilder(), this.nickname, this.nicknameHits, this.keyword);
        } else if (!this.cardNameHits.isEmpty()) {
            this.titleSpans = rn2.l.d(new SpannableStringBuilder(), this.cardName, this.cardNameHits, this.keyword);
            this.subTitleSpans = rn2.l.b(new SpannableStringBuilder(), this.nickname, this.nicknameHits, this.keyword);
        } else {
            W();
        }
    }

    private final void Y(View view) {
        Friends friend = ((IFriendDataService) this.G.getRuntimeService(IFriendDataService.class, "")).getFriend(this.uin, true);
        if (friend != null) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).setContactSearchRecentAndHistroy(view.getContext(), this.G, friend.uin, friend.getFriendNickWithAlias(), this.keyword, view);
        } else {
            Logger logger = Logger.f235387a;
            String TAG = com.tencent.mobileqq.search.model.k.W;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            Logger.b bVar = new Logger.b();
            String str = "can not find uin(" + this.uin + ") from friend manager!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).setContactSearchRecentAndHistoryWithoutFriend(view.getContext(), this.G, this.uin, this.nickname, this.keyword, view);
        }
        SearchUtils.f1(this.G, getTitle().toString(), this.uin, "", 0);
        SearchUtils.Z0(this.keyword, 20, view, false);
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).reportContactResultItemClick(this, view);
        if (SearchConfig.needSeparate) {
            SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
        }
        if (G() instanceof String) {
            AppInterface appInterface = this.G;
            String str2 = this.keyword;
            String str3 = this.L;
            String G = G();
            Intrinsics.checkNotNull(G, "null cannot be cast to non-null type kotlin.String");
            SearchUtils.o1(appInterface, str2, str3, G, H());
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            String str4 = this.L;
            if (str4 != null && !TextUtils.isEmpty(str4)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getMostUseConstantsReportContact(), 0, null, null);
            } else {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
            }
        }
    }

    private final void Z(View view) {
        boolean isRobotUin = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.uin);
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
        if (isRobotUin) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(view.getContext(), null, this.uin);
            SearchUtils.f1(this.G, getTitle().toString(), this.uin, this.fromGroupCode, 1000);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d o16 = SearchUtils.o(this.uin);
        if (o16 != null && o16.B()) {
            String x16 = SearchUtils.x(o16);
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            Context context = view.getContext();
            AppInterface appInterface = this.G;
            Intrinsics.checkNotNull(appInterface, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            iSearchPieceFetcher.enterChatWin(context, appInterface, this.uin, 0, x16, false);
            AppInterface appInterface2 = this.G;
            Intrinsics.checkNotNull(appInterface2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            SearchUtils.f1(appInterface2, x16, this.uin, "", 0);
            return;
        }
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(view.getContext(), this.uin, this.fromGroupCode, 1000, getTitle(), false, null, null);
        SearchUtils.f1(this.G, getTitle().toString(), this.uin, "", 1000);
        SearchUtils.c1(this.keyword, 20, 1, view);
        SearchUtils.Z0(this.keyword, 20, view, false);
        SearchUtils.X0(this, view);
        if (SearchConfig.needSeparate) {
            SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
        }
        if ((G() instanceof String) && !this.M) {
            AppInterface appInterface3 = this.G;
            String str = this.keyword;
            String str2 = this.L;
            String G = G();
            Intrinsics.checkNotNull(G, "null cannot be cast to non-null type kotlin.String");
            SearchUtils.o1(appInterface3, str, str2, G, H());
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            String str3 = this.L;
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 1, 0, null, null);
            } else {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    public String K() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: L, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        int i3 = this.chatType;
        if (i3 != 2 && i3 != 100) {
            return 0;
        }
        return 1000;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.keyword = keyword;
        return com.tencent.mobileqq.search.j.f283432t;
    }

    public final void R() {
        if (this.chatType == 2) {
            X();
        } else {
            W();
        }
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public String o() {
        return "";
    }

    @NotNull
    /* renamed from: U, reason: from getter */
    public final String getFromGroupCode() {
        return this.fromGroupCode;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: V, reason: from getter and merged with bridge method [inline-methods] */
    public String G() {
        return this.uin;
    }

    public final void a0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardName = str;
    }

    public final void b0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cardNameHits = list;
    }

    @Override // com.tencent.mobileqq.search.model.s
    public boolean c() {
        if (this.chatType == 2) {
            return true;
        }
        return false;
    }

    public final void c0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
    }

    public final void d0(int i3) {
        this.chatType = i3;
    }

    public final void e0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromGroupCode = str;
    }

    public final void f0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void g0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.nicknameHits = list;
    }

    @Override // com.tencent.mobileqq.search.model.s
    @NotNull
    public String getGroupCode() {
        return this.fromGroupCode;
    }

    @Override // com.tencent.mobileqq.search.model.v
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getRecallReason() {
        return this.recallReason;
    }

    public final void i0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rankInfo = str;
    }

    public final void j0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recallReason = str;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    public final void k0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remark = str;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l */
    public String getUin() {
        return this.uin;
    }

    public final void l0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.remarkHits = list;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        boolean z16;
        if (this.categoryName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.categoryName = "\u6211\u7684\u597d\u53cb";
        }
        if (this.chatType == 2) {
            return HardCodeUtil.qqStr(R.string.l2m) + this.categoryName;
        }
        return S(this.categoryName);
    }

    public final void m0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void n0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.uinHits = list;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: s, reason: from getter */
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: t, reason: from getter */
    public CharSequence getSubTitle() {
        return this.subTitleSpans;
    }

    @NotNull
    public String toString() {
        return "ContactSearchModelNtBuddy(title='" + this.title + "', keyword='" + this.keyword + "', uin='" + this.uin + "', chatType=" + this.chatType + ")";
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u, reason: from getter */
    public CharSequence getTitle() {
        return this.titleSpans;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.v(view);
        if (!SearchUtils.F0(this.I)) {
            return;
        }
        if (!this.M) {
            SearchUtils.o1(this.G, this.keyword, this.L, G(), H());
        }
        if (this.chatType != 2) {
            Y(view);
        } else {
            Z(view);
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    @NotNull
    public Map<String, String> y() {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.rankInfo.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            linkedHashMap.put("ranking_weight", this.rankInfo);
        }
        return linkedHashMap;
    }
}
