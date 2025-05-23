package uo3;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import zo3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u00002\u00020\u0001B7\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001b\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Luo3/a;", "Lzo3/g;", "", "Lcom/tencent/ntcompose/foundation/shape/CornerSize;", "a", UserInfo.SEX_FEMALE, "d", "()F", "topStart", "b", "c", "topEnd", "bottomEnd", "bottomStart", "<init>", "(FFFF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float topStart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float topEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float bottomEnd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float bottomStart;

    public a(float f16, float f17, float f18, float f19) {
        this.topStart = f16;
        this.topEnd = f17;
        this.bottomEnd = f18;
        this.bottomStart = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getBottomEnd() {
        return this.bottomEnd;
    }

    /* renamed from: b, reason: from getter */
    public final float getBottomStart() {
        return this.bottomStart;
    }

    /* renamed from: c, reason: from getter */
    public final float getTopEnd() {
        return this.topEnd;
    }

    /* renamed from: d, reason: from getter */
    public final float getTopStart() {
        return this.topStart;
    }
}
