package zm3;

import com.tencent.now.linkpkanchorplay.componententry.AnchorRoomInfo;
import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u0004J\u001a\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lzm3/a;", "", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "roomInfo", "", "f", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "tabid", "g", "Le55/a;", "c", "linkAnchorInfo", "e", "a", "", "", "paramsMap", "d", "", "b", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "selectedMainPageTab", "Le55/a;", "Ljava/util/Map;", "pageParamsMap", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static e55.a linkAnchorInfo;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452778a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AnchorRoomInfo roomInfo = new AnchorRoomInfo(0, 0);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static LinkPKTabData.TabId selectedMainPageTab = LinkPKTabData.TabId.PK_TAB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, String> pageParamsMap = new HashMap();

    a() {
    }

    public final void a() {
        roomInfo = new AnchorRoomInfo(0L, 0L);
        linkAnchorInfo = null;
    }

    @NotNull
    public final Map<String, String> b() {
        return pageParamsMap;
    }

    @Nullable
    public final e55.a c() {
        return linkAnchorInfo;
    }

    public final void d(@NotNull Map<String, String> paramsMap) {
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        pageParamsMap.clear();
        pageParamsMap.putAll(paramsMap);
    }

    public final void e(@Nullable e55.a linkAnchorInfo2) {
        linkAnchorInfo = linkAnchorInfo2;
    }

    public final void f(@NotNull AnchorRoomInfo roomInfo2) {
        Intrinsics.checkNotNullParameter(roomInfo2, "roomInfo");
        roomInfo = roomInfo2;
    }

    public final void g(@NotNull LinkPKTabData.TabId tabid) {
        Intrinsics.checkNotNullParameter(tabid, "tabid");
        selectedMainPageTab = tabid;
    }
}
