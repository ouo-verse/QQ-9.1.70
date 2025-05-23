package zy;

import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzy/a;", "Lwz/c;", "Lcom/tencent/biz/pubaccount/weishi/event/FollowEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Laz/b;", "d", "Laz/b;", "presenter", "<init>", "(Laz/b;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements wz.c<FollowEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final az.b presenter;

    public a(az.b presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FollowEvent followEvent = (FollowEvent) event;
        String pid = followEvent.getPersonId();
        boolean hasFollowed = followEvent.hasFollowed();
        az.b bVar = this.presenter;
        Intrinsics.checkNotNullExpressionValue(pid, "pid");
        bVar.F0(pid, hasFollowed);
    }

    @Override // wz.c
    public ArrayList<Class<FollowEvent>> getEventClass() {
        ArrayList<Class<FollowEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FollowEvent.class);
        return arrayListOf;
    }
}
