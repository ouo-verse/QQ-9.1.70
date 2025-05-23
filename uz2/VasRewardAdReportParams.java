package uz2;

import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nBA\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\n\u0010\u0015R\"\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u000f\u0010\u001f\"\u0004\b \u0010!R$\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010$\u001a\u0004\b\u001b\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Luz2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "adSequence", "b", "Z", "isFinished", "()Z", "I", "f", "()I", "rewardType", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "rewardItem", "e", "actionValue", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "()Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "g", "(Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;)V", "adRsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "()Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "setRewardReport", "(Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;)V", "rewardReport", "<init>", "(JZILjava/lang/String;ILcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: uz2.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasRewardAdReportParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long adSequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rewardType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String rewardItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionValue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private vac_adv_get.VacAdvRsp adRsp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private adv_report.RewardReportInfo rewardReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b!\u0010\u0016\"\u0004\b\f\u0010\u0018R\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010$\u001a\u0004\b%\u0010&\"\u0004\b\u0013\u0010'R$\u0010/\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b*\u0010.\u00a8\u00062"}, d2 = {"Luz2/a$a;", "", "Luz2/a;", "a", "", "J", "getAdSequence", "()J", "d", "(J)V", "adSequence", "", "b", "Z", "isFinished", "()Z", "e", "(Z)V", "", "c", "I", "getRewardType", "()I", h.F, "(I)V", "rewardType", "", "Ljava/lang/String;", "getRewardItem", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "rewardItem", "getActionValue", "actionValue", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "getAdRsp", "()Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "(Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;)V", "adRsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "g", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "getRewardReport", "()Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;", "(Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$RewardReportInfo;)V", "rewardReport", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uz2.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C11382a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long adSequence;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isFinished;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int rewardType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int actionValue;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private adv_report.RewardReportInfo rewardReport;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String rewardItem = "";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private vac_adv_get.VacAdvRsp adRsp = new vac_adv_get.VacAdvRsp();

        @NotNull
        public final VasRewardAdReportParams a() {
            return new VasRewardAdReportParams(this.adSequence, this.isFinished, this.rewardType, this.rewardItem, this.actionValue, this.adRsp, this.rewardReport);
        }

        public final void b(int i3) {
            this.actionValue = i3;
        }

        public final void c(@NotNull vac_adv_get.VacAdvRsp vacAdvRsp) {
            Intrinsics.checkNotNullParameter(vacAdvRsp, "<set-?>");
            this.adRsp = vacAdvRsp;
        }

        public final void d(long j3) {
            this.adSequence = j3;
        }

        public final void e(boolean z16) {
            this.isFinished = z16;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rewardItem = str;
        }

        public final void g(@Nullable adv_report.RewardReportInfo rewardReportInfo) {
            this.rewardReport = rewardReportInfo;
        }

        public final void h(int i3) {
            this.rewardType = i3;
        }
    }

    public VasRewardAdReportParams(long j3, boolean z16, int i3, @NotNull String rewardItem, int i16, @NotNull vac_adv_get.VacAdvRsp adRsp, @Nullable adv_report.RewardReportInfo rewardReportInfo) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        Intrinsics.checkNotNullParameter(adRsp, "adRsp");
        this.adSequence = j3;
        this.isFinished = z16;
        this.rewardType = i3;
        this.rewardItem = rewardItem;
        this.actionValue = i16;
        this.adRsp = adRsp;
        this.rewardReport = rewardReportInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionValue() {
        return this.actionValue;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final vac_adv_get.VacAdvRsp getAdRsp() {
        return this.adRsp;
    }

    /* renamed from: c, reason: from getter */
    public final long getAdSequence() {
        return this.adSequence;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRewardItem() {
        return this.rewardItem;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final adv_report.RewardReportInfo getRewardReport() {
        return this.rewardReport;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasRewardAdReportParams)) {
            return false;
        }
        VasRewardAdReportParams vasRewardAdReportParams = (VasRewardAdReportParams) other;
        if (this.adSequence == vasRewardAdReportParams.adSequence && this.isFinished == vasRewardAdReportParams.isFinished && this.rewardType == vasRewardAdReportParams.rewardType && Intrinsics.areEqual(this.rewardItem, vasRewardAdReportParams.rewardItem) && this.actionValue == vasRewardAdReportParams.actionValue && Intrinsics.areEqual(this.adRsp, vasRewardAdReportParams.adRsp) && Intrinsics.areEqual(this.rewardReport, vasRewardAdReportParams.rewardReport)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getRewardType() {
        return this.rewardType;
    }

    public final void g(@NotNull vac_adv_get.VacAdvRsp vacAdvRsp) {
        Intrinsics.checkNotNullParameter(vacAdvRsp, "<set-?>");
        this.adRsp = vacAdvRsp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = androidx.fragment.app.a.a(this.adSequence) * 31;
        boolean z16 = this.isFinished;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((a16 + i3) * 31) + this.rewardType) * 31) + this.rewardItem.hashCode()) * 31) + this.actionValue) * 31) + this.adRsp.hashCode()) * 31;
        adv_report.RewardReportInfo rewardReportInfo = this.rewardReport;
        if (rewardReportInfo == null) {
            hashCode = 0;
        } else {
            hashCode = rewardReportInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "VasRewardAdReportParams(adSequence=" + this.adSequence + ", isFinished=" + this.isFinished + ", rewardType=" + this.rewardType + ", rewardItem=" + this.rewardItem + ", actionValue=" + this.actionValue + ", adRsp=" + this.adRsp + ", rewardReport=" + this.rewardReport + ')';
    }
}
