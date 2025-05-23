package r94;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonObject;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.sort.CombineOrderFilterData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import qu4.m;
import qu4.q;
import tl.h;
import uv4.ag;
import uv4.ah;
import uv4.al;
import uv4.am;
import uv4.aq;
import uv4.ay;
import uv4.az;
import uv4.ba;
import uv4.bb;
import uv4.be;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0004*\u00020\t\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\b\u0012\u0004\u0012\u00020\t0\u000b\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000e*\b\u0012\u0004\u0012\u00020\t0\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00000\u000e2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e\u001a\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e*\u00020\u0000\u001a\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e*\u00020\u0000\u001a \u0010\u0015\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00000\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u001a\u001a\u0010\u0016\u001a\u00020\u0002*\u00020\u00002\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u001a&\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0018\u001a\u001a\u0010\u001a\u001a\u00020\u0002*\u00020\u00002\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u001a\n\u0010\u001b\u001a\u00020\u0004*\u00020\u0000\u001a\u0018\u0010\u001d\u001a\u00020\u0002*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u001a\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\f*\u00020\u0000\u001a\n\u0010 \u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010!\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\"\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010#\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010$\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010%\u001a\u00020\u0002*\u00020\u0000\u001a\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\f*\u00020\u0000\u001a\n\u0010'\u001a\u00020\u0002*\u00020\u0000\u001a\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\b\u0012\u0004\u0012\u00020\u00000\u000b\u001a\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\f*\b\u0012\u0004\u0012\u00020\u00000\u000b\u001a\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e*\b\u0012\u0004\u0012\u00020\u00000\u000b\u001a\u0010\u0010+\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00000\u000e\u001a\u0010\u0010,\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00000\u000e\u001a\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\b\u0012\u0004\u0012\u00020\u00000\f\u001a\u0010\u0010/\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020.0\u000e\u001a\u0012\u00101\u001a\u00020\u0004*\n\u0012\u0004\u0012\u000200\u0018\u00010\u000e\u001a\u001b\u00104\u001a\u00020\u0002*\u0002022\b\u00103\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b4\u00105\u001a,\u0010:\u001a\u000209*\u0002062\u0006\u00107\u001a\u0002022\u0018\b\u0002\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0017j\b\u0012\u0004\u0012\u00020\u001e`\u0018\u001a#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0=*\b\u0012\u0004\u0012\u00020<0;\u00a2\u0006\u0004\b?\u0010@\u001a\n\u0010A\u001a\u00020>*\u00020<\u001a\f\u0010D\u001a\u0004\u0018\u00010C*\u00020B\u001a\f\u0010E\u001a\u0004\u0018\u000102*\u00020B\u001a\n\u0010G\u001a\u00020\u001e*\u00020F\u001a\n\u0010I\u001a\u00020\u001e*\u00020H\u001a\n\u0010J\u001a\u00020\u001e*\u00020C\u001a\n\u0010K\u001a\u00020\u001e*\u00020\u0000\u00a8\u0006L"}, d2 = {"Luv4/az;", "other", "", "b", "", "a", "K", "Lcom/google/gson/JsonObject;", "J", "Luv4/bk;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "", "u", "", "alreadyHasIdPool", "c", "E", "g", "f", "dressIdList", "v", HippyTKDListViewAdapter.X, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "w", "L", "I", "itemUniqueIdList", "N", "", "k", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "G", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "y", h.F, DomainData.DOMAIN_NAME, "r", "j", "p", "i", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/a;", "t", "Luv4/ah;", "H", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "dstGender", "B", "(Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;Ljava/lang/Integer;)Z", "Luv4/al;", "gender", "slotRecorder", "Lm94/a;", "O", "", "Luv4/am;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "P", "([Luv4/am;)Ljava/util/Map;", "e", "Ldw4/b;", "Lqu4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "Luv4/aq;", "l", "Luv4/ay;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "M", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {
    public static final boolean A(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return azVar.f440292s == 3;
    }

    public static final boolean B(UEAvatarGender uEAvatarGender, Integer num) {
        Intrinsics.checkNotNullParameter(uEAvatarGender, "<this>");
        if (uEAvatarGender == UEAvatarGender.MALE && num != null && num.intValue() == 2) {
            return true;
        }
        return uEAvatarGender == UEAvatarGender.FEMALE && num != null && num.intValue() == 1;
    }

    public static final boolean C(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return azVar.f440292s == 2;
    }

    public static final boolean D(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return azVar.f440292s == 4;
    }

    public static final boolean E(List<az> list, List<az> other) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (list.isEmpty() && other.isEmpty()) {
            return true;
        }
        return Intrinsics.areEqual(p(list), p(other));
    }

    public static final boolean F(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return azVar.f440292s == 5;
    }

    public static final boolean G(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return A(azVar) || D(azVar);
    }

    public static final String I(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        String jSONObject = c.I(azVar).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toSimpleJson().toString()");
        return jSONObject;
    }

    public static final JsonObject J(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("item_id", String.valueOf(azVar.f440275b));
        jsonObject.addProperty("taojian_id", String.valueOf(azVar.G));
        Map<String, String> extInfo = azVar.H;
        if (extInfo != null) {
            Intrinsics.checkNotNullExpressionValue(extInfo, "extInfo");
            for (Map.Entry<String, String> entry : extInfo.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    jsonObject.addProperty(entry.getKey(), entry.getValue());
                }
            }
        }
        return jsonObject;
    }

    public static final String K(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        long j3 = azVar.f440276c;
        if (j3 != 0) {
            return String.valueOf(j3);
        }
        return String.valueOf(azVar.f440275b);
    }

    public static final boolean L(az azVar, List<String> list) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (list == null) {
            return false;
        }
        Iterator<T> it = g(azVar).iterator();
        while (it.hasNext()) {
            if (list.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final int M(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        be beVar = azVar.f440290q;
        if (beVar == null) {
            return -1;
        }
        return beVar.f440324a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean N(az azVar, List<String> itemUniqueIdList) {
        boolean z16;
        az azVar2;
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        Intrinsics.checkNotNullParameter(itemUniqueIdList, "itemUniqueIdList");
        az[] containStoreItems = azVar.f440289p;
        if (containStoreItems != null) {
            if (!(containStoreItems.length == 0)) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                Intrinsics.checkNotNullExpressionValue(containStoreItems, "containStoreItems");
                int length = containStoreItems.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        azVar2 = null;
                        break;
                    }
                    azVar2 = containStoreItems[i3];
                    if (itemUniqueIdList.contains(azVar2.B)) {
                        break;
                    }
                    i3++;
                }
                return azVar2 != null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static final Map<CameraKey, am> P(am[] amVarArr) {
        Intrinsics.checkNotNullParameter(amVarArr, "<this>");
        HashMap hashMap = new HashMap();
        for (am amVar : amVarArr) {
            hashMap.put(e(amVar), amVar);
        }
        return hashMap;
    }

    public static final String Q(bk bkVar) {
        Intrinsics.checkNotNullParameter(bkVar, "<this>");
        int i3 = bkVar.f440365a;
        az azVar = bkVar.f440366b;
        String a16 = azVar != null ? a(azVar) : null;
        ag agVar = bkVar.f440367c;
        Integer valueOf = agVar != null ? Integer.valueOf(agVar.f440130a) : null;
        ag agVar2 = bkVar.f440367c;
        return "itemType:" + i3 + ",item:" + a16 + ",outfit:" + valueOf + "_" + (agVar2 != null ? agVar2.f440131b : null);
    }

    public static final String a(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        String uniqueId = azVar.B;
        Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
        return uniqueId;
    }

    public static final boolean b(az azVar, az azVar2) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (azVar2 == null) {
            return false;
        }
        return Intrinsics.areEqual(azVar.B, azVar2.B);
    }

    public static final List<bk> c(List<bk> list, Set<String> alreadyHasIdPool) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(alreadyHasIdPool, "alreadyHasIdPool");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet(alreadyHasIdPool);
        for (bk bkVar : list) {
            if (!hashSet.contains(Q(bkVar))) {
                arrayList.add(bkVar);
                hashSet.add(Q(bkVar));
            }
        }
        return arrayList;
    }

    public static final int d(qu4.a aVar) {
        q[] qVarArr;
        q qVar;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        m mVar = aVar.f429574c;
        if (mVar == null || (qVarArr = mVar.f429621b) == null) {
            return 0;
        }
        int length = qVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                qVar = null;
                break;
            }
            qVar = qVarArr[i3];
            if (qVar.f429639a == 116) {
                break;
            }
            i3++;
        }
        if (qVar != null) {
            return qVar.f429640b;
        }
        return 0;
    }

    public static final CameraKey e(am amVar) {
        Intrinsics.checkNotNullParameter(amVar, "<this>");
        return new CameraKey(amVar.f440157a, amVar.f440169m);
    }

    public static final List<String> f(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(azVar));
        az[] azVarArr = azVar.f440289p;
        if (azVarArr != null) {
            for (az item : azVarArr) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                arrayList.addAll(f(item));
            }
        }
        return arrayList;
    }

    public static final List<String> g(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add(azVar.B);
        az[] azVarArr = azVar.f440289p;
        if (azVarArr != null) {
            for (az item : azVarArr) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                arrayList.addAll(g(item));
            }
        }
        return arrayList;
    }

    public static final Set<String> h(Collection<az> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(f((az) it.next()));
        }
        return hashSet;
    }

    public static final Set<String> i(Set<az> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            hashSet.addAll(f((az) it.next()));
        }
        return hashSet;
    }

    public static final String j(List<az> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(a(list.get(i3)));
            if (i3 != list.size() - 1) {
                sb5.append("|");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    public static final Set<Integer> k(az azVar) {
        List emptyList;
        List list;
        int[] iArr;
        List list2;
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        bb bbVar = azVar.f440291r;
        if (bbVar == null || (iArr = bbVar.f440311b) == null || (list2 = ArraysKt.toList(iArr)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            list = new ArrayList();
            for (Object obj : list2) {
                if (((Number) obj).intValue() != 0) {
                    list.add(obj);
                }
            }
        }
        return new HashSet(list);
    }

    public static final int l(aq aqVar) {
        Intrinsics.checkNotNullParameter(aqVar, "<this>");
        int i3 = aqVar.f440213i;
        return i3 != 0 ? i3 : aqVar.f440206b == 1 ? 2 : 1;
    }

    public static final int m(ay ayVar) {
        Intrinsics.checkNotNullParameter(ayVar, "<this>");
        int i3 = ayVar.f440273i;
        return i3 != 0 ? i3 : ayVar.f440266b == 1 ? 2 : 1;
    }

    public static final Set<Integer> n(Collection<az> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(o((az) it.next()));
        }
        return hashSet;
    }

    public static final Set<Integer> o(az azVar) {
        Set<Integer> emptySet;
        int[] iArr;
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        be beVar = azVar.f440290q;
        if (beVar != null && (iArr = beVar.f440326c) != null && (set = ArraysKt.toSet(iArr)) != null) {
            return set;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final String p(List<az> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(K(list.get(i3)));
            if (i3 != list.size() - 1) {
                sb5.append("|");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    public static final qu4.a q(dw4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i3 = bVar.f395116c;
        if (i3 == UEAvatarGender.MALE.getIndex()) {
            return bVar.f395117d;
        }
        if (i3 == UEAvatarGender.FEMALE.getIndex()) {
            return bVar.f395118e;
        }
        return null;
    }

    public static final List<String> r(Collection<az> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a((az) it.next()));
        }
        return arrayList;
    }

    public static final UEAvatarGender s(dw4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i3 = bVar.f395116c;
        UEAvatarGender uEAvatarGender = UEAvatarGender.MALE;
        if (i3 == uEAvatarGender.getIndex()) {
            return uEAvatarGender;
        }
        UEAvatarGender uEAvatarGender2 = UEAvatarGender.FEMALE;
        if (i3 == uEAvatarGender2.getIndex()) {
            return uEAvatarGender2;
        }
        return null;
    }

    public static final String t(List<CombineOrderFilterData> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (CombineOrderFilterData combineOrderFilterData : list) {
            sb5.append(combineOrderFilterData.getValue().f440138a + ContainerUtils.KEY_VALUE_DELIMITER + combineOrderFilterData.getValue().f440139b);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public static final Set<String> u(Collection<bk> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.add(Q((bk) it.next()));
        }
        return hashSet;
    }

    public static final boolean v(List<az> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!x((az) it.next(), list2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean w(az azVar, HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (hashSet == null) {
            return false;
        }
        Iterator<T> it = g(azVar).iterator();
        while (it.hasNext()) {
            if (!hashSet.contains((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean x(az azVar, List<String> list) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (list == null) {
            return false;
        }
        Iterator<T> it = g(azVar).iterator();
        while (it.hasNext()) {
            if (!list.contains((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean y(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        ba baVar = azVar.f440288o;
        if (baVar != null) {
            return baVar.f440306g;
        }
        return false;
    }

    public static final boolean z(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return azVar.f440292s == 1;
    }

    public static final String H(List<ah> list) {
        if (list == null) {
            return "{null}";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        for (ah ahVar : list) {
            sb5.append(ahVar.f440138a + ContainerUtils.KEY_VALUE_DELIMITER + ahVar.f440139b + ",");
        }
        sb5.append("}");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "strBuilder.toString()");
        return sb6;
    }

    public static final m94.a O(al alVar, UEAvatarGender gender, HashSet<Integer> hashSet) {
        HashSet<Integer> slotRecorder = hashSet;
        Intrinsics.checkNotNullParameter(alVar, "<this>");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(slotRecorder, "slotRecorder");
        az[] dressList = alVar.f440153b;
        qu4.a aVar = alVar.f440152a;
        if (aVar == null) {
            aVar = new qu4.a();
        }
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNullExpressionValue(dressList, "dressList");
        int length = dressList.length;
        int i3 = 0;
        while (i3 < length) {
            az item = dressList[i3];
            be beVar = item.f440290q;
            if ((beVar != null ? beVar.f440325b : null) != null) {
                int[] iArr = beVar.f440325b;
                Intrinsics.checkNotNullExpressionValue(iArr, "item.slot.occupancySlots");
                slotRecorder.addAll(ArraysKt.toList(iArr));
                int[] iArr2 = item.f440290q.f440325b;
                Intrinsics.checkNotNullExpressionValue(iArr2, "item.slot.occupancySlots");
                for (int i16 : iArr2) {
                    if (hashMap.containsKey(Integer.valueOf(i16))) {
                        az azVar = (az) hashMap.get(Integer.valueOf(i16));
                        String a16 = azVar != null ? a(azVar) : null;
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        QLog.e("StoreAvatarInfo", 1, "toAvatarDressInfo dressList repeat slot " + i16 + ".idA:" + a16 + ", idB: " + a(item));
                    }
                    Integer valueOf = Integer.valueOf(i16);
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    hashMap.put(valueOf, item);
                }
            }
            i3++;
            slotRecorder = hashSet;
        }
        return new m94.a(gender, hashMap, aVar);
    }
}
