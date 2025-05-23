package sr0;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lsr0/a;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "Lsr0/a$a;", "Lsr0/a$b;", "Lsr0/a$c;", "Lsr0/a$d;", "Lsr0/a$e;", "Lsr0/a$f;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lsr0/a$a;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "origPath", "b", "Z", "()Z", CustomImageProps.QUALITY, "c", "I", "()I", QCircleLpReportDc010001.KEY_SUBTYPE, "<init>", "(Ljava/lang/String;ZI)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class AIOPicElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String origPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean quality;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int subType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AIOPicElement(@NotNull String origPath, boolean z16, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            this.origPath = origPath;
            this.quality = z16;
            this.subType = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getOrigPath() {
            return this.origPath;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getQuality() {
            return this.quality;
        }

        /* renamed from: c, reason: from getter */
        public final int getSubType() {
            return this.subType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AIOPicElement)) {
                return false;
            }
            AIOPicElement aIOPicElement = (AIOPicElement) other;
            if (Intrinsics.areEqual(this.origPath, aIOPicElement.origPath) && this.quality == aIOPicElement.quality && this.subType == aIOPicElement.subType) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.origPath.hashCode() * 31;
            boolean z16 = this.quality;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.subType;
        }

        @NotNull
        public String toString() {
            return "AIOPicElement(origPath=" + this.origPath + ", quality=" + this.quality + ", subType=" + this.subType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0011\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b/\u0010\u000f\u00a8\u00063"}, d2 = {"Lsr0/a$b;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "c", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "faceType", "b", "k", "faceIndex", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "packId", "d", DomainData.DOMAIN_NAME, NodeProps.CUSTOM_PROP_IMAGE_TYPE, "l", "faceText", "f", "i", "r", "stickerId", "g", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sourceType", "j", ReportConstant.COSTREPORT_PREFIX, com.tencent.luggage.wxa.c8.c.f123402w, "setResultId", "resultId", "getSurpriseId", "setSurpriseId", "surpriseId", "p", "randomType", "<init>", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class FaceElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int faceType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int faceIndex;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String packId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int imageType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String faceText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String stickerId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private int sourceType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private int stickerType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String resultId;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String surpriseId;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private int randomType;

        public FaceElement() {
            this(0, 0, null, 0, null, null, 0, 0, null, null, 0, 2047, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getFaceIndex() {
            return this.faceIndex;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFaceText() {
            return this.faceText;
        }

        /* renamed from: c, reason: from getter */
        public final int getFaceType() {
            return this.faceType;
        }

        /* renamed from: d, reason: from getter */
        public final int getImageType() {
            return this.imageType;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getPackId() {
            return this.packId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FaceElement)) {
                return false;
            }
            FaceElement faceElement = (FaceElement) other;
            if (this.faceType == faceElement.faceType && this.faceIndex == faceElement.faceIndex && Intrinsics.areEqual(this.packId, faceElement.packId) && this.imageType == faceElement.imageType && Intrinsics.areEqual(this.faceText, faceElement.faceText) && Intrinsics.areEqual(this.stickerId, faceElement.stickerId) && this.sourceType == faceElement.sourceType && this.stickerType == faceElement.stickerType && Intrinsics.areEqual(this.resultId, faceElement.resultId) && Intrinsics.areEqual(this.surpriseId, faceElement.surpriseId) && this.randomType == faceElement.randomType) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getRandomType() {
            return this.randomType;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getResultId() {
            return this.resultId;
        }

        /* renamed from: h, reason: from getter */
        public final int getSourceType() {
            return this.sourceType;
        }

        public int hashCode() {
            return (((((((((((((((((((this.faceType * 31) + this.faceIndex) * 31) + this.packId.hashCode()) * 31) + this.imageType) * 31) + this.faceText.hashCode()) * 31) + this.stickerId.hashCode()) * 31) + this.sourceType) * 31) + this.stickerType) * 31) + this.resultId.hashCode()) * 31) + this.surpriseId.hashCode()) * 31) + this.randomType;
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final String getStickerId() {
            return this.stickerId;
        }

        /* renamed from: j, reason: from getter */
        public final int getStickerType() {
            return this.stickerType;
        }

        public final void k(int i3) {
            this.faceIndex = i3;
        }

        public final void l(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.faceText = str;
        }

        public final void m(int i3) {
            this.faceType = i3;
        }

        public final void n(int i3) {
            this.imageType = i3;
        }

        public final void o(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.packId = str;
        }

        public final void p(int i3) {
            this.randomType = i3;
        }

        public final void q(int i3) {
            this.sourceType = i3;
        }

        public final void r(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.stickerId = str;
        }

        public final void s(int i3) {
            this.stickerType = i3;
        }

        @NotNull
        public String toString() {
            return "FaceElement(faceType=" + this.faceType + ", faceIndex=" + this.faceIndex + ", packId=" + this.packId + ", imageType=" + this.imageType + ", faceText=" + this.faceText + ", stickerId=" + this.stickerId + ", sourceType=" + this.sourceType + ", stickerType=" + this.stickerType + ", resultId=" + this.resultId + ", surpriseId=" + this.surpriseId + ", randomType=" + this.randomType + ")";
        }

        public /* synthetic */ FaceElement(int i3, int i16, String str, int i17, String str2, String str3, int i18, int i19, String str4, String str5, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
            this((i27 & 1) != 0 ? 0 : i3, (i27 & 2) != 0 ? 0 : i16, (i27 & 4) != 0 ? "" : str, (i27 & 8) != 0 ? 0 : i17, (i27 & 16) != 0 ? "" : str2, (i27 & 32) != 0 ? "" : str3, (i27 & 64) != 0 ? 0 : i18, (i27 & 128) != 0 ? 0 : i19, (i27 & 256) != 0 ? "" : str4, (i27 & 512) == 0 ? str5 : "", (i27 & 1024) == 0 ? i26 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FaceElement(int i3, int i16, @NotNull String packId, int i17, @NotNull String faceText, @NotNull String stickerId, int i18, int i19, @NotNull String resultId, @NotNull String surpriseId, int i26) {
            super(null);
            Intrinsics.checkNotNullParameter(packId, "packId");
            Intrinsics.checkNotNullParameter(faceText, "faceText");
            Intrinsics.checkNotNullParameter(stickerId, "stickerId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(surpriseId, "surpriseId");
            this.faceType = i3;
            this.faceIndex = i16;
            this.packId = packId;
            this.imageType = i17;
            this.faceText = faceText;
            this.stickerId = stickerId;
            this.sourceType = i18;
            this.stickerType = i19;
            this.resultId = resultId;
            this.surpriseId = surpriseId;
            this.randomType = i26;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lsr0/a$c;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "origPath", "<init>", "(Ljava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$c, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class FileElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String origPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileElement(@NotNull String origPath) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            this.origPath = origPath;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getOrigPath() {
            return this.origPath;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FileElement) && Intrinsics.areEqual(this.origPath, ((FileElement) other).origPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.origPath.hashCode();
        }

        @NotNull
        public String toString() {
            return "FileElement(origPath=" + this.origPath + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lsr0/a$d;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "replyMsgId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "replyNick", "replyContent", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$d, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ReplyElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long replyMsgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyNick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplyElement(long j3, @NotNull String replyNick, @NotNull String replyContent) {
            super(null);
            Intrinsics.checkNotNullParameter(replyNick, "replyNick");
            Intrinsics.checkNotNullParameter(replyContent, "replyContent");
            this.replyMsgId = j3;
            this.replyNick = replyNick;
            this.replyContent = replyContent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getReplyContent() {
            return this.replyContent;
        }

        /* renamed from: b, reason: from getter */
        public final long getReplyMsgId() {
            return this.replyMsgId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getReplyNick() {
            return this.replyNick;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyElement)) {
                return false;
            }
            ReplyElement replyElement = (ReplyElement) other;
            if (this.replyMsgId == replyElement.replyMsgId && Intrinsics.areEqual(this.replyNick, replyElement.replyNick) && Intrinsics.areEqual(this.replyContent, replyElement.replyContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(this.replyMsgId) * 31) + this.replyNick.hashCode()) * 31) + this.replyContent.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReplyElement(replyMsgId=" + this.replyMsgId + ", replyNick=" + this.replyNick + ", replyContent=" + this.replyContent + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b\n\u0010\"\"\u0004\b#\u0010$R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lsr0/a$e;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "content", "b", "I", "e", "()I", "atType", "", "c", "J", "f", "()J", "atUid", "d", "atTinyId", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setAtRoleId", "(Ljava/lang/Long;)V", "atRoleId", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setAtRoleColor", "(Ljava/lang/Integer;)V", "atRoleColor", "setAtRoleName", "(Ljava/lang/String;)V", "atRoleName", "<init>", "(Ljava/lang/String;IJJLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$e, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class TextElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int atType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long atUid;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long atTinyId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Long atRoleId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Integer atRoleColor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String atRoleName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextElement(@NotNull String content, int i3, long j3, long j16, @Nullable Long l3, @Nullable Integer num, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.atType = i3;
            this.atUid = j3;
            this.atTinyId = j16;
            this.atRoleId = l3;
            this.atRoleColor = num;
            this.atRoleName = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getAtRoleColor() {
            return this.atRoleColor;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Long getAtRoleId() {
            return this.atRoleId;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getAtRoleName() {
            return this.atRoleName;
        }

        /* renamed from: d, reason: from getter */
        public final long getAtTinyId() {
            return this.atTinyId;
        }

        /* renamed from: e, reason: from getter */
        public final int getAtType() {
            return this.atType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextElement)) {
                return false;
            }
            TextElement textElement = (TextElement) other;
            if (Intrinsics.areEqual(this.content, textElement.content) && this.atType == textElement.atType && this.atUid == textElement.atUid && this.atTinyId == textElement.atTinyId && Intrinsics.areEqual(this.atRoleId, textElement.atRoleId) && Intrinsics.areEqual(this.atRoleColor, textElement.atRoleColor) && Intrinsics.areEqual(this.atRoleName, textElement.atRoleName)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getAtUid() {
            return this.atUid;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = ((((((this.content.hashCode() * 31) + this.atType) * 31) + androidx.fragment.app.a.a(this.atUid)) * 31) + androidx.fragment.app.a.a(this.atTinyId)) * 31;
            Long l3 = this.atRoleId;
            int i3 = 0;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            Integer num = this.atRoleColor;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str = this.atRoleName;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "TextElement(content=" + this.content + ", atType=" + this.atType + ", atUid=" + this.atUid + ", atTinyId=" + this.atTinyId + ", atRoleId=" + this.atRoleId + ", atRoleColor=" + this.atRoleColor + ", atRoleName=" + this.atRoleName + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lsr0/a$f;", "Lsr0/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "origPath", "b", "I", "c", "()I", "subBusiType", "Z", "()Z", CustomImageProps.QUALITY, "d", "thumbPath", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sr0.a$f, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class VideoElement extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String origPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int subBusiType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean quality;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String thumbPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoElement(@NotNull String origPath, int i3, boolean z16, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            this.origPath = origPath;
            this.subBusiType = i3;
            this.quality = z16;
            this.thumbPath = str;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getOrigPath() {
            return this.origPath;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getQuality() {
            return this.quality;
        }

        /* renamed from: c, reason: from getter */
        public final int getSubBusiType() {
            return this.subBusiType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getThumbPath() {
            return this.thumbPath;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoElement)) {
                return false;
            }
            VideoElement videoElement = (VideoElement) other;
            if (Intrinsics.areEqual(this.origPath, videoElement.origPath) && this.subBusiType == videoElement.subBusiType && this.quality == videoElement.quality && Intrinsics.areEqual(this.thumbPath, videoElement.thumbPath)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.origPath.hashCode() * 31) + this.subBusiType) * 31;
            boolean z16 = this.quality;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            String str = this.thumbPath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i16 + hashCode;
        }

        @NotNull
        public String toString() {
            return "VideoElement(origPath=" + this.origPath + ", subBusiType=" + this.subBusiType + ", quality=" + this.quality + ", thumbPath=" + this.thumbPath + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
