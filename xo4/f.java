package xo4;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lxo4/f;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "b", "c", "a", "<init>", "()V", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class f extends av {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lxo4/f$a;", "", "Lcom/tencent/mobileqq/utils/ax;", "action", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xo4.f$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull ax action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return Intrinsics.areEqual("1", action.f("back_feedlist"));
        }

        Companion() {
        }
    }

    private final ax b(BaseQQAppInterface app, Context context, String jump, JumpParserResult jumpParserResult) {
        ax axVar = null;
        if (jumpParserResult != null) {
            String action = jumpParserResult.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -2062494842) {
                    if (hashCode != -398937817) {
                        if (hashCode == 1984635193 && action.equals("openfeeddetail")) {
                            axVar = new c(app, context);
                        }
                    } else if (action.equals("openfeedpublish")) {
                        axVar = c(app, context, jumpParserResult);
                    }
                } else if (action.equals("openfeedlist")) {
                    axVar = new e(app, context);
                }
            }
            if (axVar != null) {
                axVar.f307439d = jumpParserResult.getServer();
                axVar.f307440e = jumpParserResult.getAction();
                axVar.s(jumpParserResult.getParamMap());
            }
        }
        if (axVar == null) {
            return new e(app, context);
        }
        return axVar;
    }

    private final ax c(BaseQQAppInterface app, Context context, JumpParserResult jumpParserResult) {
        d dVar = new d(app, context);
        dVar.s(jumpParserResult.getParamMap());
        if (dVar.J()) {
            return new d(app, context);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    @NotNull
    public ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @Nullable String jump, @Nullable JumpParserResult jumpParserResult) {
        return b(app, context, jump, jumpParserResult);
    }
}
