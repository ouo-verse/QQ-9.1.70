package qa2;

import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import op4.d;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sp4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lqa2/a;", "", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "a", "Lop4/i;", "", "myLike", "", "Lsp4/c;", "b", "(Lop4/i;I)[Lsp4/c;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f428765a = new a();

    a() {
    }

    @Nullable
    public final SelfUserInfo a() {
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null) {
            return f16.getSelfUserInfo();
        }
        return null;
    }

    @Nullable
    public final c[] b(@NotNull i iVar, int i3) {
        boolean z16;
        Object[] plus;
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        d dVar = iVar.f423359i;
        c[] cVarArr = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.f423312c == null) {
            dVar.f423312c = new c[0];
        }
        SelfUserInfo a16 = a();
        if (a16 != null) {
            if (i3 == 1) {
                d dVar2 = iVar.f423359i;
                c cVar = new c();
                cVar.f434140a = a16.getTid();
                cVar.f434143d = a16.getNickName();
                cVar.f434145f = a16.getAvatarUrl();
                Unit unit = Unit.INSTANCE;
                c[] cVarArr2 = iVar.f423359i.f423312c;
                Intrinsics.checkNotNullExpressionValue(cVarArr2, "likeInfo.likedUsers");
                plus = ArraysKt___ArraysJvmKt.plus((Object[]) new c[]{cVar}, (Object[]) cVarArr2);
                dVar2.f423312c = (c[]) plus;
            } else {
                d dVar3 = iVar.f423359i;
                c[] likedUsers = dVar3.f423312c;
                if (likedUsers != null) {
                    Intrinsics.checkNotNullExpressionValue(likedUsers, "likedUsers");
                    ArrayList arrayList = new ArrayList();
                    for (c cVar2 : likedUsers) {
                        if (cVar2.f434140a != a16.getTid()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            arrayList.add(cVar2);
                        }
                    }
                    Object[] array = arrayList.toArray(new c[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    cVarArr = (c[]) array;
                }
                dVar3.f423312c = cVarArr;
            }
        }
        d dVar4 = iVar.f423359i;
        dVar4.f423313d = i3;
        return dVar4.f423312c;
    }
}
