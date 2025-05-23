package ya2;

import com.tencent.mobileqq.nearbypro.base.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yr4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lya2/a;", "a", "Lya2/a;", "()Lya2/a;", "NormalChatParser", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ya2.a f449933a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"ya2/c$a", "Lya2/a;", "", "templateId", "", "body", "a", "Ljava/lang/String;", "TAG", "b", "TEMPLATE_ID", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements ya2.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String TAG = "ChatLandNormalChatMsgItemViewFactory";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String TEMPLATE_ID = "room_normal_chat";

        a() {
        }

        @Override // ya2.a
        @NotNull
        public String a(@Nullable byte[] body) {
            try {
                byte[] bArr = e.c(body).f451110d;
                Intrinsics.checkNotNullExpressionValue(bArr, "parseFrom(body).text");
                return new String(bArr, Charsets.UTF_8);
            } catch (Exception e16) {
                j.c().d(this.TAG, "failed to parse body: " + e16);
                return "";
            }
        }

        @Override // ya2.a
        @NotNull
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    }

    @NotNull
    public static final ya2.a a() {
        return f449933a;
    }
}
