package sk0;

import android.content.Context;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import dl0.d;
import dl0.g;
import dl0.k;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0019\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u000e\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b\u0014\u0010#\u00a8\u0006'"}, d2 = {"Lsk0/a;", "", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "f", "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "", "b", "Z", "()Z", "enableTouch", "Landroid/content/Context;", "c", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "viewContext", "", "d", "I", "()I", "fps", "Ldl0/k;", "e", "Ldl0/k;", "()Ldl0/k;", "toggleProxy", "Ldl0/d;", "Ldl0/d;", "()Ldl0/d;", "loadSoProxy", "Ldl0/g;", "Ldl0/g;", "()Ldl0/g;", "qqmcProxy", "<init>", "(Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;ZLandroid/content/Context;ILdl0/k;Ldl0/d;Ldl0/g;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean enableTouch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context viewContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int fps;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final k toggleProxy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d loadSoProxy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final g qqmcProxy;

    @JvmOverloads
    public a(@NotNull FilamentUrlTemplate urlTemplate, boolean z16, @NotNull Context viewContext, int i3, @Nullable k kVar, @Nullable d dVar, @Nullable g gVar) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(viewContext, "viewContext");
        this.urlTemplate = urlTemplate;
        this.enableTouch = z16;
        this.viewContext = viewContext;
        this.fps = i3;
        this.toggleProxy = kVar;
        this.loadSoProxy = dVar;
        this.qqmcProxy = gVar;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableTouch() {
        return this.enableTouch;
    }

    /* renamed from: b, reason: from getter */
    public final int getFps() {
        return this.fps;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final d getLoadSoProxy() {
        return this.loadSoProxy;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final g getQqmcProxy() {
        return this.qqmcProxy;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final k getToggleProxy() {
        return this.toggleProxy;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final FilamentUrlTemplate getUrlTemplate() {
        return this.urlTemplate;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final Context getViewContext() {
        return this.viewContext;
    }

    public /* synthetic */ a(FilamentUrlTemplate filamentUrlTemplate, boolean z16, Context context, int i3, k kVar, d dVar, g gVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(filamentUrlTemplate, z16, context, (i16 & 8) != 0 ? 15 : i3, (i16 & 16) != 0 ? null : kVar, (i16 & 32) != 0 ? null : dVar, (i16 & 64) != 0 ? null : gVar);
    }
}
