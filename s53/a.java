package s53;

import android.database.Cursor;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig;
import e93.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b>\u0010?J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0015\u0010)\"\u0004\b*\u0010+R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030-8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b'\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u00104\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0-8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b;\u00100R\u0011\u0010=\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010\f\u00a8\u0006@"}, d2 = {"Ls53/a;", "", "", "Ls53/b;", "phs", "", "a", "c", "", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "id", "j", QQWinkConstants.STORY_ID, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "coverPhotoId", "d", "Ls53/b;", "e", "()Ls53/b;", "p", "(Ls53/b;)V", "coverPhoto", "", "J", "k", "()J", "t", "(J)V", "timestamp", "l", "u", "triggerTimestamp", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", "g", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", "o", "(Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;)V", DownloadInfo.spKey_Config, "", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", "winkMemoryPhotos", "", "i", "Z", "()Z", "r", "(Z)V", "exposed", "isNewGenerated", "setNewGenerated", DomainData.DOMAIN_NAME, "winkMemoryPhotosId", "reportMediaCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String storyId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String coverPhotoId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b coverPhoto;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long triggerTimestamp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public WinkMemoryAlbumConfig config;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> winkMemoryPhotos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean exposed;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isNewGenerated;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> winkMemoryPhotosId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ls53/a$a;", "", "Landroid/database/Cursor;", "cursor", "Ls53/a;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s53.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final a a(@NotNull Cursor cursor) {
            String str;
            String str2;
            String str3;
            Long l3;
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            try {
                int columnIndex = cursor.getColumnIndex(QQWinkConstants.STORY_ID);
                if (columnIndex >= 0 && columnIndex < cursor.getColumnCount()) {
                    str = cursor.getString(columnIndex);
                } else {
                    str = null;
                }
                int columnIndex2 = cursor.getColumnIndex("id");
                if (columnIndex2 >= 0 && columnIndex2 < cursor.getColumnCount()) {
                    str2 = cursor.getString(columnIndex2);
                } else {
                    str2 = null;
                }
                int columnIndex3 = cursor.getColumnIndex("coverPhotoId");
                if (columnIndex3 >= 0 && columnIndex3 < cursor.getColumnCount()) {
                    str3 = cursor.getString(columnIndex3);
                } else {
                    str3 = null;
                }
                int columnIndex4 = cursor.getColumnIndex("timestamp");
                if (columnIndex4 >= 0 && columnIndex4 < cursor.getColumnCount()) {
                    l3 = Long.valueOf(cursor.getLong(columnIndex4));
                } else {
                    l3 = null;
                }
                if (str == null || str2 == null || str3 == null || l3 == null) {
                    return null;
                }
                a aVar = new a(str2, str);
                aVar.q(str3);
                aVar.t(l3.longValue());
                return aVar;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        Companion() {
        }
    }

    public a(@NotNull String id5, @NotNull String storyId) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        this.id = id5;
        this.storyId = storyId;
        this.coverPhotoId = "";
        this.winkMemoryPhotos = new ArrayList();
        this.isNewGenerated = true;
        this.winkMemoryPhotosId = new ArrayList();
    }

    public final void a(@NotNull List<b> phs) {
        Intrinsics.checkNotNullParameter(phs, "phs");
        this.winkMemoryPhotos.addAll(phs);
    }

    public final void b(@NotNull List<String> phs) {
        Intrinsics.checkNotNullParameter(phs, "phs");
        this.winkMemoryPhotosId.addAll(phs);
    }

    public final void c() {
        this.winkMemoryPhotos.clear();
        this.winkMemoryPhotosId.clear();
    }

    @NotNull
    public final WinkMemoryAlbumConfig d() {
        WinkMemoryAlbumConfig winkMemoryAlbumConfig = this.config;
        if (winkMemoryAlbumConfig != null) {
            return winkMemoryAlbumConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        return null;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final b getCoverPhoto() {
        return this.coverPhoto;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getCoverPhotoId() {
        return this.coverPhotoId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getExposed() {
        return this.exposed;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String i() {
        List<b> list = this.winkMemoryPhotos;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            LocalMediaInfo originPhoto = ((b) it.next()).getOriginPhoto();
            if (originPhoto != null) {
                arrayList.add(originPhoto);
            }
        }
        Iterator it5 = arrayList.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it5.hasNext()) {
            if (i.I((LocalMediaInfo) it5.next())) {
                i16++;
            } else {
                i3++;
            }
        }
        return i3 + "|" + i16;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getStoryId() {
        return this.storyId;
    }

    /* renamed from: k, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: l, reason: from getter */
    public final long getTriggerTimestamp() {
        return this.triggerTimestamp;
    }

    @NotNull
    public final List<b> m() {
        return this.winkMemoryPhotos;
    }

    @NotNull
    public final List<String> n() {
        return this.winkMemoryPhotosId;
    }

    public final void o(@NotNull WinkMemoryAlbumConfig winkMemoryAlbumConfig) {
        Intrinsics.checkNotNullParameter(winkMemoryAlbumConfig, "<set-?>");
        this.config = winkMemoryAlbumConfig;
    }

    public final void p(@Nullable b bVar) {
        this.coverPhoto = bVar;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPhotoId = str;
    }

    public final void r(boolean z16) {
        this.exposed = z16;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void t(long j3) {
        this.timestamp = j3;
    }

    public final void u(long j3) {
        this.triggerTimestamp = j3;
    }
}
