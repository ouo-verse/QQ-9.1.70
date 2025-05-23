package s00;

import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u000e\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\nH\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\nH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001d\u0010\u001a\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002J\u001e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u001cJ\u0018\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0016\u00a8\u0006+"}, d2 = {"Ls00/f;", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "", "c", "videoLengthSec", "", "fileSizeByte", "b", "", Constants.Configs.CONFIGS, TVKLiveRequestBuilder.RequestParamKey.BANDWIDTH, "bitrate", "o", "f", h.F, "i", "g", "j", "", "configStr", "d", "e", "", "hourMinute", "l", "([Ljava/lang/String;)[I", "", DomainData.DOMAIN_NAME, "k", "str", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/pubaccount/weishi/player/WSPlayerWrapper;", "player", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o1", "o2", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements Comparator<int[]> {

    /* renamed from: d, reason: collision with root package name */
    public static final f f433060d = new f();

    f() {
    }

    private final int[] b(int videoLengthSec, long fileSizeByte) {
        if (!m()) {
            x.j("WSVideoBufferController", "[computeBufferRange] not PeakPeriod!");
            return f();
        }
        long currentPrediction = c.f433052d.getCurrentPrediction();
        int i3 = (fileSizeByte <= 0 || videoLengthSec <= 0) ? 0 : (int) ((fileSizeByte / 1024) / videoLengthSec);
        int o16 = o(g(), currentPrediction, i3);
        int o17 = o(j(), currentPrediction, i3);
        x.j("WSVideoBufferController", "[computeBufferRange] emergencyTime:" + o16 + ", safePlayTime:" + o17 + ", bandwidth:" + currentPrediction + ", bitrate:" + i3);
        return new int[]{o16, o17};
    }

    private final int c() {
        if (m()) {
            return g.f433061a.k();
        }
        return g.f433061a.l();
    }

    private final List<int[]> d(String configStr) {
        ArrayList arrayList = new ArrayList();
        Object[] array = new Regex("\\|").split(configStr, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            Object[] array2 = new Regex(",").split(str, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array2;
            if (strArr.length == 2) {
                try {
                    Integer v16 = Integer.valueOf(strArr[0]);
                    Integer v26 = Integer.valueOf(strArr[1]);
                    Intrinsics.checkNotNullExpressionValue(v16, "v1");
                    Intrinsics.checkNotNullExpressionValue(v26, "v2");
                    arrayList.add(new int[]{v16.intValue(), v26.intValue()});
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        Collections.sort(arrayList, this);
        return arrayList;
    }

    private final List<List<int[]>> e(String configStr) {
        List listOf;
        x.j("WSVideoBufferController", "[decodePeakPeriodConfigStr] peekPeriod= " + configStr);
        ArrayList arrayList = new ArrayList();
        Object[] array = new Regex("\\|").split(configStr, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            Object[] array2 = new Regex(",").split(str, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array2;
            if (strArr.length == 2) {
                Object[] array3 = new Regex(":").split(strArr[0], 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Object[] array4 = new Regex(":").split(strArr[1], 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new int[][]{l((String[]) array3), l((String[]) array4)});
                arrayList.add(listOf);
            }
        }
        return arrayList;
    }

    private final int[] f() {
        int[] iArr;
        List<int[]> d16 = d(g.f433061a.e());
        if (!d16.isEmpty()) {
            iArr = d16.get(0);
        } else {
            iArr = new int[]{0, 0};
        }
        return new int[]{iArr[0], iArr[1]};
    }

    private final List<int[]> g() {
        return d(g.f433061a.h());
    }

    private final List<List<int[]>> h() {
        return e(g.f433061a.i());
    }

    private final List<List<int[]>> i() {
        return e(g.f433061a.j());
    }

    private final List<int[]> j() {
        return d(g.f433061a.p());
    }

    private final int[] l(String[] hourMinute) {
        int i3;
        int i16;
        if (hourMinute.length == 1) {
            i3 = q(hourMinute[0]);
            i16 = 0;
        } else if (hourMinute.length == 2) {
            int q16 = q(hourMinute[0]);
            i16 = q(hourMinute[1]);
            i3 = q16;
        } else {
            i3 = 0;
            i16 = 0;
        }
        return new int[]{i3, i16};
    }

    private final boolean n() {
        int k3 = k();
        x.f("WSVideoBufferController", "[isTodayWeekend] currentDay:" + k3);
        return k3 == 7 || k3 == 6;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(int[] o16, int[] o26) {
        Intrinsics.checkNotNullParameter(o16, "o1");
        Intrinsics.checkNotNullParameter(o26, "o2");
        return o26[0] - o16[0];
    }

    public final boolean m() {
        List<List<int[]>> h16;
        if (n()) {
            h16 = i();
        } else {
            h16 = h();
        }
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(11);
        int i16 = calendar.get(12);
        for (List<int[]> list : h16) {
            if (list.size() == 2) {
                int[] iArr = list.get(0);
                int[] iArr2 = list.get(1);
                int i17 = iArr[0];
                if ((i3 > i17 && i3 < iArr2[0]) || ((i3 == i17 && i16 >= iArr[1]) || (i3 == iArr2[0] && i16 < iArr2[1]))) {
                    x.f("WSVideoBufferController", "[isPeakPeriod] true!");
                    return true;
                }
            }
        }
        x.j("WSVideoBufferController", "[isPeakPeriod] false!");
        return false;
    }

    public final void p(WSPlayerWrapper player, int videoLengthSec, long fileSizeByte) {
        Intrinsics.checkNotNullParameter(player, "player");
        int[] b16 = b(videoLengthSec, fileSizeByte);
        int i3 = b16[0];
        int i16 = b16[1];
        int c16 = c();
        x.j("WSVideoBufferController", "[setupVideoBufferStrategy] emergencyTime:" + i3 + ", safePlayTime:" + i16 + ", fileSizeByte:" + fileSizeByte + ", videoLengthSec:" + videoLengthSec + ", preloadDuration:" + c16);
        player.z0(i3, i16, c16);
    }

    private final int k() {
        Integer[] numArr = {7, 1, 2, 3, 4, 5, 6};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i3 = calendar.get(7) - 1;
        return numArr[i3 >= 0 ? i3 : 0].intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int q(String str) {
        boolean z16;
        boolean isBlank;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return 0;
                }
                try {
                    Integer valueOf = Integer.valueOf(str);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(str)");
                    return valueOf.intValue();
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    return 0;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final int o(List<int[]> configs, long bandwidth, int bitrate) {
        if (bandwidth > 0 && bitrate > 0) {
            for (int[] iArr : configs) {
                if (iArr.length == 2 && bandwidth > iArr[0] * bitrate) {
                    return iArr[1];
                }
            }
        }
        if (!(!configs.isEmpty())) {
            return 0;
        }
        int[] iArr2 = configs.get(configs.size() - 1);
        if (iArr2[0] <= 0) {
            return iArr2[1];
        }
        return 0;
    }
}
