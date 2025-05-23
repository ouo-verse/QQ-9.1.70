package ra2;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feeds.request.GetUserStatusListRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.FormatUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017R&\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\"\u0010;\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lra2/d;", "Lra2/a;", "", "more", "", "U1", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lna2/b;", "data", "R1", "", "getLogTag", FeedManager.LOAD_MORE, "refresh", "Lop4/i;", "statusFeed", "T1", "feedId", "P1", "Lop4/d;", "likeInfo", "Q1", "", "commentCount", "O1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "mFeedsData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mLoadMoreFinish", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMTinyId", "()Ljava/lang/String;", "setMTinyId", "(Ljava/lang/String;)V", "mTinyId", "", "D", "Ljava/util/List;", "getMAllFeedsListData", "()Ljava/util/List;", "mAllFeedsListData", "Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "E", "Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "mTimeTag", "", UserInfo.SEX_FEMALE, "[B", "mAttachInfo", "G", "I", "getMVisibleCount", "()I", "setMVisibleCount", "(I)V", "mVisibleCount", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends a {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FormatUtils.StateTagTime mTimeTag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<na2.b>>> mFeedsData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mLoadMoreFinish = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mTinyId = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<na2.b> mAllFeedsListData = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private byte[] mAttachInfo = new byte[0];

    /* renamed from: G, reason: from kotlin metadata */
    private int mVisibleCount = 10;

    private final void R1(final UIStateData<List<na2.b>> data) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ra2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.S1(d.this, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(d this$0, UIStateData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.mFeedsData.setValue(data);
    }

    private final void U1(final boolean more) {
        j.e().b(new GetUserStatusListRequest(this.mTinyId, 0, 0, this.mAttachInfo, 6, null), new com.tencent.mobileqq.nearbypro.request.b() { // from class: ra2.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                d.W1(d.this, more, (NearbyProBaseRequest) obj, rspStatus, (up4.b) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(d this$0, boolean z16, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, up4.b bVar) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        ga2.a c16 = j.c();
        String tag = this$0.getTAG();
        if (c16.isColorLevel()) {
            c16.e(tag, "requestNet " + rspStatus);
        }
        if (rspStatus.c() && bVar != null) {
            if (!z16) {
                this$0.mAllFeedsListData.clear();
            }
            i[] list = bVar.f439767a;
            int i3 = bVar.f439770d;
            if (i3 > 0) {
                this$0.mVisibleCount = i3;
            }
            boolean z18 = true;
            if (list != null) {
                if (list.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z18 = false;
                }
            }
            if (z18) {
                if (!z16) {
                    UIStateData<List<na2.b>> obtainEmpty = UIStateData.obtainEmpty();
                    Intrinsics.checkNotNullExpressionValue(obtainEmpty, "obtainEmpty()");
                    this$0.R1(obtainEmpty);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                for (i iVar : list) {
                    na2.b bVar2 = new na2.b();
                    bVar2.b(iVar);
                    FormatUtils.StateTagTime c17 = FormatUtils.f253930a.c(iVar.f423358h * 1000);
                    if (!Intrinsics.areEqual(this$0.mTimeTag, c17)) {
                        bVar2.d(c17);
                        this$0.mTimeTag = c17;
                    }
                    bVar2.e(bVar.f439770d);
                    this$0.mAllFeedsListData.add(bVar2);
                }
                UIStateData<List<na2.b>> data = UIStateData.obtainSuccess(false).setData(z16, this$0.mAllFeedsListData);
                Intrinsics.checkNotNullExpressionValue(data, "obtainSuccess<List<NBPFe\u2026(more, mAllFeedsListData)");
                this$0.R1(data);
            }
            this$0.mLoadMoreFinish.setValue(Boolean.valueOf(bVar.f439768b));
            byte[] bArr = bVar.f439769c;
            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.cookies");
            this$0.mAttachInfo = bArr;
            return;
        }
        if (!z16) {
            UIStateData<List<na2.b>> obtainError = UIStateData.obtainError(rspStatus.getMsg());
            Intrinsics.checkNotNullExpressionValue(obtainError, "obtainError(rspStatus.msg)");
            this$0.R1(obtainError);
        }
        j.c().d(this$0.getTAG(), "requestNet " + rspStatus);
    }

    public final void O1(@NotNull String feedId, int commentCount) {
        String str;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Iterator<na2.b> it = this.mAllFeedsListData.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            na2.b next = it.next();
            i a16 = next.a();
            if (a16 != null) {
                str = a16.f423351a;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, feedId)) {
                i a17 = next.a();
                if (a17 != null) {
                    a17.f423362l = commentCount;
                }
            } else {
                i3++;
            }
        }
        if (i3 >= this.mAllFeedsListData.size()) {
            return;
        }
        UIStateData<List<na2.b>> pos = UIStateData.obtainModify().setDataList(this.mAllFeedsListData).setPos(i3);
        Intrinsics.checkNotNullExpressionValue(pos, "obtainModify<List<NBPFee\u2026eedsListData).setPos(pos)");
        R1(pos);
    }

    public void P1(@NotNull String feedId) {
        FormatUtils.StateTagTime stateTagTime;
        na2.b bVar;
        String str;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Iterator<na2.b> it = this.mAllFeedsListData.iterator();
        int i3 = 0;
        while (true) {
            stateTagTime = null;
            if (it.hasNext()) {
                bVar = it.next();
                i a16 = bVar.a();
                if (a16 != null) {
                    str = a16.f423351a;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, feedId)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                bVar = null;
                break;
            }
        }
        if (i3 >= this.mAllFeedsListData.size()) {
            return;
        }
        if (bVar != null) {
            stateTagTime = bVar.getStateTagTime();
        }
        if (stateTagTime != null && i3 < this.mAllFeedsListData.size() - 1) {
            int i16 = i3 + 1;
            if (this.mAllFeedsListData.get(i16).getStateTagTime() == null) {
                this.mAllFeedsListData.get(i16).d(bVar.getStateTagTime());
            }
        }
        this.mAllFeedsListData.remove(i3);
        UIStateData<List<na2.b>> dataList = UIStateData.obtainDelete().setPos(i3).setDataList(this.mAllFeedsListData);
        Intrinsics.checkNotNullExpressionValue(dataList, "obtainDelete<List<NBPFee\u2026taList(mAllFeedsListData)");
        R1(dataList);
    }

    public void Q1(@NotNull String feedId, @NotNull op4.d likeInfo) {
        String str;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
        Iterator<na2.b> it = this.mAllFeedsListData.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            na2.b next = it.next();
            i a16 = next.a();
            if (a16 != null) {
                str = a16.f423351a;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, feedId)) {
                i a17 = next.a();
                if (a17 != null) {
                    a17.f423359i = likeInfo;
                }
            } else {
                i3++;
            }
        }
        if (i3 >= this.mAllFeedsListData.size()) {
            return;
        }
        UIStateData<List<na2.b>> pos = UIStateData.obtainModify().setDataList(this.mAllFeedsListData).setPos(i3);
        Intrinsics.checkNotNullExpressionValue(pos, "obtainModify<List<NBPFee\u2026eedsListData).setPos(pos)");
        R1(pos);
    }

    public final void T1(@Nullable i statusFeed) {
        Object firstOrNull;
        FormatUtils.StateTagTime stateTagTime;
        if (statusFeed != null) {
            FormatUtils.StateTagTime c16 = FormatUtils.f253930a.c(statusFeed.f423358h * 1000);
            na2.b bVar = new na2.b();
            bVar.b(statusFeed);
            bVar.d(c16);
            bVar.e(this.mVisibleCount);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.mAllFeedsListData);
            na2.b bVar2 = (na2.b) firstOrNull;
            if (bVar2 != null) {
                stateTagTime = bVar2.getStateTagTime();
            } else {
                stateTagTime = null;
            }
            if (Intrinsics.areEqual(stateTagTime, c16)) {
                bVar2.d(null);
            }
            this.mAllFeedsListData.add(0, bVar);
            UIStateData<List<na2.b>> dataList = UIStateData.obtainInsert(0).setDataList(this.mAllFeedsListData);
            Intrinsics.checkNotNullExpressionValue(dataList, "obtainInsert<List<NBPFee\u2026taList(mAllFeedsListData)");
            R1(dataList);
            return;
        }
        refresh();
    }

    @Override // ra2.a, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "NBP.NearbyFeedPart.NearbyProFeedListViewModel";
    }

    public final void loadMore() {
        List emptyList;
        ga2.a c16 = j.c();
        String tag = getTAG();
        if (c16.isColorLevel()) {
            c16.e(tag, "loadMore... mLoadMoreFinish.value = " + this.mLoadMoreFinish.getValue());
        }
        if (Intrinsics.areEqual(this.mLoadMoreFinish.getValue(), Boolean.TRUE)) {
            MutableLiveData<UIStateData<List<na2.b>>> mutableLiveData = this.mFeedsData;
            UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.setValue(obtainSuccess.setData(true, emptyList));
            return;
        }
        U1(true);
    }

    public final void refresh() {
        this.mAttachInfo = new byte[0];
        U1(false);
    }
}
