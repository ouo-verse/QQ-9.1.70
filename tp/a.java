package tp;

import com.tencent.qqlive.module.videoreport.page.PageUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Ltp/a;", "", "", "", "a", "Ljava/lang/String;", "pageId", "b", "refPageId", "", "c", "I", "pageStp", "d", "Ljava/util/Map;", "pageParam", "<init>", "()V", "qqrtc_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int pageStp;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String pageId = "pg_bas_robot_live_talk";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String refPageId = PageUtils.VR_PAGE_NONE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> pageParam = new HashMap();

    public final Map<String, Object> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", this.pageId);
        linkedHashMap.put("qq_pgstp", Integer.valueOf(this.pageStp));
        linkedHashMap.put("qq_ref_pgid", this.refPageId);
        linkedHashMap.putAll(this.pageParam);
        return linkedHashMap;
    }
}
