package x13;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lx13/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "a", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "b", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447051a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<g> mProcessorList;

    static {
        List<g> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new g[]{(g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTitleConvertProcessor(), (g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
        mProcessorList = listOf;
    }

    a() {
    }

    public final com.tencent.qqnt.chats.core.adapter.itemdata.g a(RecentContactInfo contact) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(contact, "contact");
        long j3 = contact.contactId;
        int i3 = contact.chatType;
        String peerUid = contact.peerUid;
        String str = contact.avatarPath;
        Intrinsics.checkNotNullExpressionValue(str, "contact.avatarPath");
        g.a aVar = new g.a(0, str, null, null, 13, null);
        boolean z16 = contact.topFlag == 1;
        int i16 = contact.sendStatus;
        boolean z17 = contact.draftFlag == 1;
        ArrayList<Long> nestedSortedContactList = contact.nestedSortedContactList;
        ArrayList<RecentContactInfo> arrayList = contact.nestedChangedList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "contact.nestedChangedList");
        ArrayList arrayList2 = new ArrayList();
        for (RecentContactInfo it : arrayList) {
            a aVar2 = f447051a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.qqnt.chats.core.adapter.itemdata.g a16 = aVar2.a(it);
            if (a16 != null) {
                arrayList2.add(a16);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        boolean z18 = contact.isMsgDisturb;
        long j16 = contact.shieldFlag;
        byte b16 = contact.specialCareFlag;
        long j17 = contact.peerUin;
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        Intrinsics.checkNotNullExpressionValue(nestedSortedContactList, "nestedSortedContactList");
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = new com.tencent.qqnt.chats.core.adapter.itemdata.g(contact, j3, i3, peerUid, aVar, null, null, null, null, null, z16, z17, i16, nestedSortedContactList, arrayList3, z18, j16, b16, j17, false, null, 1573856, null);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        com.tencent.qqnt.chats.data.converter.c cVar = new com.tencent.qqnt.chats.data.converter.c(context);
        List<com.tencent.qqnt.chats.data.converter.g> list = mProcessorList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            ((com.tencent.qqnt.chats.data.converter.g) it5.next()).update(gVar, cVar);
            arrayList4.add(Unit.INSTANCE);
        }
        return gVar;
    }
}
