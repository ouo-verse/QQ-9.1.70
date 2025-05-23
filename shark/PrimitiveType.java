package shark;

import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lshark/PrimitiveType;", "", "", "hprofType", "I", "getHprofType", "()I", "byteSize", "getByteSize", "<init>", "(Ljava/lang/String;III)V", "Companion", "a", AlbumSocialInfoCacheData.TYPE_ALBUM_IS_LIKED, "CHAR", "FLOAT", "DOUBLE", "BYTE", "SHORT", "INT", "LONG", "shark-hprof"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public enum PrimitiveType {
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);

    public static final int REFERENCE_HPROF_TYPE = 2;

    @NotNull
    private static final Map<Integer, Integer> byteSizeByHprofType;

    @NotNull
    private static final Map<Integer, PrimitiveType> primitiveTypeByHprofType;
    private final int byteSize;
    private final int hprofType;

    static {
        Map<Integer, Integer> map;
        Map<Integer, PrimitiveType> map2;
        PrimitiveType[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (PrimitiveType primitiveType : values) {
            arrayList.add(TuplesKt.to(Integer.valueOf(primitiveType.hprofType), Integer.valueOf(primitiveType.byteSize)));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        byteSizeByHprofType = map;
        PrimitiveType[] values2 = values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (PrimitiveType primitiveType2 : values2) {
            arrayList2.add(TuplesKt.to(Integer.valueOf(primitiveType2.hprofType), primitiveType2));
        }
        map2 = MapsKt__MapsKt.toMap(arrayList2);
        primitiveTypeByHprofType = map2;
    }

    PrimitiveType(int i3, int i16) {
        this.hprofType = i3;
        this.byteSize = i16;
    }

    public final int getByteSize() {
        return this.byteSize;
    }

    public final int getHprofType() {
        return this.hprofType;
    }
}
