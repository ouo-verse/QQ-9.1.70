package xa1;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 *2\u00020\u0001:\u0001\u0005Bu\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u00100\u001a\u00020\f\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b%\u0010\nR\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b(\u0010\nR\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b*\u0010\u0012R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b,\u0010\nR\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012\u00a8\u00063"}, d2 = {"Lxa1/e;", "", "", "toString", "", "a", "I", "d", "()I", DomainData.DOMAIN_NAME, "(I)V", "encodeType", "", "b", "Z", "e", "()Z", "o", "(Z)V", "ipConnect", "c", "g", "r", "needReportPlaySuccess", "i", "t", "useSticker", "getNeedCheckMp4TrackCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "needCheckMp4TrackCount", "", "f", "J", "()J", "p", "(J)V", "mp4FileSizeLimit", "k", "aaType", h.F, "j", "aaLevel", "l", "canCodecReUse", ReportConstant.COSTREPORT_PREFIX, "softEncodeMode", "getDoubleUserRecordUseV2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "doubleUserRecordUseV2", "<init>", "(IZZZZJIIZIZ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int encodeType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean ipConnect;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean needReportPlaySuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean useSticker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needCheckMp4TrackCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mp4FileSizeLimit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int aaType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int aaLevel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean canCodecReUse;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int softEncodeMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean doubleUserRecordUseV2;

    public e(int i3, boolean z16, boolean z17, boolean z18, boolean z19, long j3, int i16, int i17, boolean z26, int i18, boolean z27) {
        this.encodeType = i3;
        this.ipConnect = z16;
        this.needReportPlaySuccess = z17;
        this.useSticker = z18;
        this.needCheckMp4TrackCount = z19;
        this.mp4FileSizeLimit = j3;
        this.aaType = i16;
        this.aaLevel = i17;
        this.canCodecReUse = z26;
        this.softEncodeMode = i18;
        this.doubleUserRecordUseV2 = z27;
    }

    /* renamed from: a, reason: from getter */
    public final int getAaLevel() {
        return this.aaLevel;
    }

    /* renamed from: b, reason: from getter */
    public final int getAaType() {
        return this.aaType;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCanCodecReUse() {
        return this.canCodecReUse;
    }

    /* renamed from: d, reason: from getter */
    public final int getEncodeType() {
        return this.encodeType;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIpConnect() {
        return this.ipConnect;
    }

    /* renamed from: f, reason: from getter */
    public final long getMp4FileSizeLimit() {
        return this.mp4FileSizeLimit;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNeedReportPlaySuccess() {
        return this.needReportPlaySuccess;
    }

    /* renamed from: h, reason: from getter */
    public final int getSoftEncodeMode() {
        return this.softEncodeMode;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getUseSticker() {
        return this.useSticker;
    }

    public final void j(int i3) {
        this.aaLevel = i3;
    }

    public final void k(int i3) {
        this.aaType = i3;
    }

    public final void l(boolean z16) {
        this.canCodecReUse = z16;
    }

    public final void m(boolean z16) {
        this.doubleUserRecordUseV2 = z16;
    }

    public final void n(int i3) {
        this.encodeType = i3;
    }

    public final void o(boolean z16) {
        this.ipConnect = z16;
    }

    public final void p(long j3) {
        this.mp4FileSizeLimit = j3;
    }

    public final void q(boolean z16) {
        this.needCheckMp4TrackCount = z16;
    }

    public final void r(boolean z16) {
        this.needReportPlaySuccess = z16;
    }

    public final void s(int i3) {
        this.softEncodeMode = i3;
    }

    public final void t(boolean z16) {
        this.useSticker = z16;
    }

    @NotNull
    public String toString() {
        String str = "VasZplanSquareConfig:\nencodeType: " + this.encodeType + "\nipConnect: " + this.ipConnect + "\nneedReportPlaySuccess" + this.needReportPlaySuccess + "\nuseSticker: " + this.useSticker + "\nneedCheckMp4TrackCount: " + this.needCheckMp4TrackCount + "\nmp4FileSizeLimit: " + this.mp4FileSizeLimit + "\naaType: " + this.aaType + "\naaLevel: " + this.aaLevel + "\ncanCodecReUse: " + this.canCodecReUse + "\nsoftEncodeMode: " + this.softEncodeMode + "\ndoubleUserRecordUseV2: " + this.doubleUserRecordUseV2;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026)\n            .toString()");
        return str;
    }

    public /* synthetic */ e(int i3, boolean z16, boolean z17, boolean z18, boolean z19, long j3, int i16, int i17, boolean z26, int i18, boolean z27, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 1 : i3, (i19 & 2) != 0 ? false : z16, (i19 & 4) != 0 ? false : z17, (i19 & 8) != 0 ? false : z18, (i19 & 16) == 0 ? z19 : true, (i19 & 32) != 0 ? -1L : j3, (i19 & 64) != 0 ? 4 : i16, (i19 & 128) != 0 ? 3 : i17, (i19 & 256) != 0 ? false : z26, (i19 & 512) != 0 ? 0 : i18, (i19 & 1024) == 0 ? z27 : false);
    }
}
