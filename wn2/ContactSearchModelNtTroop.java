package wn2;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0002\u001emB\u0017\u0012\u0006\u0010h\u001a\u00020\u0006\u0012\u0006\u0010i\u001a\u00020\u0018\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\bH\u0014J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J.\u0010&\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\b2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0016R\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010)\u001a\u0004\b4\u00105\"\u0004\b3\u00106R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010)\u001a\u0004\b7\u00105\"\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010@R\"\u0010D\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010@\u001a\u0004\bA\u0010B\"\u0004\b<\u0010CR(\u0010K\u001a\b\u0012\u0004\u0012\u00020\"0E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\b>\u0010JR\"\u0010O\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010@\u001a\u0004\bM\u0010B\"\u0004\bN\u0010CR(\u0010S\u001a\b\u0012\u0004\u0012\u00020\"0E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010G\u001a\u0004\bQ\u0010I\"\u0004\bR\u0010JR'\u0010X\u001a\u0012\u0012\u0004\u0012\u00020T0!j\b\u0012\u0004\u0012\u00020T`#8\u0006\u00a2\u0006\f\n\u0004\bN\u0010U\u001a\u0004\bV\u0010WR\"\u0010Z\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010@\u001a\u0004\bY\u0010B\"\u0004\bF\u0010CR\"\u0010]\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010@\u001a\u0004\b\\\u0010B\"\u0004\bL\u0010CR\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010@R(\u0010a\u001a\b\u0012\u0004\u0012\u00020\"0E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010G\u001a\u0004\b`\u0010I\"\u0004\b9\u0010JR(\u0010g\u001a\u0004\u0018\u00010\u001d2\b\u0010b\u001a\u0004\u0018\u00010\u001d8F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\u00a8\u0006n"}, d2 = {"Lwn2/l;", "Lcom/tencent/mobileqq/search/model/k;", "Lcom/tencent/mobileqq/search/model/o;", "", "W", "X", "", "k", "", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "T", ReportConstant.COSTREPORT_PREFIX, "", "r", "U", "H", "M", "u", "L", "t", "K", "keyword", "", "N", "", "y", "toString", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "a", tl.h.F, "name", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHitInfo;", "Lkotlin/collections/ArrayList;", "hits", "type", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "groupCode", "Z", "Landroid/view/View;", "view", "v", "I", "getMemberCount", "()I", "d0", "(I)V", "memberCount", "Y", "isConf", "()Z", "(Z)V", "isPrivateTroop", "e0", "a0", "Ljava/lang/CharSequence;", "title", "b0", QQWinkConstants.TAB_SUBTITLE, "c0", "description", "Ljava/lang/String;", "getGroupName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "groupName", "", "f0", "Ljava/util/List;", "getGroupNameHits", "()Ljava/util/List;", "(Ljava/util/List;)V", "groupNameHits", "g0", "getRemarkName", "i0", "remarkName", "h0", "getRemarkNameHits", "j0", "remarkNameHits", "Lwn2/l$b;", "Ljava/util/ArrayList;", "getMembers", "()Ljava/util/ArrayList;", "members", "getRankInfo", "rankInfo", "k0", "getRecallReason", "recallReason", "l0", "m0", "getGroupCodeHits", "groupCodeHits", "<set-?>", "n0", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "V", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "mTroopInfo", IProfileCardConst.KEY_FROM_TYPE, "recentIndex", "<init>", "(IJ)V", "o0", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wn2.l, reason: from toString */
/* loaded from: classes18.dex */
public final class ContactSearchModelNtTroop extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.o {

    /* renamed from: X, reason: from kotlin metadata */
    private int memberCount;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isConf;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isPrivateTroop;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public CharSequence title;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public CharSequence subTitle;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public CharSequence description;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String keyword;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String groupName;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> groupNameHits;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String remarkName;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> remarkNameHits;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<Member> members;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rankInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String recallReason;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String groupCode;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchHitInfo> groupCodeHits;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopInfo mTroopInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lwn2/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHitInfo;", "Ljava/util/List;", "()Ljava/util/List;", "hits", "c", "I", "getType", "()I", "type", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wn2.l$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class Member {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<SearchHitInfo> hits;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        public Member(@NotNull String name, @NotNull List<SearchHitInfo> hits, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(hits, "hits");
            this.name = name;
            this.hits = hits;
            this.type = i3;
        }

        @NotNull
        public final List<SearchHitInfo> a() {
            return this.hits;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            if (Intrinsics.areEqual(this.name, member.name) && Intrinsics.areEqual(this.hits, member.hits) && this.type == member.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.hits.hashCode()) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            return "Member(name=" + this.name + ", hits=" + this.hits + ", type=" + this.type + ")";
        }
    }

    public ContactSearchModelNtTroop(int i3, long j3) {
        super((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), i3, j3);
        List<SearchHitInfo> emptyList;
        List<SearchHitInfo> emptyList2;
        List<SearchHitInfo> emptyList3;
        this.title = "";
        this.subTitle = "";
        this.description = "";
        this.keyword = "";
        this.groupName = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.groupNameHits = emptyList;
        this.remarkName = "";
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.remarkNameHits = emptyList2;
        this.members = new ArrayList<>();
        this.rankInfo = "";
        this.recallReason = "";
        this.groupCode = "";
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.groupCodeHits = emptyList3;
        C(7);
    }

    private final void W() {
        CharSequence removeSuffix;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!this.members.isEmpty()) {
            spannableStringBuilder.append((CharSequence) "\u5305\u542b\uff1a");
            Iterator<Member> it = this.members.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Member next = it.next();
                if (i3 >= 10) {
                    break;
                }
                if (!next.a().isEmpty()) {
                    rn2.l.a(spannableStringBuilder, next.getName(), next.a(), this.keyword);
                    i3++;
                    spannableStringBuilder.append((CharSequence) "\u3001");
                }
            }
        }
        removeSuffix = StringsKt__StringsKt.removeSuffix(spannableStringBuilder, "\u3001");
        this.description = removeSuffix;
    }

    private final void X() {
        List emptyList;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z16 = true;
        if (!this.remarkNameHits.isEmpty()) {
            rn2.l.d(spannableStringBuilder, this.remarkName, this.remarkNameHits, this.keyword);
        } else if (!this.groupNameHits.isEmpty()) {
            rn2.l.d(spannableStringBuilder, this.groupName, this.groupNameHits, this.keyword);
        } else {
            if (this.remarkName.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                rn2.l.d(spannableStringBuilder, this.remarkName, this.remarkNameHits, this.keyword);
            } else {
                rn2.l.d(spannableStringBuilder, this.groupName, this.groupNameHits, this.keyword);
            }
        }
        this.title = spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (!this.isConf && !this.isPrivateTroop) {
            rn2.l.b(spannableStringBuilder2, this.groupCode, this.groupCodeHits, this.keyword);
        } else {
            String str = this.memberCount + HardCodeUtil.qqStr(R.string.l3d);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            rn2.l.c(spannableStringBuilder2, str, emptyList, null, 4, null);
        }
        this.subTitle = spannableStringBuilder2;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 2;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    public String K() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: L */
    public String getTitle() {
        return this.title.toString();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return com.tencent.mobileqq.search.j.f283416e;
    }

    public final void R(@NotNull String name, @NotNull ArrayList<SearchHitInfo> hits, int type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hits, "hits");
        this.members.add(new Member(name, hits, type));
    }

    public final void S() {
        X();
        W();
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public String o() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: U, reason: from getter and merged with bridge method [inline-methods] */
    public String getUin() {
        return this.groupCode;
    }

    @Nullable
    public final TroopInfo V() {
        if (this.mTroopInfo == null) {
            if (QLog.isDebugVersion()) {
                QLog.w(com.tencent.mobileqq.search.model.k.W, 1, "mTroopInfo is null, create troop info", new Throwable());
            }
            this.mTroopInfo = SearchUtils.w0(this.G, this.groupCode);
        }
        return this.mTroopInfo;
    }

    public final void Y(boolean z16) {
        this.isConf = z16;
    }

    public final void Z(@NotNull String groupCode) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        this.groupCode = groupCode;
        D(groupCode);
    }

    @Override // com.tencent.mobileqq.search.model.o
    @Nullable
    public TroopInfo a() {
        return V();
    }

    public final void a0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.groupCodeHits = list;
    }

    public final void b0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupName = str;
    }

    public final void c0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.groupNameHits = list;
    }

    public final void d0(int i3) {
        this.memberCount = i3;
    }

    public final void e0(boolean z16) {
        this.isPrivateTroop = z16;
    }

    public final void f0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rankInfo = str;
    }

    public final void g0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recallReason = str;
    }

    @Override // com.tencent.mobileqq.search.model.v
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getRecallReason() {
        return this.recallReason;
    }

    public final void i0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remarkName = str;
    }

    public final void j0(@NotNull List<SearchHitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.remarkNameHits = list;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l */
    public String getUin() {
        return this.groupCode;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m, reason: from getter */
    public CharSequence getDescription() {
        return this.description;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return com.tencent.mobileqq.search.business.contact.i.f(this.I);
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
    public CharSequence getSubTitleSpans() {
        return this.subTitle;
    }

    @NotNull
    public String toString() {
        CharSequence charSequence = this.title;
        return "ContactSearchModelNtTroop(title='" + ((Object) charSequence) + "', keyword='" + this.keyword + "', groupCode='" + this.groupCode + "', members=" + this.members + ")";
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u, reason: from getter */
    public CharSequence getTitleSpans() {
        return this.title;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            String troopName = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.G, this.groupCode, true);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterChatWin(view.getContext(), this.G, this.groupCode, 1, troopName, false);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.keyword);
            SearchUtils.f1(this.G, this.groupName, this.groupCode, "", 1);
            SearchUtils.c1(this.keyword, 20, 2, view);
            SearchUtils.Z0(this.keyword, 20, view, false);
            SearchUtils.X0(this, view);
            if ((G() instanceof String) && !this.M) {
                AppInterface appInterface = this.G;
                String str = this.keyword;
                String str2 = this.L;
                String G = G();
                Intrinsics.checkNotNull(G, "null cannot be cast to non-null type kotlin.String");
                SearchUtils.o1(appInterface, str, str2, G, H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str3 = this.L;
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 2, 0, null, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D3B", 0, 0, null, null);
                }
            }
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
