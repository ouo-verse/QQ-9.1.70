package wx0;

import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lwx0/a;", "Ltx0/b;", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "a", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "v2TIMGroupListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltx0/a;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "groupListeners", "<init>", "()V", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements tx0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V2TIMGroupListener v2TIMGroupListener = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<tx0.a> groupListeners = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"wx0/a$b", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "", "groupID", "", "onGroupCreated", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "opUser", "onGroupDismissed", "", "memberList", "onMemberKicked", "onMemberInvited", "member", "onMemberLeave", "", "customData", "onReceiveRESTCustomData", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends V2TIMGroupListener {
        b() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onGroupCreated(@Nullable String groupID) {
            g.h("ICGameGroupManager", "onGroupCreated: " + groupID);
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onGroupDismissed(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            g.h("ICGameGroupManager", "onGroupDismissed: " + groupID);
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                Iterator it = a.this.groupListeners.iterator();
                while (it.hasNext()) {
                    ((tx0.a) it.next()).b(data, new wx0.b(opUser));
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberInvited(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser, @NotNull List<V2TIMGroupMemberInfo> memberList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                for (tx0.a aVar : a.this.groupListeners) {
                    wx0.b bVar = new wx0.b(opUser);
                    List<V2TIMGroupMemberInfo> list = memberList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new wx0.b((V2TIMGroupMemberInfo) it.next()));
                    }
                    aVar.a(data, bVar, arrayList);
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberKicked(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser, @NotNull List<V2TIMGroupMemberInfo> memberList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            g.h("ICGameGroupManager", "onMemberKicked: " + groupID);
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                for (tx0.a aVar : a.this.groupListeners) {
                    wx0.b bVar = new wx0.b(opUser);
                    List<V2TIMGroupMemberInfo> list = memberList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new wx0.b((V2TIMGroupMemberInfo) it.next()));
                    }
                    aVar.c(data, bVar, arrayList);
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberLeave(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo member) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(member, "member");
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                Iterator it = a.this.groupListeners.iterator();
                while (it.hasNext()) {
                    ((tx0.a) it.next()).d(data, new wx0.b(member));
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onReceiveRESTCustomData(@NotNull String groupID, @Nullable byte[] customData) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            super.onReceiveRESTCustomData(groupID, customData);
            g.a("ICGameGroupManager", "onReceiveRESTCustomData() called with: groupID = [" + groupID + "]");
            try {
                MessageOuterClass$TimMsgBody timMsg = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(customData, 0));
                sx0.b bVar = (sx0.b) qx0.a.b(sx0.b.class);
                Intrinsics.checkNotNullExpressionValue(timMsg, "timMsg");
                bVar.S0(groupID, timMsg);
            } catch (InvalidProtocolBufferMicroException e16) {
                g.e("ICGameGroupManager", "onReceiveRESTCustomData error", e16);
            }
        }
    }
}
