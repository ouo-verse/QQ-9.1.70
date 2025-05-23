package rz1;

import com.tencent.mobileqq.guild.setting.guildinfo.ProfileRuleData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import h53.CharacterCountInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001 BA\u0012\b\b\u0002\u0010&\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0'\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0'\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0'\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0004J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0015J\"\u0010\u001a\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019\u0012\u0004\u0012\u00020\u00020\u0005J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\t\u0010\u001d\u001a\u00020\u001cH\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010&\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0'8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0'8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b,\u0010*R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0'8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b.\u0010*R\u0016\u00100\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!\u00a8\u00063"}, d2 = {"Lrz1/c;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lkotlin/Pair;", "", "ruleList", "", DomainData.DOMAIN_NAME, "l", "o", "Lrz1/d;", "data", "targetData", "d", "c", "f", "b", "ruleData", "e", "Lrz1/h;", "g", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "Lkotlin/collections/ArrayList;", tl.h.F, "toString", "", "hashCode", "other", "equals", "a", "I", "k", "()I", "setStatus", "(I)V", "status", "", "Ljava/util/List;", "getOriginRuleDataList", "()Ljava/util/List;", "originRuleDataList", "i", "ruleDataList", "j", "sortingDataList", "ruleOrder", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rz1.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class PageData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Pair<String, String> f432981g = new Pair<>("\u9891\u9053\u5021\u5bfc\u6210\u5458\u5171\u540c\u8425\u9020\u826f\u597d\u6c1b\u56f4\u3002", "\u6210\u5458\u5e94\u5bbd\u5bb9\u7406\u6027\u5730\u5bf9\u5f85\u4e0d\u540c\u610f\u89c1\uff0c\u79ef\u6781\u70b9\u8d5e\u4ed6\u4eba\u521b\u4f5c\uff0c\u5c0a\u91cd\u539f\u521b\uff0c\u907f\u514d\u672a\u7ecf\u8bb8\u53ef\u5f15\u7528\u4ed6\u4eba\u4f5c\u54c1\uff1b\u5c0a\u91cd\u9690\u79c1\uff0c\u8c28\u614e\u5904\u7406\u4e2a\u4eba\u4fe1\u606f\uff0c\u907f\u514d\u6cc4\u9732\uff1b\u8425\u9020\u826f\u597d\u793e\u533a\u6c1b\u56f4\uff0c\u4fdd\u6301\u53cb\u5584\u6c9f\u901a\uff1b\u63d0\u9ad8\u7f51\u7edc\u5b89\u5168\u548c\u9632\u8bc8\u9a97\u610f\u8bc6\uff0c\u53ca\u65f6\u4e3e\u62a5\u4e0d\u5b9e\u5185\u5bb9\u3002");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RuleData> originRuleDataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RuleData> ruleDataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RuleData> sortingDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int ruleOrder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lrz1/c$a;", "", "Lkotlin/Pair;", "", "DEFAULT_RULE", "Lkotlin/Pair;", "a", "()Lkotlin/Pair;", "", "MIN_RULE_TITLE_LEGNTH", "I", "STATUS_EDIT", "STATUS_EMPTY", "STATUS_SORTING", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rz1.c$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Pair<String, String> a() {
            return PageData.f432981g;
        }

        Companion() {
        }
    }

    public PageData() {
        this(0, null, null, null, 15, null);
    }

    private final boolean m() {
        if (this.sortingDataList.size() != this.ruleDataList.size()) {
            return true;
        }
        if (this.sortingDataList.isEmpty()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : this.sortingDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((RuleData) obj, this.ruleDataList.get(i3))) {
                return true;
            }
            i3 = i16;
        }
        return false;
    }

    public final void b() {
        if (this.status == 1) {
            this.status = 2;
        }
        List<RuleData> list = this.ruleDataList;
        int i3 = this.ruleOrder;
        this.ruleOrder = i3 + 1;
        list.add(new RuleData(i3, null, null, 6, null));
    }

    public final boolean c() {
        if (this.status != 3) {
            return false;
        }
        this.status = 2;
        this.sortingDataList.clear();
        return true;
    }

    public final void d(@NotNull RuleData data, @NotNull RuleData targetData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(targetData, "targetData");
        Collections.swap(this.sortingDataList, this.sortingDataList.indexOf(data), this.sortingDataList.indexOf(targetData));
    }

    public final void e(@NotNull RuleData ruleData) {
        Intrinsics.checkNotNullParameter(ruleData, "ruleData");
        this.ruleDataList.remove(ruleData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) other;
        if (this.status == pageData.status && Intrinsics.areEqual(this.originRuleDataList, pageData.originRuleDataList) && Intrinsics.areEqual(this.ruleDataList, pageData.ruleDataList) && Intrinsics.areEqual(this.sortingDataList, pageData.sortingDataList)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.status != 3) {
            return false;
        }
        this.status = 2;
        this.ruleDataList.clear();
        this.ruleDataList.addAll(this.sortingDataList);
        this.sortingDataList.clear();
        return true;
    }

    @NotNull
    public final TitleStatus g() {
        int i3 = this.status;
        boolean z16 = true;
        if (i3 == 1) {
            return new TitleStatus(1, false, false, 6, null);
        }
        boolean m3 = m();
        if (this.ruleDataList.size() <= 1) {
            z16 = false;
        }
        return new TitleStatus(i3, m3, z16);
    }

    @NotNull
    public final Pair<ArrayList<ProfileRuleData>, Boolean> h() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        List<RuleData> list = this.ruleDataList;
        ArrayList<RuleData> arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (CharacterCountInfo.d(h53.c.b(((RuleData) next).getTitle(), null, 2, null), null, 1, null) >= 5) {
                z16 = true;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        for (RuleData ruleData : arrayList2) {
            arrayList.add(new ProfileRuleData(ruleData.getTitle(), ruleData.getContent(), false, 4, null));
        }
        if (arrayList.size() != this.ruleDataList.size()) {
            z16 = true;
        }
        return new Pair<>(arrayList, Boolean.valueOf(z16));
    }

    public int hashCode() {
        return (((((this.status * 31) + this.originRuleDataList.hashCode()) * 31) + this.ruleDataList.hashCode()) * 31) + this.sortingDataList.hashCode();
    }

    @NotNull
    public final List<RuleData> i() {
        return this.ruleDataList;
    }

    @NotNull
    public final List<RuleData> j() {
        return this.sortingDataList;
    }

    /* renamed from: k, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final boolean l() {
        if (this.originRuleDataList.size() != this.ruleDataList.size()) {
            return true;
        }
        if (this.originRuleDataList.isEmpty()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : this.originRuleDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((RuleData) obj, this.ruleDataList.get(i3))) {
                return true;
            }
            i3 = i16;
        }
        return false;
    }

    public final void n(@NotNull List<Pair<String, String>> ruleList) {
        Intrinsics.checkNotNullParameter(ruleList, "ruleList");
        if (ruleList.isEmpty()) {
            this.status = 1;
            return;
        }
        this.status = 2;
        Iterator<T> it = ruleList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int i3 = this.ruleOrder;
            this.ruleOrder = i3 + 1;
            String str = (String) pair.getFirst();
            String str2 = (String) pair.getSecond();
            if (str2 == null) {
                str2 = "";
            }
            RuleData ruleData = new RuleData(i3, str, str2);
            this.ruleDataList.add(ruleData);
            this.originRuleDataList.add(RuleData.b(ruleData, 0, null, null, 7, null));
        }
    }

    public final boolean o() {
        if (this.status != 2) {
            return false;
        }
        this.sortingDataList.clear();
        this.sortingDataList.addAll(this.ruleDataList);
        this.status = 3;
        return true;
    }

    @NotNull
    public String toString() {
        return "PageData(status=" + this.status + ", originRuleDataList=" + this.originRuleDataList.size() + ", ruleDataList=" + this.ruleDataList.size() + ", sortingDataList=" + this.sortingDataList.size() + ")";
    }

    public PageData(int i3, @NotNull List<RuleData> originRuleDataList, @NotNull List<RuleData> ruleDataList, @NotNull List<RuleData> sortingDataList) {
        Intrinsics.checkNotNullParameter(originRuleDataList, "originRuleDataList");
        Intrinsics.checkNotNullParameter(ruleDataList, "ruleDataList");
        Intrinsics.checkNotNullParameter(sortingDataList, "sortingDataList");
        this.status = i3;
        this.originRuleDataList = originRuleDataList;
        this.ruleDataList = ruleDataList;
        this.sortingDataList = sortingDataList;
    }

    public /* synthetic */ PageData(int i3, List list, List list2, List list3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 2 : i3, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? new ArrayList() : list2, (i16 & 8) != 0 ? new ArrayList() : list3);
    }
}
