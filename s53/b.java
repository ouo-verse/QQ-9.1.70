package s53;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.utils.ak;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 G2\u00020\u0001:\u0001\u0002B\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0002\u001a\u00020\u0000H\u0016R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u001b\u0010\tR\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u001e\u0010\tR\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\"\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b$\u0010\u0012R*\u0010,\u001a\u00020&2\u0006\u0010\f\u001a\u00020&8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u001d\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007\"\u0004\b'\u0010\tR\"\u00103\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\"\u00107\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\"\u0010:\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0005\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\"\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0005\u001a\u0004\b;\u0010\u0007\"\u0004\b \u0010\tR$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Ls53/b;", "", "a", "", "d", "I", "i", "()I", HippyTKDListViewAdapter.X, "(I)V", "mediaType", "", "value", "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "path", "f", "o", "D", "width", h.F, "w", "height", "u", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "haveFace", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "isDeleted", "setId", "id", "", "E", "J", "()J", "B", "(J)V", "timestamp", UserInfo.SEX_FEMALE, "p", "year", "G", "j", "y", "month", "H", "b", "r", "dayOfMonth", "c", ReportConstant.COSTREPORT_PREFIX, "dayOfWeek", DomainData.DOMAIN_NAME, WidgetCacheLunarData.WEEK, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "K", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "k", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "originPhoto", "<init>", "()V", "L", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements Cloneable {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private long timestamp;

    /* renamed from: F, reason: from kotlin metadata */
    private int year;

    /* renamed from: G, reason: from kotlin metadata */
    private int month;

    /* renamed from: H, reason: from kotlin metadata */
    private int dayOfMonth;

    /* renamed from: I, reason: from kotlin metadata */
    private int dayOfWeek;

    /* renamed from: J, reason: from kotlin metadata */
    private int week;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo originPhoto;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int duration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int haveFace;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mediaType = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String path = "";

    /* renamed from: C, reason: from kotlin metadata */
    private int isDeleted = 1;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String id = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ls53/b$a;", "", "Landroid/database/Cursor;", "cursor", "Ls53/b;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s53.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final b a(@NotNull Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            b bVar = new b();
            try {
                int columnIndex = cursor.getColumnIndex("mediatype");
                if (columnIndex >= 0 && columnIndex < cursor.getColumnCount()) {
                    bVar.x(cursor.getInt(columnIndex));
                }
                int columnIndex2 = cursor.getColumnIndex("year");
                if (columnIndex2 >= 0 && columnIndex2 < cursor.getColumnCount()) {
                    bVar.E(cursor.getInt(columnIndex2));
                }
                int columnIndex3 = cursor.getColumnIndex("month");
                if (columnIndex3 >= 0 && columnIndex3 < cursor.getColumnCount()) {
                    bVar.y(cursor.getInt(columnIndex3));
                }
                int columnIndex4 = cursor.getColumnIndex("dayofmonth");
                if (columnIndex4 >= 0 && columnIndex4 < cursor.getColumnCount()) {
                    bVar.r(cursor.getInt(columnIndex4));
                }
                int columnIndex5 = cursor.getColumnIndex("dayofweek");
                if (columnIndex5 >= 0 && columnIndex5 < cursor.getColumnCount()) {
                    bVar.s(cursor.getInt(columnIndex5));
                }
                int columnIndex6 = cursor.getColumnIndex(WidgetCacheLunarData.WEEK);
                if (columnIndex6 >= 0 && columnIndex6 < cursor.getColumnCount()) {
                    bVar.C(cursor.getInt(columnIndex6));
                }
                int columnIndex7 = cursor.getColumnIndex("path");
                if (columnIndex7 >= 0 && columnIndex7 < cursor.getColumnCount()) {
                    String string = cursor.getString(columnIndex7);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnPhotoPathIndex)");
                    bVar.A(string);
                }
                int columnIndex8 = cursor.getColumnIndex("timestamp");
                if (columnIndex8 >= 0 && columnIndex8 < cursor.getColumnCount()) {
                    bVar.B(cursor.getLong(columnIndex8));
                }
                int columnIndex9 = cursor.getColumnIndex("haveface");
                if (columnIndex9 >= 0 && columnIndex9 < cursor.getColumnCount()) {
                    bVar.v(cursor.getInt(columnIndex9));
                }
                int columnIndex10 = cursor.getColumnIndex("isdeleted");
                if (columnIndex10 >= 0 && columnIndex10 < cursor.getColumnCount()) {
                    bVar.t(cursor.getInt(columnIndex10));
                }
                int columnIndex11 = cursor.getColumnIndex("width");
                if (columnIndex11 >= 0 && columnIndex11 < cursor.getColumnCount()) {
                    bVar.D(cursor.getInt(columnIndex11));
                }
                int columnIndex12 = cursor.getColumnIndex("height");
                if (columnIndex12 >= 0 && columnIndex12 < cursor.getColumnCount()) {
                    bVar.w(cursor.getInt(columnIndex12));
                }
                int columnIndex13 = cursor.getColumnIndex("duration");
                if (columnIndex13 >= 0 && columnIndex13 < cursor.getColumnCount()) {
                    bVar.u(cursor.getInt(columnIndex13));
                }
                return bVar;
            } catch (Exception unused) {
                return null;
            }
        }

        Companion() {
        }
    }

    public final void A(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.path = value;
        this.id = ak.f326673a.b(value);
    }

    public final void B(long j3) {
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
    }

    public final void C(int i3) {
        this.week = i3;
    }

    public final void D(int i3) {
        this.width = i3;
    }

    public final void E(int i3) {
        this.year = i3;
    }

    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.wink.db.memoryalbumdb.bean.WinkMemoryPhoto");
        return (b) clone;
    }

    /* renamed from: b, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* renamed from: c, reason: from getter */
    public final int getDayOfWeek() {
        return this.dayOfWeek;
    }

    /* renamed from: d, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: e, reason: from getter */
    public final int getHaveFace() {
        return this.haveFace;
    }

    /* renamed from: f, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: i, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    /* renamed from: j, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final LocalMediaInfo getOriginPhoto() {
        return this.originPhoto;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: m, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: n, reason: from getter */
    public final int getWeek() {
        return this.week;
    }

    /* renamed from: o, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: p, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* renamed from: q, reason: from getter */
    public final int getIsDeleted() {
        return this.isDeleted;
    }

    public final void r(int i3) {
        this.dayOfMonth = i3;
    }

    public final void s(int i3) {
        this.dayOfWeek = i3;
    }

    public final void t(int i3) {
        this.isDeleted = i3;
    }

    public final void u(int i3) {
        this.duration = i3;
    }

    public final void v(int i3) {
        this.haveFace = i3;
    }

    public final void w(int i3) {
        this.height = i3;
    }

    public final void x(int i3) {
        this.mediaType = i3;
    }

    public final void y(int i3) {
        this.month = i3;
    }

    public final void z(@Nullable LocalMediaInfo localMediaInfo) {
        this.originPhoto = localMediaInfo;
    }
}
