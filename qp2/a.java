package qp2;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b$\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010(\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b#\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u0010+\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0006\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0006\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0006\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b5\u0010\tR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0006\u001a\u0004\b&\u0010\u0007\"\u0004\b8\u0010\tR\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b7\u0010\u0007\"\u0004\b:\u0010\t\u00a8\u0006>"}, d2 = {"Lqp2/a;", "", "", "p", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "boxInfo", "b", "d", "t", "docInfo", "c", "f", "v", "itemInfo", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "searchId", "e", "g", "w", "parentSearchId", "", "I", "k", "()I", "B", "(I)V", QCircleLpReportDc010001.KEY_SUBTYPE, "r", "businessType", h.F, ReportConstant.COSTREPORT_PREFIX, "docId", "i", HippyTKDListViewAdapter.X, RemoteProxy.KEY_RESULT_TYPE, "getSerialNumber", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "serialNumber", "l", BdhLogUtil.LogTag.Tag_Conn, "svrBoxExtInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "svrDocExtInfo", DomainData.DOMAIN_NAME, "E", "svrItemExtInfo", "u", "extBackComm", "o", "y", "searchAdExtraData", UserInfo.SEX_FEMALE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "<init>", "()V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String boxInfo = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String docInfo = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String itemInfo = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String parentSearchId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int subType = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int businessType = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String docId = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int resultType = -1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int serialNumber = -1;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String svrBoxExtInfo = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String svrDocExtInfo = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String svrItemExtInfo = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String extBackComm = "";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchAdExtraData = "";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uniqueId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lqp2/a$a;", "", "", "input", "Lqp2/a;", "a", "<init>", "()V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qp2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final a a(@NotNull String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (TextUtils.isEmpty(input)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(input);
                a aVar = new a();
                String optString = jSONObject.optString("boxInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"boxInfo\", \"\")");
                aVar.q(optString);
                String optString2 = jSONObject.optString("docInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"docInfo\", \"\")");
                aVar.t(optString2);
                String optString3 = jSONObject.optString("itemInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"itemInfo\", \"\")");
                aVar.v(optString3);
                String optString4 = jSONObject.optString("searchId", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"searchId\", \"\")");
                aVar.z(optString4);
                String optString5 = jSONObject.optString("parentSearchId", "");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"parentSearchId\", \"\")");
                aVar.w(optString5);
                aVar.B(jSONObject.optInt(QCircleLpReportDc010001.KEY_SUBTYPE, -1));
                aVar.r(jSONObject.optInt("businessType", -1));
                String optString6 = jSONObject.optString("docId", "");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"docId\", \"\")");
                aVar.s(optString6);
                aVar.x(jSONObject.optInt(RemoteProxy.KEY_RESULT_TYPE, -1));
                aVar.A(jSONObject.optInt("serial_number", -1));
                String optString7 = jSONObject.optString("svrBoxExtInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"svrBoxExtInfo\", \"\")");
                aVar.C(optString7);
                String optString8 = jSONObject.optString("svrDocExtInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"svrDocExtInfo\", \"\")");
                aVar.D(optString8);
                String optString9 = jSONObject.optString("svrItemExtInfo", "");
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"svrItemExtInfo\", \"\")");
                aVar.E(optString9);
                String optString10 = jSONObject.optString("extBackComm", "");
                Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(\"extBackComm\", \"\")");
                aVar.u(optString10);
                String optString11 = jSONObject.optString("searchAdExtraData", "");
                Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"searchAdExtraData\", \"\")");
                aVar.y(optString11);
                String optString12 = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, aVar.getDocId());
                Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(\"uniqueId\", docId)");
                aVar.F(optString12);
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }

        Companion() {
        }
    }

    public final void A(int i3) {
        this.serialNumber = i3;
    }

    public final void B(int i3) {
        this.subType = i3;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrBoxExtInfo = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrDocExtInfo = str;
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrItemExtInfo = str;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uniqueId = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBoxInfo() {
        return this.boxInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDocInfo() {
        return this.docInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getExtBackComm() {
        return this.extBackComm;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getItemInfo() {
        return this.itemInfo;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getParentSearchId() {
        return this.parentSearchId;
    }

    /* renamed from: h, reason: from getter */
    public final int getResultType() {
        return this.resultType;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getSearchAdExtraData() {
        return this.searchAdExtraData;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSearchId() {
        return this.searchId;
    }

    /* renamed from: k, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getSvrBoxExtInfo() {
        return this.svrBoxExtInfo;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getSvrDocExtInfo() {
        return this.svrDocExtInfo;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSvrItemExtInfo() {
        return this.svrItemExtInfo;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean p() {
        if (this.docId.length() > 0) {
            return true;
        }
        return false;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.boxInfo = str;
    }

    public final void r(int i3) {
        this.businessType = i3;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.docId = str;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.docInfo = str;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extBackComm = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemInfo = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentSearchId = str;
    }

    public final void x(int i3) {
        this.resultType = i3;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchAdExtraData = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchId = str;
    }
}
