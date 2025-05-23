package zf3;

import android.view.View;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerItemContent;
import com.tencent.mobileqq.zplan.utils.aa;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import pu4.g;
import pv4.p;
import pv4.q;
import pv4.s;
import pv4.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\rBq\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0010&\u001a\u00020\u0017\u0012\u0006\u0010+\u001a\u00020'\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001c\u0012\u0006\u0010/\u001a\u00020'\u0012\u0006\u00101\u001a\u00020'\u0012\u0006\u00104\u001a\u00020\t\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0013\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010&\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u0017\u0010+\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b,\u0010 R\u0017\u0010/\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b.\u0010*R\u0017\u00101\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b0\u0010*R\u0017\u00104\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u00102\u001a\u0004\b\"\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0013\u00a8\u00068"}, d2 = {"Lzf3/e;", "", "", "c", "", "o", "p", "obj", "equals", "", "toString", "hashCode", "Lpv4/s;", "a", "Lpv4/s;", "k", "()Lpv4/s;", "originData", "b", "I", "d", "()I", "id", "Lpu4/g;", "Lpu4/g;", "j", "()Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "Lpv4/p;", "Ljava/util/List;", h.F, "()Ljava/util/List;", "leftTopLabels", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rightTopLabels", "f", "leftBottomIcon", "Lpv4/u;", "g", "Lpv4/u;", "()Lpv4/u;", "leftBottomTxt", "l", "rightBottomLabels", "i", "mainDesc", DomainData.DOMAIN_NAME, QQWinkConstants.TAB_SUBTITLE, "Ljava/lang/String;", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "measureHeight", "<init>", "(Lpv4/s;ILpu4/g;Ljava/util/List;Ljava/util/List;Lpu4/g;Lpv4/u;Ljava/util/List;Lpv4/u;Lpv4/u;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zf3.e, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class StaggerItemData {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name */
    private static WeakReference<TextView> f452450n;

    /* renamed from: o, reason: collision with root package name */
    private static WeakReference<TextView> f452451o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final s originData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final g material;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<p> leftTopLabels;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<p> rightTopLabels;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final g leftBottomIcon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final u leftBottomTxt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<u> rightBottomLabels;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final u mainDesc;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final u subTitle;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final String jumpUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int measureHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lzf3/e$a;", "", "", "defaultJumpUrl", "Lzf3/e;", "c", "", "Lpv4/s;", "detailList", "b", "detail", "a", "", "EMPTY_ID", "I", "TAG", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "Landroid/widget/TextView;", "descTxvCache", "Lmqq/util/WeakReference;", "titleTxvCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zf3.e$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
        
            r1 = kotlin.collections.ArraysKt___ArraysKt.toList(r1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final StaggerItemData a(s detail) {
            ArrayList arrayList;
            ArrayList arrayList2;
            List arrayList3;
            Intrinsics.checkNotNullParameter(detail, "detail");
            int i3 = detail.f427690k;
            g gVar = detail.f427681b;
            if (gVar == null) {
                gVar = new g();
            }
            g gVar2 = gVar;
            p[] pVarArr = detail.f427685f;
            if (pVarArr == null) {
                arrayList = new ArrayList();
            } else {
                Intrinsics.checkNotNullExpressionValue(pVarArr, "detail.labels");
                ArrayList arrayList4 = new ArrayList();
                for (p pVar : pVarArr) {
                    if (pVar.f427652b == 0) {
                        arrayList4.add(pVar);
                    }
                }
                arrayList = arrayList4;
            }
            p[] pVarArr2 = detail.f427685f;
            if (pVarArr2 == null) {
                arrayList2 = new ArrayList();
            } else {
                Intrinsics.checkNotNullExpressionValue(pVarArr2, "detail.labels");
                arrayList2 = new ArrayList();
                for (p pVar2 : pVarArr2) {
                    if (pVar2.f427652b == 1) {
                        arrayList2.add(pVar2);
                    }
                }
            }
            ArrayList arrayList5 = arrayList2;
            q qVar = detail.f427687h;
            g gVar3 = qVar != null ? qVar.f427653a : null;
            if (gVar3 == null) {
                gVar3 = new g();
            }
            g gVar4 = gVar3;
            q qVar2 = detail.f427687h;
            u uVar = qVar2 != null ? qVar2.f427655c : null;
            u uVar2 = uVar == null ? new u() : uVar;
            u[] uVarArr = detail.f427689j;
            if (uVarArr == null || arrayList3 == null) {
                arrayList3 = new ArrayList();
            }
            List list = arrayList3;
            u uVar3 = detail.f427680a;
            if (uVar3 == null) {
                uVar3 = new u();
            }
            u uVar4 = uVar3;
            u uVar5 = detail.f427683d;
            if (uVar5 == null) {
                uVar5 = new u();
            }
            u uVar6 = uVar5;
            String str = detail.f427682c;
            if (str == null) {
                str = "";
            }
            return new StaggerItemData(detail, i3, gVar2, arrayList, arrayList5, gVar4, uVar2, list, uVar4, uVar6, str);
        }

        public final List<StaggerItemData> b(List<s> detailList) {
            Intrinsics.checkNotNullParameter(detailList, "detailList");
            ArrayList arrayList = new ArrayList(detailList.size());
            if (detailList.isEmpty()) {
                return arrayList;
            }
            StaggerItemContent.Companion companion = StaggerItemContent.INSTANCE;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextView a16 = companion.a(context);
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            TextView b16 = companion.b(context2);
            StaggerItemData.f452450n = new WeakReference(a16);
            StaggerItemData.f452451o = new WeakReference(b16);
            int size = detailList.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(a(detailList.get(i3)));
            }
            QLog.i("StaggerItemData_", 1, "descTxv:" + a16 + ", titleTxv:" + b16);
            return arrayList;
        }

        public final StaggerItemData c(String defaultJumpUrl) {
            Intrinsics.checkNotNullParameter(defaultJumpUrl, "defaultJumpUrl");
            return new StaggerItemData(new s(), -1, new g(), new ArrayList(), new ArrayList(), new g(), new u(), new ArrayList(), new u(), new u(), defaultJumpUrl);
        }

        Companion() {
        }
    }

    public StaggerItemData(s originData, int i3, g material, List<p> leftTopLabels, List<p> rightTopLabels, g leftBottomIcon, u leftBottomTxt, List<u> rightBottomLabels, u mainDesc, u subTitle, String jumpUrl) {
        Intrinsics.checkNotNullParameter(originData, "originData");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(leftTopLabels, "leftTopLabels");
        Intrinsics.checkNotNullParameter(rightTopLabels, "rightTopLabels");
        Intrinsics.checkNotNullParameter(leftBottomIcon, "leftBottomIcon");
        Intrinsics.checkNotNullParameter(leftBottomTxt, "leftBottomTxt");
        Intrinsics.checkNotNullParameter(rightBottomLabels, "rightBottomLabels");
        Intrinsics.checkNotNullParameter(mainDesc, "mainDesc");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.originData = originData;
        this.id = i3;
        this.material = material;
        this.leftTopLabels = leftTopLabels;
        this.rightTopLabels = rightTopLabels;
        this.leftBottomIcon = leftBottomIcon;
        this.leftBottomTxt = leftBottomTxt;
        this.rightBottomLabels = rightBottomLabels;
        this.mainDesc = mainDesc;
        this.subTitle = subTitle;
        this.jumpUrl = jumpUrl;
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d7, code lost:
    
        if ((r8 == null || r8.length() == 0) != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int c() {
        TextView a16;
        TextView b16;
        aa a17 = aa.b().a();
        WeakReference<TextView> weakReference = f452450n;
        if (weakReference == null || (a16 = weakReference.get()) == null) {
            StaggerItemContent.Companion companion = StaggerItemContent.INSTANCE;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a16 = companion.a(context);
        }
        Intrinsics.checkNotNullExpressionValue(a16, "descTxvCache?.get() ?: S\u2026(BaseApplication.context)");
        WeakReference<TextView> weakReference2 = f452451o;
        if (weakReference2 == null || (b16 = weakReference2.get()) == null) {
            StaggerItemContent.Companion companion2 = StaggerItemContent.INSTANCE;
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            b16 = companion2.b(context2);
        }
        Intrinsics.checkNotNullExpressionValue(b16, "titleTxvCache?.get() ?: \u2026(BaseApplication.context)");
        a16.setText(this.mainDesc.f427702a);
        b16.setText(this.subTitle.f427702a);
        a17.d("doInitMeasure-build-txv");
        d dVar = d.f452428a;
        int i3 = 0;
        a16.measure(View.MeasureSpec.makeMeasureSpec(dVar.m(), 1073741824), 0);
        int measuredHeight = a16.getMeasuredHeight();
        b16.measure(View.MeasureSpec.makeMeasureSpec(dVar.m(), 1073741824), 0);
        int measuredHeight2 = b16.getMeasuredHeight();
        a17.d("doInitMeasure-txv-measure");
        String str = this.mainDesc.f427702a;
        int a18 = str == null || str.length() == 0 ? 0 : dVar.a() + measuredHeight;
        String str2 = this.subTitle.f427702a;
        int p16 = str2 == null || str2.length() == 0 ? 0 : dVar.p() + measuredHeight2;
        String str3 = this.mainDesc.f427702a;
        if (str3 == null || str3.length() == 0) {
            String str4 = this.subTitle.f427702a;
        }
        i3 = dVar.o();
        int f16 = dVar.f() + a18 + p16 + i3;
        this.measureHeight = f16;
        QLog.i("StaggerItemData_", 1, "measureHeight descHeight:" + measuredHeight + ", descAreaHeight:" + a18 + "titleHeight:" + measuredHeight2 + ", titleAreaHeight:" + p16 + ",mainDesc.title:" + this.mainDesc.f427702a + ", subTitle.title:" + this.subTitle.f427702a + ",measureHeight:" + f16);
        a17.d("doInitMeasure-end");
        return this.measureHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public boolean equals(Object obj) {
        StaggerItemData staggerItemData = obj instanceof StaggerItemData ? (StaggerItemData) obj : null;
        return staggerItemData != null && this.id == staggerItemData.id && o.d(this.material, staggerItemData.material) && o.h(this.leftTopLabels, staggerItemData.leftTopLabels) && o.d(this.leftBottomIcon, staggerItemData.leftBottomIcon) && o.g(this.leftBottomTxt, staggerItemData.leftBottomTxt) && o.i(this.rightBottomLabels, staggerItemData.rightBottomLabels) && o.g(this.mainDesc, staggerItemData.mainDesc) && o.g(this.subTitle, staggerItemData.subTitle) && Intrinsics.areEqual(this.jumpUrl, staggerItemData.jumpUrl);
    }

    /* renamed from: f, reason: from getter */
    public final g getLeftBottomIcon() {
        return this.leftBottomIcon;
    }

    /* renamed from: g, reason: from getter */
    public final u getLeftBottomTxt() {
        return this.leftBottomTxt;
    }

    public final List<p> h() {
        return this.leftTopLabels;
    }

    public int hashCode() {
        return (((((((((((((((((((this.originData.hashCode() * 31) + this.id) * 31) + this.material.hashCode()) * 31) + this.leftTopLabels.hashCode()) * 31) + this.rightTopLabels.hashCode()) * 31) + this.leftBottomIcon.hashCode()) * 31) + this.leftBottomTxt.hashCode()) * 31) + this.rightBottomLabels.hashCode()) * 31) + this.mainDesc.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final u getMainDesc() {
        return this.mainDesc;
    }

    /* renamed from: j, reason: from getter */
    public final g getMaterial() {
        return this.material;
    }

    /* renamed from: k, reason: from getter */
    public final s getOriginData() {
        return this.originData;
    }

    public final List<u> l() {
        return this.rightBottomLabels;
    }

    public final List<p> m() {
        return this.rightTopLabels;
    }

    /* renamed from: n, reason: from getter */
    public final u getSubTitle() {
        return this.subTitle;
    }

    public final boolean o() {
        return this.id == -1;
    }

    /* renamed from: p, reason: from getter */
    public final int getMeasureHeight() {
        return this.measureHeight;
    }

    public String toString() {
        return "StaggerItemData(originData=" + this.originData + ", id=" + this.id + ", material=" + this.material + ", leftTopLabels=" + this.leftTopLabels + ", rightTopLabels=" + this.rightTopLabels + ", leftBottomIcon=" + this.leftBottomIcon + ", leftBottomTxt=" + this.leftBottomTxt + ", rightBottomLabels=" + this.rightBottomLabels + ", mainDesc=" + this.mainDesc + ", subTitle=" + this.subTitle + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
