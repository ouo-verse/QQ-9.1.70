package r94;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import qu4.d;
import qu4.g;
import qu4.i;
import qu4.j;
import qu4.k;
import qu4.l;
import qu4.m;
import qu4.p;
import qu4.q;
import qu4.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\b\u001a\u00020\u0002*\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\n\u001a\u00020\u0002*\u0004\u0018\u00010\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\t\u001a\u0016\u0010\f\u001a\u00020\u0002*\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u000b\u001a\u0016\u0010\u000e\u001a\u00020\u0002*\u0004\u0018\u00010\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\r\u001a\u0016\u0010\u000f\u001a\u00020\u0002*\u0004\u0018\u00010\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u0005\u001a)\u0010\u0011\u001a\u00020\u0002*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u0004\u0018\u00010\u00132\b\u0010\u0001\u001a\u0004\u0018\u00010\u0013\u001a\u0016\u0010\u0016\u001a\u00020\u0002*\u0004\u0018\u00010\u00152\b\u0010\u0001\u001a\u0004\u0018\u00010\u0015\u001a\u0016\u0010\u0018\u001a\u00020\u0002*\u0004\u0018\u00010\u00172\b\u0010\u0001\u001a\u0004\u0018\u00010\u0017\u001a)\u0010\u0019\u001a\u00020\u0002*\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00102\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u0016\u0010\u001c\u001a\u00020\u0002*\u0004\u0018\u00010\u001b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u001b\u001a)\u0010\u001d\u001a\u00020\u0002*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00102\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u0016\u0010 \u001a\u00020\u0002*\u0004\u0018\u00010\u001f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u001f\u001a\u0016\u0010\"\u001a\u00020\u0002*\u0004\u0018\u00010!2\b\u0010\u0001\u001a\u0004\u0018\u00010!\u001a%\u0010#\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020!0\u00102\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u0010\u00a2\u0006\u0004\b#\u0010$\u001a\u0016\u0010&\u001a\u00020\u0002*\u0004\u0018\u00010%2\b\u0010\u0001\u001a\u0004\u0018\u00010%\u001a)\u0010(\u001a\u00020\u0002*\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00102\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0010\u00a2\u0006\u0004\b(\u0010)\u001a)\u0010+\u001a\u00020\u0002*\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00102\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0010\u00a2\u0006\u0004\b+\u0010,\u00a8\u0006-"}, d2 = {"Lqu4/a;", "other", "", "c", "a", "Lqu4/d;", "b", "Lqu4/b;", "d", "Lqu4/j;", "i", "Lqu4/m;", "l", "Lqu4/c;", "e", "f", "", "r", "([Lqu4/d;[Lqu4/d;)Z", "Lqu4/l;", "k", "Lqu4/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqu4/k;", "j", "t", "([Lqu4/k;[Lqu4/k;)Z", "Lqu4/q;", DomainData.DOMAIN_NAME, "u", "([Lqu4/q;[Lqu4/q;)Z", "Lqu4/g;", "g", "Lqu4/i;", h.F, ReportConstant.COSTREPORT_PREFIX, "([Lqu4/i;[Lqu4/i;)Z", "Lqu4/r;", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "([Ljava/lang/String;[Ljava/lang/String;)Z", "", "p", "([Ljava/lang/Integer;[Ljava/lang/Integer;)Z", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final boolean b(d dVar, d dVar2) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.f429584b != 1) {
            return false;
        }
        if (dVar2 == null) {
            return true;
        }
        return !k(dVar.f429586d, dVar2.f429586d);
    }

    public static final boolean s(i[] iVarArr, i[] other) {
        i iVar;
        Intrinsics.checkNotNullParameter(iVarArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (iVarArr.length != other.length) {
            return false;
        }
        int length = iVarArr.length;
        int i3 = 0;
        while (true) {
            i iVar2 = null;
            if (i3 >= length) {
                for (i iVar3 : other) {
                    int length2 = iVarArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            iVar = null;
                            break;
                        }
                        iVar = iVarArr[i16];
                        if (iVar3.f429601a == iVar.f429601a) {
                            break;
                        }
                        i16++;
                    }
                    if (iVar == null || !h(iVar3, iVar)) {
                        return false;
                    }
                }
                return true;
            }
            i iVar4 = iVarArr[i3];
            int length3 = other.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                i iVar5 = other[i17];
                if (iVar4.f429601a == iVar5.f429601a) {
                    iVar2 = iVar5;
                    break;
                }
                i17++;
            }
            if (iVar2 == null || !h(iVar4, iVar2)) {
                return false;
            }
            i3++;
        }
    }

    public static final boolean a(qu4.a aVar, qu4.a aVar2) {
        d dVar;
        d dVar2;
        if (aVar == null) {
            return aVar2 != null;
        }
        if (aVar2 == null) {
            return true;
        }
        qu4.c cVar = aVar.f429575d;
        d[] dVarArr = cVar != null ? cVar.f429581b : null;
        if (dVarArr == null) {
            return false;
        }
        qu4.c cVar2 = aVar2.f429575d;
        d[] dVarArr2 = cVar2 != null ? cVar2.f429581b : null;
        if (dVarArr2 == null) {
            return false;
        }
        for (d item : dVarArr) {
            int length = dVarArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    dVar2 = null;
                    break;
                }
                dVar2 = dVarArr2[i3];
                if (item.f429583a == dVar2.f429583a) {
                    break;
                }
                i3++;
            }
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (b(item, dVar2)) {
                return true;
            }
        }
        boolean enableCompareSaveAvatarGradientColor = ZPlanQQMC.INSTANCE.enableCompareSaveAvatarGradientColor();
        QLog.i("AvatarDataCompareEx", 1, "enableCompareSaveAvatarGradientColor=" + enableCompareSaveAvatarGradientColor);
        if (enableCompareSaveAvatarGradientColor) {
            for (d item2 : dVarArr2) {
                int length2 = dVarArr.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length2) {
                        dVar = null;
                        break;
                    }
                    dVar = dVarArr[i16];
                    if (item2.f429583a == dVar.f429583a) {
                        break;
                    }
                    i16++;
                }
                Intrinsics.checkNotNullExpressionValue(item2, "item");
                if (b(item2, dVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean c(qu4.a aVar, qu4.a aVar2) {
        if (aVar == null) {
            return aVar2 == null;
        }
        if (aVar2 == null) {
            return false;
        }
        return aVar.f429576e == aVar2.f429576e && d(aVar.f429572a, aVar2.f429572a) && l(aVar.f429574c, aVar2.f429574c) && e(aVar.f429575d, aVar2.f429575d) && i(aVar.f429573b, aVar2.f429573b);
    }

    public static final boolean d(qu4.b bVar, qu4.b bVar2) {
        if (bVar == null) {
            return bVar2 == null;
        }
        if (bVar2 == null) {
            return false;
        }
        return bVar.f429577a == bVar2.f429577a && u(bVar.f429578b, bVar2.f429578b);
    }

    public static final boolean e(qu4.c cVar, qu4.c cVar2) {
        if (cVar == null) {
            return cVar2 == null;
        }
        if (cVar2 == null) {
            return false;
        }
        return cVar.f429580a == cVar2.f429580a && r(cVar.f429581b, cVar2.f429581b);
    }

    public static final boolean f(d dVar, d dVar2) {
        if (dVar == null) {
            return dVar2 == null;
        }
        if (dVar2 == null) {
            return false;
        }
        return dVar.f429583a == dVar2.f429583a && dVar.f429584b == dVar2.f429584b && m(dVar.f429585c, dVar2.f429585c) && k(dVar.f429586d, dVar2.f429586d);
    }

    public static final boolean g(g gVar, g gVar2) {
        if (gVar == null) {
            return gVar2 == null;
        }
        if (gVar2 == null) {
            return false;
        }
        if (gVar.f429593a == gVar2.f429593a && gVar.f429594b == gVar2.f429594b) {
            i[] controlPoints = gVar.f429595c;
            Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
            i[] iVarArr = gVar2.f429595c;
            Intrinsics.checkNotNullExpressionValue(iVarArr, "other.controlPoints");
            if (s(controlPoints, iVarArr) && gVar.f429596d == gVar2.f429596d) {
                return true;
            }
        }
        return false;
    }

    public static final boolean h(i iVar, i iVar2) {
        if (iVar == null) {
            return iVar2 == null;
        }
        if (iVar2 == null) {
            return false;
        }
        return iVar.f429601a == iVar2.f429601a && iVar.f429602b == iVar2.f429602b && iVar.f429603c == iVar2.f429603c && iVar.f429604d == iVar2.f429604d && iVar.f429605e == iVar2.f429605e;
    }

    public static final boolean i(j jVar, j jVar2) {
        if (jVar == null) {
            return jVar2 == null;
        }
        if (jVar2 == null) {
            return false;
        }
        return jVar.f429606a == jVar2.f429606a && t(jVar.f429607b, jVar2.f429607b);
    }

    public static final boolean j(k kVar, k kVar2) {
        if (kVar == null) {
            return kVar2 == null;
        }
        if (kVar2 == null) {
            return false;
        }
        if (kVar.f429609a == kVar2.f429609a) {
            i[] controlPoints = kVar.f429612d;
            Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
            i[] iVarArr = kVar2.f429612d;
            Intrinsics.checkNotNullExpressionValue(iVarArr, "other.controlPoints");
            if (s(controlPoints, iVarArr)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean k(l lVar, l lVar2) {
        if (lVar == null) {
            return lVar2 == null;
        }
        if (lVar2 == null) {
            return false;
        }
        if (lVar.f429614a == lVar2.f429614a && m(lVar.f429615b, lVar2.f429615b) && m(lVar.f429616c, lVar2.f429616c)) {
            if (lVar.f429617d == lVar2.f429617d) {
                if (lVar.f429618e == lVar2.f429618e) {
                    if (lVar.f429619f == lVar2.f429619f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean l(m mVar, m mVar2) {
        if (mVar == null) {
            return mVar2 == null;
        }
        if (mVar2 == null) {
            return false;
        }
        return mVar.f429620a == mVar2.f429620a && u(mVar.f429621b, mVar2.f429621b);
    }

    public static final boolean m(p pVar, p pVar2) {
        if (pVar == null) {
            return pVar2 == null;
        }
        if (pVar2 == null) {
            return false;
        }
        return pVar.f429636a == pVar2.f429636a && pVar.f429637b == pVar2.f429637b;
    }

    public static final boolean n(q qVar, q qVar2) {
        if (qVar == null) {
            return qVar2 == null;
        }
        if (qVar2 == null) {
            return false;
        }
        return qVar.f429639a == qVar2.f429639a && qVar.f429640b == qVar2.f429640b && qVar.f429641c == qVar2.f429641c && g(qVar.f429642d, qVar2.f429642d) && o(qVar.f429643e, qVar2.f429643e);
    }

    public static final boolean o(r rVar, r rVar2) {
        Integer[] typedArray;
        Integer[] typedArray2;
        Integer[] typedArray3;
        Integer[] typedArray4;
        if (rVar == null) {
            return rVar2 == null;
        }
        if (rVar2 == null) {
            return false;
        }
        if (Intrinsics.areEqual(rVar.f429644a, rVar2.f429644a) && Intrinsics.areEqual(rVar.f429645b, rVar2.f429645b) && q(rVar.f429646c, rVar2.f429646c) && q(rVar.f429647d, rVar2.f429647d) && Intrinsics.areEqual(rVar.f429648e, rVar2.f429648e) && Intrinsics.areEqual(rVar.f429650g, rVar2.f429650g)) {
            if ((rVar.f429651h == rVar2.f429651h) && rVar.f429652i == rVar2.f429652i && Intrinsics.areEqual(rVar.f429653j, rVar2.f429653j) && Intrinsics.areEqual(rVar.f429654k, rVar2.f429654k) && Intrinsics.areEqual(rVar.f429655l, rVar2.f429655l)) {
                int[] offsetScale = rVar.f429656m;
                Intrinsics.checkNotNullExpressionValue(offsetScale, "offsetScale");
                typedArray = ArraysKt___ArraysJvmKt.toTypedArray(offsetScale);
                int[] iArr = rVar2.f429656m;
                Intrinsics.checkNotNullExpressionValue(iArr, "other.offsetScale");
                typedArray2 = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
                if (p(typedArray, typedArray2) && Intrinsics.areEqual(rVar.f429657n, rVar2.f429657n)) {
                    int[] containAvatars = rVar.f429658o;
                    Intrinsics.checkNotNullExpressionValue(containAvatars, "containAvatars");
                    typedArray3 = ArraysKt___ArraysJvmKt.toTypedArray(containAvatars);
                    int[] iArr2 = rVar2.f429658o;
                    Intrinsics.checkNotNullExpressionValue(iArr2, "other.containAvatars");
                    typedArray4 = ArraysKt___ArraysJvmKt.toTypedArray(iArr2);
                    if (p(typedArray3, typedArray4) && rVar.f429659p == rVar2.f429659p && q(rVar.f429660q, rVar2.f429660q) && q(rVar.f429661r, rVar2.f429661r) && q(rVar.f429662s, rVar2.f429662s) && q(rVar.f429663t, rVar2.f429663t) && Intrinsics.areEqual(rVar.f429664u, rVar2.f429664u) && Intrinsics.areEqual(rVar.f429665v, rVar2.f429665v) && Intrinsics.areEqual(rVar.C, rVar2.C) && Intrinsics.areEqual(rVar.D, rVar2.D) && Intrinsics.areEqual(rVar.E, rVar2.E) && Intrinsics.areEqual(rVar.F, rVar2.F)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean p(Integer[] numArr, Integer[] numArr2) {
        Integer num;
        if (numArr == null) {
            return numArr2 == null;
        }
        if (numArr2 == null || numArr.length != numArr2.length) {
            return false;
        }
        int length = numArr.length;
        int i3 = 0;
        while (true) {
            Integer num2 = null;
            if (i3 >= length) {
                for (Integer num3 : numArr2) {
                    int intValue = num3.intValue();
                    int length2 = numArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            num = null;
                            break;
                        }
                        num = numArr[i16];
                        if (intValue == num.intValue()) {
                            break;
                        }
                        i16++;
                    }
                    if (num == null) {
                        return false;
                    }
                    num.intValue();
                }
                return true;
            }
            int intValue2 = numArr[i3].intValue();
            int length3 = numArr2.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                Integer num4 = numArr2[i17];
                if (intValue2 == num4.intValue()) {
                    num2 = num4;
                    break;
                }
                i17++;
            }
            if (num2 == null) {
                return false;
            }
            num2.intValue();
            i3++;
        }
    }

    public static final boolean q(String[] strArr, String[] strArr2) {
        String str;
        if (strArr == null) {
            return strArr2 == null;
        }
        if (strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            String str2 = null;
            if (i3 >= length) {
                for (String str3 : strArr2) {
                    int length2 = strArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            str = null;
                            break;
                        }
                        str = strArr[i16];
                        if (Intrinsics.areEqual(str3, str)) {
                            break;
                        }
                        i16++;
                    }
                    if (str == null) {
                        return false;
                    }
                }
                return true;
            }
            String str4 = strArr[i3];
            int length3 = strArr2.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                String str5 = strArr2[i17];
                if (Intrinsics.areEqual(str4, str5)) {
                    str2 = str5;
                    break;
                }
                i17++;
            }
            if (str2 == null) {
                return false;
            }
            i3++;
        }
    }

    public static final boolean r(d[] dVarArr, d[] dVarArr2) {
        d dVar;
        if (dVarArr == null) {
            return dVarArr2 == null;
        }
        if (dVarArr2 == null || dVarArr.length != dVarArr2.length) {
            return false;
        }
        int length = dVarArr.length;
        int i3 = 0;
        while (true) {
            d dVar2 = null;
            if (i3 >= length) {
                for (d dVar3 : dVarArr2) {
                    int length2 = dVarArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            dVar = null;
                            break;
                        }
                        dVar = dVarArr[i16];
                        if (dVar3.f429583a == dVar.f429583a) {
                            break;
                        }
                        i16++;
                    }
                    if (dVar == null || !f(dVar3, dVar)) {
                        return false;
                    }
                }
                return true;
            }
            d dVar4 = dVarArr[i3];
            int length3 = dVarArr2.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                d dVar5 = dVarArr2[i17];
                if (dVar4.f429583a == dVar5.f429583a) {
                    dVar2 = dVar5;
                    break;
                }
                i17++;
            }
            if (dVar2 == null || !f(dVar4, dVar2)) {
                return false;
            }
            i3++;
        }
    }

    public static final boolean t(k[] kVarArr, k[] kVarArr2) {
        k kVar;
        if (kVarArr == null) {
            return kVarArr2 == null;
        }
        if (kVarArr2 == null || kVarArr.length != kVarArr2.length) {
            return false;
        }
        int length = kVarArr.length;
        int i3 = 0;
        while (true) {
            k kVar2 = null;
            if (i3 >= length) {
                for (k kVar3 : kVarArr2) {
                    int length2 = kVarArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            kVar = null;
                            break;
                        }
                        kVar = kVarArr[i16];
                        if (kVar3.f429609a == kVar.f429609a) {
                            break;
                        }
                        i16++;
                    }
                    if (kVar == null || !j(kVar3, kVar)) {
                        return false;
                    }
                }
                return true;
            }
            k kVar4 = kVarArr[i3];
            int length3 = kVarArr2.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                k kVar5 = kVarArr2[i17];
                if (kVar4.f429609a == kVar5.f429609a) {
                    kVar2 = kVar5;
                    break;
                }
                i17++;
            }
            if (kVar2 == null || !j(kVar4, kVar2)) {
                return false;
            }
            i3++;
        }
    }

    public static final boolean u(q[] qVarArr, q[] qVarArr2) {
        q qVar;
        if (qVarArr == null) {
            return qVarArr2 == null;
        }
        if (qVarArr2 == null) {
            return false;
        }
        int length = qVarArr.length;
        int i3 = 0;
        while (true) {
            q qVar2 = null;
            if (i3 >= length) {
                for (q qVar3 : qVarArr2) {
                    int length2 = qVarArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            qVar = null;
                            break;
                        }
                        qVar = qVarArr[i16];
                        if (qVar3.f429639a == qVar.f429639a) {
                            break;
                        }
                        i16++;
                    }
                    if (qVar == null || !n(qVar3, qVar)) {
                        return false;
                    }
                }
                return true;
            }
            q qVar4 = qVarArr[i3];
            int length3 = qVarArr2.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    break;
                }
                q qVar5 = qVarArr2[i17];
                if (qVar4.f429639a == qVar5.f429639a) {
                    qVar2 = qVar5;
                    break;
                }
                i17++;
            }
            if (qVar2 == null || !n(qVar4, qVar2)) {
                return false;
            }
            i3++;
        }
    }
}
