package sg3;

import com.tencent.mobileqq.vas.banner.c;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lsg3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "secretId", "", "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", "signatures", "", "c", "J", "()J", "signatureBegin", "d", "signatureEnd", "f", "token", "cosDir", "<init>", "(Ljava/lang/String;[Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sg3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanCosUGCAvatarKeyInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String secretId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String[] signatures;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long signatureBegin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long signatureEnd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String token;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cosDir;

    public ZPlanCosUGCAvatarKeyInfo(String secretId, String[] signatures, long j3, long j16, String token, String cosDir) {
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(cosDir, "cosDir");
        this.secretId = secretId;
        this.signatures = signatures;
        this.signatureBegin = j3;
        this.signatureEnd = j16;
        this.token = token;
        this.cosDir = cosDir;
    }

    /* renamed from: a, reason: from getter */
    public final String getCosDir() {
        return this.cosDir;
    }

    /* renamed from: b, reason: from getter */
    public final String getSecretId() {
        return this.secretId;
    }

    /* renamed from: c, reason: from getter */
    public final long getSignatureBegin() {
        return this.signatureBegin;
    }

    /* renamed from: d, reason: from getter */
    public final long getSignatureEnd() {
        return this.signatureEnd;
    }

    /* renamed from: e, reason: from getter */
    public final String[] getSignatures() {
        return this.signatures;
    }

    /* renamed from: f, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((((((this.secretId.hashCode() * 31) + Arrays.hashCode(this.signatures)) * 31) + c.a(this.signatureBegin)) * 31) + c.a(this.signatureEnd)) * 31) + this.token.hashCode()) * 31) + this.cosDir.hashCode();
    }

    public String toString() {
        return "ZPlanCosUGCAvatarKeyInfo(secretId=" + this.secretId + ", signatures=" + Arrays.toString(this.signatures) + ", signatureBegin=" + this.signatureBegin + ", signatureEnd=" + this.signatureEnd + ", token=" + this.token + ", cosDir=" + this.cosDir + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanCosUGCAvatarKeyInfo)) {
            return false;
        }
        ZPlanCosUGCAvatarKeyInfo zPlanCosUGCAvatarKeyInfo = (ZPlanCosUGCAvatarKeyInfo) other;
        return Intrinsics.areEqual(this.secretId, zPlanCosUGCAvatarKeyInfo.secretId) && Intrinsics.areEqual(this.signatures, zPlanCosUGCAvatarKeyInfo.signatures) && this.signatureBegin == zPlanCosUGCAvatarKeyInfo.signatureBegin && this.signatureEnd == zPlanCosUGCAvatarKeyInfo.signatureEnd && Intrinsics.areEqual(this.token, zPlanCosUGCAvatarKeyInfo.token) && Intrinsics.areEqual(this.cosDir, zPlanCosUGCAvatarKeyInfo.cosDir);
    }
}
