package ro1;

import android.view.View;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lro1/b;", "", "", "channelId", "c", "", c.G, "f", "sessionId", "g", "roomId", "e", "cardType", "b", "coverState", "d", "Lro1/a;", "a", "Landroid/view/View;", "Landroid/view/View;", "view", "Ljava/lang/String;", "I", "liveRoomId", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int pos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sessionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String liveRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int cardType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int coverState;

    public b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.channelId = "";
        this.pos = -1;
        this.sessionId = "";
        this.liveRoomId = "";
        this.cardType = -1;
        this.coverState = -1;
    }

    @NotNull
    public LiveAudioReport a() {
        LiveAudioReport liveAudioReport = new LiveAudioReport(this.view);
        liveAudioReport.b(this.channelId);
        liveAudioReport.f(this.pos);
        liveAudioReport.g(this.sessionId);
        liveAudioReport.e(this.liveRoomId);
        liveAudioReport.a(this.cardType);
        liveAudioReport.c(this.coverState);
        return liveAudioReport;
    }

    @NotNull
    public b b(int cardType) {
        this.cardType = cardType;
        return this;
    }

    @NotNull
    public b c(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.channelId = channelId;
        return this;
    }

    @NotNull
    public b d(int coverState) {
        this.coverState = coverState;
        return this;
    }

    @NotNull
    public b e(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.liveRoomId = roomId;
        return this;
    }

    @NotNull
    public b f(int pos) {
        this.pos = pos;
        return this;
    }

    @NotNull
    public b g(@NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }
}
