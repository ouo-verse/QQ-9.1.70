package um4;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.SafeOuterClass$GetUserPrivIdRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lum4/i;", "", "Lum4/i$a;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f439236a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lum4/i$a;", "", "", "show", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a();

        void show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"um4/i$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/SafeOuterClass$GetUserPrivIdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<SafeOuterClass$GetUserPrivIdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f439237a;

        b(a aVar) {
            this.f439237a = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable SafeOuterClass$GetUserPrivIdRsp result) {
            List<Integer> list;
            PBRepeatField<Integer> pBRepeatField;
            if (result != null && (pBRepeatField = result.priv_id_list) != null) {
                list = pBRepeatField.get();
            } else {
                list = null;
            }
            l.a("GiftTeamManager_", 1, "GetUserPrivIdRsp succeed " + list);
            if (result != null && result.priv_id_list.get().contains(11)) {
                this.f439237a.show();
            } else {
                this.f439237a.a();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.c("GiftTeamManager_", 1, "GetUserPrivIdRsp onError " + errorCode + " " + errorMessage);
            this.f439237a.a();
        }
    }

    i() {
    }

    public final void a(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((bo4.d) mm4.b.b(bo4.d.class)).n3(new b(callback));
    }
}
