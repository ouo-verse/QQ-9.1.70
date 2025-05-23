package u03;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J:\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lu03/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "", "url", "filePath", "Lkotlin/Function2;", "", "", "loadCallback", "a", "", "bid", "scid", "b", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements com.tencent.cachedrawable.dynamicdrawable.business.download.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"u03/c$b", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f438029a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f438030b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super String, Unit> function2, String str) {
            this.f438029a = function2;
            this.f438030b = str;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m result) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m result) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            this.f438029a.invoke(Integer.valueOf(result.a()), this.f438030b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function2 loadCallback, String filePath) {
        Intrinsics.checkNotNullParameter(loadCallback, "$loadCallback");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        loadCallback.invoke(0, filePath);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.download.c
    public void a(@NotNull String url, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback) {
        boolean contains$default;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        b.a T = new b.a("dynamic_drawable", url, new File(filePath)).T(new b(loadCallback, filePath));
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "dynamic_download_avif=true", false, 2, (Object) null);
        if (contains$default) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Accept", "image/avif, image/jpeg, image/png, */*"));
            T.a(mapOf);
        }
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(T.c());
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.download.c
    public void b(long bid, @NotNull String scid, @NotNull final String filePath, @NotNull final Function2<? super Integer, ? super String, Unit> loadCallback) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(bid);
        business.addDownLoadListener(scid, new Runnable() { // from class: u03.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(Function2.this, filePath);
            }
        });
        business.startDownload(scid);
    }
}
