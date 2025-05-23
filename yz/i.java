package yz;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ0\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\rJ\u0006\u0010\u0014\u001a\u00020\u0004R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010)R$\u0010\n\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010/R\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010/\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lyz/i;", "", "Lyz/b;", "fetcher", "", DomainData.DOMAIN_NAME, "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "startIndex", "k", "T", "Lyz/a;", TransactionActivity.PREF_NAME_TRANSFER, "Ljz/c;", "listener", "", "e", "d", "c", "Lyz/d;", "b", "Lyz/d;", "f", "()Lyz/d;", "floatWindowTransfer", "Lyz/e;", "Lyz/e;", "g", "()Lyz/e;", "floatWindowVerticalTransfer", "Lyz/b;", "dataFetcher", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", tl.h.F, "()Lcom/tencent/biz/pubaccount/weishi/player/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/biz/pubaccount/weishi/player/e;)V", "playingParam", "Ljava/util/List;", "dataList", "<set-?>", "I", "i", "()I", "Z", "isRequesting", "j", "()Z", "l", "(Z)V", "isFloatingWindowShowing", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static b dataFetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.biz.pubaccount.weishi.player.e playingParam;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int startIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isRequesting;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isFloatingWindowShowing;

    /* renamed from: a, reason: collision with root package name */
    public static final i f451583a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final d floatWindowTransfer = new d();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final e floatWindowVerticalTransfer = new e();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static List<j> dataList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"yz/i$a", "Ljz/e;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "isRefresh", "isFirst", "", "extObject", "", "b", "", "errorCode", "", "errorMsg", "i", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements jz.e<List<j>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.c<T> f451592a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ yz.a<j, T> f451593b;

        a(jz.c<T> cVar, yz.a<j, T> aVar) {
            this.f451592a = cVar;
            this.f451593b = aVar;
        }

        @Override // jz.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<j> data, boolean isRefresh, boolean isFirst, Object extObject) {
            Intrinsics.checkNotNullParameter(data, "data");
            i.dataList.addAll(data);
            i.isRequesting = false;
            jz.c<T> cVar = this.f451592a;
            if (cVar != 0) {
                cVar.d0(this.f451593b.a(data), isRefresh, isFirst, extObject);
            }
        }

        @Override // jz.e
        public void i(int errorCode, String errorMsg, boolean isFirst, boolean isRefresh) {
            i.isRequesting = false;
            jz.c<T> cVar = this.f451592a;
            if (cVar != 0) {
                cVar.i(errorCode, errorMsg, isFirst, isRefresh);
            }
        }
    }

    i() {
    }

    public final void c() {
        dataList.clear();
        playingParam = null;
    }

    public final <T> List<T> d(yz.a<j, T> transfer) {
        Intrinsics.checkNotNullParameter(transfer, "transfer");
        return transfer.a(dataList);
    }

    public final <T> boolean e(yz.a<j, T> transfer, jz.c<T> listener) {
        Intrinsics.checkNotNullParameter(transfer, "transfer");
        isRequesting = true;
        b bVar = dataFetcher;
        if (bVar != null) {
            return bVar.a(new a(listener, transfer));
        }
        return false;
    }

    public final d f() {
        return floatWindowTransfer;
    }

    public final e g() {
        return floatWindowVerticalTransfer;
    }

    public final com.tencent.biz.pubaccount.weishi.player.e h() {
        return playingParam;
    }

    public final int i() {
        return startIndex;
    }

    public final boolean j() {
        return isFloatingWindowShowing;
    }

    public final void k(List<j> data, int startIndex2) {
        Intrinsics.checkNotNullParameter(data, "data");
        x.j("nel-log", "startIndex:" + startIndex2 + " in WSVideoFloatingDataManager");
        List<j> list = dataList;
        list.clear();
        list.addAll(data);
        startIndex = startIndex2;
    }

    public final void l(boolean z16) {
        isFloatingWindowShowing = z16;
    }

    public final void m(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        playingParam = eVar;
    }

    public final void n(b fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        dataFetcher = fetcher;
    }
}
