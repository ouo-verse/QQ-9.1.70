package ua4;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00188\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\t\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u0011\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\u000e\u0010\"\u00a8\u0006&"}, d2 = {"Lua4/a;", "", "", h.F, "i", "", "width", "j", "", "a", UserInfo.SEX_FEMALE, "f", "()F", "tilt", "b", "g", "tiltTan", "c", "I", "d", "()I", "repeatCount", "e", "repeatMode", "", "J", "()J", "animationDuration", "", "[F", "()[F", "positions", "", "[I", "()[I", NodeProps.COLORS, "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float tilt = 20.0f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float tiltTan = (float) Math.tan(Math.toRadians(20.0f));

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int repeatCount = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int repeatMode = 1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long animationDuration = 1000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float[] positions = new float[4];

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int[] colors = new int[4];

    public a() {
        h();
        i();
    }

    private final void h() {
        int[] iArr = this.colors;
        iArr[0] = -1;
        iArr[1] = 1291845631;
        iArr[2] = 1291845631;
        iArr[3] = -1;
    }

    private final void i() {
        this.positions[0] = Math.max(0.25f, 0.0f);
        this.positions[1] = Math.max(0.4995f, 0.0f);
        this.positions[2] = Math.min(0.5005f, 1.0f);
        this.positions[3] = Math.min(0.75f, 1.0f);
    }

    /* renamed from: a, reason: from getter */
    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    /* renamed from: b, reason: from getter */
    public final int[] getColors() {
        return this.colors;
    }

    /* renamed from: c, reason: from getter */
    public final float[] getPositions() {
        return this.positions;
    }

    /* renamed from: d, reason: from getter */
    public final int getRepeatCount() {
        return this.repeatCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getRepeatMode() {
        return this.repeatMode;
    }

    /* renamed from: f, reason: from getter */
    public final float getTilt() {
        return this.tilt;
    }

    /* renamed from: g, reason: from getter */
    public final float getTiltTan() {
        return this.tiltTan;
    }

    public final int j(int width) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(width * 1.0f);
        return roundToInt;
    }
}
