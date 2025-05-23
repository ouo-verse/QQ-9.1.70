package xi1;

import androidx.annotation.UiThread;
import androidx.lifecycle.MutableLiveData;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedPayloadType;
import com.tencent.mobileqq.guild.feed.feedsquare.data.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vi1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\bH\u0017J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\"R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010/R\"\u00103\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lxi1/b;", "Lvi1/f;", "", "isChecked", "l", "", "p", DomainData.DOMAIN_NAME, "", c.G, "o", "", "feedId", "j", "Lvi1/a;", JsonRuleKey.OPERATOR, "k", "", "channelId", "c", "mode", "d", "f", "g", h.F, "channelName", "a", "b", "e", "Landroidx/lifecycle/MutableLiveData;", "Lxi1/a;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", "batchManageOperate", "I", "curSelectMode", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "selectedFeedsList", "unSelectedFeedsList", "Lvi1/a;", "feedListOperator", "J", "selectedChannelId", "Ljava/lang/String;", "selectedChannelName", "", "Ljava/util/Map;", "channelIdMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/lifecycle/MutableLiveData;", "batchManageOperateState", "<init>", "()V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<BatchManageOperate> batchManageOperate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int curSelectMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<String> selectedFeedsList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<String> unSelectedFeedsList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vi1.a feedListOperator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long selectedChannelId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selectedChannelName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Long> channelIdMap;

    public b() {
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.batchManageOperate = new MutableLiveData<>(new BatchManageOperate(0, emptyList, emptyList2, null, null, 24, null));
        this.selectedFeedsList = new LinkedList<>();
        this.unSelectedFeedsList = new LinkedList<>();
        this.selectedChannelName = "";
        this.channelIdMap = new LinkedHashMap();
    }

    private final boolean l(boolean isChecked) {
        if (this.curSelectMode == 1) {
            if (isChecked || this.unSelectedFeedsList.size() < 100) {
                return false;
            }
        } else if (!isChecked || this.selectedFeedsList.size() < 100) {
            return false;
        }
        return true;
    }

    private final void n() {
        Map mapOf;
        vi1.a aVar = this.feedListOperator;
        if (aVar != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(GuildFeedSquareFeedPayloadType.SELECT_STATE_PAYLOAD, i.a.f218825a));
            aVar.U0(mapOf);
        }
    }

    private final void o(int pos) {
        vi1.a aVar = this.feedListOperator;
        if (aVar != null) {
            aVar.m6(pos);
        }
    }

    private final void p() {
        List list;
        List list2;
        MutableLiveData<BatchManageOperate> mutableLiveData = this.batchManageOperate;
        int i3 = this.curSelectMode;
        list = CollectionsKt___CollectionsKt.toList(this.selectedFeedsList);
        list2 = CollectionsKt___CollectionsKt.toList(this.unSelectedFeedsList);
        mutableLiveData.setValue(new BatchManageOperate(i3, list, list2, null, null, 24, null));
    }

    @Override // vi1.f
    public void a(@NotNull String channelName) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        this.selectedChannelName = channelName;
    }

    @Override // vi1.f
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getSelectedChannelName() {
        return this.selectedChannelName;
    }

    @Override // vi1.f
    public void c(int pos, @NotNull String feedId, long channelId, boolean isChecked) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (l(isChecked)) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f145270r1, 0).show();
            return;
        }
        if (isChecked) {
            if (!this.selectedFeedsList.contains(feedId)) {
                this.selectedFeedsList.add(feedId);
            }
            if (this.unSelectedFeedsList.contains(feedId)) {
                this.unSelectedFeedsList.remove(feedId);
            }
        } else {
            if (!this.unSelectedFeedsList.contains(feedId)) {
                this.unSelectedFeedsList.add(feedId);
            }
            if (this.selectedFeedsList.contains(feedId)) {
                this.selectedFeedsList.remove(feedId);
            }
        }
        this.channelIdMap.put(feedId, Long.valueOf(channelId));
        o(pos);
        p();
    }

    @Override // vi1.f
    @UiThread
    public void d(int mode) {
        if (this.curSelectMode != mode) {
            this.curSelectMode = mode;
            this.selectedFeedsList.clear();
            this.unSelectedFeedsList.clear();
            p();
            n();
        }
    }

    @Override // vi1.f
    public long e() {
        if (this.selectedFeedsList.size() != 1) {
            return 0L;
        }
        String str = this.selectedFeedsList.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "selectedFeedsList[0]");
        Long l3 = this.channelIdMap.get(str);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @Override // vi1.f
    public void f() {
        List list;
        List list2;
        this.curSelectMode = 0;
        this.selectedFeedsList.clear();
        this.unSelectedFeedsList.clear();
        MutableLiveData<BatchManageOperate> mutableLiveData = this.batchManageOperate;
        int i3 = this.curSelectMode;
        list = CollectionsKt___CollectionsKt.toList(this.selectedFeedsList);
        list2 = CollectionsKt___CollectionsKt.toList(this.unSelectedFeedsList);
        mutableLiveData.setValue(new BatchManageOperate(i3, list, list2, "", 0));
        n();
    }

    @Override // vi1.f
    /* renamed from: g, reason: from getter */
    public long getSelectedChannelId() {
        return this.selectedChannelId;
    }

    @Override // vi1.f
    public void h(long channelId) {
        this.selectedChannelId = channelId;
    }

    @Override // vi1.f
    public boolean j(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (this.curSelectMode == 0) {
            return this.selectedFeedsList.contains(feedId);
        }
        if (!this.unSelectedFeedsList.contains(feedId)) {
            return true;
        }
        return false;
    }

    public void k(@NotNull vi1.a operator) {
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.feedListOperator = operator;
    }

    @Override // vi1.f
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public MutableLiveData<BatchManageOperate> i() {
        return this.batchManageOperate;
    }
}
