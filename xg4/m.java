package xg4;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010$\u001a\u00020 \u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0013\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\u00a8\u0006'"}, d2 = {"Lxg4/m;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Lxg4/n;", "Lxg4/n;", "()Lxg4/n;", "callback", "", "c", "J", "f", "()J", "scene", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "inputEditText", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "e", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "()Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "inputView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "pageRoot", "", "g", "I", "()I", "yesGameId", "<init>", "(Landroid/content/Context;Lxg4/n;JLandroid/widget/EditText;Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;Landroid/view/ViewGroup;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final n callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final EditText inputEditText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TimiBaseInputViewV2 inputView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ViewGroup pageRoot;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int yesGameId;

    public m(@NotNull Context context, @Nullable n nVar, long j3, @Nullable EditText editText, @Nullable TimiBaseInputViewV2 timiBaseInputViewV2, @Nullable ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.callback = nVar;
        this.scene = j3;
        this.inputEditText = editText;
        this.inputView = timiBaseInputViewV2;
        this.pageRoot = viewGroup;
        this.yesGameId = i3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final n getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final EditText getInputEditText() {
        return this.inputEditText;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final TimiBaseInputViewV2 getInputView() {
        return this.inputView;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final ViewGroup getPageRoot() {
        return this.pageRoot;
    }

    /* renamed from: f, reason: from getter */
    public final long getScene() {
        return this.scene;
    }

    /* renamed from: g, reason: from getter */
    public final int getYesGameId() {
        return this.yesGameId;
    }

    public /* synthetic */ m(Context context, n nVar, long j3, EditText editText, TimiBaseInputViewV2 timiBaseInputViewV2, ViewGroup viewGroup, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : nVar, (i16 & 4) != 0 ? 1L : j3, (i16 & 8) != 0 ? null : editText, (i16 & 16) != 0 ? null : timiBaseInputViewV2, (i16 & 32) == 0 ? viewGroup : null, (i16 & 64) != 0 ? -1 : i3);
    }
}
