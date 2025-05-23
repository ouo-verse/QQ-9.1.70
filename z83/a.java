package z83;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.utils.ak;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 m2\u00020\u0001:\u0001nB\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0002\u001a\u00020\u0000H\u0016R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\"\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\"\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\"\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\"\u0010'\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"\u0004\b\u0005\u0010\tR*\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010*\u001a\u0004\b\u0019\u0010,\"\u0004\b0\u0010.R*\u00108\u001a\u0002022\u0006\u0010)\u001a\u0002028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0017\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0005\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\"\u0010>\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR\"\u0010@\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b?\u0010\tR\"\u0010C\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\bB\u0010\tR\"\u0010G\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u0005\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR$\u0010N\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010Q\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0005\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR\"\u0010T\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR\"\u0010X\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010*\u001a\u0004\bV\u0010,\"\u0004\bW\u0010.R\"\u0010Y\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010*\u001a\u0004\b\u000f\u0010,\"\u0004\b3\u0010.R\"\u0010^\u001a\u00020Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b[\u0010\\\"\u0004\bD\u0010]R\"\u0010`\u001a\u00020Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b_\u0010\\\"\u0004\bA\u0010]R\"\u0010c\u001a\u00020Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010\u0013\u001a\u0004\bb\u0010\\\"\u0004\b%\u0010]R$\u0010f\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010*\u001a\u0004\be\u0010,\"\u0004\bU\u0010.R\u0011\u0010i\u001a\u00020g8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010hR\u0011\u0010j\u001a\u00020g8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010h\u00a8\u0006o"}, d2 = {"Lz83/a;", "", "b", "", "d", "I", "r", "()I", "N", "(I)V", "mediaType", "e", "v", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "subMediaType", "f", "G", ShortVideoConstants.PARAM_KEY_CAMERA_TYPE, h.F, UserInfo.SEX_FEMALE, "cameraSwitch", "i", "k", "J", "hasFace", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "T", "videoDuration", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "U", "width", "D", "l", "K", "height", "E", "j", "hasExposure", "", "value", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "P", "(Ljava/lang/String;)V", "path", "setId", "id", "", "H", HippyTKDListViewAdapter.X, "()J", ExifInterface.LATITUDE_SOUTH, "(J)V", "timestamp", "B", "setYear", "year", ReportConstant.COSTREPORT_PREFIX, "setMonth", "month", "setDayOfMonth", "dayOfMonth", "L", "setDayOfWeek", "dayOfWeek", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setWeek", WidgetCacheLunarData.WEEK, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "t", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "O", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "originPhoto", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setLunarMonth", "lunarMonth", "p", "setLunarDay", "lunarDay", BdhLogUtil.LogTag.Tag_Req, "getProvince", "setProvince", "province", "city", "", "o", "()F", "(F)V", "longitude", DomainData.DOMAIN_NAME, "latitude", "V", "c", "aestheticScore", "W", "w", "tempAlbumName", "", "()Z", BaseProfileQZoneComponent.KEY_IS_VIDEO, "isImage", "<init>", "()V", "X", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements Cloneable {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int width;

    /* renamed from: D, reason: from kotlin metadata */
    private int height;

    /* renamed from: E, reason: from kotlin metadata */
    private int hasExposure;

    /* renamed from: H, reason: from kotlin metadata */
    private long timestamp;

    /* renamed from: I, reason: from kotlin metadata */
    private int year;

    /* renamed from: J, reason: from kotlin metadata */
    private int month;

    /* renamed from: K, reason: from kotlin metadata */
    private int dayOfMonth;

    /* renamed from: L, reason: from kotlin metadata */
    private int dayOfWeek;

    /* renamed from: M, reason: from kotlin metadata */
    private int week;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo originPhoto;

    /* renamed from: P, reason: from kotlin metadata */
    private int lunarMonth;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lunarDay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mediaType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int subMediaType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int cameraType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int cameraSwitch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int hasFace;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int videoDuration;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String path = "";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String id = "";

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String province = "";

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String city = "";

    /* renamed from: T, reason: from kotlin metadata */
    private float longitude = -1.0f;

    /* renamed from: U, reason: from kotlin metadata */
    private float latitude = -1.0f;

    /* renamed from: V, reason: from kotlin metadata */
    private float aestheticScore = -100.0f;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private String tempAlbumName = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lz83/a$a;", "", "Landroid/database/Cursor;", "cursor", "Lz83/a;", "a", "", "CAMERA_SWITCH_BACK", "I", "CAMERA_SWITCH_FRONT", "CAMERA_SWITCH_UNKNOWN", "MEDIA_TYPE_GIF", "MEDIA_TYPE_IMAGE", "MEDIA_TYPE_UNKNOWN", "MEDIA_TYPE_VIDEO", "", "NO_AESTHETICSCORE", UserInfo.SEX_FEMALE, "NO_GPS", "SUB_MEDIA_TYPE_CAMERA", "SUB_MEDIA_TYPE_RECORD", "SUB_MEDIA_TYPE_SCREENSHOT", "SUB_MEDIA_TYPE_UNKNOWN", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z83.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final a a(@NotNull Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            a aVar = new a();
            try {
                int columnIndex = cursor.getColumnIndex("mediatype");
                if (columnIndex >= 0 && columnIndex < cursor.getColumnCount()) {
                    aVar.N(cursor.getInt(columnIndex));
                }
                int columnIndex2 = cursor.getColumnIndex("submediatype");
                if (columnIndex2 >= 0 && columnIndex2 < cursor.getColumnCount()) {
                    aVar.Q(cursor.getInt(columnIndex2));
                }
                int columnIndex3 = cursor.getColumnIndex("cameratype");
                if (columnIndex3 >= 0 && columnIndex3 < cursor.getColumnCount()) {
                    aVar.G(cursor.getInt(columnIndex2));
                }
                int columnIndex4 = cursor.getColumnIndex("cameraswitch");
                if (columnIndex4 >= 0 && columnIndex4 < cursor.getColumnCount()) {
                    aVar.F(cursor.getInt(columnIndex4));
                }
                int columnIndex5 = cursor.getColumnIndex("hasface");
                if (columnIndex5 >= 0 && columnIndex5 < cursor.getColumnCount()) {
                    aVar.J(cursor.getInt(columnIndex5));
                }
                int columnIndex6 = cursor.getColumnIndex("videoduration");
                if (columnIndex6 >= 0 && columnIndex6 < cursor.getColumnCount()) {
                    aVar.T(cursor.getInt(columnIndex6));
                }
                int columnIndex7 = cursor.getColumnIndex("width");
                if (columnIndex7 >= 0 && columnIndex7 < cursor.getColumnCount()) {
                    aVar.U(cursor.getInt(columnIndex7));
                }
                int columnIndex8 = cursor.getColumnIndex("height");
                if (columnIndex8 >= 0 && columnIndex8 < cursor.getColumnCount()) {
                    aVar.K(cursor.getInt(columnIndex8));
                }
                int columnIndex9 = cursor.getColumnIndex("hasexposure");
                if (columnIndex9 >= 0 && columnIndex9 < cursor.getColumnCount()) {
                    aVar.I(cursor.getInt(columnIndex6));
                }
                int columnIndex10 = cursor.getColumnIndex("path");
                if (columnIndex10 >= 0 && columnIndex10 < cursor.getColumnCount()) {
                    String string = cursor.getString(columnIndex10);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnPathIndex)");
                    aVar.P(string);
                }
                int columnIndex11 = cursor.getColumnIndex("timestamp");
                if (columnIndex11 >= 0 && columnIndex11 < cursor.getColumnCount()) {
                    aVar.S(cursor.getLong(columnIndex11));
                }
                int columnIndex12 = cursor.getColumnIndex("localmediainfo");
                if (columnIndex12 >= 0 && columnIndex12 < cursor.getColumnCount()) {
                    aVar.O(LocalMediaInfo.formObjectByJsonString(cursor.getString(columnIndex12)));
                }
                int columnIndex13 = cursor.getColumnIndex("aestheticscore");
                if (columnIndex13 >= 0 && columnIndex13 < cursor.getColumnCount()) {
                    aVar.E(cursor.getFloat(columnIndex13));
                }
                int columnIndex14 = cursor.getColumnIndex("city");
                if (columnIndex14 >= 0 && columnIndex14 < cursor.getColumnCount()) {
                    try {
                        String string2 = cursor.getString(columnIndex14);
                        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(columnCityIndex)");
                        aVar.H(string2);
                    } catch (Exception e16) {
                        QLog.e("WinkNewMemoryPhoto", 1, e16, new Object[0]);
                    }
                }
                int columnIndex15 = cursor.getColumnIndex("longitude");
                if (columnIndex15 >= 0 && columnIndex15 < cursor.getColumnCount()) {
                    aVar.M(cursor.getFloat(columnIndex15));
                }
                int columnIndex16 = cursor.getColumnIndex("latitude");
                if (columnIndex16 >= 0 && columnIndex16 < cursor.getColumnCount()) {
                    aVar.L(cursor.getFloat(columnIndex16));
                }
                return aVar;
            } catch (Exception e17) {
                QLog.e("WinkNewAlbumPoiProcessor", 1, e17, new Object[0]);
                return null;
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final a a(@NotNull Cursor cursor) {
        return INSTANCE.a(cursor);
    }

    /* renamed from: A, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: B, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    public final boolean C() {
        int i3 = this.mediaType;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public final boolean D() {
        if (this.mediaType == 2) {
            return true;
        }
        return false;
    }

    public final void E(float f16) {
        this.aestheticScore = f16;
    }

    public final void F(int i3) {
        this.cameraSwitch = i3;
    }

    public final void G(int i3) {
        this.cameraType = i3;
    }

    public final void H(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.city = str;
    }

    public final void I(int i3) {
        this.hasExposure = i3;
    }

    public final void J(int i3) {
        this.hasFace = i3;
    }

    public final void K(int i3) {
        this.height = i3;
    }

    public final void L(float f16) {
        this.latitude = f16;
    }

    public final void M(float f16) {
        this.longitude = f16;
    }

    public final void N(int i3) {
        this.mediaType = i3;
    }

    public final void O(@Nullable LocalMediaInfo localMediaInfo) {
        this.originPhoto = localMediaInfo;
    }

    public final void P(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.path = value;
        this.id = ak.f326673a.b(value);
    }

    public final void Q(int i3) {
        this.subMediaType = i3;
    }

    public final void R(@Nullable String str) {
        this.tempAlbumName = str;
    }

    public final void S(long j3) {
        this.timestamp = j3;
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        int i3 = 7;
        calendar.setMinimalDaysInFirstWeek(7);
        calendar.setTime(new Date(j3));
        this.year = calendar.get(1);
        this.month = calendar.get(2) + 1;
        this.dayOfMonth = calendar.get(5);
        int i16 = calendar.get(7) - 1;
        if (i16 != 0) {
            i3 = i16;
        }
        this.dayOfWeek = i3;
        this.week = calendar.get(3);
        try {
            int lunarDateINT = RFWRecommendDateUtils.getLunarDateINT(this.year, this.month, this.dayOfMonth);
            Intrinsics.checkNotNull(Integer.valueOf(lunarDateINT), "null cannot be cast to non-null type kotlin.Int");
            int i17 = (lunarDateINT % 10000) / 100;
            this.lunarMonth = i17;
            this.lunarDay = (lunarDateINT - ((lunarDateINT / 10000) * 10000)) - (i17 * 100);
        } catch (Exception e16) {
            QLog.e("WinkNewMemoryPhoto", 1, e16, "year:" + this.year + ", month:" + this.month + ", dayOfMonth:" + this.dayOfMonth);
        }
    }

    public final void T(int i3) {
        this.videoDuration = i3;
    }

    public final void U(int i3) {
        this.width = i3;
    }

    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.wink.newalbum.photo.WinkNewMemoryPhoto");
        return (a) clone;
    }

    /* renamed from: c, reason: from getter */
    public final float getAestheticScore() {
        return this.aestheticScore;
    }

    /* renamed from: d, reason: from getter */
    public final int getCameraSwitch() {
        return this.cameraSwitch;
    }

    /* renamed from: e, reason: from getter */
    public final int getCameraType() {
        return this.cameraType;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: h, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* renamed from: i, reason: from getter */
    public final int getDayOfWeek() {
        return this.dayOfWeek;
    }

    /* renamed from: j, reason: from getter */
    public final int getHasExposure() {
        return this.hasExposure;
    }

    /* renamed from: k, reason: from getter */
    public final int getHasFace() {
        return this.hasFace;
    }

    /* renamed from: l, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: n, reason: from getter */
    public final float getLatitude() {
        return this.latitude;
    }

    /* renamed from: o, reason: from getter */
    public final float getLongitude() {
        return this.longitude;
    }

    /* renamed from: p, reason: from getter */
    public final int getLunarDay() {
        return this.lunarDay;
    }

    /* renamed from: q, reason: from getter */
    public final int getLunarMonth() {
        return this.lunarMonth;
    }

    /* renamed from: r, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    /* renamed from: s, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final LocalMediaInfo getOriginPhoto() {
        return this.originPhoto;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: v, reason: from getter */
    public final int getSubMediaType() {
        return this.subMediaType;
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public final String getTempAlbumName() {
        return this.tempAlbumName;
    }

    /* renamed from: x, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: y, reason: from getter */
    public final int getVideoDuration() {
        return this.videoDuration;
    }

    /* renamed from: z, reason: from getter */
    public final int getWeek() {
        return this.week;
    }
}
