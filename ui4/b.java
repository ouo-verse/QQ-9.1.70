package ui4;

import af4.OperationItem;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.ad.ui.OperationItemView;
import com.tencent.timi.game.liveroom.impl.room.match.TGAudienceMatchTabView;
import com.tencent.timi.game.liveroom.impl.room.match.TGAudienceTabViewPager;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$RoomTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u000eB'\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001f\u00a8\u0006#"}, d2 = {"Lui4/b;", "", "", "url", "", "c", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$RoomTabInfo;", "roomTabInfos", "outCallUrl", "d", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView;", "g", "()Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView;", "tabView", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;", "b", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;", h.F, "()Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;", "viewPager", "", "J", "f", "()J", "roomId", "", "Z", "jumpEnable", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceMatchTabView;Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TGAudienceMatchTabView tabView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TGAudienceTabViewPager viewPager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean jumpEnable = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"ui4/b$b", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "Laf4/d;", "itemData", "", "a", "", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ui4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11352b implements OperationItemView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<PremadesTeamServerOuterClass$RoomTabInfo> f439053b;

        C11352b(List<PremadesTeamServerOuterClass$RoomTabInfo> list) {
            this.f439053b = list;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public void a(@NotNull OperationItem itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public boolean b(@NotNull OperationItem itemData) {
            boolean contains$default;
            boolean contains$default2;
            int indexOf$default;
            CharSequence trim;
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            l.b("TGTabViewOperateHelper", ">>shouldOverJumpTask");
            String realUrl = URLDecoder.decode(itemData.getJumpUrl(), "utf-8");
            String str = null;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) itemData.getJumpUrl(), (CharSequence) "mqqapi://vaslive", false, 2, (Object) null);
            Intrinsics.checkNotNullExpressionValue(realUrl, "decodeUrl");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) realUrl, (CharSequence) "mqqapi://vaslive", false, 2, (Object) null);
            if (!contains$default && !contains$default2) {
                l.b("TGTabViewOperateHelper", ">>shouldOverJumpTask \u975e\u76f4\u64ad\u95f4url");
                return false;
            }
            if (contains$default) {
                realUrl = itemData.getJumpUrl();
            }
            Intrinsics.checkNotNullExpressionValue(realUrl, "realUrl");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) realUrl, "mqqapi://vaslive", 0, false, 6, (Object) null);
            String substring = realUrl.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            String queryParameter = Uri.parse(substring).getQueryParameter("roomid");
            if (!TextUtils.isEmpty(queryParameter)) {
                if (queryParameter != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) queryParameter);
                    str = trim.toString();
                }
                if (Intrinsics.areEqual(str, String.valueOf(b.this.getRoomId()))) {
                    int c16 = b.this.c(realUrl);
                    if (c16 != -1) {
                        int d16 = b.this.d(this.f439053b, realUrl);
                        if (d16 >= 0 && b.this.getTabView() != null && b.this.getViewPager() != null) {
                            b.this.getTabView().m(d16);
                            b.this.getViewPager().setCurrentItem(d16, true);
                            l.b("TGTabViewOperateHelper", ">>shouldOverJumpTask \u627e\u5230\u9ed8\u8ba4tab tabIndex = " + d16);
                        } else {
                            f.c("\u4e0d\u652f\u6301\u7684\u8df3\u8f6c\u52a8\u4f5c");
                            l.b("TGTabViewOperateHelper", ">>shouldOverJumpTask defaultTabIdInUrl:" + c16 + ", \u65e0\u6cd5\u5339\u914d");
                        }
                        return true;
                    }
                    return false;
                }
            }
            l.b("TGTabViewOperateHelper", ">>shouldOverJumpTask \u975e\u672c\u76f4\u64ad\u95f4url");
            return false;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public void c(@NotNull OperationItem itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
        }
    }

    public b(@Nullable TGAudienceMatchTabView tGAudienceMatchTabView, @Nullable TGAudienceTabViewPager tGAudienceTabViewPager, long j3) {
        this.tabView = tGAudienceMatchTabView;
        this.viewPager = tGAudienceTabViewPager;
        this.roomId = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(String url) {
        boolean z16;
        Integer intOrNull;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (r3 = Uri.parse(url).getQueryParameter("default_tab_id")) == null || intOrNull == null) {
            return -1;
        }
        return intOrNull.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(List<PremadesTeamServerOuterClass$RoomTabInfo> roomTabInfos, String outCallUrl) {
        String str;
        l.b("TGTabViewOperateHelper", ">>getDefaultTabIndexFromUrl");
        if (outCallUrl != null) {
            String queryParameter = Uri.parse(outCallUrl).getQueryParameter("default_tab_id");
            int i3 = 0;
            for (Object obj : roomTabInfos) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                PremadesTeamServerOuterClass$RoomTabInfo premadesTeamServerOuterClass$RoomTabInfo = (PremadesTeamServerOuterClass$RoomTabInfo) obj;
                if (!TextUtils.isEmpty(queryParameter)) {
                    PBStringField pBStringField = premadesTeamServerOuterClass$RoomTabInfo.f437246id;
                    if (pBStringField != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, queryParameter)) {
                        l.b("TGTabViewOperateHelper", ">>getDefaultTabIndexFromUrl index=" + i3);
                        return i3;
                    }
                }
                i3 = i16;
            }
            return -1;
        }
        return -1;
    }

    @NotNull
    public final OperationItemView.b e(@NotNull List<PremadesTeamServerOuterClass$RoomTabInfo> roomTabInfos) {
        Intrinsics.checkNotNullParameter(roomTabInfos, "roomTabInfos");
        return new C11352b(roomTabInfos);
    }

    /* renamed from: f, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final TGAudienceMatchTabView getTabView() {
        return this.tabView;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final TGAudienceTabViewPager getViewPager() {
        return this.viewPager;
    }
}
